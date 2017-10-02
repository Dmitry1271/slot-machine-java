package by.dudko.slotmachine.machinerealisation.riskbonus;

import java.util.Random;

/**
 * Created by cplus on 30.09.2017.
 */
public class RiskGenerator {
    public static int generate() {
        Random random = new Random();
        return random.nextInt(2);
    }
}
