package by.dudko.slotmachine.valid;

/**
 * Created by cplus on 03.10.2017.
 */
public class BalanceIncreaseScreenValidator {
    public static boolean isValidBalance(String balance) {
        return balance.matches("^[0-9]{1,10}(\\.[0-9])?$");
    }
}
