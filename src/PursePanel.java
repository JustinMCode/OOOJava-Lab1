import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.util.Map;

public class PursePanel extends JPanel {
    private Purse purse;

    public PursePanel(Purse purse) {
        this.purse = purse;
        setPreferredSize(new Dimension(400, 400));
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int x = 10; // Starting x position for drawing
        int y = 10; // Starting y position for drawing
        int offset = 5; // Offset for stacking
        int imageWidth = 120;
        int imageHeight = 80;

        // Iterate through the contents of the purse
        for (Map.Entry<Purse.Denomination, Integer> entry : purse.getCash().entrySet()) {

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
            x += imageWidth + 10; // Adjust x position based on image width and spacing
            if (x > getWidth() - imageWidth) { // If we reach the end of the panel, move to the next line
                x = 10;
                y += imageHeight + 10; // Move y position down for the next row
            }
        }
    }

    public void setPurse(Purse purse) {
        this.purse = purse;
        repaint(); // Repaint the panel to update the display
    }
}
