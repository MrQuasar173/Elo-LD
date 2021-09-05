import java.util.*;

public class AffEloComparator implements Comparator<debateTeam> {
    @Override
    public int compare(debateTeam o1, debateTeam o2) {
        if (o1.getAffElo() > o2.getAffElo()) {
            return 1;
        } else if (o1.getAffElo() == o2.getAffElo()) {
            return 0;
        } else {
            return -1;
        }
    }
}
