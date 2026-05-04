package esports;

public class PlayerStats {
    private int kills;
    private int deaths;
    private int assists;
    private int matchesPlayed;
    private int wins;

    public PlayerStats() {
        this(0, 0, 0);  // constructor chaining — calls the one below
    }

    public PlayerStats(int kills, int deaths, int assists) {
        this.kills = kills;
        this.deaths = deaths;
        this.assists = assists;
        this.matchesPlayed = 0;
        this.wins = 0;
    }

    public int getKills() {
        return kills;
    }

    public int getDeaths() {
        return deaths;
    }

    public int getAssists() {
        return assists;
    }

    public int getMatchesPlayed() {
        return matchesPlayed;
    }

    public int getWins() {
        return wins;
    }

    void recordMatch(int kills, int deaths, int assists, boolean win) {
        this.kills += kills;
        this.deaths += deaths;
        this.assists += assists;
        if (win) {
            wins++;
        }
        matchesPlayed++;
    }

    double getKDA() {
        return (kills + assists) / Math.max(deaths, 1.0);
    }

    double getWinRate() {
        if (matchesPlayed == 0) return 0.0;
        return (double) wins / matchesPlayed * 100;  // also — should be a percentage (0–100)
    }

    @Override
    public String toString() {
        return String.format("Stats[KDA=%.2f, WinRate=%.1f%%, Matches=%d]",
                getKDA(), getWinRate(), matchesPlayed);
    }
}
