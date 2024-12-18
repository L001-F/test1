package Model;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class JButton extends javax.swing.JButton {

    public JButton(String text, int textSize) {
        super(text);

        // Default styles
        setBackground(new Color(30, 144, 255)); // Light blue background
        setFont(new Font("SansSerif", Font.BOLD, textSize)); // Font style
        setForeground(Color.white); // White text
        setFocusPainted(false); // Remove focus border
        setBorderPainted(false); // No default border
        setContentAreaFilled(true); // Enable background fill
        setOpaque(true); // Make button background visible

        // Add hover effects
        addHoverEffect();
    }

    private void addHoverEffect() {
        // Store the original background and hover colors
        Color defaultBackground = new Color(30, 144, 255); // Light blue
        Color hoverBackground = new Color(70, 130, 180);   // Slightly darker blue
        Color pressedBackground = new Color(25, 100, 175); // Darker blue for click

        // Add mouse listeners for hover and pressed effects
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                setBackground(hoverBackground); // Change background on hover
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setBackground(defaultBackground); // Revert background on exit
            }

            @Override
            public void mousePressed(MouseEvent e) {
                setBackground(pressedBackground); // Change background on press
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                setBackground(hoverBackground); // Revert to hover color after release
            }
        });
    }
}
