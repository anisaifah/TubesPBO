/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Asus
 */
public class Database {
        private String dbuser;
        private String dbpassword;
        private java.sql.Statement statement;
        private java.sql.Connection connection;
        private java.sql.ResultSet resultSet;
    
        public void connect(){
            try{
                connection = DriverManager.getConnection("jdbc:mysql://localhost/rentaldvddb","root","");
                statement = connection.createStatement();
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, ""+e.getMessage(),"Connection Error",JOptionPane.WARNING_MESSAGE);
            }
        }
    
    public ResultSet getData(String query){
        try{
            resultSet = statement.executeQuery(query);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error : "+e.getMessage(),"Communication Error", JOptionPane.WARNING_MESSAGE);
        }
        return resultSet;
    }
    
    public void execute(String query){
        try{
            statement.execute(query);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error : "+e.getMessage(),"Communication Error", JOptionPane.WARNING_MESSAGE);
        }
    }
}
