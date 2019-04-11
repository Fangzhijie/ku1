package com.itcast.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateforString {

    public static String dateTostring(Date date,String string){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(string);
        String format = simpleDateFormat.format(date);
        return format;
    }
    public static Date stringTodate(String date,String string) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(string);
        Date parse = simpleDateFormat.parse(date);
        return parse;
    }
}
