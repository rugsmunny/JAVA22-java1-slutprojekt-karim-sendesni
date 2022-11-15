import javax.swing.*;
import java.awt.*;

//Class creating panels containing weekday name and date
//for the top part of every weekDayPanel (class Calender)
public class WeekDayNameAndDatePanel {
    JLabel weekDayNameLabel;
    LocalDateCalculations localDateCalculations;
    void addDateAndWeekDayTextToPanelTop(int iterations, JPanel weekDayPanel) {

// Date evaluation for marking today date
        if (iterations == localDateCalculations.weekDayValueOfTodayDate()) {

            weekDayNameLabel = new JLabel(localDateCalculations
                    .createWeekday(iterations), SwingConstants.CENTER);

            weekDayNameLabel
                    .setOpaque(true);

            weekDayNameLabel
                    .setBackground(Color.lightGray);

            weekDayPanel
                    .add(weekDayNameLabel);

        } else {

            weekDayPanel.add(new JLabel(localDateCalculations
                    .createWeekday(iterations), SwingConstants.CENTER));
        }

        weekDayPanel.add(new JLabel(localDateCalculations
                .createWeekDates(iterations), SwingConstants.CENTER));
    }
}
