package view;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ErrorDialog {

    public static void main(String args[]) {
    }

    public void SetMessage(String message) {
        JOptionPane.showMessageDialog(new JFrame(), message, "Erro", JOptionPane.ERROR_MESSAGE);
    }
}
