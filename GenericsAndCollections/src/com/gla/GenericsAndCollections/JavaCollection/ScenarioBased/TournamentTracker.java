package com.gla.GenericsAndCollections.JavaCollection.ScenarioBased;
import java.util.*;
class Player {
    private String id;
    private String name;

    public Player(String id, String name) {
        this.id   = id;
        this.name = name;
    }

    public String getId()   { return id; }
    public String getName() { return name; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Player)) return false;
        Player p = (Player) o;
        return id.equals(p.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "Player{" + id + ", " + name + "}";
    }
}

class Match {
    private Player player1;
    private Player player2;

    public Match(Player p1, Player p2) {
        this.player1 = p1;
        this.player2 = p2;
    }

    public Player getPlayer1() { return player1; }
    public Player getPlayer2() { return player2; }

    @Override
    public String toString() {
        return "Match{" + player1.getName() + " vs " + player2.getName() + "}";
    }
}

class Result {
    private Match match;
    private Player winner;
    private Player loser;
    private int winnerScore;

    public Result(Match match, Player winner, Player loser, int winnerScore) {
        this.match       = match;
        this.winner      = winner;
        this.loser       = loser;
        this.winnerScore = winnerScore;
    }

    public Match getMatch()       { return match; }
    public Player getWinner()     { return winner; }
    public Player getLoser()      { return loser; }
    public int getWinnerScore()   { return winnerScore; }

    @Override
    public String toString() {
        return "Result{" + winner.getName() + " beat " +
                loser.getName() + " +" + winnerScore + " pts}";
    }
}

// Used for leaderboard
class Score {
    private Player player;
    private int totalScore;

    public Score(Player player, int totalScore) {
        this.player = player;
        this.totalScore = totalScore;
    }

    public Player getPlayer()   { return player; }
    public int getTotalScore()  { return totalScore; }

    public void addScore(int s) {
        this.totalScore += s;
    }

    @Override
    public String toString() {
        return player.getName() + " : " + totalScore;
    }
}
public class TournamentTracker {
    private Set<Player> players;

    private Queue<Match> matchQueue;

    private List<Result> results;

    private TreeSet<Score> leaderboard;

    private Map<Player, Score> scoreMap;

    public TournamentTracker() {
        this.players    = new HashSet<>();
        this.matchQueue = new LinkedList<>();
        this.results    = new ArrayList<>();
        this.leaderboard = new TreeSet<>(
                (s1, s2) -> {
                    // Sort by totalScore DESC, then by player name to break ties
                    int cmp = Integer.compare(s2.getTotalScore(), s1.getTotalScore());
                    if (cmp != 0) return cmp;
                    return s1.getPlayer().getName().compareTo(s2.getPlayer().getName());
                }
        );
        this.scoreMap   = new HashMap<>();
    }

    public boolean registerPlayer(Player p) {
        boolean added = players.add(p);
        if (added) {
            // Initialize score entry
            Score score = new Score(p, 0);
            leaderboard.add(score);
            scoreMap.put(p, score);
            System.out.println("Registered player: " + p);
        } else {
            System.out.println("Duplicate player ignored: " + p);
        }
        return added;
    }

    public void scheduleMatch(Player p1, Player p2) {
        if (!players.contains(p1) || !players.contains(p2)) {
            System.out.println("Both players must be registered to schedule a match.");
            return;
        }
        Match m = new Match(p1, p2);
        matchQueue.add(m);
        System.out.println("Scheduled: " + m);
    }

    public void processNextMatch() {
        if (matchQueue.isEmpty()) {
            System.out.println("No upcoming matches.");
            return;
        }

        Match m = matchQueue.poll();
        System.out.println("\nProcessing match: " + m);

        Player winner = Math.random() > 0.5 ? m.getPlayer1() : m.getPlayer2();
        Player loser  = (winner == m.getPlayer1()) ? m.getPlayer2() : m.getPlayer1();
        int points = 3;

        recordResult(m, winner, loser, points);
    }

    private void recordResult(Match m, Player winner, Player loser, int points) {
        Result r = new Result(m, winner, loser, points);
        results.add(r);
        System.out.println("Result recorded: " + r);


        Score s = scoreMap.get(winner);
        leaderboard.remove(s);
        s.addScore(points);
        leaderboard.add(s);
    }


    public void printLeaderboard() {
        System.out.println("\n Live Leaderboard ");
        int rank = 1;
        for (Score s : leaderboard) {
            System.out.println(rank + ". " + s);
            rank++;
        }
    }

    public void printResults() {
        System.out.println("\n Match Results ");
        for (Result r : results) {
            System.out.println(r);
        }
    }

    public static void main(String[] args) {
        TournamentTracker tracker = new TournamentTracker();

        Player p1 = new Player("P1", "Amit");
        Player p2 = new Player("P2", "Priya");
        Player p3 = new Player("P3", "Rahul");

        tracker.registerPlayer(p1);
        tracker.registerPlayer(p2);
        tracker.registerPlayer(p3);
        tracker.registerPlayer(new Player("P1", "Amit Duplicate")); // duplicate

        tracker.scheduleMatch(p1, p2);
        tracker.scheduleMatch(p2, p3);
        tracker.scheduleMatch(p1, p3);


        tracker.processNextMatch();
        tracker.printLeaderboard();

        tracker.processNextMatch();
        tracker.printLeaderboard();

        tracker.processNextMatch();
        tracker.printLeaderboard();


        tracker.printResults();
    }
}
