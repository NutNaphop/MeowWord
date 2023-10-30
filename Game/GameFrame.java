package Game;

import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import javax.swing.plaf.RootPaneUI;

public class GameFrame extends javax.swing.JFrame {

    private Ingame ig;
    private Animation ani;
    private int enemy_x;

    public GameFrame() {
        initComponents();
        setGameAnimation();
        setGame();

    }
    
    public void setGame() {
        ig = new Ingame();

        // game
        ig.RandomNumberGenerator();
        ig.genQuestion();
        ig.setHiscore(textHiScore);
        ig.setScore(textScore);
        ig.setWord(textWord);
        ig.setEngButton1(btAnsLeft);
        ig.setEngButton2(btAnsRight);
        ig.setPanel(this.rootPane);
        // Animation 
        ani.setEnemy(enemy_x);
        playAnimation();
    }

    public void setGameAnimation() {
        ani = new Animation();
        ani.setInit(playerSprite, zombieSprite);
        enemy_x = zombieSprite.getX();
    }

    public void nextQuestion() {
        if (ig.genQuestion() == -1) {
            ig.winGame(this.rootPane, textScore.getText());
            setGame(); // Go to main menu
        } else {
            ig.setWord(textWord);
            ig.setEngButton1(btAnsLeft);
            ig.setEngButton2(btAnsRight);
            playAnimation();
        }
    }

    public void playAnimation() {
        System.out.println("AA");
        ani.setPosition();
        ani.playAnimation(playerSprite, zombieSprite);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Component_HiScore = new javax.swing.JLabel();
        Component_Score = new javax.swing.JLabel();
        textScore = new javax.swing.JLabel();
        textHiScore = new javax.swing.JLabel();
        btAnsLeft = new javax.swing.JButton();
        btAnsRight = new javax.swing.JButton();
        textWord = new javax.swing.JLabel();
        playerSprite = new javax.swing.JLabel();
        zombieSprite = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        Component_HiScore.setFont(new java.awt.Font("Segoe UI Semibold", 2, 24)); // NOI18N
        Component_HiScore.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Component_HiScore.setText("Hi-Score");

        Component_Score.setFont(new java.awt.Font("Segoe UI Semibold", 2, 24)); // NOI18N
        Component_Score.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Component_Score.setText("Score");

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

        playerSprite.setIcon(new javax.swing.ImageIcon("C:\\Users\\Windows 10\\Downloads\\man_icon-icons.com_50102.png")); // NOI18N
        playerSprite.setText("jLabel1");

        zombieSprite.setIcon(new javax.swing.ImageIcon(getClass().getResource("/staticfile/14_icon-icons.com_73797+(2).png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Component_Score, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textScore, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 4, Short.MAX_VALUE))
                            .addComponent(btAnsLeft, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Component_HiScore, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textHiScore, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btAnsRight, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(playerSprite, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(185, 185, 185)
                                .addComponent(zombieSprite))
                            .addComponent(textWord, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textScore)
                    .addComponent(Component_Score)
                    .addComponent(Component_HiScore)
                    .addComponent(textHiScore))
                .addGap(45, 45, 45)
                .addComponent(textWord, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 168, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(playerSprite)
                    .addComponent(zombieSprite, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(140, 140, 140)
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
            ani.stopAndResetAnimation();
            ani.setPosition();
            nextQuestion();
            ani.startAnimation();
        } else {
            ani.stopAndResetAnimation();
            ig.gameOver(this.rootPane, textScore.getText());
            ani.setPosition();
            setGame(); // Restart
        }
    }//GEN-LAST:event_btAnsRightActionPerformed

    private void btAnsLeftActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAnsLeftActionPerformed
        // TODO add your handling code here:]
        if (ig.checkAns("1")) {
            ig.setScore(textScore);
                  ani.stopAndResetAnimation();
            ani.setPosition();
            nextQuestion();
            ani.startAnimation();
        } else {
            ani.stopAndResetAnimation();
            ig.gameOver(this.rootPane, textScore.getText());
            ani.setPosition();
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
    private javax.swing.JLabel Component_Score;
    private javax.swing.JButton btAnsLeft;
    private javax.swing.JButton btAnsRight;
    private javax.swing.JLabel playerSprite;
    private javax.swing.JLabel textHiScore;
    private javax.swing.JLabel textScore;
    private javax.swing.JLabel textWord;
    private javax.swing.JLabel zombieSprite;
    // End of variables declaration//GEN-END:variables
}
