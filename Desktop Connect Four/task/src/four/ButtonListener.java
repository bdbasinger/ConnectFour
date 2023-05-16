package four;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

public class ButtonListener implements ActionListener {
    List<List<JButton>> horizontals;
    List<List<JButton>> verticals;
    List<List<JButton>> diagonals;
    List<List<JButton>> gameBoard;
    List<JButton> buttons;
    boolean xMove = true;

    JButton[] winningButtons = new JButton[4];

    static boolean gameIsOver;

    Map<String, Integer> columnToIndexMap = Map.of(
            "A",0,
            "B",1,
            "C",2,
            "D",3,
            "E",4,
            "F",5,
            "G",6
    );

    // Constructor
    public ButtonListener(List<List<JButton>> gameBoard, List<JButton> buttons, List<List<JButton>> horizontals, List<List<JButton>> verticals, List<List<JButton>> diagonals) {
        this.gameBoard = gameBoard;
        this.buttons = buttons;
        this.horizontals = horizontals;
        this.verticals = verticals;
        this.diagonals = diagonals;

    }

    public ButtonListener() {

    }

    // Define what happens when clicking a button on the board
    @Override
    public void actionPerformed(ActionEvent e) {
        if(!gameIsOver) {
            JButton button = (JButton) e.getSource();
            String buttonName = button.getName();
            System.out.println(buttonName + " has an index of " + buttons.indexOf(button));
            String columnLetter = (String) button.getClientProperty("Column");
            Integer indexOfColumn = columnToIndexMap.get(columnLetter);
            int indexOfRow = checkButton(indexOfColumn);
            if(xMove) {
                gameBoard.get(indexOfColumn).get(indexOfRow).setText("X");
                xMove = false;
            } else {
                gameBoard.get(indexOfColumn).get(indexOfRow).setText("O");
                xMove = true;
            }
            if((checkWin(verticals) || checkWin(horizontals) || checkWin(diagonals) )) {
            //if(checkWin(gameBoard)) {
                System.out.println("USER WON THE GAME!!!!!!!!!!!!!!!!!!!!!!!");
                for(JButton b : winningButtons) {
                    System.out.println("Winning Buttons: " + b.getName());
                    b.setBackground(Color.CYAN);
                }
                gameIsOver = true;
            }
        }
    }



    //Find the index of where the player's X or O should be placed
    public int checkButton(int index) {
        List<JButton> list = gameBoard.get(index);
        for(int i = 0; i < list.size(); i++) {
            if(Objects.equals(list.get(i).getText(), " ")) {
                return i;
            }
        }
        return 0;
    }

    public void returnGameNotOver() {
        gameIsOver = false;
    }


    /*
    After each click by the user, use the checkForAWin method
        // Buttons before sort A6 B6 C6 D6 E6 F6 G6 A5 B5
        Current Index of buttons ArrayList After Sort:
        A1 A2 A3 A4 A5 A6 B1 B2 B3 B4 B5 B6 C1 C2 C3 C4 C5 C6 D1 D2 D3 D4 D5 D6 E1 E2 E3 E4 E5 E6 F1 F2 F3 F4 F5 F6 G1 G2 G3 G4 G5 G6
        0  1  2  3  4  5  6  7  8  9  10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41
         */
    private boolean checkWin(List<List<JButton>> list) {
        int countXsInARow = 0;
        int countOsInARow = 0;

        for(int i = 0; i < list.size(); i++) {
            for(int j = 0; j < list.get(i).size(); j++) {

                if((Objects.equals(list.get(i).get(j).getText()," "))) {
                    countXsInARow = 0;
                    countOsInARow = 0;
                }

                // If this button's text == X
                if(buttonEqualsX(list.get(i).get(j))) {
                    // Set the count for O's in a row to zero
                    countOsInARow = 0;
                    //if(!(Objects.equals(list.get(i).get(j).getText()," ")))
                    winningButtons[countXsInARow] = list.get(i).get(j);
                    countXsInARow++;
                    //winningButtons[countXsInARow] = list.get(i).get(j);
                }
                else if(buttonEqualsO(list.get(i).get(j))) {
                    countXsInARow = 0;
                    //if(!(Objects.equals(list.get(i).get(j).getText()," ")))
                    winningButtons[countOsInARow] = list.get(i).get(j);
                    countOsInARow++;
                    //winningButtons[countOsInARow] = list.get(i).get(j);
                }
                if(countXsInARow == 4 || countOsInARow == 4) {
                    return true;
                }

            }
        }
        return false;
    }





        //if(doesButtonEqualX())

    private boolean buttonEqualsX(JButton b) {
        return b.getText().equals("X");
    }

    private boolean buttonEqualsO(JButton b) {
        return b.getText().equals("O");
    }





}
