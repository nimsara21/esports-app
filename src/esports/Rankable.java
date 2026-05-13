package esports;

public interface Rankable {
    int getPoints();
    double getWinRate();
    String getRank();

    default String getLeaderboardEntry(){
        return getRank() + getPoints();
    }
}
