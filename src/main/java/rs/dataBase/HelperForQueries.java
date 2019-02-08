package rs.dataBase;

import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

@Slf4j
public class HelperForQueries {

    private HelperForQueries() {
    }

    static final String PROBLEM_WITH_EXECUTING_SELECT = "Problems with executing SELECT";
    private static Connection connToDB;

    public static String executeSelectGetOneValue(String query) {
        try {
            connToDB = Connector.getConnection();
            ResultSet rs;
            try (Statement statement = connToDB.createStatement()) {
                rs = statement.executeQuery(query);
                rs.next();
                return rs.getString(1);//возвращается первый столбец
            }
        } catch (SQLException e) {
            Logger.getLogger("DataBaseLogger").info(PROBLEM_WITH_EXECUTING_SELECT);
        }
        return "";
    }

    public static void executeUpdate(String query) throws SQLException {
        try {
            connToDB = Connector.getConnection();
            try (Statement statement = connToDB.createStatement()) {
                statement.execute(query);
            }
        } catch (SQLException e) {
            log.info(e.getSQLState());
        }
    }

    public static void executeDelete(String query) throws SQLException {
        try {
            connToDB = Connector.getConnection();
            try (Statement statement = connToDB.createStatement()) {
                statement.execute(query);
            }
        } catch (SQLException e) {
            log.info(e.getSQLState());
            connToDB.close();
        }
    }
}
