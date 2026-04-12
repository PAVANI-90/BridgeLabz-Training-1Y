package com.gla.GenericsAndCollections.JavaCollection.ScenarioBased;
import java.util.*;
class Team {
    private String name;
    private int points;

    public Team(String name) {
        this.name = name;
        this.points = 0;
    }

    public String getName() { return name; }
    public int getPoints() { return points; }

    public void addPoints(int p) {
        this.points += p;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Team)) return false;
        Team t = (Team) o;
        return name.equals(t.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return "Team{" + name + ", points=" + points + "}";
    }
}

class Match {
    private Team home;
    private Team away;

    public Match(Team home, Team away) {
        this.home = home;
        this.away = away;
    }

    public Team getHome() { return home; }
    public Team getAway() { return away; }

    @Override
    public String toString() {
        return "Match{" + home.getName() + " vs " + away.getName() + "}";
    }
}

class Result {
    private Match match;
    private Team winner;
    private Team loser;
    private int homeScore;
    private int awayScore;

    public Result(Match match, Team winner, Team loser, int homeScore, int awayScore) {
        this.match = match;
        this.winner = winner;
        this.loser = loser;
        this.homeScore = homeScore;
        this.awayScore = awayScore;
    }

    public Match getMatch() { return match; }
    public Team getWinner() { return winner; }
    public Team getLoser() { return loser; }
    public int getHomeScore() { return homeScore; }
    public int getAwayScore() { return awayScore; }

    @Override
    public String toString() {
        return "Result{" + match + ", " +
                winner.getName() + " beat " + loser.getName() +
                " " + homeScore + "-" + awayScore + "}";
    }
}
public class SportsTournamentScheduler {
    private Set<Team> teams;
    private Queue<Match> matchQueue;
    private List<Result> results;
    private TreeSet<Team> leaderboard;

    public SportsTournamentScheduler() {
        this.teams = new HashSet<>();
        this.matchQueue = new LinkedList<>();
        this.results = new ArrayList<>();
        this.leaderboard = new TreeSet<>(
                (t1, t2) -> {
                    int cmp = Integer.compare(t2.getPoints(), t1.getPoints());
                    if (cmp != 0) return cmp;
                    return t1.getName().compareTo(t2.getName());
                }
        );
    }

    public boolean registerTeam(Team t) {
        boolean added = teams.add(t);
        if (added) {
            leaderboard.add(t);
            System.out.println("Registered team: " + t.getName());
        } else {
            System.out.println("Duplicate team ignored: " + t.getName());
        }
        return added;
    }

    public void scheduleMatch(Team home, Team away) {
        if (!teams.contains(home) || !teams.contains(away)) {
            System.out.println("Both teams must be registered to schedule a match.");
            return;
        }
        Match m = new Match(home, away);
        matchQueue.add(m);
        System.out.println("Scheduled: " + m);
    }

    public void processNextMatch() {
        if (matchQueue.isEmpty()) {
            System.out.println("No matches to process.");
            return;
        }
        Match m = matchQueue.poll();
        System.out.println("\nProcessing match: " + m);

        Random rand = new Random();
        int homeScore = rand.nextInt(5);
        int awayScore = rand.nextInt(5);

        Team winner;
        Team loser;
        if (homeScore > awayScore) {
            winner = m.getHome();
            loser = m.getAway();
        } else if (awayScore > homeScore) {
            winner = m.getAway();
            loser = m.getHome();
        } else {
            winner = null;
            loser = null;
        }

        if (winner != null) {
            updatePoints(winner, 3);
            Result r = new Result(m, winner, loser, homeScore, awayScore);
            results.add(r);
            System.out.println("Result recorded: " + r);
        } else {
            m.getHome().addPoints(1);
            m.getAway().addPoints(1);
            leaderboard.remove(m.getHome());
            leaderboard.remove(m.getAway());
            leaderboard.add(m.getHome());
            leaderboard.add(m.getAway());
            System.out.println("Draw: " + m.getHome().getName() + " " + homeScore +
                    "-" + awayScore + " " + m.getAway().getName());
        }
    }

    private void updatePoints(Team winner, int points) {
        leaderboard.remove(winner);
        winner.addPoints(points);
        leaderboard.add(winner);
    }

    public void printResults() {
        System.out.println("\n Match Results ");
        for (Result r : results) {
            System.out.println(r);
        }
    }

    public void printLeaderboard() {
        System.out.println("\n Leaderboard ");
        int rank = 1;
        for (Team t : leaderboard) {
            System.out.println(rank + ". " + t.getName() + " - " + t.getPoints() + " pts");
            rank++;
        }
    }

    public static void main(String[] args) {
        SportsTournamentScheduler scheduler = new SportsTournamentScheduler();

        Team t1 = new Team("Lions");
        Team t2 = new Team("Tigers");
        Team t3 = new Team("Bulls");

        scheduler.registerTeam(t1);
        scheduler.registerTeam(t2);
        scheduler.registerTeam(t3);
        scheduler.registerTeam(new Team("Lions"));

        scheduler.scheduleMatch(t1, t2);
        scheduler.scheduleMatch(t2, t3);
        scheduler.scheduleMatch(t1, t3);

        scheduler.processNextMatch();
        scheduler.printLeaderboard();

        scheduler.processNextMatch();
        scheduler.printLeaderboard();

        scheduler.processNextMatch();
        scheduler.printLeaderboard();

        scheduler.printResults();
    }
}
