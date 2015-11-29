package by.bsuir.firmserver.dao.classes;

import by.bsuir.firmserver.subjectarea.classes.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySqlUserDao extends AbstractDao<User, Integer> {

    public MySqlUserDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public String getSelectQuery() {
        return "SELECT * FROM user ORDER BY id ASC";
    }

    @Override
    public String getDeleteQuery() {
        return "DELETE FROM user WHERE user.id = ? ;";
    }

    @Override
    public String getUpdateQuery() {
        return "UPDATE user SET login = ?, password = ? WHERE id = ?;";
    }

    @Override
    public String getCreateQuery() {
        return "INSERT INTO user (login, password) VALUES (?, ?);";
    }

    @Override
    protected void prepareStatementForInsert(PreparedStatement preparedStatement, User object) throws SQLException {
        preparedStatement.setString(1, object.getLogin());
        preparedStatement.setString(2, object.getPassword());
    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement preparedStatement, User object) throws SQLException {
        preparedStatement.setString(1, object.getLogin());
        preparedStatement.setString(2, object.getPassword());
        preparedStatement.setInt(3, object.getId());
    }

    @Override
    protected void prepareStatementForDelete(PreparedStatement preparedStatement, User object) throws SQLException {
        preparedStatement.setInt(1, object.getId());
    }

    @Override
    protected List<User> parseResultSet(ResultSet result) throws SQLException {
        List<User> list = new ArrayList<>();
        while(result.next()){
            list.add(new User(result.getInt("id"),result.getString("login"),result.getString("password")));
        }
        return list;
    }

    @Override
    public User create() throws SQLException {
        User user = new User("user11","pass11");
        user = persist(user);
        updateId(user);
        return user;
    }

    @Override
    public User read(Integer id) throws SQLException, NullPointerException {
        PreparedStatement readUserStatement = connection.prepareStatement("SELECT * FROM user WHERE user.id = ? ;");
        readUserStatement.setInt(1, id);
        ResultSet result = readUserStatement.executeQuery();
        if(!result.next()){
            System.out.println("No data found");
            return null;
        }
        else{
            User user = new User(result.getInt("id"),result.getString("login"),result.getString("password"));
            return user;
        }
    }

    private void updateId(User user) throws SQLException{
        List<User> list = this.getAll();
        user.setId(list.get(list.size()-1).getId());
    }

}
