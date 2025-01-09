package view;

import java.awt.Color;
import java.io.IOException;
import java.net.*;
import controller.BoardController;

public class Board extends javax.swing.JFrame {

    private String player_01;
    private String player_02;
    public final InfoDialog info_window = new InfoDialog();
    ;
    public final ErrorDialog error_window = new ErrorDialog();
    private boolean actionInProgress = false;
    private final BoardController boardController = new BoardController();
    private boolean gameFinished = false;
    private Color foreground = Color.GREEN;
    private final MainScreen mainContext;

    public Board(MainScreen mainContext) {
        initComponents();
        this.mainContext = mainContext;
    }

    private Board() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void StartGame(Socket socket, String firstResponse) throws IOException {
        boardController.setSocket(socket);
        boardController.setPlayer_01(player_01);
        boardController.setPlayer_02(player_02);

        this.show();

        switch (firstResponse) {
            case "await":
                boardController.SetPlayerCharacter("X");
                info_window.SetMessage("Jogador " + this.getPlayer_02() + " irá começar a partida!");
                boardController.receiveMovementFromOpponent(this);
                break;
            case "play":
                boardController.SetPlayerCharacter("O");
                info_window.SetMessage("Você começa a partida!");
                break;
            default:
                break;
        }

    }

    public void FillLabelPlayer1(int x, int y, String playerCharacter) {        
        setForeground(new Color(120, 94, 134));
        FillForeground(x-1, y-1);
        setCharacterInLabel(x, y, playerCharacter);
        
    }
    
    public void FillLabelPlayer2(int x, int y, String playerCharacter) {        
        setForeground(new Color(243, 203, 43));
        FillForeground(x-1, y-1);
        setCharacterInLabel(x, y, playerCharacter);
        
    }
    
    private void setCharacterInLabel(int x, int y, String playerCharacter){
        if (x == 1 && y == 1) {
            label_x1_y1.setText(playerCharacter);
        }
        if (x == 1 && y == 2) {
            label_x1_y2.setText(playerCharacter);
        }
        if (x == 1 && y == 3) {
            label_x1_y3.setText(playerCharacter);
        }

        if (x == 2 && y == 1) {
            label_x2_y1.setText(playerCharacter);
        }
        if (x == 2 && y == 2) {
            label_x2_y2.setText(playerCharacter);
        }
        if (x == 2 && y == 3) {
            label_x2_y3.setText(playerCharacter);
        }

        if (x == 3 && y == 1) {
            label_x3_y1.setText(playerCharacter);
        }
        if (x == 3 && y == 2) {
            label_x3_y2.setText(playerCharacter);
        }
        if (x == 3 && y == 3) {
            label_x3_y3.setText(playerCharacter);
        }
    }

    public void FillVictoryPositions(int x1, int y1, int x2, int y2, int x3, int y3) {
        setForeground(new Color(152, 251, 152));

        FillForeground(x1, y1);
        FillForeground(x2, y2);
        FillForeground(x3, y3);

        info_window.SetMessage("Parabéns, você ganhou!");
    }
    
    public void FillDefeatPositions(int x1, int y1, int x2, int y2, int x3, int y3) {
        setForeground(new Color(255, 99, 71));

        FillForeground(x1, y1);
        FillForeground(x2, y2);
        FillForeground(x3, y3);

        info_window.SetMessage("Você perdeu, boa sorte no próximo jogo!");
    }

    public void DrawGame() {
        setForeground(new Color(244, 164, 96));

        for (int x = 0; x <= 2; x++) {
            for (int y = 0; y <= 2; y++) {
                FillForeground(x, y);
            }
        }
        
        info_window.SetMessage("Empate!");
    }

    public void EndGame() {
        this.setForeground(Color.orange);

        for (int x = 0; x <= 2; x++) {
            for (int y = 0; y <= 2; y++) {
                FillForeground(x, y);
            }
        }

        info_window.SetMessage("Adversário finalizou o jogo!");
    }

    private void FillForeground(int x, int y) {
        switch (x) {
            case 0: {
                switch (y) {
                    case 0:
                        label_x1_y1.setForeground(this.getForeground());
                        break;
                    case 1:
                        label_x1_y2.setForeground(this.getForeground());
                        break;
                    case 2:
                        label_x1_y3.setForeground(this.getForeground());
                        break;
                }
                break;
            }
            case 1: {
                switch (y) {
                    case 0:
                        label_x2_y1.setForeground(this.getForeground());
                        break;
                    case 1:
                        label_x2_y2.setForeground(this.getForeground());
                        break;
                    case 2:
                        label_x2_y3.setForeground(this.getForeground());
                        break;
                }
                break;
            }
            case 2: {
                switch (y) {
                    case 0:
                        label_x3_y1.setForeground(this.getForeground());
                        break;
                    case 1:
                        label_x3_y2.setForeground(this.getForeground());
                        break;
                    case 2:
                        label_x3_y3.setForeground(this.getForeground());
                        break;
                }
                break;
            }
        }
    }

