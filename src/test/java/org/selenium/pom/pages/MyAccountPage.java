package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class MyAccountPage {
    public static WebDriver driver;
    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//div[@class='account-nav-item user-login-container']")
    WebElement login_container;
    @FindBy(xpath = "//button[@class='q-secondary q-button-medium q-button tab button mr-5 left active']")
    WebElement login_button;
    @FindBy(xpath = "//div[@id='login-register']")
    WebElement login_register;
    @FindBy(xpath = "//input[@id='login-email']")
    WebElement email;
    @FindBy(xpath = "//input[@id='login-password-input']")
    WebElement password;
    @FindBy(xpath = "//button[@class='q-primary q-fluid q-button-medium q-button submit']")
    WebElement submit_button;
    @FindBy(xpath = "//input[@class='vQI670rJ']")
    WebElement search_bar;
    @FindBy(xpath = "//input[@placeholder='Aradığınız ürün, kategori veya markayı yazınız']")
    WebElement search_bar_place_holder;
    @FindBy(xpath = "//i[@class='ft51BU2r']")
    WebElement search_bar_icon;
    public void my_account_page_login_container_check(){
        Assert.assertTrue(login_container.isDisplayed());
        Assert.assertEquals(login_container.getText(),"Giriş Yap","Login container is invalid");
        login_container.click();
    }
    public void my_account_page_check(){
        Assert.assertTrue(login_register.isDisplayed());
        Assert.assertTrue(login_button.isDisplayed());
        login_button.click();
        Assert.assertEquals(login_button.getText(),"Giriş Yap","Login button message invalid");
    }
    public void my_account_page_submit() {
        Assert.assertTrue(email.isDisplayed());
        email.sendKeys("02180201068@ogr.inonu.edu.tr");
        Assert.assertTrue(password.isDisplayed());
        password.sendKeys("1234567890*-qwe");
        Assert.assertTrue(submit_button.isDisplayed());
        Assert.assertEquals(submit_button.getText(),"GIRIŞ YAP","Submit button message invalid");
        submit_button.click();
    }
    public void my_account_page_submit_successfull(){
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='account-nav-item user-login-container']")).isDisplayed());
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='account-nav-item user-login-container']")).getText(),"Hesabım","My account message is not showing");
    }
    public void my_account_page_search_bar_check(){
        Assert.assertTrue(search_bar.isDisplayed());
        Assert.assertEquals(search_bar_place_holder.getAttribute("placeholder"),"Aradığınız ürün, kategori veya markayı yazınız","Search bar place holder message is invalid");
        search_bar.sendKeys("Nutella");
        Assert.assertTrue(search_bar_icon.isDisplayed());
        search_bar_icon.click();
    }
}
