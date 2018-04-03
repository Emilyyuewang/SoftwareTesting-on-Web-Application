package edu.umd.fcmd.analysis.data.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.umd.fcmd.analysis.data.*;

public class ConfigurationTest {

	private Configuration configuration=null;

	@Before
    public void setup()throws Exception{
		configuration=new Configuration();
    }
	
	@After
    public void tearDown()throws Exception
    {
        configuration=null;
    }  
	@Test
	public void testGetOptions() {
		assertNotNull(configuration.getOptions());
	}
	
	@Test
	public void testAddOption() {
		Option option=new Option("hello", "world");
		configuration.addOption(option);
		Option option_1=new Option("ask", "no");
		configuration.addOption(option_1);
		assertEquals("ask",configuration.getOptions().get(0).getName());
		assertEquals("no",configuration.getOptions().get(0).getValue());
		assertEquals("hello",configuration.getOptions().get(1).getName());
		assertEquals("world",configuration.getOptions().get(1).getValue());
	}

	@Test
	public void testSubsumes() {
		
		Option option=new Option("hello", "world");
		configuration.addOption(option);
		Option option_1=new Option("ask", "no");
		configuration.addOption(option_1);
		Option option_2=new Option("knit", "wo");
		configuration.addOption(option_2);
		Option option_3=new Option("as", "yoo");
		configuration.addOption(option_3);
		
		Configuration configuration_1=new Configuration();
		configuration_1.addOption(option_3);
		Option option_111=new Option("ask", "no");
		configuration.addOption(option_111);
		
		Configuration configuration_2=new Configuration();
		configuration_2.addOption(option_3);
		Option option_4=new Option("asye", "yoo");
		configuration_2.addOption(option_4);
		
		Configuration configuration_3=new Configuration();
		Option option_5=new Option("si", "no");
		configuration_3.addOption(option_5);
		Option option_6=new Option("yek", "no");
		configuration_3.addOption(option_6);
		Option option_7=new Option("knt", "wo");
		configuration_3.addOption(option_7);
		Option option_8=new Option("aso", "oo");
		configuration_3.addOption(option_8);
		
		Configuration configuration_4=new Configuration();
		Option option_9=new Option("i", "no");
		configuration_4.addOption(option_9);
		Option option_10=new Option("ek", "no");
		configuration_4.addOption(option_10);
		Option option_11=new Option("nt", "wo");
		configuration_4.addOption(option_11);
		Option option_12=new Option("aso", "oo");
		configuration_4.addOption(option_12);
		Option option_13=new Option("a", "oo");
		configuration_4.addOption(option_13);
		
		Configuration configuration_5=new Configuration();
		Option option_14=new Option("hello", "world");
		configuration.addOption(option_14);
		Option option_15=new Option("ask", "no");
		configuration.addOption(option_15);
		Option option_16=new Option("knit", "wo");
		configuration.addOption(option_16);
		Option option_17=new Option("as", "yoo");
		configuration.addOption(option_17);
		
		
		Configuration configuration_6=new Configuration();
		Option option_18=new Option("i", "no");
		configuration_6.addOption(option_18);
		Option option_19=new Option("hello", "world");
		configuration_6.addOption(option_19);
		Option option_20=new Option("ask", "no");
		configuration_6.addOption(option_20);
		Option option_21=new Option("knit", "wo");
		configuration_6.addOption(option_21);
		Option option_22=new Option("as", "yoo");
		configuration_6.addOption(option_22);
		
		
		assertTrue(configuration.subsumes(configuration_1));/*it turns true*/
		assertFalse(configuration.subsumes(configuration_2));/* check the small different half set*/
		assertFalse(configuration.subsumes(configuration_3));/*check the same size*/
		assertFalse(configuration.subsumes(configuration_4));/*longer size*/
		assertTrue(configuration.subsumes(configuration));/*same size same value*/
		assertTrue(configuration.subsumes(configuration_5));//the same object
		assertFalse(configuration.subsumes(configuration_6));
	
	}
	
	@Test
	public void testCompareTo() {
		
		Option option=new Option("c", "o");
		configuration.addOption(option);
		Option option_1=new Option("d", "o");
		configuration.addOption(option_1);
		
		Configuration configuration_1=new Configuration();
		Option option_2=new Option("c", "o");
		configuration_1.addOption(option_2);
		Option option_3=new Option("e", "o");
		configuration_1.addOption(option_3);
		
		Configuration configuration_2=new Configuration();
		Option option_4=new Option("a", "o");
		configuration_2.addOption(option_4);
		Option option_5=new Option("d", "o");
		configuration_2.addOption(option_5);
		
		Configuration configuration_3=new Configuration();
		Option option_6=new Option("c", "o");
		configuration_3.addOption(option_6);
		Option option_7=new Option("a", "o");
		configuration_3.addOption(option_7);
		Option option_8=new Option("k", "o");
		configuration_2.addOption(option_8);
		
		Configuration configuration_4=new Configuration();
		Option option_9=new Option("a", "o");
		configuration_4.addOption(option_9);
		
		Configuration configuration_5=new Configuration();
		configuration_5.addOption(option);
		configuration_5.addOption(option_1);
		
		Configuration configuration_6=new Configuration();
		Option option_10=new Option("c", "o");
		configuration_6.addOption(option_10);
		
		Configuration configuration_7=new Configuration();
		Option option_11=new Option("t", "o");
		configuration_7.addOption(option_11);
		Option option_12=new Option("i", "o");
		configuration_7.addOption(option_12);
		
		Configuration configuration_8=new Configuration();
		Option option_13=new Option("f", "o");
		configuration_8.addOption(option_13);

		assertTrue(configuration.compareTo(configuration)==0);//same size same value
		assertTrue(configuration.compareTo(configuration_1)<0);//same size smaller
		assertTrue(configuration.compareTo(configuration_2)>0);//same size bigger
		assertTrue(configuration.compareTo(configuration_3)>0);//bigger size different value
		assertTrue(configuration.compareTo(configuration_4)>0);//smaller size smaller	
		assertTrue(configuration.compareTo(configuration_5)==0);
		assertTrue(configuration.compareTo(configuration_6)>0);
		assertTrue(configuration.compareTo(configuration_7)<0);
		assertTrue(configuration.compareTo(configuration_8)<0);

	}
	
