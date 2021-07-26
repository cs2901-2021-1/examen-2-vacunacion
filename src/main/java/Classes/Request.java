package Classes;

public class Request {
    //Attributes
    Integer user_id;
    String type;

    //Methods
    //Constructor
    public Request(Integer user_id, String request) {
        this.user_id = user_id;
        this.type = request;
    }

    public String get_type() {
        return this.type;
    }
}
