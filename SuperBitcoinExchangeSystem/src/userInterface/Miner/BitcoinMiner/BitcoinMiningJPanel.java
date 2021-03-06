/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface.Miner.BitcoinMiner;

import Business.EcoSystem;
import Business.Enterprise.DepositoryEnterprise;
import Business.Enterprise.Enterprise;
import Business.Enterprise.MinerEnterprise;
import Business.Network.Network;
import Business.Organization.Miner.MiningOrganization;
import Business.Organization.Miner.WritingOrganization;
import Business.Organization.Organization;
import Business.Other.Bitcoin;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.BitcoinMiningToWritingWorkRequest;
import java.awt.CardLayout;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author KW
 */
public class BitcoinMiningJPanel extends javax.swing.JPanel {

    /**
     * Creates new form BitcoinMiningJPanel
     */
    private JPanel userProcessContainer;
    private UserAccount account;
    private MinerEnterprise minerEnterprise;
    private EcoSystem ecoSystem;

    private ArrayList<Bitcoin> bitcoinList;

    BitcoinMiningJPanel(JPanel userProcessContainer, UserAccount account, MinerEnterprise minerEnterprise, EcoSystem ecoSystem) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.account = account;
        this.minerEnterprise = minerEnterprise;
        this.ecoSystem = ecoSystem;
        bitcoinList = new ArrayList<>();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        txtBitcoinPrivateKey = new javax.swing.JTextField();
        btnMine = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBitcoinList = new javax.swing.JTable();
        btnBack = new javax.swing.JButton();
        btnReport = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel4.setText("Bitcoin Mining Place");

        txtBitcoinPrivateKey.setEditable(false);

        btnMine.setText("Mine");
        btnMine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMineActionPerformed(evt);
            }
        });

        tblBitcoinList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Serial Number", "Private Key", "Mined Date"
            }
        ));
        jScrollPane1.setViewportView(tblBitcoinList);

        btnBack.setText("<< Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnReport.setText("Report to Writer");
        btnReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(145, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(379, 379, 379))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnReport)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 710, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(145, 145, 145))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(324, 324, 324)
                        .addComponent(txtBitcoinPrivateKey, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61)
                        .addComponent(btnMine))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(btnBack)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel4)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBitcoinPrivateKey, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMine))
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(btnReport)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 130, Short.MAX_VALUE)
                .addComponent(btnBack)
                .addGap(28, 28, 28))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnMineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMineActionPerformed
        // TODO add your handling code here:
        DepositoryEnterprise depositoryEnterprise = null;
        for (Network n : ecoSystem.getNetworkList()) {
            for (Enterprise e : n.getEnterpriseDirectory().getEnterpriseList()) {
                if (e instanceof DepositoryEnterprise) {
                    depositoryEnterprise = (DepositoryEnterprise) e;
                }
            }
        }

        if (depositoryEnterprise == null) {
            JOptionPane.showMessageDialog(null, "Sorry, You can mine bitcoin now :)", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        HashMap<Bitcoin, Boolean> bList = depositoryEnterprise.getBitcoinList();
        ArrayList<Bitcoin> bt = new ArrayList<>();

        for (Bitcoin b : bList.keySet()) {
            bt.add(b);
        }

        Random random = new Random();

        while (true) {
            int n = random.nextInt(10000);
            if (bList.get(bt.get(n)) == false) {
                bList.put(bt.get(n), true);
                txtBitcoinPrivateKey.setText(bt.get(n).getPrivateKey());
                bitcoinList.add(bt.get(n));
                account.getPerson().getLocalBitcoinWallet().add(bt.get(n));
                bt.get(n).setBirthday(new Date());
                populateTable();
                break;
            }
        }


    }//GEN-LAST:event_btnMineActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        if (bitcoinList.size() > 0) {
            JOptionPane.showMessageDialog(null, "Please report all bitcoins first.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportActionPerformed
        // TODO add your handling code here:
        if (bitcoinList.size() <= 0) {
            JOptionPane.showMessageDialog(null, "No Bitcoin need to be written.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        String message = "Writing Bitcoin";
        BitcoinMiningToWritingWorkRequest request = new BitcoinMiningToWritingWorkRequest();
        request.setMessage(message);
        request.setSender(account);
        request.setStatusString("Sent");
        request.setBitcoins(bitcoinList);
        bitcoinList = new ArrayList<>();
//        account.getWorkQueue().getWorkRequestList().add(request);
        populateTable();

        Organization o = null;
        for (Organization organization : minerEnterprise.getOrganizationDirectory().getOrganizationList()) {
            if (organization instanceof WritingOrganization) {
                o = organization;
                break;
            }
        }
        if (o != null) {
            o.getWorkQueue().getWorkRequestList().add(request);
            account.getWorkQueue().getWorkRequestList().add(request);
        } else {
            JOptionPane.showMessageDialog(null, "No writing organization existed :(", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        JOptionPane.showMessageDialog(null, "Congratulation! You report successfully ;)", "Warning", JOptionPane.WARNING_MESSAGE);
        txtBitcoinPrivateKey.setText("");
    }//GEN-LAST:event_btnReportActionPerformed

    public void populateTable() {
        DefaultTableModel model = (DefaultTableModel) tblBitcoinList.getModel();
        model.setRowCount(0);
        for (Bitcoin b : bitcoinList) {
            Object[] row = new Object[3];
            row[0] = b;
            row[1] = b.getPrivateKey();

            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String dateString = formatter.format(b.getBirthday());

            row[2] = dateString;
            model.addRow(row);
        }
    }

//    public static String getRandomString() {
//        //定义一个字符串（A-Z，a-z，0-9）即62位；
//        String str = "zxcvbnmlkjhgfdsaqwertyuiopQWERTYUIOPASDFGHJKLZXCVBNM1234567890";
//        //由Random生成随机数
//        Random random = new Random();
//        StringBuffer sb = new StringBuffer();
//        //长度为几就循环几次
//        for (int i = 0; i < 32; ++i) {
//            //产生0-61的数字
//            int number = random.nextInt(62);
//            //将产生的数字通过length次承载到sb中
//            sb.append(str.charAt(number));
//        }
//        //将承载的字符转换成字符串
//        return sb.toString();
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnMine;
    private javax.swing.JButton btnReport;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblBitcoinList;
    private javax.swing.JTextField txtBitcoinPrivateKey;
    // End of variables declaration//GEN-END:variables
}
