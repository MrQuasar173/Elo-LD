import java.util.*;

public class ByesComparator implements Comparator<debateTeam> {
    @Override
    public int compare(debateTeam o1, debateTeam o2) {
        if (o1.getByes() > o2.getByes()) {
            return 1;
        } else if (o1.getByes() == o2.getByes()) {
            return 0;
        } else {
            return -1;
        }
    }
}
