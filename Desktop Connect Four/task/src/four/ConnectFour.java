package four;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;
import four.ApplicationRunner;


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

    List<List<JButton>> gameBoard = new ArrayList<>();

    List<List<JButton>> diagonals = new ArrayList<>();

    List<List<JButton>> horizontals = new ArrayList<>();

    List<List<JButton>> verticals = new ArrayList<>();

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
            b.setBackground(Color.red);
            b.setBorderPainted(false);
            b.setOpaque(true);
            b.setFocusPainted(false);

            //Add the JButton I'm working with to the buttons ArrayList
            buttons.add(b);
            //Add the JButton to the layout
            add(b);
        }
        setVisible(true);

        for(int i = 0; i < buttons.size(); i++) {
            buttons.get(i).putClientProperty("Column", letters[i]);
        }

        //Horizontal Lists
        List<JButton> a6Row = new ArrayList<>(buttons.subList(0,7));    // A6-G6
        List<JButton> a5Row = new ArrayList<>(buttons.subList(7,14));   // A5-G5
        List<JButton> a4Row = new ArrayList<>(buttons.subList(14,21));  // A4-G4
        List<JButton> a3Row = new ArrayList<>(buttons.subList(21,28));  // A3-G3
        List<JButton> a2Row = new ArrayList<>(buttons.subList(28,35));  // A2-G2
        List<JButton> a1Row = new ArrayList<>(buttons.subList(35,42));  // A1-G1

        horizontals.add(a1Row);
        horizontals.add(a2Row);
        horizontals.add(a3Row);
        horizontals.add(a4Row);
        horizontals.add(a5Row);
        horizontals.add(a5Row);
        horizontals.add(a6Row);


        /*
        for(JButton b : buttons){
            String[] pieces = {
                    "A6","B6","C6","D6","E6","F6","G6",
                    "A5","B5","C5","D5","E5","F5","G5",
                    "A4","B4","C4","D4","E4","F4","G4",
                    "A3","B3","C3","D3","E3","F3","G3",
                    "A2","B2","C2","D2","E2","F2","G2",
                    "A1","B1","C1","D1","E1","F1","G1"};
            System.out.println("Button " + b.getName() + " has index of " + buttons.indexOf(b));
        }
         */
        /*
        // Buttons before sort A6 B6 C6 D6 E6 F6 G6 A5 B5
        Current Index of buttons ArrayList After Sort:
        A1 A2 A3 A4 A5 A6 B1 B2 B3 B4 B5 B6 C1 C2 C3 C4 C5 C6 D1 D2 D3 D4 D5 D6 E1 E2 E3 E4 E5 E6 F1 F2 F3 F4 F5 F6 G1 G2 G3 G4 G5 G6
        0  1  2  3  4  5  6  7  8  9  10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41

         */










        //Sort the buttons
        buttons.sort(Comparator.comparing(JButton::getName));
        //Buttons after sorting
        //ButtonA1 ButtonA2 ButtonA3 ButtonA4 ButtonA5 ButtonA6 ButtonB1 ButtonB2...


        //Diagonals
        List<JButton> a4d1Diagonal = new ArrayList<>(); //4 elements
        List<JButton> a5e1Diagonal = new ArrayList<>(); //5
        List<JButton> a6f1Diagonal = new ArrayList<>(); //6
        List<JButton> g1b6Diagonal = new ArrayList<>(); //6
        List<JButton> g2c6Diagonal = new ArrayList<>(); //5
        List<JButton> g3d6Diagonal = new ArrayList<>(); //4


        //a4
        a4d1Diagonal.add(buttons.get(3));
        a4d1Diagonal.add(buttons.get(8));
        a4d1Diagonal.add(buttons.get(13));
        a4d1Diagonal.add(buttons.get(18));

        //a5
        a5e1Diagonal.add(buttons.get(4));
        a5e1Diagonal.add(buttons.get(9));
        a5e1Diagonal.add(buttons.get(14));
        a5e1Diagonal.add(buttons.get(19));
        a5e1Diagonal.add(buttons.get(24));


        //a6
        a6f1Diagonal.add(buttons.get(5));
        a6f1Diagonal.add(buttons.get(10));
        a6f1Diagonal.add(buttons.get(15));
        a6f1Diagonal.add(buttons.get(20));
        a6f1Diagonal.add(buttons.get(25));
        a6f1Diagonal.add(buttons.get(30));

        //g1
        g1b6Diagonal.add(buttons.get(11));
        g1b6Diagonal.add(buttons.get(16));
        g1b6Diagonal.add(buttons.get(21));
        g1b6Diagonal.add(buttons.get(26));
        g1b6Diagonal.add(buttons.get(31));
        g1b6Diagonal.add(buttons.get(36));


        //g2
        g2c6Diagonal.add(buttons.get(17));
        g2c6Diagonal.add(buttons.get(22));
        g2c6Diagonal.add(buttons.get(27));
        g2c6Diagonal.add(buttons.get(32));
        g2c6Diagonal.add(buttons.get(37));


        //g3
        g3d6Diagonal.add(buttons.get(23));
        g3d6Diagonal.add(buttons.get(28));
        g3d6Diagonal.add(buttons.get(33));
        g3d6Diagonal.add(buttons.get(38));

        diagonals.add(a4d1Diagonal);
        diagonals.add(a5e1Diagonal);
        diagonals.add(a6f1Diagonal);
        diagonals.add(g1b6Diagonal);
        diagonals.add(g2c6Diagonal);
        diagonals.add(g3d6Diagonal);

        //Vertical Lists A1 A2 A3 A4 A5 A6 B1 B2 B3....
        List<JButton> aColumn = new ArrayList<>(buttons.subList(0,6));   // A
        List<JButton> bColumn = new ArrayList<>(buttons.subList(6,12));  // B
        List<JButton> cColumn = new ArrayList<>(buttons.subList(12,18)); // C
        List<JButton> dColumn = new ArrayList<>(buttons.subList(18,24)); // D
        List<JButton> eColumn = new ArrayList<>(buttons.subList(24,30)); // E
        List<JButton> fColumn = new ArrayList<>(buttons.subList(30,36)); // F
        List<JButton> gColumn = new ArrayList<>(buttons.subList(36,42)); // G

        verticals.add(aColumn);
        verticals.add(bColumn);
        verticals.add(cColumn);
        verticals.add(dColumn);
        verticals.add(eColumn);
        verticals.add(fColumn);
        verticals.add(gColumn);

        gameBoard.add(aColumn);
        gameBoard.add(bColumn);
        gameBoard.add(cColumn);
        gameBoard.add(dColumn);
        gameBoard.add(eColumn);
        gameBoard.add(fColumn);
        gameBoard.add(gColumn);




        ButtonListener buttonListener = new ButtonListener(gameBoard, buttons, horizontals, verticals, diagonals);

        for(JButton b : buttons) {
            b.addActionListener(buttonListener);
        }



        for (List<JButton> jButton : gameBoard) {
            for (int j = 0; j < gameBoard.get(0).size(); j++) {
                System.out.println(jButton.get(j).getName());
                System.out.println("Column: " + "A B C D E F G");
            }
            System.out.println("---------------------------------------------");
        }

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