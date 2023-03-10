package org.example.carina.demo;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import org.example.carina.demo.gui.pages.CompareModelsPage;
import org.example.carina.demo.gui.pages.HomePage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

/**
 * This sample shows how works page opening strategy
 *
 * @author qpsdemo
 */
public class PageOpeningStrategySampleTest implements IAbstractTest {

    @Test
    @MethodOwner(owner = "qpsdemo")
    public void testByElementOpeningStrategy(){

        SoftAssert softAssert = new SoftAssert();

        HomePage homePage = new HomePage(getDriver());
        homePage.open();

        homePage.setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);

        softAssert.assertTrue(homePage.isPageOpened(),"Home page is not opened");

        CompareModelsPage compareModelsPage = homePage.getFooterMenu().openComparePage();
        compareModelsPage.setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);

        softAssert.assertTrue(compareModelsPage.isPageOpened(), "Compare page is not opened");

        softAssert.assertAll();
    }

    @Test
    @MethodOwner(owner = "qpsdemo")
    public void testByURLOpeningStrategy(){
        SoftAssert softAssert = new SoftAssert();
        HomePage homePage = new HomePage(getDriver());
        homePage.open();

        homePage.setPageOpeningStrategy(PageOpeningStrategy.BY_URL);

        softAssert.assertTrue(homePage.isPageOpened(),"Home page is not opened");

        CompareModelsPage compareModelsPage = homePage.getFooterMenu().openComparePage();
        compareModelsPage.setPageOpeningStrategy(PageOpeningStrategy.BY_URL);

        softAssert.assertTrue(compareModelsPage.isPageOpened(), "Compare page is not opened");

        softAssert.assertAll();
    }

    @Test
    @MethodOwner(owner = "qpsdemo")
    public void testByUrlAndElementOpeningStrategy() {
        SoftAssert softAssert = new SoftAssert();
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        homePage.setPageOpeningStrategy(PageOpeningStrategy.BY_URL_AND_ELEMENT);

        softAssert.assertTrue(homePage.isPageOpened(),"Home page is not opened");

        CompareModelsPage compareModelsPage = homePage.getFooterMenu().openComparePage();
        compareModelsPage.setPageOpeningStrategy(PageOpeningStrategy.BY_URL_AND_ELEMENT);

        softAssert.assertTrue(compareModelsPage.isPageOpened(), "Compare page is not opened");

        softAssert.assertAll();
    }
}
