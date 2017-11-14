package by.dudko.slotmachine.swingrealisation.balanceincrease;

import by.dudko.slotmachine.swingrealisation.MainScreen;
import by.dudko.slotmachine.swingrealisation.action.DoubleRounding;
import by.dudko.slotmachine.swingrealisation.action.LabelReader;
import by.dudko.slotmachine.swingrealisation.autorization.Login;

import javax.swing.*;
import java.awt.*;

import by.dudko.slotmachine.swingrealisation.gamescreens.GameTable;
import by.dudko.slotmachine.valid.BalanceIncreaseScreenValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by cplus on 03.10.2017.
 */
public class BalanceIncreaseScreen extends JPanel {
    private static final Logger Logger = LogManager.getLogger(BalanceIncreaseScreen.class);
    private JLabel panelName = new JLabel("Top up the balance");
    private JLabel balanceName = new JLabel("Your balance is: ");
    private JLabel balanceValue = new JLabel("" + DoubleRounding.round(Login.user.getBalance()));
    private JLabel balanceInputName = new JLabel("Enter the top up balance:");
    private JTextField balanceInput = new JTextField();
    private JButton topUpButton = new JButton("Top up");
    private JButton goGameButton = new JButton("Go to game");

    public BalanceIncreaseScreen() {
        setProperties();
        settingBounds();
        addingToPanel();
        addButtonsAction();
    }

    private void setBalanceValue(Double value) {
        balanceValue.setText("" + DoubleRounding.round(value));
    }

    private void setProperties() {
        setLayout(null);
        panelName.setFont(new Font("Verdana", Font.PLAIN, 40));
        balanceName.setFont(new Font("Verdana", Font.PLAIN, 20));
        balanceValue.setFont(new Font("Verdana", Font.PLAIN, 20));
        balanceInputName.setFont(new Font("Verdana", Font.PLAIN, 13));
        balanceInput.setFont(new Font("Verdana", Font.PLAIN, 13));
    }

    private void settingBounds() {
        panelName.setBounds(210, 20, 440, 60);
        balanceName.setBounds(295, 100, 250, 30);
        balanceValue.setBounds(470, 100, 100, 30);
        balanceInputName.setBounds(170, 200, 200, 20);
        balanceInput.setBounds(370, 200, 140, 30);
        topUpButton.setBounds(300, 270, 120, 40);
        goGameButton.setBounds(300, 335, 120, 40);
    }

    private void addingToPanel() {
        add(panelName);
        add(balanceName);
        add(balanceValue);
        add(balanceInputName);
        add(balanceInput);
        add(topUpButton);
        add(goGameButton);
    }

    private void addButtonsAction() {
        topUpButton.addActionListener(e -> {
            if (!"".equals(balanceInput.getText())) {
                if (BalanceIncreaseScreenValidator.isValidBalance(balanceInput.getText())) {
                    Login.user.setBalance(Login.user.getBalance() + LabelReader.getValue(balanceInput));
                    setBalanceValue((LabelReader.getValue(balanceValue) + LabelReader.getValue(balanceInput)));
                    JOptionPane.showMessageDialog(null, "Success!\nYour balance was toped up on: " + balanceInput.getText());
                } else {
                    JOptionPane.showMessageDialog(null, "The input data incorrect!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Enter the balanceValue you wanna top up!");
            }
        });

        goGameButton.addActionListener(e -> {
            MainScreen.mainPanel.add(new GameTable(), "GameTable");
            MainScreen.layout.show(MainScreen.mainPanel, "GameTable");
        });
    }
}
