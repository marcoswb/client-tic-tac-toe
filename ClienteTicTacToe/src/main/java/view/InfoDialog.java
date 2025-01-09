package view;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class InfoDialog {
    
    public String message;

    public static void main(String args[]) {
    }

    public void SetMessage(String message) {
        InfoDialog controller = new InfoDialog();
        controller.message = message;
        
        Thread t = new Thread(controller::showMessage);
        t.start();
    }
    
    private void showMessage(){
        JOptionPane.showMessageDialog(new JFrame(), message, "Info", JOptionPane.INFORMATION_MESSAGE);
    }
}
