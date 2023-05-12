package four;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class ButtonListener implements ActionListener {
    boolean xMove = true;
    List<List<JButton>> gameBoard;
    List<JButton> buttons;

    Map<String, Integer> columnToIndexMap = Map.of(
            "A",0,
            "B",1,
            "C",2,
            "D",3,
            "E",4,
            "F",5,
            "G",6
    );



    public ButtonListener(List<List<JButton>> gameBoard, List<JButton> buttons) {
        this.gameBoard = gameBoard;
        this.buttons = buttons;

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        System.out.println(button.getClientProperty("Column"));
        String buttonName = button.getName();
        String buttonText = button.getText();
        System.out.println("button.getName() == " + buttonName);
        System.out.println("button.getText() == " + buttonText);

        String columnLetter = (String) button.getClientProperty("Column");


        Integer indexOfColumn = columnToIndexMap.get(columnLetter);


        int indexOfRow = checkButton(indexOfColumn);

        gameBoard.get(indexOfColumn).get(indexOfRow).setText("X");




        //switch (columnLetter)
        //{

        //}

        /*
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(b.getText().equals(" ")) {
                    if(xMove) {
                        b.setText("X");
                        xMove = false;
                    }
                    else {
                        b.setText("O");
                        xMove = true;
                    }
                }
            }
        });
         */


    }


    //Find the index of where the player's X or O should be placed
    public int checkButton(int index) {
        List<JButton> list = gameBoard.get(index);
        for(int i = 0; i < list.size(); i++) {
            if(Objects.equals(list.get(i).getText(), " ")) {
                return i;
            }
        }


        //for(int i = 0; i < gameBoard.get(colLetter).size();)




        return 0;

    }







}
