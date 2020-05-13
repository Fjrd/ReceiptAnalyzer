package ru.fjrd.receiptAnalyzer;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;


public class DataBase {
    private static Properties properties;
    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;
    private static String dbUrl;
    private static String dbName;
    private static String dbUser;
    private static String dbPassword;
    private static String dbServerTimezone;

    public static void loadProperties(String path) throws IOException {
        properties = new Properties();
        properties.load(new FileInputStream(path));
        dbUrl = properties.getProperty("db.url");
        dbName = properties.getProperty("db.name");
        dbUser = properties.getProperty("db.user");
        dbPassword = properties.getProperty("db.password");
        dbServerTimezone = properties.getProperty("db.serverTimezone");
    }

    public static void getConnection() throws SQLException {
        connection = DriverManager.getConnection(dbUrl + dbName + "?useTimezone=true&serverTimezone=UTC", dbUser, dbPassword);

    }

    public static void selectAll() throws SQLException {
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

    public static void insert() throws SQLException {
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
