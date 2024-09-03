import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.util.Map;
import java.util.List;

public class PursePanel extends JPanel {
    private Purse purse;

    // Constructor for the PursePanel class
    public PursePanel(Purse purse) {
        this.purse = purse;

        // Set size of panel and make background transparent
        setPreferredSize(new Dimension(400, 400));
        setOpaque(false);
    }

    // Allows for custom drawing
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int x = 10; // Starting x position for drawing
        int y = 10; // Starting y position for drawing
        int offset = 5; // Offset for stacking
        int imageWidth = 120;
        int imageHeight = 80;

        // Get the denominations in the purse sorted by amount in descending order
        List<Map.Entry<Purse.Denomination, Integer>> sortedEntries = purse.getCash().entrySet()
                .stream()
                .sorted((entry1, entry2) -> Double.compare(entry2.getKey().amount(), entry1.getKey().amount()))
                .toList();

        // Iterate through the sorted contents of the purse
        for (Map.Entry<Purse.Denomination, Integer> entry : sortedEntries) {

            Purse.Denomination denom = entry.getKey();
            int quantity = entry.getValue();

            // Load the image for this denomination
            Image image = null;
            try {
                image = ImageIO.read(new File("src/images/" + denom.img()));
            } catch (IOException e) {
                e.printStackTrace();
            }

            // Draw the denomination image multiple times based on the quantity
            for (int i = 0; i < quantity; i++) {
                if (image != null) {
                    // Draw each subsequent image slightly offset to create a stacking effect
                    g.drawImage(image, x + (i * offset), y + (i * offset), imageWidth, imageHeight, this);
                }
            }

            // Move to the right for the next denomination
            x += imageWidth + 10;
            if (x > getWidth() - imageWidth) {
                x = 10;
                y += imageHeight + 10;
            }
        }
    }

    // Method to update the purse and repaint the panel if needed
    public void setPurse(Purse purse) {
        this.purse = purse;
        repaint(); // Repaint the panel to update the display
    }
}
