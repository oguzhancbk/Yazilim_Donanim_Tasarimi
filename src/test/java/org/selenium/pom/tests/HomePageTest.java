package org.selenium.pom.tests;

import org.selenium.pom.base.BaseClass;
import org.selenium.pom.pages.HomePage;
import org.testng.annotations.Test;

public class HomePageTest extends BaseClass {

    @Test
    public void test_verification_home_page(){
        HomePage homePage = new HomePage(driver);
        homePage.home_page_title_check();
        homePage.home_page_cookies();
        homePage.home_page_wrapper_check();
        homePage.home_page_widget_check();
        homePage.home_page_marketing_list_check();
    }

}
