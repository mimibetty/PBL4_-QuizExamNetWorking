package com.quizapplication;


import javax.swing.JFrame;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Admin
 */
public class AdminHome extends javax.swing.JFrame {
public static int open=0;
    /**
     * Creates new form AdminHome
     */
    public AdminHome() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelBackgroundAdmin = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuAllQuestion = new javax.swing.JMenu();
        menuAddQuestion = new javax.swing.JMenu();
        menuUpdateQuestion = new javax.swing.JMenu();
        menuDeleteQuestion = new javax.swing.JMenu();
        menuAllReult = new javax.swing.JMenu();
        menuLogout = new javax.swing.JMenu();
        menuExit = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelBackgroundAdmin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/index background.png"))); // NOI18N
        getContentPane().add(labelBackgroundAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -110, -1, -1));

        jMenuBar1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Navigation Bar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 36), new java.awt.Color(255, 0, 0))); // NOI18N
        jMenuBar1.setVerifyInputWhenFocusTarget(false);

        menuAllQuestion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/all questions.png"))); // NOI18N
        menuAllQuestion.setText("Question bank");
        menuAllQuestion.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        menuAllQuestion.setMargin(new java.awt.Insets(0, 5, 0, 10));
        menuAllQuestion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuAllQuestionMouseClicked(evt);
            }
        });
        menuAllQuestion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAllQuestionActionPerformed(evt);
            }
        });
        jMenuBar1.add(menuAllQuestion);

        menuAddQuestion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/add new question.png"))); // NOI18N
        menuAddQuestion.setText("Add Question");
        menuAddQuestion.setAutoscrolls(true);
        menuAddQuestion.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        menuAddQuestion.setMargin(new java.awt.Insets(0, 5, 0, 10));
        menuAddQuestion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuAddQuestionMouseClicked(evt);
            }
        });
        jMenuBar1.add(menuAddQuestion);

        menuUpdateQuestion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Update Question.png"))); // NOI18N
        menuUpdateQuestion.setText("Edit Question");
        menuUpdateQuestion.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        menuUpdateQuestion.setMargin(new java.awt.Insets(0, 5, 0, 10));
        menuUpdateQuestion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuUpdateQuestionMouseClicked(evt);
            }
        });
        jMenuBar1.add(menuUpdateQuestion);

        menuDeleteQuestion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/delete Question.png"))); // NOI18N
        menuDeleteQuestion.setText("Delete Question");
        menuDeleteQuestion.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        menuDeleteQuestion.setMargin(new java.awt.Insets(0, 5, 0, 15));
        menuDeleteQuestion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuDeleteQuestionMouseClicked(evt);
            }
        });
        jMenuBar1.add(menuDeleteQuestion);

        menuAllReult.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/all student result.png"))); // NOI18N
        menuAllReult.setText("Student results");
        menuAllReult.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        menuAllReult.setMargin(new java.awt.Insets(0, 5, 0, 10));
        menuAllReult.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuAllReultMouseClicked(evt);
            }
        });
        jMenuBar1.add(menuAllReult);

        menuLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Logout.png"))); // NOI18N
        menuLogout.setText("Logout");
        menuLogout.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        menuLogout.setMargin(new java.awt.Insets(0, 5, 0, 20));
        menuLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuLogoutMouseClicked(evt);
            }
        });
        jMenuBar1.add(menuLogout);

        menuExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Close.png"))); // NOI18N
        menuExit.setText("Exit");
        menuExit.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        menuExit.setMargin(new java.awt.Insets(0, 5, 0, 30));
        menuExit.setName(""); // NOI18N
        menuExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuExitMouseClicked(evt);
            }
        });
        jMenuBar1.add(menuExit);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    // đăng xuất log out
    private void menuLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuLogoutMouseClicked
        JFrame fr=new JFrame();
        fr.setAlwaysOnTop(true);
        int option=JOptionPane.showConfirmDialog(fr, "Bạn có chắc muốn đăng xuất tài khoản","Select",JOptionPane.YES_NO_OPTION);
        if(option==0){
            setVisible(false);
            new LoginAdmin().setVisible(true);
        }
        
    }//GEN-LAST:event_menuLogoutMouseClicked

    // thoát chương trình, exit
    private void menuExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuExitMouseClicked
        JFrame fr=new JFrame();
        fr.setAlwaysOnTop(true);
        int option=JOptionPane.showConfirmDialog(fr, "Bạn có chắc muốn thoát khỏi chương trình","Select",JOptionPane.YES_NO_OPTION);
        if(option==0){
            System.exit(0);
        }
    }//GEN-LAST:event_menuExitMouseClicked

    // xem toàn bộ question
    private void menuAllQuestionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuAllQuestionMouseClicked
        // TODO add your handling code here:
        if(open==0){
            new allQuestion().setVisible(true);
            open=1;
        }
        else{
            // nếu đã mở form rồi thì tạo 1 jframe và thông báo đã mở
            JFrame jf=new JFrame();
            jf.setAlwaysOnTop(true);
            JOptionPane.showMessageDialog(jf,"One Form is already exist");
        }
    }//GEN-LAST:event_menuAllQuestionMouseClicked

    private void menuAllQuestionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAllQuestionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menuAllQuestionActionPerformed

    private void menuDeleteQuestionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuDeleteQuestionMouseClicked
        // TODO add your handling code here:
        if(open==0){
            new deleteQuestion().setVisible(true);
            open=1;
        }
        else{
            JFrame jf=new JFrame();
            jf.setAlwaysOnTop(true);
            JOptionPane.showMessageDialog(jf,"One Form is already exist");
        }
    }//GEN-LAST:event_menuDeleteQuestionMouseClicked

    private void menuAddQuestionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuAddQuestionMouseClicked
        // TODO add your handling code here:
          if(open==0){
            new AddQuestionForm().setVisible(true);
            open=1;
        }else{
            JFrame frame=new JFrame();
            frame.setAlwaysOnTop(true);
            JOptionPane.showMessageDialog(frame, "Đã tồn tại một cửa sổ khác làm phiềm đóng cửa sổ trước đó");
        }
    }//GEN-LAST:event_menuAddQuestionMouseClicked

    private void menuUpdateQuestionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuUpdateQuestionMouseClicked
        // TODO add your handling code here:
         if(open==0){
            new UpdateQuestionForm().setVisible(true);
            open=1;
        }else{
            JFrame frame=new JFrame();
            frame.setAlwaysOnTop(true);
            JOptionPane.showMessageDialog(frame, "Đã tồn tại một cửa sổ khác làm phiềm đóng cửa sổ trước đó");
        }
    }//GEN-LAST:event_menuUpdateQuestionMouseClicked

    private void menuAllReultMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuAllReultMouseClicked
        // TODO add your handling code here:
          if(open==0){
            new allStudentResult().setVisible(true);
            open=1;
        }else{
            JFrame frame=new JFrame();
            frame.setAlwaysOnTop(true);
            JOptionPane.showMessageDialog(frame, "Đã tồn tại một cửa sổ khác làm phiềm đóng cửa sổ trước đó");
        }
    }//GEN-LAST:event_menuAllReultMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JLabel labelBackgroundAdmin;
    private javax.swing.JMenu menuAddQuestion;
    private javax.swing.JMenu menuAllQuestion;
    private javax.swing.JMenu menuAllReult;
    private javax.swing.JMenu menuDeleteQuestion;
    private javax.swing.JMenu menuExit;
    private javax.swing.JMenu menuLogout;
    private javax.swing.JMenu menuUpdateQuestion;
    // End of variables declaration//GEN-END:variables
}