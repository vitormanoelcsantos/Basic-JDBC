package com.one.innovation.digital.jdbcbasic.connectionjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionJDBC {
    public static void main(String[] args) throws SQLException {
        String driver = "mysql";
        String dataBaseAddress = "localhost";
        String dataBaseName = "digital_innovation_one";
        String user = "root";
        String password = "password";

        StringBuilder sb = new StringBuilder("jdbc:")
                .append(driver).append("://")
                .append(dataBaseAddress).append("/")
                .append(dataBaseName);

        String connectionUrl = sb.toString(); //sb.toString() == "jdbc:mysql://localhost/digital_innovation_one"

        // Criar conexão usando o DriverManager, passando como parâmetros a string de conexão,
        // usuário e senha do usuário.
        try (Connection conn = DriverManager.getConnection(connectionUrl, user, password)) {
            System.out.println("Sucesso ao se conectar ao banco MySQL!");
        } catch (SQLException e) {
            System.out.println("Falha ao se conectar ao banco MySQL!");
            e.printStackTrace();
        }

//        System.out.println("----> "+DriverManager.getDriver(String.valueOf(sb)));
    }
}
