package ru.fjrd.receiptAnalyzer.scanner;

import ru.fjrd.receiptAnalyzer.parser.ReceiptJsonParser;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.*;
import java.util.List;
import java.util.Properties;

public class ReceiptsFolderScanner {
    String newReceiptsFolderPath;
    String processedReceiptsFolderPath;

    public void createWatchService() throws IOException, InterruptedException {
        WatchService watchService = FileSystems.getDefault().newWatchService();
        Path path = Paths.get(newReceiptsFolderPath);

        WatchKey watchKey = path.register(watchService, StandardWatchEventKinds.ENTRY_CREATE);
        System.out.println("Monitoring directory for changes...");

        while (true) {

            for (WatchEvent<?> event : watchKey.pollEvents()) {
                System.out.println(event.kind());
                Path file = path.resolve((Path) event.context());
                System.out.println(file.toString());
                ReceiptJsonParser.parseCheck(file.toString()).toScreen();
            }
        }
    }

    public void loadProperties(String path) throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream(path));
        newReceiptsFolderPath = properties.getProperty("from.path");
        processedReceiptsFolderPath = properties.getProperty("to.path");
    }



}
