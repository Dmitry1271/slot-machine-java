package by.dudko.slotmachine.entity;

import by.dudko.slotmachine.run.Constants;
import by.dudko.slotmachine.machinerealisation.result.CalculationMoneyForElements;
import by.dudko.slotmachine.machinerealisation.result.CheckLines;
import by.dudko.slotmachine.write.ConsoleWriter;

import java.util.List;

/**
 * Created by cplus on 01.09.2017.
 */
public class Guest extends User{
    private double bet;
    private List<Integer> lines;
    private double balance;
    private SlotRings slotRings = new SlotRings(Constants.SLOT_RINGS);

    public Guest() {
    }

    public Guest(double bet, List<Integer> lines) {
        this.bet = bet;
        this.lines = lines;
        this.balance = Constants.DEMO_BALANCE;
    }

    public double getBet() {
        return bet;
    }

    public void setBet(double bet) {
        this.bet = bet;
    }

    public List<Integer> getLines() {
        return lines;
    }

    public void setLines(List<Integer> lines) {
        this.lines = lines;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public double start() {

        slotRings.generate();
        ConsoleWriter.write(slotRings.getVisiblePartRings());
        return new CalculationMoneyForElements(bet).calculate(new CheckLines(lines).getWonElements(slotRings));
    }
}
