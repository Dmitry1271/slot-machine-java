package by.dudko.slotmachine.valid;

/**
 * Created by cplus on 03.10.2017.
 */
public class RegistrationValidator {
    private String login;
    private String password;
    private String confirmPassword;
    private String email;
    private String cardNumber;
    private String message;

    public RegistrationValidator() {
    }

    public RegistrationValidator(String login, String password, String confirmPassword, String email, String cardNumber) {
        this.login = login;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.email = email;
        this.cardNumber = cardNumber;
        message = null;
    }

    public boolean isValidData() {
        if (!isValidLogin(login)) {
            message = "Incorrect Login!";
            return false;
        } else if (!isValidPassword(password)) {
            message = "Password must have 8 symbols at least!";
            return false;
        } else if (!password.equals(confirmPassword)) {
            message = "Passwords must match!";
            return false;
        } else if (!isValidEmail(email)) {
            message = "Incorrect email!";
            return false;
        } else if (!isValidCardNumber(cardNumber)) {
            message = "Incorrect card number!";
            return false;
        } else return true;
    }

    public String getErrorMessage() {
        return message;
    }

    private boolean isValidCardNumber(String value) {
        return value.matches("^[0-9]{16}$");
    }

    private boolean isValidEmail(String email) {
        return email.matches("^[a-zA-Z0-9]([a-zA-Z0-9_.-]{0,40})?@[a-z]{1,20}\\.[a-z]{1,20}");
    }

    private boolean isValidPassword(String password) {
        return password.matches("^.{8,60}$");
    }

    private boolean isValidLogin(String login) {
        return login.matches("^[0-9a-zA-Z].{0,30}$");
    }
}
