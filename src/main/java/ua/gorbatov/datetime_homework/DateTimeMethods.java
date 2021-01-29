package ua.gorbatov.datetime_homework;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
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
    List<String> fridays13(){
        List<String> result = new ArrayList<>();
        LocalDate now = LocalDate.now();
        LocalDate start = LocalDate.of(2000, Month.JANUARY, 1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM yyyy", Locale.ENGLISH);

       while(start.isBefore(now)){
            if(start.getDayOfWeek() == DayOfWeek.FRIDAY && start.getDayOfMonth() == 13) {
                result.add(formatter.format(start));
            }
            start = start.plusDays(1);
        }
        return result;
    }
}
