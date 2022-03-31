package lesson8;

import javax.swing.*;

public class Example1 extends JFrame {
    public Example1(){
        setTitle("window");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(500, 500, 480, 420);
    }

    public static void main(String[] args) {
        new Example1();
    }
}
