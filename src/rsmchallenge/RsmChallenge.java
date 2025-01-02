package rsmchallenge;
public class RsmChallenge {
    public static void main(String[] args) {
        // Create two films with the same name but different years
        Film inception2010 = new Film("Inception", 2010, "Sci-Fi", 4.8, 148);
        Film inception2020 = new Film("Inception", 2010, "Sci-Fi", 4.8, 148);

        // Print the films' details
        System.out.println("Film 1: " + inception2010);
        System.out.println("Film 2: " + inception2020);

        // Compare the two films using equals() method
        System.out.println("\nAre the two films with the same name but different years equal?");
        System.out.println(inception2010.equals(inception2020)); // Should be false

        // Check hash codes to further confirm
        System.out.println("\nHash codes:");
        System.out.println("Film 1 hash code: " + inception2010.hashCode());
        System.out.println("Film 2 hash code: " + inception2020.hashCode());
        
        //edited text to contain words
    
    }    
}
