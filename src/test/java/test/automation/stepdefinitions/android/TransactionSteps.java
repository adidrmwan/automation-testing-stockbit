package test.automation.stepdefinitions.android;

import com.github.javafaker.Faker;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import test.automation.data.Customer;
import test.automation.data.Payment;
import test.automation.pages.android.*;
import test.automation.properties.UserProperties;
import test.automation.utils.FakerUtil;

public class TransactionSteps {
    @Autowired
    CatalogScreen catalogScreen;

    @Autowired
    TopBar topBar;

    @Autowired
    DetailProductScreen detailProductScreen;

    @Autowired
    CartScreen cartScreen;

    @Autowired
    LoginScreen loginScreen;

    @Autowired
    CheckoutScreen checkoutScreen;

    @Autowired
    UserProperties userProperties;

    @Autowired
    PaymentScreen paymentScreen;

    @Autowired
    ReviewTransactionScreen reviewTransactionScreen;

    @Autowired
    CompleteTransactionScreen completeTransactionScreen;

    private static int quantity;

    @Given("user on catalog screen")
    public void userOnCatalogScreen() {
        catalogScreen.isOnPage();
    }

    @When("user select the item {string} with colour {string} and quantity {int} of item")
    public void userSelectTheItemWithColourAndQuantityOfItem(String itemName, String colorName, int number) {
        catalogScreen.tapItem(itemName);
        detailProductScreen.isOnDetailProducts(itemName);
        detailProductScreen.selectColour(colorName);
        detailProductScreen.addQuantity(number);
        detailProductScreen.isQuantityOfItemCorrect(String.valueOf(number));
        if (topBar.isQuantityCartInvisible()) {
            quantity = 0;
        } else {
            quantity = Integer.parseInt(topBar.getQuantityCart());
        }
        detailProductScreen.tapAddToCartButton();
        if (quantity!=0){
            int temp = Integer.parseInt(topBar.getQuantityCart()) - quantity;
            Assert.assertEquals(number, temp);
        }
        else {
            Assert.assertEquals(number, Integer.parseInt(topBar.getQuantityCart()));
        }
    }

    @And("user tap add to cart button")
    public void userTapAddToCartButton() {
        topBar.tapCartIcon();
    }

    @And("user proceed to checkout the item {string} with colour {string} and quantity {int} of item")
    public void userProceedToCheckoutTheItem(String itemName, String colorName, int number) {
        cartScreen.isOnCart("My Cart");
        cartScreen.isProductNameEqualWith(itemName);
        cartScreen.isProductQuantityEqualWith(number);
        cartScreen.tapProceedToCheckoutButton();
    }

    @And("user need login to process the item")
    public void userNeedLoginToProcessTheItem() {
        loginScreen.isOnLoginScreen("Login");
        loginScreen.inputUsername(userProperties.getUsername());
        loginScreen.inputPassword(userProperties.getPassword());
        loginScreen.tapLoginButton();
    }

    @And("user input shipping address")
    public void userInputShippingAddress() {
        checkoutScreen.isOnCheckoutScreen("Checkout");
        checkoutScreen.inputFullName(Customer.getFullname());
        checkoutScreen.inputAddressLine1(Customer.getAddressLine1());
        checkoutScreen.inputAddressLine2(Customer.getAddressLine2());
        checkoutScreen.inputCity(Customer.getCity());
        checkoutScreen.inputStateRegion(Customer.getStateRegion());
        checkoutScreen.inputZipCode(Customer.getZipCode());
        checkoutScreen.inputCountry(Customer.getCountry());
        checkoutScreen.tapPaymentButton();
    }

    @And("user input payment detail")
    public void userInputPaymentDetail() {
        paymentScreen.isOnPaymentScreen("Enter a payment method");
        paymentScreen.inputFullName(Customer.getFullname());
        paymentScreen.inputCardNumber(Payment.getCardNumber());
        paymentScreen.inputExpirationDate(Payment.getExpirationDate());
        paymentScreen.inputSecurityCode(Payment.getSecurityCode());
        paymentScreen.tapReviewOrderButton();
    }

    @And("user review the order of the item {string}")
    public void userReviewTheOrder(String name) {
        String fullname = Customer.getFullname();
        String address = Customer.getAddressLine1();
        String cityState = Customer.getCity() + ", " + Customer.getStateRegion();
        String countryZip = Customer.getCountry() +  ", " + Customer.getZipCode();
        String expiration = "Exp: " + Payment.getExpirationDate();
        String number = Payment.getCardNumber();

        reviewTransactionScreen.isOnReviewScreen("Review your order");
        reviewTransactionScreen.isProductEqualWith(name);
        reviewTransactionScreen.isDeliverAddressCorrect(fullname,address,cityState,countryZip);
        reviewTransactionScreen.isPaymentDataCorrect(fullname,number,expiration);
        reviewTransactionScreen.tapPlaceOrderButton();
    }

    @Then("user see complete transaction")
    public void userSeeCompleteTransaction() {
        completeTransactionScreen.isSuccessTransactionMessageDisplayed();
    }

    @Before(value = "@SuccessBuyTheProduct")
    public void registerNewUser() {
        Customer.setFullname(FakerUtil.getFakeName());
        Customer.setAddressLine1(FakerUtil.getFakeAddress());
        Customer.setAddressLine2(FakerUtil.getFakeAddress());
        Customer.setCity(FakerUtil.getFakeCity());
        Customer.setStateRegion(FakerUtil.getFakeState());
        Customer.setZipCode(FakerUtil.getFakeZipCode());
        Customer.setCountry(FakerUtil.getFakeCountry());
        Payment.setCardNumber(FakerUtil.getFakeAccountNumber());
        Payment.setExpirationDate(FakerUtil.getExpiredCard());
        Payment.setSecurityCode(FakerUtil.getSecurityNumberCard());
    }
}
