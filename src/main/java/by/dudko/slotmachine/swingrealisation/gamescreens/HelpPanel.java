package by.dudko.slotmachine.swingrealisation.gamescreens;

import by.dudko.slotmachine.constants.HelpPanelConstants;
import by.dudko.slotmachine.swingrealisation.MainScreen;

import javax.swing.*;

/**
 * Created by cplus on 04.10.2017.
 */
public class HelpPanel extends JPanel {
    private JLabel rules = new JLabel(HelpPanelConstants.RULES);
    private JButton goGameButton = new JButton(HelpPanelConstants.BUTTON_NAME);

    public HelpPanel() {
        setPanelProperties();
        settingBounds();
        addingToPanel();
        addButtonsAction();
    }

    private void setPanelProperties() {
        setLayout(null);
    }

    private void settingBounds() {
        rules.setBounds(20, 30, 700, 390);
        goGameButton.setBounds(315, 460, 120, 35);
    }

    private void addingToPanel() {
        add(rules);
        add(goGameButton);
    }

    private void addButtonsAction() {
        goGameButton.addActionListener(e -> {
            MainScreen.layout.show(MainScreen.mainPanel, "GameTable");
        });
    }
}
