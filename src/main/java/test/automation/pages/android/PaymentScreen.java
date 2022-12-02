package test.automation.pages.android;

import org.openqa.selenium.By;
import org.springframework.stereotype.Component;
import test.automation.pageobject.AndroidPageObject;

@Component("test.automation.pages.android.PaymentScreen")
public class PaymentScreen extends AndroidPageObject {
    private By title() {
        return By.id("enterPaymentMethodTV");
    }

    private By fullName() {
        return By.id("nameET");
    }

    private By cardNumber() {
        return By.id("cardNumberET");
    }

    private By expirationDate() {
        return By.id("expirationDateET");
    }

    private By securityCode() {
        return By.id("securityCodeET");
    }

    private By reviewOrderButton() {
        return By.id("paymentBtn");
    }

    public boolean isOnPaymentScreen(String name){
        return waitUntilVisible(title()).getText().equalsIgnoreCase(name);
    }

    public void inputFullName(String fullName) {
        onType(fullName(), fullName);
    }
    public void inputCardNumber(String cardNumber) {
        onType(cardNumber(), cardNumber);
    }
    public void inputExpirationDate(String expirationDate) {
        onClick(expirationDate());
        for (int i = 0; i < expirationDate.length(); i++) {
            pressNumber(String.valueOf(expirationDate.charAt(i)));
            delay(1000);
        }
        hideKeyboard();

    }
    public void inputSecurityCode(String securityCode) {
        onType(securityCode(), securityCode);
    }

    public void tapReviewOrderButton() {
        onClick(reviewOrderButton());
    }
}
