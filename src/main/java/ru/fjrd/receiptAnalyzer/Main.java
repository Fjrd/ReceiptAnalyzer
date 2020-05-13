package ru.fjrd.receiptAnalyzer;

import java.io.IOException;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws IOException, SQLException {
        DataBase.loadProperties("src/main/resources/db.properties");
        DataBase.getConnection();
        DataBase.selectAll();
        //CheckJsonParser.parseCheck("src/main/java/test.json").toScreen();
    }
}
