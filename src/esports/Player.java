package esports;

import java.util.Objects;

public class Player {
    private String id;
    private String username;
    private GameTitle gameTitle;
    private int eloRating;
    private PlayerStats stats;
    private static int playerCount = 0;


    public Player() {
        this("Unknown", GameTitle.CS2);
    }

    public Player(String username, GameTitle gameTitle) {
        playerCount++;
        this.id = "P" + playerCount;
        this.username = username;
        this.gameTitle = gameTitle;
        this.eloRating = 1000;
        this.stats = new PlayerStats();
    }

    public Player(Player other) {
        this.id = other.id;
        this.username = other.username;
        this.gameTitle = other.gameTitle;
        this.eloRating = other.eloRating;
        this.stats = new PlayerStats(other.stats);
        playerCount++;
    }

    public static int getPlayerCount() {
        return playerCount;
    }

    public String getId() { return id; }
    public String getUsername() { return username; }
    public GameTitle getGameTitle() { return gameTitle; }
    public int getEloRating() { return eloRating; }
    public PlayerStats getStats() { return stats; }


    public void setEloRating(int eloRating) { this.eloRating = Math.max(0, eloRating); }

    public void recordMatchResult(int kills, int deaths, int assists, boolean won) {
        stats.recordMatch(kills, deaths, assists, won);
        setEloRating(eloRating + (won ? 25 : -20));  // one line, always uses the setter
    }

    public void printProfile() {
        System.out.println("===== Player Profile =====");
        System.out.println("ID         : " + id);
        System.out.println("Username   : " + username);
        System.out.println("Game       : " + gameTitle.getDisplayName());
        System.out.println("ELO Rating : " + eloRating);
        System.out.println("KDA        : " + String.format("%.2f", stats.getKDA()));
        System.out.println("Wins       : " + stats.getWins());
        System.out.println("Losses     : " + stats.getLosses());
        System.out.println("==========================");
    }

    @Override
    public String toString() {
        return String.format("Player[id=%s, username=%s, game=%s, elo=%d, KDA=%.2f]",
                id, username, gameTitle.getDisplayName(), eloRating, stats.getKDA());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Player)) return false;
        Player other = (Player) o;
        return Objects.equals(id, other.id); // two players are equal if they share the same ID
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}