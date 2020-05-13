package dbcp;

import java.io.IOException;
import java.io.StringReader;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.commons.dbcp2.DriverManagerConnectionFactory;
import org.apache.commons.dbcp2.PoolableConnection;
import org.apache.commons.dbcp2.PoolableConnectionFactory;
import org.apache.commons.dbcp2.PoolingDriver;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

public class DbcpListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
	}
	
	private void loadJdbcDriver(Properties config) {
		try {
			Class.forName(config.getProperty("jdbcDriver"));
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("fail to load JDBC Driver", e);
		}
	}
	private PoolableConnectionFactory getConnectionFactory(Properties config) {
		PoolableConnectionFactory rst = null;
		String uri = config.getProperty("jdbcUrl");
		String name = config.getProperty("dbUser");
		String pw = config.getProperty("dbPass");
		String validQuery = config.getProperty("validationQuery");
		rst = new PoolableConnectionFactory(
				new DriverManagerConnectionFactory(uri, name, pw), null);
		if (validQuery != null && !validQuery.isEmpty()) {
			rst.setValidationQuery(validQuery);
		}
		return rst;
	}
	private GenericObjectPoolConfig<PoolableConnection> getPoolableConfig(Properties config) {
		GenericObjectPoolConfig<PoolableConnection> rst = null;
		rst = new GenericObjectPoolConfig<>();
		rst.setTimeBetweenEvictionRunsMillis(1000L * 60L * 5L);
		rst.setTestWhileIdle(true);
		int minIdle = getIntProperty(config, "minIdle", 5);
		rst.setMinIdle(minIdle);
		int maxTotal = getIntProperty(config, "maxTotal", 50);
		rst.setMaxTotal(maxTotal);
		return rst;
	}
	private void registerPool(Properties config,
			GenericObjectPool<PoolableConnection> pool) throws ClassNotFoundException, SQLException {
		try {
			Class.forName("org.apache.commons.dbcp2.PoolingDriver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("fail to load PoolingDriver", e);
		}
		PoolingDriver driver = (PoolingDriver)DriverManager.getDriver("jdbc:apache:commons:dbcp:");
		driver.registerPool(config.getProperty("poolName"), pool);
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		Properties poolConfig = new Properties();
		try {
			poolConfig.load(new StringReader(sce.getServletContext().getInitParameter("poolConfig")));
		} catch (IOException e) {
			throw new RuntimeException("config load fail", e);
		}

		loadJdbcDriver(poolConfig);
		
		try {
			PoolableConnectionFactory conFactory = getConnectionFactory(poolConfig);
			GenericObjectPoolConfig<PoolableConnection> poolableConfig = getPoolableConfig(poolConfig);
			GenericObjectPool<PoolableConnection> pool = 
					new GenericObjectPool<>(conFactory, poolableConfig);
			conFactory.setPool(pool);
			registerPool(poolConfig, pool);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	private int getIntProperty(Properties properties, String name, int defValue) {
		int rst = defValue;
		String value = properties.getProperty(name);
		try {
			rst = Integer.parseInt(value);
		} catch (NumberFormatException e) {
		}
		return rst;
	}

}
