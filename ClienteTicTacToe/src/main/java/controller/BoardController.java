package controller;

import utils.JsonData;
import view.Board;
import utils.ResponseModel;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utils.Config;

public class BoardController extends Thread {

    private final byte[] data = new byte[Config.SOCKET_LENGTH_DATA];
    private Socket socket;
    private Board contextScreen;
    private int position_x = 0;
    private int position_y = 0;
    private String[][] board = {{"NULO", "NULO", "NULO"}, {"NULO", "NULO", "NULO"}, {"NULO", "NULO", "NULO"}};
    private String playerCharacter = "";
    private String player_01;
    private String player_02;
    private static final Logger LOGGER = LogManager.getLogger();

    public void receiveMovementFromOpponent(Board context) {
        BoardController controller = replicateInstance(context);

        Thread t = new Thread(controller::awaitMoveOponent);
        t.start();
    }

    public void moveAndAwaitOponnet(Board context, int x, int y) {
        BoardController controller = replicateInstance(context);
        controller.setPosition_x(x);
        controller.setPosition_y(y);

        Thread t = new Thread(controller::moveAndAwait);
        t.start();
    }

    private void moveAndAwait() {
        contextScreen.DisableBoard();

        try {
            boolean valid_mov = Move(position_x, position_y);

            if (valid_mov) {
                this.awaitMoveOponent();
            }
        } catch (Exception ex) {
            LOGGER.error("Erro na função moveAndAwait `{}`", ex.getMessage());
        } finally {
            contextScreen.EnableBoard();
        }
    }

    private boolean Move(int x, int y) throws Exception {
        if (this.BoardIsFree(x, y)) {
            this.FillBoard(this.GetPlayerCharacter(), x, y);

            if (this.CheckVictory(playerCharacter)) {
                this.SendMoveOponent(x, y, "victory");
                closeGame("Vitória");
                return false;
            } else {
                if(this.CheckDraw()) {
                    this.SendMoveOponent(x, y, "draw");
                    closeGame("Empate");
                    return false;
                } else {
                    this.SendMoveOponent(x, y, "play");
                    return true;
                }
            }
        } else {
            contextScreen.error_window.SetMessage("Posição ocupada, escolha outro campo!");
            return false;
        }
    }

    private void awaitMoveOponent() {
        try {
            contextScreen.DisableBoard();

            String responseString = this.awaitMessage();
            ResponseModel responseJson = new ResponseModel();
            String message = responseJson.getMessageKey(responseString, "message");
            String action = responseJson.getMessageKey(responseString, "action");
            
            if(action.equals("end_game")) {
                contextScreen.EndGame();
                closeGame("Vitória");
            } else {
                String position_x_oponent = message.substring(0, 1);
                String position_y_oponent = message.substring(1, 2);

                int x = Integer.parseInt(position_x_oponent);
                int y = Integer.parseInt(position_y_oponent);

                this.FillBoard(this.GetInversePlayerCharacter(), x, y);
                
                if(action.equals("victory")) {
                    CheckVictory(GetInversePlayerCharacter());
                    closeGame("Derrota");
                } else if (action.equals("draw")) {
                    contextScreen.DrawGame();
                    closeGame("Empate");
                }
            }
        } catch (IOException ex) {
            LOGGER.error("Erro na função awaitMoveOponent `{}`", ex.getMessage());
        } finally {
            contextScreen.EnableBoard();
        }
    }

    private void SendMoveOponent(int x, int y, String action) {
        JsonData json = new JsonData();

        json.addKeyJson("message", String.valueOf(x) + String.valueOf(y));
        json.addKeyJson("action", action);

        this.sendMessage(json.getJson());
    }

    private String awaitMessage() throws IOException {
        try {
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
            LOGGER.error("Erro na função awaitMessage `{}`", ex.getMessage());
        }
        return null;
    }

    public void sendMessage(String message) {
        try {
            OutputStream output = socket.getOutputStream();
            output.write(message.getBytes());
            output.flush();
        } catch (Exception ex) {
            LOGGER.error("Erro na função sendMessage `{}`", ex.getMessage());
        }
    }

