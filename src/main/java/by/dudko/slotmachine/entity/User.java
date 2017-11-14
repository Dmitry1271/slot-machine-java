package by.dudko.slotmachine.entity;

/**
 * Created by cplus on 29.08.2017.
 */
public class User {
    private int id;
    private String login;
    private long cardNumber;
    private double balance;
    private String password;


    public User(){}

    public User(int id, String login, long cardNumber, double balance) {
        this.id = id;
        this.login = login;
        this.cardNumber = cardNumber;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public long getCardNumber() {
        return cardNumber;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setCardNumber(long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (cardNumber != user.cardNumber) return false;
        if (Double.compare(user.balance, balance) != 0) return false;
        if (login != null ? !login.equals(user.login) : user.login != null) return false;
        return password != null ? password.equals(user.password) : user.password == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (int) (cardNumber ^ (cardNumber >>> 32));
        temp = Double.doubleToLongBits(balance);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }
}
