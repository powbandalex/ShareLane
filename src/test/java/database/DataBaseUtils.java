package database;

import utilities.PropertiesManager;

import java.sql.*;

public class DataBaseUtils {

    Connection connect;
    Statement statement;

    public void connect() {
        PropertiesManager propertiesManager = new PropertiesManager();
        String databaseUrl = propertiesManager.get("MYSQL_URL");
        try {
            connect = DriverManager
                    .getConnection(databaseUrl);
            // Statements allow to issue SQL queries to the database
            statement = connect.createStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public ResultSet selectFrom(String tableName) {
        try {
            return statement
                    .executeQuery(String.format("SELECT * FROM %s;", tableName));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public void addUserViaExecute(String tableName, String studentName, String groupId) {
        try {
            statement
                    .execute(String.format("INSERT INTO %s (name, group_id) VALUES ('%s', '%s')", tableName, studentName, groupId));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void addUser(String name, String groupId) throws SQLException {
        PreparedStatement preparedStatement = connect
                .prepareStatement("INSERT INTO  TMSAQA16.students values (default, ?, ?)");
        preparedStatement.setString(1, name);
        preparedStatement.setString(2, groupId);
        preparedStatement.executeUpdate();
    }

    public void writeResultSet(ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            String id = resultSet.getString("id");
            String name = resultSet.getString("name");
            String groupId = resultSet.getString("group_id");
            System.out.println("ID: " + id);
            System.out.println("NAME: " + name);
            System.out.println("GROUP ID: " + groupId);
        }
    }

    public void close() {
        try {

            if (statement != null) {
                statement.close();
            }

            if (connect != null) {
                connect.close();
            }
        } catch (Exception ignored) {
        }
    }
}
