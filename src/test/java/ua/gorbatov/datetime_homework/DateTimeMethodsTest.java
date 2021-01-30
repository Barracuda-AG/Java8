package ua.gorbatov.datetime_homework;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Year;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DateTimeMethodsTest {
    private DateTimeMethods dateTimeMethods;
    private List<String> fridays13Expected;
    private List<YearMonth> endOnSundaysExpected;
    private List<Year> birthdaysOnSaturdaysExpected;

    @BeforeEach
    void setUp(){
        dateTimeMethods = new DateTimeMethods();
        fridays13Expected =  new ArrayList<>();
        fridays13Expected.add("Oct 2000");
        fridays13Expected.add("Apr 2001");
        fridays13Expected.add("Jul 2001");
        fridays13Expected.add("Sep 2002");
        fridays13Expected.add("Dec 2002");
        fridays13Expected.add("Jun 2003");
        fridays13Expected.add("Feb 2004");
        fridays13Expected.add("Aug 2004");
        fridays13Expected.add("May 2005");
        fridays13Expected.add("Jan 2006");
        fridays13Expected.add("Oct 2006");
        fridays13Expected.add("Apr 2007");
        fridays13Expected.add("Jul 2007");
        fridays13Expected.add("Jun 2008");
        fridays13Expected.add("Feb 2009");
        fridays13Expected.add("Mar 2009");
        fridays13Expected.add("Nov 2009");
        fridays13Expected.add("Aug 2010");
        fridays13Expected.add("May 2011");
        fridays13Expected.add("Jan 2012");
        fridays13Expected.add("Apr 2012");
        fridays13Expected.add("Jul 2012");
        fridays13Expected.add("Sep 2013");
        fridays13Expected.add("Dec 2013");
        fridays13Expected.add("Jun 2014");
        fridays13Expected.add("Feb 2015");
        fridays13Expected.add("Mar 2015");
        fridays13Expected.add("Nov 2015");
        fridays13Expected.add("May 2016");
        fridays13Expected.add("Jan 2017");
        fridays13Expected.add("Oct 2017");
        fridays13Expected.add("Apr 2018");
        fridays13Expected.add("Jul 2018");
        fridays13Expected.add("Sep 2019");
        fridays13Expected.add("Dec 2019");
        fridays13Expected.add("Mar 2020");
        fridays13Expected.add("Nov 2020");

        endOnSundaysExpected = new ArrayList<>();
        endOnSundaysExpected.add(YearMonth.of(2000, 4));
        endOnSundaysExpected.add(YearMonth.of(2000, 12));
        endOnSundaysExpected.add(YearMonth.of(2001, 9));
        endOnSundaysExpected.add(YearMonth.of(2002, 3));
        endOnSundaysExpected.add(YearMonth.of(2002, 6));
        endOnSundaysExpected.add(YearMonth.of(2003, 8));
        endOnSundaysExpected.add(YearMonth.of(2003, 11));
        endOnSundaysExpected.add(YearMonth.of(2004, 2));
        endOnSundaysExpected.add(YearMonth.of(2004, 10));
        endOnSundaysExpected.add(YearMonth.of(2005, 7));
        endOnSundaysExpected.add(YearMonth.of(2006, 4));
        endOnSundaysExpected.add(YearMonth.of(2006, 12));
        endOnSundaysExpected.add(YearMonth.of(2007, 9));
        endOnSundaysExpected.add(YearMonth.of(2008, 8));
        endOnSundaysExpected.add(YearMonth.of(2008, 11));
        endOnSundaysExpected.add(YearMonth.of(2009, 5));
        endOnSundaysExpected.add(YearMonth.of(2010, 1));
        endOnSundaysExpected.add(YearMonth.of(2010, 2));
        endOnSundaysExpected.add(YearMonth.of(2010, 10));
        endOnSundaysExpected.add(YearMonth.of(2011, 7));
        endOnSundaysExpected.add(YearMonth.of(2012, 9));
        endOnSundaysExpected.add(YearMonth.of(2013, 3));
        endOnSundaysExpected.add(YearMonth.of(2013, 6));
        endOnSundaysExpected.add(YearMonth.of(2014, 8));
        endOnSundaysExpected.add(YearMonth.of(2014, 11));
        endOnSundaysExpected.add(YearMonth.of(2015, 5));
        endOnSundaysExpected.add(YearMonth.of(2016, 1));
        endOnSundaysExpected.add(YearMonth.of(2016, 7));
        endOnSundaysExpected.add(YearMonth.of(2017, 4));
        endOnSundaysExpected.add(YearMonth.of(2017, 12));
        endOnSundaysExpected.add(YearMonth.of(2018, 9));
        endOnSundaysExpected.add(YearMonth.of(2019, 3));
        endOnSundaysExpected.add(YearMonth.of(2019, 6));
        endOnSundaysExpected.add(YearMonth.of(2020, 5));
       // endOnSundaysExpected.add(YearMonth.of(2021, 1));

        birthdaysOnSaturdaysExpected = new ArrayList<>();
        birthdaysOnSaturdaysExpected.add(Year.of(1993));
        birthdaysOnSaturdaysExpected.add(Year.of(1999));
        birthdaysOnSaturdaysExpected.add(Year.of(2004));
        birthdaysOnSaturdaysExpected.add(Year.of(2010));

    }
    @Test
    void fridays13() {
        List<String> actual = dateTimeMethods.fridays13();
        assertEquals(fridays13Expected.size(), actual.size());
        assertTrue(actual.containsAll(fridays13Expected));
    }

    @Test
    void endOnSundays() {
        List<YearMonth> actual = dateTimeMethods.endOnSundays();
        assertEquals(endOnSundaysExpected.size(), actual.size());
        assertTrue(actual.containsAll(endOnSundaysExpected));
    }

    @Test
    void birthdaysOnSaturdays() {
        LocalDate birthDay = LocalDate.of(1990, 6, 12);
        List<Year> actual = dateTimeMethods.birthdaysOnSaturdays(birthDay);
        assertTrue(actual.containsAll(birthdaysOnSaturdaysExpected));

    }
}