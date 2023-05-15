package four;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ResetListener extends JFrame implements ActionListener {
    JButton button;
    ConnectFour game;

    public ResetListener(ConnectFour game) {
        this.game = game;
        this.button = new JButton("Reset");
        button.setName("ButtonReset");
        button.addActionListener(this);
        this.setTitle("Reset Board Frame");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(200,200);
        this.setLayout(new GridLayout());
        this.setVisible(true);
        this.add(button);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("RESET BUTTON ACTION METHOD");
        game = null;
        game = new ConnectFour();
    }
}

