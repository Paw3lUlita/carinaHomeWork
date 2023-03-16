package org.example.carina.demo.carina_homepage.pages.components;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.example.carina.demo.carina_homepage.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.*;

public class NavigationBarTest implements IAbstractTest {

    @Test
    @MethodOwner(owner = "pulita")
    public void navigationIsVisibleTest() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        assertTrue(homePage.isPageOpened(), "Home page is not opened");
        NavigationBar navigationBar = homePage.getNavigationBar();

        SoftAssert sa = new SoftAssert();
        sa.assertEquals(navigationBar.getNavbarTitleText(), "Carina", "Carina heading is not first element of navigation menu");
        sa.assertTrue(navigationBar.areNavbarLinksPresent(), "List elements are not present");
        sa.assertTrue(navigationBar.isFirstLinkActiveWhenEnteringThePage(), "First link should be active");
        sa.assertAll();
    }

    @Test
    @MethodOwner(owner = "pulita")
    public void someElementsAreHiddenTest() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        assertTrue(homePage.isPageOpened(), "Home page is not opened");
        NavigationBar navigationBar = homePage.getNavigationBar();

        assertFalse(navigationBar.isAutomationNavbarFirstElementPresent(), "There are no hidden elements");

        navigationBar.clickOnAutomationNavBar();

        assertTrue(navigationBar.isAutomationNavbarFirstElementPresent(), "There are no hidden elements");
    }

    @Test
    @MethodOwner(owner = "pulita")
    public void clickEveryLinkAndCheckHighlightAndLinkTest() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        assertTrue(homePage.isPageOpened(), "Home page is not opened");
        NavigationBar navigationBar = homePage.getNavigationBar();

        SoftAssert sa = new SoftAssert();
        sa.assertTrue(navigationBar.clickAllVisibleElementsAndCheckHighlightAndLink(), "Element is not highlighted or link is invalid");
        sa.assertTrue(navigationBar.clickAllNestedAndCheckHighlightAndLink(), "Element is not highlighted or link is invalid");
        sa.assertAll();
    }
}
