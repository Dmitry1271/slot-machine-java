package by.dudko.slotmachine.constants;

import java.awt.*;

/**
 * Created by cplus on 15.11.2017.
 */
public final class GameTableConstants {
    private GameTableConstants() {
    }

    //buttons
    public static final String PLAY_BUTTON_TEXT = "Play";
    public static final String RISK_BUTTON_TEXT = "Risk";
    public static final String HELP_BUTTON_TEXT = "Help";
    public static final String PLUS_BUTTON_TEXT = "+";
    public static final String MINUS_BUTTON_TEXT = "-";

    public static final String BALANCE_TEXT = "Balance";
    public static final String BET_TEXT = "Bet";
    public static final String BET_FOR_LINE_TEXT = "Bet for line";
    public static final String BET_VALUE = "0.0";
    public static final String BET_FOR_LINE_VALUE = "0.1";

    public static final String MESSAGE_DIALOG_TEXT_AFTER_WON_1 = "You won: ";
    public static final String MESSAGE_DIALOG_TEXT_AFTER_WON_2 = "\nNow you can Risk!";
    public static final String CONFIRM_DIALOG_AFTER_LOST_MONEY_NORMAL_GAME = "You haven't so much money!\nDo you wanna top up your balance?";
    public static final String MESSAGE_DIALOG_AFTER_LOST_MONEY_DEMO_GAME = "You haven't so much money!";
    public static final String MESSAGE_DIALOG_LINE_SELECTION_HELP = "You must select at least one line!";
    public static final String MESSAGE_DIALOG_RISK_HELP = "You can use this only right after the winning!";

    //Lines colors
    public static final Color FIRST_LINE_COLOR = Color.red;
    public static final Color SECOND_LINE_COLOR = Color.blue;
    public static final Color THIRD_LINE_COLOR = new Color(204, 0, 153);
    public static final Color TOP_DIAG_LINE_COLOR = new Color(0, 200, 51);
    public static final Color BOTTOM_DIAG_COLOR = Color.orange;

}
