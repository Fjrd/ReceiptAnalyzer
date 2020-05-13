package ru.fjrd.receiptAnalyzer.dao;


import ru.fjrd.receiptAnalyzer.model.Item;

import java.util.List;
import java.util.Optional;

public class ItemDao implements Dao<Item>{

    @Override
    public Optional<Item> get(long id) {
        return Optional.empty();
    }

    @Override
    public List<Item> getAll() {
        return null;
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
