/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface.Bank.BankAdmin;

import Business.EcoSystem;
import Business.Enterprise.BankEnterprise;
import Business.Organization.Bank.BankAdminOrganization;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author Lei
 */
public class BankAdminWorkAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form BankAdminWorkAreaJPanel
     */
    JPanel userProcessContainer;
    UserAccount account;
    BankAdminOrganization bankAdminOrganization;
    BankEnterprise bankEnterprise;
    EcoSystem business;
    public BankAdminWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, BankAdminOrganization bankAdminOrganization, BankEnterprise bankEnterprise,EcoSystem business) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.account = account;
        this.bankAdminOrganization = bankAdminOrganization;
        this.bankEnterprise = bankEnterprise;
        this.business = business;
        valueJLabel.setText(bankEnterprise.getName());
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
        enterpriseJLabel = new javax.swing.JLabel();
        valueJLabel = new javax.swing.JLabel();
        manageOrganizationJButton = new javax.swing.JButton();
        manageEmployeeJButton = new javax.swing.JButton();
        manageUserJButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 255));
        jLabel1.setText("My Work Area - Bank Administrative Role");

        enterpriseJLabel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        enterpriseJLabel.setText("Enterprise");

        valueJLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        valueJLabel.setText("<value>");

        manageOrganizationJButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        manageOrganizationJButton.setText("Manage Organization");
        manageOrganizationJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageOrganizationJButtonActionPerformed(evt);
            }
        });

        manageEmployeeJButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        manageEmployeeJButton.setText("Manage Employee");
        manageEmployeeJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageEmployeeJButtonActionPerformed(evt);
            }
        });

        manageUserJButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        manageUserJButton.setText("Manage User");
        manageUserJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageUserJButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(277, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(251, 251, 251))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(manageOrganizationJButton, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
                    .addComponent(manageEmployeeJButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(enterpriseJLabel)
                        .addGap(27, 27, 27)
                        .addComponent(valueJLabel))
                    .addComponent(manageUserJButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jLabel1)
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(valueJLabel)
                    .addComponent(enterpriseJLabel))
                .addGap(26, 26, 26)
                .addComponent(manageOrganizationJButton)
                .addGap(43, 43, 43)
                .addComponent(manageEmployeeJButton)
                .addGap(50, 50, 50)
                .addComponent(manageUserJButton)
                .addContainerGap(234, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void manageOrganizationJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageOrganizationJButtonActionPerformed
        // TODO add your handling code here:
        ManageBankOrganizationJPanel manageBankOrganizationJPanel = new ManageBankOrganizationJPanel(userProcessContainer, bankEnterprise.getOrganizationDirectory());
        userProcessContainer.add("manageBankOrganizationJPanel",manageBankOrganizationJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_manageOrganizationJButtonActionPerformed

    private void manageEmployeeJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageEmployeeJButtonActionPerformed
        // TODO add your handling code here:
        ManageBankEmployeeJPanel manageBankEmployeeJPanel = new ManageBankEmployeeJPanel(userProcessContainer, bankEnterprise.getOrganizationDirectory());
        userProcessContainer.add("manageBankEmployeeJPanel", manageBankEmployeeJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_manageEmployeeJButtonActionPerformed

    private void manageUserJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageUserJButtonActionPerformed
        // TODO add your handling code here:
        ManageBankUserJPanel manageBankUserJPanel = new ManageBankUserJPanel(userProcessContainer, bankEnterprise, business);
        userProcessContainer.add("manageBankUserJPanel", manageBankUserJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_manageUserJButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel enterpriseJLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton manageEmployeeJButton;
    private javax.swing.JButton manageOrganizationJButton;
    private javax.swing.JButton manageUserJButton;
    private javax.swing.JLabel valueJLabel;
    // End of variables declaration//GEN-END:variables
}