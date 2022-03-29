package com.avis.qa.constants;

import com.avis.qa.core.Configuration;

public class AvisConstants {

    public static final String REGRESSION = "regression";
    public static final String SANITY = "sanity";
    public static final String SMOKE = "smoke";
    public static final String TEST_DATA = "testData";
    public static final String HOMEPAGE = "Homepage";
    public static final String RESERVATION = "Reservation";

    public static final String ABOVE_NINETY_ERROR_MESSAGE = "Sorry, 90 days is the maximum number of days that can be reserved.";
    public static final String ABOVE_THREE_THIRTY_ERROR_MESSAGE = "Sorry, 330 days is the maximum number of days that can be reserved online.";
    public static final String DUMMY_CC_ERROR_MESSAGE = "Please enter a valid Credit Card Number.";


    public static String getAvisUrl(String path) {
        return Configuration.URL.replace("/en/home", path);
    }

}
