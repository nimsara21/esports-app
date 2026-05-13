package esports;

public interface Matchable {

    String getId();
    String getUsername();
    int getEloRating();
    boolean isEligible();
}
