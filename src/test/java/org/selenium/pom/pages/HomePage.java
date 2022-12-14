package org.selenium.pom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class HomePage {
    public static WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//div[@class='homepage-wrapper']")
    WebElement home_page_wrapper;
    @FindBy(xpath = "//button[@id='onetrust-accept-btn-handler']")
    WebElement cookies;
    @FindBy(xpath = "//a[@class='logo' and @title='trendyol']")
    WebElement home_page_header_title;
    @FindBy(xpath = "//div[@class='styles-module_slider__o0fqa']")
    WebElement home_page_widget;
    @FindBy(xpath = "//a[@class='item']")
    List<WebElement> home_page_widget_items;
    @FindBy(xpath = "//div[@data-fragment-name='MarketingBoutiqueList']")
    WebElement home_page_marketing_list;

    public void home_page_wrapper_check(){
        home_page_wrapper.isDisplayed();
    }
    public void home_page_widget_check(){
        home_page_widget.isDisplayed();
        int i = 0;
        for (WebElement element : home_page_widget_items){
            element.isDisplayed();
            i++;
        }
        assert home_page_widget_items.size() == i;
    }
    public void home_page_title_check(){
        Assert.assertTrue(home_page_header_title.isDisplayed());
    }
    public void home_page_cookies(){
        cookies.click();
    }
    public void home_page_marketing_list_check(){
        Assert.assertTrue(home_page_marketing_list.isDisplayed());
    }

}
