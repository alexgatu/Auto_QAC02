package utils;

import java.sql.*;

public class DatabaseUtils {
    String dbHostname, dbUser, dbPassword, dbSchema, dbPort;

    public void getConnectionDetails() {
        dbHostname = ConfigUtils.readGenericElementFromConfig(ConstantUtils.DEFAULT_CONFIG_FILE,
                "dbHostname");
        dbPassword = ConfigUtils.readGenericElementFromConfig(ConstantUtils.DEFAULT_CONFIG_FILE,
                "dbPassword");
        dbUser = ConfigUtils.readGenericElementFromConfig(ConstantUtils.DEFAULT_CONFIG_FILE,
                "dbUser");
        dbSchema = ConfigUtils.readGenericElementFromConfig(ConstantUtils.DEFAULT_CONFIG_FILE,
                "dbSchema");
        dbPort = ConfigUtils.readGenericElementFromConfig(ConstantUtils.DEFAULT_CONFIG_FILE, "dbPort");
    }

    public Connection connect() throws SQLException {
        getConnectionDetails();
        return DriverManager.getConnection("jdbc:mysql://" + dbHostname + ":" + dbPort + "/" +
                dbSchema, dbUser, dbPassword);
    }


    public Statement getStatement(Connection connection) throws SQLException {
        return connection.createStatement();
    }

    public String getElementFromDB(ResultSet resultSet, String column) throws SQLException {
        if (resultSet.getString(column) != null) {
            return resultSet.getString(column);
        } else {
            return "";
        }
    }

}
