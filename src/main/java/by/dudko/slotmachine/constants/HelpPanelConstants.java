package by.dudko.slotmachine.constants;

/**
 * Created by cplus on 04.10.2017.
 */
public final class HelpPanelConstants {
    private HelpPanelConstants() {
    }

    public static final String RULES = "<html>" +
            "<h2 style = \"text-align: center\">Slot machine rules</h2>" +
            "<p>1) Choose at least one line in boxes on the left of rings with symbols;</p>" +
            "<p>2) In the bottom, set bet for line you want;</p>" +
            "<p>3) Press button Play in bottom-right part of the screen;</p>" +
            "<p>4) See on rings with symbols;</p>" +
            "<p>5) You will win if at one of drawing line on rings with symbols there are 3 equals symbols;</p>" +
            "<p>6) Each symbol has it own coefficient which multiplies on your bet for line and add to balance;</p>" +
            "<p>7) If you won you can press the button called Risk and go to the next screen where you can risk</p>" +
            "<p>8) At risk panel you should chose black or red card, if you win your winning will multiplied by 2, " +
            "if you lose you will lost your winning, you can win there only 5 times than you will pick up all your winning, " +
            "also you can pick up you winning every time after gessing card.</p>" +
            "<p>9) You can press Risk only after winning on the slot rings and only one time after one winning " +
            "and after the next winning you also can press Risk one time and etc.</p>" +
            "<div style = \"text-align: center\">" +
            "<h3>Symbols coefficients</h3>" +
            "<p>9 9 9 - 5</p>" +
            "<p>10 10 10 - 30</p>" +
            "<p>J J J - 50</p>" +
            "<p>Q Q Q - 50</p>" +
            "<p>K K K - 100</p>" +
            "<p>A A A - 300</p>" +
            "<p>@ @ @ - 1000</p>" +
            "</div>" +
            "</html>";

    public static final String BUTTON_NAME = "Back to game";
}
