package com.quizapplication;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
  z* @author ACER
 */
public class allQuestion extends javax.swing.JFrame {
 DefaultTableModel model ;
 ArrayList<String[]> Questions;

    /**
     * Creates new form allQuestion
     */
 
 
 // tao sk va lay du lieu o day
    public allQuestion() {
        initComponents();
        try{
            System.out.println("question1");
            Questions = Main.client.getAllQuestion();
            System.out.println("herrrreee");
//            int x = 0;
//            for (String[] question : Questions) {
//                x++;
//                System.out.println("ID  : "  + x);
//                for (String element : question) {
//                    System.out.println(element);
//                }
//                System.out.println();
//            }
            
            model = new DefaultTableModel(new Object[]{"ID", "Name", "Opt1", "Opt2", "Opt3", "Opt4", "Answer"}, 0);
            jTable1.setModel(model);
            
            int x = 0;
            for (String[] QuestionData: Questions) {
//                x++;
//                System.out.println("ID  : "  + x);
//
//                System.out.println(QuestionData[0]);
//                System.out.println(QuestionData[1]);
//                System.out.println(QuestionData[2]);                
//                System.out.println(QuestionData[3]);                
//                System.out.println(QuestionData[4]);                
//                System.out.println(QuestionData[5]);                
//                System.out.println(QuestionData[6]);                
//                System.out.println("  ");                
                
                model.addRow(new Object[]{QuestionData[0], QuestionData[1], QuestionData[2], QuestionData[3], QuestionData[4], QuestionData[5], QuestionData[6] });
            }   
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
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
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setLocation(new java.awt.Point(150, 183));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/all questions.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel2.setFont(new java.awt.Font("Algerian", 1, 40)); // NOI18N
        jLabel2.setText("All Question");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(66, 14, -1, -1));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Close.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 10, 80, -1));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 87, 1066, 10));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 1050, 430));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/pages background student.jpg"))); // NOI18N
        jLabel3.setText("jLabel3");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1070, 540));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        AdminHome.open=0;
        setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
