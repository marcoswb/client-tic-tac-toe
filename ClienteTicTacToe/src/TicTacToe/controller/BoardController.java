
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
    
    public void receiveMovementFromOpponent(Board context){
        BoardController controller = new BoardController();
        
        controller.setSocket(socket);
        controller.setContextScreen(context);
        
        Thread t = new Thread(controller::awaitMoveOponent);
        t.start();
    }
    
    public void moveAndAwaitOponnet(Board context, int x, int y){
        BoardController controller = new BoardController();
        
        controller.setSocket(socket);
        controller.setContextScreen(context);
        controller.setPosition_x(x);
        controller.setPosition_y(y);
        
        Thread t = new Thread(controller::moveAndAwait);
        t.start();
    }
    
    private void moveAndAwait(){
        contextScreen.DisableBoard();
        
        Move(position_x, position_y);
        this.awaitMoveOponent();
        
        contextScreen.EnableBoard();
    }
    
    private void Move(int x, int y){        
//        if(gameFinished){
//            return;
//        }
//
//        x = x - 1;
//        y = y - 1;
//
//        if(board[x][y].equals("NULO")){
//            board[x][y] = playerCharacter;
//            this.FillLabel(x, y);
//
//            boolean victory = CheckVictory();
//            if(victory){
//                gameFinished = true;
//                info_window.SetMessage("Parabéns, você ganhou!");
//            }
//        } else {
//            error_window.SetMessage("Posição ocupada, escolha outro campo");
//        }

        this.SendMoveOponent(x, y);
    }
    
        
    private void awaitMoveOponent(){
        try {
            contextScreen.DisableBoard();
            
            String response = this.awaitMessage();
            System.out.println("RETORNOU: "+response);
            
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
}
