package test.automation.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@EnableConfigurationProperties({
        DriverAndroidProperties.class
})

@ConfigurationProperties(prefix = "driver.mobile.android.capabilities")
public class DriverAndroidProperties {
    private String platformName;
    private String deviceName;
    private String appiumUrl;
    private String app;
    private boolean autoGrantPermissions;
    private String automationName;
}
