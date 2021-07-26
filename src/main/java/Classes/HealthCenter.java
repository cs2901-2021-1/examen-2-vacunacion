package Classes;
import java.util.*;

public class HealthCenter {

    String name;
    String city;
    Integer partially_vaccinated;
    Integer completely_vaccinated;
    Integer total_people;
    List<User> subscribed_users = new ArrayList<User>();

    public HealthCenter() {
        this.name = "Generic Health Center name";
        this.partially_vaccinated = 0;
        this.completely_vaccinated = 0;
        this.total_people = 30000;
    }
    public HealthCenter(String name, String city, Integer partial, Integer complete, Integer total) {
        this.name = name;
        this.city = city;
        this.partially_vaccinated = partial;
        this.completely_vaccinated = complete;
        this.total_people = total;
    }

    public void vaccinate_someone_with_first_dose() {
        this.partially_vaccinated++;
    }
    public void vaccinate_someone_with_second_dose() {
        this.partially_vaccinated--;
        this.completely_vaccinated++;
    }
    public Integer getPartially_vaccinated() {
        return this.partially_vaccinated;
    }
    public Integer getCompletely_vaccinated() {
        return this.completely_vaccinated;
    }

    public String get_name() {
        return this.name;
    }
    public void register_user(User user) {
        this.subscribed_users.add(user);
    }

    public void unsubscribe_user(User user) {
        this.subscribed_users.remove(user);
    }
}
