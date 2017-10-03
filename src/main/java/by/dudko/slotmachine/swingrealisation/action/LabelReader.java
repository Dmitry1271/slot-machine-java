package by.dudko.slotmachine.swingrealisation.action;

import javax.swing.*;

/**
 * Created by cplus on 30.09.2017.
 */
public class LabelReader {
    public static double getValue(JLabel label){
        return Double.parseDouble(label.getText());
    }

    public static double getValue(JTextField jTextField){
        return Double.parseDouble(jTextField.getText());
    }

}
