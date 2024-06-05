
package TicTacToe.controller;

import TicTacToe.view.Board;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class BoardController extends Thread{    
    
    private final byte[] data = new byte[1024];
    private Socket socket;
    private Board contextScreen;
    private int position_x = 0;
    private int position_y = 0;
    private String [][]board = {{"NULO", "NULO", "NULO"}, {"NULO", "NULO", "NULO"}, {"NULO", "NULO", "NULO"}};
    private String playerCharacter = "";
    
    public void receiveMovementFromOpponent(Board context){
        BoardController controller = new BoardController();
        
        controller.SetPlayerCharacter(this.GetPlayerCharacter());
        controller.setSocket(socket);
        controller.setContextScreen(context);
        controller.setBoard(this.getBoard());
        
        Thread t = new Thread(controller::awaitMoveOponent);
        t.start();
    }
    
    public void moveAndAwaitOponnet(Board context, int x, int y){
        BoardController controller = new BoardController();
        
        controller.SetPlayerCharacter(this.GetPlayerCharacter());
        controller.setSocket(socket);
        controller.setContextScreen(context);
        controller.setBoard(this.getBoard());
        controller.setPosition_x(x);
        controller.setPosition_y(y);
        
        Thread t = new Thread(controller::moveAndAwait);
        t.start();
    }
    
    private void moveAndAwait(){
        contextScreen.DisableBoard();
        
        boolean valid_mov = Move(position_x, position_y);
        
        if(valid_mov){
            this.awaitMoveOponent();    
        }
        
        contextScreen.EnableBoard();
    }
    
    private boolean Move(int x, int y){        
//        if(gameFinished){
//            return;
//        }
//
//        x = x - 1;
//        y = y - 1;
        
        if(this.BoardIsFree(x, y)){
            this.FillBoard(this.GetPlayerCharacter(), x, y);
            
            this.SendMoveOponent(x, y);

//            boolean victory = contextScreen.CheckVictory();
//            if(victory){
//                gameFinished = true;
//                info_window.SetMessage("Parabéns, você ganhou!");
//            }
            return true;
        } else {
            contextScreen.error_window.SetMessage("Posição ocupada, escolha outro campo");
            return false;
        }

    }
    
        
    private void awaitMoveOponent(){
        try {
            contextScreen.DisableBoard();
            
            String response = this.awaitMessage();
            int x = Integer.parseInt(response.substring(0, 1));
            int y = Integer.parseInt(response.substring(1, 2));
            
            this.FillBoard(this.GetInversePlayerCharacter(), x, y);
            
            contextScreen.EnableBoard();
        } catch (IOException ex) {
            System.out.println("ERROOOOOOOOOO2 "+ex);
        }
    }
    
    private void SendMoveOponent(int x, int y){
        try{
            this.sendMessage(String.valueOf(x) + String.valueOf(y));   
        } catch (IOException ex) {
            System.out.println("ERROOOOOOOOOO2 "+ex);
        }
    }
    
    private String awaitMessage() throws IOException{
        try{
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
        } catch (Exception ex) {
            System.out.println("MARCOSSSS 2 " + ex);
        }
        return null;
    }

    public void sendMessage(String message) throws IOException{
        try{
            OutputStream output = socket.getOutputStream();
            output.write(message.getBytes());
            output.flush();
        } catch (Exception ex) {
            System.out.println("MARCOSSSS 1 " + ex);
        }
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public void setContextScreen(Board contextScreen) {
        this.contextScreen = contextScreen;
    }
    
    public void setPosition_x(int position_x) {
        this.position_x = position_x;
    }

    public void setPosition_y(int position_y) {
        this.position_y = position_y;
    }
    
    public void SetPlayerCharacter(String value){
        playerCharacter = value;
    }
    
    public String GetPlayerCharacter(){
        return playerCharacter;
    }
    
    public String GetInversePlayerCharacter(){
        if(this.GetPlayerCharacter().equals("X")){
            return "O";
        } else{
            return "X";
        }
    }
    
    public void FillBoard(String character, int x, int y) {
            board[x-1][y-1] = character;
            contextScreen.FillLabel(x, y, character);
    }
    
    public boolean BoardIsFree(int x, int y){
        return board[x-1][y-1].equals("NULO");
    }
    
    public String[][] getBoard() {
        return board;
    }

    public void setBoard(String[][] board) {
        this.board = board;
    }
    
}
