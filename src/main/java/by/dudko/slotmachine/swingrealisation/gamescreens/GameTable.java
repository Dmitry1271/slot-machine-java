package by.dudko.slotmachine.swingrealisation.gamescreens;

import static by.dudko.slotmachine.constants.GameTableConstants.*;

import by.dudko.slotmachine.entity.SlotRings;
import by.dudko.slotmachine.constants.Constants;
import by.dudko.slotmachine.machinerealisation.result.CalculationMoneyForElements;
import by.dudko.slotmachine.machinerealisation.result.CheckLines;
import by.dudko.slotmachine.swingrealisation.MainScreen;
import by.dudko.slotmachine.swingrealisation.action.DoubleRounding;
import by.dudko.slotmachine.swingrealisation.action.LinesFromCheckBoxes;
import by.dudko.slotmachine.swingrealisation.action.LabelReader;
import by.dudko.slotmachine.swingrealisation.action.ChangeValue;
import by.dudko.slotmachine.swingrealisation.autorization.Login;
import by.dudko.slotmachine.swingrealisation.balanceincrease.BalanceIncreaseScreen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import static javax.swing.JOptionPane.*;

/**
 * Created by cplus on 29.09.2017.
 */
public class GameTable extends JPanel {
    static double wonMoney = 0;
    static double balanceValue;
    //The first ring
    private JPanel firstSlot = new JPanel();
    private JLabel firstZero = new JLabel(Constants.SLOT_RINGS[0][0]);
    private JLabel firstOne = new JLabel(Constants.SLOT_RINGS[0][1]);
    private JLabel firstTwo = new JLabel(Constants.SLOT_RINGS[0][2]);
    //The second ring
    private JPanel secondSlot = new JPanel();
    private JLabel secondZero = new JLabel(Constants.SLOT_RINGS[1][0]);
    private JLabel secondOne = new JLabel(Constants.SLOT_RINGS[1][1]);
    private JLabel secondTwo = new JLabel(Constants.SLOT_RINGS[1][2]);
    //The third ring
    private JPanel thirdSlot = new JPanel();
    private JLabel thirdZero = new JLabel(Constants.SLOT_RINGS[2][0]);
    private JLabel thirdOne = new JLabel(Constants.SLOT_RINGS[2][1]);
    private JLabel thirdTwo = new JLabel(Constants.SLOT_RINGS[2][2]);
    //Buttons
    private JButton playButton = new JButton(PLAY_BUTTON_TEXT);
    private JButton riskButton = new JButton(RISK_BUTTON_TEXT);
    private JButton helpButton = new JButton(HELP_BUTTON_TEXT);
    private JButton plusButton = new JButton(PLUS_BUTTON_TEXT);
    private JButton minusButton = new JButton(MINUS_BUTTON_TEXT);
    //Panels with names
    private JPanel balancePanel = new JPanel();
    private JPanel betPanel = new JPanel();
    private JPanel betForLinePanel = new JPanel();
    //Information for player
    private JLabel balanceName = new JLabel(BALANCE_TEXT);
    private JLabel betName = new JLabel(BET_TEXT);
    private JLabel betForLineName = new JLabel(BET_FOR_LINE_TEXT);
    private JLabel balance = new JLabel();
    private JLabel bet = new JLabel(BET_VALUE);
    private JLabel betForLine = new JLabel(BET_FOR_LINE_VALUE);
    //Lines checkBoxes
    private JCheckBox line1Box = new JCheckBox();
    private JCheckBox line2Box = new JCheckBox();
    private JCheckBox line3Box = new JCheckBox();
    private JCheckBox line4Box = new JCheckBox();
    private JCheckBox line5Box = new JCheckBox();
    private ArrayList<JCheckBox> listBoxes = new ArrayList<>();
    private int numberSelectedLines = 0;
    //GameDoings
    private SlotRings slotRings;
    private boolean isWon = false;


    public GameTable() {
        setBalance();
        slotRings = new SlotRings(Constants.SLOT_RINGS);
        listBoxes.add(line1Box);
        listBoxes.add(line2Box);
        listBoxes.add(line3Box);
        listBoxes.add(line4Box);
        listBoxes.add(line5Box);
        setProperties();
        settingBounds();
        addingToPanel();
        addButtonsAction();
        addCheckBoxesAction();
        balanceValue = DoubleRounding.round(LabelReader.getValue(balance));
    }

    private void setRingsValues(String[][] rings) {
        //The first ring
        firstZero.setText(rings[0][0]);
        firstOne.setText(rings[0][1]);
        firstTwo.setText(rings[0][2]);
        //The second ring
        secondZero.setText(rings[1][0]);
        secondOne.setText(rings[1][1]);
        secondTwo.setText(rings[1][2]);
        //The third ring
        thirdZero.setText(rings[2][0]);
        thirdOne.setText(rings[2][1]);
        thirdTwo.setText(rings[2][2]);
    }

