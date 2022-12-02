package test.automation.pages.android;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.springframework.stereotype.Component;
import test.automation.pageobject.AndroidPageObject;

@Component("test.automation.pages.android.SideBarScreen")
public class SideBarScreen extends AndroidPageObject {

    private By breadcrumbs() {
        return MobileBy.id("menuIV");
    }
    private By catalogMenu() {
        return MobileBy.id("menuIV");
    }
    private By webviewMenu() {
        return MobileBy.id("menuIV");
    }
    private By QRCodeScannerMenu() {
        return MobileBy.id("menuIV");
    }
    private By geoLocationMenu() {
        return MobileBy.id("menuIV");
    }
    private By drawingMenu() {
        return MobileBy.id("menuIV");
    }
    private By aboutMenu() {
        return MobileBy.id("menuIV");
    }
    private By fingerPrintMenu() {
        return MobileBy.id("menuIV");
    }

    private By loginMenu() {
        return MobileBy.xpath("(//*[contains(@resource-id, 'menuRV')]/descendant::android.view.ViewGroup)[12]");
    }
}
