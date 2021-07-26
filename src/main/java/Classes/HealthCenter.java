package Classes;

public class HealthCenter {

    String name;
    String city;
    Integer partially_vaccinated;
    Integer completely_vaccinated;
    Integer total_people;

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
}
