package by.dudko.slotmachine.entity;

/**
 * Created by cplus on 29.08.2017.
 */
public class Client{
    private int id;
    private String login;
    private long cardNumber;
    private double balance;


    public Client(){}

    public Client(int id, String login, long cardNumber, double balance) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Client client = (Client) o;

        if (cardNumber != client.cardNumber) return false;
        if (Double.compare(client.balance, balance) != 0) return false;
        return login != null ? login.equals(client.login) : client.login == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = login != null ? login.hashCode() : 0;
        result = 31 * result + (int) (cardNumber ^ (cardNumber >>> 32));
        temp = Double.doubleToLongBits(balance);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Client{" +
                "login='" + login + '\'' +
                ", cardNumber=" + cardNumber +
                ", balance=" + balance +
                '}';
    }
}
