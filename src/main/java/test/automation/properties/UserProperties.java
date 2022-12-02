package test.automation.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@EnableConfigurationProperties({
        UserProperties.class
})

@ConfigurationProperties(prefix = "user")
public class UserProperties {
    private String username;
    private String password;
}
