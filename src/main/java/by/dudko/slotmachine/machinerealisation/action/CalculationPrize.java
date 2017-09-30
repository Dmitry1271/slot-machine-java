package by.dudko.slotmachine.machinerealisation.action;

import static by.dudko.slotmachine.run.Constants.*;

/**
 * Created by cplus on 28.08.2017.
 */
public class CalculationPrize {

    public static double getWonPrize(String string) {
        switch (string) {
            case "9": {
                return NINE;
            }
            case "10": {
                return TEN;
            }
            case "J": {
                return JACK;
            }
            case "Q": {
                return QUEEN;
            }
            case "A": {
                return ACE;
            }
            case "@": {
                return JOKER;
            }
            default: {
                return 0;
            }
        }
    }
}
