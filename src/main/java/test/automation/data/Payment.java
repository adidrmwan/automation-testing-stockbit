package test.automation.data;

public class Payment {
    private static String cardNumber;
    private static String expirationDate;
    private static String securityCode;

    public static String getCardNumber() { return cardNumber; }
    public static void setCardNumber(String cardNumber) {
        Payment.cardNumber = cardNumber;
    }

    public static String getExpirationDate() {
        return expirationDate;
    }
    public static void setExpirationDate(String expirationDate) {
        Payment.expirationDate = expirationDate;
    }

    public static String getSecurityCode() {
        return securityCode;
    }
    public static void setSecurityCode(String securityCode) {
        Payment.securityCode = securityCode;
    }
}
