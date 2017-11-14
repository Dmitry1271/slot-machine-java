package by.dudko.slotmachine.run;

import by.dudko.slotmachine.swingrealisation.MainScreen;

import javax.swing.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by cplus on 06.07.2017.
 */
public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainScreen::new);
    }
}