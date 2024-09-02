import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterPanel {

    public static class TextFieldPanel extends JPanel {
        private final JTextField textField;
        private final JLabel label;

        public TextFieldPanel() {
            this.setPreferredSize(new Dimension(700, 700));
            this.setBackground(Color.WHITE);

            textField = new JTextField();
            textField.setPreferredSize(new Dimension(300, 50));
            textField.setFont(new Font("sanserif", Font.PLAIN, 40));
            textField.addActionListener(new InputListener());

            label = new JLabel("Please Enter how much change you would like!");
            label.setFont(new Font("sanserif", Font.PLAIN, 20));

            this.add(textField);
            this.add(label);
        }

        private class InputListener implements ActionListener {

            public void actionPerformed(ActionEvent e) {
                String text = textField.getText();
                double amt = Double.parseDouble(text);

                System.out.println(text);

                label.setText("$" + amt);
                label.setIcon(new ImageIcon("images/penny.jfif"));

            }
        }
    }
}