package by.dudko.slotmachine.swingrealisation.autorization;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;

import by.dudko.slotmachine.entity.Client;
import by.dudko.slotmachine.swingrealisation.MainScreen;
import by.dudko.slotmachine.swingrealisation.balanceincrease.BalanceIncreaseScreen;
import by.dudko.slotmachine.swingrealisation.gamescreens.GameTable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by cplus on 17.09.2017.
 */
public class Login extends JPanel {
    private static final Logger Logger = LogManager.getLogger(Login.class);
    public static Client client;
    public static boolean isLogined = false;
    private JLabel mainLabel = new JLabel("Sign in");
    private JLabel loginLabel = new JLabel("Login:");
    private JLabel passwordLabel = new JLabel("Password:");
    private JTextField login = new JTextField();
    private JPasswordField password = new JPasswordField();
    private JButton singInButton = new JButton("Login");
    private JButton registrationButton = new JButton("Register");

    public Login() {
        setPanelProperties();
        settingBounds();
        addingToPanel();
        addButtonsAction();//нужна зацита от SQL инъекции
    }

    private void setPanelProperties() {
        setLayout(null);
    }

    private void settingBounds() {
        mainLabel.setBounds(375, 75, 50, 25);
        loginLabel.setBounds(200, 115, 50, 25);
        passwordLabel.setBounds(175, 155, 75, 25);
        login.setBounds(250, 115, 300, 25);
        password.setBounds(250, 155, 300, 25);
        singInButton.setBounds(350, 200, 100, 35);
        registrationButton.setBounds(350, 250, 100, 20);
    }

    private void addingToPanel() {
        add(mainLabel);
        add(loginLabel);
        add(passwordLabel);
        add(login);
        add(password);
        add(singInButton);
        add(registrationButton);
    }

    private void addButtonsAction() {//need shift valid in new class
        singInButton.addActionListener(e -> {
            if (!"".equals(login.getText())) {
                try {
                    ResultSet result = MainScreen.statement.executeQuery("SELECT * FROM client WHERE login=\'" + login.getText() + "\' AND password=\'" + password.getText() + "\'");
                    if (result.next()) {
                        client = new Client(result.getInt("idclient"), result.getString("login"), result.getLong("card_number"), result.getDouble("balance"));
                        int answer = JOptionPane.showConfirmDialog(null, "Your balance is: " + client.getBalance() + "\nDo you wanna top your balance?");
                        isLogined = true;
                        if (answer == JOptionPane.YES_OPTION) {
                            MainScreen.mainPanel.add(new BalanceIncreaseScreen(), "BalanceIncreaseScreen");
                            MainScreen.layout.show(MainScreen.mainPanel, "BalanceIncreaseScreen");
                        } else {
                            MainScreen.mainPanel.add(new GameTable(), "GameTable");
                            MainScreen.layout.show(MainScreen.mainPanel, "GameTable");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Incorrect Login or Password!");
                    }
                } catch (SQLException ex) {
                    Logger.error(ex.getMessage());
                }
            } else {
                JOptionPane.showMessageDialog(null, "You must enter the Login and Password!");
            }
        });

        registrationButton.addActionListener(e -> {
            MainScreen.layout.show(MainScreen.mainPanel, "Registration");
        });
    }
}
