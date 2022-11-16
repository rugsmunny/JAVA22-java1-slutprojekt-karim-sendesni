import java.time.LocalDate;

//Class includes methods returning Strings
//of weekdays name and date and int value of today.

public class LocalDateCalculations {

    //Filed
    final int valueOfToday = LocalDate.now().getDayOfWeek().getValue();

    //Methods
    public int getValueOfToday() {
        return valueOfToday;
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
