/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author ACER
 */
public class koneksi {

    /**
     * @param args the command line arguments
     */
    public static Connection koneksi = null;
    public static Connection getConnection(){
        try {
            koneksi = (Connection)DriverManager.getConnection("jdbc:mysql://localhost/laundry","root","");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,e);
        }
        return koneksi;
    }
    
    public static void main(String[] args) {
        new koneksi().getConnection();
    }
}
