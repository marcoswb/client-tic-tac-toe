package controller;


import java.util.Random;

public class ComputerPlayer {
    private BoardController boardController;
    private String player;
    private String computer;

    public ComputerPlayer(BoardController board) {
        this.boardController = board;
        this.player = board.GetPlayerCharacter();
        this.computer = board.GetInversePlayerCharacter();
    }

    public int[] getMove() {        
        String level = boardController.getLevel();
        
        switch (level.toLowerCase()) {
            case "facil":
                return getRandomMove();
            case "medio":
                return getRuleBasedMove();
            case "dificil":
                return getMinimaxMove();
            default:
                throw new IllegalArgumentException("Dificuldade inválida: " + level);
        }
    }

    private int[] getRandomMove() {
        Random random = new Random();
        int x, y;
        do {
            x = random.nextInt(3) + 1;
            y = random.nextInt(3) + 1;
        } while (!boardController.BoardIsFree(x, y));
        return new int[]{x, y};
    }

    private int[] getRuleBasedMove() {
        // Verificar se o computador pode vencer
        for (int x = 1; x <= 3; x++) {
            for (int y = 1; y <= 3; y++) {
                if(boardController.BoardIsFree(x, y)) {
                    if(boardController.simuleVictory(computer, x, y)){
                        return new int[]{x, y};
                    }
                }
            }
        }

        // Bloquear o adversário
        for (int x = 1; x <= 3; x++) {
            for (int y = 1; y <= 3; y++) {
                if(boardController.BoardIsFree(x, y)) {
                    if(boardController.simuleVictory(player, x, y)){
                        return new int[]{x, y};
                    }
                }
            }
        }

        // Jogar no centro, se disponível
        if (boardController.BoardIsFree(2, 2)) return new int[]{2, 2};

        // Jogar em qualquer canto disponível
        int[][] corners = {{1, 1}, {1, 3}, {3, 1}, {3, 3}};
        for (int[] corner : corners) {
            if (boardController.BoardIsFree(corner[0], corner[1])) return corner;
        }

        // Jogar em qualquer célula disponível
        for (int x = 1; x <= 3; x++) {
            for (int y = 1; y <= 3; y++) {
                if (boardController.BoardIsFree(x, y)) return new int[]{x, y};
            }
        }

        return null; // Empate
    }

    private int[] getMinimaxMove() {
        int bestScore = Integer.MIN_VALUE;
        int[] bestMove = null;

        for (int x = 1; x <= 3; x++) {
            for (int y = 1; y <= 3; y++) {
                if(boardController.BoardIsFree(x, y)) {
                    boardController.board[x-1][y-1] = computer;
                    int score = minimax(false);
                    boardController.board[x-1][y-1] = "NULO";
                    if (score > bestScore) {
                        bestScore = score;
                        bestMove = new int[]{x, y};
                    }
                }
            }
        }
        return bestMove;
    }

    private int minimax(boolean isMaximizing) {
        if(boardController.playerWin(computer)){
            return 10;
        }
        
        if(boardController.playerWin(player)){
            return -10;
        }
        
        if (boardController.isBoardFull()){
            return 0;
        }

        int bestScore = isMaximizing ? Integer.MIN_VALUE : Integer.MAX_VALUE;

        for (int row = 1; row <= 3; row++) {
            for (int col = 1; col <= 3; col++) {
                if(boardController.BoardIsFree(row, col)) {
                    boardController.board[row-1][col-1] = isMaximizing ? computer : player;
                    int score = minimax(!isMaximizing);
                    boardController.board[row-1][col-1] = "NULO";
                    bestScore = isMaximizing ? Math.max(bestScore, score) : Math.min(bestScore, score);
                }
            }
        }
        return bestScore;
    }
}
