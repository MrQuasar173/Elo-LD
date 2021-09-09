import java.util.*;
import java.io.*;

public class allTeams {
    private ArrayList<debateTeam> teamsEloSort = new ArrayList<debateTeam>();
    private ArrayList<debateTeam> teamsAffEloSort = new ArrayList<debateTeam>();
    private ArrayList<debateTeam> teamsNegEloSort = new ArrayList<debateTeam>();
    private ArrayList<debateTeam> teamsGamesPlayed = new ArrayList<debateTeam>();
    private ArrayList<debateTeam> teamsByes = new ArrayList<debateTeam>();
    private ArrayList<debateTeam> teamsElimRounds = new ArrayList<debateTeam>();
    private ArrayList<debateTeam> teamsWins = new ArrayList<debateTeam>();
    private ArrayList<debateTeam> teamsPercentage = new ArrayList<debateTeam>();
    private ArrayList<debateTeam> warning = new ArrayList<debateTeam>();
    private ArrayList<debateTeam> teamsForSum = new ArrayList<debateTeam>();
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public allTeams() {

        try {
            ArrayList<debateTeam> teams = new ArrayList<debateTeam>();
            ArrayList<Double> elos = new ArrayList<Double>();
            ArrayList<Double> affElos = new ArrayList<Double>();
            ArrayList<Double> negElos = new ArrayList<Double>();
            ArrayList<Integer> gamesPlayed = new ArrayList<Integer>();
            ArrayList<Integer> byes = new ArrayList<Integer>();
            ArrayList<Integer> elimRounds = new ArrayList<Integer>();
            ArrayList<Integer> wins = new ArrayList<Integer>();
            ArrayList<String> names = new ArrayList<String>();
            FileReader freader2 = new FileReader("/Users/zacharyklein/eloDebateRankings/Teams.txt");
            BufferedReader bufreader2 = new BufferedReader(freader2);
            FileReader freader3 = new FileReader("/Users/zacharyklein/eloDebateRankings/TeamStatsElo.txt");
            BufferedReader bufreader3 = new BufferedReader(freader3);
            FileReader freader4 = new FileReader("/Users/zacharyklein/eloDebateRankings/TeamStatsAffElo.txt");
            BufferedReader bufreader4 = new BufferedReader(freader4);
            FileReader freader5 = new FileReader("/Users/zacharyklein/eloDebateRankings/TeamStatsNegElo.txt");
            BufferedReader bufreader5 = new BufferedReader(freader5);
            FileReader freader6 = new FileReader("/Users/zacharyklein/eloDebateRankings/TeamStatsGamesPlayed.txt");
            BufferedReader bufreader6 = new BufferedReader(freader6);
            FileReader freader7 = new FileReader("/Users/zacharyklein/eloDebateRankings/TeamsByes.txt");
            BufferedReader bufreader7 = new BufferedReader(freader7);
            FileReader freader8 = new FileReader("/Users/zacharyklein/eloDebateRankings/TeamsElimRound.txt");
            BufferedReader bufreader8 = new BufferedReader(freader8);
            FileReader freader9 = new FileReader("/Users/zacharyklein/eloDebateRankings/TeamsWins.txt");
            BufferedReader bufreader9 = new BufferedReader(freader9);
            String line;
            while ((line = bufreader2.readLine()) != null) {
                if (!line.isEmpty()) {
                    names.add(line);
                }

            }
            while ((line = bufreader3.readLine()) != null) {
                if (!line.isEmpty()) {
                    elos.add(Double.parseDouble(line));
                }

            }
            while ((line = bufreader4.readLine()) != null) {
                if (!line.isEmpty()) {
                    affElos.add(Double.parseDouble(line));
                }

            }
            while ((line = bufreader5.readLine()) != null) {
                if (!line.isEmpty()) {
                    negElos.add(Double.parseDouble(line));
                }

            }
            while ((line = bufreader6.readLine()) != null) {
                if (!line.isEmpty()) {
                    gamesPlayed.add(Integer.parseInt(line));
                }

            }
            while ((line = bufreader7.readLine()) != null) {
                if (!line.isEmpty()) {
                    byes.add(Integer.parseInt(line));
                }

            }
            while ((line = bufreader8.readLine()) != null) {
                if (!line.isEmpty()) {
                    elimRounds.add(Integer.parseInt(line));
                }

            }
            while ((line = bufreader9.readLine()) != null) {
                if (!line.isEmpty()) {
                    wins.add(Integer.parseInt(line));
                }

            }
            for (int i = 0; i < elos.size(); i++) {
                teamsEloSort.add(new debateTeam(names.get(i), elos.get(i), affElos.get(i), negElos.get(i), gamesPlayed.get(i), byes.get(i), elimRounds.get(i), wins.get(i)));
                teamsNegEloSort.add(new debateTeam(names.get(i), elos.get(i), affElos.get(i), negElos.get(i), gamesPlayed.get(i), byes.get(i), elimRounds.get(i), wins.get(i)));
                teamsAffEloSort.add(new debateTeam(names.get(i), elos.get(i), affElos.get(i), negElos.get(i), gamesPlayed.get(i), byes.get(i), elimRounds.get(i), wins.get(i)));
                teamsGamesPlayed.add(new debateTeam(names.get(i), elos.get(i), affElos.get(i), negElos.get(i), gamesPlayed.get(i), byes.get(i), elimRounds.get(i), wins.get(i)));
                teamsElimRounds.add(new debateTeam(names.get(i), elos.get(i), affElos.get(i), negElos.get(i), gamesPlayed.get(i), byes.get(i), elimRounds.get(i),wins.get(i)));
                teamsByes.add(new debateTeam(names.get(i), elos.get(i), affElos.get(i), negElos.get(i), gamesPlayed.get(i), byes.get(i), elimRounds.get(i), wins.get(i)));
                teamsWins.add(new debateTeam(names.get(i), elos.get(i), affElos.get(i), negElos.get(i), gamesPlayed.get(i), byes.get(i), elimRounds.get(i), wins.get(i)));
                teamsPercentage.add(new debateTeam(names.get(i), elos.get(i), affElos.get(i), negElos.get(i), gamesPlayed.get(i), byes.get(i), elimRounds.get(i), wins.get(i)));
                warning.add(new debateTeam(names.get(i), elos.get(i), affElos.get(i), negElos.get(i), gamesPlayed.get(i), byes.get(i), elimRounds.get(i), wins.get(i)));
                teamsForSum.add(new debateTeam(names.get(i), elos.get(i), affElos.get(i), negElos.get(i), gamesPlayed.get(i), byes.get(i), elimRounds.get(i), wins.get(i)));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void remove(int x) {
        teamsEloSort.remove(x);
        teamsAffEloSort.remove(x);
        teamsNegEloSort.remove(x);
        teamsGamesPlayed.remove(x);
        teamsByes.remove(x);
        teamsElimRounds.remove(x);
        teamsWins.remove(x);
        warning.remove(x);
    }

    public void sortElo() {
        Collections.sort(teamsEloSort, new EloComparator());
        for (int i = teamsEloSort.size() - 1; i >= 0; i--) {
            int k = teamsEloSort.size() - i;
            if(!teamsEloSort.get(i).warning()) {
                System.out.println(k + ". " + teamsEloSort.get(i).toString());
            }else{
                System.out.println(ANSI_PURPLE + k + ". " + teamsEloSort.get(i).toString() + ANSI_RESET);
            }
        }
    }

    public void sortAffElo() {
        Collections.sort(teamsAffEloSort, new AffEloComparator());
        for (int i = teamsAffEloSort.size() - 1; i >= 0; i--) {
            int k = teamsAffEloSort.size() - i;
            if(!teamsAffEloSort.get(i).warning()) {
                System.out.println(k + ". " + teamsAffEloSort.get(i).toString());
            }else{
                System.out.println(ANSI_PURPLE + k + ". " + teamsAffEloSort.get(i).toString() + ANSI_RESET);
            }
        }
    }

    public void sortNegElo() {
        Collections.sort(teamsNegEloSort, new NegEloComparator());
        for (int i = teamsNegEloSort.size() - 1; i >= 0; i--) {
            int k = teamsNegEloSort.size() - i;
            if (!teamsNegEloSort.get(i).warning()) {
                System.out.println(k + ". " + teamsNegEloSort.get(i).toString());
            } else {
                System.out.println(ANSI_PURPLE + k + ". " + teamsNegEloSort.get(i).toString() + ANSI_RESET);
            }
        }
    }

    public void sortGamesPlayed() {
        Collections.sort(teamsGamesPlayed, new GamesPlayedComparator());
        for (int i = teamsGamesPlayed.size() - 1; i >= 0; i--) {
            int k = teamsGamesPlayed.size() - i;
            if (!teamsGamesPlayed.get(i).warning()) {
                System.out.println(k + ". " + teamsGamesPlayed.get(i).toString());
            } else {
                System.out.println(ANSI_PURPLE + k + ". " + teamsGamesPlayed.get(i).toString() + ANSI_RESET);
            }
        }
    }

    public void sortByes() {
        Collections.sort(teamsByes, new ByesComparator());
        for (int i = teamsByes.size() - 1; i >= 0; i--) {
            int k = teamsByes.size() - i;
            if(!teamsByes.get(i).warning()) {
                System.out.println(k + ". " + teamsByes.get(i).toString());
            }else{
                System.out.println(ANSI_PURPLE + k + ". " + teamsByes.get(i).toString() + ANSI_RESET);
            }
        }
    }
    public void sortElimRounds(){
        Collections.sort(teamsElimRounds, new ElimRoundComparator());
        for (int i = teamsElimRounds.size() - 1; i >= 0; i--) {
            int k = teamsElimRounds.size() - i;
            if(!teamsElimRounds.get(i).warning()) {
                System.out.println(k + ". " + teamsElimRounds.get(i).toString());
            }else{
                System.out.println(ANSI_PURPLE + k + ". " + teamsElimRounds.get(i).toString() + ANSI_RESET);
            }
        }
    }
    public void sortWins(){
        Collections.sort(teamsWins, new WinsComparator());
        for (int i = teamsWins.size() - 1; i >= 0; i--) {
            int k = teamsWins.size() - i;
            if(!teamsWins.get(i).warning()) {
                System.out.println(k + ". " + teamsWins.get(i).toString());
            }else{
                System.out.println(ANSI_PURPLE + k + ". " + teamsWins.get(i).toString() + ANSI_RESET);
            }
        }
    }
    public void sortPercentage(){
        Collections.sort(teamsPercentage, new WinPercentageComparator());
        for (int i = teamsPercentage.size() - 1; i >= 0; i--) {
            int k = teamsPercentage.size() - i;
            if(!teamsPercentage.get(i).warning()) {
                System.out.println(k + ". " + teamsPercentage.get(i).toString());
            }else{
                System.out.println(ANSI_PURPLE + k + ". " + teamsPercentage.get(i).toString() + ANSI_RESET);
            }
        }
    }

    public void warningTeams() {
        for (debateTeam team : warning) {
            if (team.warning()) {
                System.out.println(team);
            }
        }
    }
    public void sumGamesPlayed(){
        int sum = 0;
        for(debateTeam team : teamsForSum){
            sum+= team.getGamesPlayed();

        }
        System.out.println(sum);
    }

    public void probabilityOfWinning() {

    }


}
