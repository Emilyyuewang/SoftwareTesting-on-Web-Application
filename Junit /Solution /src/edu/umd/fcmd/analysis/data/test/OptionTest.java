package edu.umd.fcmd.analysis.data.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import edu.umd.fcmd.analysis.data.*;

public class OptionTest {

	private Option option=null;

	@Before
    public void setup()throws Exception{
		option=new Option("hello","world");
    }
	
	@After
    public void tearDown()throws Exception
    {
        option=null;
    }  
	
    @Test
    public void testOption() {
    	assertEquals("hello",option.getName());
    	assertEquals("world",option.getValue());
    }
    
    @Test
    public void testGetName() {
    	assertEquals("hello",option.getName());
    }
    
    @Test
    public void testSetName() {
        option.setName("test");
        assertEquals("test",option.getName());
    }

    /**
     * Getter and setter for the current Option's value
	*/
    @Test
    public void testGetValue() {
    	assertEquals("world",option.getValue());
    }
    
    @Test
    public void testSetValue() {
    	option.setValue("test");
        assertEquals("test",option.getValue());
    }
    
    @Test
    public void testCompareTo() {
    	Option s1=new Option("hello","no");
    	Option s2=new Option("yes","world");
    	Option s3=new Option("yes","no");
    	Option s4=new Option("hello","world");

        assertTrue(option.compareTo(option)==0);
        assertTrue(option.compareTo(s1)>0);
        assertTrue(option.compareTo(s2)<0);
        assertTrue(option.compareTo(s3)<0);
        assertTrue(option.compareTo(s4)==0);
        
    }
    
    @Test
    public void testEquals() {
        Option s1=new Option("yes","no");
        Option s2=new Option("hello","world");
        Option s3=new Option("hello","no");
        Option s4=new Option("yes","world");
        
        assertFalse(option.equals("sdfgfdh11f"));
        assertFalse(option.equals(s1));
        assertTrue(option.equals(s2));
        assertFalse(option.equals(s3));
        assertFalse(option.equals(s4));
        assertTrue(option.equals(option));
    }
    

	@Test
    public void tetsHashCode() {
        Option s1=new Option("hello","world");
        Option s2=new Option("yes","no");
        assertEquals(option.hashCode(),option.hashCode());
        assertEquals(option.hashCode(),s1.hashCode());
        assertTrue(option.hashCode()!=s2.hashCode());
    }
    
	@Test
    public void TestToString(){
    	assertEquals("hello=world",option.toString());
    }

}