package org.example.carina.demo.carina_homepage.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SearchComponent extends AbstractUIObject {

    @FindBy(xpath = "./input")
    private ExtendedWebElement inputField;

    @FindBy(xpath = "./label")
    private ExtendedWebElement icon;

    public SearchComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public boolean isInputFieldPresent() {
        return inputField.isElementPresent();
    }

    public boolean isIconPresent() {
        return icon.isElementPresent();
    }
}
