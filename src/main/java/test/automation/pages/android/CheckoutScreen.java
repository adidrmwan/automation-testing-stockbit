package test.automation.pages.android;

import org.openqa.selenium.By;
import org.springframework.stereotype.Component;
import test.automation.data.Customer;
import test.automation.pageobject.AndroidPageObject;
import test.automation.utils.FakerUtil;

@Component("test.automation.pages.android.CheckoutScreen")
public class CheckoutScreen extends AndroidPageObject {
    private By title() {
        return By.id("checkoutTitleTV");
    }

    private By fullName() {
        return By.id("fullNameET");
    }

    private By addressLine1() {
        return By.id("address1ET");
    }

    private By addressLine2() {
        return By.id("address2ET");
    }

    private By city() {
        return By.id("cityET");
    }

    private By stateRegion() {
        return By.id("stateET");
    }

    private By zipCode() {
        return By.id("zipET");
    }

    private By country() {
        return By.id("countryET");
    }

    private By toPaymentButton() {
        return By.id("paymentBtn");
    }

    public boolean isOnCheckoutScreen(String name){
        return waitUntilVisible(title()).getText().equalsIgnoreCase(name);
    }

    public void inputFullName(String fullName) {
        onType(fullName(), fullName);
    }
    public void inputAddressLine1(String addressLine1) {
        onType(addressLine1(), addressLine1);
    }
    public void inputAddressLine2(String addressLine2) {
        onType(addressLine2(), addressLine2);
    }
    public void inputCity(String city) {
        onType(city(), city);
    }
    public void inputStateRegion(String stateRegion) {
        onType(stateRegion(), stateRegion);
    }

    public void inputZipCode(String zipCode) {
        onType(zipCode(), zipCode);
    }

    public void inputCountry(String country) {
        onType(country(), country);
    }

    public void tapPaymentButton() {
        onClick(toPaymentButton());
    }
}
