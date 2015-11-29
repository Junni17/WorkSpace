package demo;

public class App
{
    public static void main(String[] args)
    {
        // System.out.println(App.isLeapYear(2016));
        for (int i = 1; i <= 12; i++) {
            System.out.println(i + ": " + App.monthLength(i, 2015));
        }
    }

    /**
     * Returns true, if the year is a leap year.<br />
     * Requires: year > 1582.
     */
    public static boolean isLeapYear(int year)
    {
        assert year > 1582;
        return (year % 400 == 0) || (year % 4 == 0 && year % 100 != 0);
    }

    /**
     * Returns the length of the month in the year.<br/>
     * Requires: 1 <= month <= 12 and year > 1582.<br/>
     * Note: Uses the Gregorian calendar rule for leap years.
     */
    public static int monthLength(int month, int year)
    {
        assert 1 <= month && month <= 12;
        assert year > 1582;
        int length = 31;
        if (month == 4 || month == 6 || month == 9 || month == 11) {
            length = 30;
        } else if (month == 2) {
            if (App.isLeapYear(year)) {
                length = 29;
            } else {
                length = 28;
            }
        }
        return length;
    }

}
