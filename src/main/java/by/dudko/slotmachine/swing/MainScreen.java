package by.dudko.slotmachine.swing;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.sql.Statement;

import by.dudko.slotmachine.swing.autorization.DBConnector;
import by.dudko.slotmachine.swing.autorization.Login;
import by.dudko.slotmachine.swing.autorization.Registration;
import by.dudko.slotmachine.swing.gamescreens.GameChoice;
import by.dudko.slotmachine.swing.gamescreens.GameTable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by cplus on 17.09.2017.
 */
public class MainScreen extends JFrame {
    private static final Logger Logger = LogManager.getLogger(MainScreen.class);
    public static Statement statement;
    public static boolean isDemoGame;
    public static CardLayout layout = new CardLayout();
    public static JPanel mainPanel = new JPanel();

    public MainScreen() {
        super("qwerty tyuiop");
        setSize(800, 627);
        initStatement();

        mainPanel.setLayout(layout);
        mainPanel.add(new GameChoice(), "GameChoice");
        mainPanel.add(new Login(), "Login");
        mainPanel.add(new Registration(), "Registration");

        add(mainPanel);

        setLocationRelativeTo(null);//чтобы понель была по середине
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        layout.show(mainPanel, "GameChoice");
    }

    private void initStatement() {
        try {
            statement = DBConnector.getConnection().createStatement();
        } catch (SQLException e) {
            Logger.error("DB connection error: " + e);
        }
    }
}
