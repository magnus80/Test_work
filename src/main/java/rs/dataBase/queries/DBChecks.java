package rs.dataBase.queries;

import lombok.extern.slf4j.Slf4j;

import static rs.dataBase.HelperForQueries.executeSelectGetOneValue;

@Slf4j
public class DBChecks {

    private DBChecks() {
    }

    public static String getCreatedId() {
        String query = "select id from users\n" +
                "order by 1 desc\n" +
                "limit 1;";
        log.info("\n...getting last id...\n");
        return executeSelectGetOneValue(query);
    }


}
