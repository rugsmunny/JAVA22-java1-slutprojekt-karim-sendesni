import javax.swing.*;
import java.awt.*;
import static java.awt.Color.*;

//Creating Calendar GUI components and layout
public class Calender extends JFrame {
    ImageIcon calenderLogo;
    JPanel weekDayPanel;
    JTextField eventOutputTextField, eventInputTextfield;
    WeekDayNameAndDatePanel weekDayNameAndDatePanelSetter;
    JButton addEventButton, deleteEventButton;
    ActionHandlers action;

    Calender() {

        calenderLogo = new ImageIcon("calender_icon.png");

        super.setIconImage(calenderLogo.getImage());

        super.setTitle("Calendar");

        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        super.setLayout(new GridLayout());

        createCalenderLayout();

        super.pack();

        super.setSize(1200, 900);

        super.setVisible(true);
    }

    void createCalenderLayout() {

        for (int iterations = 1; iterations < 8; iterations++) {

            weekDayPanel = new JPanel();

            weekDayPanel.setBackground(WHITE);

            weekDayPanel.setLayout(new GridLayout(12, 1));

            weekDayNameAndDatePanelSetter
                    .addDateAndWeekDayTextToPanelTop(iterations, weekDayPanel);

            for (int j = 0; j < 7; j++) {

                weekDayPanel.add(eventOutputTextfields());
            }

            weekDayPanel.add(eventInputTextField());

            weekDayPanel.add(addEventButton(weekDayPanel));

            weekDayPanel.add(deleteEventButton(weekDayPanel));

            super.add(weekDayPanel);

        }
    }

    JTextField eventOutputTextfields() {

        eventOutputTextField = new JTextField("");

        eventOutputTextField
                .setHorizontalAlignment(SwingConstants.CENTER);

        eventOutputTextField.setEditable(false);

        eventOutputTextField
                .setBorder(BorderFactory.createLineBorder(BLACK));

        eventOutputTextField.setBackground(WHITE);

        eventOutputTextField.revalidate();

        eventOutputTextField.setVisible(true);

        return eventOutputTextField;
    }

    JTextField eventInputTextField() {

        eventInputTextfield = new JTextField("Add an event");

        eventInputTextfield.setHorizontalAlignment(JTextField.CENTER);

        action.inputTextFieldFocusAction(eventInputTextfield);

        return eventInputTextfield;
    }

    JButton addEventButton(JPanel weekDayPanel) {

        addEventButton = new JButton("Add");

        action.addEventButtonListener(addEventButton, weekDayPanel);

        return addEventButton;
    }

    JButton deleteEventButton(JPanel weekDayPanel) {

        deleteEventButton = new JButton("Delete");

        action.deleteEventButtonListener(deleteEventButton, weekDayPanel);

        return deleteEventButton;
    }
}
