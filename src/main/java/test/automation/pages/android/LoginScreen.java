package test.automation.pages.android;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.springframework.stereotype.Component;
import test.automation.pageobject.AndroidPageObject;

@Component("test.automation.pages.android.LoginScreen")
public class LoginScreen extends AndroidPageObject {

    private By title() {
        return MobileBy.id("loginTV");
    }

    private By usernameField() {return MobileBy.id("nameET"); }

    private By passwordField() {return MobileBy.id("passwordET"); }

    private By loginButton() {
        return MobileBy.id("loginBtn");
    }

    public boolean isOnLoginScreen(String name){
        return waitUntilVisible(title()).getText().equalsIgnoreCase(name);
    }

    public void inputUsername(String username) {
        onType(usernameField(), username);
    }

    public void inputPassword(String password) {
        onType(passwordField(), password);
    }

    public void tapLoginButton(){
        onClick(loginButton());
    }
}
