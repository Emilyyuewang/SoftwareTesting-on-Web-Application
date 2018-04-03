package edu.umd.fcmd.guice.application;

/*import edu.umd.fcmd.guice.interfaces.Authentication;
import edu.umd.fcmd.guice.interfaces.Connection;
import edu.umd.fcmd.guice.interfaces.FileSystem;
import edu.umd.fcmd.guice.interfaces.Frontend;
import edu.umd.fcmd.guice.interfaces.Middleware;
import edu.umd.fcmd.guice.interfaces.Persistance;

import edu.umd.fcmd.guice.services.FrontendGWT;
import edu.umd.fcmd.guice.services.FrontendHTML;
import edu.umd.fcmd.guice.services.MiddlewareJBoss;
import edu.umd.fcmd.guice.services.MiddlewareTomcat;
import edu.umd.fcmd.guice.services.PersistanceMySQL;
import edu.umd.fcmd.guice.services.PersistanceOracle;
import edu.umd.fcmd.guice.services.AuthenticationSSL;
import edu.umd.fcmd.guice.services.AuthenticationTSL;
import edu.umd.fcmd.guice.services.ConnectionJDBC;
import edu.umd.fcmd.guice.services.ConnectionPooled;
import edu.umd.fcmd.guice.services.FileSystemNFS;
import edu.umd.fcmd.guice.services.FileSystemNTFS;*/
import edu.umd.fcmd.guice.interfaces.*;
import edu.umd.fcmd.guice.services.*;
import com.google.inject.AbstractModule;



public class StandardModule extends AbstractModule{
	protected void configure(){
	bind(Frontend.class).to(FrontendHTML.class);
	bind(Middleware.class).to(MiddlewareTomcat.class);
	bind(Persistance.class).to(PersistanceMySQL.class);
	bind(Authentication.class).to(AuthenticationSSL.class);
	bind(FileSystem.class).to(FileSystemNFS.class);
	bind(Connection.class).to(ConnectionJDBC.class);
	}
}

