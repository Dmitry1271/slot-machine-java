package by.dudko.slotmachine.entity;

import by.dudko.slotmachine.constants.Constants;
import by.dudko.slotmachine.machinerealisation.action.RingScrolling;

/**
 * Created by cplus on 06.07.2017.
 */
public class SlotRings {
    private String[][] rings;
    private String[][] visiblePartRings;

    public SlotRings() {

    }

    public SlotRings(String[][] rings) {
        this.rings = rings;
        giveMemory();
        highlightRings();
    }

    public void generate() {
        rings[0] = RingScrolling.scroll(rings[0]);
        rings[1] = RingScrolling.scroll(rings[1]);
        rings[2] = RingScrolling.scroll(rings[2]);
        highlightRings();
    }

    public String[][] getRings() {
        return rings;
    }

    public String[][] getVisiblePartRings() {
        return visiblePartRings;
    }

    private void giveMemory() {
        visiblePartRings = new String[Constants.RING_WIDTH][Constants.RING_NUMBER];
    }

    private void highlightRings(){
        for (int i = 0; i < Constants.RING_NUMBER; ++i) {
            for (int j = 0; j < Constants.RING_WIDTH; ++j) {
                visiblePartRings[i][j] = rings[i][j];
            }
        }
    }
}
