package ua.gorbatov.datetime_homework;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DateTimeMethodsTest {
    private DateTimeMethods dateTimeMethods;
    private List<String> fridays13Expected;

    @BeforeEach
    void setUp(){
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


    }
    @Test
    void fridays13() {
        dateTimeMethods = new DateTimeMethods();
        List<String> actual = dateTimeMethods.fridays13();
        assertEquals(fridays13Expected.size(), actual.size());
        assertTrue(actual.containsAll(fridays13Expected));
    }
}