    private void setBalance() {
        if (MainScreen.isDemoGame) {
            this.balance.setText(String.valueOf(Constants.DEMO_BALANCE));
        } else {
            this.balance.setText(String.valueOf(Login.user.getBalance()));
        }
    }

    private void setBalance(double balance) {
        this.balance.setText(String.valueOf(balance));
    }

    private void setProperties() {
        setLayout(null);
        //The first ring
        firstSlot.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        firstZero.setFont(new Font("Verdana", Font.PLAIN, 55));
        firstOne.setFont(new Font("Verdana", Font.PLAIN, 55));
        firstTwo.setFont(new Font("Verdana", Font.PLAIN, 55));
        //The second ring
        secondSlot.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        secondZero.setFont(new Font("Verdana", Font.PLAIN, 55));
        secondOne.setFont(new Font("Verdana", Font.PLAIN, 55));
        secondTwo.setFont(new Font("Verdana", Font.PLAIN, 55));
        //The third ring
        thirdSlot.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        thirdZero.setFont(new Font("Verdana", Font.PLAIN, 55));
        thirdOne.setFont(new Font("Verdana", Font.PLAIN, 55));
        thirdTwo.setFont(new Font("Verdana", Font.PLAIN, 55));

        playButton.setFont(new Font("Verdana", Font.PLAIN, 20));
        riskButton.setFont(new Font("Verdana", Font.PLAIN, 20));
        helpButton.setFont(new Font("Verdana", Font.PLAIN, 20));
        plusButton.setFont(new Font("Verdana", Font.BOLD, 20));
        plusButton.setMargin(new Insets(0, 0, 0, 0));
        minusButton.setFont(new Font("Verdana", Font.BOLD, 25));
        minusButton.setMargin(new Insets(0, 0, 0, 0));

        bet.setFont(new Font("Verdana", Font.PLAIN, 20));
        betForLine.setFont(new Font("Verdana", Font.PLAIN, 20));
        balance.setFont(new Font("Verdana", Font.PLAIN, 20));
        betPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        balancePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        betForLinePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
    }

    private void settingBounds() {
        firstSlot.setBounds(255, 100, 70, 230);
        secondSlot.setBounds(365, 100, 70, 230);
        thirdSlot.setBounds(475, 100, 70, 230);

        line4Box.setBounds(210, 58, 20, 20);
        line1Box.setBounds(210, 130, 20, 20);
        line2Box.setBounds(210, 205, 20, 20);
        line3Box.setBounds(210, 280, 20, 20);
        line5Box.setBounds(210, 350, 20, 20);

        playButton.setBounds(661, 510, 100, 40);
        riskButton.setBounds(556, 510, 80, 40);
        helpButton.setBounds(451, 510, 80, 40);
        plusButton.setBounds(284, 510, 35, 40);
        minusButton.setBounds(163, 510, 35, 40);

        betPanel.setBounds(346, 510, 80, 40);
        betForLinePanel.setBounds(195, 510, 90, 40);
        balancePanel.setBounds(35, 510, 100, 40);

        betName.setBounds(374, 483, 40, 30);
        betForLineName.setBounds(210, 483, 120, 30);
        balanceName.setBounds(60, 483, 80, 30);
    }

    private void addingToPanel() {
        firstSlot.add(firstZero);
        firstSlot.add(firstOne);
        firstSlot.add(firstTwo);
        secondSlot.add(secondZero);
        secondSlot.add(secondOne);
        secondSlot.add(secondTwo);
        thirdSlot.add(thirdZero);
        thirdSlot.add(thirdOne);
        thirdSlot.add(thirdTwo);

        betPanel.add(bet);
        betForLinePanel.add(betForLine);
        balancePanel.add(balance);

        add(firstSlot);
        add(secondSlot);
        add(thirdSlot);
        add(betPanel);
        add(betForLinePanel);
        add(balancePanel);

        add(balanceName);
        add(betName);
        add(betForLineName);

        add(playButton);
        add(riskButton);
        add(helpButton);
        add(plusButton);
        add(minusButton);

        add(line1Box);
        add(line2Box);
        add(line3Box);
        add(line4Box);
        add(line5Box);
    }

