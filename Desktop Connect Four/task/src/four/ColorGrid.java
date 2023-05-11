package four;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ColorGrid extends JFrame {
    public ColorGrid() {
        JFrame j = new JFrame("COLOR GRID");
        j.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        j.setSize(400,400);
        j.setLocationRelativeTo(null);
        j.setLayout(new GridLayout(2, 2, 5, 5));
        j.setVisible(true);

        String[] arr = {"RED", "BLUE", "GREEN", "YELLOW"};
/*
        for(String s : arr){
            JButton b = new JButton(s);
            b.setBackground(Color.getColor(s));
            b.setOpaque(true);
            b.setBorderPainted(false);
            j.add(b);
        }
        */

        JButton redButton = new JButton("RED");
        JButton blueButton = new JButton("BLUE");
        JButton greenButton = new JButton("GREEN");
        JButton yellowButton = new JButton("YELLOW");

        redButton.setBackground(Color.RED);
        redButton.setOpaque(true);
        redButton.setBorderPainted(false);

        redButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                redButton.setBackground(Color.BLUE);
            }
        });

        blueButton.setBackground(Color.BLUE);
        blueButton.setOpaque(true);
        blueButton.setBorderPainted(false);

        greenButton.setBackground(Color.GREEN);
        greenButton.setOpaque(true);
        greenButton.setBorderPainted(false);

        yellowButton.setBackground(Color.YELLOW);
        yellowButton.setOpaque(true);
        yellowButton.setBorderPainted(false);

        j.add(redButton);
        j.add(blueButton);
        j.add(greenButton);
        j.add(yellowButton);

    }


}
