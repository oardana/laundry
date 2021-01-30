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

public class control_biaya {
    
    DefaultTableModel model;
    String [] kolom = {"KODE BIAYA","KETERANGAN","BIAYA"};
    public control_biaya(){
        model = new DefaultTableModel(null,kolom);
    }
    
    public void simpanBiaya(JTextField kodebiaya,JTextField keterangan,JTextField biaya){
        try {
            Statement st = koneksi.getConnection().createStatement();
            st.executeUpdate("INSERT INTO biaya_tambahan VALUES('"+kodebiaya.getText()+"','"+keterangan.getText()+"','"+biaya.getText()+"')");
            JOptionPane.showMessageDialog(null, "Berhasil Ditambahkan");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void tampilBiaya(JTable data){
        try {
            ResultSet rs = koneksi.getConnection().createStatement().executeQuery("SELECT * FROM biaya_tambahan ");
            while(rs.next()){
             model.addRow(new Object[]{rs.getString(1),rs.getString(2),rs.getString(3)});   
            }
            data.setModel(model);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void refreshBiaya(JTable data){
        DefaultTableModel table = new DefaultTableModel();
        for (String column : kolom) {
            table.addColumn(column);
        }
        try {
            ResultSet rs = koneksi.getConnection().createStatement().executeQuery("SELECT * FROM biaya_tambahan ");
            while(rs.next()){
               table.addRow(new Object[]{rs.getString(1),rs.getString(2),rs.getString(3)});
            }
            data.setModel(table);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
     
    public void hapusBiaya(String kodebiaya){
        if(JOptionPane.showConfirmDialog(null, "Apakah anda Yakin Ingin di Hapus ","Warning",2) == JOptionPane.YES_OPTION){
             try {
                Statement st = koneksi.getConnection().createStatement();
                st.executeUpdate("DELETE FROM biaya_tambahan WHERE kode_biaya='"+kodebiaya+"'");
                JOptionPane.showMessageDialog(null, "Berhasil dihapus");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    } 
    
    public void ubahBiaya(String kodebiaya,String keterangan,String biaya){
        if(kodebiaya.isEmpty() ||keterangan.isEmpty() || biaya.isEmpty() ){
            JOptionPane.showMessageDialog(null, "Data Tidak Boleh Kosong");
        }else{
            try {
                Statement st = koneksi.getConnection().createStatement();
                st.executeUpdate("UPDATE biaya_tambahan SET keterangan='"+keterangan+"',biaya='"+biaya+"' WHERE kode_biaya='"+kodebiaya+"'");
                JOptionPane.showMessageDialog(null, "Berhasil Diubah");
                
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }
    
    public void autoNumberBiaya(JTextField kodebiaya){
        try {
           ResultSet rs = koneksi.getConnection().createStatement().executeQuery("SELECT * FROM biaya_tambahan ORDER BY kode_biaya DESC");
           if(rs.next()){
               String kode = "" + (Integer.parseInt(rs.getString("kode_biaya").substring(2))+1);
               String angka = "";
               if(kode.length()==1){
                   angka = "000";
               }else if(kode.length()==2){
                   angka = "00";
               }else if(kode.length()==3){
                   angka = "0";
               }else if(kode.length()==4){
                   angka= "";
               }
               kodebiaya.setText("KB"+angka+kode);
           }else{
               kodebiaya.setText("KB0001");
           }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void refreshJcomboBiaya(JComboBox comboBox){
        DefaultComboBoxModel Jcombo = new DefaultComboBoxModel();
        Jcombo.addElement("pilih");
        try {
            ResultSet rs = koneksi.getConnection().createStatement().executeQuery("SELECT biaya FROM biaya_tambahan");
            while (rs.next()) {                
                Jcombo.addElement(rs.getString(1));
            }
            comboBox.setModel(Jcombo);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
