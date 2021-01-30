/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Oki Ardana
 */
public class control_orderan {
    DefaultTableModel model;
    String [] kolom = {"NAMA","TELEPON","ALAMAT","LAYANAN","BIAYA","ITEM","TANGGAL","SELESAI","BIAYA ANTAR","BIAYA JEMPUT","BIAYA HARI","PETUGAS","STATUS"};
    public control_orderan(){
        model = new DefaultTableModel(null,kolom);
    }
    
    public void tampilOrderan(JTable data){
        try {
            ResultSet rs = koneksi.getConnection().createStatement().executeQuery("SELECT nama,pesan.no_telepon,alamat,jenis_layanan,biaya,jumlah_unit,tanggal_order,tanggal_selesai,biaya_antar,biaya_jemput,biaya_hari,petugas_antar,status_order FROM pelanggan INNER JOIN pesan ON pesan.kode_pelanggan = pelanggan.kode_pelanggan INNER JOIN detail_order ON pesan.kode_order = detail_order.kode_order ");
            while(rs.next()){
             model.addRow(new Object[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13)});   
            }
            data.setModel(model);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    public void refreshOrderan(JTable data){
        DefaultTableModel tabel = new DefaultTableModel();
        for (String isi : kolom) {
            tabel.addColumn(isi);
        }
        try {
            ResultSet rs = koneksi.getConnection().createStatement().executeQuery("SELECT nama,pesan.no_telepon,alamat,jenis_layanan,biaya,jumlah_unit,tanggal_order,tanggal_selesai,biaya_antar,biaya_jemput,biaya_hari,petugas_antar,status_order FROM pelanggan INNER JOIN pesan ON pesan.kode_pelanggan = pelanggan.kode_pelanggan INNER JOIN detail_order ON pesan.kode_order = detail_order.kode_order ");
            while(rs.next()){
             tabel.addRow(new Object[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13)});   
            }
            data.setModel(tabel);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void cariOrderan(JTable data, JTextField telepon){
        DefaultTableModel tabel = new DefaultTableModel();
        for (String isi : kolom) {
            tabel.addColumn(isi);
        }
        try {
            ResultSet rs = koneksi.getConnection().createStatement().executeQuery("SELECT nama,pesan.no_telepon,alamat,jenis_layanan,biaya,jumlah_unit,tanggal_order,tanggal_selesai,biaya_antar,biaya_jemput,biaya_hari,petugas_antar,status_order FROM pelanggan INNER JOIN pesan ON pesan.kode_pelanggan = pelanggan.kode_pelanggan INNER JOIN detail_order ON pesan.kode_order = detail_order.kode_order WHERE pesan.no_telepon LIKE '%"+telepon.getText()+"%' ");
            while(rs.next()){
             tabel.addRow(new Object[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13)});   
            }
            data.setModel(tabel);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void kode(JTextField telepon,JTextField kodeorder,JTextField kodepelanggan){
        try {
            ResultSet rs = koneksi.getConnection().createStatement().executeQuery("SELECT kode_order,kode_pelanggan FROM PESAN WHERE no_telepon='"+telepon.getText()+"'");
            while(rs.next()){
                kodeorder.setText(rs.getString(1));
                kodepelanggan.setText(rs.getString(2));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void pilihCombo(JComboBox layanan,String query){
        try {
            ResultSet rs = koneksi.getConnection().createStatement().executeQuery(query);
            while(rs.next()){
               layanan.addItem(rs.getString(1));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    public void tampillayanan(JTextField kodelayanan, JTextField biayalayanan, JComboBox layanan){
        try {
            ResultSet rs = koneksi.getConnection().createStatement().executeQuery("SELECT KODE_LAYANAN, BIAYA FROM LAYANAN WHERE JENIS_LAYANAN='"+layanan.getSelectedItem()+"'");
            while(rs.next()){
                kodelayanan.setText(rs.getString("kode_layanan"));
                biayalayanan.setText(rs.getString("biaya"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void editOrder(JTextField kodeorder,JTextField kodepelanggan, JTextField nama,JTextField telepon,JTextArea alamat, JComboBox layanan,JTextField biayalayanan, JTextField item, JTextField biayaantar, JTextField biayajemput, JComboBox biayahari, JComboBox petugasantar){
        try {
            Statement st = koneksi.getConnection().createStatement();
            st.executeUpdate("UPDATE pelanggan SET nama='"+nama.getText()+"',no_telepon='"+telepon.getText()+"',alamat='"+alamat.getText()+"' WHERE kode_pelanggan='"+kodepelanggan.getText()+"'");
            st.executeUpdate("UPDATE pesan SET no_telepon='"+telepon.getText()+"',biaya_antar='"+biayaantar.getText()+"',biaya_jemput='"+biayajemput.getText()+"',biaya_hari='"+biayahari.getSelectedItem().toString()+"',petugas_antar='"+petugasantar.getSelectedItem().toString()+"' WHERE kode_order='"+kodeorder.getText()+"'");
            st.executeUpdate("UPDATE detail_order SET jenis_layanan='"+layanan.getSelectedItem().toString()+"',jumlah_unit='"+item.getText()+"',biaya='"+biayalayanan.getText()+"' WHERE kode_order='"+kodeorder.getText()+"'");
            JOptionPane.showMessageDialog(null, "Berhasil Diubah");
            st.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void autoNumberOrder(JTextField kode,String digit,String query){
        try {
           ResultSet rs = koneksi.getConnection().createStatement().executeQuery(query);
           if(rs.next()){
               String code = "" + (Integer.parseInt(rs.getString(1).substring(2))+1);
               String angka = "";
               if(code.length()==1){
                   angka = "000";
               }else if(code.length()==2){
                   angka = "00";
               }else if(code.length()==3){
                   angka = "0";
               }else if(code.length()==4){
                   angka= "";
               }
               kode.setText(digit+angka+code);
           }else{
               kode.setText(digit+"0001");
           }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void addDataOrder(JTextField kodepelanggan,JTextField nama, JTextField telepon,JTextArea alamat,JTextField kodeorder,JLabel tanggal,JTextField enddate,JTextField biayaantar,JTextField biayajemput, JComboBox biayahari,JComboBox petugas,JTextField kodelayanan,JComboBox layanan,JTextField item, JTextField biayalayanan){
        try {
          Statement st = koneksi.getConnection().createStatement();
          st.executeUpdate("INSERT INTO PELANGGAN VALUES('"+kodepelanggan.getText()+"','"+nama.getText()+"','"+telepon.getText()+"','"+alamat.getText()+"')");
          st.executeUpdate("INSERT INTO PESAN VALUES('"+kodeorder.getText()+"','"+kodepelanggan.getText()+"','"+telepon.getText()+"','"+tanggal.getText()+"','"+enddate.getText()+"','"+biayaantar.getText()+"','"+biayajemput.getText()+"','"+biayahari.getSelectedItem().toString()+"','"+petugas.getSelectedItem().toString()+"','belum selesai')");
          st.executeUpdate("INSERT INTO DETAIL_ORDER VALUES('"+kodeorder.getText()+"','"+kodelayanan.getText()+"','"+layanan.getSelectedItem().toString()+"','"+item.getText()+"','"+biayalayanan.getText()+"')");
          JOptionPane.showMessageDialog(null, "Berhasil Dimasukan");
        } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    public void deleteOrder(JTextField kodepelanggan){
        try {
            Statement st = koneksi.getConnection().createStatement();
            st.executeUpdate("DELETE FROM PElanggan WHERE kode_pelanggan='"+kodepelanggan.getText()+"' ");
            JOptionPane.showMessageDialog(null, "Berhasil Dihapus");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    public void setKonfir(JTextField kodeorder){
        try {
            Statement st = koneksi.getConnection().createStatement();
            st.executeUpdate("UPDATE pesan SET status_order='Selesai' WHERE kode_order='"+kodeorder.getText()+"' ");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
}
