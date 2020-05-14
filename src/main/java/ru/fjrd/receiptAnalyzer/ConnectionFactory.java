package ru.fjrd.receiptAnalyzer;

import javax.naming.InitialContext;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class ConnectionFactory {
    private static ConnectionFactory instance;
    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;
    private static String connectionUrl;
    private static String dbName;
    private static String dbUser;
    private static String dbPassword;

    private ConnectionFactory() throws SQLException, IOException {
        loadProperties("src/main/resources/db.properties");
        createConnection();
    }

    public static ConnectionFactory getInstance() throws SQLException, IOException {
        if (instance ==null){
            instance = new ConnectionFactory();
        }
        return instance;
    }

    public void createConnection() throws SQLException {
        connection = DriverManager.getConnection(
                connectionUrl + dbName + "?useTimezone=true&serverTimezone=UTC", dbUser, dbPassword);
    }

    public Connection getConnection() throws SQLException {

        return connection;
    }

    public void loadProperties(String path) throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream(path));
        connectionUrl = properties.getProperty("db.url");
        dbName = properties.getProperty("db.name");
        dbUser = properties.getProperty("db.user");
        dbPassword = properties.getProperty("db.password");
    }

    public void selectAll() throws SQLException {
        statement = connection.createStatement();
        String query = "SELECT * FROM item";
        resultSet = statement.executeQuery(query);
        while (resultSet.next()){
            System.out.println(
                    resultSet.getString("name") + ", " +
                    resultSet.getString("sum")
            );
        }
    }

    public void insert() throws SQLException {
        String sql2 = "INSERT INTO Users (username, password, fullname, email) VALUES (?, ?, ?, ?)";

        PreparedStatement statement = connection.prepareStatement(sql2);
        statement.setString(1, "bill");
        statement.setString(2, "secretpass");
        statement.setString(3, "Bill Gates");
        statement.setString(4, "bill.gates@microsoft.com");

        int rowsInserted = statement.executeUpdate();
        if (rowsInserted > 0) {
            System.out.println("A new user was inserted successfully!");
        }
    }
}
