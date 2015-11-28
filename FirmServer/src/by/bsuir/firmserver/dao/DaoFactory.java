package by.bsuir.firmserver.dao;

import java.sql.Connection;
import java.sql.SQLException;

public interface DaoFactory {
    public Connection getConnection() throws SQLException;
    public GenericDao getUserDao(Connection connection);
    public GenericDao getFirmDao(Connection connection);
    public GenericDao getReviewDao(Connection connection);
    public GenericDao getPerfomanceDao(Connection connection);
}
