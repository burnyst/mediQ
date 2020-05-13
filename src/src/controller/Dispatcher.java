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
	private Map<String, Controller> map = new HashMap<>();
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
                Controller controller = (Controller)Class.forName(className).newInstance();
                map.put(request, controller);
            } catch (ClassNotFoundException|InstantiationException|IllegalAccessException e) {
                throw new ServletException(e);
            }
        }
	}
	private Controller getController(HttpServletRequest req) {
		Controller rst = null;
		String uri = req.getRequestURI();
		if (uri != null && uri.indexOf(req.getContextPath()) == 0) {
			uri = uri.substring(req.getContextPath().length());
			rst = map.get(uri);
		}
        return rst;
	}
	private void forward(HttpServletRequest req, HttpServletResponse resp, String page) throws ServletException, IOException {
		if (page != null) {
	        RequestDispatcher dispatcher = req.getRequestDispatcher(page);
	        dispatcher.forward(req, resp);
        }
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Controller controller = getController(req);
        if (controller == null) {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        
        String viewPage = null;
        try {
            viewPage = controller.doGet(req, resp);
        } catch (Throwable e) {
            throw new ServletException(e);
        }
        
        forward(req, resp, viewPage);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Controller controller = getController(req);
        if (controller == null) {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        
        String viewPage = null;
        try {
            viewPage = controller.doPost(req, resp);
        } catch (Throwable e) {
            throw new ServletException(e);
        }
        
        forward(req, resp, viewPage);
	}
}
