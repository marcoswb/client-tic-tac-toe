package view;

import controller.API;
import java.awt.Color;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utils.Functions;
import utils.ResponseModel;

public class LoginScreen extends javax.swing.JFrame {
    
    public Functions functions = new Functions();
    private static final Logger LOGGER = LogManager.getLogger();

    public LoginScreen() {
        initComponents();
        getContentPane().setBackground(new Color(44, 62, 80));

        jFieldUser.setForeground(Color.GRAY);
        jFieldUser.setText("Informe seu usuário...");

        jFieldPassword.setForeground(Color.GRAY);
        jFieldPassword.setEchoChar((char) 0);
        jFieldPassword.setText("Informe sua senha...");
    }

    private void login() {
        try {
            String user = jFieldUser.getText();
            String password = jFieldPassword.getText();

            if (functions.IsNull(user)) {
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
            ResponseModel response = api.Login(user, password);

            if (response.getResponseCode() == 200) {
                dispose();

                MainScreen main_screen = new MainScreen(user);
                main_screen.show();
            } else {
                InfoDialog info_window = new InfoDialog();
                info_window.SetMessage("Erro ao realizar Login!\n" + response.getResponseText());
            }
        } catch (Exception ex) {
            System.out.println("TESTEEEEEEE" + ex);
        }
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
        setBackground(new java.awt.Color(44, 62, 80));
        setForeground(new java.awt.Color(44, 62, 80));
        setResizable(false);

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

        jFieldPassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jFieldPasswordFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jFieldPasswordFocusLost(evt);
            }
        });
        jFieldPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jFieldPasswordKeyPressed(evt);
            }
        });

        jButtonLogin.setBackground(new java.awt.Color(236, 240, 241));
        jButtonLogin.setForeground(new java.awt.Color(0, 0, 0));
        jButtonLogin.setLabel("Login");
        jButtonLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonLoginMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonLoginMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonLoginMouseExited(evt);
            }
        });

        jLabelSignOn.setBackground(new java.awt.Color(44, 62, 80));
        jLabelSignOn.setForeground(new java.awt.Color(120, 94, 134));
        jLabelSignOn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelSignOn.setText("Cadastrar-se");
        jLabelSignOn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabelSignOn.setOpaque(true);
        jLabelSignOn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelSignOnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelSignOnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelSignOnMouseExited(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelSignOn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jFieldUser)
                    .addComponent(jFieldPassword)
                    .addComponent(jButtonLogin, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE))
                .addGap(42, 42, 42))
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

    private void jLabelSignOnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSignOnMouseClicked
        dispose();

        RegisterScreen register_screen = new RegisterScreen();
        register_screen.show();
    }//GEN-LAST:event_jLabelSignOnMouseClicked

    private void jLabelSignOnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSignOnMouseEntered
        jLabelSignOn.setForeground(Color.lightGray);
        jLabelSignOn.setBackground(new Color(44, 62, 80));
    }//GEN-LAST:event_jLabelSignOnMouseEntered

    private void jLabelSignOnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSignOnMouseExited
        jLabelSignOn.setForeground(new Color(120, 94, 134));
        jLabelSignOn.setBackground(new Color(44, 62, 80));
    }//GEN-LAST:event_jLabelSignOnMouseExited

    private void jButtonLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonLoginMouseClicked
        login();
    }//GEN-LAST:event_jButtonLoginMouseClicked

    private void jButtonLoginMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonLoginMouseEntered
        jButtonLogin.setBackground(Color.lightGray);
    }//GEN-LAST:event_jButtonLoginMouseEntered

    private void jButtonLoginMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonLoginMouseExited
        jButtonLogin.setBackground(new Color(236, 240, 241));
    }//GEN-LAST:event_jButtonLoginMouseExited

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

    private void jFieldPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFieldPasswordKeyPressed
        if (evt.getKeyCode() == 10) {
            login();
        }
    }//GEN-LAST:event_jFieldPasswordKeyPressed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            LOGGER.error("Erro na função getMessageKey 1 `{}`", ex.getMessage());
        }
        //</editor-fold>
        
        //</editor-fold>

        java.awt.EventQueue.invokeLater(() -> {
            new LoginScreen().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonLogin;
    private javax.swing.JPasswordField jFieldPassword;
    private javax.swing.JTextField jFieldUser;
    private javax.swing.JLabel jLabelSignOn;
    // End of variables declaration//GEN-END:variables
}
