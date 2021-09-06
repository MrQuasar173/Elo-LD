import java.util.*;
import java.io.*;

public class CertainSchoolSorting {
    public static void main(String[] args) {
        try {
            ArrayList<String> schools = new ArrayList<String>();
            schools.add("Rowland Hall");
            schools.add("Peninsula");


            ArrayList<debateTeam> teamList = new ArrayList<debateTeam>();
            ArrayList<debateTeam> teamList2 = new ArrayList<debateTeam>();
            ArrayList<debateTeam> teamListReturn = new ArrayList<debateTeam>();
            ArrayList<Integer> keeper = new ArrayList<Integer>();
            FileReader freader = new FileReader("/Users/zacharyklein/eloDebateRankings/Teams.txt");
            BufferedReader bufreader = new BufferedReader(freader);


            FileReader freader3 = new FileReader("/Users/zacharyklein/eloDebateRankings/TeamStatsElo.txt");
            BufferedReader bufreader3 = new BufferedReader(freader3);
            FileReader freader4 = new FileReader("/Users/zacharyklein/eloDebateRankings/TeamStatsAffElo.txt");
            BufferedReader bufreader4 = new BufferedReader(freader4);
            FileReader freader5 = new FileReader("/Users/zacharyklein/eloDebateRankings/TeamStatsNegElo.txt");
            BufferedReader bufreader5 = new BufferedReader(freader5);
            FileReader freader6 = new FileReader("/Users/zacharyklein/eloDebateRankings/TeamStatsGamesPlayed.txt");
            BufferedReader bufreader6 = new BufferedReader(freader6);
            FileReader freader8 = new FileReader("/Users/zacharyklein/eloDebateRankings/TeamsByes.txt");
            BufferedReader bufreader8 = new BufferedReader(freader8);
            FileReader freader9 = new FileReader("/Users/zacharyklein/eloDebateRankings/TeamsElimRound.txt");
            BufferedReader bufreader9 = new BufferedReader(freader9);
            FileReader freader10 = new FileReader("/Users/zacharyklein/eloDebateRankings/TeamsWins.txt");
            BufferedReader bufreader10 = new BufferedReader(freader10);



            ArrayList<Double> teamStatsElo = new ArrayList<Double>();
            ArrayList<Double> teamStatsAffElo = new ArrayList<Double>();
            ArrayList<Double> teamStatsNegElo = new ArrayList<Double>();
            ArrayList<Integer> teamStatsGamesPlayed = new ArrayList<Integer>();
            ArrayList<Integer> teamStatsByes = new ArrayList<Integer>();
            ArrayList<Integer> teamStatsElimRounds = new ArrayList<Integer>();
            ArrayList<Integer> teamStatsWins = new ArrayList<Integer>();
            String nextLine;

            while ((nextLine = bufreader3.readLine()) != null) {
                if (!nextLine.isEmpty()) {
                    teamStatsElo.add(Double.parseDouble(nextLine));
                }

            }
            while ((nextLine = bufreader4.readLine()) != null) {
                if (!nextLine.isEmpty()) {
                    teamStatsAffElo.add(Double.parseDouble(nextLine));
                }

            }
            while ((nextLine = bufreader5.readLine()) != null) {
                if (!nextLine.isEmpty()) {
                    teamStatsNegElo.add(Double.parseDouble(nextLine));
                }

            }
            while ((nextLine = bufreader6.readLine()) != null) {
                if (!nextLine.isEmpty()) {
                    teamStatsGamesPlayed.add(Integer.parseInt(nextLine));
                }

            }
            while ((nextLine = bufreader8.readLine()) != null) {
                if (!nextLine.isEmpty()) {
                    teamStatsByes.add(Integer.parseInt(nextLine));
                }

            }
            while ((nextLine = bufreader9.readLine()) != null) {
                if (!nextLine.isEmpty()) {
                    teamStatsElimRounds.add(Integer.parseInt(nextLine));
                }

            }
            while ((nextLine = bufreader10.readLine()) != null) {
                if (!nextLine.isEmpty()) {
                    teamStatsWins.add(Integer.parseInt(nextLine));
                }

            }
            String line;
            int lineNumber = 0;
            while ((line = bufreader.readLine()) != null && lineNumber < teamStatsElo.size()) {
                if (!line.isEmpty()) {
                    teamList.add(new debateTeam(line, teamStatsElo.get(lineNumber), teamStatsAffElo.get(lineNumber), teamStatsNegElo.get(lineNumber), teamStatsGamesPlayed.get(lineNumber), teamStatsByes.get(lineNumber), teamStatsElimRounds.get(lineNumber),teamStatsWins.get(lineNumber)));
                }
                lineNumber++;
            }
            for (int i = 0; i < teamList.size(); i++) {
                for (int k = 0; k < schools.size(); k++) {
                    if (teamList.get(i).getSchool().equals(schools.get(k))) {
                        keeper.add(i);
                    }
                }
            }
            allTeams listyy = new allTeams();
            for (int i = teamList.size() - 1; i >= 0; i--) {
                int end = 0;
                for (int k = 0; k < keeper.size(); k++) {
                    if (i == keeper.get(k)) {
                        end = 1;
                    }
                }
                if (end == 0) {
                    listyy.remove(i);
                }
            }
            listyy.sortElo();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
