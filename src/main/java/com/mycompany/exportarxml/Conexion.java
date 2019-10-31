/*
 * Clase que permite la conexión con la base de datos MS SQL SERVER
 */
package com.mycompany.exportarxml;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Objeto para establecer la conexión a la base de datos
 */
public class Conexion {
    
    // Variables para la conexion a la base de datos de SQL Server
    private static String host = "jdbc:sqlserver://;database=TimbradoNominaAYA;integratedSecurity=true;";
    private static String username = "sa";
    private static String password = "Compac2013";
    private static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static Connection conexion;
    
    public Conexion() {
        
        try {
            // Se carga el driver de SQL Server
            Class.forName(driver);
            // Se establece la conexión a la base de datos
            conexion = DriverManager.getConnection(host, username, password);
            System.out.println("Conexión realizada con éxito");
        }
        catch(SQLException e) {
            e.printStackTrace();
            System.out.println("Conexión fallida");
        }
        catch (ClassNotFoundException ex) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Erro en el driver");
        }
    }

    public Connection getConexion() {
        // Se devuelve el objeto Connection
        return conexion;
    }
}