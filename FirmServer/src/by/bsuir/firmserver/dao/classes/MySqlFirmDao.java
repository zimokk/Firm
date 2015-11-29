package by.bsuir.firmserver.dao.classes;

import by.bsuir.firmserver.subjectarea.classes.Firm;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySqlFirmDao extends AbstractDao<Firm,String> {

    public MySqlFirmDao(Connection connection) {
        this.connection = connection;
    }  

    @Override
    public Firm read(String firm_title) throws SQLException, NullPointerException{
        PreparedStatement readFirmStatement = connection.prepareStatement(this.getSelectQuery() + "WHERE firm.title = ? ;");
        readFirmStatement.setString(1, firm_title);
        ResultSet result = readFirmStatement.executeQuery();
        if(!result.next()){
            System.out.println("No data found(read firms)");
            return null;
        }
        else{
            Firm firm = new Firm(result.getString("title"),result.getDate("registration_date"),
                result.getInt("user_id"),result.getString("adress"),result.getString("structure"));
            return firm;
        }
    }
    
    @Override
    public Firm create() throws SQLException {
        Firm firm = new Firm("firm1",null,1,"adress","structure");//TODO FILL params
        return persist(firm);
    }

    @Override
    public String getSelectQuery() {
        return "SELECT * FROM firm ";
    }

    @Override
    public String getDeleteQuery() {
        return "DELETE FROM firm WHERE firm.title = ? ";
    }

    @Override
    public String getUpdateQuery() {
        return "UPDATE firm SET title = ?, registration_date = ? ,user_id = ?, adress = ?, structure = ? WHERE title = ?;";
    }

    @Override
    public String getCreateQuery() {
        return "INSERT INTO firm (title, registration_date, user_id, adress, structure) VALUES (?, ?, ?, ?, ?);";
    }

    @Override
    protected List<Firm> parseResultSet(ResultSet result) throws SQLException {
        List<Firm> list = new ArrayList<>();
        while(result.next()){
            list.add(new Firm(result.getString("title"),result.getDate("registration_date"),
                        result.getInt("user_id"),result.getString("adress"),result.getString("structure")));
        }
        return list;
    }

    @Override
    protected void prepareStatementForInsert(PreparedStatement preparedStatement, Firm object) throws SQLException {
        preparedStatement.setString(1, object.getTitle());
        Date objectDate = new Date(System.currentTimeMillis());
        if(object.getRegistration_date() != null){
            objectDate = new Date(object.getRegistration_date().getTime());
        }
        preparedStatement.setDate(2, objectDate);
        preparedStatement.setInt(3, object.getUser_id());
        preparedStatement.setString(4, object.getAdress());
        preparedStatement.setString(5, object.getStructure());
    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement preparedStatement, Firm object) throws SQLException{
        preparedStatement.setString(1, object.getTitle());
        preparedStatement.setDate(2, new Date(object.getRegistration_date().getTime()));
        preparedStatement.setInt(3, object.getUser_id());
        preparedStatement.setString(4, object.getAdress());
        preparedStatement.setString(5, object.getStructure());
        if(object.getOld_title() != null){
            preparedStatement.setString(6, object.getOld_title());
        }
        else{
            preparedStatement.setString(6, object.getTitle());
        }
    }

    @Override
    protected void prepareStatementForDelete(PreparedStatement preparedStatement, Firm object) throws SQLException {
        preparedStatement.setString(1, object.getTitle());
    }
    
}
