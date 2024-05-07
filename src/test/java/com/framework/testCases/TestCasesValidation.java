package com.framework.testCases;
import com.framework.pageObjects.LoginPage;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
public class TestCasesValidation extends baseClass {
    private static final Logger logger = Logger.getLogger(TestCasesValidation.class);
    @Test
    public void Loginform(){
        logger.info("URL is opened");
        LoginPage lp= new LoginPage(driver);
        lp.enterUsername(emailId);
        lp.enterPassword(password);
        lp.clickButton();
        if(driver.getTitle().equals("Enmovil")){
            Assert.assertTrue(true);
            logger.info("Matched.");

        }else{
            Assert.fail();
        }


    }


}
