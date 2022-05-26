package com.training.api;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateParser {
    static SimpleDateFormat ft;

    static  {
        ft = new SimpleDateFormat ("yyyy-MM-dd");
    }

    public static Date parseDate(String dateString) {
        try {
            return ft.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
