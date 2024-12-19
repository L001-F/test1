package Model;

import java.awt.Color;
import java.awt.Font;

@SuppressWarnings("serial")
public class JTextField extends javax.swing.JTextField {

    public JTextField(int textSize) {
        super();
        setFont(new Font("SansSerif", Font.PLAIN, textSize));
        setForeground(Color.DARK_GRAY);
        setBackground(new Color(240, 248, 255)); // Light blue-ish background
        setCaretColor(Color.BLUE); // Blue caret for better visibility
        setHorizontalAlignment(CENTER);
        setBorder(javax.swing.BorderFactory.createLineBorder(new Color(200, 200, 200), 2)); // Light gray border
        setOpaque(true);
    }
}
