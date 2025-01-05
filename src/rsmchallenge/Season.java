package rsmchallenge;
import java.util.Objects;

public class Season {
    private int seasonNumber;
    private int yearOfRelease;
    private int numberOfEpisodes;
    private StreamingService streamingService;
    private TvShow tvshow;

    public Season(int seasonNumber, int yearOfRelease, int numberOfEpisodes, TvShow tvshow) {
        this.seasonNumber = seasonNumber;
        this.yearOfRelease = yearOfRelease;
        this.numberOfEpisodes = numberOfEpisodes;
        this.tvshow = tvshow;
    }

    public int getSeasonNumber() {
        return seasonNumber;
    }
    public int getYearOfRelease() {
        return yearOfRelease;
    }
    public int getNumberOfEpisodes() {
        return numberOfEpisodes;
    }
    public StreamingService getStreamingService() {
        return streamingService;
    }
    public TvShow getTvShow(){
        return tvshow;
    }

    public void setStreamingService(StreamingService streamingService) {
        this.streamingService = streamingService;
    }

    //updated equals method to allow for shows with the same season number and release year which are attached to a diffrent show
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Season season = (Season) obj;
        return seasonNumber == season.seasonNumber &&
               yearOfRelease == season.yearOfRelease &&
               tvshow == season.tvshow;
    }

    @Override
    public int hashCode() {
        return Objects.hash(seasonNumber, yearOfRelease);
    }

    @Override
    public String toString() {
        return "Season{ " +
               "seasonNumber=" + seasonNumber +
               ", yearOfRelease=" + yearOfRelease +
               ", numberOfEpisodes=" + numberOfEpisodes +
               ", streamingService=" + streamingService.getName() +
               " }";
    }
}
