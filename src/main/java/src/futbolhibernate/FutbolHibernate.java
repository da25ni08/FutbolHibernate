/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package src.futbolhibernate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * @author danid
 */
public class FutbolHibernate {


    private static final String DIRECCION_SQL = "jdbc:mysql://localhost:3306/";
    private static final String USUARIO_SQL = "root";
    private static final String PASSWORD_SQL = "";

    public static Connection conectar() throws SQLException {
        return DriverManager.getConnection(DIRECCION_SQL, USUARIO_SQL, PASSWORD_SQL);
    }

    public static void main(String[] args) {
        try (Connection connection = conectar()) {
            Statement stmt = connection.createStatement();
            String sql = "CREATE DATABASE IF NOT EXISTS EstherAlmiraFutbol";
            stmt.executeUpdate(sql);
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
