package ru.fjrd.receiptAnalyzer.scanner;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReceiptsFolderScanner {
    String newReceiptsFolderPath;
    String oldReceiptsFolderPath;

    public void loadProperties(String path) throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream(path));
        newReceiptsFolderPath = properties.getProperty("new.path");
        oldReceiptsFolderPath = properties.getProperty("old.path");
    }



}
