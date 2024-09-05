package com.mycompany.jdbcevidencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Jdbcevidencia {

    public static void main(String[] args) {
        String usuario = "root";
        String password = "";
        String url = "jdbc:mysql://localhost:3306/dbjdbcevidencia";
        Connection conexion;
        Statement statement;
        ResultSet rs;

        try {
            conexion = DriverManager.getConnection(url, usuario, password);
            statement = conexion.createStatement();
            rs = statement.executeQuery("SELECT * FROM `usuarios`");
            while (rs.next()) {
                System.out.println(rs.getString("nombre"));
            }

            //Insercion de datos
            statement.execute("INSERT INTO `usuarios` (`id`, `nombre`) VALUES (NULL, 'Sergio');");
            System.out.println("");
            rs = statement.executeQuery("SELECT * FROM usuarios");
            while (rs.next()) {
                System.out.println(rs.getString("nombre"));
            }

            //Actualizacion de datos
            statement.execute("UPDATE `usuarios` SET `nombre` = 'Fercha' WHERE `usuarios`.`id` = 1;");
            System.out.println("");
            rs = statement.executeQuery("SELECT * FROM usuarios");
            while (rs.next()) {
                System.out.println(rs.getString("nombre"));
            }

            //Borrado eliminar datos
            statement.execute("DELETE FROM usuarios WHERE `usuarios`.`id` = 4");
            System.out.println("");
            rs = statement.executeQuery("SELECT * FROM usuarios");
            while (rs.next()) {
                System.out.println(rs.getString("nombre"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(Jdbcevidencia.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
