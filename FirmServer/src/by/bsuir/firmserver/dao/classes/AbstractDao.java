package by.bsuir.firmserver.dao.classes;

import by.bsuir.firmserver.dao.GenericDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public abstract class AbstractDao <T, PrimaryKey> implements GenericDao <T, PrimaryKey> {
    
    Connection connection;
    
    public abstract String getSelectQuery();
    public abstract String getDeleteQuery();
    public abstract String getUpdateQuery();
    public abstract String getCreateQuery();
    
    protected abstract void prepareStatementForInsert(PreparedStatement preparedStatement, T object) throws SQLException;
    protected abstract void prepareStatementForUpdate(PreparedStatement preparedStatement, T object) throws SQLException;
    protected abstract void prepareStatementForDelete(PreparedStatement preparedStatement, T object) throws SQLException;
    
    protected abstract List<T> parseResultSet(ResultSet result) throws SQLException;
    
    @Override
    public List<T> getAll() throws SQLException{
        List<T> list;
        String sql = getSelectQuery();
        try (PreparedStatement selectAllStatement = connection.prepareStatement(sql)) {
            ResultSet rs = selectAllStatement.executeQuery();
            list = parseResultSet(rs);
        }
        return list;
    }
    
    @Override
    public T persist(T object) throws SQLException{
        String sqlQuery = getCreateQuery();
        try (PreparedStatement persistStatement = connection.prepareStatement(sqlQuery)) {
            prepareStatementForInsert(persistStatement, object);
            persistStatement.executeUpdate();
            persistStatement.close();
        }
        return object;
    }
    
    @Override
    public void update(T object) throws SQLException{
        String sqlQuery = getUpdateQuery();
        try (PreparedStatement Updatetatement = connection.prepareStatement(sqlQuery)) {
            prepareStatementForUpdate(Updatetatement, object);
            Updatetatement.executeUpdate();
        }
    }
    
    @Override
    public void delete(T object) throws SQLException{
        String sql = getDeleteQuery();
        try (PreparedStatement deleteStatement = connection.prepareStatement(sql)) {
            prepareStatementForDelete(deleteStatement, object);
            deleteStatement.executeUpdate();
            deleteStatement.close();
        }
    }
}
