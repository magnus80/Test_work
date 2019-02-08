package rs.dataBase;

import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static java.lang.String.valueOf;

@Slf4j
public class Connector {

    private Connector() {
    }

    private static final String DB_URL = "jdbc:derby://localhost:28080/users";
    /*    private static final String USER = "lms2_db_user";
        private static final String PASS = "";*/
    private static Connection connection;

    public static Connection getConnection() {
        if (connection == null) {
            createConnection();
        }
        return connection;
    }

    private static void createConnection() {
        try {
            connection = DriverManager
                    .getConnection(DB_URL);
        } catch (SQLException e) {
            log.info(valueOf(e.getErrorCode()));
        }
    }
}

