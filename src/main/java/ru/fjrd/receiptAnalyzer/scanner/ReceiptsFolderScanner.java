package ru.fjrd.receiptAnalyzer.scanner;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.*;
import java.util.List;
import java.util.Properties;

public class ReceiptsFolderScanner {
    String newReceiptsFolderPath;
    String processedReceiptsFolderPath;

    public void createWatchService() throws IOException, InterruptedException {
        // get path object pointing to the directory we wish to monitor
        Path path = Paths.get(newReceiptsFolderPath);

        // get watch service which will monitor the directory
        WatchService watcher = path.getFileSystem().newWatchService();
        // associate watch service with the directory to listen to the event
        // types

        path.register(watcher, StandardWatchEventKinds.ENTRY_CREATE);
        System.out.println("Monitoring directory for changes...");

        // listen to events
        WatchKey watchKey = watcher.take();

        // get list of events as they occur
        List<WatchEvent<?>> events = watchKey.pollEvents();

        //iterate over events
        for (WatchEvent event : events) {

            //check if the event refers to a new file created
            if (event.kind() == StandardWatchEventKinds.ENTRY_CREATE) {

                //print file name which is newly created
                System.out.println("Created: " + event.context().toString());
            }
        }
    }
    public ReceiptsFolderScanner() throws IOException {
    }

    public void loadProperties(String path) throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream(path));
        newReceiptsFolderPath = properties.getProperty("from.path");
        processedReceiptsFolderPath = properties.getProperty("to.path");
    }



}
