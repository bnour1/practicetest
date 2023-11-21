package com.sinerji.services;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateStringParser {

    public static Date parseStringToDate(String dataString) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("MM/yyyy");
            return dateFormat.parse(dataString);
        } catch (Exception e) {
            throw new RuntimeException("Data inválida");
        }
    }

    public static String formatDateToString(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/yyyy");
        return dateFormat.format(date);
    }

}
