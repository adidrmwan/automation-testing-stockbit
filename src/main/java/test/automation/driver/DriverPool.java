package test.automation.driver;

import io.appium.java_client.android.AndroidDriver;
import lombok.Data;
import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Data
@Component("test.automation.driver.DriverPool")
public class DriverPool {
    private HashMap<String, AndroidDriver> android = new HashMap<>();
    private HashMap<String, WebDriver> web = new HashMap<>();

    public AndroidDriver getAndroidDriver() {
        return this.android.get(Thread.currentThread().getName());
    }

    public void setAndroidDriver(AndroidDriver androidDriver) {
        this.android.put(Thread.currentThread().getName(), androidDriver);
    }
}
