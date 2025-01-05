package rsmchallenge;
import java.util.Objects;

public class Season {
    private int seasonNumber;
    private int yearOfRelease;
    private int numberOfEpisodes;
    private StreamingService streamingService;

    public Season(int seasonNumber, int yearOfRelease, int numberOfEpisodes) {
        this.seasonNumber = seasonNumber;
        this.yearOfRelease = yearOfRelease;
        this.numberOfEpisodes = numberOfEpisodes;
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

    public void setStreamingService(StreamingService streamingService) {
        this.streamingService = streamingService;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Season season = (Season) obj;
        return seasonNumber == season.seasonNumber &&
               yearOfRelease == season.yearOfRelease;
    }

    @Override
    public int hashCode() {
        return Objects.hash(seasonNumber, yearOfRelease);
    }

    @Override
    public String toString() {
        return "Season{" +
               "seasonNumber=" + seasonNumber +
               ", yearOfRelease=" + yearOfRelease +
               ", numberOfEpisodes=" + numberOfEpisodes +
               ", streamingService=" + (streamingService != null ? streamingService.getName() : "None") +
               '}';
    }
}
