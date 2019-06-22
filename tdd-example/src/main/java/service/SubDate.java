package service;

import exception.DateFormatException;

public class SubDate {

    static final int[] monthDays = {
            31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public int sub(String date1, String date2) throws DateFormatException {
        return Math.abs(getTotalDay(date1) - getTotalDay(date2));
    }

    public int getTotalDay(String date) {
        int year = Integer.parseInt(date.substring(0, 4));
        int month = Integer.parseInt(date.substring(4, 6));
        int day = Integer.parseInt(date.substring(6, 8));

        if(year<0)
            throw new DateFormatException("Invalid year");
        if(month<0 || month>12)
            throw new DateFormatException("Invalid month");
        if(day<0)
            throw new DateFormatException("Invalid day");

        return getYearDay(year)
                + getMonthDay(month, isLeapYear(year))
                + day;
    }

    public int getYearDay(int year) {
        int result = 0;
        for(int i=1; i<year; i++) {
            if (isLeapYear(i))
                result += 366;
            else
                result += 365;
        }
        return result;
    }

    public int getMonthDay(int month, boolean isLeap) {
        int result = 0;
        for(int i=1; i< month; i++) {
            result += monthDays[i-1];
        }

        if (isLeap && month > 2)
            result += 1;
        return result;
    }

    public boolean isLeapYear(int year) {
        if (year % 400 == 0)
            return true;
        if (year % 100 == 0)
            return false;
        if (year % 4 == 0)
            return true;
        return false;
    }
}
