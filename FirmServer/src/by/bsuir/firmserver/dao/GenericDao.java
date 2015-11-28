package by.bsuir.firmserver.dao;

import java.sql.SQLException;
import java.util.List;

public interface GenericDao <T, PrimaryKey> {
    public T create() throws SQLException; 
    public T persist(T object) throws SQLException;
    public T read(PrimaryKey key) throws SQLException, NullPointerException;
    public void update(T object) throws SQLException; 
    public void delete(T object) throws SQLException;
    public List<T> getAll() throws SQLException;
}
