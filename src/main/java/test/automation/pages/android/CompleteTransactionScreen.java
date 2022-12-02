package test.automation.pages.android;

import org.openqa.selenium.By;
import org.springframework.stereotype.Component;
import test.automation.pageobject.AndroidPageObject;

@Component("test.automation.pages.android.CompleteTransactionScreen")
public class CompleteTransactionScreen extends AndroidPageObject {
    private By title() {
        return By.id("completeTV");
    }

    private By description() {
        return By.id("orderTV");
    }

    private By sauceLabsImage() {
        return By.id("horseIV");
    }

    private By continueShoppingButton() {
        return By.id("shoopingBt");
    }

    public boolean isSuccessTransactionMessageDisplayed() {
        return waitUntilVisible(title()).isDisplayed() &&
                waitUntilVisible(description()).isDisplayed() &&
                waitUntilVisible(sauceLabsImage()).isDisplayed() &&
                waitUntilVisible(continueShoppingButton()).isDisplayed();
    }
}
