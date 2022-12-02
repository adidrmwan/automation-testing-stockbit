package test.automation.pageobject;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import test.automation.driver.AndroidDriverPool;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

@Component("test.automation.pageobject.AndroidPageObject")
public class AndroidPageObject extends BasePageObject{
    @Autowired
    AndroidDriverPool androidDriverPool;

    @Override
    public AndroidDriver getDriver() {
        if (this.driver.getAndroidDriver() == null) {
            this.driver.setAndroidDriver(this.androidDriverPool.create());
        }
        return this.driver.getAndroidDriver();
    }

    public void pressKey(AndroidKey androidKey) {
        ((AndroidDriver<?>) getDriver()).pressKey(new KeyEvent(androidKey));
    }

    public void swipeUpIntoElement(By by) {
        for (int count = 0;  !isElementDisplayed(by,2) && count < 10 ; count++){
            Dimension size = getDriver().manage().window().getSize();
            Map<String, PointOption> point = new HashMap<>();
            point.put("from", PointOption.point(size.getWidth() / 2, (int) (size.getHeight() * 0.80)));
            point.put("to", PointOption.point(size.getWidth() / 2, (int) (size.getHeight() * 0.30)));
            new TouchAction<>(getDriver())
                    .press(point.get("from"))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                    .moveTo(point.get("to"))
                    .release()
                    .perform();
        }
    }

    public void pressNumber(String number) {
        switch (number){
            case "0":
                getDriver().pressKey(new KeyEvent(AndroidKey.DIGIT_0));
                break;
            case "1":
                getDriver().pressKey(new KeyEvent(AndroidKey.DIGIT_1));
                break;
            case "2":
                getDriver().pressKey(new KeyEvent(AndroidKey.DIGIT_2));
                break;
            case "3":
                getDriver().pressKey(new KeyEvent(AndroidKey.DIGIT_3));
                break;
            case "4":
                getDriver().pressKey(new KeyEvent(AndroidKey.DIGIT_4));
                break;
            case "5":
                getDriver().pressKey(new KeyEvent(AndroidKey.DIGIT_5));
                break;
            case "6":
                getDriver().pressKey(new KeyEvent(AndroidKey.DIGIT_6));
                break;
            case "7":
                getDriver().pressKey(new KeyEvent(AndroidKey.DIGIT_7));
                break;
            case "8":
                getDriver().pressKey(new KeyEvent(AndroidKey.DIGIT_8));
                break;
            case "9":
                getDriver().pressKey(new KeyEvent(AndroidKey.DIGIT_9));
                break;
            default:
                getDriver().pressKey(new KeyEvent(AndroidKey.DIGIT_0));
        }
    }

    public void hideKeyboard() {
        getDriver().hideKeyboard();
    }

}
