package by.bsuir.firmclient.panels;

import by.bsuir.firmclient.rmi.Commander;
import by.bsuir.firmserver.subjectarea.Firm;
import by.bsuir.firmserver.subjectarea.Perfomance;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

public class WorkAreaPanel extends javax.swing.JPanel {
    
    private String login;
    
    public WorkAreaPanel() {
        initComponents();
    }
    
    private void cleanFirmTableData(){
        DefaultTableModel tableModel = (DefaultTableModel) FirmsTable.getModel();
        for(int i = tableModel.getRowCount(); i > 0; i--){
            tableModel.removeRow(0);
        }
    }
    
    private void cleanPerfomanceData(){
        DefaultComboBoxModel worksComboBoxModel = (DefaultComboBoxModel) this.FirmjComboBox.getModel();
        worksComboBoxModel.removeAllElements();
    }
    
    private void updateFirmTableData(List<Firm> firms){
        DefaultTableModel tableModel = (DefaultTableModel) FirmsTable.getModel();
        for(int i = tableModel.getRowCount(); i > 0; i--){
            tableModel.removeRow(0);
        }
        for(Firm firm :firms){
            Object[] tempMas = {firm.getTitle(),firm.getRegistration_date(),firm.getAdress(),firm.getStructure()};
            tableModel.addRow(tempMas);
        }
    }
    
    private void updatePerfomanceData(List<Firm> firms){
        DefaultComboBoxModel worksComboBoxModel = (DefaultComboBoxModel) this.FirmjComboBox.getModel();
        for(Firm firm : firms){
            worksComboBoxModel.addElement(firm.getTitle());
        }
    }
    
