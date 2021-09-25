import java.util.*;

public class ElimRoundComparator implements Comparator<debateTeam> {
    @Override
    public int compare(debateTeam o1, debateTeam o2) {
        if (o1.getElimRounds() > o2.getElimRounds()) {
            return 1;
        } else if (o1.getElimRounds() == o2.getElimRounds()) {
            if(o1.getElo() > o2.getElo()){
                return 1;
            } else if(o1.getElo() == o2.getElo()){
                return 0;
            } else{
                return -1;
            }
        } else {
            return -1;
        }
    }
}
