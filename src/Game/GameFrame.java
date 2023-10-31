package Game;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import javax.swing.Timer;
import javax.swing.plaf.RootPaneUI;

public class GameFrame extends javax.swing.JFrame {

    private Ingame ig;
    private Animation ani;
    private int enemy_x;
    private GameFrame currentFrame = this;

    public GameFrame() {
        initComponents();
        setGameAnimation();
        setGame();
        ImageIcon ic = new ImageIcon("src/staticfile/icon.png") ;
        this.setIconImage(ic.getImage());
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

    public int nextQuestion() {
        if (ig.genQuestion() == -1) {
            GameSystem.playSound("Sound\\win.wav");
            ani.stopAndResetAnimation();
            ig.winGame(this.rootPane, textScore.getText());
            ani.setPosition();
            HomeJFrame hf = new HomeJFrame();
            hf.show();
            GameSystem.stopSound();
            dispose();
            return -1;
        } else {
            ig.setWord(textWord);
            ig.setEngButton1(btAnsLeft);
            ig.setEngButton2(btAnsRight);
            playAnimation();
            return 1 ; 
        }
    }

    public void playAnimation() {
        ani.setPosition();
        ani.playAnimation(playerSprite, zombieSprite, this.rootPane, textScore.getText(), currentFrame);
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
        textComponent = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(393, 665));
        setMinimumSize(new java.awt.Dimension(393, 665));
        setResizable(false);
        getContentPane().setLayout(null);

        Component_HiScore.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        Component_HiScore.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Component_HiScore.setText("Hi-Score");
        getContentPane().add(Component_HiScore);
        Component_HiScore.setBounds(230, 20, 104, 29);

        Component_Score.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        Component_Score.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Component_Score.setText("Score");
        getContentPane().add(Component_Score);
        Component_Score.setBounds(80, 20, 60, 29);

        textScore.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 20)); // NOI18N
        textScore.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textScore.setText("00");
        getContentPane().add(textScore);
        textScore.setBounds(80, 50, 60, 20);

        textHiScore.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 20)); // NOI18N
        textHiScore.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textHiScore.setText("00");
        getContentPane().add(textHiScore);
        textHiScore.setBounds(240, 50, 80, 20);

        btAnsLeft.setBackground(new java.awt.Color(249, 243, 204));
        btAnsLeft.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 18)); // NOI18N
        btAnsLeft.setText("Ans1");
        btAnsLeft.setMaximumSize(new java.awt.Dimension(72, 19));
        btAnsLeft.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btAnsLeftMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btAnsLeftMouseExited(evt);
            }
        });
        btAnsLeft.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAnsLeftActionPerformed(evt);
            }
        });
        getContentPane().add(btAnsLeft);
        btAnsLeft.setBounds(90, 470, 219, 52);

        btAnsRight.setBackground(new java.awt.Color(249, 243, 204));
        btAnsRight.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 18)); // NOI18N
        btAnsRight.setText("Ans2");
        btAnsRight.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btAnsRightMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btAnsRightMouseExited(evt);
            }
        });
        btAnsRight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAnsRightActionPerformed(evt);
            }
        });
        getContentPane().add(btAnsRight);
        btAnsRight.setBounds(90, 540, 219, 54);

        textWord.setFont(new java.awt.Font("TH Krub", 1, 48)); // NOI18N
        textWord.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textWord.setText("Word");
        getContentPane().add(textWord);
        textWord.setBounds(1, 150, 390, 110);

        playerSprite.setIcon(new javax.swing.ImageIcon(getClass().getResource("/staticfile/Rat.png"))); // NOI18N
        getContentPane().add(playerSprite);
        playerSprite.setBounds(40, 390, 77, 58);

        zombieSprite.setIcon(new javax.swing.ImageIcon(getClass().getResource("/staticfile/Cat2.png"))); // NOI18N
        getContentPane().add(zombieSprite);
        zombieSprite.setBounds(270, 360, 96, 88);

        textComponent.setFont(new java.awt.Font("TH Krub", 1, 36)); // NOI18N
        textComponent.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textComponent.setText("คํานี้คือคําว่าอะไร ?");
        getContentPane().add(textComponent);
        textComponent.setBounds(6, 106, 381, 69);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/staticfile/GBG.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(-60, -150, 460, 870);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btAnsRightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAnsRightActionPerformed
        // TODO add your handling code here:
        if (ig.checkAns("2")) {
            ig.setScore(textScore);
            GameSystem.playSound("Sound\\CorrectChoice.wav");
            ani.stopAndResetAnimation();
            ani.setPosition();
            if(nextQuestion() != -1 )ani.startAnimation();
            
        } else {
            GameSystem.playSound("Sound\\GameOverBeep.wav");
            GameSystem.playSound("Sound\\gameOverCat.wav");
            ani.stopAndResetAnimation();
            ig.gameOver(this.rootPane, textScore.getText());
            ani.setPosition();
            HomeJFrame hf = new HomeJFrame();
            hf.show();
            dispose();
        }
    }//GEN-LAST:event_btAnsRightActionPerformed

    private void btAnsLeftActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAnsLeftActionPerformed
        // TODO add your handling code here:
        if (ig.checkAns("1")) {
            ig.setScore(textScore);
            GameSystem.playSound("Sound\\CorrectChoice.wav");
            ani.stopAndResetAnimation();
            ani.setPosition();
            if(nextQuestion() != -1 ) ani.startAnimation();
        } else {
            GameSystem.playSound("Sound\\GameOverBeep.wav");
            GameSystem.playSound("Sound\\gameOverCat.wav");
            ani.stopAndResetAnimation();
            ig.gameOver(this.rootPane, textScore.getText());
                        GameSystem.stopSound();
                                    GameSystem.stopSound();
            ani.setPosition();
            HomeJFrame hf = new HomeJFrame();
            hf.show();
            dispose();
        }
    }//GEN-LAST:event_btAnsLeftActionPerformed

    private void btAnsLeftMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btAnsLeftMouseEntered
        // TODO add your handling code here:
        GameSystem.playSound("Sound\\selected_choice.wav");
        btAnsLeft.setBackground(new Color(248,234,147));
    }//GEN-LAST:event_btAnsLeftMouseEntered

    private void btAnsRightMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btAnsRightMouseEntered
        // TODO add your handling code here:
        GameSystem.playSound("Sound\\selected_choice.wav");
         btAnsRight.setBackground(new Color(248,234,147));
        
    }//GEN-LAST:event_btAnsRightMouseEntered

    private void btAnsLeftMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btAnsLeftMouseExited
        // TODO add your handling code here:
        btAnsLeft.setBackground(new Color(249,243,204));
    }//GEN-LAST:event_btAnsLeftMouseExited

    private void btAnsRightMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btAnsRightMouseExited
        // TODO add your handling code here:
        btAnsRight.setBackground(new Color(249,243,204));
    }//GEN-LAST:event_btAnsRightMouseExited

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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel playerSprite;
    private javax.swing.JLabel textComponent;
    private javax.swing.JLabel textHiScore;
    private javax.swing.JLabel textScore;
    private javax.swing.JLabel textWord;
    private javax.swing.JLabel zombieSprite;
    // End of variables declaration//GEN-END:variables
}
