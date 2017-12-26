package com.heavenhr.api.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Author: Kingsley Eze.
 * Project: heavenhr
 * Date: 12/25/2017.
 */
public class DateUtils {

    /**
     * Converts string to Date Object
     * @param dateString
     * @return
     */
    public static Date parseDate(String dateString) {
        try {
            return new SimpleDateFormat("dd/MM/yyyy").parse(dateString);
        } catch (ParseException e) {
            System.out.println(e);
        }
        return null;
    }

}