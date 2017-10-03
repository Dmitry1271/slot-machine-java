package by.dudko.slotmachine.swingrealisation.action;

/**
 * Created by cplus on 30.09.2017.
 */
public class ChangeValue {
    public static double changePlus(double current) {
        if (current < 0.5) return (current + 0.1);
        else if (current == 0.5) return 1;
        else if (current < 5) return current + 1;
        else if (current < 20) return current * 2;
        else if (current == 20) return 50;
        else if (current == 50) return 100;
        return 100;
    }

    public static double changeMinus(double current) {
        if (current == 100) return 50;
        else if (current == 50) return 20;
        else if (current > 5) return current / 2;
        else if (current > 1) return current - 1;
        else if (current == 1) return 0.5;
        else if (current > 0.1) return (current - 0.1);
        return 0.1;
    }
}
