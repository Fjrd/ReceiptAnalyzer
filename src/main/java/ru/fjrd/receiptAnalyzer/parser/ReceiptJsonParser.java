package ru.fjrd.receiptAnalyzer.parser;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import ru.fjrd.receiptAnalyzer.model.Receipt;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class ReceiptJsonParser {
    public static Receipt parseCheck (String path) throws FileNotFoundException {
        JsonReader jsonReader = new JsonReader(new FileReader(new File(path)));
        Gson gson = new Gson();
        Receipt receipt = gson.fromJson(jsonReader, Receipt.class);
        return receipt;
    }
}
