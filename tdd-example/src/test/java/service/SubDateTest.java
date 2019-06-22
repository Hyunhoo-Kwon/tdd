package service;

import exception.DateFormatException;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SubDateTest {

    private SubDate subDate;

    @Before
    public void init() {
        subDate = new SubDate();
    }

    @Test
    public void testSubDate() {
        assertThat(subDate.sub("20061231", "20070101"), is(1));
        assertThat(subDate.sub("20070101", "20070515"), is(31+28+30+31+14));
    }

    @Test
    public void testGetTotalDay() {
        assertThat(subDate.getTotalDay("00010101"), is(1));
        assertThat(subDate.getTotalDay("00020101"), is(366));
    }

    @Test(expected = DateFormatException.class)
    public void testGetTotalDayWithInvalidDate() {
        subDate.getTotalDay("20191331");
    }

    @Test
    public void testGetYearDay() {
        assertThat(subDate.getYearDay(1), is(0));
        assertThat(subDate.getYearDay(2), is(365));
        assertThat(subDate.getYearDay(5), is(365+365+365+366));
    }

    @Test
    public void testGetMonthDay() {
        assertThat(subDate.getMonthDay(3, false), is(31+28));
        assertThat(subDate.getMonthDay(3, true), is(31+29));
    }

    @Test
    public void testLeapYear() {
        assertThat(subDate.isLeapYear(0), is(true));
        assertThat(subDate.isLeapYear(1), is(false));
        assertThat(subDate.isLeapYear(4), is(true));
        assertThat(subDate.isLeapYear(1200), is(true));
        assertThat(subDate.isLeapYear(700), is(false));
    }

}
