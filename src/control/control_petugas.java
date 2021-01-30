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
public class control_petugas {
    
    DefaultTableModel model;
    String [] kolom = {"KODE PETUGAS","NAMA PETUGAS","TELEPON"};
    public control_petugas(){
        model = new DefaultTableModel(null,kolom);
    }
    
    public void simpanPetugas(JTextField kodepetugas,JTextField namapetugas,JTextField telepon){
        try {
          Statement st = koneksi.getConnection().createStatement();
          st.executeUpdate("INSERT INTO petugas_antar VALUES('"+kodepetugas.getText()+"','"+namapetugas.getText()+"','"+telepon.getText()+"')");
          JOptionPane.showMessageDialog(null, "Berhasil Ditambahkan");
        } catch (SQLException e) {
          JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void tampilPetugas(JTable data){
        try {
            ResultSet rs = koneksi.getConnection().createStatement().executeQuery("SELECT * FROM petugas_antar");
            while(rs.next()){
             model.addRow(new Object[]{rs.getString(1),rs.getString(2),rs.getString(3), });   
            }
            data.setModel(model);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void refreshPetugas(JTable data){
        DefaultTableModel table = new DefaultTableModel();
        for (String column : kolom) {
            table.addColumn(column);
        }
        try {
            ResultSet rs = koneksi.getConnection().createStatement().executeQuery("SELECT * FROM petugas_antar");
            while(rs.next()){
               table.addRow(new Object[]{rs.getString(1),rs.getString(2),rs.getString(3)});
            }
            data.setModel(table);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
     
    public void hapusPetugas(String kodepetugas){
        if(JOptionPane.showConfirmDialog(null, "Apakah anda Yakin Ingin di Hapus ","Warning",2) == JOptionPane.YES_OPTION){
             try {
                Statement st = koneksi.getConnection().createStatement();
                st.executeUpdate("DELETE FROM PETUGAS_ANTAR WHERE kode_petugas='"+kodepetugas+"'");
                JOptionPane.showMessageDialog(null, "Berhasil dIhapus");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    } 
    
    public void ubahPetugas(JTextField kodepetugas,JTextField namapetugas,JTextField telepon){
        try {
           Statement st = koneksi.getConnection().createStatement();
           st.executeUpdate("UPDATE PETUGAS_ANTAR SET NAMA_PETUGAS='"+namapetugas.getText()+"',NO_TELEPON='"+telepon.getText()+"' WHERE KODE_PETUGAS='"+kodepetugas.getText()+"'");
           JOptionPane.showMessageDialog(null, "Berhasil Diubah");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    public void autoNumberPetugas(JTextField kodepetugas){
        try {
            ResultSet rs = koneksi.getConnection().createStatement().executeQuery("SELECT * FROM petugas_antar ORDER BY kode_petugas DESC");
            if(rs.next()){
                String kode = "" +(Integer.parseInt(rs.getString("kode_petugas").substring(2))+1) ;
                String angka = "";
                if(kode.length() ==1){
                    angka = "000";
                }else if(kode.length()==2){
                    angka = "00";
                }else if(kode.length()==3){
                    angka = "0";
                }else if(kode.length()==4){
                    angka = "";
                }
                kodepetugas.setText("KP"+angka+kode);
            }else{
                kodepetugas.setText("KP0001");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    public void refreshJcomboPetugas(JComboBox comboBox){
        DefaultComboBoxModel Jcombo = new DefaultComboBoxModel();
        Jcombo.addElement("pilih");
        try {
            ResultSet rs = koneksi.getConnection().createStatement().executeQuery("SELECT nama_petugas FROM petugas_antar");
            while (rs.next()) {                
                Jcombo.addElement(rs.getString(1));
            }
            comboBox.setModel(Jcombo);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
}
