package ru.fjrd.receiptAnalyzer;

import java.io.IOException;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws IOException, SQLException {
        ConnectionFactory.getInstance().selectAll();
        //CheckJsonParser.parseCheck("src/main/java/test.json").toScreen();
    }
}
