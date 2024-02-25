package TicTacToe.view;

public class Board extends javax.swing.JFrame {
    
    private String playerCharacter = "";
    
    public Board() {
        initComponents();
    }
    
    public void FillLabel(javax.swing.JLabel label_object){
        String current_text = label_object.getText();
        if(current_text.equals(playerCharacter)){
            ErrorDialog error_window = new ErrorDialog();
            error_window.SetMessage("Posição ocupada, escolha outro campo");
        } else {
            label_object.setText(playerCharacter);
        }
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
        label_1_1 = new javax.swing.JLabel();
        label_2_1 = new javax.swing.JLabel();
        label_3_1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        label_3_2 = new javax.swing.JLabel();
        label_1_2 = new javax.swing.JLabel();
        label_2_2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        label_3_3 = new javax.swing.JLabel();
        label_1_3 = new javax.swing.JLabel();
        label_2_3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridLayout(1, 1, 1, 1));

        jPanel1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new java.awt.GridLayout(3, 3));

        label_1_1.setBackground(new java.awt.Color(0, 0, 0));
        label_1_1.setFont(new java.awt.Font("Dialog", 0, 48)); // NOI18N
        label_1_1.setForeground(new java.awt.Color(0, 0, 0));
        label_1_1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_1_1.setAlignmentY(0.0F);
        label_1_1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        label_1_1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        label_1_1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_1_1MouseClicked(evt);
            }
        });
        jPanel1.add(label_1_1);

        label_2_1.setBackground(new java.awt.Color(0, 0, 0));
        label_2_1.setFont(new java.awt.Font("Dialog", 0, 48)); // NOI18N
        label_2_1.setForeground(new java.awt.Color(0, 0, 0));
        label_2_1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_2_1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        label_2_1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_2_1MouseClicked(evt);
            }
        });
        jPanel1.add(label_2_1);

        label_3_1.setBackground(new java.awt.Color(0, 0, 0));
        label_3_1.setFont(new java.awt.Font("Dialog", 0, 48)); // NOI18N
        label_3_1.setForeground(new java.awt.Color(0, 0, 0));
        label_3_1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_3_1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        label_3_1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_3_1MouseClicked(evt);
            }
        });
        jPanel1.add(label_3_1);

        getContentPane().add(jPanel1);

        label_3_2.setBackground(new java.awt.Color(0, 0, 0));
        label_3_2.setFont(new java.awt.Font("Dialog", 0, 48)); // NOI18N
        label_3_2.setForeground(new java.awt.Color(0, 0, 0));
        label_3_2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_3_2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        label_3_2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_3_2MouseClicked(evt);
            }
        });

        label_1_2.setBackground(new java.awt.Color(0, 0, 0));
        label_1_2.setFont(new java.awt.Font("Dialog", 0, 48)); // NOI18N
        label_1_2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_1_2.setAlignmentY(0.0F);
        label_1_2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        label_1_2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        label_1_2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_1_2MouseClicked(evt);
            }
        });

        label_2_2.setBackground(new java.awt.Color(0, 0, 0));
        label_2_2.setFont(new java.awt.Font("Dialog", 0, 48)); // NOI18N
        label_2_2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_2_2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        label_2_2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_2_2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 247, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(label_1_2, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(label_2_2, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(label_3_2, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 517, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(label_1_2, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, 0)
                    .addComponent(label_2_2, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, 0)
                    .addComponent(label_3_2, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        getContentPane().add(jPanel2);

        label_3_3.setBackground(new java.awt.Color(0, 0, 0));
        label_3_3.setFont(new java.awt.Font("Dialog", 0, 48)); // NOI18N
        label_3_3.setForeground(new java.awt.Color(0, 0, 0));
        label_3_3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_3_3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        label_3_3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_3_3MouseClicked(evt);
            }
        });

        label_1_3.setBackground(new java.awt.Color(0, 0, 0));
        label_1_3.setFont(new java.awt.Font("Dialog", 0, 48)); // NOI18N
        label_1_3.setForeground(new java.awt.Color(0, 0, 0));
        label_1_3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_1_3.setAlignmentY(0.0F);
        label_1_3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        label_1_3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        label_1_3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_1_3MouseClicked(evt);
            }
        });

        label_2_3.setBackground(new java.awt.Color(0, 0, 0));
        label_2_3.setFont(new java.awt.Font("Dialog", 0, 48)); // NOI18N
        label_2_3.setForeground(new java.awt.Color(0, 0, 0));
        label_2_3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_2_3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        label_2_3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_2_3MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 247, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(label_1_3, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(label_2_3, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(label_3_3, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 517, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(label_1_3, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, 0)
                    .addComponent(label_2_3, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, 0)
                    .addComponent(label_3_3, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        getContentPane().add(jPanel3);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void label_1_1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_1_1MouseClicked
        FillLabel(label_1_1);
    }//GEN-LAST:event_label_1_1MouseClicked

    private void label_2_1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_2_1MouseClicked
        FillLabel(label_2_1);
    }//GEN-LAST:event_label_2_1MouseClicked

    private void label_3_1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_3_1MouseClicked
        FillLabel(label_3_1);
    }//GEN-LAST:event_label_3_1MouseClicked

    private void label_1_2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_1_2MouseClicked
        FillLabel(label_1_2);
    }//GEN-LAST:event_label_1_2MouseClicked

    private void label_2_2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_2_2MouseClicked
        FillLabel(label_2_2);
    }//GEN-LAST:event_label_2_2MouseClicked

    private void label_3_2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_3_2MouseClicked
        FillLabel(label_3_2);
    }//GEN-LAST:event_label_3_2MouseClicked

    private void label_1_3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_1_3MouseClicked
        FillLabel(label_1_3);
    }//GEN-LAST:event_label_1_3MouseClicked

    private void label_2_3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_2_3MouseClicked
        FillLabel(label_2_3);
    }//GEN-LAST:event_label_2_3MouseClicked

    private void label_3_3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_3_3MouseClicked
        FillLabel(label_3_3);
    }//GEN-LAST:event_label_3_3MouseClicked
     
    
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
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
    private javax.swing.JLabel label_1_1;
    private javax.swing.JLabel label_1_2;
    private javax.swing.JLabel label_1_3;
    private javax.swing.JLabel label_2_1;
    private javax.swing.JLabel label_2_2;
    private javax.swing.JLabel label_2_3;
    private javax.swing.JLabel label_3_1;
    private javax.swing.JLabel label_3_2;
    private javax.swing.JLabel label_3_3;
    // End of variables declaration//GEN-END:variables
}
