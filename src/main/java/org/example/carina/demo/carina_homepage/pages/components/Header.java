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

    @FindBy(xpath = "./nav/div[1]/div/span[1]")
    private ExtendedWebElement carinaTextOnHeader;

    @FindBy(xpath = "./nav/div[@class='md-search']/div/form")
    private SearchComponent searchComponent;

    @FindBy(xpath = "./nav/div[3]/a")
    private ExtendedWebElement githubLink;

    public Header(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public HomePage gotoHomePage(){
        zebrunnerLogo.click();
        return new HomePage(driver);
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
