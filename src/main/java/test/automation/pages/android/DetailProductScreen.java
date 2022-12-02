package test.automation.pages.android;

import org.openqa.selenium.By;
import org.springframework.stereotype.Component;
import test.automation.pageobject.AndroidPageObject;

@Component("test.automation.pages.android.DetailProductScreen")
public class DetailProductScreen extends AndroidPageObject {
    private By title() {return By.id("productTV"); }

    private By colour(String name) {return By.xpath("//android.widget.ImageView[contains(@content-desc, '"+name+" color')]");}

    private By quantity() { return By.id("noTV"); }

    private By increaseQuantityButton() {return By.id("plusIV"); }

    private By decreaseQuantityButton() {return By.id("minusIV"); }

    private By addToCartButton() {return By.id("cartBt"); }

    public boolean isOnDetailProducts(String name){
        return waitUntilVisible(title()).getText().equalsIgnoreCase(name);
    }

    public void selectColour(String name) {
        onClick(colour(name));
    }

    public void addQuantity(int number) {
        swipeUpIntoElement(quantity());
        int num = Integer.parseInt(waitUntilVisible(quantity()).getText());
        for (int i = num; i< number;i++) {
            onClick(increaseQuantityButton());
        }
    }

    public boolean isQuantityOfItemCorrect(String number){
        return waitUntilVisible(quantity()).getText().equalsIgnoreCase(number);
    }

    public void tapAddToCartButton() {
        onClick(addToCartButton());
    }
}
