package com.gla.StreamAPI.StreamapiStatement.Streamapi;
import java.util.*;
import java.util.stream.Collectors;
import java.util.Comparator;
class Movie {
    String title;
    double rating;
    int year;

    Movie(String title, double rating, int year) {
        this.title = title;
        this.rating = rating;
        this.year = year;
    }

    // ADD THESE GETTERS for method references
    public double getRating() { return rating; }
    public int getYear() { return year; }

    @Override
    public String toString() {
        return String.format("%s (%.1f/10, %d)", title, rating, year);
    }
}
public class TopTrendingMovies {
    public static void main(String[] args) {
        List<Movie> movies = Arrays.asList(
                new Movie("Project Hail Mary", 8.4, 2026),
                new Movie("The Housemaid", 7.0, 2025),
                new Movie("Avatar: Fire and Ash", 7.4, 2025),
                new Movie("Marty Supreme", 8.2, 2026),
                new Movie("Wake Up Dead Man", 7.4, 2025),
                new Movie("One Battle After Another", 7.8, 2025),
                new Movie("The Tiger", 6.6, 2025),
                new Movie("Bugonia", 7.5, 2025),
                new Movie("Pegasus 3", 7.2, 2026),
                new Movie("The Super Mario Galaxy Movie", 7.9, 2026),
                new Movie("The Drama", 7.8, 2025),
                new Movie("Crime 101", 8.0, 2026)
        );

        System.out.println("TOP 5 TRENDING MOVIES (2025+)");
        List<Movie> top5 = movies.stream()
                .filter(movie -> movie.year >= 2025)
                .sorted((m1, m2) -> Double.compare(m2.rating, m1.rating))
                .limit(5)
                .collect(Collectors.toList());

        top5.forEach(System.out::println);

        System.out.println("\n TOP 5 (Comparator method ref) ");
        movies.stream()
                .filter(m -> m.year >= 2025)
                .sorted(Comparator.comparingDouble(Movie::getRating).reversed())
                .limit(5)
                .forEach(System.out::println);
    }
}
