package four;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class ButtonListener implements ActionListener {
    boolean xMove = true;

    List<List<JButton>> gameBoard;
    List<JButton> buttons;

    List<JButton> sortedButtons;

    public ButtonListener(List<List<JButton>> gameBoard, List<JButton> buttons, List<JButton> sortedButtons) {
        this.gameBoard = gameBoard;
        this.buttons = buttons;
        this.sortedButtons = sortedButtons;

        for(JButton b : buttons) {
            //b.putClientProperty();

        }

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        String buttonName = button.getName();
        String buttonText = button.getText();
        System.out.println("button.getName() == " + buttonName);
        System.out.println("button.getText() == " + buttonText);
        //button.putClientProperty();



    }






}
