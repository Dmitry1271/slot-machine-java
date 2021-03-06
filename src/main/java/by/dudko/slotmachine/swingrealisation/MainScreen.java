package by.dudko.slotmachine.swingrealisation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import by.dudko.slotmachine.swingrealisation.action.DBConnector;
import by.dudko.slotmachine.swingrealisation.autorization.Login;
import by.dudko.slotmachine.swingrealisation.autorization.Registration;
import by.dudko.slotmachine.swingrealisation.gamescreens.GameChoice;
import by.dudko.slotmachine.swingrealisation.gamescreens.HelpPanel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by cplus on 17.09.2017.
 */
public class MainScreen extends JFrame {
    public static final String SQL_UPDATE_BALANCE = "UPDATE client SET balance=? WHERE idclient=?;";

    private static final Logger Logger = LogManager.getLogger(MainScreen.class);

    public static PreparedStatement statement;
    public static Connection connection;
    public static boolean isDemoGame;
    public static CardLayout layout = new CardLayout();
    public static JPanel mainPanel = new JPanel();

    public MainScreen() {
        super("Slot Machine");
        setSize(800, 627);
        initConnection();

        mainPanel.setLayout(layout);
        mainPanel.add(new GameChoice(), "GameChoice");
        mainPanel.add(new Login(), "Login");
        mainPanel.add(new Registration(), "Registration");
        mainPanel.add(new HelpPanel(), "HelpPanel");

        add(mainPanel);
        setVisible(true);
        layout.show(mainPanel, "GameChoice");

        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
            }

            @Override
            public void windowClosing(WindowEvent e) {
                if (Login.isLogined) {
                    try {
                        statement = connection.prepareStatement(SQL_UPDATE_BALANCE);
                        statement.setString(1, String.valueOf(Login.user.getBalance()));
                        statement.setString(2, String.valueOf(Login.user.getId()));
                        statement.execute();
                    } catch (SQLException e1) {
                        Logger.error(e1.getMessage());
                    }
                }
            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });
    }

    private void initConnection() {
        try {
            connection = DBConnector.getConnection();
        } catch (SQLException e) {
            Logger.error("DB connection error: " + e);
        }
    }
}
