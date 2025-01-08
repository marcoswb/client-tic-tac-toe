package view;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class QuestionDialog {

    public static void main(String args[]) {
    }

    public int SetMessage(String message) {
        Object[] options = {"Aceitar", "Rejeitar"};
        
        return JOptionPane.showOptionDialog(
                new JFrame(),
                message,
                "Confirmação",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]
        );
    }
}
