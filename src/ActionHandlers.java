import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

//Class for handling actions - for now it handles:
//Click-actions: addEventButton (class Calender), deleteEventButton (class Calender)
//Focus-actions: eventInputTextfield (class Calender)
public class ActionHandlers {

    //Field
    String textFieldForNewCalendarEventInput;
    boolean inputTextFieldFocusIndicated = false;

    //Methods
    void addEventButtonListener(JButton addEventButton, JPanel weekDayPanel) {

        addEventButton.addActionListener(e -> {

            for (Component weekDayPanelComponent : weekDayPanel.getComponents()) {

                if (weekDayPanelComponent instanceof JTextField &&
                        checkIfInputTextfieldContainsNewInput(weekDayPanelComponent)) {

                    ((JTextField) weekDayPanelComponent).setText(textFieldForNewCalendarEventInput);

                    textFieldForNewCalendarEventInput = "";

                    break;
                }
            }
        });
    }

    boolean checkIfInputTextfieldContainsNewInput(Component text) {

        return ((JTextField) text).getText().equalsIgnoreCase("");
    }

    void deleteEventButtonListener(JButton deleteEventButton, JPanel weekDayPanel) {

        deleteEventButton.addActionListener(e -> {

                    for (Component text : weekDayPanel.getComponents()) {

                        if (text instanceof JTextField && checkIfTextfieldContainsText(text)) {

                            ((JTextField) text).setText("");
                            break;
                        }
                    }
                });
    }
    //
    boolean checkIfTextfieldContainsText(Component text) {

        return ((JTextField) text).getText().length() > 0 &&
                !((JTextField) text).getText().equalsIgnoreCase("Add an event");
    }


    //FocusListener for JTextField used for event input
    void inputTextFieldFocusAction(JTextField inputTextField) {

        inputTextField.addFocusListener(new FocusAdapter() {
            //Placeholder 'Add an event' removed when textField is in focus
            public void focusGained(FocusEvent e) {

                        if (!inputTextFieldFocusIndicated) {

                            inputTextField.setText("");

                            inputTextFieldFocusIndicated = true;
                        }
                    }
            //Placeholder 'Add an event' returned when textField is out of focus
            public void focusLost(FocusEvent e) {

                        textFieldForNewCalendarEventInput = inputTextField.getText();

                        inputTextFieldFocusIndicated = false;

                        inputTextField.setText("Add an event");

                        inputTextField.revalidate();
                    }
                });

    }
}
