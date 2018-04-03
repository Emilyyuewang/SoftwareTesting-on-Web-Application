package edu.umd.fcmd.guice.application;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class WebApplication {
	private WebServer server;

	public void run() {
		System.out.println("starting web application...");
		
		// create guice injector and server here
		//Injector injector = Guice.createInjector(new StandardModule());
		Injector injector= Guice.createInjector(new LoggedModule());
		server = injector.getInstance(WebServer.class);
		//server = injector1.getInstance(WebServer.class);

		server.run();
		
		System.out.println("web application finished.");
	}

	public static void main(String[] args) {
		WebApplication app = new WebApplication();

		app.run();
	}
}