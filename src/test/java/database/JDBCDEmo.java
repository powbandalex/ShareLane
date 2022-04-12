package database;

import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCDEmo {

    public static void main(String[] args) throws SQLException {
        DataBaseUtils dataBaseUtils = new DataBaseUtils();
        dataBaseUtils.connect();
        dataBaseUtils.addUserViaExecute("TMSAQA16.students", "Artem", "2");
        dataBaseUtils.addUser("Alexander", "1");
        ResultSet selectResult = dataBaseUtils.selectFrom("students");
        dataBaseUtils.writeResultSet(selectResult);
        dataBaseUtils.close();
    }
}
