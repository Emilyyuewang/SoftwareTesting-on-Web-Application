/**************************************************************************/
/* TODO get this simple test to run before starting the ToyWebApp testing */
/**************************************************************************/

package edu.umd.fcmd.enpm614.selenium.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

// TODO add necessary imports

public class SimpleTest {
	private static WebDriver driver;
	
	// @Before or @BeforeClass
	public void setUp() throws Exception {
		driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "/Users/ANepaul/Desktop/" +
                "chromedriver");
	}

	// @After or @AfterClass
	public void tearDown() throws Exception {
		driver.quit();
	}
}
