package edu.umd.fcmd.enpm614.mock.test;

import static org.junit.Assert.*;

import java.awt.List;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import edu.umd.fcmd.enpm614.mock.*;
import mockit.*;

public class UserAdminTest {
	private UserAdmin admin;
	@Mocked DBConnection db;
	@Rule
	    public ExpectedException thrown = ExpectedException.none();

	@Before
	public void setUp() throws Exception {
		admin = new UserAdmin(db);
	}

	@After
	public void tearDown() throws Exception {
		admin = null;
	}
	
	@Test
	public void testCreateUser1() throws SQLException {
		new NonStrictExpectations(){{
			db.userExists(withEqual("exist"));//if the username is exist, return true
			result = true;
			
			db.userExists(withNotEqual("exist"));//if the username is exist, return true
			result = false;
					
			db.addUser(anyString, anyString);
			minTimes = 0;
		}};
		assertFalse(admin.createUser("exist", "1234"));
		assertTrue(admin.createUser("notExist", "1234"));		
		new Verifications(){{
			db.userExists("exist");
			db.userExists("notExist");
			db.addUser("notExist", "1234");
		}};
	}
	
	@Test
	public void testCreateUser2() throws Exception {
		new NonStrictExpectations(){{
			db.userExists(anyString);//if the username is exist, return true
			result = new SQLException();
					
			db.addUser(anyString, anyString);
			times = 0;
		}};
		

		admin.createUser("exist", "1234");		
		new Verifications(){{
			db.userExists("exist");
		}};
	}

	@Test
	public void testRemoveUser1() throws SQLException {
		new NonStrictExpectations(){{			
			db.userExists(withEqual("notExist"));
			result = false;
			
			db.userExists(withNotEqual("notExist"));
			result = true;
			
			db.isAdmin(withEqual("admin"));
			result = true;
			
			db.isAdmin(withNotEqual("admin"));
			result = false;
					
			db.deleteUser(anyString);
			minTimes = 0;
		}};
		assertTrue(admin.removeUser("a"));
		assertFalse(admin.removeUser("notExist"));
		assertFalse(admin.removeUser("admin"));
		new Verifications(){{
			db.userExists("a");
			db.userExists("notExist");
			db.isAdmin("a");
			db.isAdmin("admin");
			db.deleteUser("a");
		}};
	}
	
	@Test
	public void testRemoveUser2() throws SQLException {
		new NonStrictExpectations(){{			
			db.userExists(anyString);
			result = new SQLException();
			
			db.isAdmin(anyString);
			result = false;
					
			db.deleteUser(anyString);
			minTimes = 0;
		}};
		assertFalse(admin.removeUser("a"));	

	}
	
	@Test
	public void testRunUserReport1() throws SQLException {
		new NonStrictExpectations(){{			
			db.getUsers();
			result = new ArrayList();
			
		}};
		admin.runUserReport();	
		new Verifications(){{
			db.getUsers();
		}};
	}
	
	@Test
	public void testRunUserReport2() throws SQLException {
		User a = new User("a", "user");
		final ArrayList userlist = new ArrayList<User>();
		userlist.add(a);
		new NonStrictExpectations(){{			
			db.getUsers();
			result = userlist;		
		}};
		admin.runUserReport();	
		new Verifications(){{
			db.getUsers();
		}};
	}
	
	@Test
	public void testRunUserReport3() throws SQLException {
		User a = new User("a", "user");
		final ArrayList userlist = new ArrayList<User>();
		for (int i=0;i<20;i++)
		{
			userlist.add(a);
		}
		
		new NonStrictExpectations(){{			
			db.getUsers();
			result = userlist;		
		}};
		admin.runUserReport();	
		new Verifications(){{
			db.getUsers();
		}};
	}
	
	@Test
	public void testRunUserReport4() throws SQLException {
		
		new NonStrictExpectations(){{			
			db.getUsers();
			result = new SQLException();		
		}};
		admin.runUserReport();	
		new Verifications(){{
			db.getUsers();
		}};
	}

}
