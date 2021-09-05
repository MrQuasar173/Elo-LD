import java.util.*;

public class NegEloComparator implements Comparator<debateTeam> {
    @Override
    public int compare(debateTeam o1, debateTeam o2) {
        if (o1.getNegElo() > o2.getNegElo()) {
            return 1;
        } else if (o1.getNegElo() == o2.getNegElo()) {
            return 0;
        } else {
            return -1;
        }
    }
}
