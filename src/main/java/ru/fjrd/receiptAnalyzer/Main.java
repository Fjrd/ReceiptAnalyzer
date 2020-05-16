package ru.fjrd.receiptAnalyzer;

import ru.fjrd.receiptAnalyzer.db.ConnectionFactory;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws IOException, SQLException {
        File directory = new File("/home/fjrd/Dropbox/Receipts/");
        for (File file : directory.listFiles()){
            System.out.println(file.getName());
        }
    }
}
