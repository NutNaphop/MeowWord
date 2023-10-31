import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class testZone {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Slide Animation Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 100);

        JPanel slidingPanel = new JPanel();
        slidingPanel.setBackground(Color.BLUE);
        slidingPanel.setPreferredSize(new Dimension(100, 50));
        frame.add(slidingPanel);
        
        Timer timer = new Timer(10, new ActionListener() {
            int x = 400; // Initial X position (right edge)

            @Override
            public void actionPerformed(ActionEvent e) {
                x -= 1; // Adjust the X position for sliding
                slidingPanel.setLocation(x, 25); // 25 is the Y position (centered)

                if (x <= -100) {
                    ((Timer) e.getSource()).stop(); // Stop the animation when it's off-screen
                }
            }
        });

        timer.start(); // Start the animation

        frame.setVisible(true);
    }
}
