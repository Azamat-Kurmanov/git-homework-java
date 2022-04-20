package lesson8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CounterApp extends JFrame {

    private int counter = 0;
    public CounterApp(){
        setTitle("CounterApp window");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(500, 500, 250, 120);

        Font font = new Font("Arial", Font.BOLD, 30);

        JButton buttonIncrement = new JButton(">");
        add(buttonIncrement, BorderLayout.LINE_END);

        JButton buttonDecrement = new JButton("<");
        add(buttonDecrement, BorderLayout.LINE_START);

        JButton buttonRefresh = new JButton(String.valueOf(counter));
        add(buttonRefresh, BorderLayout.PAGE_END);
        buttonRefresh.setText("Refresh");

        JLabel counterView = new JLabel(String.valueOf(counter));
        counterView.setHorizontalAlignment(SwingConstants.CENTER);
        counterView.setFont(font);
        add(counterView, BorderLayout.CENTER);

        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource().equals(buttonIncrement)) {
                    counter+=10;
                } else if (e.getSource().equals(buttonDecrement)){
                    counter-=10;
                } else if (e.getSource().equals(buttonRefresh)){
                    counter = 0;
                }
                counterView.setText(String.valueOf(counter));
            }
        };

        buttonIncrement.addActionListener(actionListener);
        buttonDecrement.addActionListener(actionListener);
        buttonRefresh.addActionListener(actionListener);

        setVisible(true);
    }

    public static void main(String[] args) {
        new CounterApp();
    }
}