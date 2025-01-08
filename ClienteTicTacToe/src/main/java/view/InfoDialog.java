package view;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class InfoDialog {

    public static void main(String args[]) {
    }

    public void SetMessage(String message) {
        JOptionPane.showMessageDialog(new JFrame(), message, "Info", JOptionPane.INFORMATION_MESSAGE);
    }
}
