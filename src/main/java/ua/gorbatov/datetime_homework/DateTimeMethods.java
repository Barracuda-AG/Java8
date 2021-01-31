package ua.gorbatov.datetime_homework;


import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class DateTimeMethods {
    /**
     * Список месяцев, в которых есть пятница 13-е. От 2000 года до сегодня.
     * Метод: List<String> fridays13() , где String имеет формат “MMM yyyy”
     */
    public List<String> fridays13() {
        List<String> result = new ArrayList<>();
        LocalDate now = LocalDate.now();
        LocalDate start = LocalDate.of(2000, Month.JANUARY, 1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM yyyy", Locale.ENGLISH);

        while (start.isBefore(now)) {
            if (start.getDayOfWeek() == DayOfWeek.FRIDAY && start.getDayOfMonth() == 13) {
                result.add(formatter.format(start));
            }
            start = start.plusDays(1);
        }
        return result;
    }

    /**
     * 2. Список месяцев, которые заканчиваются в воскресенье. От 2000 года до
     * сегодня.
     */
    public List<YearMonth> endOnSundays() {
        List<YearMonth> result = new ArrayList<>();
        YearMonth now = YearMonth.now();
        YearMonth start = YearMonth.of(2000, Month.JANUARY);

        while (start.isBefore(now)) {
            if (start.atEndOfMonth().getDayOfWeek().equals(DayOfWeek.SUNDAY)) {
                result.add(start);
            }
            start = start.plusMonths(1);
        }
        return result;
    }

    /**
     * 3. Список годов, когда заданный день рождения попадает на субботу. От даты
     * рождения до сегодня.
     */
    public List<Year> birthdaysOnSaturdays(LocalDate birthday) {
        List<Year> result = new ArrayList<>();
        LocalDate start = birthday;
        LocalDate now = LocalDate.now();
        while (start.isBefore(now)) {
            if (start.getDayOfWeek().equals(DayOfWeek.SATURDAY)) {
                result.add(Year.of(start.getYear()));
            }
            start = start.plusYears(1);
        }
        return result;
    }

    /**
     * 4. Для заданного года найти дни, когда количество часов не равно 24.
     * Метод: List<MothDay> daysNotWith24Hours(Year year) , список по
     * возрастанию.
     */
    public List<MonthDay> daysNotWith24Hours(Year year) {
        List<MonthDay> result = new ArrayList<>();
        //for Europe/Helsinki ZoneId
        ZonedDateTime start = ZonedDateTime.of(year.getValue(), 1, 1, 0, 0, 0, 0, ZoneId.of("Europe/Helsinki"));
        //for current ZoneId
        //ZonedDateTime start = ZonedDateTime.of(year.getValue(), 1,1,0,0,0,0,ZoneId.systemDefault());
        ZonedDateTime end = start.plusYears(1);
        while (start.isBefore(end)) {
            ZonedDateTime nextDay = start.plusDays(1);
            long hours = Duration.between(start, nextDay).toHours();
            if (hours != 24) {
                result.add(MonthDay.of(start.getMonth(), start.getDayOfMonth()));
                System.out.println(start);
            }
            start = start.plusDays(1);
        }
        return result;
    }

    /**
     * 5. Из списка тайм-зон найти зоны, где есть и нет перевода часов. А также зоны,
     * где в одни годы был, в другие - нет. Проверяем от 1900 года до сегодня.
     */
    public List<ZoneId> zonesAlwaysClockShift(List<ZoneId> zones) {
        List<ZoneId> result = new ArrayList<>();
        for (ZoneId zone : zones) {
            int years = yearsWhenClockShifted(zone);
            if (years == 121) {
                result.add(zone);
            }
        }
        return result;
    }

    public List<ZoneId> zonesNeverClockShift(List<ZoneId> zones) {
        List<ZoneId> result = new ArrayList<>();
        for (ZoneId zone : zones) {
            int years = yearsWhenClockShifted(zone);
            if (years == 0) {
                result.add(zone);
            }
        }
        return result;
    }

    public List<ZoneId> zonesChangedClockShiftRules(List<ZoneId> zones) {
        List<ZoneId> result = new ArrayList<>();
        for (ZoneId zone : zones) {
            int years = yearsWhenClockShifted(zone);
            if (years > 0 && years < 121) {
                result.add(zone);
            }
        }
        return result;
    }

    private int yearsWhenClockShifted(ZoneId zoneId) {
        Set<Year> years = new HashSet<>();
        ZonedDateTime start = ZonedDateTime.of(1900, 1, 1, 0, 0, 0, 0, zoneId);
        ZonedDateTime end = ZonedDateTime.now();
        while (start.isBefore(end)) {
            ZonedDateTime nextDay = start.plusDays(1);
            long hours = Duration.between(start, nextDay).toHours();
            if (hours != 24) {
               years.add(Year.of(start.getYear()));
            }
            start = start.plusDays(1);
        }
        return years.size();
    }
}
