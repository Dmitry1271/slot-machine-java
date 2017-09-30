package by.dudko.slotmachine.write;

/**
 * Created by cplus on 21.08.2017.
 */
public class ConsoleWriter {
    public static void write(String slots[][]){
        for (int i = 0; i < slots.length; ++i) {
            for (int j = 0; j < slots[i].length; ++j) {
                System.out.print(slots[j][i] + " ");
            }
            System.out.println();
        }
    }
}
