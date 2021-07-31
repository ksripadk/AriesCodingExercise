package com.aries.prototype.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateUtility {

    public static String getExpirationDate(String date, int durationMonths)
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        try {
            c.setTime(sdf.parse(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        c.add(Calendar.MONTH, durationMonths);  // number of months to add
        date = sdf.format(c.getTime());
        return date;
    }
}
