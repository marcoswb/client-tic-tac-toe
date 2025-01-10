package view;

import java.awt.Color;
import utils.Functions;
import controller.API;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utils.ResponseModel;

public class RegisterScreen extends javax.swing.JFrame {

    public Functions functions = new Functions();
    private static final Logger LOGGER = LogManager.getLogger();

    public RegisterScreen() {
        initComponents();
        getContentPane().setBackground(new Color(44, 62, 80));

        jFieldName.setForeground(Color.GRAY);
        jFieldName.setText("Informe seu nome...");

        jFieldUser.setForeground(Color.GRAY);
        jFieldUser.setText("Informe seu usuário...");

        jFieldPassword.setForeground(Color.GRAY);
        jFieldPassword.setEchoChar((char) 0);
        jFieldPassword.setText("Informe sua senha...");
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
        setBackground(new java.awt.Color(44, 62, 80));
        setResizable(false);

        jFieldUser.setForeground(new java.awt.Color(204, 204, 204));
        jFieldUser.setToolTipText("");
        jFieldUser.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jFieldUser.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jFieldUserFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jFieldUserFocusLost(evt);
            }
        });

        jButtonSignOn.setBackground(new java.awt.Color(236, 240, 241));
        jButtonSignOn.setForeground(new java.awt.Color(0, 0, 0));
        jButtonSignOn.setText("Sign On");
        jButtonSignOn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonSignOnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonSignOnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonSignOnMouseExited(evt);
            }
        });

        jFieldPassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jFieldPasswordFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jFieldPasswordFocusLost(evt);
            }
        });

        jLabelLogin.setBackground(new java.awt.Color(44, 62, 80));
        jLabelLogin.setForeground(new java.awt.Color(120, 94, 134));
        jLabelLogin.setText("Login");
        jLabelLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelLoginMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelLoginMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelLoginMouseExited(evt);
            }
        });

        jFieldName.setForeground(new java.awt.Color(204, 204, 204));
        jFieldName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jFieldNameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jFieldNameFocusLost(evt);
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

    private void jLabelLoginMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelLoginMouseEntered
        jLabelLogin.setForeground(Color.lightGray);
        jLabelLogin.setBackground(new Color(44, 62, 80));
    }//GEN-LAST:event_jLabelLoginMouseEntered

    private void jLabelLoginMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelLoginMouseExited
        jLabelLogin.setForeground(new Color(120, 94, 134));
        jLabelLogin.setBackground(new Color(44, 62, 80));
    }//GEN-LAST:event_jLabelLoginMouseExited

    private void jButtonSignOnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonSignOnMouseEntered
        jButtonSignOn.setBackground(Color.lightGray);
    }//GEN-LAST:event_jButtonSignOnMouseEntered

    private void jButtonSignOnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonSignOnMouseExited
        jButtonSignOn.setBackground(new Color(236, 240, 241));
    }//GEN-LAST:event_jButtonSignOnMouseExited

    private void jButtonSignOnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonSignOnMouseClicked
        try {
            String name = jFieldName.getText();
            String user = jFieldUser.getText();
            String password = jFieldPassword.getText();

            if (functions.IsNull(name)) {
                InfoDialog info_window = new InfoDialog();
                info_window.SetMessage("Preencha o campo de nome do usuário corretamente!");
                jFieldName.requestFocus();
                return;
            } else if (functions.IsNull(user)) {
                InfoDialog info_window = new InfoDialog();
                info_window.SetMessage("Preencha o campo de usuário corretamente!");
                jFieldUser.requestFocus();
                return;
            } else if (functions.IsNull(password)) {
                InfoDialog info_window = new InfoDialog();
                info_window.SetMessage("Preencha o campo de senha corretamente!");
                jFieldPassword.requestFocus();
                return;
            }

            API api = new API();
            ResponseModel response = api.CreateUser(name, user, password);

            InfoDialog info_window = new InfoDialog();
            if (response.getResponseCode() == 200) {
                info_window.SetMessage("Usuário criado com sucesso!");
                jFieldName.setText("");
                jFieldUser.setText("");
                jFieldPassword.setText("");
            } else {
                info_window.SetMessage("Erro ao criar usuário!\n" + response.getResponseText());
            }
        } catch (Exception ex) {
            LOGGER.error("Erro na função jButtonSignOnMouseClicked `{}`", ex.getMessage());
        }

    }//GEN-LAST:event_jButtonSignOnMouseClicked

    private void jLabelLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelLoginMouseClicked

        dispose();

        LoginScreen login_screen = new LoginScreen();
        login_screen.show();
    }//GEN-LAST:event_jLabelLoginMouseClicked

    private void jFieldNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jFieldNameFocusGained
        if (jFieldName.getText().equals("Informe seu nome...")) {
            jFieldName.setText("");
            jFieldName.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_jFieldNameFocusGained

    private void jFieldNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jFieldNameFocusLost
        if (jFieldName.getText().isEmpty()) {
            jFieldName.setForeground(Color.GRAY);
            jFieldName.setText("Informe seu nome...");
        }
    }//GEN-LAST:event_jFieldNameFocusLost

    private void jFieldUserFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jFieldUserFocusGained
        if (jFieldUser.getText().equals("Informe seu usuário...")) {
            jFieldUser.setText("");
            jFieldUser.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_jFieldUserFocusGained

    private void jFieldUserFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jFieldUserFocusLost
        if (jFieldUser.getText().isEmpty()) {
            jFieldUser.setForeground(Color.GRAY);
            jFieldUser.setText("Informe seu usuário...");
        }
    }//GEN-LAST:event_jFieldUserFocusLost

    private void jFieldPasswordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jFieldPasswordFocusGained
        if (String.valueOf(jFieldPassword.getPassword()).equals("Informe sua senha...")) {
            jFieldPassword.setText("");
            jFieldPassword.setEchoChar('•');
            jFieldPassword.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_jFieldPasswordFocusGained

    private void jFieldPasswordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jFieldPasswordFocusLost
        if (String.valueOf(jFieldPassword.getPassword()).isEmpty()) {
            jFieldPassword.setForeground(Color.GRAY);
            jFieldPassword.setEchoChar((char) 0);
            jFieldPassword.setText("Informe sua senha...");
        }
    }//GEN-LAST:event_jFieldPasswordFocusLost

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
            LOGGER.error("Erro na função main 1 `{}`", ex.getMessage());
        } catch (InstantiationException ex) {
            LOGGER.error("Erro na função main 2 `{}`", ex.getMessage());
        } catch (IllegalAccessException ex) {
            LOGGER.error("Erro na função main 3 `{}`", ex.getMessage());
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            LOGGER.error("Erro na função main 4 `{}`", ex.getMessage());
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
