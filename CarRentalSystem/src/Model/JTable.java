package Model;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class JTable extends javax.swing.JTable {

    public JTable(String[][] data, String[] header, Color headerColor, Color alternateRowColor) {
        super(data, header);
        setRowHeight(40);
        setShowGrid(true);
        setGridColor(headerColor);
        setBackground(Color.WHITE);

        DefaultTableModel tableModel = new DefaultTableModel(data, header) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        setModel(tableModel);

        DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(javax.swing.JTable table, Object value, boolean isSelected,
                    boolean hasFocus, int row, int column) {
                super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                setHorizontalAlignment(JLabel.CENTER);
                setFont(new Font("SansSerif", Font.PLAIN, 18));
                setForeground(Color.DARK_GRAY);
                setBorder(null);
                setBackground(row % 2 == 0 ? Color.WHITE : alternateRowColor);
                if (isSelected) {
                    setBackground(new Color(173, 216, 230)); // Light blue highlight for selected row
                    setForeground(Color.BLACK);
                }
                return this;
            }
        };

        for (int i = 0; i < getColumnModel().getColumnCount(); i++) {
            getColumnModel().getColumn(i).setCellRenderer(cellRenderer);
        }

        DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(javax.swing.JTable table, Object value, boolean isSelected,
                    boolean hasFocus, int row, int column) {
                super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                setHorizontalAlignment(JLabel.CENTER);
                setFont(new Font("SansSerif", Font.BOLD, 20));
                setBackground(headerColor);
                setForeground(Color.WHITE);
                setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
                return this;
            }
        };

        getTableHeader().setDefaultRenderer(headerRenderer);
        getTableHeader().setBorder(BorderFactory.createMatteBorder(2, 2, 1, 2, headerColor));
        setBorder(BorderFactory.createMatteBorder(1, 2, 2, 2, headerColor));
    }
}