    private boolean CheckVictory(String character) {
        // checar vitória horizontal
        for (int x = 0; x <= 2; x++) {
            if (board[x][0].equals(character) & board[x][1].equals(character) & board[x][2].equals(character)) {
                if(character.equals(this.GetPlayerCharacter())){
                    contextScreen.FillVictoryPositions(x, 0, x, 1, x, 2);
                } else {
                    contextScreen.FillDefeatPositions(x, 0, x, 1, x, 2);
                }
                return true;
            }
        }

        // checar vitória vertical
        for (int y = 0; y <= 2; y++) {
            if (board[0][y].equals(character) & board[1][y].equals(character) & board[2][y].equals(character)) {
                if(character.equals(this.GetPlayerCharacter())){
                    contextScreen.FillVictoryPositions(0, y, 1, y, 2, y);
                } else {
                    contextScreen.FillDefeatPositions(0, y, 1, y, 2, y);
                }
                return true;
            }
        }

        // checar vitória diagonal principal
        if (board[0][0].equals(character) & board[1][1].equals(character) & board[2][2].equals(character)) {
            if(character.equals(this.GetPlayerCharacter())){
                contextScreen.FillVictoryPositions(0, 0, 1, 1, 2, 2);
            } else {
                contextScreen.FillDefeatPositions(0, 0, 1, 1, 2, 2);
            }
            return true;
        }

        // checar vitória diagonal secundária
        if (board[0][2].equals(character) & board[1][1].equals(character) & board[2][0].equals(character)) {
            if(character.equals(this.GetPlayerCharacter())){
                contextScreen.FillVictoryPositions(0, 2, 1, 1, 2, 0);
            } else {
                contextScreen.FillDefeatPositions(0, 2, 1, 1, 2, 0);
            }
            return true;
        }

        return false;
    }

    public void saveGame(String result) throws Exception {
        API api = new API();
        api.saveHistory(getPlayer_01(), getPlayer_02(), result);
    }

    private boolean CheckDraw() {
        for (int x = 0; x <= 2; x++) {
            for (int y = 0; y <= 2; y++) {
                if (board[x][y].equals("NULO")) {
                    return false;
                }
            }
        }

        contextScreen.DrawGame();
        return true;
    }

    private void closeGame(String status) {
        contextScreen.setGameFinished(true);
        try {
            saveGame(status);
            closeSocket();
        } catch (Exception ex) {
            LOGGER.error("Erro na função closeGame `{}`", ex.getMessage());
        }
    }
    
    private BoardController replicateInstance(Board context){
        BoardController controller = new BoardController();
        controller.setPlayer_01(player_01);
        controller.setPlayer_02(player_02);

        controller.SetPlayerCharacter(this.GetPlayerCharacter());
        controller.setSocket(socket);
        controller.setContextScreen(context);
        controller.setBoard(this.getBoard());
        
        return controller;
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

    public void SetPlayerCharacter(String value) {
        playerCharacter = value;
    }

    public String GetPlayerCharacter() {
        return playerCharacter;
    }

    public String GetInversePlayerCharacter() {
        if (this.GetPlayerCharacter().equals("X")) {
            return "O";
        } else {
            return "X";
        }
    }

    public void FillBoard(String character, int x, int y) {
        board[x - 1][y - 1] = character;
        if(character.equals("X")){
            contextScreen.FillLabelPlayer1(x, y, character);
        } else {
            contextScreen.FillLabelPlayer2(x, y, character);
        }
        
    }

    public boolean BoardIsFree(int x, int y) {
        return board[x - 1][y - 1].equals("NULO");
    }

    public String[][] getBoard() {
        return board;
    }

    public void setBoard(String[][] board) {
        this.board = board;
    }

    public String getPlayer_01() {
        return player_01;
    }

    public void setPlayer_01(String player_01) {
        this.player_01 = player_01;
    }

    public String getPlayer_02() {
        return player_02;
    }

    public void setPlayer_02(String player_02) {
        this.player_02 = player_02;
    }

    public void closeSocket() {
        try {
            this.socket.close();
        } catch (IOException ex) {
            LOGGER.error("Erro na função closeSocket `{}`", ex.getMessage());
        }
    }

}
