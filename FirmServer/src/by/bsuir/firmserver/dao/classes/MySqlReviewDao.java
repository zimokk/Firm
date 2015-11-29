package by.bsuir.firmserver.dao.classes;

import by.bsuir.firmserver.subjectarea.classes.Review;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySqlReviewDao extends AbstractDao<Review, String>{

    public MySqlReviewDao(Connection connection) {
        this.connection = connection;   
    }

    @Override
    public String getSelectQuery() {
        return "SELECT * FROM review ";
    }

    @Override
    public String getDeleteQuery() {
        return "DELETE FROM review WHERE review.firm_title = ? AND review.name = ? ";
    }

    @Override
    public String getUpdateQuery() {
        return "UPDATE review SET value = ?, standart = ?, reason = ?, suggestion = ? WHERE firm_title = ? AND name = ? ";
    }

    @Override
    public String getCreateQuery() {
        return "INSERT INTO review (firm_title, name, value, standart, reason, suggestion) VALUES (?, ?, ?, ?, ?, ?);";
    }

    @Override
    protected void prepareStatementForInsert(PreparedStatement preparedStatement, Review object) throws SQLException {
        preparedStatement.setString(1, object.getFirm_title());
        preparedStatement.setString(2, object.getName());
        preparedStatement.setDouble(3, object.getValue());
        preparedStatement.setString(4, object.getStandart());
        preparedStatement.setString(5, object.getReason());
        preparedStatement.setString(6, object.getSuggestion());
    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement preparedStatement, Review object) throws SQLException {  
        preparedStatement.setDouble(1, object.getValue());
        preparedStatement.setString(2, object.getStandart());
        preparedStatement.setString(3, object.getReason());
        preparedStatement.setString(4, object.getSuggestion());
        preparedStatement.setString(5, object.getFirm_title());
        preparedStatement.setString(6, object.getName());
    }

    @Override
    protected void prepareStatementForDelete(PreparedStatement preparedStatement, Review object) throws SQLException {
        preparedStatement.setString(1, object.getFirm_title());
        preparedStatement.setString(2, object.getName());
    }

    @Override
    protected List<Review> parseResultSet(ResultSet result) throws SQLException {
        List<Review> list = new ArrayList<>();
        while(result.next()){
            list.add(new Review(result.getString("firm_title"),result.getString("name"),result.getDouble("value"),
                    result.getString("standart"),result.getString("reason"),result.getString("suggestion")));
        }
        return list;
    }

    @Override
    public Review create() throws SQLException {
        Review review = new Review("1","1",1,"1","1","2");
        review = persist(review);
        return review;
    }

    public Review read(String firm_title, String name) throws SQLException, NullPointerException {
        PreparedStatement readFirmStatement = connection.prepareStatement(this.getSelectQuery() + "WHERE firm_title = ? AND name = ?;");
        readFirmStatement.setString(1, firm_title);
        readFirmStatement.setString(2, name);
        ResultSet result = readFirmStatement.executeQuery();
        if(!result.next()){
            System.out.println("No data found");
            return null;
        }
        else{
            Review review = new Review(result.getString("firm_title"),result.getString("name"),result.getDouble("value"),
                    result.getString("standart"),result.getString("reason"),result.getString("suggestion"));
            return review;
        }
    }

    @Override
    public Review read(String firm_title) throws SQLException, NullPointerException {
        PreparedStatement readFirmStatement = connection.prepareStatement(this.getSelectQuery() + "WHERE firm_title = ? ;");
        readFirmStatement.setString(1, firm_title);
        ResultSet result = readFirmStatement.executeQuery();
        if(!result.next()){
            System.out.println("No data found");
            return null;
        }
        else{
            Review review = new Review(result.getString("firm_title"),result.getString("name"),result.getDouble("value"),
                    result.getString("standart"),result.getString("reason"),result.getString("suggestion"));
            return review;
        }
    }
    
}
