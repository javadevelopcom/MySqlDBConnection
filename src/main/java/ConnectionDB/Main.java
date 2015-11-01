package ConnectionDB;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    private static final String URL = "jdbc:mysql://localhost:3306/";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "2015";

    public static void main(String[] args) throws SQLException {
        Connection connection; // подключаем для манипуляций с БД

        try {
            Driver driver = new FabricMySQLDriver();    // Подключаем драйвер
            DriverManager.registerDriver(driver);       // Подключаем драйвер-менеджер
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            if (!connection.isClosed()) {
                System.out.println("CONNECTION is NOT CLOSED!");

                connection.close();                     // закрываем соединение с БД
                if (connection.isClosed()) {
                    System.out.println("CONNECTION is CLOSED!");
                }
            }
        } catch (SQLException e) {
            System.err.println("Не удалось загрузить драйвер");
        }

    }
}
