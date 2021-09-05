import java.util.*;
import java.io.*;

public class TournamentQualityEntryList {
    public static void main(String[] args) {
        try {
            ArrayList<debateTeam> teamList = new ArrayList<debateTeam>();
            ArrayList<debateTeam> teamList2 = new ArrayList<debateTeam>();
            ArrayList<debateTeam> teamListReturn = new ArrayList<debateTeam>();
            ArrayList<Integer> keeper = new ArrayList<Integer>();
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
            Scanner sc = new Scanner(new File("/Users/zacharyklein/eloDebateRankings/mytable (164).csv"));
            sc.useDelimiter(",");
            int count = 0;
            int team = 0;
            while (sc.hasNext()) {
                count++;
                String info = sc.next();
                if (count < 4) {

                } else if (count % 4 == 0) {
                    int x = 0;
                    for (int i = 0; i < teamList.size(); i++) {
                        if (teamList.get(i).equals(new debateTeam(info))) {
                            team = i;
                            keeper.add(team);
                            x++;
                        }
                    }
                    if (x == 0) {
                        team = teamList.size();
                        teamList2.add(new debateTeam(info));
                        System.out.println(info);
                    } else {
                        teamList2.add(new debateTeam(info, teamStatsElo.get(team), teamStatsAffElo.get(team), teamStatsNegElo.get(team), teamStatsGamesPlayed.get(team), teamStatsByes.get(team), teamStatsElimRounds.get(team)));
                        teamListReturn.add(new debateTeam(info, teamStatsElo.get(team), teamStatsAffElo.get(team), teamStatsNegElo.get(team), teamStatsGamesPlayed.get(team), teamStatsByes.get(team), teamStatsElimRounds.get(team)));

                    }
                }
            }


            allTeams list = new allTeams();
            for (int i = teamList.size() - 1; i >= 0; i--) {
                int end = 0;
                for (int k = 0; k < keeper.size(); k++) {
                    if (i == keeper.get(k)) {
                        end = 1;
                    }
                }
                if (end == 0) {
                    list.remove(i);
                }
            }
            double sum = 0;
            for (debateTeam teamer : teamList2) {
                sum += teamer.getElo();
            }
            double sum2 = 0;
            for (debateTeam teamer2 : teamListReturn) {
                sum2 += teamer2.getElo();
            }
            System.out.println("Average Elo: " + sum / teamList2.size());
            System.out.println("Average Returner Elo: " + sum2 / teamListReturn.size());
            list.sortElimRounds();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
