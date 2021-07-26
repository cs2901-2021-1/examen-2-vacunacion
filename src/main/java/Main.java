
import Classes.Application;
import Classes.User;
import java.util.logging.Logger;

public class Main {
    static Logger logger = Logger.getLogger(Main.class.getName());
    public static void main(String[] args) {
        Application app = new Application();
        User user_1 = new User("josedlz");

        //FR01
        user_1.set_token(app.login_user(user_1));

        //FR02
        app.get_general_information(user_1);


        //FR06
        app.logout_user(user_1);


    }

}
