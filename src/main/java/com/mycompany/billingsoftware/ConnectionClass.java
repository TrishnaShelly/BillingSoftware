/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.billingsoftware;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author O7 Services
 */
public class ConnectionClass {

    private static ConnectionClass single_instance = null;
    Connection connection;

    private ConnectionClass() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/shopdata", "root", "");
            if (connection != null) {
                System.out.println("connected");
                
                String query1 = "CREATE TABLE IF NOT EXISTS addEmployee ( ID INT NOT NULL AUTO_INCREMENT , "
                        + "name VARCHAR(255) NOT NULL , "
                        + "aadharNumber VARCHAR(255) NOT NULL ,"
                        + "joiningDate VARCHAR(255) NOT NULL , "
                        + "Age INT NOT NULL,"
                        + "Address VARCHAR(255) NOT NULL , "
                        + "contact VARCHAR(255 ) NOT NULL , "
                        + "email VARCHAR(255), "
                        + "password VARCHAR(255), "
                        + "PRIMARY KEY(ID))";
                        PreparedStatement ps=connection.prepareStatement(query1);
                        ps.execute();
                        System.out.println("Table created successfully");

            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionClass.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static ConnectionClass getInstance() {
        if (single_instance == null) {
            single_instance = new ConnectionClass();
        }
        return single_instance;
    }
}
