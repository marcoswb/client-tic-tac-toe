package view;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class ErrorDialog {

    public String message;
    
    public static void main(String args[]) {
    }

    public void SetMessage(String message) {
        ErrorDialog controller = new ErrorDialog();
        controller.message = message;
        
        Thread t = new Thread(controller::showMessage);
        t.start();
    }
    
    private void showMessage(){
        UIManager.put("OptionPane.background", new Color(44, 62, 80));
        UIManager.put("Panel.background", new Color(44, 62, 80));
        UIManager.put("Button.background", new Color(236, 240, 241));
        UIManager.put("OptionPane.messageForeground", new Color(236, 240, 241));
        
        JOptionPane.showMessageDialog(new JFrame(), message, "Erro", JOptionPane.ERROR_MESSAGE);
    }
}
