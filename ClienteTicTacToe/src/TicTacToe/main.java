package TicTacToe;

import TicTacToe.view.Board;

public class main {

    public static void main(String[] args) {
        Board main_screen = new Board();
        main_screen.SetPlayerCharacter("O");
        main_screen.show();
    }
    
}
