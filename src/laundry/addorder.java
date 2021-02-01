/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laundry;

import control.control_orderan;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.*;

/**
 *
 * @author Oki Ardana
 */

public class addorder extends JFrame{
    boolean ceklis;
    control_orderan control_orderan;
    public addorder() {
        initComponents();
        tanggal.setText(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        jpetugas.setVisible(false);
        bantar.setVisible(false);
        bjemput.setVisible(false);
        petugas.setVisible(false);
        biayaantar.setVisible(false);
        biayajemput.setVisible(false);
        control_orderan = new control_orderan();
        control_orderan.pilihCombo(layanan, "SELECT jenis_layanan FROM layanan");
        control_orderan.pilihCombo(petugas, "SELECT nama_petugas FROM petugas_antar");
        control_orderan.pilihCombo(biayahari, "SELECT biaya FROM biaya_tambahan");
        control_orderan.autoNumberOrder(kodepelanggan, "KP", "SELECT * FROM pelanggan ORDER BY kode_pelanggan DESC");
        control_orderan.autoNumberOrder(kodeorder, "KO", "SELECT * FROM pesan ORDER BY kode_order DESC");
        addDate(3);
        kodelayanan.setVisible(false);
        enddate.setVisible(false);
        biayalayanan.setEditable(false);
        kodepelanggan.setVisible(false);
        kodeorder.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        item = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        alamat = new javax.swing.JTextArea();
        biayaantar = new javax.swing.JTextField();
        bantar = new javax.swing.JLabel();
        biayajemput = new javax.swing.JTextField();
        bjemput = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        nama = new javax.swing.JTextField();
        jpetugas = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        telepon = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        biayalayanan = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();
        jLabel16 = new javax.swing.JLabel();
        cekantarjemput = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tanggal = new javax.swing.JLabel();
        enddate = new javax.swing.JTextField();
        kodelayanan = new javax.swing.JTextField();
        kodeorder = new javax.swing.JTextField();
        kodepelanggan = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        simpanorder = new javax.swing.JButton();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(100, 100, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        item.setText("0");
        jPanel1.add(item, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 260, 130, 28));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Item");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 230, -1, -1));

        alamat.setColumns(20);
        alamat.setRows(5);
        jScrollPane3.setViewportView(alamat);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 155, -1));

