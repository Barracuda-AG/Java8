package ua.gorbatov.datetime_homework;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class DateTimeMethods {
    /**
     *Список месяцев, в которых есть пятница 13-е. От 2000 года до сегодня.
     * Метод: List<String> fridays13() , где String имеет формат “MMM yyyy”, например
     * “Jul 2013”, список упорядочен по возрастанию дат.
     * @return List<String> with results
     */
    List<String> fridays13() {
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
         * Метод: List<YearMonth> endOnSundays() , список упорядочен по возрастанию
         * дат.
         */
        List<YearMonth> endOnSundays(){
            List<YearMonth> result = new ArrayList<>();
            YearMonth now = YearMonth.now();
            YearMonth start = YearMonth.of(2000, Month.JANUARY);

            while(start.isBefore(now)){
                if(start.atEndOfMonth().getDayOfWeek().equals(DayOfWeek.SUNDAY)) {
                    result.add(start);
                }
                start = start.plusMonths(1);
            }
            return result;
        }
    /**
     * 3. Список годов, когда заданный день рождения попадает на субботу. От даты
     * рождения до сегодня.
     * Метод: List<Year> birthdaysOnSaturdays(LocalDate birthday) , список годов
     * упорядочен по возрастанию.
     */
    List<Year> birthdaysOnSaturdays(LocalDate birthday){
        List<Year> result = new ArrayList<>();
        LocalDate start = birthday;
        LocalDate now = LocalDate.now();
        while (start.isBefore(now)){
            if(start.getDayOfWeek().equals(DayOfWeek.SATURDAY)){
                result.add(Year.of(start.getYear()));
            }
            start = start.plusYears(1);
        }
        return result;
    }
}
