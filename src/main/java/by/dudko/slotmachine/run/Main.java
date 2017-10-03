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
        List<Integer> lines = new LinkedList<>();
        double bet = 1;
        boolean demoGame = true;
        double balance = 0;
        lines.add(2);
        lines.add(1);
        lines.add(3);
       /* SlotRings slotRings = new SlotRings(Constants.SLOT_RINGS);
        slotRings.generate();
        for(int i = 0; i < 20; i++){
            for(int j = 0; j < 3; ++j){
                System.out.print(slotRings.getRings()[j][i]+ " ");
            }
            System.out.println();
        }
        slotRings.generate();
        System.out.println();
        for(int i = 0; i < 20; i++){
            for(int j = 0; j < 3; ++j){
                System.out.print(slotRings.getRings()[j][i]+ " ");
            }
            System.out.println();
        }*/

        //User user = new Guest(bet,lines);
        //System.out.println(user.start());

/*
       try {
            Connection connection = DriverManager.getConnection(TYPE_DB + ":" + NAME_DB + ":" + URL_DB, LOGIN_DB, PASSWORD_DB);
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM client");
            while (result.next()) {
                int id = result.getInt(1);
                double balance1 = result.getInt(7);
                String phone = result.getString("card_number");
                System.out.println("id = " + id);
                System.out.println("balance = " + balance1);
                System.out.println("phone = " + phone);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
*/
        SwingUtilities.invokeLater(MainScreen::new);
    }
}