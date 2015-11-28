package by.bsuir.firmclient;

import by.bsuir.firmclient.rmi.Commander;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class MainClient extends javax.swing.JFrame {

    private static Commander commander;
    
    public MainClient() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        RegistrationjButton = new javax.swing.JButton();
        workAreaPanel2 = new by.bsuir.firmclient.panels.WorkAreaPanel();
        LoginjLabel = new javax.swing.JLabel();
        ExitjButton = new javax.swing.JButton();
        UserManagejButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        RegistrationjButton.setText("Аутентификация");
        RegistrationjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegistrationjButtonActionPerformed(evt);
            }
        });

        LoginjLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        ExitjButton.setText("Выход");
        ExitjButton.setEnabled(false);
        ExitjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitjButtonActionPerformed(evt);
            }
        });

        UserManagejButton.setText("Управление пользователями");
        UserManagejButton.setEnabled(false);
        UserManagejButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UserManagejButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(workAreaPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(UserManagejButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(LoginjLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RegistrationjButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ExitjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ExitjButton, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                        .addComponent(RegistrationjButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(LoginjLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(UserManagejButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(workAreaPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void RegistrationjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegistrationjButtonActionPerformed
        AutentificationJDialog dial = new AutentificationJDialog(this);
    }//GEN-LAST:event_RegistrationjButtonActionPerformed

    private void ExitjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitjButtonActionPerformed
        exitUser();
    }//GEN-LAST:event_ExitjButtonActionPerformed

    private void UserManagejButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UserManagejButtonActionPerformed
        UserManagingJDialog dial = new UserManagingJDialog();
    }//GEN-LAST:event_UserManagejButtonActionPerformed

    public static void main(String args[]) throws RemoteException, NotBoundException {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                        javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainClient().setVisible(true);
            }
        });
    }
    
    //own functions
    public void logInUser(String login){
        this.LoginjLabel.setText(login);
        this.ExitjButton.setEnabled(true);
        this.RegistrationjButton.setEnabled(false);
        this.workAreaPanel2.updateUserData(login);
        //Peredelat'
        if("admin".equals(login)){
            this.UserManagejButton.setEnabled(true);
        }
    }
    private void exitUser(){
        this.LoginjLabel.setText("");
        this.ExitjButton.setEnabled(false);
        this.RegistrationjButton.setEnabled(true);
        this.workAreaPanel2.updateUserData(null);
        this.UserManagejButton.setEnabled(false);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ExitjButton;
    private javax.swing.JLabel LoginjLabel;
    private javax.swing.JButton RegistrationjButton;
    private javax.swing.JButton UserManagejButton;
    private by.bsuir.firmclient.panels.WorkAreaPanel workAreaPanel2;
    // End of variables declaration//GEN-END:variables
}
