package org.selenium.pom.tests;

import org.selenium.pom.base.BaseClass;
import org.selenium.pom.pages.HomePage;
import org.selenium.pom.pages.MyAccountPage;
import org.testng.annotations.Test;

public class MyAccountPageTest extends BaseClass {

    @Test
    public void test_verification_my_account_page(){
        HomePage homePage = new HomePage(driver);
        homePage.home_page_title_check();
        homePage.home_page_cookies();
        homePage.home_page_marketing_list_check();
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        myAccountPage.my_account_page_login_container_check();
        myAccountPage.my_account_page_check();
        myAccountPage.my_account_page_submit();
        homePage.home_page_marketing_list_check();
        myAccountPage.my_account_page_submit_successfull();
        myAccountPage.my_account_page_search_bar_check();
    }
}
