package ru.fjrd.receiptAnalyzer;

import ru.fjrd.receiptAnalyzer.db.ConnectionFactory;
import ru.fjrd.receiptAnalyzer.parser.ReceiptJsonParser;
import ru.fjrd.receiptAnalyzer.scanner.ReceiptsFolderScanner;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws IOException, SQLException, InterruptedException {
        ReceiptsFolderScanner receiptsFolderScanner = new ReceiptsFolderScanner();
        receiptsFolderScanner.loadProperties("src/main/resources/configuration.properties");
        //receiptsFolderScanner.createWatchService();
        //ReceiptJsonParser.parseCheck("src/main/java/ru/fjrd/receiptAnalyzer/test.json").toScreen();
        ReceiptJsonParser.parseCheck("/home/fjrd/Dropbox/Receipts/1.json").toScreen();

    }
}
