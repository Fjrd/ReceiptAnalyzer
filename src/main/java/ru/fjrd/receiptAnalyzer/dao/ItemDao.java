package ru.fjrd.receiptAnalyzer.dao;


import ru.fjrd.receiptAnalyzer.ConnectionFactory;
import ru.fjrd.receiptAnalyzer.model.Item;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ItemDao implements Dao<Item>{
    private List<Item> items = new ArrayList<>();

    public ItemDao() {

    }

    @Override
    public Optional<Item> get(long id) {
        return Optional.empty();
    }

    @Override
    public List<Item> getAll() throws IOException, SQLException {
        Statement statement = ConnectionFactory.getInstance().getConnection().createStatement();
        String query = "SELECT * FROM item";
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()){
            items.add(new Item())
            System.out.println(
                    resultSet.getString("name") + ", " +
                            resultSet.getString("sum")
            );
        }
        return items;
    }

    @Override
    public void save(Item item) {

    }

    @Override
    public void update(Item item, String[] params) {

    }

    @Override
    public void delete(Item item) {

    }
}
