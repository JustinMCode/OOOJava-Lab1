import javax.swing.*;

public class MakingChange {

    public static void main(String[] args){

        // Set up Frame and Panel
        JFrame frame = new JFrame("Register");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create an instance of RegisterPanel.TextFieldPanel
        RegisterPanel.TextFieldPanel registerPanel = new RegisterPanel.TextFieldPanel();

        // Add the custom panel to the frame
        frame.getContentPane().add(registerPanel);

        // Finish initializing frame and panel.
        frame.pack();
        frame.setVisible(true);
    }
}
