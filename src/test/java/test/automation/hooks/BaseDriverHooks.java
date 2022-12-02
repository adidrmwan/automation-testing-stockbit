package test.automation.hooks;

import io.cucumber.java.After;
import org.springframework.beans.factory.annotation.Autowired;
import test.automation.driver.AndroidDriverPool;
import test.automation.driver.DriverPool;

import java.util.Optional;

public class BaseDriverHooks {
    @Autowired
    DriverPool driverPool;

    @Autowired
    AndroidDriverPool androidDriverPool;

    @After
    public void afterTest() {
        quitDrivers(driverPool);
    }

    public void quitDrivers(DriverPool drivers) {
        Optional.ofNullable(drivers.getAndroidDriver())
                .ifPresent(
                        driver -> {
                            driver.quit();
                            androidDriverPool.stopAppiumServer();
                            drivers.setAndroidDriver(null);
                        });
    }
}