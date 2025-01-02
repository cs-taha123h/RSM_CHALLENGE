package rsmchallenge;
import java.util.HashSet;
import java.util.Set;
public class StreamingService {
   private String name;
   private double price;
   private Set<Film> films;
   
   public StreamingService(String name, double price){
        this.name = name;
        this.price = price;
        this.films = new HashSet<>();
   }
   
   public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    
    public boolean addFilm(Film film) {
        if (film.getCurrentService() != null && film.getCurrentService() != this) {
            System.out.println("The film '" + film.getName() + "' is already assigned to another streaming service.");
            return false;
        }
        if (films.contains(film)) {
            System.out.println("Film already exists in this service.");
            return false;
        }
        
        films.add(film);
        film.setCurrentService(this);
        return true;
    }
    
    public boolean removeFilm(Film film) {
        if (films.remove(film)) {
            film.setCurrentService(null); // Disassociate the film from the service
            return true;
        }
        System.out.println("Film not found in this service.");
        return false;
    }
    
    public void listFilms() {
        if (films.isEmpty()) {
            System.out.println("No films available on this service.");
        } else {
            System.out.println("Films on " + name + ":");
            for (Film film : films) {
                System.out.println(film);
            }
        }
    }
    
    @Override
    public String toString(){
        return "StreamingService name='" + name + "', price= £" + price;
    }
}
