package TicTacToe.controller;

import TicTacToe.utils.JsonData;
import TicTacToe.utils.ResponseModel;
import javax.swing.JLabel;
import raven.swing.spinner.SpinnerProgress;
import static javax.swing.WindowConstants.HIDE_ON_CLOSE;
import java.io.*;
import java.net.*;
import TicTacToe.view.Board;
import TicTacToe.view.MainScreen;


public class PrepareGame implements Runnable{
    
    private String nickname;
    private JLabel jLabelProgress;
    private SpinnerProgress spinnerProgressLoad;
    private final String host = "127.0.0.1";
    private final int port = 8000;
    private final byte[] data = new byte[1024];
    private Socket socket;
    private final MainScreen mainContext;
    
    public PrepareGame(MainScreen mainContext) {
        this.mainContext = mainContext;
    }

    public void startGame(){
        
        PrepareGame board = new PrepareGame(mainContext);
        board.setjLabelProgress(mainContext.getjLabelProgress());
        board.setSpinnerProgressLoad(mainContext.getSpinnerProgressLoad());
        board.setNickname(this.getNickname());
        
        Thread thread = new Thread(board, "board");
        thread.start();
    }
    
    
    @Override
    public void run(){
        try{
            Board game = new Board(mainContext);
            game.setPlayer_01(this.getNickname());

            
            try{
                socket = new Socket(host, port);
                
                // autenticação
                JsonData json = new JsonData();

                json.addKeyJson("message", "entrar");
                json.addKeyJson("player", this.getNickname());
                
                this.sendMessage(json.getJson());
                
                // recuperar quem joga primeiro e o nome do adversário
                String responseString = this.awaitMessage();     
                ResponseModel responseJson = new ResponseModel();
                String message = responseJson.getMessageKey(responseString, "message");
                String nickname_oponent = responseJson.getMessageKey(responseString, "player");          
                
                game.setPlayer_02(nickname_oponent);

                game.setDefaultCloseOperation(HIDE_ON_CLOSE);
                game.StartGame(socket, message);

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
