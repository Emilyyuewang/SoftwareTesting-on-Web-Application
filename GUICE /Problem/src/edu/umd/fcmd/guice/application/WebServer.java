package edu.umd.fcmd.guice.application;

import edu.umd.fcmd.guice.interfaces.Frontend;
import edu.umd.fcmd.guice.interfaces.Middleware;
import edu.umd.fcmd.guice.interfaces.Persistance;
import com.google.inject.Inject;

public class WebServer {
	private final Frontend frontend;
	private final Middleware middleware;
	private final Persistance persistance;

	@Inject
	public WebServer(Frontend frontend, Middleware middleware, Persistance persistance) {
		this.frontend = frontend;
		this.middleware = middleware;
		this.persistance = persistance;
	}
	
	public String getType() {
		return "WebServer";
	}

	public boolean run() {
		System.out.println("running " + this.getType());
		
		// invoke services here if applicable
		frontend.run();
		middleware.run();
		persistance.run();
		
		return true;
	}
}
