package Model;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.plaf.basic.BasicComboBoxRenderer;

@SuppressWarnings({ "rawtypes", "serial" })
public class JComboBox extends javax.swing.JComboBox {

    @SuppressWarnings("unchecked")
    public JComboBox(String[] items, int fontSize) {
        super(items);

        // Set default styling
        setFont(new Font("SansSerif", Font.BOLD, fontSize)); // Set bold font
        setBackground(new Color(240, 248, 255)); // Light blue-ish white background
        setForeground(Color.DARK_GRAY); // Dark gray text
        setFocusable(false); // Remove focus effect

        // Add a custom renderer for drop-down items and selected items
        setRenderer(new CustomComboBoxRenderer(fontSize));
    }

    // Custom renderer for JComboBox
    private class CustomComboBoxRenderer extends DefaultListCellRenderer {
        private int fontSize;

        public CustomComboBoxRenderer(int fontSize) {
            this.fontSize = fontSize;
        }

        @Override
        public Component getListCellRendererComponent(
                javax.swing.JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {

            JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            label.setFont(new Font("SansSerif", Font.BOLD, fontSize)); // Set font for items
            label.setHorizontalAlignment(SwingConstants.CENTER); // Center-align text

            if (isSelected) {
                label.setBackground(new Color(70, 130, 180)); // Steel blue for selected item
                label.setForeground(Color.WHITE); // White text for selected item
            } else {
                label.setBackground(Color.WHITE); // White background for unselected items
                label.setForeground(Color.DARK_GRAY); // Dark gray text for unselected items
            }

            return label;
        }
    }
}
