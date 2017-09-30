package by.dudko.slotmachine.machinerealisation.result;

import by.dudko.slotmachine.machinerealisation.action.CalculationPrize;

import java.util.List;

/**
 * Created by cplus on 26.08.2017.
 */
public class CalculationMoneyForElements {
    private double bet;

    public CalculationMoneyForElements(double bet) {
        this.bet = bet;
    }

    public double calculate(List<String> elements) {
        double result = 0;
        if (elements.size() == 0) {
            return 0;
        } else {
            for (String element : elements) {
                result += CalculationPrize.getWonPrize(element) * bet;
            }
            return result;
        }
    }
}
