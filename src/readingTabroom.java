import java.io.*;
import java.util.*;

public class readingTabroom {
    public static void main(String[] args) throws Exception {

            for (int k = 200; k <= 240; k++) {
                if (k == 161) {
                    continue;
                }

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

                }

        ManualAddRound.manualAdd(41,40,0);
        ManualAddRound.manualAdd(22,16,.6666666);
        ManualAddRound.manualAdd(22,11,.3333333);
        ManualAddRound.manualAdd(29,40,1);
        ManualAddRound.manualAdd(24,34,.3333333);
        ManualAddRound.manualAdd(46,5,.6666666);
        ManualAddRound.manualAdd(44,38,.33333333);
        ManualAddRound.manualAdd(32,21,.66666666);
        ManualAddRound.manualAdd(23,18,0);
        ManualAddRound.manualAdd(26,9,0);
        ManualAddRound.manualAdd(9,11,.33333333);
        ManualAddRound.manualAdd(18,29,.3333333);
        ManualAddRound.manualAdd(34,32,.6666666);
        ManualAddRound.manualAdd(38,46,.6666666);
        ManualAddRound.manualAdd(11,38,1);
        ManualAddRound.manualAdd(29,34,.3333333);
        ManualAddRound.manualAdd(34,11,.6666666);
        ManualAddRound.manualAdd(64,97,0);
        ManualAddRound.manualAdd(54,85,0);
        ManualAddRound.manualAdd(95,94,1);
        ManualAddRound.manualAdd(86,68,1);
        ManualAddRound.manualAdd(49,56,.66666666);
        ManualAddRound.manualAdd(51,8,1);
        ManualAddRound.manualAdd(98,79,0);
        ManualAddRound.manualAdd(61,80,.33333333);
        ManualAddRound.manualAdd(72,93,1);
        ManualAddRound.manualAdd(92,21,1);
        ManualAddRound.manualAdd(58,74,.333333333);
        ManualAddRound.manualAdd(52,87,.666666666);
        ManualAddRound.manualAdd(71,90,.333333333);
        ManualAddRound.manualAdd(99,90,1);
        ManualAddRound.manualAdd(52,69,.666666666);
        ManualAddRound.manualAdd(97,53,.333333333);
        ManualAddRound.manualAdd(101,85,0);
        ManualAddRound.manualAdd(92,95,0);
        ManualAddRound.manualAdd(86,72,1);
        ManualAddRound.manualAdd(49,80,.6666666666);
        ManualAddRound.manualAdd(51,79,0);
        ManualAddRound.manualAdd(99,79,.6666666666);
        ManualAddRound.manualAdd(49,52,0);
        ManualAddRound.manualAdd(53,86,.3333333333);
        ManualAddRound.manualAdd(85,95,0);
        ManualAddRound.manualAdd(86,52,0);
        ManualAddRound.manualAdd(120,126,1);
        ManualAddRound.manualAdd(104,157,1);
        ManualAddRound.manualAdd(119,141,0);
        ManualAddRound.manualAdd(156,154,(double) 1/3);
        ManualAddRound.manualAdd(178,162,1);
        ManualAddRound.manualAdd(136,112,0);
        ManualAddRound.manualAdd(122,139,1);
        ManualAddRound.manualAdd(127,6,0);
        ManualAddRound.manualAdd(107,18,0);
        ManualAddRound.manualAdd(113,174,(double) 2/3);
        ManualAddRound.manualAdd(150,175,1);
        ManualAddRound.manualAdd(135,128,(double) 2/3);
        ManualAddRound.manualAdd(176,161,(double) 2/3);
        ManualAddRound.manualAdd(130,173,1);
        ManualAddRound.manualAdd(146,44,(double) 1/3);
        ManualAddRound.manualAdd(118,153,(double) 2/3);
        ManualAddRound.manualAdd(118,120,0);
        ManualAddRound.manualAdd(104,44,1);
        ManualAddRound.manualAdd(130,141,(double) 1/3);
        ManualAddRound.manualAdd(176,154,(double) 1/3);
        ManualAddRound.manualAdd(178,135,(double) 2/3);
        ManualAddRound.manualAdd(150,112,(double) 2/3);
        ManualAddRound.manualAdd(113,122,0);
        ManualAddRound.manualAdd(18,6,(double) 2/3);
        ManualAddRound.manualAdd(18,120,0);
        ManualAddRound.manualAdd(104,122,(double) 2/3);
        ManualAddRound.manualAdd(150,141,(double) 2/3);
        ManualAddRound.manualAdd(178,154,1);
        ManualAddRound.manualAdd(178,120,0);
        ManualAddRound.manualAdd(104,150,1);
        ManualAddRound.manualAdd(120,104,(double) 1/3);
        ManualAddRound.manualAdd(195,215,(double) 0);
        ManualAddRound.manualAdd(183,198,(double) 0);
        ManualAddRound.manualAdd(206,210,(double) 1);
        ManualAddRound.manualAdd(193,186,(double) 0);
        ManualAddRound.manualAdd(204,181,(double) 0);
        ManualAddRound.manualAdd(197,196,(double) 1/3);
        ManualAddRound.manualAdd(196,202,(double) 0);
        ManualAddRound.manualAdd(215,200,(double) 1);
        ManualAddRound.manualAdd(198,181,(double) 1);
        ManualAddRound.manualAdd(206,186,(double) 1);
        ManualAddRound.manualAdd(206,202,(double) 1);
        ManualAddRound.manualAdd(215,198,(double) 2/3);
        ManualAddRound.manualAdd(215,206,(double) 1);
        ManualAddRound.manualAdd(327,313,(double) 0);
        ManualAddRound.manualAdd(293,140,(double) 1);
        ManualAddRound.manualAdd(178,118,(double) 1);
        ManualAddRound.manualAdd(284,176,(double) 1);
        ManualAddRound.manualAdd(310,53,(double) 1);
        ManualAddRound.manualAdd(95,281,(double) 1);
        ManualAddRound.manualAdd(316,99,(double) 0);
        ManualAddRound.manualAdd(215,104,(double) 2/3);
        ManualAddRound.manualAdd(288,269,(double) 0);
        ManualAddRound.manualAdd(330,314,(double) 1);
        ManualAddRound.manualAdd(320,309,(double) 0);
        ManualAddRound.manualAdd(277,85,(double) 1/3);
        ManualAddRound.manualAdd(325,173,(double) 2/3);
        ManualAddRound.manualAdd(319,135,(double) 1/3);
        ManualAddRound.manualAdd(97,307,(double) 0);
        ManualAddRound.manualAdd(233,287,(double) 2/3);
        ManualAddRound.manualAdd(233,313,(double) 2/3);
        ManualAddRound.manualAdd(293,307,(double) 1);
        ManualAddRound.manualAdd(178,135,(double) 1/3);
        ManualAddRound.manualAdd(325,284,(double) 1/3);
        ManualAddRound.manualAdd(85,310,(double) 0);
        ManualAddRound.manualAdd(309,95,(double) 0);
        ManualAddRound.manualAdd(330,99,(double) 2/3);
        ManualAddRound.manualAdd(215,269,(double) 1);
        ManualAddRound.manualAdd(215,233,(double) 1/3);
        ManualAddRound.manualAdd(330,293,(double) 1/3);
        ManualAddRound.manualAdd(135,95,(double) 2/3);
        ManualAddRound.manualAdd(310,284,(double) 0);
        ManualAddRound.manualAdd(135,293,(double) 2/3);
        ManualAddRound.manualAdd(284,135,(double) 1/3);
        ManualAddRound.manualAdd(257,261,(double) 1);
        ManualAddRound.manualAdd(246,77,(double) 1/3);
        ManualAddRound.manualAdd(149,244,(double) 0);
        ManualAddRound.manualAdd(101,227,(double) 1);
        ManualAddRound.manualAdd(61,247,(double) 0);
        ManualAddRound.manualAdd(251,70,(double) 1/3);
        ManualAddRound.manualAdd(62,10,(double) 0);
        ManualAddRound.manualAdd(236,8,(double) 1);
        ManualAddRound.manualAdd(226,129,(double) 2/3);
        ManualAddRound.manualAdd(78,226,(double) 0);
        ManualAddRound.manualAdd(236,92,(double) 1/3);
        ManualAddRound.manualAdd(87,10,(double) 0);
        ManualAddRound.manualAdd(259,70,(double) 1/3);
        ManualAddRound.manualAdd(90,247,(double) 1);
        ManualAddRound.manualAdd(237,101,(double) 0);
        ManualAddRound.manualAdd(244,107,(double) 1);
        ManualAddRound.manualAdd(77,257,(double) 0);
        ManualAddRound.manualAdd(226,257,(double) 0);
        ManualAddRound.manualAdd(244,92,(double) 0);
        ManualAddRound.manualAdd(101,10,(double) 2/3);
        ManualAddRound.manualAdd(70,90,(double) 0);
        ManualAddRound.manualAdd(257,90,(double) 2/3);
        ManualAddRound.manualAdd(92,101,(double) 2/3);

        FileWriter frwiter11 = new FileWriter("/Users/zacharyklein/eloDebateRankings/TotalAffNegWins.txt");
        BufferedWriter bufwriter11 = new BufferedWriter(frwiter11);
        bufwriter11.append(debateTeam.affWinsTotal  + "\n");
        bufwriter11.append(debateTeam.negWinsTotal  + "\n");
        bufwriter11.append(debateTeam.affElimWins  + "\n");
        bufwriter11.append(debateTeam.negElimWins  + "\n");
        bufwriter11.append(debateTeam.affWinsThreeZero  + "\n");
        bufwriter11.append(debateTeam.negWinsThreeZero  + "\n");
        bufwriter11.append(debateTeam.affWinsTwoOne  + "\n");
        bufwriter11.append(debateTeam.negWinsTwoOne  + "\n");
        bufwriter11.append(debateTeam.correct  + "\n");
        bufwriter11.append(debateTeam.totalGamesPlayed  + "\n");

        bufwriter11.flush();
            }

        }




