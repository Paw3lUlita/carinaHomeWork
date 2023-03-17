package org.example.carina.demo.carina_homepage.components;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.example.carina.demo.carina_homepage.pages.HomePage;
import org.example.carina.demo.utils.JSActionUtils;
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
        Assert.assertTrue(header.isZebrunnerLogoPresent(), "The header is missing");
        homePage = header.clickOnZebrunnerLogo();
        assertTrue(homePage.isPageOpened(), "Home page is not opened");
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
        SoftAssert sa = new SoftAssert();
        sa.assertTrue(searchComponent.isUIObjectPresent(), "Search Component is not present");
        sa.assertTrue(searchComponent.isIconPresent(), "Icon is not present");
        sa.assertTrue(searchComponent.isInputFieldPresent(), "Input is not present");
        sa.assertAll();
    }

    @Test
    @MethodOwner(owner = "pulita")
    public void githubLinkTest() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        assertTrue(homePage.isPageOpened(), "Home page is not opened");
        Header header = homePage.getHeader();
        header.clickOnGithubLink();
        assertEquals(getDriver().getCurrentUrl(), "https://github.com/zebrunner/carina/");
    }

    @Test
    @MethodOwner(owner = "pulita")
    public void stickyHeaderTest() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        assertTrue(homePage.isPageOpened(), "Home page is not opened");
        Header header = homePage.getHeader();
        JSActionUtils.scrollDownThePage(getDriver());
        assertTrue(header.isUIObjectPresent(), "Header is not sticky");
    }
}
