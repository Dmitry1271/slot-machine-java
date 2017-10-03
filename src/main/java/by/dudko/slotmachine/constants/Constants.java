package by.dudko.slotmachine.constants;

/**
 * Created by cplus on 21.08.2017.
 */
public class Constants {
    public static final String[][] SLOT_RINGS = new String[][]{{"@", "A", "10", "9", "9", "J", "10", "9", "9", "9", "K", "9", "9", "A", "A", "9", "K", "9", "Q", "J"},
                                                               {"J", "9", "9", "10", "K", "Q", "Q", "@", "10", "A", "J", "10", "9", "K", "9", "Q", "9", "9", "J", "10"},
                                                               {"10", "J", "9", "@", "Q", "10", "9", "Q", "10", "9", "A", "9", "J", "9", "9", "9", "Q", "10", "10", "9"}};
    public static final int RANDOM_LIMIT = 60;
    public static final int RING_NUMBER = 3;
    public static final int RING_WIDTH = 3;
    public static final double DEMO_BALANCE = 100;

    //prizes
    public static final int NINE = 5;
    public static final int TEN = 30;
    public static final int JACK = 50;
    public static final int QUEEN = 50;
    public static final int ACE = 300;
    public static final int JOKER = 1000;

    //mySQL data
    public static final String TYPE_DB = "jdbc";
    public static final String NAME_DB = "mysql";
    public static final String URL_DB = "//localhost:3306/clients_data";
    public static final String LOGIN_DB = "root";
    public static final String PASSWORD_DB = "root";
}
