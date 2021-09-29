import java.io.*;
import java.util.*;

public class TeamListCreator {
    public static void main(String[] args) throws Exception {
        for (int k = 200; k <= 246; k++) {
            if (k == 161) {
                continue;
            }

            Scanner sc = new Scanner(new File("/Users/zacharyklein/eloDebateRankings/mytable (" + k + ").csv"));
            String tournament = "Alta";
            ArrayList<debateRound> matches = new ArrayList<debateRound>();
            ArrayList<debateTeam> teamList = new ArrayList<debateTeam>();
            FileReader freader = new FileReader("/Users/zacharyklein/eloDebateRankings/Teams.txt");
            BufferedReader bufreader = new BufferedReader(freader);

            ArrayList<Double> teamStatsElo = new ArrayList<Double>();
            ArrayList<Double> teamStatsAffElo = new ArrayList<Double>();
            ArrayList<Double> teamStatsNegElo = new ArrayList<Double>();
            ArrayList<Integer> teamStatsGamesPlayed = new ArrayList<Integer>();
            ArrayList<Integer> teamStatsByes = new ArrayList<Integer>();
            ArrayList<Integer> teamStatsElimRounds = new ArrayList<Integer>();
            ArrayList<Integer> teamStatsWins = new ArrayList<Integer>();





            String line;
            int lineNumber = 0;
            while ((line = bufreader.readLine()) != null ) {
                if (!line.isEmpty()) {
                    teamList.add(new debateTeam(line));
                }
                lineNumber++;
            }

            sc.useDelimiter(",");   //sets the delimiter pattern
            int count = 1;


            int affTeam = 0;
            int negTeam = 0;
            boolean affWins = false;
            while (sc.hasNext())  //returns a boolean value
            {
                String info = sc.next();
                if (count <= 6) {
                } else if (count % 6 == 1) {
                    int x = 0;
                    for (int i = 0; i < teamList.size(); i++) {
                        if (teamList.get(i).equals(new debateTeam(info)) && !teamList.get(i).equals(new debateTeam("Berkeley Prep  S2"))) {

                            affTeam = i;
                            x++;
                        }
                    }
                    int y = 0;
                    if (x == 0) {
                        if((new debateTeam(info)).equals(new debateTeam("Berkeley Prep  S2"))){
                            for(int d = 0; d < teamList.size(); d++){
                                if(teamList.get(d).equals(new debateTeam("Berkeley Prep SS"))){
                                    y++;
                                }
                            }
                            if(y==0){
                                teamList.add(new debateTeam("Berkeley Prep SS"));
                            }

                        } else {
                            affTeam = teamList.size();
                            teamList.add(new debateTeam(info));
                            System.out.println(info);
                        }
                    }


                } else if (count % 6 == 2) {

                    int x = 0;
                    for (int i = 0; i < teamList.size(); i++) {
                        if (teamList.get(i).equals(new debateTeam(info)) ) {
                            negTeam = i;
                            x++;
                        }
                    }

                    int y = 0;
                    if (x == 0) {
                        if((new debateTeam(info)).equals(new debateTeam("Berkeley Prep  S2"))){
                            for(int d = 0; d < teamList.size(); d++){
                                if(teamList.get(d).equals(new debateTeam("Berkeley Prep SS"))){
                                    y++;
                                }
                            }
                            if(y==0){
                                teamList.add(new debateTeam("Berkeley Prep SS"));
                            }

                        } else {
                            negTeam = teamList.size();
                            teamList.add(new debateTeam(info));
                            System.out.println(info);
                        }
                    }
                } else if (count % 6 == 3) {

                } else if (count % 6 == 4) {


                } else if (count % 6 == 0) {

                }

                count++;

            }


            sc.close();


            FileWriter frwiter = new FileWriter("/Users/zacharyklein/eloDebateRankings/Teams.txt");
            BufferedWriter bufwriter = new BufferedWriter(frwiter);
            if(k==240) {
                teamList.add(new debateTeam("Berkeley Prep  S2"));
            }
            for (debateTeam teams : teamList) {
                bufwriter.append(teams.getName() + "\n");
            }
            bufwriter.flush();

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
            FileWriter frwiter10 = new FileWriter("/Users/zacharyklein/eloDebateRankings/TeamsWins.txt");
            BufferedWriter bufwriter10 = new BufferedWriter(frwiter10);


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
            for (debateTeam teams : teamList) {
                // System.out.println(teams.getName() + " " + teams.getLong());
                bufwriter10.append(teams.getWins() + "\n");
            }

            bufwriter3.flush();
            bufwriter4.flush();
            bufwriter5.flush();
            bufwriter6.flush();
            bufwriter8.flush();
            bufwriter9.flush();
            bufwriter10.flush();


        }


    }

}




