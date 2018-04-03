package edu.umd.fcmd.guice.services;

import edu.umd.fcmd.guice.interfaces.Connection;
import edu.umd.fcmd.guice.interfaces.FileSystem;
import com.google.inject.Inject;

import edu.umd.fcmd.guice.interfaces.Persistance;

public class PersistanceOracle implements Persistance {
	private final FileSystem filesystem;
	private final Connection connection;
	
	@Inject
	public PersistanceOracle(FileSystem filesys,Connection connection) {
		this.filesystem = filesys;
		this.connection = connection;
		
	}
	
	@Override
	public String getType() {
		return "Oracle Persistance";
	}
	
	@Override
	public boolean run() {
		System.out.println("running " + this.getType());
		
		// invoke services here if applicable
		filesystem.run();
		connection.run();
		return true;
	}
}
