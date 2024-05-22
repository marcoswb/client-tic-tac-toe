package TicTacToe.view;

import java.awt.Color;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.*;

public class Board extends javax.swing.JFrame {
    
    private String player_01;
    private String player_02;
    private String playerCharacter = "";
    private final String [][]board = {{"NULO", "NULO", "NULO"}, {"NULO", "NULO", "NULO"}, {"NULO", "NULO", "NULO"}};
    private boolean gameFinished = false;
    private final byte[] data = new byte[1024];
    private Socket socket;
    private final InfoDialog info_window = new InfoDialog();;
    private final ErrorDialog error_window = new ErrorDialog();
    
    public Board() {
        initComponents();
    }
        
    public void StartGame(Socket socket, String firstResponse) throws IOException{        
        this.socket = socket;
        this.show();

        switch (firstResponse) {
            case "await":
                info_window.SetMessage("Jogador "+this.getPlayer_02()+" irá começar a partida!");
                
                this.DisableBoard();
                this.awaitMoveOponent();
                this.EnableBoard();
                
                break;
            case "play":
                info_window.SetMessage("Você começa a partida!");
                break;
            default:
                break;
        }
        
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
    
    private void SendMoveOponent(int x, int y){
        try{
            this.sendMessage(String.valueOf(x) + String.valueOf(y));   
        } catch (IOException ex) {
            System.out.println("ERROOOOOOOOOO2 "+ex);
        }
    }
    
    private void awaitMoveOponent(){
        try {
            String response = this.awaitMessage();
            System.out.println("RETORNOU: "+response);
        } catch (IOException ex) {
            System.out.println("ERROOOOOOOOOO2 "+ex);
        }
    }
    
    public void FillLabel(int x, int y){
        if(x == 0 && y == 0){
            label_x1_y1.setText(playerCharacter);
        }
        if(x == 0 && y == 1){
            label_x1_y2.setText(playerCharacter);
        }
        if(x == 0 && y == 2){
            label_x1_y3.setText(playerCharacter);
        }
        
        if(x == 1 && y == 0){
            label_x2_y1.setText(playerCharacter);
        }
        if(x == 1 && y == 1){
            label_x2_y2.setText(playerCharacter);
        }
        if(x == 1 && y == 2){
            label_x2_y3.setText(playerCharacter);
        }
        
        if(x == 2 && y == 0){
            label_x3_y1.setText(playerCharacter);
        }
        if(x == 2 && y == 1){
            label_x3_y2.setText(playerCharacter);
        }
        if(x == 2 && y == 2){
            label_x3_y3.setText(playerCharacter);
        }
    }
    
    private boolean CheckVictory(){
        // checar vitória horizontal
        for(int x = 0; x <= 2; x++){
            if(board[x][0].equals(playerCharacter) & board[x][1].equals(playerCharacter) & board[x][2].equals(playerCharacter)) {
                FillVictoryPositions(x, 0, x, 1, x, 2);
                return true;
            }
        }
        
        // checar vitória vertical
        for(int y = 0; y <= 2; y++){
            if(board[0][y].equals(playerCharacter) & board[1][y].equals(playerCharacter) & board[2][y].equals(playerCharacter)) {
                FillVictoryPositions(0, y, 1, y, 2, y);
                return true;
            }
        }
        
        // checar vitória diagonal principal
        if(board[0][0].equals(playerCharacter) & board[1][1].equals(playerCharacter) & board[2][2].equals(playerCharacter)){
            FillVictoryPositions(0, 0, 1, 1, 2, 2);
            return true;
        }
        
        // checar vitória diagonal secundária
        if(board[0][2].equals(playerCharacter) & board[1][1].equals(playerCharacter) & board[2][0].equals(playerCharacter)){
            FillVictoryPositions(0, 2, 1, 1, 2, 0);
            return true;
        }
        
        return false;
    }
    
    private void FillVictoryPositions(int x1, int y1, int x2, int y2, int x3, int y3){
        FillForeground(x1, y1);
        FillForeground(x2, y2);
        FillForeground(x3, y3);
    }
    
    private void FillForeground(int x, int y){
        switch(x){
            case 0: {
                switch(y){
                    case 0:
                        label_x1_y1.setForeground(Color.GREEN);
                        break;
                    case 1:
                        label_x1_y2.setForeground(Color.GREEN);
                        break;
                    case 2:
                        label_x1_y3.setForeground(Color.GREEN);
                        break;
                }
                break;
            }
            case 1: {
                switch(y){
                    case 0:
                        label_x2_y1.setForeground(Color.GREEN);
                        break;
                    case 1:
                        label_x2_y2.setForeground(Color.GREEN);
                        break;
                    case 2:
                        label_x2_y3.setForeground(Color.GREEN);
                        break;
                }
                break;
            }
            case 2: {
                switch(y){
                    case 0:
                        label_x3_y1.setForeground(Color.GREEN);
                        break;
                    case 1:
                        label_x3_y2.setForeground(Color.GREEN);
                        break;
                    case 2:
                        label_x3_y3.setForeground(Color.GREEN);
                        break;
                }
                break;
            }
        }
    }
    
    public void DisableBoard(){
        label_x1_y1.setEnabled(false);
        label_x1_y2.setEnabled(false);
        label_x1_y3.setEnabled(false);
        label_x2_y1.setEnabled(false);
        label_x2_y2.setEnabled(false);
        label_x2_y3.setEnabled(false);
        label_x3_y1.setEnabled(false);
        label_x3_y2.setEnabled(false);
        label_x3_y3.setEnabled(false);
    }
    
    private void EnableBoard(){
        label_x1_y1.setEnabled(true);
        label_x1_y2.setEnabled(true);
        label_x1_y3.setEnabled(true);
        label_x2_y1.setEnabled(true);
        label_x2_y2.setEnabled(true);
        label_x2_y3.setEnabled(true);
        label_x3_y1.setEnabled(true);
        label_x3_y2.setEnabled(true);
        label_x3_y3.setEnabled(true);
    }
        
    public void SetPlayerCharacter(String value){
        playerCharacter = value;
    }
    
    public String GetPlayerCharacter(){
        return playerCharacter;
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
    
    public String awaitMessage() throws IOException{
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
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });
        getContentPane().setLayout(new java.awt.GridLayout(1, 1, 1, 1));

        jPanel1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new java.awt.GridLayout(3, 3));

