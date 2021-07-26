package Classes;
import java.util.*;
import java.security.SecureRandom;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Logger;

public class Application {
    // Constructor

    // Attributes
    //Logger
    static Logger logger = Logger.getLogger(System.class.getName());

    //List of Health Centers
    List<HealthCenter> centers = new ArrayList<HealthCenter>();

    //User ID -> token
    HashMap<String, Integer> online_users = new HashMap<String, Integer>();

    //Queue for the 50 simultaneous requests
    Queue<Request> requests = new LinkedList<Request>();

    //We are not using a database but we still need to know the available users
    TreeSet<String> users = new TreeSet<String>();

    // Methods
    private void populate_users() {
        this.users.add("josedlz");
        this.users.add("jbellido");
        this.users.add("tchambilla");
    }

    private void populate_centers() {
        this.centers.add(new HealthCenter("Centro 1", "Lima", 100, 200, 500));
        this.centers.add(new HealthCenter("Centro 2", "Trujillo", 200, 300, 700));
    }
    public Application() {
        this.populate_users();
        this.populate_centers();
    }

    public Integer login_user(User user) {
        //Generate random token and save this token in a list of users
        Integer new_token = -1;
        try {
            SecureRandom number = SecureRandom.getInstance("SHA1PRNG");
            // Generate random integer
            new_token = number.nextInt(200000);
        } catch (NoSuchAlgorithmException nsae) {
            logger.info("Token generation failed");
        }
        this.online_users.put(user.get_username(), new_token);
        return new_token;
    }

    public void logout_user(User user) {
        this.online_users.remove(user.get_username());
    }

    public void get_general_information(User user) {
        if (user.get_token() != online_users.get(user.get_token())) {
            logger.info("Not authorized operation");
            return;
        }
        Integer total_partial = 0;
        Integer total_complete = 0;

        for (HealthCenter center : centers) {
            total_partial += center.getPartially_vaccinated();
            total_complete += center.getCompletely_vaccinated();
        }
        logger.info("Partially vaccinated: " + total_partial);
        logger.info("Total vaccinated completely: " + total_complete);
    }

    public void register_user(User user, String center_name) {
        if (user.get_token() != online_users.get(user.get_token())) {
            logger.info("Not authorized operation");
            return;
        }
        for (HealthCenter center : centers) {
            if (center.get_name() == center_name) {
                center.register_user(user);
            }
        }
    }
    public void unsubscribe_user(User user, String center_name) {
        if (user.get_token() != online_users.get(user.get_token())) {
            logger.info("Not authorized operation");
            return;
        }
        for (HealthCenter center : centers) {
            if (center.get_name() == center_name) {
                center.unsubscribe_user(user);
            }
        }
    }
}
}
