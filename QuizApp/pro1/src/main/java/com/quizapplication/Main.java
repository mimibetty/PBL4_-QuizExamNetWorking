package com.quizapplication;


import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Admin
 */
public class Main extends javax.swing.JFrame {
    public static Client client;
    private int port = 6666;
    /**
     * Creates new form index
     */
    public Main() {
        initComponents();
        client = new Client(6666);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnStudent = new javax.swing.JButton();
        btnAdmin = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        labelLayoutMain = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("frameHome"); // NOI18N
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnStudent.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnStudent.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/index_student.png"))); // NOI18N
        btnStudent.setText("Student");
        btnStudent.setToolTipText("");
        btnStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStudentActionPerformed(evt);
            }
        });
        getContentPane().add(btnStudent, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 20, -1, -1));

        btnAdmin.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAdmin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/index admin.png"))); // NOI18N
        btnAdmin.setText("Admin");
        btnAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdminActionPerformed(evt);
            }
        });
        getContentPane().add(btnAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 20, -1, -1));

        btnExit.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Close.png"))); // NOI18N
        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        getContentPane().add(btnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 20, -1, -1));

        labelLayoutMain.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/index background.png"))); // NOI18N
        getContentPane().add(labelLayoutMain, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        int option= JOptionPane.showConfirmDialog(null, "Có có chắc chắn muốn thoát khỏi chương trình","Select",JOptionPane.YES_NO_OPTION);
        if(option==0){
            System.exit(0);
        }
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStudentActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        new studentDetails().setVisible(true);
    }//GEN-LAST:event_btnStudentActionPerformed

    private void btnAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdminActionPerformed
        // TODO add your handling code here:
        setVisible(false);
         new LoginAdmin().setVisible(true);
    }//GEN-LAST:event_btnAdminActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdmin;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnStudent;
    private javax.swing.JLabel labelLayoutMain;
    // End of variables declaration//GEN-END:variables
}
