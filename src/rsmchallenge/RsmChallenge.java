package rsmchallenge;
public class RsmChallenge {
    public static void main(String[] args) {
        // Create streaming services
        StreamingService netflix = new StreamingService("Netflix", 9.99);
        StreamingService primeVideo = new StreamingService("Prime Video", 7.99);

        System.out.println("Created streaming services:");
        System.out.println(netflix);
        System.out.println(primeVideo);

        // Create TvShows
        TvShow breakingBad = new TvShow("Breaking Bad", "Drama", 4.9);
        TvShow theOffice = new TvShow("The Office", "Comedy", 4.8);

        System.out.println("\nAdding TvShows to Netflix...");
        System.out.println("Adding Breaking Bad: " + netflix.addTVShow(breakingBad));
        System.out.println("Adding The Office: " + netflix.addTVShow(theOffice));

        System.out.println("\nAdding TvShows to Prime Video...");
        System.out.println("Adding Breaking Bad: " + primeVideo.addTVShow(breakingBad)); // Should succeed (different service)

        // Create seasons
        Season season1 = new Season(1, 2008, 7);
        Season season2 = new Season(2, 2009, 13);
        Season season3 = new Season(3, 2010, 13);

        System.out.println("\nAdding seasons to Breaking Bad on Netflix...");
        System.out.println("Adding Season 1: " + netflix.addSeasonToTVShow(breakingBad, season1));
        System.out.println("Adding Season 2: " + netflix.addSeasonToTVShow(breakingBad, season2));

        System.out.println("\nAdding Season 1 of Breaking Bad to Prime Video (Should fail)...");
        System.out.println("Adding Season 1: " + primeVideo.addSeasonToTVShow(breakingBad, season1)); // Should fail

        System.out.println("\nAdding Season 3 to Breaking Bad on Prime Video...");
        System.out.println("Adding Season 3: " + primeVideo.addSeasonToTVShow(breakingBad, season3)); // Should succeed

        System.out.println("\nAdding seasons to The Office on Netflix...");
        Season officeSeason1 = new Season(1, 2005, 6);
        Season officeSeason2 = new Season(2, 2006, 22);
        System.out.println("Adding Season 1: " + netflix.addSeasonToTVShow(theOffice, officeSeason1));
        System.out.println("Adding Season 2: " + netflix.addSeasonToTVShow(theOffice, officeSeason2));

        // List TvShows and their seasons
        System.out.println("\nNetflix TvShows:");
        netflix.listTVShows();

        System.out.println("\nPrime Video TvShows:");
        primeVideo.listTVShows();

        // Update rating for a TvShow
        System.out.println("\nUpdating rating for Breaking Bad on Netflix...");
        breakingBad.setRating(5.0);

        System.out.println("\nNetflix TvShows after rating update:");
        netflix.listTVShows();
    }    
}
