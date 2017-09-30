package by.dudko.slotmachine.entity;

/**
 * Created by cplus on 29.08.2017.
 */
public class Client extends User{
    private String login;
    private String password;
    private long cardNumber;
    private String email;
    private String name;
    private String surname;
    private double balance;
    private double bet;
    private int numberLines;


    @Override
    public double start() {
        return 0;
    }
}
