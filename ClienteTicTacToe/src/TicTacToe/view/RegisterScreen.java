package TicTacToe.view;

import java.awt.Color;
import TicTacToe.utils.Functions;

public class RegisterScreen extends javax.swing.JFrame {
    
    public Functions functions = new Functions();
    
    public RegisterScreen() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFieldUser = new javax.swing.JTextField();
        jButtonSignOn = new javax.swing.JButton();
        jFieldPassword = new javax.swing.JPasswordField();
        jLabelLogin = new javax.swing.JLabel();
        jFieldName = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sign On");
        setResizable(false);

        jFieldUser.setToolTipText("");
        jFieldUser.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jFieldUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFieldUserActionPerformed(evt);
            }
        });

        jButtonSignOn.setBackground(new java.awt.Color(204, 204, 204));
        jButtonSignOn.setForeground(new java.awt.Color(0, 0, 0));
        jButtonSignOn.setText("Sign On");
        jButtonSignOn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonSignOnMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonSignOnMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonSignOnMouseEntered(evt);
            }
        });
        jButtonSignOn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSignOnActionPerformed(evt);
            }
        });

        jFieldPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFieldPasswordActionPerformed(evt);
            }
        });

        jLabelLogin.setForeground(java.awt.Color.blue);
        jLabelLogin.setText("Login");
        jLabelLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelLoginMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelLoginMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelLoginMouseEntered(evt);
            }
        });

        jFieldName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFieldNameActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelLogin)
                .addGap(123, 123, 123))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jFieldName)
                    .addComponent(jFieldUser, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonSignOn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                    .addComponent(jFieldPassword, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(42, 42, 42))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jFieldName, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jFieldUser, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jFieldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonSignOn)
                .addGap(34, 34, 34)
                .addComponent(jLabelLogin)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jFieldUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFieldUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFieldUserActionPerformed

    private void jFieldPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFieldPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFieldPasswordActionPerformed

    private void jButtonSignOnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSignOnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonSignOnActionPerformed

    private void jLabelLoginMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelLoginMouseEntered
        jLabelLogin.setForeground(Color.red);
    }//GEN-LAST:event_jLabelLoginMouseEntered

    private void jLabelLoginMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelLoginMouseExited
        jLabelLogin.setForeground(Color.BLUE);
    }//GEN-LAST:event_jLabelLoginMouseExited

    private void jButtonSignOnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonSignOnMouseEntered
        jButtonSignOn.setBackground(Color.gray);
    }//GEN-LAST:event_jButtonSignOnMouseEntered

    private void jButtonSignOnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonSignOnMouseExited
        jButtonSignOn.setBackground(Color.lightGray);
    }//GEN-LAST:event_jButtonSignOnMouseExited

    private void jFieldNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFieldNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFieldNameActionPerformed

    private void jButtonSignOnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonSignOnMouseClicked
        String nameUser = jFieldName.getText();
        String user = jFieldUser.getText();
        String password = jFieldPassword.getText();
        
        if(functions.IsNull(nameUser)){
            InfoDialog info_window = new InfoDialog();
            info_window.SetMessage("Preencha o campo de nome do usuário corretamente!");
            jFieldName.requestFocus();
            return;
        } else if(functions.IsNull(user)){
            InfoDialog info_window = new InfoDialog();
            info_window.SetMessage("Preencha o campo de usuário corretamente!");
            jFieldUser.requestFocus();
            return;
        } else if(functions.IsNull(password)){
            InfoDialog info_window = new InfoDialog();
            info_window.SetMessage("Preencha o campo de senha corretamente!");
            jFieldPassword.requestFocus();
            return;
        }
        
        System.out.println(nameUser);
        System.out.println(user);
        System.out.println(password);
    }//GEN-LAST:event_jButtonSignOnMouseClicked

    private void jLabelLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelLoginMouseClicked
                                    
        dispose();
        
        LoginScreen login_screen = new LoginScreen();
        login_screen.show();
    }//GEN-LAST:event_jLabelLoginMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RegisterScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegisterScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegisterScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegisterScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegisterScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonSignOn;
    private javax.swing.JTextField jFieldName;
    private javax.swing.JPasswordField jFieldPassword;
    private javax.swing.JTextField jFieldUser;
    private javax.swing.JLabel jLabelLogin;
    // End of variables declaration//GEN-END:variables
}
