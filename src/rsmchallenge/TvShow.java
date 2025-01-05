package rsmchallenge;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TvShow {
    private String name;
    private String genre;
    private double rating;
    private List<Season> seasons;
    
    public TvShow(String name, String genre, double rating) {
        this.name = name;
        this.genre = genre;
        this.rating = rating;
        this.seasons = new ArrayList<>();
    }
    public String getName() {
        return name;
    }
    public String getGenre() {
        return genre;
    }
    public double getRating() {
        return rating;
    }
    public List<Season> getSeasons() {
        return seasons;
    }
    
    public void setRating(double rating) {
        if (rating >= 0 && rating <= 5) {
            this.rating = rating;
        } else {
            throw new IllegalArgumentException("Rating must be between 0 and 5.");
        }
    }
    
    //checks if a season is already in a tvshow otherwise returns false
    public boolean addSeason(Season season) {
        if (!seasons.contains(season)) {
            return seasons.add(season);
        }
        return false;
    }
    
    //overide of equals method to allow comparision between diffrent object instances 
    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (obj == null || getClass() != obj.getClass()){
            return false;
        }
        TvShow tvshow = (TvShow) obj;
        return name.equals(tvshow.name);
    }
    

    //overide hashcode so hashcodes are consistent for each tvshow based on name
    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
    
    @Override
    public String toString() {
        return "TVShow{ " +
               "name='" + name +
               ", genre='" + genre +
               ", rating=" + rating +
               ", seasons=" + seasons +
               "}";
    }
}
