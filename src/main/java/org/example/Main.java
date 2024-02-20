package org.example;

import java.awt.*;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame win = new JFrame();
        win.setTitle("Java Swing Example-2");
        win.setSize(400, 200);

        JLabel lbl = new JLabel("Simple Java Swing application");
        lbl.setForeground(Color.blue);
        lbl.setBounds(100,20,250,100);


        JButton btn = new JButton("Close");
        btn.setBounds(150, 100, 80, 30);

        win.add(lbl);
        win.add(btn);

        win.setLocationRelativeTo(null);
        win.setLayout(null);
        win.setVisible(true);
    }
}