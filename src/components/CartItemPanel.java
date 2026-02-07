package components;

import java.awt.*;
import javax.swing.*;

public class CartItemPanel extends JPanel {
    private JLabel titleLabel;
    private JLabel priceLabel;

    public CartItemPanel(String title, double price) {
//        setLayout(new BorderLayout(10, 0));

        // Make panel visible
//        setOpaque(true);
//        setBackground(Color.WHITE);                  // white background
//        setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
//        setMaximumSize(new Dimension(Integer.MAX_VALUE, 40)); // fixed height

        // Title label
        titleLabel = new JLabel(title);
        titleLabel.setFont(new Font("Dialog", Font.PLAIN, 16));
        titleLabel.setForeground(Color.BLACK);       // black title

        // Price label in RED
        priceLabel = new JLabel(String.format("$%.2f", price));
        priceLabel.setFont(new Font("Dialog", Font.BOLD, 16));
        priceLabel.setForeground(Color.RED);        // <-- red color
        priceLabel.setHorizontalAlignment(SwingConstants.RIGHT);

        // Add to panel
        add(titleLabel, BorderLayout.WEST);
        add(priceLabel, BorderLayout.EAST);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(255, 51, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
