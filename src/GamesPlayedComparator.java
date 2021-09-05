import java.util.Comparator;

public class GamesPlayedComparator implements Comparator<debateTeam> {
    @Override
    public int compare(debateTeam o1, debateTeam o2) {
        if (o1.getGamesPlayed() > o2.getGamesPlayed()) {
            return 1;
        } else if (o1.getGamesPlayed() == o2.getGamesPlayed()) {
            return 0;
        } else {
            return -1;
        }
    }
}
