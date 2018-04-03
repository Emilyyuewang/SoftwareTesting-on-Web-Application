package edu.umd.cs.csfalcon.web.toyapp;

import java.io.IOException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class ToyWebAppServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/plain");
		resp.getWriter().println("Hello, world");
	}
}
