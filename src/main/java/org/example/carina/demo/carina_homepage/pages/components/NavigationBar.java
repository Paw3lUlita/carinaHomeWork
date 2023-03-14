package org.example.carina.demo.carina_homepage.pages.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class NavigationBar extends AbstractUIObject {

    @FindBy(xpath = "./child::node()[1]")
    private ExtendedWebElement navbarTitle;

    @FindBy(xpath = "./ul/li[@class='md-nav__item']/a | ./ul/li[@class='md-nav__item md-nav__item--active']/a")
    private List<ExtendedWebElement> navbarCLicableElements;


    @FindBy(xpath = "./ul/li[@class='md-nav__item md-nav__item--nested']")
    private List<NestedNavigationBar> elementsWithNestedNavBar;

    public NavigationBar(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public boolean isHighlighted(ExtendedWebElement element) {
        return element.getAttribute("class").endsWith("--active");
    }

}
