package org.example.carina.demo.carina_homepage.pages;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.zebrunner.carina.utils.Configuration;
import com.zebrunner.carina.utils.R;
import org.example.carina.demo.carina_homepage.components.Header;
import org.example.carina.demo.carina_homepage.components.NavigationBar;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class HomePage extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//header[@class='md-header']")
    private Header header;

    @FindBy(xpath = "//nav[@aria-label='Navigation']")
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
