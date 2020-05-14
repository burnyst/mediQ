package controller;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Dispatcher extends HttpServlet {
	private static final long serialVersionUID = -5460502380405758539L;
	private Map<String, Object> map = new HashMap<>();
	@Override
	public void init() throws ServletException {
		Properties properties = new Properties();
		String fileName = getServletContext().getRealPath(getInitParameter("configFile"));
		try (FileReader fis = new FileReader(fileName)) {
			properties.load(fis);
        } catch (IOException e) {
            throw new ServletException(e);
        }
		Iterator<Object> iter = properties.keySet().iterator();
        while (iter.hasNext()) {
            String request = (String)iter.next();
            String className = properties.getProperty(request);
            try {
                map.put(request, Class.forName(className).newInstance());
            } catch (ClassNotFoundException|InstantiationException|IllegalAccessException e) {
                throw new ServletException(e);
            }
        }
	}
	private Object getController(HttpServletRequest req) {
		Object rst = null;
		String uri = req.getRequestURI();
		if (uri != null && uri.indexOf(req.getContextPath()) == 0) {
			uri = uri.substring(req.getContextPath().length());
			rst = map.get(uri);
		}
        return rst;
	}
	private void forward(HttpServletRequest req, HttpServletResponse res, String page) throws ServletException, IOException {
		if (page != null) {
	        RequestDispatcher dispatcher = req.getRequestDispatcher(page);
	        dispatcher.forward(req, res);
        }
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Object controller = getController(req);
        if (controller == null) {
            res.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        
        String viewPage = null;
        try {
        	if (controller instanceof Controller) {
        		viewPage = ((Controller)controller).doGet(req, res);
        	} else {
        		viewPage = ((CommandHandler)controller).process(req, res);
        	}
        } catch (Throwable e) {
            throw new ServletException(e);
        }
        
        forward(req, res, viewPage);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Object controller = getController(req);
        if (controller == null) {
            res.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        
        String viewPage = null;
        try {
        	if (controller instanceof Controller) {
        		viewPage = ((Controller)controller).doPost(req, res);
        	} else {
        		viewPage = ((CommandHandler)controller).process(req, res);
        	}
        } catch (Throwable e) {
            throw new ServletException(e);
        }
        
        forward(req, res, viewPage);
	}
}
