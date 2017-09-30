package by.dudko.slotmachine.machinerealisation.action;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by cplus on 25.08.2017.
 */
public class CheckingTest {
    @Test
    public void isEqualTest() {
        Assert.assertEquals(true, Checking.isEqual("A", "A", "A"));
        Assert.assertEquals(false, Checking.isEqual("A", "J", "A"));
        Assert.assertEquals(false, Checking.isEqual("A", "A", "@"));
        Assert.assertEquals(false, Checking.isEqual("A", "A", null));
    }
}
