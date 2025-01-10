package controller;


import utils.JsonData;
import utils.ResponseModel;
import static javax.swing.WindowConstants.HIDE_ON_CLOSE;
import java.io.*;
import java.net.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import view.Board;
import view.MainScreen;
import utils.Config;


public class PrepareGame implements Runnable{
    
    private String nickname;
    private String opponent;
    private String host = Config.SOCKET_HOST;
    private int port = Config.SOCKET_PORT;
    private byte[] data = new byte[Config.SOCKET_LENGTH_DATA];
    private Socket socket;
    private final MainScreen mainContext;
    private static final Logger LOGGER = LogManager.getLogger();
    
    public PrepareGame(MainScreen mainContext) {
        this.mainContext = mainContext;
    }

    public void startGame(){
        PrepareGame board = new PrepareGame(mainContext);
        board.setNickname(this.getNickname());
        
        Thread thread = new Thread(board, "board");
        thread.start();
    }
    
    public void startGame(String opponent){        
        PrepareGame board = new PrepareGame(mainContext);
        board.setNickname(this.getNickname());
        board.setOpponent(opponent);
        
        Thread thread = new Thread(board, "board");
        thread.start();
    }
    
    
    @Override
    public void run(){
        try{
            Board game = new Board(mainContext);
            game.setPlayer_01(this.getNickname());
        
            socket = new Socket(host, port);
            JsonData json = new JsonData();
            json.addKeyJson("message", "entrar");
            json.addKeyJson("player", this.getNickname());

            if(this.getOpponent() == null){
                json.addKeyJson("opponent", "random");
            } else {
                json.addKeyJson("opponent", this.getOpponent());
            }

            this.sendMessage(json.getJson());

            // recuperar nome do adversário e quem joga primeiro
            String responseString = this.awaitMessage();     
            ResponseModel responseJson = new ResponseModel();
            String message = responseJson.getMessageKey(responseString, "message");
            String nickname_oponent = responseJson.getMessageKey(responseString, "player");          

            game.setPlayer_02(nickname_oponent);

            game.setDefaultCloseOperation(HIDE_ON_CLOSE);
            game.StartGame(socket, message);

            mainContext.stopLoading();

        } catch (UnknownHostException ex) {
            LOGGER.error("Erro na função run 1 `{}`", ex.getMessage());
        } catch (IOException ex) {
            LOGGER.error("Erro na função run 2 `{}`", ex.getMessage());
        } catch (Exception ex) {
            LOGGER.error("Erro na função run 3 `{}`", ex.getMessage());
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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getOpponent() {
        return opponent;
    }

    public void setOpponent(String opponent) {
        this.opponent = opponent;
    }
}

