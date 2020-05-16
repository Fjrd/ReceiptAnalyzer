package ru.fjrd.receiptAnalyzer.dao;

import ru.fjrd.receiptAnalyzer.db.ConnectionFactory;
import ru.fjrd.receiptAnalyzer.model.Item;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class ItemDaoJdbcImpl implements Dao<Item> {

    Connection connection;

    public ItemDaoJdbcImpl() throws IOException, SQLException {
         connection = ConnectionFactory.getInstance().getConnection();
    }

    @Override
    public Optional<Item> get(int id) {
        return Optional.empty();
    }

    @Override
    public List<Item> getAll() throws IOException, SQLException {
        return new LinkedList<>();
    }

    @Override
    public void save(Item model) {

    }

    @Override
    public void update(Item model, String[] params) {

    }

    @Override
    public void delete(int id) {

    }


}