    private void addButtonsAction() {
        plusButton.addActionListener(e -> {
            double value = ChangeValue.changePlus(LabelReader.getValue(betForLine));
            betForLine.setText(String.valueOf(DoubleRounding.round(value)));
            bet.setText(String.valueOf(DoubleRounding.round(value * numberSelectedLines)));
        });

        minusButton.addActionListener(e -> {
            double value = ChangeValue.changeMinus(LabelReader.getValue(betForLine));
            betForLine.setText(String.valueOf(DoubleRounding.round(value)));
            bet.setText(String.valueOf(DoubleRounding.round(value * numberSelectedLines)));
        });

        playButton.addActionListener((ActionEvent e) -> {
            double balance = LabelReader.getValue(this.balance);
            double betAllValue1 = LabelReader.getValue(bet);

            if (numberSelectedLines > 0) {
                if (betAllValue1 <= balance) {
                    slotRings.generate();
                    setRingsValues(slotRings.getVisiblePartRings());

                    wonMoney = new CalculationMoneyForElements(Double.parseDouble(betForLine.getText())).calculate(
                            new CheckLines(LinesFromCheckBoxes.getSelectedLines(listBoxes)).getWonElements(slotRings));

                    isWon = wonMoney > 0;
                    if (isWon) {
                        showMessageDialog(null, MESSAGE_DIALOG_TEXT_AFTER_WON_1 + wonMoney + MESSAGE_DIALOG_TEXT_AFTER_WON_2);
                    }

                    balanceValue = DoubleRounding.round(
                            Double.parseDouble(this.balance.getText()) -
                                    Double.parseDouble(bet.getText()) +
                                    wonMoney);

                    if (!MainScreen.isDemoGame) {
                        Login.user.setBalance(balanceValue);
                    }

                } else {
                    if (!MainScreen.isDemoGame) {
                        int answer = showConfirmDialog(null, CONFIRM_DIALOG_AFTER_LOST_MONEY_NORMAL_GAME);
                        if (answer == JOptionPane.YES_OPTION) {
                            MainScreen.mainPanel.add(new BalanceIncreaseScreen(), "BalanceIncreaseScreen");
                            MainScreen.layout.show(MainScreen.mainPanel, "BalanceIncreaseScreen");
                        }
                    } else {
                        showMessageDialog(null, MESSAGE_DIALOG_AFTER_LOST_MONEY_DEMO_GAME);
                    }
                }
            } else {
                showMessageDialog(null, MESSAGE_DIALOG_LINE_SELECTION_HELP);
            }
        });

        riskButton.addActionListener(e -> {
            if (isWon) {
                MainScreen.mainPanel.add(new RiskPanel(), "RiskPanel");//выполняется каждый раз после нажатия
                MainScreen.layout.show(MainScreen.mainPanel, "RiskPanel");
                isWon = false;
            } else {
                MainScreen.mainPanel.add(new RiskPanel(), "RiskPanel");
                showMessageDialog(null, MESSAGE_DIALOG_RISK_HELP);
            }
        });

        helpButton.addActionListener(e -> {
            MainScreen.layout.show(MainScreen.mainPanel, "HelpPanel");
        });
    }

    private void addCheckBoxesAction() {
        for (JCheckBox box : listBoxes) {
            box.addActionListener(e -> {
                double bet1 = Double.parseDouble(betForLine.getText());
                if (box.isSelected()) {
                    numberSelectedLines++;
                    bet.setText(String.valueOf(DoubleRounding.round(bet1 * numberSelectedLines)));
                } else {
                    numberSelectedLines--;
                    bet.setText(String.valueOf(DoubleRounding.round(bet1 * numberSelectedLines)));
                }
            });
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        balance.setText(String.valueOf(balanceValue));
        balancePanel.add(balance);

        if (line1Box.isSelected()) {
            g.setColor(FIRST_LINE_COLOR);
            g.drawLine(227, 140, 255, 140);
            g.drawLine(325, 140, 365, 140);
            g.drawLine(435, 140, 475, 140);
        }
        if (line2Box.isSelected()) {
            g.setColor(SECOND_LINE_COLOR);
            g.drawLine(227, 215, 255, 215);
            g.drawLine(325, 215, 365, 215);
            g.drawLine(435, 215, 475, 215);
        }
        if (line3Box.isSelected()) {
            g.setColor(THIRD_LINE_COLOR);
            g.drawLine(227, 290, 255, 290);
            g.drawLine(325, 290, 365, 290);
            g.drawLine(435, 290, 475, 290);
        }
        if (line4Box.isSelected()) {
            g.setColor(TOP_DIAG_LINE_COLOR);
            g.drawLine(227, 74, 255, 100);
            g.drawLine(325, 160, 365, 195);
            g.drawLine(435, 254, 475, 289);
        }
        if (line5Box.isSelected()) {
            g.setColor(BOTTOM_DIAG_COLOR);
            g.drawLine(227, 354, 255, 329);
            g.drawLine(325, 271, 365, 236);
            g.drawLine(435, 178, 475, 141);
        }
        repaint();
    }
}
