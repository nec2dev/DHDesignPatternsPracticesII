/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ahorcado.vista;

import java.awt.event.ActionListener;
import javax.swing.ImageIcon;

/**
 *
 * @author fvideau
 */
public class About extends javax.swing.JFrame {

    /**
     * Creates new form About
     */
    public About() {
        initComponents();
        setIconImage( new ImageIcon(getClass().getResource("/ahorcado/resources/logo.png" )).getImage());
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("About");
        this.txtAreaAbout.setEditable(false);
        this.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    }
    
    public void setHandlers(ActionListener hok){
        this.btnOk.addActionListener(hok);
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelAbout = new javax.swing.JPanel();
        btnOk = new javax.swing.JButton();
        txtAreaAbout = new javax.swing.JTextArea();
        labelAbout = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(null);
        setMinimumSize(null);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(600, 400));
        getContentPane().setLayout(null);

        panelAbout.setBackground(new java.awt.Color(255, 204, 0));
        panelAbout.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        panelAbout.setMaximumSize(null);
        panelAbout.setMinimumSize(new java.awt.Dimension(600, 400));
        panelAbout.setOpaque(false);
        panelAbout.setPreferredSize(new java.awt.Dimension(600, 400));

        btnOk.setBackground(new java.awt.Color(0, 0, 0));
        btnOk.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        btnOk.setForeground(new java.awt.Color(255, 204, 0));
        btnOk.setText("OK");
        btnOk.setBorder(null);
        btnOk.setBorderPainted(false);
        btnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkActionPerformed(evt);
            }
        });

        txtAreaAbout.setColumns(20);
        txtAreaAbout.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        txtAreaAbout.setForeground(new java.awt.Color(255, 204, 0));
        txtAreaAbout.setRows(5);
        txtAreaAbout.setText("Profesores: Emiliano Papasidero y Diego Gómez Rivera\n\nAlumnos:\nMaximiliano Arrettino\nFernando Betancor\nMaría Eugenia Coraita\nNahuel Ezequiel Correa\nEric Emanuel Graff\nJudith Grau\nCarolina Vanesa Insaurralde\nAna Paula Montenegro Alderete\nAntonia Puca\nGerardo Tapia\nMicaela Teseira \nFederico Videau\nEzequiel Toloza");
        txtAreaAbout.setBorder(null);
        txtAreaAbout.setFocusable(false);
        txtAreaAbout.setOpaque(false);

        javax.swing.GroupLayout panelAboutLayout = new javax.swing.GroupLayout(panelAbout);
        panelAbout.setLayout(panelAboutLayout);
        panelAboutLayout.setHorizontalGroup(
            panelAboutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAboutLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtAreaAbout, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(226, Short.MAX_VALUE))
            .addComponent(btnOk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelAboutLayout.setVerticalGroup(
            panelAboutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAboutLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtAreaAbout, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(btnOk, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(panelAbout);
        panelAbout.setBounds(0, 0, 600, 400);

        labelAbout.setBackground(new java.awt.Color(0, 0, 0));
        labelAbout.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelAbout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ahorcado/resources/CastleAbout.gif"))); // NOI18N
        labelAbout.setMaximumSize(new java.awt.Dimension(600, 400));
        labelAbout.setMinimumSize(new java.awt.Dimension(600, 400));
        labelAbout.setPreferredSize(new java.awt.Dimension(600, 400));
        getContentPane().add(labelAbout);
        labelAbout.setBounds(0, 0, 600, 400);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnOkActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOk;
    private javax.swing.JLabel labelAbout;
    private javax.swing.JPanel panelAbout;
    private javax.swing.JTextArea txtAreaAbout;
    // End of variables declaration//GEN-END:variables
}
