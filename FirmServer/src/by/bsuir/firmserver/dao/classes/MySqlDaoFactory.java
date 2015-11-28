package by.bsuir.firmserver.dao.classes;

import by.bsuir.firmserver.dao.DaoFactory;
import by.bsuir.firmserver.dao.GenericDao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MySqlDaoFactory implements DaoFactory{

    private final String user = "root";
    private final String password = "";
    private final String url ="jdbc:mysql://localhost:3306/firmdb?zeroDateTimeBehavior=convertToNull";
    private final String driver = "com.mysql.jdbc.Driver";

    public MySqlDaoFactory() {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MySqlDaoFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public Connection getConnection() throws SQLException{
        return DriverManager.getConnection(url, user, password);
    }
    @Override
    public GenericDao getUserDao(Connection connection) {
        return new MySqlUserDao(connection);
    }

    @Override
    public GenericDao getFirmDao(Connection connection) {
        return new MySqlFirmDao(connection);
    }

    @Override
    public MySqlReviewDao getReviewDao(Connection connection) {
        return new MySqlReviewDao(connection);
    }

    @Override
    public GenericDao getPerfomanceDao(Connection connection) {
        return new MySqlPerfomanceDao(connection);
    }
    
}
