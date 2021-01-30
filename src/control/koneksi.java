/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package control;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
//import org.json.*;

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
        // TODO code application logic here
    }
//    public static JSONObject ObjectJson = null;
//    public static JSONObject geturl(String search){
//        try {
//            HttpURLConnection con = (HttpURLConnection) new URL("http://www.omdbapi.com/?apikey=4cb6197c&s="+search+"").openConnection();
//            con.setRequestMethod("GET");
//            String input;
//            StringBuffer respon = new StringBuffer();
//            while ((input = new BufferedReader(new InputStreamReader(con.getInputStream())).readLine()) != null ) {            
//                respon.append(input);
//            }
//            ObjectJson = new JSONObject(respon.toString());
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//        return ObjectJson;
//    }
}