	@Test
	public void testEquals() {

		Option option=new Option("c", "o");
		configuration.addOption(option);
		Option option_1=new Option("h", "j");
		configuration.addOption(option_1);
	
		Configuration configuration_1=new Configuration();
		Option option_2=new Option("c", "o");
		configuration_1.addOption(option_2);
		Option option_3=new Option("e", "o");
		configuration_1.addOption(option_3);
		
		Configuration configuration_2=new Configuration();
		configuration_2.addOption(option);
		
		Configuration configuration_3=new Configuration();
		Option option_4=new Option("k", "i");
		configuration_3.addOption(option_4);
		Option option_5=new Option("c", "o");
		configuration_3.addOption(option_5);
		Option option_6=new Option("k", "o");
		configuration_2.addOption(option_6);
		
		Configuration configuration_4=new Configuration();
		Option option_7=new Option("e", "i");
		configuration_4.addOption(option_7);
		Option option_8=new Option("f", "j");
		configuration_1.addOption(option_8);
		
		Configuration configuration_5=new Configuration();
		Option option_9=new Option("d", "k");
        configuration.addOption(option_9);
        
        Configuration configuration_6=new Configuration();
		Option option_10=new Option("p", "o");
		configuration_6.addOption(option_10);
		Option option_11=new Option("c", "o");
		configuration_6.addOption(option_11);
		
		Configuration configuration_7=new Configuration();
		Option option_12=new Option("c", "o");
        configuration_7.addOption(option_12);
        
        Configuration configuration_8=new Configuration();
		Option option_13=new Option("d", "i");
		configuration_8.addOption(option_13);
		Option option_14=new Option("p", "g");
		configuration_8.addOption(option_14);
		Option option_15=new Option("s", "o");
		configuration_8.addOption(option_15);
		
		 Configuration configuration_9=new Configuration();
		 Option option_16=new Option("c", "o");
		 configuration_9.addOption(option_16);
		 Option option_17=new Option("h", "j");
		 configuration_9.addOption(option_17);
		 Option option_18=new Option("s", "o");
		 configuration_9.addOption(option_18);
		 
		 Configuration configuration_10=new Configuration();
		 configuration_10.addOption(option);
		 configuration_10.addOption(option_1);
		 
		 Configuration configuration_11=new Configuration();
		 Option option_19=new Option("c", "o");
		 configuration_11.addOption(option_19);
		 Option option_20=new Option("p", "o");
		 configuration_11.addOption(option_20);
		

		 assertFalse(configuration.equals("s___h11f"));
		 assertTrue(configuration.equals(configuration));
		 assertFalse(configuration.equals(configuration_1));
		 assertFalse(configuration.equals(configuration_2));
		 assertFalse(configuration.equals(configuration_3));
		 assertFalse(configuration.equals(configuration_4));
		 assertFalse(configuration.equals(configuration_5));
		 assertFalse(configuration.equals(configuration_6));
		 assertFalse(configuration.equals(configuration_7));
		 assertFalse(configuration.equals(configuration_8));
		 assertFalse(configuration.equals(configuration_9));
		 assertFalse(configuration.equals(configuration_10));
		 assertFalse(configuration.equals(configuration_11));
		 
	}

	@Test
	public void testHashCode() {
		
		Option option=new Option("c", "o");
		configuration.addOption(option);
		
		Configuration configuration_1=new Configuration();
		configuration_1.addOption(option);
		
		Configuration configuration_2=new Configuration();
		Option option_1=new Option("d", "e");
		configuration_2.addOption(option_1);
		
		assertEquals(configuration.hashCode(),configuration.hashCode());
        assertEquals(configuration.hashCode(),configuration_1.hashCode());
        assertTrue(configuration.hashCode()!=configuration_2.hashCode());
	}
	

	@Test
	public void testToString() {		
		Option option=new Option("c", "u");
		configuration.addOption(option);
		Option option_1=new Option("e", "i");
		configuration.addOption(option_1);
		assertEquals("c=u e=i",configuration.toString());
		
			
	}

}
