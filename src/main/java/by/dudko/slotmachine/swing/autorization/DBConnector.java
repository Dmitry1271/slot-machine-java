package by.dudko.slotmachine.swing.autorization;

import  by.dudko.slotmachine.run.Constants;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by cplus on 17.09.2017.
 */
public class DBConnector {

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(Constants.TYPE_DB + ':' + Constants.NAME_DB + ':' + Constants.URL_DB, Constants.LOGIN_DB, Constants.PASSWORD_DB);
    }
}
