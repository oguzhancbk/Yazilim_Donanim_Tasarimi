package org.selenium.pom.tests;

import org.selenium.pom.base.BaseClass;
import org.selenium.pom.pages.HomePage;
import org.selenium.pom.pages.MyAccountPage;
import org.selenium.pom.pages.ProductPage;
import org.testng.annotations.Test;

public class ProductPageTest extends BaseClass {

    @Test
    public void test_verification_product_page(){
        HomePage homePage = new HomePage(driver);
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        ProductPage productPage = new ProductPage(driver);
        homePage.home_page_cookies();
        logger.info("Cookies accept");
        myAccountPage.my_account_page_login_container_check();
        myAccountPage.my_account_page_check();
        myAccountPage.my_account_page_submit();
        homePage.home_page_marketing_list_check();
        myAccountPage.my_account_page_submit_successfull();
        logger.info("Account login successfull");
        myAccountPage.my_account_page_search_bar_check();
        productPage.product_page_check();
        productPage.product_page_products_container_check();
        productPage.product_page_filter_container_title_check();
        productPage.product_page_filters_wrapper_hide_filters_check();
        productPage.product_page_p_card_wrapper_check();
        logger.info("Product transactions successfull");
        productPage.product_page_order_check();
        logger.info("Order transactions successfull");
    }

}
