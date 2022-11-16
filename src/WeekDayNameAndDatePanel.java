import javax.swing.*;
import java.awt.*;

//Class returning  JPanels containing weekday name and date
//for the top part of every weekDayPanel (class Calender)
public class WeekDayNameAndDatePanel {

    //Field
    JLabel weekDayNameLabel, weekDayDateLabel;

    //Methods
    JLabel addWeekDayNameToPanelTop(int iterations) {

    // Date evaluation for marking today date
        if (iterations == new LocalDateCalculations().getValueOfToday()) {

            weekDayNameLabel = new JLabel(new LocalDateCalculations()
                    .createWeekday(iterations), SwingConstants.CENTER);

            weekDayNameLabel
                    .setOpaque(true);

            weekDayNameLabel
                    .setBackground(Color.lightGray);

            return weekDayNameLabel;

        } else {

            return new JLabel(new LocalDateCalculations()
                    .createWeekday(iterations), SwingConstants.CENTER);
        }
    }

    JLabel addWeekDayDateToPanelTop(int iterations) {

        weekDayDateLabel = new JLabel(new LocalDateCalculations()
                .createWeekDates(iterations), SwingConstants.CENTER);
        return weekDayDateLabel;
    }
}
