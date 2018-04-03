/**************************************************************************/
/* TODO get this simple test to run before starting the ToyWebApp testing */
/**************************************************************************/

package edu.umd.fcmd.enpm614.selenium.test;
// TODO add necessary imports
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class SimpleTest {
	private static WebDriver driver;
	
	@Before 
	public void setUp() throws Exception {
		String exePath = "C://ChromeDriver//chromedriver.exe";
		driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", exePath);
	}
	

	//test the title and link value.
	@Test
	public void TestMainPage(){//test the main page function: title+links value
		driver.get("http://localhost:8888/");
		assertEquals("Assignment 3 Toy Web App",driver.getTitle());//test the title
		
		WebElement element = driver.findElement(By.linkText("Math"));
		assertNotNull(element);//test the link value"Math"
		WebElement element1 = driver.findElement(By.linkText("Form"));
		assertNotNull(element1);//test the link value"Form"
	}
	
	//	Review page reviews (displays) all of the form data submitted or error messages
	@Test
	public void TestReview(){
		driver.get("http://localhost:8888/");
		
		WebElement element = driver.findElement(By.linkText("Form"));//click the form link
		element.click();
		
		
		//complete review
		driver.get("http://localhost:8888/form.jsp");
		assertEquals("Assignment 3 Toy Web App - Form",driver.getTitle());
		List<WebElement> color_buttons=driver.findElements(By.name("colors"));
		color_buttons.get(1).click();
		element=driver.findElement(By.name("characters"));
		element.sendKeys("‘¬¡¡");
		driver.findElement(By.name("agree")).click();//click the "agree"
		element.submit();
		assertEquals("??",driver.findElement(By.name("charRev")).getAttribute("value"));//not null
		assertEquals("white",driver.findElement(By.name("colRev")).getAttribute("value"));
		assertEquals("agree",driver.findElement(By.name("agrRev")).getAttribute("value"));//i agree		
		
		
		//complete review
		driver.get("http://localhost:8888/form.jsp");
		assertEquals("Assignment 3 Toy Web App - Form",driver.getTitle());
		List<WebElement> color_buttons1=driver.findElements(By.name("colors"));
		color_buttons1.get(1).click();
		element=driver.findElement(By.name("characters"));
		element.sendKeys("yesthis");
		driver.findElement(By.name("agree")).click();//click the "agree"
		element.submit();
		assertEquals("yesthis",driver.findElement(By.name("charRev")).getAttribute("value"));//not null
		assertEquals("white",driver.findElement(By.name("colRev")).getAttribute("value"));
		assertEquals("agree",driver.findElement(By.name("agrRev")).getAttribute("value"));//i agree		
		
		
		
		
		
		
		
		//leave color selection empty
		driver.get("http://localhost:8888/form.jsp");
		assertEquals("Assignment 3 Toy Web App - Form",driver.getTitle());
		element=driver.findElement(By.name("characters"));
		element.sendKeys("yesthis");
		driver.findElement(By.name("agree")).click();//click the "agree"
		element.submit();
		assertEquals("some fields were left empty...",driver.findElement(By.name("error")).getAttribute("value"));
						
		
		
		//leave agree empty
		driver.get("http://localhost:8888/form.jsp");
		assertEquals("Assignment 3 Toy Web App - Form",driver.getTitle());
		List<WebElement> color_buttons5=driver.findElements(By.name("colors"));
		color_buttons5.get(1).click();
		element=driver.findElement(By.name("characters"));
		element.sendKeys("yesthis");
		element.submit();
		assertEquals("some fields were left empty...",driver.findElement(By.name("error")).getAttribute("value"));
				
		
		//leave character empty
		driver.get("http://localhost:8888/form.jsp");
		assertEquals("Assignment 3 Toy Web App - Form",driver.getTitle());
		List<WebElement> color_buttons2=driver.findElements(By.name("colors"));
		color_buttons2.get(1).click();
		element=driver.findElement(By.name("characters"));
		driver.findElement(By.name("agree")).click();//click the "agree"
		element.submit();
		assertEquals("some fields were left empty...",driver.findElement(By.name("error")).getAttribute("value"));
		
		
		//leave character empty
		driver.get("http://localhost:8888/form.jsp");
		assertEquals("Assignment 3 Toy Web App - Form",driver.getTitle());
		element=driver.findElement(By.name("characters"));
		driver.findElement(By.name("agree")).click();//click the "agree"
		element.submit();
		assertEquals("some fields were left empty...",driver.findElement(By.name("error")).getAttribute("value"));
		
		
		//leave three parts empty:
		driver.get("http://localhost:8888/form.jsp");
		assertEquals("Assignment 3 Toy Web App - Form",driver.getTitle());
		element=driver.findElement(By.name("characters"));
		element.submit();
		assertEquals("some fields were left empty...",driver.findElement(By.name("error")).getAttribute("value"));

	
	}
			
		@Test
	public void TestMath(){
		driver.get("http://localhost:8888/math.jsp");
		assertEquals("Assignment 3 Toy Web App - Math",driver.getTitle());
		assertEquals("Usage: http://localhost:8888/math.jsp?param1=XX&opertation=X&param2=XX",driver.findElement(By.name("result")).getAttribute("value"));
		
		//normal test
		driver.get("http://localhost:8888/math.jsp?param1=20&operation=plus&param2=30");
		assertEquals("50",driver.findElement(By.name("result")).getAttribute("value"));//normal test
		driver.get("http://localhost:8888/math.jsp?param1=20&operation=minus&param2=30");
		assertEquals("-10",driver.findElement(By.name("result")).getAttribute("value"));//normal test
		
		//test the param1 and param2 
		driver.get("http://localhost:8888/math.jsp?param1=0&operation=plus&param2=0");
		assertEquals("0",driver.findElement(By.name("result")).getAttribute("value"));//integer test
		
		driver.get("http://localhost:8888/math.jsp?param1=-1&operation=plus&param2=-30");
		assertEquals("-31",driver.findElement(By.name("result")).getAttribute("value"));//integer test
		
		driver.get("http://localhost:8888/math.jsp?param1=008&operation=plus&param2=01");
		assertEquals("9",driver.findElement(By.name("result")).getAttribute("value"));//integer test
		
		driver.get("http://localhost:8888/math.jsp?param1=0.8&operation=plus&param2=30");
		assertEquals("param1 and param2 must be integers...",driver.findElement(By.name("result")).getAttribute("value"));//integer test
		
		driver.get("http://localhost:8888/math.jsp?param1=0.8&operation=plus&param2=0.78");
		assertEquals("param1 and param2 must be integers...",driver.findElement(By.name("result")).getAttribute("value"));//integer test
		
		driver.get("http://localhost:8888/math.jsp?param1=20&operation=plus&param2=yes");
		assertEquals("param1 and param2 must be integers...",driver.findElement(By.name("result")).getAttribute("value"));//integer test
		driver.get("http://localhost:8888/math.jsp?param1=a&operation=minus&param2=30");
		assertEquals("param1 and param2 must be integers...",driver.findElement(By.name("result")).getAttribute("value"));//normal test
		driver.get("http://localhost:8888/math.jsp?param1=y&operation=plus&param2=c");
		assertEquals("param1 and param2 must be integers...",driver.findElement(By.name("result")).getAttribute("value"));//normal test
		
		//test the operation to be plus or minus
		driver.get("http://localhost:8888/math.jsp?value1=20&operation=multiply&value2=40");
		assertEquals("Usage: http://localhost:8888/math.jsp?param1=XX&opertation=X&param2=XX",driver.findElement(By.name("result")).getAttribute("value"));//operation test
		
		driver.get("http://localhost:8888/math.jsp?value1=20&operation=divide&value2=40");
		assertEquals("Usage: http://localhost:8888/math.jsp?param1=XX&opertation=X&param2=XX",driver.findElement(By.name("result")).getAttribute("value"));//operation test
		
		//test both
		driver.get("http://localhost:8888/math.jsp?value1=ef&operation=multiple&value2=40");
		assertEquals("Usage: http://localhost:8888/math.jsp?param1=XX&opertation=X&param2=XX",driver.findElement(By.name("result")).getAttribute("value"));//operation test			
	
		//test both
		driver.get("http://localhost:8888/math.jsp?value1=0.27&operation=multiple&value2=40");
		assertEquals("Usage: http://localhost:8888/math.jsp?param1=XX&opertation=X&param2=XX",driver.findElement(By.name("result")).getAttribute("value"));//operation test			
		
		}
		


	@Test
	public void TestForm(){
		driver.get("http://localhost:8888/");
			//test the title
		assertEquals("Assignment 3 Toy Web App",driver.getTitle());
			//test the link
		WebElement element=driver.findElement(By.linkText("Form"));
			element.click();
		assertNotNull(element);
			//test the page title
		assertEquals("Assignment 3 Toy Web App - Form",driver.getTitle());
		
		WebElement element1=driver.findElement(By.name("characters"));
		assertNotNull(element1);//not empty and not null
			//test submit
		element1.sendKeys("yesch");
		
			// color buttons selection
		List<WebElement> color_buttons=driver.findElements(By.name("colors"));
			
		int csize=color_buttons.size();
			
		List<String> values=Arrays.asList("red","white","blue");
			
			//start the loop from the first color to the last color;
		for(int i=0;i<csize;i++){
			
			String sValue=color_buttons.get(i).getAttribute("value");
				
			assertTrue(values.contains(sValue));
				//if find"white", click
			if(sValue.equalsIgnoreCase("white")){
				color_buttons.get(i).click();
			break;		
			}
		}	
		driver.findElement(By.name("agree")).click();
		element1.submit();
			
		assertEquals("yesch",driver.findElement(By.name("charRev")).getAttribute("value"));//not null
		assertEquals("white",driver.findElement(By.name("colRev")).getAttribute("value"));
		assertEquals("agree",driver.findElement(By.name("agrRev")).getAttribute("value"));//i agree
	}
		
		
	@After
	public void tearDown() throws Exception {
		driver.close();
		
	}
}
