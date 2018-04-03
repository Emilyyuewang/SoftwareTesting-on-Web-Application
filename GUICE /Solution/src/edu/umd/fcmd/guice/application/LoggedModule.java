package edu.umd.fcmd.guice.application;
import com.google.inject.AbstractModule;
import com.google.inject.matcher.Matchers;

/*import edu.umd.fcmd.guice.interfaces.Authentication;
import edu.umd.fcmd.guice.interfaces.Connection;
import edu.umd.fcmd.guice.interfaces.FileSystem;
import edu.umd.fcmd.guice.interfaces.Frontend;
import edu.umd.fcmd.guice.interfaces.Middleware;
import edu.umd.fcmd.guice.interfaces.Persistance;
import edu.umd.fcmd.guice.services.AuthenticationSSL;
import edu.umd.fcmd.guice.services.ConnectionJDBC;
import edu.umd.fcmd.guice.services.FileSystemNFS;

import edu.umd.fcmd.guice.services.FrontendHTML;
import edu.umd.fcmd.guice.services.MiddlewareTomcat;
import edu.umd.fcmd.guice.services.PersistanceMySQL;*/
import edu.umd.fcmd.guice.interfaces.*;
import edu.umd.fcmd.guice.services.*;

public class LoggedModule extends AbstractModule{

	protected void configure(){
	bind(Frontend.class).to(FrontendHTML.class);
	bind(Middleware.class).to(MiddlewareTomcat.class);
	bind(Persistance.class).to(PersistanceMySQL.class);

	bind(Authentication.class).to(AuthenticationSSL.class);
	bind(Connection.class).to(ConnectionJDBC.class);
	bind(FileSystem.class).to(FileSystemNFS.class);
	bindInterceptor(Matchers.identicalTo(FrontendHTML.class),Matchers.any(),new LoggingInterceptor());
	bindInterceptor(Matchers.identicalTo(MiddlewareTomcat.class),Matchers.any(),new LoggingInterceptor());
	bindInterceptor(Matchers.identicalTo(PersistanceMySQL.class),Matchers.any(),new LoggingInterceptor());
	}
}
