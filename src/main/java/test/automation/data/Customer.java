package test.automation.data;

public class Customer {
    private static String fullname;
    private static String addressLine1;
    private static String addressLine2;
    private static String city;
    private static String stateRegion;
    private static String zipCode;
    private static String country;

    public static String getFullname() {
        return fullname;
    }
    public static void setFullname(String fullname) {
        Customer.fullname = fullname;
    }

    public static String getAddressLine1() {
        return addressLine1;
    }
    public static void setAddressLine1(String addressLine1) {
        Customer.addressLine1 = addressLine1;
    }

    public static String getAddressLine2() {
        return addressLine2;
    }
    public static void setAddressLine2(String addressLine2) {
        Customer.addressLine2 = addressLine2;
    }

    public static String getCity() {
        return city;
    }
    public static void setCity(String city) {
        Customer.city = city;
    }

    public static String getStateRegion() {
        return stateRegion;
    }
    public static void setStateRegion(String stateRegion) {
        Customer.stateRegion = stateRegion;
    }

    public static String getZipCode() {
        return zipCode;
    }
    public static void setZipCode(String zipCode) {
        Customer.zipCode = zipCode;
    }

    public static String getCountry() {
        return country;
    }
    public static void setCountry(String country) {
        Customer.country = country;
    }
}
