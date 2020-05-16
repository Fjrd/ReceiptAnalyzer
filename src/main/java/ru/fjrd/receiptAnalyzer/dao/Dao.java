package ru.fjrd.receiptAnalyzer.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface Dao<T> {
    Optional<T> get(int id);

    List<T> getAll() throws IOException, SQLException;

    void save(T model);

    void update(T model, String[] params);

    void delete(int id);
}
