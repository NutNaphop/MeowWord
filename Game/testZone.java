import javax.swing.*;
import java.awt.*;

public class testZone {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("LayeredPane Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 300);

            JLayeredPane layeredPane = new JLayeredPane();
            frame.add(layeredPane);

            JPanel panel1 = new JPanel();
            panel1.setBackground(Color.RED);
            panel1.setBounds(50, 50, 200, 150);
            layeredPane.add(panel1, JLayeredPane.DEFAULT_LAYER);

            JPanel panel2 = new JPanel();
            panel2.setBackground(Color.BLUE);
            panel2.setBounds(100, 100, 200, 150);
            layeredPane.add(panel2, JLayeredPane.PALETTE_LAYER);

            frame.setVisible(true);
        });
    }
}