    public void DisableBoard() {
        actionInProgress = true;
    }

    public void EnableBoard() {
        actionInProgress = false;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        label_x1_y1 = new javax.swing.JLabel();
        label_x2_y1 = new javax.swing.JLabel();
        label_x3_y1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        label_x1_y2 = new javax.swing.JLabel();
        label_x2_y2 = new javax.swing.JLabel();
        label_x3_y2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        label_x1_y3 = new javax.swing.JLabel();
        label_x2_y3 = new javax.swing.JLabel();
        label_x3_y3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(700, 700));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });
        getContentPane().setLayout(new java.awt.GridLayout(1, 1));

        jPanel1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new java.awt.GridLayout(3, 3));

        label_x1_y1.setBackground(new java.awt.Color(44, 62, 80));
        label_x1_y1.setFont(new java.awt.Font("Dialog", 0, 48)); // NOI18N
        label_x1_y1.setForeground(new java.awt.Color(255, 255, 255));
        label_x1_y1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_x1_y1.setAlignmentY(0.0F);
        label_x1_y1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(52, 73, 94)));
        label_x1_y1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        label_x1_y1.setOpaque(true);
        label_x1_y1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_x1_y1MouseClicked(evt);
            }
        });
        jPanel1.add(label_x1_y1);

        label_x2_y1.setBackground(new java.awt.Color(44, 62, 80));
        label_x2_y1.setFont(new java.awt.Font("Dialog", 0, 48)); // NOI18N
        label_x2_y1.setForeground(new java.awt.Color(255, 255, 255));
        label_x2_y1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_x2_y1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(52, 73, 94)));
        label_x2_y1.setOpaque(true);
        label_x2_y1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_x2_y1MouseClicked(evt);
            }
        });
        jPanel1.add(label_x2_y1);

        label_x3_y1.setBackground(new java.awt.Color(44, 62, 80));
        label_x3_y1.setFont(new java.awt.Font("Dialog", 0, 48)); // NOI18N
        label_x3_y1.setForeground(new java.awt.Color(255, 255, 255));
        label_x3_y1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_x3_y1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(52, 73, 94)));
        label_x3_y1.setOpaque(true);
        label_x3_y1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_x3_y1MouseClicked(evt);
            }
        });
        jPanel1.add(label_x3_y1);

        getContentPane().add(jPanel1);

        jPanel2.setLayout(new java.awt.GridLayout(3, 3));

        label_x1_y2.setBackground(new java.awt.Color(44, 62, 80));
        label_x1_y2.setFont(new java.awt.Font("Dialog", 0, 48)); // NOI18N
        label_x1_y2.setForeground(new java.awt.Color(255, 255, 255));
        label_x1_y2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_x1_y2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(52, 73, 94)));
        label_x1_y2.setOpaque(true);
        label_x1_y2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_x1_y2MouseClicked(evt);
            }
        });
        jPanel2.add(label_x1_y2);

        label_x2_y2.setBackground(new java.awt.Color(44, 62, 80));
        label_x2_y2.setFont(new java.awt.Font("Dialog", 0, 48)); // NOI18N
        label_x2_y2.setForeground(new java.awt.Color(255, 255, 255));
        label_x2_y2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_x2_y2.setAlignmentY(0.0F);
        label_x2_y2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(52, 73, 94)));
        label_x2_y2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        label_x2_y2.setOpaque(true);
        label_x2_y2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_x2_y2MouseClicked(evt);
            }
        });
        jPanel2.add(label_x2_y2);

        label_x3_y2.setBackground(new java.awt.Color(44, 62, 80));
        label_x3_y2.setFont(new java.awt.Font("Dialog", 0, 48)); // NOI18N
        label_x3_y2.setForeground(new java.awt.Color(255, 255, 255));
        label_x3_y2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_x3_y2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(52, 73, 94)));
        label_x3_y2.setOpaque(true);
        label_x3_y2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_x3_y2MouseClicked(evt);
            }
        });
        jPanel2.add(label_x3_y2);

        getContentPane().add(jPanel2);

        jPanel3.setLayout(new java.awt.GridLayout(3, 3));

        label_x1_y3.setBackground(new java.awt.Color(44, 62, 80));
        label_x1_y3.setFont(new java.awt.Font("Dialog", 0, 48)); // NOI18N
        label_x1_y3.setForeground(new java.awt.Color(255, 255, 255));
        label_x1_y3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_x1_y3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(52, 73, 94)));
        label_x1_y3.setOpaque(true);
        label_x1_y3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_x1_y3MouseClicked(evt);
            }
        });
        jPanel3.add(label_x1_y3);

        label_x2_y3.setBackground(new java.awt.Color(44, 62, 80));
        label_x2_y3.setFont(new java.awt.Font("Dialog", 0, 48)); // NOI18N
        label_x2_y3.setForeground(new java.awt.Color(255, 255, 255));
        label_x2_y3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_x2_y3.setAlignmentY(0.0F);
        label_x2_y3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(52, 73, 94)));
        label_x2_y3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        label_x2_y3.setOpaque(true);
        label_x2_y3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_x2_y3MouseClicked(evt);
            }
        });
        jPanel3.add(label_x2_y3);

        label_x3_y3.setBackground(new java.awt.Color(44, 62, 80));
        label_x3_y3.setFont(new java.awt.Font("Dialog", 0, 48)); // NOI18N
        label_x3_y3.setForeground(new java.awt.Color(255, 255, 255));
        label_x3_y3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_x3_y3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(52, 73, 94)));
        label_x3_y3.setOpaque(true);
        label_x3_y3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_x3_y3MouseClicked(evt);
            }
        });
        jPanel3.add(label_x3_y3);

        getContentPane().add(jPanel3);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void label_x1_y1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_x1_y1MouseClicked
        if (actionInProgress || this.isGameFinished()) {
            return;
        }

        boardController.moveAndAwaitOponnet(this, 1, 1);
    }//GEN-LAST:event_label_x1_y1MouseClicked

    private void label_x2_y1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_x2_y1MouseClicked
        if (actionInProgress || this.isGameFinished()) {
            return;
        }

        boardController.moveAndAwaitOponnet(this, 2, 1);
    }//GEN-LAST:event_label_x2_y1MouseClicked

    private void label_x3_y1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_x3_y1MouseClicked
        if (actionInProgress || this.isGameFinished()) {
            return;
        }

        boardController.moveAndAwaitOponnet(this, 3, 1);
    }//GEN-LAST:event_label_x3_y1MouseClicked

    private void label_x2_y2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_x2_y2MouseClicked
        if (actionInProgress || this.isGameFinished()) {
            return;
        }

        boardController.moveAndAwaitOponnet(this, 2, 2);
    }//GEN-LAST:event_label_x2_y2MouseClicked

    private void label_x1_y2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_x1_y2MouseClicked
        if (actionInProgress || this.isGameFinished()) {
            return;
        }

        boardController.moveAndAwaitOponnet(this, 1, 2);
    }//GEN-LAST:event_label_x1_y2MouseClicked

    private void label_x2_y3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_x2_y3MouseClicked
        if (actionInProgress || this.isGameFinished()) {
            return;
        }

        boardController.moveAndAwaitOponnet(this, 2, 3);
    }//GEN-LAST:event_label_x2_y3MouseClicked

    private void label_x3_y2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_x3_y2MouseClicked
        if (actionInProgress || this.isGameFinished()) {
            return;
        }

        boardController.moveAndAwaitOponnet(this, 3, 2);
    }//GEN-LAST:event_label_x3_y2MouseClicked

    private void label_x1_y3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_x1_y3MouseClicked
        if (actionInProgress || this.isGameFinished()) {
            return;
        }

        boardController.moveAndAwaitOponnet(this, 1, 3);
    }//GEN-LAST:event_label_x1_y3MouseClicked

    private void label_x3_y3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_x3_y3MouseClicked
        if (actionInProgress || this.isGameFinished()) {
            return;
        }

        boardController.moveAndAwaitOponnet(this, 3, 3);
    }//GEN-LAST:event_label_x3_y3MouseClicked

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed

    }//GEN-LAST:event_formWindowClosed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        boardController.closeSocket();
        mainContext.reloadWindow();
    }//GEN-LAST:event_formWindowClosing

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Board.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        java.awt.EventQueue.invokeLater(() -> {
            new Board().setVisible(true);
        });
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

    public boolean isGameFinished() {
        return gameFinished;
    }

    public void setGameFinished(boolean gameFinished) {
        this.gameFinished = gameFinished;
    }

    @Override
    public Color getForeground() {
        return foreground;
    }

    @Override
    public void setForeground(Color foreground) {
        this.foreground = foreground;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel label_x1_y1;
    private javax.swing.JLabel label_x1_y2;
    private javax.swing.JLabel label_x1_y3;
    private javax.swing.JLabel label_x2_y1;
    private javax.swing.JLabel label_x2_y2;
    private javax.swing.JLabel label_x2_y3;
    private javax.swing.JLabel label_x3_y1;
    private javax.swing.JLabel label_x3_y2;
    private javax.swing.JLabel label_x3_y3;
    // End of variables declaration//GEN-END:variables
}