        biayaantar.setText("0");
        jPanel1.add(biayaantar, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 200, 130, 28));

        bantar.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        bantar.setForeground(new java.awt.Color(255, 255, 255));
        bantar.setText("Biaya Antar");
        jPanel1.add(bantar, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 170, -1, -1));

        biayajemput.setText("0");
        jPanel1.add(biayajemput, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 270, 130, 28));

        bjemput.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        bjemput.setForeground(new java.awt.Color(255, 255, 255));
        bjemput.setText("Biaya Jemput");
        jPanel1.add(bjemput, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 240, -1, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Selesai");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 160, -1, -1));

        petugas.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "pilih" }));
        jPanel1.add(petugas, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 120, 130, 32));

        biayahari.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0" }));
        biayahari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                biayahariActionPerformed(evt);
            }
        });
        jPanel1.add(biayahari, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 120, 130, 32));
        jPanel1.add(nama, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 130, 28));

        jpetugas.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jpetugas.setForeground(new java.awt.Color(255, 255, 255));
        jpetugas.setText("Petugas");
        jPanel1.add(jpetugas, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 90, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Nama");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, -1, -1));

        telepon.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                teleponKeyTyped(evt);
            }
        });
        jPanel1.add(telepon, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 130, 28));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Telepon");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, -1));
        jPanel1.add(biayalayanan, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 180, 130, 28));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Biaya");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 160, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Alamat");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, -1, -1));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Hari");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 180, -1, -1));

        jSpinner1.setModel(new javax.swing.SpinnerNumberModel(3, null, null, 1));
        jSpinner1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinner1StateChanged(evt);
            }
        });
        jPanel1.add(jSpinner1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 180, 100, 30));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Biaya Hari");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 90, -1, -1));

        layanan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "pilih" }));
        layanan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                layananActionPerformed(evt);
            }
        });
        jPanel1.add(layanan, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 120, 130, 30));

        cekantarjemput.setForeground(new java.awt.Color(255, 255, 255));
        cekantarjemput.setText("Antar/Jemput");
        cekantarjemput.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cekantarjemputMouseClicked(evt);
            }
        });
        jPanel1.add(cekantarjemput, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 120, -1, -1));

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Add Data Order");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 40, 190, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("X");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 0, 40, 30));

        tanggal.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        tanggal.setForeground(new java.awt.Color(255, 255, 255));
        tanggal.setText(".");
        jPanel2.add(tanggal, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 10, 120, -1));
        jPanel2.add(enddate, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 130, 30));
        jPanel2.add(kodelayanan, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 40, 120, 30));
        jPanel2.add(kodeorder, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 40, 120, 30));
        jPanel2.add(kodepelanggan, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 40, 130, 30));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 80));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Layanan");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 90, -1, -1));

        simpanorder.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        simpanorder.setText("Simpan");
        simpanorder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanorderActionPerformed(evt);
            }
        });
        jPanel1.add(simpanorder, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 430, 130, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 505, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    private void cekAntarJemput(boolean cek){
        if(cek == true){
            jpetugas.setVisible(false);
            bantar.setVisible(false);
            bjemput.setVisible(false);
            petugas.setVisible(false);
            biayaantar.setVisible(false);
            biayajemput.setVisible(false);
        }else{
            petugas.setVisible(true);
            biayaantar.setVisible(true);
            biayajemput.setVisible(true);
            jpetugas.setVisible(true);
            bantar.setVisible(true);
            bjemput.setVisible(true);
        }
    }
    
    private void addDate(int tambah){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar caltambah = Calendar.getInstance();
        caltambah.setTime(new java.util.Date());
        caltambah.add(Calendar.DAY_OF_MONTH, tambah);
        enddate.setText(sdf.format(caltambah.getTime()));
    }
    private void sendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendActionPerformed
        
    }//GEN-LAST:event_sendActionPerformed

    private void cekantarjemputMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cekantarjemputMouseClicked
        if(ceklis == true){
            cekAntarJemput(ceklis);
            ceklis = false;
        }else{
            cekAntarJemput(ceklis);
            ceklis = true;
        }
    }//GEN-LAST:event_cekantarjemputMouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        this.dispose();
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jSpinner1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinner1StateChanged
      addDate(Integer.parseInt(jSpinner1.getValue().toString()));
    }//GEN-LAST:event_jSpinner1StateChanged

    private void layananActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_layananActionPerformed
       if(layanan.getSelectedItem().equals("pilih")){
           kodelayanan.setText("");
           biayalayanan.setText("");
       }else{
           control_orderan.tampillayanan(kodelayanan, biayalayanan, layanan);
       }
    }//GEN-LAST:event_layananActionPerformed

    private void simpanorderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanorderActionPerformed
        if(nama.getText().isEmpty() || telepon.getText().isEmpty() || alamat.getText().isEmpty() || layanan.getSelectedItem().equals("pilih") || biayalayanan.getText().isEmpty() || item.getText().isEmpty() || biayahari.getSelectedItem().equals(0)){
            JOptionPane.showMessageDialog(null, "Data Tidak Bisa Kosong");
        }else if(telepon.getText().length() != 12){
            JOptionPane.showMessageDialog(null, "No Telepon Harus 12 Digit");
        }else{
            control_orderan.addDataOrder(kodepelanggan, nama, telepon, alamat, kodeorder, tanggal, enddate, biayaantar, biayajemput, biayahari, petugas, kodelayanan, layanan, item, biayalayanan);
            dispose();
            control_orderan.autoNumberOrder(kodepelanggan, "KP", "SELECT * FROM pelanggan ORDER BY kode_pelanggan DESC");
            control_orderan.autoNumberOrder(kodeorder, "KO", "SELECT * FROM pesan ORDER BY kode_order DESC");
            reset();
            control_orderan.refreshOrderan(admin.tabelorderan); 
        }
    }//GEN-LAST:event_simpanorderActionPerformed

    private void teleponKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_teleponKeyTyped
        if(telepon.getText().length() == 12 ){
            evt.consume();
        }
    }//GEN-LAST:event_teleponKeyTyped

    private void biayahariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_biayahariActionPerformed
        
    }//GEN-LAST:event_biayahariActionPerformed
    
    private void reset(){
        nama.setText("");
        telepon.setText(""); 
        alamat.setText("");
        layanan.setSelectedItem("pilih");
        biayalayanan.setText("");
        item.setText("0");
        biayahari.setSelectedItem("0");
        biayaantar.setText("0");
        biayajemput.setText("0");
        jSpinner1.setValue(3);
        petugas.setSelectedItem("pilih");
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(addorder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(addorder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(addorder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(addorder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new addorder().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTextArea alamat;
    public javax.swing.JLabel bantar;
    public javax.swing.JTextField biayaantar;
    public static final javax.swing.JComboBox biayahari = new javax.swing.JComboBox();
    public javax.swing.JTextField biayajemput;
    public javax.swing.JTextField biayalayanan;
    public javax.swing.JLabel bjemput;
    public javax.swing.JCheckBox cekantarjemput;
    public javax.swing.JTextField enddate;
    public javax.swing.JTextField item;
    public javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel10;
    public javax.swing.JLabel jLabel13;
    public javax.swing.JLabel jLabel15;
    public javax.swing.JLabel jLabel16;
    public javax.swing.JLabel jLabel2;
    public javax.swing.JLabel jLabel3;
    public javax.swing.JLabel jLabel4;
    public javax.swing.JLabel jLabel5;
    public javax.swing.JLabel jLabel6;
    public javax.swing.JLabel jLabel7;
    public javax.swing.JLabel jLabel9;
    public javax.swing.JPanel jPanel1;
    public javax.swing.JPanel jPanel2;
    public javax.swing.JScrollPane jScrollPane3;
    public javax.swing.JSpinner jSpinner1;
    public javax.swing.JLabel jpetugas;
    public javax.swing.JTextField kodelayanan;
    public javax.swing.JTextField kodeorder;
    public javax.swing.JTextField kodepelanggan;
    public static final javax.swing.JComboBox<String> layanan = new javax.swing.JComboBox<>();
    public javax.swing.JTextField nama;
    public static final javax.swing.JComboBox petugas = new javax.swing.JComboBox();
    public javax.swing.JButton simpanorder;
    public javax.swing.JLabel tanggal;
    public javax.swing.JTextField telepon;
    // End of variables declaration//GEN-END:variables
}