    private void updatePerfomanceValue(String firmTitle){
        try {
            if(firmTitle != null){
                Commander commander = new Commander();
                Perfomance tempPerfomance = (Perfomance)commander.getFirmPerfomance.execute(firmTitle);
                if(tempPerfomance != null){
                    this.IncomejSpinner.getModel().setValue((int)tempPerfomance.getIncome());
                    this.CostsjSpinner.getModel().setValue((int)tempPerfomance.getCosts());
                    this.ProfitjSpinner.getModel().setValue((int)tempPerfomance.getProfit());
                    this.FixedAssetsjSpinner.getModel().setValue((int)tempPerfomance.getFixed_assets());
                    this.CurrentAssetsjSpinner.getModel().setValue((int)tempPerfomance.getCurrent_assets());
                    this.OwnedAssetsjSpinner.getModel().setValue((int)tempPerfomance.getOwned_assets());
                    this.ShortTermDutiesjSpinner.getModel().setValue((int)tempPerfomance.getShort_term_duties());
                    this.LongTermDutiesjSpinner.getModel().setValue((int)tempPerfomance.getLong_term_duties());
                    this.EquityjSpinner.getModel().setValue((int)tempPerfomance.getEquity());
                    this.BorrowedCapitaljSpinner.getModel().setValue((int)tempPerfomance.getBorrowed_capital());
                }
                else{
                    cleanPerfomanceValue();
                }
            }
            else{
                cleanPerfomanceValue();
            }
        } catch (RemoteException ex) {
            Logger.getLogger(WorkAreaPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(WorkAreaPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void cleanPerfomanceValue(){
        this.IncomejSpinner.getModel().setValue(0);
        this.CostsjSpinner.getModel().setValue(0);
        this.ProfitjSpinner.getModel().setValue(0);
        this.FixedAssetsjSpinner.getModel().setValue(0);
        this.CurrentAssetsjSpinner.getModel().setValue(0);
        this.OwnedAssetsjSpinner.getModel().setValue(0);
        this.ShortTermDutiesjSpinner.getModel().setValue(0);
        this.LongTermDutiesjSpinner.getModel().setValue(0);
        this.EquityjSpinner.getModel().setValue(0);
        this.BorrowedCapitaljSpinner.getModel().setValue(0);
    }
    
    private void cleanValues(){
        cleanFirmTableData();
        cleanPerfomanceData();
        cleanPerfomanceValue();
    }
    
    public void updateUserData(String login){
        this.login = login;
        try {
            if(login != null){
                cleanValues();
                Commander commander = new Commander();
                List<Firm> firms = (List<Firm>) commander.getUserFirm.execute(login);
                if(firms != null && firms.size() > 0){
                    updateFirmTableData(firms);
                    updatePerfomanceData(firms);
                    updatePerfomanceValue(firms.get(0).getTitle());
                }
            }
            else{
                cleanValues();
            }
        } catch (RemoteException | NotBoundException ex) {
            Logger.getLogger(WorkAreaPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        dateChooserPanel1 = new datechooser.beans.DateChooserPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        FirmsTable = new javax.swing.JTable();
        RegisterFirmjButton = new javax.swing.JButton();
        DeleteFirmjButton = new javax.swing.JButton();
        RedactFirmjButton = new javax.swing.JButton();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        FirmTitlejTextField = new javax.swing.JTextField();
        FirmAdressjTextField = new javax.swing.JTextField();
        FirmStructurejTextField = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        FirmdateChooserPanel = new datechooser.beans.DateChooserPanel();
        ConfirmFirmjButton = new javax.swing.JButton();
        DeclineFirmjButton = new javax.swing.JButton();
        FirmErrorjLabel = new javax.swing.JLabel();
        ConfirmRedactjButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        FirmjComboBox = new javax.swing.JComboBox();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        IncomejSpinner = new javax.swing.JSpinner();
        CostsjSpinner = new javax.swing.JSpinner();
        ProfitjSpinner = new javax.swing.JSpinner();
        FixedAssetsjSpinner = new javax.swing.JSpinner();
        CurrentAssetsjSpinner = new javax.swing.JSpinner();
        OwnedAssetsjSpinner = new javax.swing.JSpinner();
        LongTermDutiesjSpinner = new javax.swing.JSpinner();
        ShortTermDutiesjSpinner = new javax.swing.JSpinner();
        BorrowedCapitaljSpinner = new javax.swing.JSpinner();
        EquityjSpinner = new javax.swing.JSpinner();
        SavePerfomancejButton = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        Coef1jButton = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        Coef1jTextField = new javax.swing.JTextField();
        Coef2jTextField = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        Coef3jTextField = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        Coef4jTextField = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        Coef8jTextField = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        Coef5jTextField = new javax.swing.JTextField();
        Coef6jTextField = new javax.swing.JTextField();
        Coef7jTextField = new javax.swing.JTextField();
        Coef2jButton = new javax.swing.JButton();
        Coef3jButton = new javax.swing.JButton();
        Coef4jButton = new javax.swing.JButton();
        Coef5jButton = new javax.swing.JButton();
        Coef6jButton = new javax.swing.JButton();
        Coef7jButton = new javax.swing.JButton();
        Coef8jButton = new javax.swing.JButton();
        CoefAlljButton = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();

        jButton1.setText("jButton1");

        FirmsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "Название", "Дата регистрации", "Адрес", "Структура предприятия"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(FirmsTable);

        RegisterFirmjButton.setText("Регистрация фирмы");
        RegisterFirmjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegisterFirmjButtonActionPerformed(evt);
            }
        });

        DeleteFirmjButton.setText("Удалить фирму");
        DeleteFirmjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteFirmjButtonActionPerformed(evt);
            }
        });

        RedactFirmjButton.setText("Редактировать");
        RedactFirmjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RedactFirmjButtonActionPerformed(evt);
            }
        });

        FirmTitlejTextField.setEnabled(false);

        FirmAdressjTextField.setEnabled(false);

        FirmStructurejTextField.setEnabled(false);

        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Адрес");

        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Название");

        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Структура");

        FirmdateChooserPanel.setCurrentView(new datechooser.view.appearance.AppearancesList("Light",
            new datechooser.view.appearance.ViewAppearance("custom",
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                    new java.awt.Color(0, 0, 0),
                    new java.awt.Color(0, 0, 255),
                    false,
                    true,
                    new datechooser.view.appearance.swing.ButtonPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                    new java.awt.Color(0, 0, 0),
                    new java.awt.Color(0, 0, 255),
                    true,
                    true,
                    new datechooser.view.appearance.swing.ButtonPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                    new java.awt.Color(0, 0, 255),
                    new java.awt.Color(0, 0, 255),
                    false,
                    true,
                    new datechooser.view.appearance.swing.ButtonPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                    new java.awt.Color(128, 128, 128),
                    new java.awt.Color(0, 0, 255),
                    false,
                    true,
                    new datechooser.view.appearance.swing.LabelPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                    new java.awt.Color(0, 0, 0),
                    new java.awt.Color(0, 0, 255),
                    false,
                    true,
                    new datechooser.view.appearance.swing.LabelPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                    new java.awt.Color(0, 0, 0),
                    new java.awt.Color(255, 0, 0),
                    false,
                    false,
                    new datechooser.view.appearance.swing.ButtonPainter()),
                (datechooser.view.BackRenderer)null,
                false,
                true)));
    FirmdateChooserPanel.setEnabled(false);
    FirmdateChooserPanel.setCalendarBackground(new java.awt.Color(204, 204, 255));

    ConfirmFirmjButton.setText("Сохранить");
    ConfirmFirmjButton.setEnabled(false);
    ConfirmFirmjButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            ConfirmFirmjButtonActionPerformed(evt);
        }
    });

    DeclineFirmjButton.setText("Отмена");
    DeclineFirmjButton.setEnabled(false);
    DeclineFirmjButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            DeclineFirmjButtonActionPerformed(evt);
        }
    });

    FirmErrorjLabel.setForeground(new java.awt.Color(255, 0, 0));
    FirmErrorjLabel.setText("Ошибка..");
    FirmErrorjLabel.setEnabled(false);

    ConfirmRedactjButton.setText("Редактировать");
    ConfirmRedactjButton.setEnabled(false);
    ConfirmRedactjButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            ConfirmRedactjButtonActionPerformed(evt);
        }
    });

    javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
    jDesktopPane1.setLayout(jDesktopPane1Layout);
    jDesktopPane1Layout.setHorizontalGroup(
        jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jDesktopPane1Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(FirmStructurejTextField)
                .addComponent(FirmAdressjTextField)
                .addComponent(FirmTitlejTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE))
            .addGap(27, 27, 27)
            .addComponent(FirmdateChooserPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(ConfirmFirmjButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(DeclineFirmjButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(FirmErrorjLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ConfirmRedactjButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    jDesktopPane1Layout.setVerticalGroup(
        jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jDesktopPane1Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jDesktopPane1Layout.createSequentialGroup()
                    .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(FirmTitlejTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(FirmAdressjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(27, 27, 27)
                    .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(FirmStructurejTextField)
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(30, 30, 30))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                    .addComponent(FirmdateChooserPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                    .addContainerGap())
                .addGroup(jDesktopPane1Layout.createSequentialGroup()
                    .addComponent(ConfirmFirmjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(DeclineFirmjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(FirmErrorjLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(ConfirmRedactjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
    );
    jDesktopPane1.setLayer(FirmTitlejTextField, javax.swing.JLayeredPane.DEFAULT_LAYER);
    jDesktopPane1.setLayer(FirmAdressjTextField, javax.swing.JLayeredPane.DEFAULT_LAYER);
    jDesktopPane1.setLayer(FirmStructurejTextField, javax.swing.JLayeredPane.DEFAULT_LAYER);
    jDesktopPane1.setLayer(jLabel19, javax.swing.JLayeredPane.DEFAULT_LAYER);
    jDesktopPane1.setLayer(jLabel20, javax.swing.JLayeredPane.DEFAULT_LAYER);
    jDesktopPane1.setLayer(jLabel21, javax.swing.JLayeredPane.DEFAULT_LAYER);
    jDesktopPane1.setLayer(FirmdateChooserPanel, javax.swing.JLayeredPane.DEFAULT_LAYER);
    jDesktopPane1.setLayer(ConfirmFirmjButton, javax.swing.JLayeredPane.DEFAULT_LAYER);
    jDesktopPane1.setLayer(DeclineFirmjButton, javax.swing.JLayeredPane.DEFAULT_LAYER);
    jDesktopPane1.setLayer(FirmErrorjLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
    jDesktopPane1.setLayer(ConfirmRedactjButton, javax.swing.JLayeredPane.DEFAULT_LAYER);

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel1Layout.createSequentialGroup()
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 610, Short.MAX_VALUE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(DeleteFirmjButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(RedactFirmjButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(RegisterFirmjButton, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jDesktopPane1)))
            .addContainerGap())
    );
    jPanel1Layout.setVerticalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel1Layout.createSequentialGroup()
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(RegisterFirmjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(DeleteFirmjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(RedactFirmjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(jDesktopPane1))
    );

    jTabbedPane1.addTab("Информация о фирмах", jPanel1);

    FirmjComboBox.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            FirmjComboBoxActionPerformed(evt);
        }
    });

    jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

    jLabel1.setText("Издержки");

    jLabel2.setText("Доход");

    jLabel3.setText("Прибыль");

    jLabel4.setText("Внеоборотные активы");

    jLabel5.setText("Оборотные активы");

    jLabel6.setText("Собственные оборотные активы");

    jLabel7.setText("Краткосрочные обязательства");

    jLabel8.setText("Долгосрочные обязательства");

    jLabel9.setText("Заёмный капитал");

    jLabel10.setText("Собственный капитал");

    javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
    jPanel4.setLayout(jPanel4Layout);
    jPanel4Layout.setHorizontalGroup(
        jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel4Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(IncomejSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CurrentAssetsjSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(FixedAssetsjSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(ProfitjSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(CostsjSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)))
            .addGap(0, 19, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(OwnedAssetsjSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EquityjSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(BorrowedCapitaljSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(ShortTermDutiesjSpinner, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(LongTermDutiesjSpinner, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addContainerGap(34, Short.MAX_VALUE))
    );
    jPanel4Layout.setVerticalGroup(
        jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel4Layout.createSequentialGroup()
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addContainerGap(35, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGap(52, 52, 52)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(LongTermDutiesjSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel8))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(ShortTermDutiesjSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(OwnedAssetsjSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(10, 10, 10)
                    .addComponent(BorrowedCapitaljSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(EquityjSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10)))
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(19, 19, 19)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGap(52, 52, 52)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(CostsjSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(ProfitjSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3)))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel6)
                                .addComponent(IncomejSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(94, 94, 94)))
                    .addGap(10, 10, 10)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(FixedAssetsjSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGap(18, 18, 18)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(CurrentAssetsjSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addContainerGap(134, Short.MAX_VALUE))
    );

    SavePerfomancejButton.setText("Сохранить");
    SavePerfomancejButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            SavePerfomancejButtonActionPerformed(evt);
        }
    });

    javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
    jPanel2.setLayout(jPanel2Layout);
    jPanel2Layout.setHorizontalGroup(
        jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel2Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(FirmjComboBox, 0, 98, Short.MAX_VALUE)
                .addComponent(SavePerfomancejButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addContainerGap())
    );
    jPanel2Layout.setVerticalGroup(
        jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel2Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addComponent(FirmjComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(SavePerfomancejButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addContainerGap())
    );

    jTabbedPane1.addTab("Финансовые показатели", jPanel2);

    Coef1jButton.setText("Рассчитать");

    jLabel11.setText("Коэф. автономии");

    Coef1jTextField.setEditable(false);

    Coef2jTextField.setEditable(false);

    jLabel12.setText("Коэффициент финансовой зависимости ");

    Coef3jTextField.setEditable(false);

    jLabel13.setText("Коэффициент соотношения заемных и собственных средств");

    Coef4jTextField.setEditable(false);

    jLabel14.setText(" Коэффициент маневренности собственных оборотных средств ");

    Coef8jTextField.setEditable(false);

    jLabel15.setText("Норма чистой прибыли ");

    jLabel16.setText("Текущая ликвидность");

    jLabel17.setText(" Коэффициент обеспеченности оборотного капитала собственными источниками финансирования ");

    jLabel18.setText(" Коэффициент соотношения мобильных и иммобилизованных активов ");

    Coef5jTextField.setEditable(false);

    Coef6jTextField.setEditable(false);

    Coef7jTextField.setEditable(false);

    Coef2jButton.setText("Рассчитать");

    Coef3jButton.setText("Рассчитать");

    Coef4jButton.setText("Рассчитать");

    Coef5jButton.setText("Рассчитать");

    Coef6jButton.setText("Рассчитать");

    Coef7jButton.setText("Рассчитать");

    Coef8jButton.setText("Рассчитать");

    CoefAlljButton.setText("Рассчитать все");

    jSeparator1.setBackground(new java.awt.Color(204, 204, 204));
    jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

    javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
    jPanel3.setLayout(jPanel3Layout);
    jPanel3Layout.setHorizontalGroup(
        jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel3Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(582, 582, 582)
                    .addComponent(CoefAlljButton, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel12)
                                .addComponent(jLabel11)
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel15)
                                .addComponent(jLabel18)
                                .addComponent(jLabel14)
                                .addComponent(jLabel16))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(Coef1jTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Coef5jTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Coef4jTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Coef3jTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Coef2jTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Coef6jTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Coef8jTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Coef7jTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Coef1jButton)
                            .addComponent(Coef2jButton)
                            .addComponent(Coef3jButton)
                            .addComponent(Coef4jButton)
                            .addComponent(Coef5jButton)
                            .addComponent(Coef6jButton)
                            .addComponent(Coef7jButton))
                        .addComponent(Coef8jButton))
                    .addGap(52, 52, 52))))
    );
    jPanel3Layout.setVerticalGroup(
        jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel3Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(Coef1jButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(Coef2jButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(Coef3jButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(Coef4jButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(Coef5jButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(Coef6jButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(Coef7jButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Coef7jTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Coef1jTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(Coef2jTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Coef3jTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(Coef4jTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(Coef5jTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(Coef6jTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(Coef8jButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Coef8jTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGap(1, 1, 1)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(26, 26, 26)
                    .addComponent(CoefAlljButton, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 40, Short.MAX_VALUE))
                .addComponent(jSeparator1))
            .addContainerGap())
    );

    jTabbedPane1.addTab("Финансовые коэфициенты", jPanel3);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jTabbedPane1)
            .addContainerGap())
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jTabbedPane1)
    );

    jTabbedPane1.getAccessibleContext().setAccessibleName("");
    }// </editor-fold>//GEN-END:initComponents

    private void DeleteFirmjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteFirmjButtonActionPerformed
        try {
            Commander commander = new Commander();
            int row = FirmsTable.getSelectedRow();
            String title = (String) FirmsTable.getValueAt(row, 0);
            Firm firm = new Firm(title,null,0,null,null);
            commander.deleteFirm.execute(firm);
            cleanValues();
            updateUserData(login);
        } catch (RemoteException | NotBoundException ex) {
            Logger.getLogger(WorkAreaPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_DeleteFirmjButtonActionPerformed

    private void RegisterFirmjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegisterFirmjButtonActionPerformed
        if(login != null && !login.equals(" ")){
            changeForRegisterFirm(true);
        }
    }//GEN-LAST:event_RegisterFirmjButtonActionPerformed

    private void DeclineFirmjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeclineFirmjButtonActionPerformed
        changeForRegisterFirm(false);
    }//GEN-LAST:event_DeclineFirmjButtonActionPerformed

    private void ConfirmFirmjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfirmFirmjButtonActionPerformed
        try {
            Commander commander = new Commander();
            String title = this.FirmTitlejTextField.getText();
            String structure = this.FirmStructurejTextField.getText();
            String adress = this.FirmAdressjTextField.getText();
            Date registrationDate = this.FirmdateChooserPanel.getModel().getCurrent().getTime();
            
            Firm firm = new Firm(title,registrationDate,0,adress,structure);
            if(commander.registerFirm.execute(login,firm)){
                changeForRegisterFirm(false);
                updateUserData(login);
            }
            else{
                this.FirmErrorjLabel.setEnabled(true);
            }
        } catch (RemoteException ex) {
            Logger.getLogger(WorkAreaPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(WorkAreaPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ConfirmFirmjButtonActionPerformed

    private void RedactFirmjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RedactFirmjButtonActionPerformed
        int row = FirmsTable.getSelectedRow();
        if(row >= 0){
            changeForRedactFirm(true);
            this.FirmTitlejTextField.setText((String) FirmsTable.getValueAt(row, 0));
            this.FirmAdressjTextField.setText((String) FirmsTable.getValueAt(row, 2));
            this.FirmStructurejTextField.setText((String) FirmsTable.getValueAt(row, 3));
        }
    }//GEN-LAST:event_RedactFirmjButtonActionPerformed

    private void ConfirmRedactjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfirmRedactjButtonActionPerformed
        try {
            Commander commander = new Commander();
            int row = FirmsTable.getSelectedRow();
            String previousTitle = (String) FirmsTable.getValueAt(row, 0);
            Firm firm = new Firm(previousTitle,null,0,null,null);
            commander.deleteFirm.execute(firm);
            
            String title = this.FirmTitlejTextField.getText();
            String structure = this.FirmStructurejTextField.getText();
            String adress = this.FirmAdressjTextField.getText();
            Date registrationDate = this.FirmdateChooserPanel.getModel().getCurrent().getTime();
            
            updateRedactedPerfomance(previousTitle,title);
            
            firm = new Firm(title,registrationDate,0,adress,structure);
            if(commander.registerFirm.execute(login,firm)){
                changeForRegisterFirm(false);
                updateUserData(login);
            }
            else{
                this.FirmErrorjLabel.setEnabled(true);
            }
        } catch (RemoteException ex) {
            Logger.getLogger(WorkAreaPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(WorkAreaPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ConfirmRedactjButtonActionPerformed

    private void FirmjComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FirmjComboBoxActionPerformed
        String firmTitle = (String) this.FirmjComboBox.getSelectedItem();
        updatePerfomanceValue(firmTitle);
    }//GEN-LAST:event_FirmjComboBoxActionPerformed

    private void SavePerfomancejButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SavePerfomancejButtonActionPerformed
        try {
            String firmTitle = (String) this.FirmjComboBox.getSelectedItem();
            Commander commander = new Commander();
            commander.deletePerfomance.execute(new Perfomance(firmTitle,0,0,0,0,0,0,0,0,0,0));
            int income = (int) this.IncomejSpinner.getValue();
            int costs = (int) this.CostsjSpinner.getValue();
            int profit = (int) this.ProfitjSpinner.getValue();
            int fixedAssets = (int) this.FixedAssetsjSpinner.getValue();
            int currentAssets = (int) this.CurrentAssetsjSpinner.getValue();
            int ownedAssets = (int) this.OwnedAssetsjSpinner.getValue();
            int longTermDuties = (int) this.LongTermDutiesjSpinner.getValue();
            int shortTermDuties = (int) this.ShortTermDutiesjSpinner.getValue();
            int borrowedCapital = (int) this.BorrowedCapitaljSpinner.getValue();
            int equity = (int) this.EquityjSpinner.getValue();
            commander.addPerfomance.execute(new Perfomance(firmTitle,income,costs,profit,fixedAssets,currentAssets,ownedAssets,
                                        longTermDuties,shortTermDuties,borrowedCapital,equity));
        } catch (RemoteException ex) {
            Logger.getLogger(WorkAreaPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(WorkAreaPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_SavePerfomancejButtonActionPerformed

    private void updateRedactedPerfomance(String oldTitle, String newTitle){
        try {
            Commander commander = new Commander();
            Perfomance tempPerfomance = (Perfomance)commander.getFirmPerfomance.execute(oldTitle);
            commander.deletePerfomance.execute(tempPerfomance);
            tempPerfomance.setFirm_title(newTitle);
            commander.addPerfomance.execute(tempPerfomance);
        } catch (RemoteException ex) {
            Logger.getLogger(WorkAreaPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(WorkAreaPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void changeForRedactFirm(boolean value){
        changeForRegisterFirm(value);
        this.ConfirmFirmjButton.setEnabled(false);
        this.ConfirmRedactjButton.setEnabled(value);
    }
    
    private void changeForRegisterFirm(boolean value){                                                  
        this.FirmsTable.setEnabled(!value);
        this.FirmAdressjTextField.setEnabled(value);
        FirmAdressjTextField.setText("");
        this.FirmStructurejTextField.setEnabled(value);
        FirmStructurejTextField.setText("");
        this.FirmTitlejTextField.setEnabled(value);
        FirmTitlejTextField.setText("");
        this.FirmdateChooserPanel.setEnabled(value);
        this.ConfirmFirmjButton.setEnabled(value);
        this.DeclineFirmjButton.setEnabled(value);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSpinner BorrowedCapitaljSpinner;
    private javax.swing.JButton Coef1jButton;
    private javax.swing.JTextField Coef1jTextField;
    private javax.swing.JButton Coef2jButton;
    private javax.swing.JTextField Coef2jTextField;
    private javax.swing.JButton Coef3jButton;
    private javax.swing.JTextField Coef3jTextField;
    private javax.swing.JButton Coef4jButton;
    private javax.swing.JTextField Coef4jTextField;
    private javax.swing.JButton Coef5jButton;
    private javax.swing.JTextField Coef5jTextField;
    private javax.swing.JButton Coef6jButton;
    private javax.swing.JTextField Coef6jTextField;
    private javax.swing.JButton Coef7jButton;
    private javax.swing.JTextField Coef7jTextField;
    private javax.swing.JButton Coef8jButton;
    private javax.swing.JTextField Coef8jTextField;
    private javax.swing.JButton CoefAlljButton;
    private javax.swing.JButton ConfirmFirmjButton;
    private javax.swing.JButton ConfirmRedactjButton;
    private javax.swing.JSpinner CostsjSpinner;
    private javax.swing.JSpinner CurrentAssetsjSpinner;
    private javax.swing.JButton DeclineFirmjButton;
    private javax.swing.JButton DeleteFirmjButton;
    private javax.swing.JSpinner EquityjSpinner;
    private javax.swing.JTextField FirmAdressjTextField;
    private javax.swing.JLabel FirmErrorjLabel;
    private javax.swing.JTextField FirmStructurejTextField;
    private javax.swing.JTextField FirmTitlejTextField;
    private datechooser.beans.DateChooserPanel FirmdateChooserPanel;
    private javax.swing.JComboBox FirmjComboBox;
    private javax.swing.JTable FirmsTable;
    private javax.swing.JSpinner FixedAssetsjSpinner;
    private javax.swing.JSpinner IncomejSpinner;
    private javax.swing.JSpinner LongTermDutiesjSpinner;
    private javax.swing.JSpinner OwnedAssetsjSpinner;
    private javax.swing.JSpinner ProfitjSpinner;
    private javax.swing.JButton RedactFirmjButton;
    private javax.swing.JButton RegisterFirmjButton;
    private javax.swing.JButton SavePerfomancejButton;
    private javax.swing.JSpinner ShortTermDutiesjSpinner;
    private datechooser.beans.DateChooserPanel dateChooserPanel1;
    private javax.swing.JButton jButton1;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}
