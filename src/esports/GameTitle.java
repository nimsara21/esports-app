package esports;

public enum GameTitle {
    VALORANT("Valorant", 5),
    CS2("Counter-Strike 2", 5),
    LEAGUE_OF_LEGENDS("League of Legends", 5),
    DOTA2("Dota 2", 5),
    ROCKET_LEAGUE("Rocket League", 3);

    private final String displayName;
    private final int maxPlayers;

    private GameTitle(String displayName, int maxPlayers) {
        this.displayName = displayName;
        this.maxPlayers = maxPlayers;
    }
    public String getDisplayName() {
        return displayName;
    }
    public int getMaxPlayers() {
        return maxPlayers;
    }

    @Override
    public String toString() {
        return displayName;
    }
}
