package org.example.carina.demo.carina_homepage.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.zebrunner.carina.utils.Configuration;
import com.zebrunner.carina.utils.R;
import org.example.carina.demo.carina_homepage.pages.components.Header;
import org.example.carina.demo.carina_homepage.pages.components.NavigationBar;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class HomePage extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//body/header")
    private Header header;

    @FindBy(xpath = "//body/div[@class='md-container']/main/div/div[1]/div/div/nav")
    private NavigationBar navigationBar;

    public HomePage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL(R.CONFIG.get(Configuration.Parameter.URL.getKey()));
    }

    public Header getHeader() {
        return header;
    }

    public NavigationBar getNavigationBar() {
        return navigationBar;
    }
}
