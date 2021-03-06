/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface.Platform.Accountant;

import Business.EcoSystem;
import Business.Employee.Employee;
import Business.Employee.Person;
import Business.Enterprise.DepositoryEnterprise;
import Business.Enterprise.Enterprise;
import Business.Enterprise.PlatformEnterprise;
import Business.Network.Network;
import Business.Organization.BitcoinPlatform.AccountingOrganization;
import Business.Organization.BitcoinPlatform.BitcoinMatcherOrganization;
import Business.Organization.BitcoinPlatform.BrokerOrganization;
import Business.Organization.Organization;
import Business.Other.Bitcoin;
import Business.Other.ExchangeHistory;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.BrokerBuyWorkRequest;
import Business.WorkQueue.BrokerSellWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lei
 */
public class AccountantWorkAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form AccountantWorkAreaJPanel
     */
    JPanel userProcessContainer;
    UserAccount account;
    AccountingOrganization accountingOrganization;
    PlatformEnterprise platformEnterprise;
    EcoSystem ecoSystem;
    private HashMap<Bitcoin, Boolean> bitcoinList;

    public AccountantWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, AccountingOrganization accountingOrganization, PlatformEnterprise platformEnterprise, EcoSystem ecoSystem) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.account = account;
        this.accountingOrganization = accountingOrganization;
        this.platformEnterprise = platformEnterprise;
        this.ecoSystem = ecoSystem;
        this.bitcoinList = new HashMap<>();
        for (Network network : ecoSystem.getNetworkList()) {
            for (Enterprise e : network.getEnterpriseDirectory().getEnterpriseList()) {
                if (e instanceof DepositoryEnterprise) {
                    bitcoinList = ((DepositoryEnterprise) e).getBitcoinList();
                }
            }
        }
        platformEnterprise.setIncome(0.0);
        completeBrokerHashMap();
        countBrokerIncome();
        populateTable();
        DecimalFormat df = new DecimalFormat("0.00");
        txtPlatformProfit.setText(String.valueOf(df.format(platformEnterprise.getIncome())));
    }

    private void completeBrokerHashMap() {
        for (Organization o : platformEnterprise.getOrganizationDirectory().getOrganizationList()) {
            if (o instanceof BrokerOrganization) {
                BrokerOrganization bo = (BrokerOrganization) o;
                for (Person p : bo.getEmployeeDirectory().getEmployeeList()) {
                    platformEnterprise.getBrokerIncome().put(p, 0.0);
                }
            }
        }
    }

    private void countBrokerIncome() {

        platformEnterprise.setIncome(0.0);
        for (Bitcoin b : bitcoinList.keySet()) {
            for (ExchangeHistory eh : b.getExchangeHistoryList()) {
                platformEnterprise.getBrokerIncome().put(eh.getBuy_broker(), platformEnterprise.getBrokerIncome().get(eh.getBuy_broker()) + eh.getExchangePrize() * 0.02);
                platformEnterprise.setIncome(platformEnterprise.getIncome() + eh.getExchangePrize() * 0.01);
            }
        }

        for (Bitcoin b : bitcoinList.keySet()) {
            for (ExchangeHistory eh : b.getExchangeHistoryList()) {
                platformEnterprise.getBrokerIncome().put(eh.getSell_broker(), platformEnterprise.getBrokerIncome().get(eh.getSell_broker()) + eh.getExchangePrize() * 0.02);
                platformEnterprise.setIncome(platformEnterprise.getIncome() + eh.getExchangePrize() * 0.01);
            }
        }
    }

    private void populateTable() {
        DefaultTableModel model = (DefaultTableModel) tblBrokerIncome.getModel();
        model.setRowCount(0);

        for (Person p : platformEnterprise.getBrokerIncome().keySet()) {
            Object[] row = new Object[3];
            row[0] = p.getId();
            row[1] = p;
            DecimalFormat df = new DecimalFormat("0.00");
            row[2] =df.format( platformEnterprise.getBrokerIncome().get(p));
            model.addRow(row);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBrokerIncome = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtPlatformProfit = new javax.swing.JTextField();
        btnSelect = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setText("Accountant Work Area");

        tblBrokerIncome.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Name", "Income"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblBrokerIncome);
        if (tblBrokerIncome.getColumnModel().getColumnCount() > 0) {
            tblBrokerIncome.getColumnModel().getColumn(0).setResizable(false);
            tblBrokerIncome.getColumnModel().getColumn(1).setResizable(false);
            tblBrokerIncome.getColumnModel().getColumn(2).setResizable(false);
        }

        jLabel2.setText("Platform Profit: ");

        txtPlatformProfit.setEditable(false);
        txtPlatformProfit.setEnabled(false);

        btnSelect.setText("View Details >>");
        btnSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(167, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(34, 34, 34)
                        .addComponent(txtPlatformProfit, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(358, 358, 358))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btnSelect)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 695, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(138, 138, 138)))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtPlatformProfit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(btnSelect)
                .addContainerGap(204, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectActionPerformed
        // TODO add your handling code here:
        int row = tblBrokerIncome.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(null, "Please select a row from the table first.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        Person employee = (Person) tblBrokerIncome.getValueAt(row, 1);
        HashMap<Bitcoin, Boolean> bitcoinList = new HashMap<>();
        for (Network network : ecoSystem.getNetworkList()) {
            for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()) {
                if (enterprise instanceof DepositoryEnterprise) {
                    DepositoryEnterprise depositoryEnterprise = (DepositoryEnterprise) enterprise;
                    bitcoinList = depositoryEnterprise.getBitcoinList();
                    break;
                }
            }
        }

        ArrayList<ExchangeHistory> buyExchangeHistory = new ArrayList<>();
        ArrayList<ExchangeHistory> sellExchangeHistory = new ArrayList<>();

        for (Bitcoin bc : bitcoinList.keySet()) {
            for (ExchangeHistory eh : bc.getExchangeHistoryList()) {
                if (eh.getBuy_broker().equals(employee)) {
                    buyExchangeHistory.add(eh);
                } 
                if (eh.getSell_broker().equals(employee)) {
                    sellExchangeHistory.add(eh);
                }
            }
        }
        ViewExchangeIncomeJPanel veijp = new ViewExchangeIncomeJPanel(userProcessContainer, employee, buyExchangeHistory, sellExchangeHistory);
        userProcessContainer.add("veijp", veijp);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnSelectActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSelect;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblBrokerIncome;
    private javax.swing.JTextField txtPlatformProfit;
    // End of variables declaration//GEN-END:variables
}
