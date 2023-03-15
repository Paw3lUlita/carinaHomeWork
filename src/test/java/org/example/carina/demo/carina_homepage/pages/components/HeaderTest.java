package org.example.carina.demo.carina_homepage.pages.components;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.example.carina.demo.carina_homepage.pages.HomePage;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.*;

public class HeaderTest implements IAbstractTest {

    @Test
    @MethodOwner(owner = "pulita")
    public void zebrunnerLogoTest() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        assertTrue(homePage.isPageOpened(), "Home page is not opened");
        Header header = homePage.getHeader();
        Assert.assertTrue(header.getZebrunnerLogo().isElementPresent(), "The header is missing");
        HomePage homePage2 = header.clickOnZebrunnerLogo();
        assertTrue(homePage2.isPageOpened(), "Home page is not opened");
    }

    @Test
    @MethodOwner(owner = "pulita")
    public void carinaBrandTest() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        assertTrue(homePage.isPageOpened(), "Home page is not opened");
        Header header = homePage.getHeader();
        assertTrue(header.isCarinaTextPresentOnHeader(), "The header is missing");
    }

    @Test
    @MethodOwner(owner = "pulita")
    public void searchComponentTest() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        assertTrue(homePage.isPageOpened(), "Home page is not opened");
        SearchComponent searchComponent = homePage.getHeader().getSearchComponent();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(searchComponent.isUIObjectPresent(), "Search Component is not present");
        softAssert.assertTrue(searchComponent.getIcon().isElementPresent(), "Icon is not present");
        softAssert.assertTrue(searchComponent.getInputField().isElementPresent(), "Input is not present");
        softAssert.assertAll();
    }

    @Test
    @MethodOwner(owner = "pulita")
    public void githubLinkTest() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        assertTrue(homePage.isPageOpened(), "Home page is not opened");
        Header header = homePage.getHeader();
        header.getGithubLink().click();
        assertEquals(getDriver().getCurrentUrl(), "https://github.com/zebrunner/carina/");
    }

    @Test
    @MethodOwner(owner = "pulita")
    public void stickyHeaderTest() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        assertTrue(homePage.isPageOpened(), "Home page is not opened");
        Header header = homePage.getHeader();
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        assertTrue(header.isUIObjectPresent(), "Header is not sticky");
    }
}
