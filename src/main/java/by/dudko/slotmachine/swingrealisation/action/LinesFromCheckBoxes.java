package by.dudko.slotmachine.swingrealisation.action;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cplus on 30.09.2017.
 */
public class LinesFromCheckBoxes {
    public static List<Integer> getSelectedLines(ArrayList<JCheckBox> boxes) {
        List<Integer> listLines = new ArrayList<>();
        int flag = 1;
        for (JCheckBox box : boxes) {
            if (box.isSelected()) {
                listLines.add(flag);
            }
            flag++;
        }
        return listLines;
    }
}
