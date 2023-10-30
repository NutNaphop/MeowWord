import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class testZone {
    private JFrame frame;
    private JLabel movingLabel;
    private Timer timer;
    private int x, y; // Initial position of the label

    public testZone() {
        frame = new JFrame("Moving JLabel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLayout(null); // Set layout to null for manual positioning

        movingLabel = new JLabel("Moving Label");
        x = 50; // Initial x-position
        y = 50; // Initial y-position
        movingLabel.setBounds(x, y, 100, 30); // Set the initial position and size
        frame.add(movingLabel);

        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Update the label's position
                x += 10; // Move 10 pixels to the right
                y += 10; // Move 10 pixels down
                movingLabel.setBounds(x, y, 100, 30);

                // Repaint the frame to reflect the updated position
                frame.repaint();
            }
        });

        timer.start();

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new testZone();
            }
        });
    }
}
