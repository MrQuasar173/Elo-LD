import java.util.*;

public class WinPercentageComparator implements Comparator<debateTeam> {
    @Override
    public int compare(debateTeam o1, debateTeam o2) {
        if (o1.getPercentage() > o2.getPercentage()) {
            return 1;
        } else if (o1.getPercentage() == o2.getPercentage()) {
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
