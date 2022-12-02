package test.automation.utils;

import com.github.javafaker.Faker;

public class FakerUtil {
    private static Faker faker = new Faker();

    public static String getFakeName() {
        return faker.name().fullName();
    }

    public static String getFakeAccountNumber() {
        return faker.number().digits(12);
    }

    public static String getExpiredCard() { return faker.number().digits(4);}

    public static String getSecurityNumberCard() { return faker.number().digits(3);}

    public static String getFakeAddress() {
        return faker.address().fullAddress();
    }

    public static String getFakeCity() {
        return faker.address().city();
    }

    public static String getFakeState() {
        return faker.address().state();
    }

    public static String getFakeZipCode() {
        return faker.address().zipCode();
    }

    public static String getFakeCountry() {
        return faker.address().country();
    }

    public static String getChuckNorrisFact() {
        return faker.chuckNorris().fact();
    }

    public static String getFakeEmail() {
        return faker.internet().emailAddress();
    }


    public static String getFakePhoneNumber(String prefix, int digits) {
        return prefix + faker.number().digits(digits);
    }
}
