package view;

import controller.API;
import javax.swing.table.DefaultTableModel;
import utils.Functions;
import utils.ResponseModel;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
import controller.MainController;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class MainScreen extends javax.swing.JFrame {

    private String nickname;
    public Functions functions = new Functions();
    private volatile boolean startCheck = false;
    private final MainController mainController;
    private static final Logger LOGGER = LogManager.getLogger();
    
    public MainScreen(String nickname) {
        initComponents();
        setNickname(nickname);
        
        stylesheetScreen();
        fillTablePlayers();
        fillTableHistory();

        this.mainController = new MainController(this);
        mainController.checking();
        setStartCheck(true);
    }

    private MainScreen() {
        this.mainController = new MainController(this);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        jTablePlayers = new javax.swing.JTable();
        jButtonStartRandonGame = new javax.swing.JButton();
        jButtonStartGameWithMachine = new javax.swing.JButton();
        jButtonStartGame = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableHistory = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Jogo da Velha");
        setBackground(new java.awt.Color(44, 62, 80));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jScrollPane3.setForeground(new java.awt.Color(44, 62, 80));

        jTablePlayers.setBackground(new java.awt.Color(236, 240, 241));
        jTablePlayers.setForeground(new java.awt.Color(0, 0, 0));
        jTablePlayers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Jogadores"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTablePlayers.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTablePlayers.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(jTablePlayers);
        if (jTablePlayers.getColumnModel().getColumnCount() > 0) {
            jTablePlayers.getColumnModel().getColumn(0).setResizable(false);
        }

        jButtonStartRandonGame.setBackground(new java.awt.Color(236, 240, 241));
        jButtonStartRandonGame.setForeground(new java.awt.Color(0, 0, 0));
        jButtonStartRandonGame.setText("Iniciar partida aleatória");
        jButtonStartRandonGame.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonStartRandonGameMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonStartRandonGameMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonStartRandonGameMouseExited(evt);
            }
        });

        jButtonStartGameWithMachine.setBackground(new java.awt.Color(236, 240, 241));
        jButtonStartGameWithMachine.setForeground(new java.awt.Color(0, 0, 0));
        jButtonStartGameWithMachine.setText("Jogar contra o PC");
        jButtonStartGameWithMachine.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonStartGameWithMachineMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonStartGameWithMachineMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonStartGameWithMachineMouseExited(evt);
            }
        });

        jButtonStartGame.setBackground(new java.awt.Color(236, 240, 241));
        jButtonStartGame.setForeground(new java.awt.Color(0, 0, 0));
        jButtonStartGame.setText("Iniciar partida");
        jButtonStartGame.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonStartGameMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonStartGameMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonStartGameMouseExited(evt);
            }
        });

        jScrollPane1.setForeground(new java.awt.Color(44, 62, 80));

        jTableHistory.setBackground(new java.awt.Color(236, 240, 241));
        jTableHistory.setForeground(new java.awt.Color(0, 0, 0));
        jTableHistory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Adversário", "Resultado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableHistory.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTableHistory);
        if (jTableHistory.getColumnModel().getColumnCount() > 0) {
            jTableHistory.getColumnModel().getColumn(0).setResizable(false);
            jTableHistory.getColumnModel().getColumn(1).setResizable(false);
        }

        jLabel1.setBackground(new java.awt.Color(44, 62, 80));
        jLabel1.setForeground(new java.awt.Color(236, 240, 241));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jButtonStartRandonGame, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
                        .addComponent(jButtonStartGame, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonStartGameWithMachine, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonStartRandonGame, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonStartGameWithMachine)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                        .addComponent(jButtonStartGame)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    private void stylesheetScreen(){
        getContentPane().setBackground(new Color(44, 62, 80));
        
        jTableHistory.getTableHeader().setBackground(new Color(54, 54, 54));
        jTableHistory.getTableHeader().setForeground(new Color(236, 240, 241));

        jTablePlayers.getTableHeader().setBackground(new Color(54, 54, 54));
        jTablePlayers.getTableHeader().setForeground(new Color(236, 240, 241));
        
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER );
        jTableHistory.setDefaultRenderer(String.class, centerRenderer);
        jTablePlayers.setDefaultRenderer(String.class, centerRenderer);
        
        this.setTitle("Jogo da Velha - jogador "+this.getNickname());
        
    }
    public void fillTablePlayers() {
        try {
            API api = new API();
            ResponseModel response = api.UserStatus();

            if (response.getResponseCode() == 200) {
                DefaultTableModel tblPlayers = (DefaultTableModel) jTablePlayers.getModel();
                tblPlayers.setRowCount(0);

                String responseText = response.getResponseText().toString();
                JSONObject jsonData = new JSONObject(responseText);

                Iterator iterator = jsonData.keys();
                while (iterator.hasNext()) {
                    String status = iterator.next().toString();
                    if (status.equals("online")) {
                        JSONArray options = jsonData.getJSONArray(status);

                        for (int index = 0; index < options.length(); index++) {
                            String nickname_user = options.get(index).toString();

                            if (!nickname_user.equals(this.getNickname())) {
                                String line[] = {nickname_user};
                                tblPlayers.addRow(line);
                            }
                        }
                    }
                }
            } else {
                InfoDialog info_window = new InfoDialog();
                info_window.SetMessage("Erro ao recuperar dados!\n" + response.getResponseText());
            }
        } catch (Exception ex) {
            LOGGER.error("Erro na função fillTablePlayers `{}`", ex.getMessage());
        }
    }

    private void fillTableHistory() {
        try {
            API api = new API();
            ResponseModel response = api.getHistoryUser(getNickname());

            if (response.getResponseCode() == 200) {
                DefaultTableModel tblPlayers = (DefaultTableModel) jTableHistory.getModel();
                tblPlayers.setRowCount(0);
                jTableHistory.setAutoCreateRowSorter(true);

                String responseText = response.getResponseText().toString();
                JSONArray jsonData = new JSONArray(responseText);

                for (int index = 0; index < jsonData.length(); index++) {
                    JSONObject data = new JSONObject(jsonData.get(index).toString());

                    String result = data.get("result").toString();
                    String oponent = data.get("oponent").toString();

                    String line[] = {oponent, result};
                    tblPlayers.addRow(line);
                }
            } else {
                InfoDialog info_window = new InfoDialog();
                info_window.SetMessage("Erro ao recuperar dados!\n" + response.getResponseText());
            }
        } catch (Exception ex) {
            LOGGER.error("Erro na função fillTableHistory `{}`", ex.getMessage());
        }
    }

    private void logout() throws Exception {
        API api = new API();
        api.Logout(this.getNickname());
    }

    public void reloadWindow() {
        fillTableHistory();
        fillTablePlayers();
        setStartCheck(true);
        mainController.checking();
    }

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        try {
            setVisible(false);
            logout();
        } catch (Exception ex) {
            LOGGER.error("Erro na função formWindowClosing `{}`", ex.getMessage());
        }
    }//GEN-LAST:event_formWindowClosing

    private void jButtonStartGameMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonStartGameMouseExited
        jButtonStartGame.setBackground(new Color(236, 240, 241));
    }//GEN-LAST:event_jButtonStartGameMouseExited

    private void jButtonStartGameMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonStartGameMouseEntered
        jButtonStartGame.setBackground(Color.lightGray);
    }//GEN-LAST:event_jButtonStartGameMouseEntered

    private void jButtonStartGameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonStartGameMouseClicked
        try {
            int selectedRow = jTablePlayers.getSelectedRow();
            if (selectedRow == -1) {
                InfoDialog info_window = new InfoDialog();
                info_window.SetMessage("Selecione um usuário para jogar ou inicie uma partida aleatória!");
                return;
            }

            String opponent = jTablePlayers.getValueAt(selectedRow, 0).toString();
            mainController.invitePlayer(getNickname(), opponent);
            new InfoDialog().SetMessage("Convite enviado!");
        } catch (Exception ex) {
            LOGGER.error("Erro na função jButtonStartGameMouseClicked `{}`", ex.getMessage());
        }
    }//GEN-LAST:event_jButtonStartGameMouseClicked

    private void jButtonStartGameWithMachineMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonStartGameWithMachineMouseExited
        jButtonStartGameWithMachine.setBackground(new Color(236, 240, 241));
    }//GEN-LAST:event_jButtonStartGameWithMachineMouseExited

    private void jButtonStartGameWithMachineMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonStartGameWithMachineMouseEntered
        jButtonStartGameWithMachine.setBackground(Color.lightGray);
    }//GEN-LAST:event_jButtonStartGameWithMachineMouseEntered

    private void jButtonStartGameWithMachineMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonStartGameWithMachineMouseClicked
        new InfoDialog().SetMessage("Iniciar partida contra o computador");
    }//GEN-LAST:event_jButtonStartGameWithMachineMouseClicked

    private void jButtonStartRandonGameMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonStartRandonGameMouseExited
        jButtonStartRandonGame.setBackground(new Color(236, 240, 241));
    }//GEN-LAST:event_jButtonStartRandonGameMouseExited

    private void jButtonStartRandonGameMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonStartRandonGameMouseEntered
        jButtonStartRandonGame.setBackground(Color.lightGray);
    }//GEN-LAST:event_jButtonStartRandonGameMouseEntered

    private void jButtonStartRandonGameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonStartRandonGameMouseClicked
        try {
            startLoading();
            mainController.startRandomGame();
        } catch (Exception ex) {
            LOGGER.error("Erro na função jButtonStartRandonGameMouseClicked `{}`", ex.getMessage());
        }
    }//GEN-LAST:event_jButtonStartRandonGameMouseClicked

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("GTK+".equals(info.getName())) {
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

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainScreen().setVisible(true);
            }
        });
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonStartGame;
    private javax.swing.JButton jButtonStartGameWithMachine;
    private javax.swing.JButton jButtonStartRandonGame;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTableHistory;
    private javax.swing.JTable jTablePlayers;
    // End of variables declaration//GEN-END:variables
    
    public void startLoading(){
        jLabel1.setText("Procurando jogador...");
    }
    
    public void stopLoading(){
        jLabel1.setText("");
    }

    public boolean isStartCheck() {
        return startCheck;
    }

    public void setStartCheck(boolean startCheck) {
        this.startCheck = startCheck;
    }
}
