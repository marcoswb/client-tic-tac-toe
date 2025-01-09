package view;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

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
        JOptionPane.showMessageDialog(new JFrame(), message, "Erro", JOptionPane.ERROR_MESSAGE);
    }
}
