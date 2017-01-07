package com.example.jeremy.urbanflow.Utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Jeremy on 19/06/2016.
 */
public class DateUtils {

    public static Date strToDate(String date)
    {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        try {
            return format.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return null;
    }

}
