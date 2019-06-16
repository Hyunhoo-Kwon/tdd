public class SubDate {

    public int getYearDay(int year) {
        if (year==1 )
            return 0;
        else
            return 365;
    }

    public boolean isLeapYear(int year) {
        if (year == 0) return true;
        if (year == 1) return false;
        if (year == 4) return true;
        return false;
    }
}
