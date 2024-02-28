
package TicTacToe.view;

import java.awt.Color;
import TicTacToe.utils.Functions;


public class LoginScreen extends javax.swing.JFrame {
        public Functions functions = new Functions();

    public LoginScreen() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFieldUser = new javax.swing.JTextField();
        jFieldPassword = new javax.swing.JPasswordField();
        jButtonLogin = new javax.swing.JButton();
        jLabelSignOn = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setResizable(false);

        jFieldUser.setToolTipText("");
        jFieldUser.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jFieldUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFieldUserActionPerformed(evt);
            }
        });

        jFieldPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFieldPasswordActionPerformed(evt);
            }
        });

        jButtonLogin.setBackground(new java.awt.Color(204, 204, 204));
        jButtonLogin.setForeground(new java.awt.Color(0, 0, 0));
        jButtonLogin.setLabel("Login");
        jButtonLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonLoginMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonLoginMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonLoginMouseEntered(evt);
            }
        });

        jLabelSignOn.setForeground(java.awt.Color.blue);
        jLabelSignOn.setText("Cadastrar-se");
        jLabelSignOn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabelSignOn.setOpaque(true);
        jLabelSignOn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelSignOnMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelSignOnMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelSignOnMouseEntered(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jFieldUser)
                    .addComponent(jFieldPassword)
                    .addComponent(jButtonLogin, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE))
                .addGap(42, 42, 42))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelSignOn)
                .addGap(108, 108, 108))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jFieldUser, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jFieldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonLogin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addComponent(jLabelSignOn)
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

    private void jLabelSignOnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSignOnMouseClicked
        dispose();
        
        RegisterScreen register_screen = new RegisterScreen();
        register_screen.show();
    }//GEN-LAST:event_jLabelSignOnMouseClicked

    private void jLabelSignOnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSignOnMouseEntered
        jLabelSignOn.setForeground(Color.red);
    }//GEN-LAST:event_jLabelSignOnMouseEntered

    private void jLabelSignOnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSignOnMouseExited
        jLabelSignOn.setForeground(Color.blue);
    }//GEN-LAST:event_jLabelSignOnMouseExited

    private void jButtonLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonLoginMouseClicked
        String user = jFieldUser.getText();
        String password = jFieldPassword.getText();
        
        if(functions.IsNull(user) || functions.IsNull(password)){
            InfoDialog info_window = new InfoDialog();
            info_window.SetMessage("Preencha os campos de usuário e senha corretamente!");
            return;
        }
        
        System.out.println(user);
        System.out.println(password);
    }//GEN-LAST:event_jButtonLoginMouseClicked

    private void jButtonLoginMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonLoginMouseEntered
        jButtonLogin.setBackground(Color.gray);
    }//GEN-LAST:event_jButtonLoginMouseEntered

    private void jButtonLoginMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonLoginMouseExited
        jButtonLogin.setBackground(Color.lightGray);
    }//GEN-LAST:event_jButtonLoginMouseExited

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonLogin;
    private javax.swing.JPasswordField jFieldPassword;
    private javax.swing.JTextField jFieldUser;
    private javax.swing.JLabel jLabelSignOn;
    // End of variables declaration//GEN-END:variables
}
