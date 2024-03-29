package TicTacToe.view;

import java.awt.Color;

public class Board extends javax.swing.JFrame {
    
    private String playerCharacter = "";
    private final String [][]board = {{"NULO", "NULO", "NULO"}, {"NULO", "NULO", "NULO"}, {"NULO", "NULO", "NULO"}};
    private boolean gameFinished = false;
    
    public Board() {
        initComponents();
    }
    
    public void FillLabel(javax.swing.JLabel label_object, int x, int y){
        if(gameFinished){
            return;
        }
        
        x = x - 1;
        y = y - 1;

        if(board[x][y].equals("NULO")){
            board[x][y] = playerCharacter;
            label_object.setText(playerCharacter);
            
            boolean victory = CheckVictory();
            if(victory){
                DisableBoard();
                InfoDialog info_window = new InfoDialog();
                info_window.SetMessage("Parabéns, você ganhou!");
            }
        } else {
            ErrorDialog error_window = new ErrorDialog();
            error_window.SetMessage("Posição ocupada, escolha outro campo");
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
        FillLabel(x1, y1);
        FillLabel(x2, y2);
        FillLabel(x3, y3);
    }
    
    private void FillLabel(int x, int y){
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
        gameFinished = true;
    }
        
    public void SetPlayerCharacter(String value){
        playerCharacter = value;
    }
    
    public String GetPlayerCharacter(){
        return playerCharacter;
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
        FillLabel(label_x1_y1, 1, 1);
    }//GEN-LAST:event_label_x1_y1MouseClicked

    private void label_x2_y1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_x2_y1MouseClicked
        FillLabel(label_x2_y1, 2, 1);
    }//GEN-LAST:event_label_x2_y1MouseClicked

    private void label_x3_y1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_x3_y1MouseClicked
        FillLabel(label_x3_y1, 3, 1);
    }//GEN-LAST:event_label_x3_y1MouseClicked

    private void label_x2_y2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_x2_y2MouseClicked
        FillLabel(label_x2_y2, 2, 2);
    }//GEN-LAST:event_label_x2_y2MouseClicked

    private void label_x1_y2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_x1_y2MouseClicked
        FillLabel(label_x1_y2, 1, 2);
    }//GEN-LAST:event_label_x1_y2MouseClicked

    private void label_x2_y3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_x2_y3MouseClicked
        FillLabel(label_x2_y3, 2, 3);
    }//GEN-LAST:event_label_x2_y3MouseClicked

    private void label_x3_y2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_x3_y2MouseClicked
        FillLabel(label_x3_y2, 3, 2);
    }//GEN-LAST:event_label_x3_y2MouseClicked

    private void label_x1_y3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_x1_y3MouseClicked
        FillLabel(label_x1_y3, 1, 3);
    }//GEN-LAST:event_label_x1_y3MouseClicked

    private void label_x3_y3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_x3_y3MouseClicked
        FillLabel(label_x3_y3, 3, 3);
    }//GEN-LAST:event_label_x3_y3MouseClicked
     
    
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
