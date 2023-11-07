package database;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import utils.Colors;

public class DatabaseConnection {

    private static final String url = "jdbc:postgresql://localhost:5432/destino_com";
    private static final String user = "postgres";
    private static final String password = "123";
    public static Connection createConnection() {
        try {
            Class.forName("org.postgresql.Driver");
            System.out.println(Colors.GREEN.get() + "Driver encontrado!" + Colors.RESET.get());

        } catch (ClassNotFoundException e) {
            System.out.printf(Colors.RED.get() + "Driver não encontrado! Mensagem: " + e.getMessage() + Colors.RESET.get());
        }


        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println(Colors.GREEN.get() + "Conectado com sucesso!" + Colors.RESET.get());

            return connection;
        } catch (SQLException e) {
            System.out.printf(Colors.RED.get() + "Não foi possível conectar ao banco! Mensagem: " + e.getMessage() + Colors.RESET.get());
            return null;
        }
    }
}