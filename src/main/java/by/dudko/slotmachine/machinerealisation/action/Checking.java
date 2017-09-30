package by.dudko.slotmachine.machinerealisation.action;

/**
 * Created by cplus on 25.08.2017.
 */
public class Checking {
    public static boolean isEqual(String s1,String s2, String s3){
        return s1.equals(s2) && s2.equals(s3) && s3.equals(s1);
    }
}
