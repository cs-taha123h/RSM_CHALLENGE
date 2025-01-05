package rsmchallenge;
public class Film {
    private String name;
    private int year;
    private String genre;
    private double rating;
    private int runtime;
    private StreamingService currentService;  // To track which service the film belongs to

    // Constructor to initialize the film's attributes
    public Film(String name, int year, String genre, double rating, int runtime) {
        this.name = name;
        this.year = year;
        this.genre = genre;
        this.rating = rating;
        this.runtime = runtime;
        this.currentService = null; // Initially, no streaming service associated
    }

    public String getName() {
        return name;
    }
    public int getYear() {
        return year;
    }
    public String getGenre() {
        return genre;
    }
    public double getRating() {
        return rating;
    }
    public void setRating(double rating) {
        if (rating >= 0 && rating <= 5) {
            this.rating = rating;
        } else {
            throw new IllegalArgumentException("Rating must be between 0 and 5.");
        }
    }
    public int getRuntime() {
        return runtime;
    }
    
   
    public StreamingService getCurrentService() {
        return currentService;
    }
    public void setCurrentService(StreamingService currentService) {
        this.currentService = currentService;
    }
    
    //Overide required since otherwise equals to would be diffrent
    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (obj == null || getClass() != obj.getClass()){
            return false;
        }//either is diffrent class or is null
        Film film = (Film) obj;
        return year == film.year && name.equals(film.name);
    }
    
    //overide hashcode so hashcodes are consistent for each film based on name and year
    @Override
    public int hashCode(){
        int result = name.hashCode();
        result = result + year;
        return result;
    }
    
    @Override
    public String toString(){
        return "name='" + name + "', year=" + year + ", genre='" + genre +
               "', rating=" + rating + " stars, runtime=" + runtime + " mins";
    }
}
