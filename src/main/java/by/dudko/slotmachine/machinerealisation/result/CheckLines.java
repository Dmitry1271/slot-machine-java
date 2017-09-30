package by.dudko.slotmachine.machinerealisation.result;

import by.dudko.slotmachine.machinerealisation.combination.*;
import by.dudko.slotmachine.entity.SlotRings;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by cplus on 26.08.2017.
 */
public class CheckLines {
    private List<Integer> lines = new LinkedList<>();

    public CheckLines(List<Integer> lines) {
        this.lines = lines;
    }

    public List<String> getWonElements(SlotRings slotRings) {
        List<String> elements = new ArrayList<>();
        String firstLine = new FirstLineCombo().wonElement(slotRings);
        String secondLine = new SecondLineCombo().wonElement(slotRings);
        String thirdLine = new ThirdLineCombo().wonElement(slotRings);
        String forthLine = new ForthLineCombo().wonElement(slotRings);
        String fifthLine = new FifthLineCombo().wonElement(slotRings);
        if (lines.contains(new Integer("1")) && firstLine != null) {
            elements.add(firstLine);
        }
        if (lines.contains(new Integer("2")) && secondLine != null) {
            elements.add(secondLine);
        }
        if (lines.contains(new Integer("3")) && thirdLine != null) {
            elements.add(thirdLine);
        }
        if (lines.contains(new Integer("4")) && forthLine != null) {
            elements.add(forthLine);
        }
        if (lines.contains(new Integer("5")) && fifthLine != null) {
            elements.add(fifthLine);
        }
        return elements;
    }
}
