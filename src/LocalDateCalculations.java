import java.time.LocalDate;

//Class includes methods returning Strings
//of weekdays name and date.

public class LocalDateCalculations {

    int weekDayValueOfTodayDate(){

        return LocalDate.now().getDayOfWeek().getValue();
    }

    String createWeekday(int i){

        return  String.valueOf((LocalDate.now().getDayOfWeek())
                .minus(LocalDate.now().getDayOfWeek().getValue()).plus(i));
    }

    String createWeekDates(int i){

        return  String.valueOf((LocalDate.now()
                .minusDays(LocalDate.now().getDayOfWeek().getValue() - (i))));
    }
}
