package org.selenium.pom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class ProductPage {
    public static WebDriver driver;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='search-app-container']")
    WebElement search_app_container;
    @FindBy(xpath = "//div[@class='fltrs-wrppr hide-fltrs']")
    List<WebElement> filters_wrapper_hide_filters;
    @FindBy(xpath = "//div[@class='fltr-cntnr-ttl']")
    List<WebElement> filter_container_title;
    @FindBy(xpath = "//div[@class='srch-aggrgtn-cntnr']")
    WebElement search_aggregation_container;
    @FindBy(xpath = "//div[@class='srch-prdcts-cntnr']")
    WebElement search_products_container;
    @FindBy(xpath = "//div[@class='srch-rslt-title']")
    WebElement search_result_title;
    @FindBy(xpath = "//*[@id=\"search-app\"]/div/div[1]/div[2]/div[1]/div[1]/div/h1")
    WebElement search_result_title_description;
    @FindBy(xpath = "//div[@class='slctd-fltr-item slctd-fltr-item-dsbld']")
    WebElement selected_filter_item;
    @FindBy(xpath = "//a[@class='slctd-fltrs-clr-all']")
    WebElement selected_filters_clear_all;
    @FindBy(css = "#search-app > div > div.srch-rslt-cntnt > div.srch-prdcts-cntnr > div:nth-child(5) > div:nth-child(1) > div > div:nth-child(2) > div.p-card-chldrn-cntnr.card-border")
    WebElement selected_card_item;
    @FindBy(xpath = "//*[@id=\"search-app\"]/div/div[1]/div[2]/div[5]/div[1]/div/div[2]/div[1]/div[2]/button/div[1]")
    WebElement selected_card_item_sepete_ekle;
    @FindBy(css = "#search-app > div > div.srch-rslt-cntnt > div.srch-prdcts-cntnr > div:nth-child(5) > div:nth-child(1) > div > div:nth-child(2) > div.p-card-chldrn-cntnr.card-border > div.btn-basket > button > div.add-to-bs-tx-sc")
    WebElement selected_card_item_sepete_eklendi;
    @FindBy(css = "#search-app > div > div.srch-rslt-cntnt > div.srch-prdcts-cntnr > div:nth-child(5) > div:nth-child(1) > div > div:nth-child(2) > div.p-card-chldrn-cntnr.card-border > div.go-to-basket-button.visible")
    WebElement selected_card_item_sepete_git;
    @FindBy(css = "#pb-container > aside > div > div:nth-child(1) > a")
    WebElement order_confirm_cart_button;
    @FindBy(css = "#account-navigation-container > div > div.account-nav-item.basket-preview")
    WebElement order_my_cart;
    @FindBy(css = ".on-boarding-turn-address-selection")
    WebElement order_turn_address;

    public void product_page_check(){
        Assert.assertTrue(search_app_container.isDisplayed());
        Assert.assertTrue(search_aggregation_container.isDisplayed());
        Assert.assertTrue(search_products_container.isDisplayed());
    }

    public void product_page_filters_wrapper_hide_filters_check(){
        assert filters_wrapper_hide_filters.size() == 14;
        for (WebElement element: filters_wrapper_hide_filters){
            element.isDisplayed();
        }
    }
    public void product_page_filter_container_title_check(){
        assert filter_container_title.size() == 6;
        for (WebElement element : filter_container_title){
            element.isDisplayed();
        }
    }
    public void product_page_products_container_check(){
        Assert.assertTrue(search_result_title.isDisplayed());
        System.out.println(search_result_title_description.getText());
        Assert.assertEquals(search_result_title_description.getText(), "Nutella","Search result tittle message is invalid");
        Assert.assertTrue(selected_filter_item.isDisplayed());
        Assert.assertEquals(selected_filter_item.getText(),"Nutella","Selected filter item message is invalid");
        Assert.assertTrue(selected_filters_clear_all.isDisplayed());
        Assert.assertEquals(selected_filters_clear_all.getText(),"Filtreleri Temizle","Selected filters clear all message is invalid");
    }
    public void product_page_p_card_wrapper_check(){
        selected_card_item.isDisplayed();
        assert selected_card_item_sepete_ekle.isDisplayed();
        Assert.assertEquals(selected_card_item_sepete_ekle.getText(),"Sepete Ekle","add to base text is invalid");
        selected_card_item_sepete_ekle.click();
        Assert.assertTrue(selected_card_item_sepete_eklendi.isDisplayed());
        Assert.assertEquals(selected_card_item_sepete_eklendi.getText(),"Sepete Eklendi","add to base text sc is invalid");
    }

    public void product_page_order_check(){
        Assert.assertTrue(order_my_cart.isDisplayed());
        order_my_cart.click();
        Assert.assertTrue(order_confirm_cart_button.isDisplayed());
        order_confirm_cart_button.click();
        Assert.assertTrue(order_turn_address.isDisplayed());
        order_turn_address.click();
    }

}
