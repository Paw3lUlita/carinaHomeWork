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

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(navigationBar.getNavbarTitle().getText(), "Carina", "Carina heading is not first element of navigation menu");
        softAssert.assertTrue(navigationBar.getNavbarVisibleElements().size() > 0, "List elements are not present");
        softAssert.assertTrue(navigationBar.getNestedNavBars().size() > 0, "Nested navBars are not present");
        softAssert.assertTrue(navigationBar.getNavbarVisibleElements().get(0).getAttribute("class").endsWith("--active"));
        softAssert.assertAll();
    }

    @Test
    @MethodOwner(owner = "pulita")
    public void someElementsAreHiddenTest() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        assertTrue(homePage.isPageOpened(), "Home page is not opened");
        NavigationBar navigationBar = homePage.getNavigationBar();

        assertFalse(navigationBar.getAutomationBarElements().get(0).isElementPresent(), "There are no hidden elements");

        navigationBar.getNestedNavBars().get(0).click();

        assertTrue(navigationBar.getAutomationBarElements().get(0).isElementPresent(), "There are no hidden elements");
    }

    @Test
    @MethodOwner(owner = "pulita")
    public void clickEveryLinkAndCheckHighlightAndLinkTest() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        assertTrue(homePage.isPageOpened(), "Home page is not opened");
        NavigationBar navigationBar = homePage.getNavigationBar();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(navigationBar.clickAllVisibleElementsAndCheckHighlightAndLink(), "Element is not highlighted or link is invalid");
        softAssert.assertTrue(navigationBar.clickAllNestedAndCheckHighlightAndLink(), "Element is not highlighted or link is invalid");
        softAssert.assertAll();
    }

}
