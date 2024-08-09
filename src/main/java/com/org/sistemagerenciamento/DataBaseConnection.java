package com.org.sistemagerenciamento;

import java.sql.*;

public class DataBaseConnection {
    private static final String URL = "jdbc:derby://localhost:1527/estoque";
    
    public static Connection connect(){
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL);
            System.out.println("Conexão com o banco de dados estabelecida.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
}