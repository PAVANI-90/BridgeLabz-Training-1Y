package com.gla.GenericsAndCollections.JavaCollection.ScenarioBased;
import java.util.*;
class Movie {
    private String id;
    private String title;
    private String genre;

    public Movie(String id, String title, String genre) {
        this.id = id;
        this.title = title;
        this.genre = genre;
    }

    public String getId() { return id; }
    public String getTitle() { return title; }
    public String getGenre() { return genre; }

    @Override
    public String toString() {
        return "Movie{" + id + ", " + title + ", " + genre + "}";
    }
}
public class StreamingWatchHistorySystem {
    private Stack<Movie> watchHistory;
    private List<Movie> allMovies;
    private Set<String> watchedGenres;
    private Queue<Movie> upNext;

    public StreamingWatchHistorySystem() {
        this.watchHistory = new Stack<>();
        this.allMovies = new ArrayList<>();
        this.watchedGenres = new HashSet<>();
        this.upNext = new LinkedList<>();
    }

    public void addMovieToCatalog(Movie m) {
        allMovies.add(m);
    }

    public void addToUpNext(Movie m) {
        upNext.add(m);
        System.out.println("Added to Up Next: " + m);
    }

    public void playNext() {
        if (upNext.isEmpty()) {
            System.out.println("Up Next is empty.");
            return;
        }
        Movie m = upNext.poll();
        System.out.println("Now playing: " + m);
        completeMovie(m);
    }

    private void completeMovie(Movie m) {
        watchHistory.push(m);
        watchedGenres.add(m.getGenre());
        System.out.println("Completed and added to history: " + m);
    }

    public void showRecommendations() {
        System.out.println("\n Recommendations based on watched genres ");
        if (watchedGenres.isEmpty()) {
            System.out.println("No genres watched yet.");
            return;
        }
        Set<Movie> recommended = new LinkedHashSet<>();
        for (Movie m : allMovies) {
            if (watchedGenres.contains(m.getGenre()) && !watchHistory.contains(m)) {
                recommended.add(m);
            }
        }
        if (recommended.isEmpty()) {
            System.out.println("No recommendations available.");
        } else {
            for (Movie m : recommended) {
                System.out.println("  " + m);
            }
        }
    }

    public void printStatus() {
        System.out.println("\n Status ");
        System.out.println("Watch history stack size: " + watchHistory.size());
        System.out.println("Up Next queue size: " + upNext.size());
        System.out.println("Watched genres: " + watchedGenres);
    }

    public static void main(String[] args) {
        StreamingWatchHistorySystem system = new StreamingWatchHistorySystem();

        Movie m1 = new Movie("M001", "Inception", "Sci-Fi");
        Movie m2 = new Movie("M002", "Interstellar", "Sci-Fi");
        Movie m3 = new Movie("M003", "The Dark Knight", "Action");
        Movie m4 = new Movie("M004", "3 Idiots", "Comedy");
        Movie m5 = new Movie("M005", "PK", "Comedy");

        system.addMovieToCatalog(m1);
        system.addMovieToCatalog(m2);
        system.addMovieToCatalog(m3);
        system.addMovieToCatalog(m4);
        system.addMovieToCatalog(m5);

        system.addToUpNext(m1);
        system.addToUpNext(m3);
        system.addToUpNext(m4);

        system.playNext();
        system.playNext();

        system.printStatus();
        system.showRecommendations();
    }
}
