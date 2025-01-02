package rsmchallenge;
public class RsmChallenge {
    public static void main(String[] args) {
        StreamingService netflix = new StreamingService("Netflix", 9.99);
        StreamingService primeVideo = new StreamingService("Prime Video", 7.99);

        System.out.println("Created streaming services:");
        System.out.println(netflix);
        System.out.println(primeVideo);

        // 2. Add films to streaming services
        Film inception = new Film("Inception", 2010, "Sci-Fi", 4.8, 148);
        Film avengers = new Film("The Avengers", 2012, "Action", 4.5, 143);
        Film inceptionDuplicate = new Film("Inception", 2010, "Sci-Fi", 4.8, 148); // Duplicate
        Film inceptionDuplicateyear = new Film("Inception", 2020, "Sci-Fi", 4.8, 158); // Duplicate

        System.out.println("\nAdding films to Netflix...");
        System.out.println("Adding Inception: " + netflix.addFilm(inception));
        System.out.println("Adding The Avengers: " + netflix.addFilm(avengers));
        System.out.println("Adding Inception (Duplicate): " + netflix.addFilm(inceptionDuplicate));
        System.out.println("Adding Inception (Duplicate year): " + netflix.addFilm(inceptionDuplicateyear));

        System.out.println("\nCurrent films on Netflix:");
        netflix.listFilms();

        System.out.println("\nAdding Inception to Prime Video (Should fail):");
        System.out.println("Adding Inception: " + primeVideo.addFilm(inception)); // Should fail

        // 3. Remove a film from a streaming service
        System.out.println("\nRemoving The Avengers from Netflix...");
        System.out.println("Removed: " + netflix.removeFilm(avengers));

        System.out.println("\nCurrent films on Netflix:");
        netflix.listFilms();

        // 4. Rate a film directly via the Film class
        System.out.println("\nUpdating rating for Inception...");
        inception.setRating(5.0);

        System.out.println("\nCurrent films on Netflix after rating update:");
        netflix.listFilms();
        
        System.out.println("\nHash code test");
        System.out.println("Inception year2010:" + inception.hashCode());
        System.out.println("Inception year2010:" + inceptionDuplicate.hashCode());
        System.out.println("Inception year2010:" + inceptionDuplicateyear.hashCode());
    }    
}
