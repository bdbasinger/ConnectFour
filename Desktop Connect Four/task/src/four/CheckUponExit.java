package four;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class CheckUponExit extends JFrame {
    public CheckUponExit() {
        setSize(400,400);
        setTitle("Window Listener");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new Check());
        setLocationRelativeTo(null);

    }
    private class Check extends WindowAdapter {
        public void windowClosing(WindowEvent e) {
            ConfirmWindow checker = new ConfirmWindow();
            checker.setVisible(true);
        }
    }

    private class ConfirmWindow extends JFrame implements ActionListener {
        public ConfirmWindow() {
            setSize(400,400);
            setLayout(new BorderLayout());

            JLabel confirmLabel = new JLabel("Are you sure you want to exit?", SwingConstants.CENTER);
            add(confirmLabel, BorderLayout.CENTER);

            JPanel buttonPanel = new JPanel();
            buttonPanel.setLayout(new FlowLayout());

            JButton exitButton = new JButton("Yes");
            exitButton.addActionListener(this);
            buttonPanel.add(exitButton);

            JButton cancelButton = new JButton("No");
            cancelButton.addActionListener(this);
            buttonPanel.add(cancelButton);

            add(buttonPanel, BorderLayout.SOUTH);
            setLocationRelativeTo(null);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String action = e.getActionCommand();
            if(action.equals("Yes"))
                System.exit(0);
            else if (action.equals("No"))
                dispose();
        }
    }

}
