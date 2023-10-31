/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Game;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.net.URI;
import java.io.File;
/**
 *
 * @author USER
 */
public class HomeJFrame extends javax.swing.JFrame {

    /**
     * Creates new form GameJFrame
     */
    public HomeJFrame() {
//        File directory = new File("src/staticfile/icon.png");
//        System.out.println(directory.getAbsolutePath());
        initComponents();
        GameSystem.playBackgroundMusic("Sound\\MainMenu.wav");
        ImageIcon ic = new ImageIcon("src/staticfile/icon.png") ;
        this.setIconImage(ic.getImage());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        StartButton = new javax.swing.JButton();
        ExitButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MeowWord");
        setMaximumSize(new java.awt.Dimension(393, 665));
        setMinimumSize(new java.awt.Dimension(393, 665));
        setResizable(false);
        getContentPane().setLayout(null);

        StartButton.setBackground(new java.awt.Color(255, 245, 235));
        StartButton.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        StartButton.setText("START");
        StartButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                StartButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                StartButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                StartButtonMouseExited(evt);
            }
        });
        StartButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StartButtonActionPerformed(evt);
            }
        });
        getContentPane().add(StartButton);
        StartButton.setBounds(70, 320, 240, 60);

        ExitButton.setBackground(new java.awt.Color(255, 245, 235));
        ExitButton.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        ExitButton.setText("EXIT");
        ExitButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ExitButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ExitButtonMouseExited(evt);
            }
        });
        ExitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitButtonActionPerformed(evt);
            }
        });
        getContentPane().add(ExitButton);
        ExitButton.setBounds(70, 400, 240, 60);

        jLabel2.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 58)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 204));
        jLabel2.setText("Meow");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(110, 120, 170, 60);

        jLabel3.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 68)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 204));
        jLabel3.setText("WORD");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(90, 160, 210, 77);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/staticfile/BG7.png"))); // NOI18N
        getContentPane().add(jLabel4);
        jLabel4.setBounds(-60, -70, 500, 780);

        setSize(new java.awt.Dimension(407, 672));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void StartButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StartButtonActionPerformed
        // TODO add your handling code here:
        GameSystem.stopBackgroundMusic();
        GameSystem.playSound("Sound\\button_press.wav"); // click
        GameSystem.stopSound();
        GameSystem.Delay();
        GameFrame jfgame = new GameFrame();
        jfgame.show();
        dispose();
    }//GEN-LAST:event_StartButtonActionPerformed

    private void ExitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitButtonActionPerformed
        // TODO add your handling code here:
        GameSystem.stopBackgroundMusic();
        GameSystem.playSound("Sound\\button_press.wav");
        GameSystem.stopSound();
        GameSystem.Delay();
        System.exit(0);
    }//GEN-LAST:event_ExitButtonActionPerformed

    private void StartButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_StartButtonMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_StartButtonMouseClicked

    private void StartButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_StartButtonMouseEntered
        // TODO add your handling code here:
        GameSystem.playSound("Sound\\hover.wav");
        StartButton.setBackground(new Color(130, 224, 170));
    }//GEN-LAST:event_StartButtonMouseEntered

    private void StartButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_StartButtonMouseExited
        // TODO add your handling code here:
        GameSystem.stopSound();
        StartButton.setBackground(new Color(255,245,235));
    }//GEN-LAST:event_StartButtonMouseExited

    private void ExitButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExitButtonMouseEntered
        // TODO add your handling code here:
        GameSystem.playSound("Sound\\hover.wav");
        ExitButton.setBackground(new Color(236, 112, 99));
    }//GEN-LAST:event_ExitButtonMouseEntered

    private void ExitButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExitButtonMouseExited
        // TODO add your handling code here:
        GameSystem.stopSound();
        ExitButton.setBackground(new Color(255,245,235));
    }//GEN-LAST:event_ExitButtonMouseExited

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(HomeJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomeJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomeJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomeJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomeJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ExitButton;
    private javax.swing.JButton StartButton;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
