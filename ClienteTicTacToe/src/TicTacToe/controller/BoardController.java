package TicTacToe.controller;

import javax.swing.JLabel;
import raven.swing.spinner.SpinnerProgress;
import static javax.swing.WindowConstants.HIDE_ON_CLOSE;
import java.io.*;
import java.net.*;
import TicTacToe.view.Board;


public class BoardController implements Runnable{
    
    private String nickname;
    private JLabel jLabelProgress;
    private SpinnerProgress spinnerProgressLoad;
    private final String host = "127.0.0.1";
    private final int port = 8000;
    private final byte[] data = new byte[1024];
    private Socket socket;
    
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
//            API api = new API();
//            String nickname_oponent = api.GetFreeUser(this.getNickname());
            String nickname_oponent = "marcos2";
                      
            Board game = new Board();
            game.setPlayer_01(this.getNickname());

            
            try{
                socket = new Socket(host, port);
                
                this.sendMessage("entrar");
                
                String firstResponse = this.awaitMessage();
                System.out.println("Server first response: " + firstResponse);
                
                game.setPlayer_02(nickname_oponent);

                game.setDefaultCloseOperation(HIDE_ON_CLOSE);
                game.StartGame(socket, firstResponse);

                this.jLabelProgress.setText("");
                this.spinnerProgressLoad.setValue(0);
                this.spinnerProgressLoad.setIndeterminate(false);

            } catch (UnknownHostException ex) {
                System.out.println("Server not found: " + ex.getMessage());
            } catch (IOException ex) {
                System.out.println("I/O error: " + ex.getMessage());
            }
            
        } catch (Exception ex) {
            System.out.println("MARCOSSSS " + ex);
        }
    }
    
    public void sendMessage(String message) throws IOException{
        OutputStream output = socket.getOutputStream();
        output.write(message.getBytes());
        output.flush();
    }
    
    public String awaitMessage() throws IOException{
        InputStream input = socket.getInputStream();
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        
        int nRead;
        while ((nRead = input.read(data, 0, data.length)) != -1) {
            buffer.write(data, 0, nRead);
            if (input.available() == 0) {
                break;
            }
        }
        String response = buffer.toString("UTF-8");
        
        return response;
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
