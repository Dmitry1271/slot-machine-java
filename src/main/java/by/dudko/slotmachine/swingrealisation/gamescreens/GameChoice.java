package by.dudko.slotmachine.swingrealisation.gamescreens;

import by.dudko.slotmachine.constants.GameChoiceConstants;
import by.dudko.slotmachine.swingrealisation.MainScreen;

import javax.swing.*;

/**
 * Created by cplus on 28.09.2017.
 */
public class GameChoice extends JPanel {
    private JButton demoGameButton = new JButton(GameChoiceConstants.DEMO_GAME_BUTTON_TEXT);
    private JButton normalGameButton = new JButton(GameChoiceConstants.NORMAL_GAME_BUTTON_TEXT);

    public GameChoice() {
        setProperties();
        settingBounds();
        addingToPanel();
        addButtonsAction();
    }

    private void setProperties() {
        setLayout(null);
    }

    private void settingBounds() {
        demoGameButton.setBounds(315, 220, 170, 35);
        normalGameButton.setBounds(315, 280, 170, 35);
    }

    private void addingToPanel() {
        add(demoGameButton);
        add(normalGameButton);
    }

    private void addButtonsAction() {
        demoGameButton.addActionListener(e -> {
            MainScreen.isDemoGame = true;
            MainScreen.mainPanel.add(new GameTable(), "GameTable");
            MainScreen.layout.show(MainScreen.mainPanel, "GameTable");
        });

        normalGameButton.addActionListener(e -> {
            MainScreen.isDemoGame = false;
            MainScreen.layout.show(MainScreen.mainPanel, "Login");
        });
    }
}
