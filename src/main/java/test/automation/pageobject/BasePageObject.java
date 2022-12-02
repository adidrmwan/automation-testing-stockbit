package test.automation.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Locatable;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import test.automation.driver.AndroidDriverPool;
import test.automation.driver.DriverPool;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class BasePageObject {
    @Autowired
    DriverPool driver;

    @Autowired
    AndroidDriverPool androidDriverPool;

    public WebDriver getDriver() {
        if (this.driver.getAndroidDriver() == null) {
            this.driver.setAndroidDriver(this.androidDriverPool.create());
        }
        return this.driver.getAndroidDriver();
    }

    public WebDriverWait onWait(int timeout) {
        return new WebDriverWait(getDriver(), timeout);
    }

    public WebElement waitUntilClickable(By by) {
        return onWait(15).until(ExpectedConditions.elementToBeClickable(by));
    }

    public WebElement waitUntilPresence(By by) {
        return onWait(15).until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public List<WebElement> waitUntilPresences(By by) {
        return onWait(15).until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }

    public WebElement waitUntilVisible(By by) {
        return onWait(15).until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public List<WebElement> waitUntilVisibles(By by) {
        return onWait(15).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }

    public void onClick(By by) {
        waitUntilClickable(by).click();
    }

    public void onType(By by, CharSequence... keysToSend) {
        waitUntilPresence(by).sendKeys(keysToSend);
    }

    public void clear(By by) {
        waitUntilPresence(by).clear();
    }

    public boolean isElementInvisible(By by) {
        return onWait(5).until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    public boolean isElementDisplayed(By by, int timeout) {
        int screenHeight = getDriver().manage().window().getSize().getHeight();
        boolean isElementFound = false;
        int yPosition = 0;
        int i = 0;

        while(i < timeout * 5) {
            try {
                yPosition = (getDriver().findElement(by)).getLocation().getY();
                isElementFound = true;
                break;
            } catch (Exception var8) {
                this.getDriver().manage().timeouts().implicitlyWait(200, TimeUnit.MILLISECONDS);
                ++i;
            }
        }

        if (isElementFound) {
            return screenHeight >= yPosition;
        } else {
            return false;
        }
    }

    public void scrollTo(By by) {
        Locatable l = ((Locatable) this.waitUntilPresence(by));
        l.getCoordinates().inViewPort();
    }

    protected void delay(int milliseconds) {
        try {
            Thread.sleep((long)milliseconds);
        } catch (InterruptedException var3) {
            var3.printStackTrace();
        }
    }
}
