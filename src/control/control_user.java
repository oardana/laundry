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
public class control_user {
    
    DefaultTableModel model;
    String [] kolom = {"KODE USER","NAMA","EMAIL","PASSWORD","LEVEL"};
    public int data ;
    public control_user(){
        model = new DefaultTableModel(null,kolom);
    }
    
    public void simpanUser(JTextField kodeuser,JTextField nama,JTextField email,JTextField password, JComboBox level){
        try {
          Statement st = koneksi.getConnection().createStatement();
          st.executeUpdate("INSERT INTO USER VALUES('"+kodeuser.getText()+"','"+nama.getText()+"','"+email.getText()+"','"+password.getText()+"','"+level.getSelectedItem().toString()+"')");
          JOptionPane.showMessageDialog(null, "Berhasil Ditambahkan");
        } catch (SQLException e) {
          JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void tampilUser(JTable data){
        try {
            ResultSet rs = koneksi.getConnection().createStatement().executeQuery("SELECT * FROM user");
            while(rs.next()){
             model.addRow(new Object[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)});   
            }
            data.setModel(model);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void tabel(JTable data){
        DefaultTableModel table = new DefaultTableModel();
        for (String column : kolom) {
            table.addColumn(column);
        }
        try {
            ResultSet rs = koneksi.getConnection().createStatement().executeQuery("SELECT * FROM user");
            while(rs.next()){
               table.addRow(new Object[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)});
            }
            data.setModel(table);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
     
    public void hapusUser(String kodeuser){
        if(JOptionPane.showConfirmDialog(null, "Apakah anda Yakin Ingin di Hapus ","Warning",2) == JOptionPane.YES_OPTION){
             try {
                Statement st = koneksi.getConnection().createStatement();
                st.executeUpdate("DELETE FROM USER WHERE KODE_USER='"+kodeuser+"'");
                JOptionPane.showMessageDialog(null, "Berhasil dIhapus");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    } 
    
    public void ubahUser(JTextField kodeuser,JTextField nama,JTextField email, JTextField password, JComboBox level){
        try {
           Statement st = koneksi.getConnection().createStatement();
           st.executeUpdate("UPDATE USER SET NAMA_USER='"+nama.getText()+"',EMAIL='"+email.getText()+"',PASSWORD='"+password.getText()+"',LEVEL='"+level.getSelectedItem().toString()+"' WHERE KODE_USER='"+kodeuser.getText()+"'");
           JOptionPane.showMessageDialog(null, "Berhasil Diubah");
        } catch (SQLException e) {
           JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void autoNumberUser(JTextField kodeuser){
        try {
            ResultSet rs = koneksi.getConnection().createStatement().executeQuery("SELECT * FROM user ORDER BY kode_user DESC");
            if(rs.next()){
                String kode = "" +(Integer.parseInt(rs.getString("kode_user").substring(2))+1);
                String angka = "";
                if(kode.length() == 1){
                    angka = "000";
                }else if(kode.length() == 2 ){
                    angka = "00";
                }else if(kode.length() == 3 ){
                    angka = "0";
                }else if(kode.length() == 4){
                    angka = "";
                }
                kodeuser.setText("KU"+angka+kode);
            }else{
                kodeuser.setText("KU0001");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
}
