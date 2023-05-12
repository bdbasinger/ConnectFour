package four;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;


/*
Your program should display an empty game board as described below.
The main Connect4 class should extend the JFrame class, set its title as Connect Four, and exit on close;
The cells should extend the JButton class. Hint: Set the painted focus to false to remove the highlighting on the clicked cells;
Create 6 rows and 7 columns on the board;
Each cell should be visible and display the row and column as its label. For example, A1, G6;
Each cell should be named Button** where ** is the row and column designation in the label;
Organize rows and columns as shown in the example below.
 */

public class ConnectFour extends JFrame {
    List<JButton> buttons = new ArrayList<>();

    String[] pieces = {
            "A6","B6","C6","D6","E6","F6","G6",
            "A5","B5","C5","D5","E5","F5","G5",
            "A4","B4","C4","D4","E4","F4","G4",
            "A3","B3","C3","D3","E3","F3","G3",
            "A2","B2","C2","D2","E2","F2","G2",
            "A1","B1","C1","D1","E1","F1","G1"};

    String[] letters = {
            "A","B","C","D","E","F","G",
            "A","B","C","D","E","F","G",
            "A","B","C","D","E","F","G",
            "A","B","C","D","E","F","G",
            "A","B","C","D","E","F","G",
            "A","B","C","D","E","F","G"};

    public ConnectFour() {
        setTitle("Connect Four");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 800);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(6,7,5,5));

        // For Every array element in pieces array, do the following:
        for (String piece : pieces) {
            //Create new JButton b and set its text equal to " "
            JButton b = new JButton(" ");
            //Set the name to ButtonA6 ......... ButtonG1
            b.setName("Button" + piece);
            b.setFocusPainted(false);
            //Add the JButton I'm working with to the buttons ArrayList
            buttons.add(b);
            //Add the JButton to the layout
            add(b);
        }
        setVisible(true);

        List<List<JButton>> gameBoard = new ArrayList<>();

        for(int i = 0; i < buttons.size(); i++) {
            buttons.get(i).putClientProperty("Column",letters[i]);
        }


        //Sort the buttons
        buttons.sort(Comparator.comparing(JButton::getName));
        //ButtonA1 ButtonA2 ButtonA3 ButtonA4 ButtonA5 ButtonA6 ButtonB1 ButtonB2...



        List<JButton> aColumn = new ArrayList<>(buttons.subList(0,6));   // A
        List<JButton> bColumn = new ArrayList<>(buttons.subList(6,12));  // B
        List<JButton> cColumn = new ArrayList<>(buttons.subList(12,18)); // C
        List<JButton> dColumn = new ArrayList<>(buttons.subList(18,24)); // D
        List<JButton> eColumn = new ArrayList<>(buttons.subList(24,30)); // E
        List<JButton> fColumn = new ArrayList<>(buttons.subList(30,36)); // F
        List<JButton> gColumn = new ArrayList<>(buttons.subList(36,42)); // G

        int indexOne = 0;
        int indexTwo = 6;



        gameBoard.add(aColumn);
        gameBoard.add(bColumn);
        gameBoard.add(cColumn);
        gameBoard.add(dColumn);
        gameBoard.add(eColumn);
        gameBoard.add(fColumn);
        gameBoard.add(gColumn);



        ButtonListener buttonListener = new ButtonListener(gameBoard, buttons);

        /*
        for(int i=0; i< buttons.size(); i++) {
            buttons.get(i).putClientProperty("Column", "A");

        }

         */


        /*
        for(char letter = 'A'; letter <= 'G'; letter++) {
            //b.putClientProperty();
            //buttons.get(i).putClientProperty("Column", "A");
        }
         */









        for(JButton b : buttons) {
            b.addActionListener(buttonListener);
        }


/*
        //Iterates and Prints out contents of both JButton ArrayLists
        for (JButton button : buttons) {
            System.out.println("buttons: " + button.getName());
        }


 */


        for (List<JButton> jButton : gameBoard) {
            for (int j = 0; j < gameBoard.get(0).size(); j++) {
                System.out.println(jButton.get(j).getName());
                System.out.println("Column: " + "A B C D E F G");
            }
            System.out.println("---------------------------------------------");
        }


        /*
        for (JButton sortedButton : sortedButtons) {
            System.out.println("sortedButtons: " + sortedButton.getName());
        }
         */


        /*

        Iterate through the sortedButtons ArrayList

        When user clicks on any box located in the ArrayList
        Determine the column that was clicked

        If user clicks on the aColumn

        Iterate through the sortedButtons ArrayList
        starting at the bottom which would be A1
        all the way through A6
        checking whether JButton button.getText() equals " "

        For the first instance of a button that returns " " from getText,
        set that Button's text to the current user's piece, an X or an O

         */



    }















}