package org.example.carina.demo.carina_homepage.pages.components;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.example.carina.demo.carina_homepage.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class NavigationBarTest implements IAbstractTest {

    @Test
    @MethodOwner(owner = "pawelUlita")
    public void navigationIsVisibleTest() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        NavigationBar navigationBar = homePage.getNavigationBar();

        assertEquals(navigationBar.getNavbarTitle().getText(), "Carina", "Carina heading is not first element of navigation menu");
        assertTrue(navigationBar.getNavbarVisibleElements().size() > 0, "List elements are not present");
        assertTrue(navigationBar.getNestedNavBars().size() > 0, "Nested navBars are not present");
        assertTrue(navigationBar.isHighlighted(navigationBar.getNavbarVisibleElements().get(0)));
    }

    @Test
    @MethodOwner(owner = "pawelUlita")
    public void someElementsAreHiddenTest() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        NavigationBar navigationBar = homePage.getNavigationBar();

        assertFalse(navigationBar.getAutomationBarElements().get(0).isElementPresent(), "There are no hidden elements");

        navigationBar.getNestedNavBars().get(0).click();

        assertTrue(navigationBar.getAutomationBarElements().get(0).isElementPresent(), "There are no hidden elements");
    }

    @Test
    @MethodOwner(owner = "pawelUlita")
    public void clickEveryLinkAndCheckHighlightAndLinkTest() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        NavigationBar navigationBar = homePage.getNavigationBar();

        assertTrue(navigationBar.clickAllElementsAndCheckHighlightAndLink(navigationBar.getNavbarVisibleElements()), "Element is not highlighted or link is invalid");
        assertTrue(navigationBar.clickAllNestedAndCheckHighlightAndLink(), "Element is not highlighted or link is invalid");
    }

}
