package ru.fjrd.receiptAnalyzer.parser;

import com.google.gson.Gson;
import ru.fjrd.receiptAnalyzer.model.Receipt;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReceiptJsonParser {
    public static Receipt parseCheck (String path) throws IOException {
        String jsonFile = prepareJson(path);
        Gson gson = new Gson();
        Receipt receipt = gson.fromJson(jsonFile, Receipt.class);
        return receipt;
    }
    public static String prepareJson(String path) throws IOException {
        String content = Files.readString(Paths.get(path));
        if ((content.charAt(0) == '[') &&
            (content.charAt(content.length()-2) == ']')){
                content = content.substring(1, content.length()-1);
        }
        content = content.substring(0, content.length()-1);
        return content;
    }
}
