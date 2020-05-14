package ru.fjrd.receiptAnalyzer.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface Dao<T> {
    Optional<T> get(long id);

    List<T> getAll() throws IOException, SQLException;

    void save(T t);

    void update(T t, String[] params);

    void delete(T t);
}
