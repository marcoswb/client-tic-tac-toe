package TicTacToe.controller;

import javax.swing.JLabel;
import raven.swing.spinner.SpinnerProgress;
import static javax.swing.WindowConstants.HIDE_ON_CLOSE;
import TicTacToe.utils.ResponseModel;
import TicTacToe.view.Board;


public class BoardController implements Runnable{
    
    private JLabel jLabelProgress;
    private SpinnerProgress spinnerProgressLoad;
    
    public void startGame(JLabel label, SpinnerProgress spinner){
        
        BoardController board = new BoardController();
        board.setjLabelProgress(label);
        board.setSpinnerProgressLoad(spinner);
        
        Thread thread = new Thread(board, "board");
        thread.start();
    }
    
    
    @Override
    public void run(){
        try{
            API api = new API();
            ResponseModel response = api.GetFreeUsers();
            System.out.println(response.getResponseText());
            
            Board board = new Board();
            board.setDefaultCloseOperation(HIDE_ON_CLOSE);
            board.show();

            this.jLabelProgress.setText("");
            this.spinnerProgressLoad.setValue(0);
            this.spinnerProgressLoad.setIndeterminate(false);
            
        } catch (Exception ex) {
            System.out.println("MARCOSSSS " + ex);
        }
    }

    public void setjLabelProgress(JLabel jLabelProgress) {
        this.jLabelProgress = jLabelProgress;
    }

    public void setSpinnerProgressLoad(SpinnerProgress spinnerProgressLoad) {
        this.spinnerProgressLoad = spinnerProgressLoad;
    }

}
