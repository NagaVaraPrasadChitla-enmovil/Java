package com.framework.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage{
    WebDriver driver;

    public LoginPage(WebDriver driver) {
           this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//input[@id=\"exampleInputEmail\"]")
    WebElement userEmail;

    @FindBy(xpath = "//input[@id=\"exampleInputPassword\"]")
    WebElement userPassword;

    @FindBy(xpath = "//button[text()=\"Log in\"]")
    WebElement clickSubmitButton;

    public void enterUsername(String email){userEmail.sendKeys(email);}
    public void enterPassword(String password){
        userPassword.sendKeys(password);
    }
    public void clickButton(){
        clickSubmitButton.click();
    }
}
