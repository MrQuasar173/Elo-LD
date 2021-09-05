import java.io.*;
import java.util.*;

public class PredictMatch {
    public static void main(String[] args) {
        try {
            ArrayList<debateTeam> teamList = new ArrayList<debateTeam>();
            FileReader freader = new FileReader("/Users/zacharyklein/eloDebateRankings/Teams.txt");
            BufferedReader bufreader = new BufferedReader(freader);
            FileReader freader2 = new FileReader("/Users/zacharyklein/eloDebateRankings/TeamStats.txt");
            BufferedReader bufreader2 = new BufferedReader(freader2);

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


            ArrayList<Double> teamStatsElo = new ArrayList<Double>();
            ArrayList<Double> teamStatsAffElo = new ArrayList<Double>();
            ArrayList<Double> teamStatsNegElo = new ArrayList<Double>();
            ArrayList<Integer> teamStatsGamesPlayed = new ArrayList<Integer>();
            ArrayList<Integer> teamStatsByes = new ArrayList<Integer>();
            ArrayList<Integer> teamStatsElimRounds = new ArrayList<Integer>();
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
            String line;
            int lineNumber = 0;
            while ((line = bufreader.readLine()) != null && lineNumber < teamStatsElo.size()) {
                if (!line.isEmpty()) {
                    teamList.add(new debateTeam(line, teamStatsElo.get(lineNumber), teamStatsAffElo.get(lineNumber), teamStatsNegElo.get(lineNumber), teamStatsGamesPlayed.get(lineNumber), teamStatsByes.get(lineNumber), teamStatsElimRounds.get(lineNumber)));
                }
                lineNumber++;
            }
            System.out.println(teamList.get(276).expected(teamList.get(281)));
            System.out.println(teamList.get(276).affExpected(teamList.get(281)));
            System.out.println(teamList.get(276).negExpected(teamList.get(281)));
            System.out.println(teamList.get(276));
            System.out.println(teamList.get(281));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
