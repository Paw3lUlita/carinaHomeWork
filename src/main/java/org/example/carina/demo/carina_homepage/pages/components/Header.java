package org.example.carina.demo.carina_homepage.pages.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.example.carina.demo.carina_homepage.pages.HomePage;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class Header extends AbstractUIObject {

    @FindBy(xpath = "./nav/a")
    private ExtendedWebElement zebrunnerLogo;

    @FindBy(xpath = "./nav/div[%s]/div/span[%s]")
    private ExtendedWebElement carinaTextOnHeader;

    @FindBy(xpath = "./nav/div[@class='md-search']/div/form")
    private SearchComponent searchComponent;

    @FindBy(xpath = "./nav/div[@class='md-header-nav__source']")
    private ExtendedWebElement githubLink;

    public Header(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public HomePage clickOnZebrunnerLogo(){
        zebrunnerLogo.click();
        return new HomePage(driver);
    }

    public boolean isCarinaTextPresentOnHeader () {
        return carinaTextOnHeader.format(1,1).getText().equals("Carina");
    }

    public ExtendedWebElement getZebrunnerLogo() {
        return zebrunnerLogo;
    }

    public ExtendedWebElement getCarinaTextOnHeader() {
        return carinaTextOnHeader;
    }

    public SearchComponent getSearchComponent() {
        return searchComponent;
    }

    public ExtendedWebElement getGithubLink() {
        return githubLink;
    }
}
