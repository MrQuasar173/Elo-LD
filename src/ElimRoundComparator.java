import java.util.*;

public class ElimRoundComparator implements Comparator<debateTeam> {
    @Override
    public int compare(debateTeam o1, debateTeam o2) {
        if (o1.getElimRounds() > o2.getElimRounds()) {
            return 1;
        } else if (o1.getElimRounds() == o2.getElimRounds()) {
            return 0;
        } else {
            return -1;
        }
    }
}
