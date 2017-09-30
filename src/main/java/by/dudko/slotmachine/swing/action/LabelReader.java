package by.dudko.slotmachine.swing.action;

import javax.swing.*;

/**
 * Created by cplus on 30.09.2017.
 */
public class LabelReader {
    public static double getValue(JLabel label){
        return Double.parseDouble(label.getText());
    }

}
