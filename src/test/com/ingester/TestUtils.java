package com.ingester;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ICorda on 02/08/2016.
 */
public class TestUtils {

    public static String getToStringBusStop(String code, String name, String latitude, String longitude) {

        StringBuilder returnedBusStopString = new StringBuilder();
        returnedBusStopString.append("code" + " = " + code).append(", ");
        returnedBusStopString.append("name" + " = " + name).append(", ");
        returnedBusStopString.append("latitude" + " = " + latitude).append(", ");
        returnedBusStopString.append("longitude" + " = " + longitude);

        String busStopStr = returnedBusStopString.toString();
        return busStopStr;

    }


    public static String getToStringEventType(String contractNumber, String serviceNumber, String logicalNumber) {

        StringBuilder returnedEventTypeString = new StringBuilder();
        returnedEventTypeString.append("contractNumber" + " = " + contractNumber).append(", ");
        returnedEventTypeString.append("serviceNumber" + " = " + serviceNumber).append(", ");
        returnedEventTypeString.append("logicalNumber" + " = " + logicalNumber);

        String eventTypeStr = returnedEventTypeString.toString();
        return eventTypeStr;

    }

    public String getVoFieldsToString(List<String> aList) {

        List<String> fieldsList = new ArrayList<>();
        fieldsList.addAll(aList);
        return fieldsList.toString();

    }
}
