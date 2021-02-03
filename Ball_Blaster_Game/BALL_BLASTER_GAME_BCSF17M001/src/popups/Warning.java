/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package popups;

import javax.swing.JFrame;

/**
 *
 * @author abdul
 */
public class Warning extends javax.swing.JPanel {

    private JFrame frame;

    public Warning(JFrame frame) {
        this.frame = frame;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        header = new javax.swing.JLabel();
        warning = new javax.swing.JLabel();
        close = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 51, 51));
        setBorder(new javax.swing.border.MatteBorder(null));
        setForeground(new java.awt.Color(204, 255, 102));

        header.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        header.setForeground(new java.awt.Color(51, 255, 255));
        header.setText("Warning");

        warning.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        warning.setForeground(new java.awt.Color(51, 255, 255));
        warning.setText("Not Enough Coins");

        close.setBackground(new java.awt.Color(51, 255, 255));
        close.setForeground(new java.awt.Color(255, 102, 51));
        close.setText("Close");
        close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(153, 153, 153)
                                                .addComponent(header))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(122, 122, 122)
                                                .addComponent(warning))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(160, 160, 160)
                                                .addComponent(close)))
                                .addContainerGap(130, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(warning)
                                .addGap(34, 34, 34)
                                .addComponent(close)
                                .addContainerGap(99, Short.MAX_VALUE))
        );
    }// </editor-fold>                        

    private void closeActionPerformed(java.awt.event.ActionEvent evt) {
        frame.dispose();
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton close;
    private javax.swing.JLabel header;
    private javax.swing.JLabel warning;
    // End of variables declaration                   
}
