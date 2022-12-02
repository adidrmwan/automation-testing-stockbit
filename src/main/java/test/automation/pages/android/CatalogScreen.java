package test.automation.pages.android;

import org.openqa.selenium.By;
import org.springframework.stereotype.Component;
import test.automation.pageobject.AndroidPageObject;

@Component("test.automation.pages.android.CatalogScreen")
public class CatalogScreen extends AndroidPageObject {

    private By title() {
        return By.id("productTV");
    }
    private By item(String name) {
        return By.xpath("//android.widget.ImageView[contains(@content-desc, '"+name+"')]");
    }

    public boolean isOnPage() {
        return waitUntilVisible(title()).isDisplayed();
    }

    public void tapItem(String name) {
        onClick(item(name));
    }

}
