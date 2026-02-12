/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package components;

import java.awt.Image;
import javax.swing.ImageIcon;

public class ProductCard extends javax.swing.JPanel {

    private AddToCartListener listener;
    private String title;
    private double price;
    private int stockQty;

    public ProductCard(
        String imagePath,
        String title,
        double price,
        int stockQty,
        AddToCartListener listener) {

    initComponents();
    this.listener = listener;
    this.title = title;
    this.price = price;
    this.stockQty = stockQty;

    loadImage(imagePath);

    title_field.setText(title);
    Price.setText(String.format("%.2f$", price));

    int safeMax = Math.max(stockQty, 1);

    
    // Optional: increase button size
    amount.setPreferredSize(new java.awt.Dimension(60, 25));
}
    private void loadImage(String imagePath) {
        try {
            ImageIcon icon;
            // 1. If URL (http/https)
            if (imagePath.startsWith("http")) {
                icon = new ImageIcon(new java.net.URL(imagePath));
            } // 2. If absolute/local file path
            else if (new java.io.File(imagePath).exists()) {
                icon = new ImageIcon(imagePath);
            } // 3. Classpath resource (/assets/...)
            else {
                icon = new ImageIcon(getClass().getResource("/assets/" + imagePath));
            }

            Image imgScaled = icon.getImage()
                    .getScaledInstance(233, 162, Image.SCALE_SMOOTH);
            ImageCard.setIcon(new ImageIcon(imgScaled));

        } catch (Exception e) {
            // Fallback image
            ImageIcon fallback = new ImageIcon(
                    getClass().getResource("/assets/no-image.png")
            );
            ImageCard.setIcon(fallback);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ImageCard = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        Price = new javax.swing.JLabel();
        amount = new javax.swing.JSpinner();
        jLabel3 = new javax.swing.JLabel();
        title_field = new javax.swing.JLabel();
        AddBtn = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 0, 0)));

        ImageCard.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ImageCard.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("Price :");

        Price.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        Price.setText("20.50$");

        amount.setValue(1);

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setText("Amount");

        title_field.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        AddBtn.setText("Add To cart");
        AddBtn.addActionListener(this::AddBtnActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ImageCard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(title_field, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Price))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(amount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 26, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(AddBtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(ImageCard, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(title_field, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(Price))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(amount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(AddBtn)
                .addContainerGap(21, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void AddBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddBtnActionPerformed
        if (listener != null) {
            int orderQty = (int) amount.getValue();
            listener.onAddToCart(title, price, orderQty);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_AddBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddBtn;
    private javax.swing.JLabel ImageCard;
    private javax.swing.JLabel Price;
    private javax.swing.JSpinner amount;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel title_field;
    // End of variables declaration//GEN-END:variables
}
