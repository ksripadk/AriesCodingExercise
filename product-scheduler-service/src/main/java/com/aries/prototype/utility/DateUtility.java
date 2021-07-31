package com.aries.prototype.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

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

    public static List<String> getEmailDates(String startDate, String expDate, String prodName)
    {
        List<String> dateList = new ArrayList<String>();
        if (prodName.equals(ProductTypeConstants.DOMAIN)) {
            dateList.add(getEmailDate(expDate, -2));
        }
        else if (prodName.equals(ProductTypeConstants.HOSTING)) {
            dateList.add(getEmailDate(startDate, 1));
            dateList.add(getEmailDate(expDate, -3));
        }
        else if (prodName.equals(ProductTypeConstants.PDOMAIN)) {
            dateList.add(getEmailDate(expDate, -9));
            dateList.add(getEmailDate(expDate, -2));
        }

        return dateList;
    }

    public static String getEmailDate(String date, int days)
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        try {
            c.setTime(sdf.parse(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        c.add(Calendar.DATE, days);  // number of days to add
        date = sdf.format(c.getTime());
        return date;
    }
}
