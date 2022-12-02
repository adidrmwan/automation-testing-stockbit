package test.automation.data.api;

import test.automation.data.Customer;

public class Beers {

    private static String page;
    private static String dataPerPage;

    public static String getPage() {
        return page;
    }
    public static void setPage(String page) {
        Beers.page = page;
    }

    public static String getDataPerPage() {
        return dataPerPage;
    }
    public static void setDataPerPage(String dataPerPage) {
        Beers.dataPerPage = dataPerPage;
    }
}
