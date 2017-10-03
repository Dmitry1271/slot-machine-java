package by.dudko.slotmachine.swingrealisation.gamescreens;

import by.dudko.slotmachine.machinerealisation.riskbonus.RiskGenerator;
import by.dudko.slotmachine.swingrealisation.MainScreen;
import by.dudko.slotmachine.swingrealisation.action.DoubleRounding;
import by.dudko.slotmachine.swingrealisation.action.LabelReader;
import by.dudko.slotmachine.swingrealisation.autorization.Login;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by cplus on 01.10.2017.
 */
public class RiskPanel extends JPanel {
    private JLabel panelName = new JLabel("Try to guess the card!");
    private JLabel winningNow = new JLabel("Now you have:");
    private JLabel winningNext = new JLabel("Next you'll have:");
    private JLabel wonValueNow = new JLabel("" + GameTable.wonMoney);
    private JLabel wonValueNext = new JLabel("" + LabelReader.getValue(wonValueNow) * 2);
    private JPanel firstWon = new JPanel();
    private JPanel secondWon = new JPanel();
    private JPanel thirdWon = new JPanel();
    private JPanel fourthWon = new JPanel();
    private JPanel fifthWon = new JPanel();
    private JButton redButton = new JButton();
    private JButton blackButton = new JButton();
    private ArrayList<JPanel> wonPanels = new ArrayList<>();
    private int valueForSelection;
    private int wonNumber;
    private double winningForFirstRisk = GameTable.wonMoney;

    public RiskPanel() {
        setWonPanels();
        setProperties();
        settingBounds();
        addingToPanel();
        addButtonsAction();
    }

    private void setProperties() {
        setLayout(null);
        setValueForSelection(RiskGenerator.generate());
        panelName.setFont(new Font("Verdana", Font.PLAIN, 30));
        winningNow.setFont(new Font("Verdana", Font.PLAIN, 17));
        winningNext.setFont(new Font("Verdana", Font.PLAIN, 17));
        wonValueNow.setFont(new Font("Verdana", Font.PLAIN, 17));
        wonValueNext.setFont(new Font("Verdana", Font.PLAIN, 17));
        firstWon.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        secondWon.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        thirdWon.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        fourthWon.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        fifthWon.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        redButton.setBackground(Color.red);
        blackButton.setBackground(Color.black);
    }

    private void setWonPanels() {
        wonPanels.add(firstWon);
        wonPanels.add(secondWon);
        wonPanels.add(thirdWon);
        wonPanels.add(fourthWon);
        wonPanels.add(fifthWon);
    }

    private void setWonValueNow(double value) {
        wonValueNow.setText("" + value);
    }

    private void setWonValueNext(double value) {
        wonValueNext.setText("" + value);
    }

    private void setWonPanelsColor(Color color) {
        for (JPanel panel : wonPanels) {
            panel.setBackground(color);
        }
    }

    private void settingBounds() {
        panelName.setBounds(220, 20, 400, 60);
        winningNow.setBounds(110, 90, 130, 30);
        winningNext.setBounds(480, 90, 170, 30);
        wonValueNow.setBounds(255, 90, 90, 30);
        wonValueNext.setBounds(645, 90, 90, 30);
        firstWon.setBounds(170, 150, 50, 50);
        secondWon.setBounds(270, 150, 50, 50);
        thirdWon.setBounds(370, 150, 50, 50);
        fourthWon.setBounds(470, 150, 50, 50);
        fifthWon.setBounds(570, 150, 50, 50);
        redButton.setBounds(200, 250, 180, 300);
        blackButton.setBounds(420, 250, 180, 300);
    }

    private void setValueForSelection(int value) {
        valueForSelection = value;
    }

    private void addingToPanel() {
        add(panelName);
        add(winningNow);
        add(winningNext);
        add(wonValueNow);
        add(wonValueNext);
        add(firstWon);
        add(secondWon);
        add(thirdWon);
        add(fourthWon);
        add(fifthWon);
        add(redButton);
        add(blackButton);
    }

    private void redBlackButtonsFunction(int value){
        if (valueForSelection == value) {
            wonPanels.get(wonNumber++).setBackground(Color.green);
            setWonValueNow(LabelReader.getValue(wonValueNext));
            setWonValueNext(LabelReader.getValue(wonValueNext) * 2);
            int result = JOptionPane.showConfirmDialog(null, "Do you want to continue?");
            if (result != JOptionPane.YES_OPTION || wonNumber == 5) {
                JOptionPane.showMessageDialog(null, "You won: " + LabelReader.getValue(wonValueNow));
                GameTable.wonMoney = LabelReader.getValue(wonValueNow);
                setWonPanelsColor(null);
                GameTable.balanceValue += DoubleRounding.round(LabelReader.getValue(wonValueNow) - winningForFirstRisk);
                Login.client.setBalance(GameTable.balanceValue);
                MainScreen.layout.show(MainScreen.mainPanel, "GameTable");
            }
        } else {
            JOptionPane.showMessageDialog(null, "You lost:" + winningForFirstRisk + "!");
            GameTable.balanceValue -= DoubleRounding.round(winningForFirstRisk);
            Login.client.setBalance(GameTable.balanceValue);
            MainScreen.layout.show(MainScreen.mainPanel, "GameTable");
        }
        setValueForSelection(RiskGenerator.generate());
    }

    private void addButtonsAction() {
        redButton.addActionListener(e -> {
            redBlackButtonsFunction(1);
        });
        blackButton.addActionListener(e -> {
            redBlackButtonsFunction(0);
        });
    }
}
