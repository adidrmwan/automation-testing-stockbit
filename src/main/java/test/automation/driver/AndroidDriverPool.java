package test.automation.driver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import lombok.Data;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.automation.properties.ConfigProperties;
import test.automation.properties.DriverAndroidProperties;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.concurrent.TimeUnit;

@Data
@Service
public class AndroidDriverPool {
    @Autowired
    DriverAndroidProperties driverAndroidProperties;

    @Autowired
    ConfigProperties configProperties;

    private AppiumDriverLocalService service;
    private AppiumServiceBuilder builder;

    public AndroidDriver create() {
        startAppiumServer();

        AndroidDriver<AndroidElement> driver = null;
        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability(AndroidMobileCapabilityType.PLATFORM_NAME, driverAndroidProperties.getPlatformName());
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, driverAndroidProperties.getDeviceName());
        caps.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, driverAndroidProperties.isAutoGrantPermissions());
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, driverAndroidProperties.getAutomationName());
        caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, configProperties.getAndroid().getAppPackage());
        caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, configProperties.getAndroid().getAppActivity());
        caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 100);
        caps.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir") + File.separator + configProperties.getAndroid().getAppPath());

        driver = new AndroidDriver<AndroidElement>(service.getUrl(), caps);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        return driver;
    }

    public void startAppiumServer() {
        builder = new AppiumServiceBuilder();
        builder.withIPAddress("127.0.0.1");
        builder.usingPort(getAvailablePort());
        builder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
        builder.withArgument(GeneralServerFlag.LOG_LEVEL,"error");

        //Start the server with the builder
        service = AppiumDriverLocalService.buildService(builder);
        service.start();
    }

    public static int getAvailablePort() {
        int port = 4723;

        try {
            ServerSocket serverSocket = new ServerSocket(0);
            port = serverSocket.getLocalPort();
            serverSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return port;
    }

    public void stopAppiumServer() {
        service.stop();
    }
}
