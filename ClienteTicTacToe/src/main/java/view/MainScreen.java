package view;

import controller.API;
import javax.swing.table.DefaultTableModel;
import utils.Functions;
import utils.ResponseModel;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
import controller.MainController;

public final class MainScreen extends javax.swing.JFrame {

    private String nickname;
    public Functions functions = new Functions();
    private volatile boolean startCheck = false;
    private final MainController mainController;
    
    public MainScreen(String nickname) {
        initComponents();

        setNickname(nickname);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableHistory = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButtonStartRandonGame = new javax.swing.JButton();
        jButtonStartGameWithMachine = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTablePlayers = new javax.swing.JTable();
        jButtonStartGame = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Jogo da Velha");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jTableHistory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Adversário", "Resultado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableHistory);
        if (jTableHistory.getColumnModel().getColumnCount() > 0) {
            jTableHistory.getColumnModel().getColumn(0).setResizable(false);
            jTableHistory.getColumnModel().getColumn(1).setResizable(false);
        }

        jButtonStartRandonGame.setText("Iniciar partida aleatória");
        jButtonStartRandonGame.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonStartRandonGameMouseClicked(evt);
            }
        });

        jButtonStartGameWithMachine.setText("Jogar contra o PC");
        jButtonStartGameWithMachine.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonStartGameWithMachineMouseClicked(evt);
            }
        });

        jTablePlayers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Jogador"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jTablePlayers);

        jButtonStartGame.setText("Iniciar partida");
        jButtonStartGame.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonStartGameMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 493, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(149, 149, 149)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButtonStartGameWithMachine, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(jButtonStartRandonGame, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonStartGame, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(226, 226, 226)
                        .addComponent(jLabel1)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jButtonStartRandonGame)
                .addGap(18, 18, 18)
                .addComponent(jButtonStartGameWithMachine)
                .addGap(18, 18, 18)
                .addComponent(jButtonStartGame)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(79, 79, 79)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            System.out.println("TESTEEEEEEE" + ex);
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
            System.out.println("TESTEEEEEEE" + ex);
        }
    }

    private void jButtonStartRandonGameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonStartRandonGameMouseClicked
        try {
            startLoading();
            mainController.startGame();
        } catch (Exception ex) {
            System.out.println("TESTEEEEEEE" + ex);
        }
    }//GEN-LAST:event_jButtonStartRandonGameMouseClicked

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

    private void jButtonStartGameWithMachineMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonStartGameWithMachineMouseClicked
        System.out.println("Iniciar partida contra o computador");
    }//GEN-LAST:event_jButtonStartGameWithMachineMouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        try {
            setVisible(false);
            logout();
        } catch (Exception ex) {
            System.out.println("ERRROOOOOO 1: " + ex.toString());
        }
    }//GEN-LAST:event_formWindowClosing

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
            System.out.println("TESTEEEEEEE" + ex);
        }

    }//GEN-LAST:event_jButtonStartGameMouseClicked

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
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
