package by.dudko.slotmachine.machinerealisation.action;

import by.dudko.slotmachine.run.Constants;

import java.util.Random;

/**
 * Created by cplus on 21.08.2017.
 */
public class RingScrolling {
    public static String[] scroll(String[] string) {
        Random random = new Random();
        for (int j = 0; j < random.nextInt(Constants.RANDOM_LIMIT) % string.length; ++j) {
            String first = string[0];
            string[0] = string[string.length - 1];
            for (int i = string.length - 2; i != 0; --i) {
                string[i + 1] = string[i];
            }
            string[1] = first;
        }
        return string;
    }
}
