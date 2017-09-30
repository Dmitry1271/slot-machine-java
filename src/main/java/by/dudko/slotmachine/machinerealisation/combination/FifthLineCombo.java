package by.dudko.slotmachine.machinerealisation.combination;

import by.dudko.slotmachine.machinerealisation.action.Checking;
import by.dudko.slotmachine.entity.SlotRings;

/**
 * Created by cplus on 23.08.2017.
 */
public class FifthLineCombo implements Combo {
    @Override
    public String wonElement(SlotRings slotRings) {
        if (Checking.isEqual(slotRings.getVisiblePartRings()[2][0], slotRings.getVisiblePartRings()[1][1], slotRings.getVisiblePartRings()[0][2])) {
            return slotRings.getVisiblePartRings()[2][0];
        } else {
            return null;
        }
    }
}
