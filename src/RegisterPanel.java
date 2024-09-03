import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class RegisterPanel {

    public static class TextFieldPanel extends JPanel {
        private final JTextField textField;
        private final JLabel label;
        private Image backgroundImage;
        private Image carnivalGuy;
        private final PursePanel pursePanel;

        public TextFieldPanel() {

            // Set size of Panel, and layout to BorderLayout
            this.setPreferredSize(new Dimension(500, 500));
            this.setLayout(null); // Use null layout for manual positioning

            // Load the images
            try {
                backgroundImage = ImageIO.read(new File("src/images/backgroundLab1.png"));
                carnivalGuy = ImageIO.read(new File("src/images/carnivalGuy.png"));
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            // Create and position the textField
            textField = new JTextField();
            textField.setPreferredSize(new Dimension(100, 50));
            textField.setFont(new Font("sanserif", Font.PLAIN, 40));
            textField.setBounds(200, 400, 130, 50);
            textField.addActionListener(new InputListener());

            // Create and position the label inside the circle
            label = new JLabel("<html>How much change<br>am I getting back?</html>");
            label.setFont(new Font("sanserif", Font.PLAIN, 10));
            label.setHorizontalAlignment(SwingConstants.CENTER);
            label.setBounds(112, 255, 100, 100);

            // Initialize PursePanel and add it to the TextFieldPanel
            Purse purse = new Purse();
            pursePanel = new PursePanel(purse);
            pursePanel.setBounds(10, 10, 450, 300);

            // Add the components to the panel
            this.add(textField);
            this.add(label);
            this.add(pursePanel);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            // Draw the background image if it exists
            if (backgroundImage != null) {
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            }

            // Draw the CarnivalGuy if it exists
            if (carnivalGuy != null) {
                g.drawImage(carnivalGuy, 0, 50, getWidth(), getHeight(), this);
            }

            // Draw the white circle
            g.setColor(Color.WHITE);
            g.fillOval(110, 250, 100, 100); // x, y, width, height of the circle

            // Draw the border of the circle
            g.setColor(Color.BLACK);
            g.drawOval(110, 250, 100, 100); // x, y, width, height of the circle
        }

        private class InputListener implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                String text = textField.getText();
                double amt = Double.parseDouble(text);

                System.out.println(text);

                label.setText("<html>Thank you for the <br>change for $" + amt + "</html>");

                // Call Register.makeChange method with amt and get updated purse
                Purse newPurse = Register.makeChange(amt);

                // Update the PursePanel with the new purse
                pursePanel.setPurse(newPurse);

                System.out.println(newPurse);

            }
        }
    }
}
