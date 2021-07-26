package Classes;

public class User {
    //Attributes
    String username;
    Integer token;

    //Methods
    public User(String username) {
        this.username = username;
    }

    public void set_token(Integer new_token) {
        this.token = new_token;
    }

    public Integer get_token() {
        return this.token;
    }

    public String get_username() {
        return this.username;
    }
}
