package Model;

import java.awt.Color;
import java.awt.Font;

@SuppressWarnings("serial")
public class JLabel extends javax.swing.JLabel {

    public JLabel(String text, int fontSize) {
        super(text);

        // Set default styling
        setFont(new Font("SansSerif", Font.BOLD, fontSize)); // Bold font
        setForeground(new Color(70, 70, 70)); // Dark gray text color
        setHorizontalAlignment(CENTER); // Center-align text
        setOpaque(true); // Enable background color painting
        setBackground(new Color(240, 248, 255)); // Light blue-ish white background
    }

    /**
     * Method to allow easy customization of colors externally.
     * 
     * @param textColor The desired text color.
     * @param bgColor   The desired background color.
     */
    public void setColors(Color textColor, Color bgColor) {
        setForeground(textColor);
        setBackground(bgColor);
    }
}