        label_x1_y1.setBackground(new java.awt.Color(51, 51, 51));
        label_x1_y1.setFont(new java.awt.Font("Dialog", 0, 48)); // NOI18N
        label_x1_y1.setForeground(new java.awt.Color(255, 255, 255));
        label_x1_y1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_x1_y1.setAlignmentY(0.0F);
        label_x1_y1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        label_x1_y1.setOpaque(true);
        label_x1_y1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_x1_y1MouseClicked(evt);
            }
        });
        jPanel1.add(label_x1_y1);

        label_x2_y1.setBackground(new java.awt.Color(51, 51, 51));
        label_x2_y1.setFont(new java.awt.Font("Dialog", 0, 48)); // NOI18N
        label_x2_y1.setForeground(new java.awt.Color(255, 255, 255));
        label_x2_y1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_x2_y1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        label_x2_y1.setOpaque(true);
        label_x2_y1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_x2_y1MouseClicked(evt);
            }
        });
        jPanel1.add(label_x2_y1);

        label_x3_y1.setBackground(new java.awt.Color(51, 51, 51));
        label_x3_y1.setFont(new java.awt.Font("Dialog", 0, 48)); // NOI18N
        label_x3_y1.setForeground(new java.awt.Color(255, 255, 255));
        label_x3_y1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_x3_y1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        label_x3_y1.setOpaque(true);
        label_x3_y1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_x3_y1MouseClicked(evt);
            }
        });
        jPanel1.add(label_x3_y1);

        getContentPane().add(jPanel1);

        jPanel2.setLayout(new java.awt.GridLayout(3, 3));

        label_x1_y2.setBackground(new java.awt.Color(51, 51, 51));
        label_x1_y2.setFont(new java.awt.Font("Dialog", 0, 48)); // NOI18N
        label_x1_y2.setForeground(new java.awt.Color(255, 255, 255));
        label_x1_y2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_x1_y2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        label_x1_y2.setOpaque(true);
        label_x1_y2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_x1_y2MouseClicked(evt);
            }
        });
        jPanel2.add(label_x1_y2);

        label_x2_y2.setBackground(new java.awt.Color(51, 51, 51));
        label_x2_y2.setFont(new java.awt.Font("Dialog", 0, 48)); // NOI18N
        label_x2_y2.setForeground(new java.awt.Color(255, 255, 255));
        label_x2_y2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_x2_y2.setAlignmentY(0.0F);
        label_x2_y2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        label_x2_y2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        label_x2_y2.setOpaque(true);
        label_x2_y2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_x2_y2MouseClicked(evt);
            }
        });
        jPanel2.add(label_x2_y2);

        label_x3_y2.setBackground(new java.awt.Color(51, 51, 51));
        label_x3_y2.setFont(new java.awt.Font("Dialog", 0, 48)); // NOI18N
        label_x3_y2.setForeground(new java.awt.Color(255, 255, 255));
        label_x3_y2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_x3_y2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        label_x3_y2.setOpaque(true);
        label_x3_y2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_x3_y2MouseClicked(evt);
            }
        });
        jPanel2.add(label_x3_y2);

        getContentPane().add(jPanel2);

        jPanel3.setLayout(new java.awt.GridLayout(3, 3));

        label_x1_y3.setBackground(new java.awt.Color(51, 51, 51));
        label_x1_y3.setFont(new java.awt.Font("Dialog", 0, 48)); // NOI18N
        label_x1_y3.setForeground(new java.awt.Color(255, 255, 255));
        label_x1_y3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_x1_y3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        label_x1_y3.setOpaque(true);
        label_x1_y3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_x1_y3MouseClicked(evt);
            }
        });
        jPanel3.add(label_x1_y3);

        label_x2_y3.setBackground(new java.awt.Color(51, 51, 51));
        label_x2_y3.setFont(new java.awt.Font("Dialog", 0, 48)); // NOI18N
        label_x2_y3.setForeground(new java.awt.Color(255, 255, 255));
        label_x2_y3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_x2_y3.setAlignmentY(0.0F);
        label_x2_y3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        label_x2_y3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        label_x2_y3.setOpaque(true);
        label_x2_y3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_x2_y3MouseClicked(evt);
            }
        });
        jPanel3.add(label_x2_y3);

        label_x3_y3.setBackground(new java.awt.Color(51, 51, 51));
        label_x3_y3.setFont(new java.awt.Font("Dialog", 0, 48)); // NOI18N
        label_x3_y3.setForeground(new java.awt.Color(255, 255, 255));
        label_x3_y3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_x3_y3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
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
        System.out.println("marcos");
        this.DisableBoard();
        Move(1, 1);
        this.awaitMoveOponent();
        this.EnableBoard();
    }//GEN-LAST:event_label_x1_y1MouseClicked

    private void label_x2_y1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_x2_y1MouseClicked
        this.DisableBoard();
        Move(2, 1);
        this.awaitMoveOponent();
        this.EnableBoard();
    }//GEN-LAST:event_label_x2_y1MouseClicked

    private void label_x3_y1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_x3_y1MouseClicked
        this.DisableBoard();
        Move(3, 1);
        this.awaitMoveOponent();
        this.EnableBoard();
    }//GEN-LAST:event_label_x3_y1MouseClicked

    private void label_x2_y2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_x2_y2MouseClicked
        this.DisableBoard();
        Move(2, 2);
        this.awaitMoveOponent();
        this.EnableBoard();
    }//GEN-LAST:event_label_x2_y2MouseClicked

    private void label_x1_y2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_x1_y2MouseClicked
        this.DisableBoard();
        Move(1, 2);
        this.awaitMoveOponent();
        this.EnableBoard();
    }//GEN-LAST:event_label_x1_y2MouseClicked

    private void label_x2_y3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_x2_y3MouseClicked
        this.DisableBoard();
        Move(2, 3);
        this.awaitMoveOponent();
        this.EnableBoard();
    }//GEN-LAST:event_label_x2_y3MouseClicked

    private void label_x3_y2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_x3_y2MouseClicked
        this.DisableBoard();
        Move(3, 2);
        this.awaitMoveOponent();
        this.EnableBoard();
    }//GEN-LAST:event_label_x3_y2MouseClicked

    private void label_x1_y3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_x1_y3MouseClicked
        this.DisableBoard();
        Move(1, 3);
        this.awaitMoveOponent();
        this.EnableBoard();
    }//GEN-LAST:event_label_x1_y3MouseClicked

    private void label_x3_y3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_x3_y3MouseClicked
        this.DisableBoard();
        Move(3, 3);
        this.awaitMoveOponent();
        this.EnableBoard();
    }//GEN-LAST:event_label_x3_y3MouseClicked

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosed
     
    
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Board.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Board.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Board.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Board.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Board().setVisible(true);
            }
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
