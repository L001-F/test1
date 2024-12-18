package Model;

import java.awt.Color;
import java.awt.Font;

@SuppressWarnings("serial")
public class JPasswordField extends javax.swing.JPasswordField {

    public JPasswordField(int textSize) {
        super();
        setFont(new Font("SansSerif", Font.BOLD, textSize));
        setForeground(Color.DARK_GRAY);
        setBackground(new Color(240, 248, 255));
        setCaretColor(Color.BLUE);
        setHorizontalAlignment(CENTER);
        setBorder(javax.swing.BorderFactory.createLineBorder(new Color(200, 200, 200), 2));
        setOpaque(true);
    }
}
