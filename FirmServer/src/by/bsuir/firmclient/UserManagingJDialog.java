package by.bsuir.firmclient;

import by.bsuir.firmclient.rmi.Commander;
import by.bsuir.firmserver.subjectarea.User;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class UserManagingJDialog extends javax.swing.JDialog {

    public UserManagingJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        updateTableData();
    }

    public UserManagingJDialog() {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                UserManagingJDialog dialog = new UserManagingJDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    private void updateTableData(){
        try {
            Commander commander = new Commander();
            List <User> users = (List <User>) commander.getUsers.execute();
            DefaultTableModel usersTable = (DefaultTableModel) UsersjTable.getModel();
            for(int i = usersTable.getRowCount(); i > 0; i--){
                usersTable.removeRow(0);
            }
            for(User user : users){
                String[] temp = {user.getLogin(), user.getPassword()};
                usersTable.addRow(temp);
            }
        } catch (RemoteException | NotBoundException ex) {
            Logger.getLogger(UserManagingJDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void resetInputsValues(){
        LoginjTextField.setText("");
        PasswordjTextField.setText("");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        AddUserjButton = new javax.swing.JButton();
        DeleteUserjButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        UsersjTable = new javax.swing.JTable();
        LoginjTextField = new javax.swing.JTextField();
        PasswordjTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        ErrorjLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        AddUserjButton.setText("Добавить пользователя");
        AddUserjButton.setAutoscrolls(true);
        AddUserjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddUserjButtonActionPerformed(evt);
            }
        });

        DeleteUserjButton.setText("Удалить пользователя");
        DeleteUserjButton.setAutoscrolls(true);
        DeleteUserjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteUserjButtonActionPerformed(evt);
            }
        });

        UsersjTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null}
            },
            new String [] {
                "Логин", "Пароль"
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
        jScrollPane2.setViewportView(UsersjTable);

        LoginjTextField.setToolTipText("");

        jLabel1.setText("Логин");

        jLabel2.setText("Пароль");

        ErrorjLabel.setForeground(new java.awt.Color(255, 51, 51));
        ErrorjLabel.setText("Ошибка ввода, повторите попытку");
        ErrorjLabel.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(AddUserjButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(DeleteUserjButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(LoginjTextField)
                    .addComponent(PasswordjTextField)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ErrorjLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(40, 40, 40))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 26, Short.MAX_VALUE)
                        .addComponent(DeleteUserjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LoginjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PasswordjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(AddUserjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ErrorjLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void DeleteUserjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteUserjButtonActionPerformed
        try {
            Commander commander = new Commander();
            int row = this.UsersjTable.getSelectedRow();
            String login = (String) this.UsersjTable.getValueAt(row, 0);
            commander.deleteUserLogin.execute(login);
            updateTableData();
        } catch (RemoteException | NotBoundException ex) {
            Logger.getLogger(UserManagingJDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_DeleteUserjButtonActionPerformed

    private void AddUserjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddUserjButtonActionPerformed
        try {
            String login = LoginjTextField.getText();
            String password = PasswordjTextField.getText();
            String password2 = PasswordjTextField.getText();
            Commander commander = new Commander();
            if(!commander.registerUser.execute(login, password, password2)){
                this.ErrorjLabel.setEnabled(true);
            }
            else{
                updateTableData();
                resetInputsValues();
            }
        } catch (RemoteException | NotBoundException ex) {
            Logger.getLogger(UserManagingJDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_AddUserjButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddUserjButton;
    private javax.swing.JButton DeleteUserjButton;
    private javax.swing.JLabel ErrorjLabel;
    private javax.swing.JTextField LoginjTextField;
    private javax.swing.JTextField PasswordjTextField;
    private javax.swing.JTable UsersjTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
