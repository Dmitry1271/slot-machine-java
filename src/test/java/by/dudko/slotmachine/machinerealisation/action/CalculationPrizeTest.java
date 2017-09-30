package by.dudko.slotmachine.machinerealisation.action;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by cplus on 28.08.2017.
 */
public class CalculationPrizeTest {
    @Test
    public void getWonPrizeTest(){
        Assert.assertEquals(CalculationPrize.getWonPrize("J"),50,1);
        Assert.assertEquals(CalculationPrize.getWonPrize("9"),5,1);
        Assert.assertEquals(CalculationPrize.getWonPrize("Q"),50,1);
        Assert.assertEquals(CalculationPrize.getWonPrize("A"),300,1);
        Assert.assertEquals(CalculationPrize.getWonPrize("@"),1000,1);
        Assert.assertEquals(CalculationPrize.getWonPrize("10"),30,1);
    }
}
