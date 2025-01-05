package rsmchallenge;
import java.util.HashSet;
import java.util.Set;
public class StreamingService {
   private String name;
   private double price;
   private Set<TvShow> tvShows;
   private Set<Season> exclusiveSeasons;
   private Set<Film> films;
   
   public StreamingService(String name, double price){
        this.name = name;
        this.price = price;
        this.tvShows = new HashSet<>();
        this.exclusiveSeasons = new HashSet<>();
        this.films = new HashSet<>();
   }
   
   public String getName() {
        return name;
    }
    
    public double getPrice() {
        return price;
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
    
    //TV seasons below:
    
    public boolean addTVShow(TvShow tvShow) {
        return tvShows.add(tvShow);
    }
    
    //if a season is already assigned to a tvshow this will return false since it wall then already be assigned a streaming service
    public boolean addSeasonToTVShow(TvShow tvShow, Season season) {
        if (exclusiveSeasons.contains(season)) {
            return false;
        }
        for (TvShow show : tvShows) {
            if (show.equals(tvShow)) {
                if (show.addSeason(season)) {
                    exclusiveSeasons.add(season);
                    season.setStreamingService(this);
                    return true;
                }
            }
        }
        return false;
    }
    
    public void listexclusiveseason(TvShow show){
        boolean foundSeason = false;
        
        for (Season season: exclusiveSeasons){
            if(show.equals(season.getTvShow())){
                System.out.println(season);
                foundSeason = true; 
            }
        }
        
        if(!foundSeason){
            System.out.println("There are no exclusive seasons for this show on " + name);
        }
    }

    public void listTVShows() {
        for (TvShow show : tvShows) {
            System.out.println(show);
        }
    }
    @Override
    public String toString(){
        return "StreamingService name='" + name + "', price= £" + price;
    }
}
