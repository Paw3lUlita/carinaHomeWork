package org.example.carina.demo.carina_homepage.pages.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class NestedNavigationBar extends AbstractUIObject {

    @FindBy(xpath = "./nav/ul/li/a")
    private List<ExtendedWebElement> elements;

    public NestedNavigationBar(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public boolean isHighlighted(ExtendedWebElement element) {
        return element.getAttribute("class").endsWith("active");
    }

}
