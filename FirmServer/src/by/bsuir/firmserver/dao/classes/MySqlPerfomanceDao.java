package by.bsuir.firmserver.dao.classes;

import by.bsuir.firmserver.subjectarea.classes.Perfomance;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySqlPerfomanceDao extends AbstractDao<Perfomance, String> {

    MySqlPerfomanceDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public String getSelectQuery() {
        return "SELECT * FROM perfomance ";
    }

    @Override
    public String getDeleteQuery() {
        return "DELETE FROM perfomance WHERE firm_title = ? ;";
    }

    @Override
    public String getUpdateQuery() {
        return "UPDATE perfomance SET income = ?, costs = ?, profit = ?,"
                + " fixed_assets = ?, current_assets = ?, owned_assets = ?, long_term_duties = ?,"
                + " short_term_duties = ?, borrowed_capital = ?, equity = ? WHERE firm_title = ? ;";
    }

    @Override
    public String getCreateQuery() {
        return "INSERT INTO perfomance (firm_title, income, costs, profit, fixed_assets, current_assets, owned_assets, long_term_duties, "
                + "short_term_duties, borrowed_capital, equity) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    }

    @Override
    protected void prepareStatementForInsert(PreparedStatement preparedStatement, Perfomance object) throws SQLException {
        preparedStatement.setString(1, object.getFirm_title());
        preparedStatement.setDouble(2, object.getIncome());
        preparedStatement.setDouble(3, object.getCosts());
        preparedStatement.setDouble(4, object.getProfit());
        preparedStatement.setDouble(5, object.getFixed_assets());
        preparedStatement.setDouble(6, object.getCurrent_assets());
        preparedStatement.setDouble(7, object.getOwned_assets());
        preparedStatement.setDouble(8, object.getLong_term_duties());
        preparedStatement.setDouble(9, object.getShort_term_duties());
        preparedStatement.setDouble(10, object.getBorrowed_capital());
        preparedStatement.setDouble(11, object.getEquity());
    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement preparedStatement, Perfomance object) throws SQLException {
        preparedStatement.setDouble(1, object.getIncome());
        preparedStatement.setDouble(2, object.getCosts());
        preparedStatement.setDouble(3, object.getProfit());
        preparedStatement.setDouble(4, object.getFixed_assets());
        preparedStatement.setDouble(5, object.getCurrent_assets());
        preparedStatement.setDouble(6, object.getOwned_assets());
        preparedStatement.setDouble(7, object.getLong_term_duties());
        preparedStatement.setDouble(8, object.getShort_term_duties());
        preparedStatement.setDouble(9, object.getBorrowed_capital());
        preparedStatement.setDouble(10, object.getEquity());
        preparedStatement.setString(11, object.getFirm_title());
    }

    @Override
    protected void prepareStatementForDelete(PreparedStatement preparedStatement, Perfomance object) throws SQLException {
        preparedStatement.setString(1, object.getFirm_title());
    }

    @Override
    protected List<Perfomance> parseResultSet(ResultSet result) throws SQLException {
        List<Perfomance> list = new ArrayList<>();
        while(result.next()){
            list.add(new Perfomance(result.getString("firm_title"), result.getDouble("income"),result.getDouble("costs"),
                                    result.getDouble("profit"),result.getDouble("fixed_assets"),result.getDouble("current_assets"),
                                    result.getDouble("owned_assets"),result.getDouble("long_term_duties"),result.getDouble("short_term_duties"),
                                    result.getDouble("borrowed_capital"),result.getDouble("equity")));
        }
        return list;
    }

    @Override
    public Perfomance create() throws SQLException {
        Perfomance perfomance = new Perfomance("1",1,1,1,1,1,1,1,1,1,1);
        perfomance = persist(perfomance);
        return perfomance;
    }

    @Override
    public Perfomance read(String firm_title) throws SQLException, NullPointerException {
        PreparedStatement readFirmStatement = connection.prepareStatement(this.getSelectQuery() + "WHERE firm_title = ? ;");
        readFirmStatement.setString(1, firm_title);
        ResultSet result = readFirmStatement.executeQuery();
        if(!result.next()){
            System.out.println("No data found");
            return null;
        }
        else{
            Perfomance perfomance = new Perfomance(result.getString("firm_title"), result.getDouble("income"),result.getDouble("costs"),
                                    result.getDouble("profit"),result.getDouble("fixed_assets"),result.getDouble("current_assets"),
                                    result.getDouble("owned_assets"),result.getDouble("long_term_duties"),result.getDouble("short_term_duties"),
                                    result.getDouble("borrowed_capital"),result.getDouble("equity"));
            return perfomance;
        }
    }
    
}
