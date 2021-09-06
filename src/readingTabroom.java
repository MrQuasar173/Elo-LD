import java.io.*;
import java.util.*;

public class readingTabroom {
    public static void main(String[] args) {

        for (int k = 150; k <= 178; k++) {
            if (k == 161 || k==164 || k==171 || k==172) {
                continue;
            }
            try {
                Scanner sc = new Scanner(new File("/Users/zacharyklein/eloDebateRankings/mytable (" + k + ").csv"));
                String tournament = "Alta";
                ArrayList<debateRound> matches = new ArrayList<debateRound>();
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
                FileReader freader10 = new FileReader("/Users/zacharyklein/eloDebateRankings/TeamsWins.txt");
                BufferedReader bufreader10 = new BufferedReader(freader10);
                Scanner sc2 = new Scanner(new File("/Users/zacharyklein/eloDebateRankings/allMatches.txt"));
                sc2.useDelimiter(",");   //sets the delimiter pattern
            /*
            Teams stats number can be decoded in the following way (makes the assumption that all elos stay as less than 10000:
            value = elo + 10000 * affElo + 100000000 * negElo + 1000000000000 * gamesPlayed
             */
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

                int counter = 0;
                String affSchool = "";
                String negSchool = "";
                boolean affWins2 = false;
                while (sc2.hasNext()) {

                    String get = sc2.next();
                    if (counter % 4 == 0) {
                        affSchool = get;
                    } else if (counter % 4 == 1) {
                        negSchool = get;
                    } else if (counter % 4 == 2) {
                        if (get.substring(0, 3).toLowerCase().equals("aff")) {
                            affWins2 = true;
                        } else {
                            affWins2 = false;
                        }
                    } else if (counter % 4 == 3) {
                        matches.add(new debateRound(new debateTeam(affSchool), new debateTeam(negSchool), affWins2, get));
                    }
                    counter++;

                }

                sc2.close();

                String line;
                int lineNumber = 0;
                while ((line = bufreader.readLine()) != null && lineNumber < teamStatsElo.size()) {
                    if (!line.isEmpty()) {
                        teamList.add(new debateTeam(line, teamStatsElo.get(lineNumber), teamStatsAffElo.get(lineNumber), teamStatsNegElo.get(lineNumber), teamStatsGamesPlayed.get(lineNumber), teamStatsByes.get(lineNumber), teamStatsElimRounds.get(lineNumber), teamStatsWins.get(lineNumber)));
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
                            if (teamList.get(i).equals(new debateTeam(info))) {
                                affTeam = i;
                                x++;
                            }
                        }
                        if (x == 0) {
                            affTeam = teamList.size();
                            teamList.add(new debateTeam(info));
                            System.out.println(info);
                        }


                    } else if (count % 6 == 2) {

                        int x = 0;
                        for (int i = 0; i < teamList.size(); i++) {
                            if (teamList.get(i).equals(new debateTeam(info))) {
                                negTeam = i;
                                x++;
                            }
                        }

                        if (x == 0) {
                            negTeam = teamList.size();
                            teamList.add(new debateTeam(info));
                            System.out.println(info);
                        }
                    } else if (count % 6 == 3) {

                    } else if (count % 6 == 4) {

                        if (info.substring(0, 3).toLowerCase().equals("aff")) {
                            affWins = true;
                        } else {
                            affWins = false;
                        }
                    } else if (count % 6 == 0) {
                        // matches.add(new debateRound(teamList.get(affTeam), teamList.get(negTeam), affWins, tournament) );
                        teamList.get(affTeam).calculateElo(teamList.get(negTeam), true, affWins);
                        //teamList.get(negTeam).calculateElo(teamList.get(affTeam), false, affWins);

                    }

                    count++;

                }


                sc.close();
                FileWriter frwiter7 = new FileWriter("/Users/zacharyklein/eloDebateRankings/allMatches.txt");
                BufferedWriter bufwriter7 = new BufferedWriter(frwiter7);
                for (int i = 0; i < matches.size(); i++) {
                    bufwriter7.append("," + matches.get(i).getStringAff() + "," + matches.get(i).getStringNeg() + "," + matches.get(i).getWinner() + "," + matches.get(i).getTournament() + "\n");
                }
                bufwriter7.flush();
                FileWriter frwiter = new FileWriter("/Users/zacharyklein/eloDebateRankings/Teams.txt");
                BufferedWriter bufwriter = new BufferedWriter(frwiter);
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
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}


