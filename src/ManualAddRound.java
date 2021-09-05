import java.io.*;
import java.util.*;

public class ManualAddRound{




public static void manualAdd(int affTeam, int negTeam, double score) throws Exception{
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
    teamList.get(affTeam).calculateEloAny(teamList.get(negTeam), score);
    FileWriter frwiter = new FileWriter("/Users/zacharyklein/eloDebateRankings/Teams.txt");
    BufferedWriter bufwriter = new BufferedWriter(frwiter);
    for (debateTeam teams : teamList) {
        bufwriter.append(teams.getName() + "\n");
    }
    bufwriter.flush();
    FileWriter frwiter2 = new FileWriter("/Users/zacharyklein/eloDebateRankings/TeamStats.txt");
    BufferedWriter bufwriter2 = new BufferedWriter(frwiter2);
    for (debateTeam teams : teamList) {
        // System.out.println(teams.getName() + " " + teams.getLong());
        bufwriter2.append(teams.getLong() + "\n");
    }

    FileWriter frwiter3 = new FileWriter("/Users/zacharyklein/eloDebateRankings/TeamStatsElo.txt");
    BufferedWriter bufwriter3 = new BufferedWriter(frwiter3);
    FileWriter frwiter4 = new FileWriter("/Users/zacharyklein/eloDebateRankings/TeamStatsAffElo.txt");
    BufferedWriter bufwriter4 = new BufferedWriter(frwiter4);
    FileWriter frwiter5 = new FileWriter("/Users/zacharyklein/eloDebateRankings/TeamStatsNegElo.txt");
    BufferedWriter bufwriter5 = new BufferedWriter(frwiter5);
    FileWriter frwiter6 = new FileWriter("/Users/zacharyklein/eloDebateRankings/TeamStatsGamesPlayed.txt");
    BufferedWriter bufwriter6 = new BufferedWriter(frwiter6);
    FileWriter frwiter8 = new FileWriter("/Users/zacharyklein/eloDebateRankings/TeamsByes.txt");
    BufferedWriter bufwriter8 = new BufferedWriter(frwiter8);
    FileWriter frwiter9 = new FileWriter("/Users/zacharyklein/eloDebateRankings/TeamsElimRound.txt");
    BufferedWriter bufwriter9 = new BufferedWriter(frwiter9);
    for (debateTeam teams : teamList) {
        // System.out.println(teams.getName() + " " + teams.getLong());
        bufwriter3.append(teams.getElo() + "\n");
    }
    for (debateTeam teams : teamList) {
        // System.out.println(teams.getName() + " " + teams.getLong());
        bufwriter4.append(teams.getAffElo() + "\n");
    }
    for (debateTeam teams : teamList) {
        // System.out.println(teams.getName() + " " + teams.getLong());
        bufwriter5.append(teams.getNegElo() + "\n");
    }
    for (debateTeam teams : teamList) {
        // System.out.println(teams.getName() + " " + teams.getLong());
        bufwriter6.append(teams.getGamesPlayed() + "\n");
    }
    for (debateTeam teams : teamList) {
        // System.out.println(teams.getName() + " " + teams.getLong());
        bufwriter8.append(teams.getByes() + "\n");
    }
    for (debateTeam teams : teamList) {
        // System.out.println(teams.getName() + " " + teams.getLong());
        bufwriter9.append(teams.getElimRounds() + "\n");
    }
    bufwriter.flush();
    bufwriter3.flush();
    bufwriter4.flush();
    bufwriter5.flush();
    bufwriter6.flush();
    bufwriter8.flush();
    bufwriter9.flush();
}
}



