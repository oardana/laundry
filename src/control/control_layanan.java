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
public class control_layanan {
    
    DefaultTableModel model;
    String [] kolom = {"KODE LAYANAN","JENIS LAYANAN","BIAYA LAYANAN"};
    public control_layanan(){
        model = new DefaultTableModel(null,kolom);
    }
    
    public void simpanLayanan(JTextField kodelayanan,JTextField jenislayanan,JTextField biayalayanan){
      try {
          Statement st = koneksi.getConnection().createStatement();
          st.executeUpdate("INSERT INTO layanan VALUES('"+kodelayanan.getText()+"','"+jenislayanan.getText()+"','"+biayalayanan.getText()+"')");
          JOptionPane.showMessageDialog(null, "Berhasil Ditambahkan");
      } catch (SQLException e) {
          JOptionPane.showMessageDialog(null, e);
      }
    }
    
    public void tampilLayanan(JTable data){
        try {
            ResultSet rs = koneksi.getConnection().createStatement().executeQuery("SELECT * FROM layanan");
            while(rs.next()){
             model.addRow(new Object[]{rs.getString(1),rs.getString(2),rs.getString(3)});   
            }
            data.setModel(model);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void refreshLayanan(JTable data){
        DefaultTableModel table = new DefaultTableModel();
        for (String column : kolom) {
            table.addColumn(column);
        }
        try {
            ResultSet rs = koneksi.getConnection().createStatement().executeQuery("SELECT * FROM layanan");
            while(rs.next()){
               table.addRow(new Object[]{rs.getString(1),rs.getString(2),rs.getString(3)});
            }
            data.setModel(table);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
     
    public void hapusLayanan(String kodelayanan){
        if(JOptionPane.showConfirmDialog(null, "Apakah anda Yakin Ingin di Hapus ","Warning",2) == JOptionPane.YES_OPTION){
             try {
                Statement st = koneksi.getConnection().createStatement();
                st.executeUpdate("DELETE FROM LAYANAN WHERE kode_layanan='"+kodelayanan+"'");
                JOptionPane.showMessageDialog(null, "Berhasil dIhapus");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    } 
    
    public void ubahLayanan(JTextField kodelayanan,JTextField namalayanan,JTextField biayalayanan){
        try {
            Statement st = koneksi.getConnection().createStatement();
            st.executeUpdate("UPDATE LAYANAN SET JENIS_LAYANAN='"+namalayanan.getText()+"',BIAYA='"+biayalayanan.getText()+"' WHERE KODE_LAYANAN='"+kodelayanan.getText()+"'");
            JOptionPane.showMessageDialog(null, "Berhasil Diubah");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void autoNumberLayanan(JTextField kodelayanan){
        try {
           ResultSet rs = koneksi.getConnection().createStatement().executeQuery("SELECT * FROM layanan ORDER BY kode_layanan DESC");
           if(rs.next()){
               String kode = "" + (Integer.parseInt(rs.getString("kode_layanan").substring(2))+1);
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
               kodelayanan.setText("KL"+angka+kode);
           }else{
               kodelayanan.setText("KL0001");
           }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void refreshJcomboLayanan(JComboBox comboBox){
        DefaultComboBoxModel Jcombo = new DefaultComboBoxModel();
        Jcombo.addElement("pilih");
        try {
            ResultSet rs = koneksi.getConnection().createStatement().executeQuery("SELECT jenis_layanan FROM layanan");
            while (rs.next()) {                
                Jcombo.addElement(rs.getString(1));
            }
            comboBox.setModel(Jcombo);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
