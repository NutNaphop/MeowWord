package Game;

import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import javax.swing.plaf.RootPaneUI;



public class GameFrame extends javax.swing.JFrame {

    private Ingame ig;
    public GameFrame() {
        initComponents();
        setGame();
    }

    public void setGame() {
        ig = new Ingame();
        ig.RandomNumberGenerator();
        ig.genQuestion();
        ig.setHiscore(textHiScore);
        ig.setScore(textScore);
        ig.setWord(textWord);
        ig.setEngButton1(btAnsLeft);
        ig.setEngButton2(btAnsRight);
    }
    
    public void nextQuestion(){
        ig.genQuestion(); 
        ig.setWord(textWord);
        ig.setEngButton1(btAnsLeft);
        ig.setEngButton2(btAnsRight);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Component_HiScore = new javax.swing.JLabel();
        Component_Score2 = new javax.swing.JLabel();
        textScore = new javax.swing.JLabel();
        textHiScore = new javax.swing.JLabel();
        btAnsLeft = new javax.swing.JButton();
        btAnsRight = new javax.swing.JButton();
        textWord = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        Component_HiScore.setFont(new java.awt.Font("Segoe UI Semibold", 2, 24)); // NOI18N
        Component_HiScore.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Component_HiScore.setText("Hi-Score");

        Component_Score2.setFont(new java.awt.Font("Segoe UI Semibold", 2, 24)); // NOI18N
        Component_Score2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Component_Score2.setText("Score");

        textScore.setFont(new java.awt.Font("Segoe UI Semibold", 2, 24)); // NOI18N
        textScore.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textScore.setText("00");

        textHiScore.setFont(new java.awt.Font("Segoe UI Semibold", 2, 24)); // NOI18N
        textHiScore.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textHiScore.setText("00");

        btAnsLeft.setFont(new java.awt.Font("Segoe UI Emoji", 0, 24)); // NOI18N
        btAnsLeft.setText("Ans1");
        btAnsLeft.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAnsLeftActionPerformed(evt);
            }
        });

        btAnsRight.setFont(new java.awt.Font("Segoe UI Emoji", 0, 24)); // NOI18N
        btAnsRight.setText("Ans2");
        btAnsRight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAnsRightActionPerformed(evt);
            }
        });

        textWord.setFont(new java.awt.Font("TH NiramitIT๙ ", 0, 48)); // NOI18N
        textWord.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textWord.setText("Word");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(textWord, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Component_Score2, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textScore, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 4, Short.MAX_VALUE))
                            .addComponent(btAnsLeft, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Component_HiScore, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textHiScore, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btAnsRight, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8)))
                        .addGap(18, 18, 18))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textScore)
                    .addComponent(Component_Score2)
                    .addComponent(Component_HiScore)
                    .addComponent(textHiScore))
                .addGap(45, 45, 45)
                .addComponent(textWord, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(372, 372, 372)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btAnsLeft, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btAnsRight, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btAnsRightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAnsRightActionPerformed
        // TODO add your handling code here:
        if (ig.checkAns("2")) {
            ig.setScore(textScore);
            nextQuestion();
        }else{
            ig.gameOver(this.rootPane , textScore.getText());
            setGame(); // Restart
        }
    }//GEN-LAST:event_btAnsRightActionPerformed

    private void btAnsLeftActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAnsLeftActionPerformed
        // TODO add your handling code here:]
        if (ig.checkAns("1")) {
            ig.setScore(textScore);
            nextQuestion();
        }else {
            ig.gameOver(this.rootPane ,textScore.getText());
            setGame(); // Restart
        }

    }//GEN-LAST:event_btAnsLeftActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GameFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GameFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GameFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GameFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GameFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Component_HiScore;
    private javax.swing.JLabel Component_Score2;
    private javax.swing.JButton btAnsLeft;
    private javax.swing.JButton btAnsRight;
    private javax.swing.JLabel textHiScore;
    private javax.swing.JLabel textScore;
    private javax.swing.JLabel textWord;
    // End of variables declaration//GEN-END:variables
}
