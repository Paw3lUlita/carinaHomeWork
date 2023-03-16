package org.example.carina.demo.carina_homepage.pages.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class NavigationBar extends AbstractUIObject {

    @FindBy(xpath = "./label")
    private ExtendedWebElement navbarTitle;

    @FindBy(xpath = "./ul/li[contains(@class,'md-nav__item') and not(contains(@class,'--nested'))]/a")
    private List<ExtendedWebElement> navbarVisibleElements;

    @FindBy(xpath = "./ul/li[@class='md-nav__item md-nav__item--nested'] | ./ul/li[@class='md-nav__item md-nav__item--active md-nav__item--nested']")
    private List<ExtendedWebElement> nestedNavBars;

    @FindBy(xpath = "./ul/li[contains(@class,'--nested')][1]/nav/ul/li/a")
    private List<ExtendedWebElement> automationBarElements;

    @FindBy(xpath = "./ul/li[contains(@class,'--nested')][2]/nav/ul/li/a")
    private List<ExtendedWebElement> advancedBarElements;

    @FindBy(xpath = "./ul/li[contains(@class,'--nested')][3]/nav/ul/li/a")
    private List<ExtendedWebElement> integrationBarElements;

    public NavigationBar(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    private boolean clickElementsAndCheckHighlightAndLink(List<ExtendedWebElement> elements) {
        boolean result = false;
        for (int i = 0; i < elements.size(); i++) {
            ExtendedWebElement element = elements.get(i);
            element.click();
            element = elements.get(i);
            if (!isHighlighted(element) || !isLinkCorrect(element)) {
                return false;
            }
            result = true;
        }
        return result;
    }

    public boolean clickAllNestedAndCheckHighlightAndLink() {
        boolean result;

        nestedNavBars.get(0).click();
        result = clickElementsAndCheckHighlightAndLink(automationBarElements);

        nestedNavBars.get(1).click();
        result = clickElementsAndCheckHighlightAndLink(advancedBarElements);

        nestedNavBars.get(2).click();
        result = clickElementsAndCheckHighlightAndLink(integrationBarElements);

        return result;

    }

    public boolean clickAllVisibleElementsAndCheckHighlightAndLink() {
        return clickElementsAndCheckHighlightAndLink(navbarVisibleElements);
    }

    private boolean isHighlighted(ExtendedWebElement element) {
        return element.getAttribute("class").endsWith("--active");
    }

    private boolean isLinkCorrect(ExtendedWebElement element) {
        String currentURL = driver.getCurrentUrl();
        if (element.getText().trim().toLowerCase().equals("overview")
                && currentURL.equals("https://zebrunner.github.io/carina/")) {
            return true;
        }
        return currentURL.contains(element.getText().trim().toLowerCase().replaceAll(" ", "_"));
    }

    public String getNavbarTitleText() {
        return navbarTitle.getText();
    }

    public boolean areNavbarLinksPresent() {
        return navbarVisibleElements.size() > 0 && nestedNavBars.size() > 0;
    }

    public boolean isFirstLinkActiveWhenEnteringThePage() {
        return navbarVisibleElements.get(0).getAttribute("class").endsWith("--active");
    }

    public void clickOnAutomationNavBar() {
        nestedNavBars.get(0).click();
    }

    public boolean isAutomationNavbarFirstElementPresent() {
        return automationBarElements.get(0).isElementPresent();
    }
}
