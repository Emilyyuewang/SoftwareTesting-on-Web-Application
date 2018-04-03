package edu.umd.fcmd.guice.application;

public class WebApplication {
	private WebServer server;

	public void run() {
		System.out.println("starting web application...");
		
		// create guice injector and server here
//		Injector injector = ???;
//		server = ???;

		server.run();
		
		System.out.println("web application finished.");
	}

	public static void main(String[] args) {
		WebApplication app = new WebApplication();

		app.run();
	}
}
