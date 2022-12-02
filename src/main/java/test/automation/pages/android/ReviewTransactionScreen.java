package test.automation.pages.android;

import org.openqa.selenium.By;
import org.springframework.stereotype.Component;
import test.automation.pageobject.AndroidPageObject;

@Component("test.automation.pages.android.ReviewTransactionScreen")
public class ReviewTransactionScreen extends AndroidPageObject {
    private By title() {
        return By.id("enterShippingAddressTV");
    }

    private By productName() {
        return By.id("titleTV");
    }

    private By productPrice() {
        return By.id("priceTV");
    }

    private By fullName() {
        return By.id("fullNameTV");
    }

    private By addressLine1() {
        return By.id("addressTV");
    }

    private By cityState() {
        return By.id("cityTV");
    }

    private By countryZip() {
        return By.id("countryTV");
    }

    private By nameOnCard() {
        return By.id("cardHolderTV");
    }

    private By cardNumber() {
        return By.id("cardNumberTV");
    }

    private By expirationDate() {
        return By.id("expirationDateTV");
    }

    private By shippingPrice() {
        return By.id("amountTV");
    }

    private By totalPrice() {
        return By.id("totalAmountTV");
    }

    private By placeOrderButton() {
        return By.id("paymentBtn");
    }

    public boolean isOnReviewScreen(String name){
        return waitUntilVisible(title()).getText().equalsIgnoreCase(name);
    }

    public boolean isProductEqualWith(String name){
        return waitUntilVisible(productName()).getText().equalsIgnoreCase(name);
    }

    public boolean isDeliverAddressCorrect(String fullname, String address, String cityState, String countryZip) {
        swipeUpIntoElement(shippingPrice());
        return waitUntilVisible(fullName()).getText().equalsIgnoreCase(fullname) &&
                waitUntilVisible(addressLine1()).getText().equalsIgnoreCase(address) &&
                waitUntilVisible(cityState()).getText().equalsIgnoreCase(cityState) &&
                waitUntilVisible(countryZip()).getText().equalsIgnoreCase(countryZip);
    }

    public boolean isPaymentDataCorrect(String name, String number, String expiration) {
        String exp = waitUntilVisible(cityState()).getText().replace("/","");
        return waitUntilVisible(nameOnCard()).getText().equalsIgnoreCase(name) &&
                waitUntilVisible(cardNumber()).getText().equalsIgnoreCase(number) &&
                exp.equalsIgnoreCase(expiration);
    }

    public void tapPlaceOrderButton() {
        onClick(placeOrderButton());
    }
}
