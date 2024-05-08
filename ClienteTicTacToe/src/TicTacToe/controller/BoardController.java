package TicTacToe.controller;

import javax.swing.JLabel;
import raven.swing.spinner.SpinnerProgress;
import static javax.swing.WindowConstants.HIDE_ON_CLOSE;
import TicTacToe.view.Board;


public class BoardController implements Runnable{
    
    private String nickname;
    private JLabel jLabelProgress;
    private SpinnerProgress spinnerProgressLoad;
    
    public void startGame(JLabel label, SpinnerProgress spinner){
        
        BoardController board = new BoardController();
        board.setjLabelProgress(label);
        board.setSpinnerProgressLoad(spinner);
        board.setNickname(this.getNickname());
        
        Thread thread = new Thread(board, "board");
        thread.start();
    }
    
    
    @Override
    public void run(){
        try{
            API api = new API();
            String nickname_oponent = api.GetFreeUser(this.getNickname());
            
            Board board = new Board();
            
            board.setPlayer_01(this.getNickname());
            board.setPlayer_02(nickname_oponent);
            
            board.setDefaultCloseOperation(HIDE_ON_CLOSE);
            board.StartGame();

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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

}
