package by.dudko.slotmachine.swingrealisation.autorization;

import javax.swing.*;

import by.dudko.slotmachine.swingrealisation.MainScreen;
import by.dudko.slotmachine.valid.RegistrationValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;

import static by.dudko.slotmachine.swingrealisation.MainScreen.connection;
import static by.dudko.slotmachine.swingrealisation.MainScreen.statement;

/**
 * Created by cplus on 17.09.2017.
 */
public class Registration extends JPanel {
    public static final String SQL_SELECT_BY_LOGIN = "SELECT idclient FROM client WHERE login=?;";
    public static final String SQL_INSERT_NEW_CLIENT =
            "INSERT INTO client (login, password, email, name, surname, balance, card_number) VALUES (?,?,?,?,?,?,?);";
    public static final double START_CLIENT_BALANCE = 0;

    private static final Logger Logger = LogManager.getLogger(Login.class);

    private JLabel mainLabel = new JLabel("Sign up");
    private JLabel loginLabel = new JLabel("Login*:");
    private JLabel passwordLabel = new JLabel("Password*:");
    private JLabel confirmPasswordLabel = new JLabel("Confirm password*:");
    private JLabel nameLabel = new JLabel("Name:");
    private JLabel surnameLabel = new JLabel("Surname:");
    private JLabel emailLabel = new JLabel("Email*:");
    private JLabel cardNumberLabel = new JLabel("Card number*:");
    private JTextField email = new JTextField();
    private JTextField name = new JTextField();
    private JTextField surname = new JTextField();
    private JTextField login = new JTextField();
    private JPasswordField password = new JPasswordField();
    private JPasswordField confirmPassword = new JPasswordField();
    private JTextField cardNumber = new JTextField();
    private JButton singUpButton = new JButton("Register");
    private JButton backButton = new JButton("Back");
    private RegistrationValidator validator;

    public Registration() {
        setPanelProperties();
        settingBounds();
        addingToPanel();
        addButtonsAction();
    }

    private void setPanelProperties() {
        setLayout(null);
    }

    private void settingBounds() {
        mainLabel.setBounds(375, 75, 50, 20);
        loginLabel.setBounds(200, 115, 50, 25);
        passwordLabel.setBounds(172, 155, 75, 25);
        confirmPasswordLabel.setBounds(125, 195, 120, 25);
        nameLabel.setBounds(203, 235, 50, 25);
        surnameLabel.setBounds(183, 275, 65, 25);
        emailLabel.setBounds(197, 315, 50, 25);
        cardNumberLabel.setBounds(155, 355, 90, 25);

        login.setBounds(250, 115, 300, 25);
        password.setBounds(250, 155, 300, 25);
        confirmPassword.setBounds(250, 195, 300, 25);
        name.setBounds(250, 235, 300, 25);
        surname.setBounds(250, 275, 300, 25);
        email.setBounds(250, 315, 300, 25);
        cardNumber.setBounds(250, 355, 300, 25);
        singUpButton.setBounds(350, 400, 100, 35);
        backButton.setBounds(360, 450, 80, 20);
    }

    private void addingToPanel() {
        add(mainLabel);
        add(loginLabel);
        add(passwordLabel);
        add(confirmPasswordLabel);
        add(nameLabel);
        add(surnameLabel);
        add(emailLabel);
        add(cardNumberLabel);

        add(login);
        add(password);
        add(confirmPassword);
        add(name);
        add(surname);
        add(email);
        add(cardNumber);
        add(singUpButton);
        add(backButton);
    }

    private void addButtonsAction() {//без валидации кредитки и проверки на пустоту
        singUpButton.addActionListener(e -> {
            validator = new RegistrationValidator(login.getText(), password.getText(), confirmPassword.getText(), email.getText(), cardNumber.getText());
            if (validator.isValidData()) {
                try {
                    statement = MainScreen.connection.prepareStatement(SQL_SELECT_BY_LOGIN);
                    statement.setString(1, login.getText());

                    ResultSet result = statement.executeQuery();
                    if (result.next()) {
                        JOptionPane.showMessageDialog(null, "User with the same login exists!");
                    } else {
                        statement = connection.prepareStatement(SQL_INSERT_NEW_CLIENT);
                        statement.setString(1, login.getText());
                        statement.setString(2, password.getText());
                        statement.setString(3, email.getText());
                        statement.setString(4, name.getText());
                        statement.setString(5, surname.getText());
                        statement.setDouble(6, START_CLIENT_BALANCE);
                        statement.setString(7, cardNumber.getText());
                        statement.execute();

                        MainScreen.layout.show(MainScreen.mainPanel, "Login");
                    }
                } catch (SQLException ex) {
                    Logger.error(ex.getMessage());
                }
            } else {
                JOptionPane.showMessageDialog(null, validator.getErrorMessage());
            }
        });


        backButton.addActionListener(e -> {
            MainScreen.layout.previous(MainScreen.mainPanel);
        });
    }
}
