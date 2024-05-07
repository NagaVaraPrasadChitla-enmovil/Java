package com.framework.testCases;

//import com.framework.Utilities.ReadConfig;
//import org.apache.log4j.PropertyConfigurator;
//import org.apache.logging.log4j.core.tools.picocli.CommandLine;
//import org.jetbrains.annotations.NotNull;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.ie.InternetExplorerDriver;
//import org.testng.IClassListener;
//import org.testng.ITestClass;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.apache.log4j.Logger;
//import org.testng.annotations.Optional;
//import org.testng.annotations.Parameters;
//
//
////import java.util.logging.Logger;
//
//public class baseClass {
//
//    ReadConfig readConfig= new ReadConfig();
//
//
//    public String baseURL=readConfig.getApplicationURL();
//    public String emailId=readConfig.getemailId();
//    public String password=readConfig.getpassword();
//
//    public static WebDriver driver;
//
//    public static Logger logger;
//
//    @Parameters("browser")
//
//    @BeforeClass
//    public void setUp(String br){
//
//        logger =Logger.getLogger("Bajaj");
//        PropertyConfigurator.configure("Log4j.properties");
//
//        if(br.equals("chrome")){
//            System.setProperty("webdriver.chrome.driver", readConfig.getchromePath());
//            driver = new ChromeDriver();
//            driver.manage().window().maximize();
//        } else if (br.equals("firefox")) {
//            System.setProperty("webdriver.gecko.driver", readConfig.getfirefoxPath());
//            driver = new FirefoxDriver();
//            driver.manage().window().maximize();
//        }
//        else if(br.equals("ie")){
//            System.setProperty("webdriver.ie.driver", readConfig.getedgePath());
//            driver = new InternetExplorerDriver();
//            driver.manage().window().maximize();
//        }
//
//        driver.get(baseURL);
//    }
//
//
//    @AfterClass
//    public  void tearDown(){
//        driver.quit();
//    }
//}

import com.framework.Utilities.ReadConfig;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class baseClass extends ReadConfig {

    ReadConfig readConfig = new ReadConfig();

    public String baseURL = readConfig.getApplicationURL();
    public String emailId = readConfig.getemailId();
    public String password = readConfig.getpassword();
    public String ChromePath = readConfig.getchromePath();
    public String firefox = readConfig.getfirefoxPath();
    public String edge = readConfig.getedgePath();

    public static WebDriver driver;

    public static Logger logger;

    @BeforeClass
    @Parameters("browser")
    public void setUp(@Optional("chrome") String br) { // Default to chrome if browser parameter is not provided
        logger = Logger.getLogger("Bajaj");
        PropertyConfigurator.configure("Log4j.properties");

        if (br.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", ChromePath);
            driver = new ChromeDriver();
        } else if (br.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", firefox);
            driver = new FirefoxDriver();
        } else if (br.equalsIgnoreCase("ie")) {
            System.setProperty("webdriver.ie.driver", edge);
            driver = new InternetExplorerDriver();
        }

        driver.manage().window().maximize();
        driver.get(baseURL);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
