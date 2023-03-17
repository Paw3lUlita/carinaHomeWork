package org.example.carina.demo.carina_homepage.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.example.carina.demo.carina_homepage.pages.HomePage;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class Header extends AbstractUIObject {

    @FindBy(xpath = "./nav/a")
    private ExtendedWebElement zebrunnerLogo;

    @FindBy(xpath = ".//span")
    private ExtendedWebElement carinaTextOnHeader;

    @FindBy(xpath = ".//form")
    private SearchComponent searchComponent;

    @FindBy(xpath = "./nav/div[@class='md-header-nav__source']")
    private ExtendedWebElement githubLink;

    public Header(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public HomePage clickOnZebrunnerLogo() {
        zebrunnerLogo.click();
        return new HomePage(driver);
    }

    public boolean isZebrunnerLogoPresent() {
        return zebrunnerLogo.isElementPresent();
    }

    public void clickOnGithubLink() {
        githubLink.click();
    }

    public boolean isCarinaTextPresentOnHeader() {
        return carinaTextOnHeader.getText().equals("Carina");
    }

    public SearchComponent getSearchComponent() {
        return searchComponent;
    }
}
