package by.dudko.slotmachine.machinerealisation.combination;

import by.dudko.slotmachine.machinerealisation.action.Checking;
import by.dudko.slotmachine.entity.SlotRings;

/**
 * Created by cplus on 23.08.2017.
 */
public class ThirdLineCombo implements Combo {
    @Override
    public String wonElement(SlotRings slotRings) {
        if (Checking.isEqual(slotRings.getVisiblePartRings()[0][2], slotRings.getVisiblePartRings()[1][2], slotRings.getVisiblePartRings()[2][2])) {
            return slotRings.getVisiblePartRings()[0][2];
        } else {
            return null;
        }
    }
}
