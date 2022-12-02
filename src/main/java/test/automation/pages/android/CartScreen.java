package test.automation.pages.android;

import org.openqa.selenium.By;
import org.springframework.stereotype.Component;
import test.automation.pageobject.AndroidPageObject;

@Component("test.automation.pages.android.CartScreen")
public class CartScreen extends AndroidPageObject {
    private By title() {
        return By.id("productTV");
    }

    private By productName() {
        return By.id("titleTV");
    }

    private By price() {
        return By.id("priceTV");
    }

    private By productQuantity() {
        return By.id("noTV");
    }

    private By totalPrice() {
        return By.id("totalPriceTV");
    }

    private By checkoutButton() {
        return By.id("cartBt");
    }

    public boolean isOnCart(String name){
        return waitUntilVisible(title()).getText().equalsIgnoreCase(name);
    }

    public boolean isProductNameEqualWith(String name) {
        return waitUntilVisible(productName()).getText().equalsIgnoreCase(name);
    }

    public boolean isProductQuantityEqualWith(int quantity) {
        return waitUntilVisible(productQuantity()).getText().equalsIgnoreCase(String.valueOf(quantity));
    }

    public void tapProceedToCheckoutButton() {
        onClick(checkoutButton());
    }
}
