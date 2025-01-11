package view;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class DialogChooseLevel {

    public static void main(String args[]) {
    }

    public int ShowMessage() {
        UIManager.put("OptionPane.background", new Color(44, 62, 80));
        UIManager.put("Panel.background", new Color(44, 62, 80));
        UIManager.put("Button.background", new Color(236, 240, 241));
        UIManager.put("OptionPane.messageForeground", new Color(236, 240, 241));
        
        Object[] options = {"Fácil", "Médio", "Difícil"};
        
        return JOptionPane.showOptionDialog(
                new JFrame(),
                "Escolha o nível que deseja jogar!",
                "Selecionar nível",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]
        );
    }
}
