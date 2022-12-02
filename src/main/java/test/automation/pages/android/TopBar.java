package test.automation.pages.android;

import org.openqa.selenium.By;
import org.springframework.stereotype.Component;
import test.automation.pageobject.AndroidPageObject;

@Component("test.automation.pages.android.TopBar")
public class TopBar extends AndroidPageObject {
    private By cart() { return By.id("cartIV"); }

    private By quantityCart() { return By.id("cartTV"); }

    public String getQuantityCart() {
        return waitUntilVisible(quantityCart()).getText();
    }

    public boolean isQuantityCartInvisible() {
        return isElementInvisible(quantityCart());
    }

    public void tapCartIcon() {
        onClick(cart());
    }
}
