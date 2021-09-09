import java.util.*;

/*
Need to do.
1. figure out how to add previous rounds from doc
 */
public class debateTeam {
    private String school;
    private String code;
    private double elo;
    private double affElo;
    private double negElo;
    private int gamesPlayed;
    public static final int scale = 100;
    private ArrayList<debateRound> rounds;
    private ArrayList<String> alias;
    private int byes;
    private int elimRounds;
    private int wins;

    public debateTeam() {
        byes = 0;
        school = "";
        code = "";
        elo = 0.0;
        affElo = 0.0;
        negElo = 0.0;
        gamesPlayed = 0;
        rounds = new ArrayList<debateRound>();
        elimRounds = 0;
        wins = 0;
    }

    public debateTeam(String school, String code, double elo, double affElo, double negElo, int gamesPlayed) {
        this.school = school;
        this.code = code;
        this.elo = elo;
        this.gamesPlayed = gamesPlayed;
        this.affElo = affElo;
        this.negElo = negElo;
        rounds = new ArrayList<debateRound>();
        byes = 0;
        elimRounds = 0;
        wins = 0;
    }

    public debateTeam(String name, double elo, double affElo, double negElo, int gamesPlayed) {
        if (name.length() < 2) {
            System.out.println("School not parsed " + name);
            this.elo = 1500.0;
            this.gamesPlayed = 0;
            this.code = "fl";
            this.school = "fail";
            this.affElo = 1500.0;
            this.negElo = 1500.0;
            rounds = new ArrayList<debateRound>();
            byes = 0;
            elimRounds = 0;
            wins = 0;
        } else {
            this.school = name.substring(0, name.length() - 3);
            this.code = name.substring(name.length() - 2);
            this.elo = elo;
            this.gamesPlayed = gamesPlayed;
            this.affElo = affElo;
            this.negElo = negElo;
            rounds = new ArrayList<debateRound>();
            byes = 0;
            elimRounds = 0;
            wins = 0;
        }
    }

    public debateTeam(String name, double elo, double affElo, double negElo, int gamesPlayed, int byes) {
        if (name.length() < 2) {
            System.out.println("School not parsed " + name);
            this.elo = 1500.0;
            this.gamesPlayed = 0;
            this.code = "fl";
            this.school = "fail";
            this.affElo = 1500.0;
            this.negElo = 1500.0;
            rounds = new ArrayList<debateRound>();
            this.byes = byes;
            elimRounds = 0;
             wins = 0;
        } else {
            this.school = name.substring(0, name.length() - 3);
            this.code = name.substring(name.length() - 2);
            this.elo = elo;
            this.gamesPlayed = gamesPlayed;
            this.affElo = affElo;
            this.negElo = negElo;
            this.byes = byes;
            rounds = new ArrayList<debateRound>();
            elimRounds = 0;
            wins = 0;
        }
    }
    public debateTeam(String name, double elo, double affElo, double negElo, int gamesPlayed, int byes, int elimRounds) {
        if (name.length() < 2) {
            System.out.println("School not parsed " + name);
            this.elo = 1500.0;
            this.gamesPlayed = 0;
            this.code = "fl";
            this.school = "fail";
            this.affElo = 1500.0;
            this.negElo = 1500.0;
            rounds = new ArrayList<debateRound>();
            this.byes = byes;
            this.elimRounds = elimRounds;
            wins = 0;
        } else {
            this.school = name.substring(0, name.length() - 3);
            this.code = name.substring(name.length() - 2);
            this.elo = elo;
            this.gamesPlayed = gamesPlayed;
            this.affElo = affElo;
            this.negElo = negElo;
            this.byes = byes;
            rounds = new ArrayList<debateRound>();
            this.elimRounds = elimRounds;
            wins = 0;
        }
    }
    public debateTeam(String name, double elo, double affElo, double negElo, int gamesPlayed, int byes, int elimRounds, int wins) {
        if (name.length() < 2) {
            System.out.println("School not parsed " + name);
            this.elo = 1500.0;
            this.gamesPlayed = 0;
            this.code = "fl";
            this.school = "fail";
            this.affElo = 1500.0;
            this.negElo = 1500.0;
            rounds = new ArrayList<debateRound>();
            this.byes = byes;
            this.elimRounds = elimRounds;
            this.wins = wins;
        } else {
            this.school = name.substring(0, name.length() - 3);
            this.code = name.substring(name.length() - 2);
            this.elo = elo;
            this.gamesPlayed = gamesPlayed;
            this.affElo = affElo;
            this.negElo = negElo;
            this.byes = byes;
            rounds = new ArrayList<debateRound>();
            this.elimRounds = elimRounds;
            this.wins = wins;
        }
    }


    public debateTeam(String name) {
        if (name.length() < 2) {
            elo = 1500.0;
            gamesPlayed = 0;
            code = "fl";
            school = "fail";
            affElo = 1500.0;
            negElo = 1500.0;
            rounds = new ArrayList<debateRound>();
            System.out.println("school not parsed " + name);
            byes = 0;
            wins = 0;
        } else {
            elo = 1500.0;
            affElo = 1500.0;
            negElo = 1500.0;
            gamesPlayed = 0;
            code = name.substring(name.length() - 2);
            school = name.substring(0, name.length() - 3);
            rounds = new ArrayList<debateRound>();
            byes = 0;
            wins = 0;
        }
    }
    public int getElimRounds(){
        return elimRounds;
    }
    public double getElo() {
        return elo;
    }

    public double getAffElo() {
        return affElo;
    }

    public double getNegElo() {
        return negElo;
    }

    public String getSchool() {
        return school;
    }

    public int getByes() {
        return byes;
    }

    public int getWins(){
        return wins;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return school + " " + code;
    }

    public ArrayList<debateRound> getRounds() {
        return rounds;
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public void setElo(double newElo) {
        elo = newElo;
    }

    public void setAffElo(double newAffElo) {
        affElo = newAffElo;
    }

    public void setNegElo(double newNegElo) {
        negElo = newNegElo;
    }

    public void increaseGamesPlayed() {
        gamesPlayed++;
    }

    public void increaseElimRounds(){
        elimRounds++;
    }

    public void delete() {
        //run some code to get it out of the database
        System.out.println("Remember delete does nothing");
    }

    public double expected(debateTeam opponent) {
        //1 means that the non-opponent wins 100% of the time 0 means that opponent wins 100% of the time.
        // It is a scale from 0 to 1.
        return 1 / (1 + Math.pow(10, (opponent.getElo() - getElo()) / 400));
    }

    public double affExpected(debateTeam opponent) {
        //1 means that the non-opponent wins 100% of the time 0 means that opponent wins 100% of the time.
        // It is a scale from 0 to 1.
        //If the team this method is on is aff.
        return 1 / (1 + Math.pow(10, (opponent.getNegElo() - getAffElo()) / 400));
    }

    public double negExpected(debateTeam opponent) {
        //1 means that the non-opponent wins 100% of the time 0 means that opponent wins 100% of the time.
        // It is a scale from 0 to 1
        //If the team this method is on is neg.
        return 1 / (1 + Math.pow(10, (opponent.getAffElo() - getNegElo()) / 400));
    }

    public void eloCalculator(debateTeam opponent, boolean weWon) {
        //weWon is if the team who this method is on, won.
        if (weWon) {
            elo = elo + scale * (1 - expected(opponent));
        } else {
            elo = elo + scale * -expected(opponent);
        }
        // increaseGamesPlayed();
    }

    public void affEloCalculator(debateTeam opponent, boolean weWon) {
        //if the team that the method this is on is aff.
        if (weWon) {
            affElo = affElo + scale * (1 - affExpected(opponent));
        } else {
            affElo = affElo + scale * -affExpected(opponent);
        }
    }

    public void negEloCalculator(debateTeam opponent, boolean weWon) {
        //if the team that the method this is on is neg.
        if (weWon) {
            negElo = negElo + scale * (1 - negExpected(opponent));
        } else {
            negElo = negElo + scale * -negExpected(opponent);
        }
    }

    public debateTeam copy(debateTeam copyCat) {
        debateTeam clone = new debateTeam(copyCat.getSchool(), copyCat.getCode(), copyCat.getElo(), copyCat.getAffElo(), copyCat.getNegElo(), copyCat.getGamesPlayed());
        return clone;
    }

    public debateTeam copyHelp() {
        debateTeam clone = new debateTeam(getSchool(), getCode(), getElo(), getAffElo(), getNegElo(), getGamesPlayed());
        return clone;
    }

    public int toIntNegElo() {
        return (int) Math.round(negElo);
    }

    public int toIntAffElo() {
        return (int) Math.round(affElo);
    }

    public int toIntElo() {
        return (int) Math.round(elo);
    }

    public Long getLong() {
        //return elo + 10000 * affElo + 100000000 * negElo + 1000000000000L *  gamesPlayed;
        return 1000000000000L * gamesPlayed + 100000000L * toIntNegElo() + 10000L * toIntAffElo() + toIntElo();
    }

    public void increaseByes() {
        byes++;
    }

    public void increaseWins(){
        wins++;
    }

    public void calculateElo(debateTeam opponent, boolean amAff, boolean affWins) {
        if (opponent.equals(new debateTeam("Zach BA"))) {
            increaseByes();
            opponent.increaseByes();
        } else if (equals(new debateTeam("Zach BA"))) {
            increaseByes();
            opponent.increaseByes();
        } else if (amAff) {
            debateTeam staySelf1 = copyHelp();
            debateTeam staySelf2 = copyHelp();
            debateTeam stayOpponent1 = opponent.copyHelp();
            debateTeam stayOpponent2 = opponent.copyHelp();
            eloCalculator(stayOpponent1, affWins);
            opponent.eloCalculator(staySelf1, !affWins);
            affEloCalculator(stayOpponent2, affWins);
            opponent.negEloCalculator(staySelf2, !affWins);
            increaseGamesPlayed();
            opponent.increaseGamesPlayed();
            if(affWins){
                increaseWins();
            } else{
                opponent.increaseWins();
            }


        } else {
            debateTeam staySelf1 = copyHelp();
            debateTeam staySelf2 = copyHelp();
            debateTeam stayOpponent1 = opponent.copyHelp();
            debateTeam stayOpponent2 = opponent.copyHelp();
            eloCalculator(stayOpponent1, !affWins);
            opponent.eloCalculator(staySelf1, affWins);
            negEloCalculator(stayOpponent2, !affWins);
            opponent.affEloCalculator(staySelf2, affWins);
            increaseGamesPlayed();
            opponent.increaseGamesPlayed();
            if(!affWins){
                increaseWins();
            } else{
                opponent.increaseWins();
            }

        }
    }

    public int compareTo(debateTeam otherTeam) {
        return Double.compare(otherTeam.getElo(), getElo());
    }

    public boolean equals(Object o) {
        debateTeam other = (debateTeam) o;

        if (getSchool().equals(other.getSchool())) {
            if (getCode().equals(other.getCode()) || ((getCode().substring(0, 1).equals(other.getCode().substring(1, 2))) && getCode().substring(1, 2).equals(other.getCode().substring(0, 1)))) {
                return true;
            }
        }
        return false;
    }

    public void combine(debateTeam other) {
        elo = (getElo() * getGamesPlayed() + other.getElo() * other.getGamesPlayed()) / (getGamesPlayed() + other.getGamesPlayed());
        negElo = (getNegElo() * getGamesPlayed() + other.getNegElo() * other.getGamesPlayed()) / (getGamesPlayed() + other.getGamesPlayed());
        affElo = (getAffElo() * getGamesPlayed() + other.getAffElo() * other.getGamesPlayed()) / (getGamesPlayed() + other.getGamesPlayed());
        gamesPlayed = getGamesPlayed() + other.getGamesPlayed();

    }

    public String toString() {
        return getName() + "\n \t elo: " + elo + "\n \t Neg Elo: " + negElo + "\n \t Aff Elo: " + affElo + "\n \t Games Played: " + gamesPlayed + "\n \t Byes: " + byes + "\n \t Elim Rounds: " + elimRounds + "\n \t Record: " + wins + "-" + (gamesPlayed - wins);
    }

    public boolean warning() {
        if (affElo > elo && negElo > elo) {
            return true;
        }
        if (affElo < elo && negElo < elo) {
            return true;
        }
        return false;
    }

    public void eloCalculatorAny(debateTeam opponent, double valued) {
        elo = elo + scale * (valued - expected(opponent));
    }

    public void affEloCalculatorAny(debateTeam opponent, double valued) {
        //if the team that the method this is on is aff.

        affElo = affElo + scale * (valued - affExpected(opponent));


    }

    public void negEloCalculatorAny(debateTeam opponent, double valued) {
        //if the team that the method this is on is neg.
        negElo = negElo + scale * (valued - negExpected(opponent));
    }
    public void calculateEloAny(debateTeam opponent, double score) {
        if (opponent.equals(new debateTeam("Zach BA"))) {
            increaseByes();
            opponent.increaseByes();
        } else if (equals(new debateTeam("Zach BA"))) {
            increaseByes();
            opponent.increaseByes();
        } else {
            if(score > .5){
                increaseWins();
            } else if (score < .5){
                opponent.increaseWins();
            }
            debateTeam staySelf1 = copyHelp();
            debateTeam staySelf2 = copyHelp();
            debateTeam stayOpponent1 = opponent.copyHelp();
            debateTeam stayOpponent2 = opponent.copyHelp();
            eloCalculatorAny(stayOpponent1, score);
            opponent.eloCalculatorAny(staySelf1, 1 - score);
            affEloCalculatorAny(stayOpponent2, score);
            opponent.negEloCalculatorAny(staySelf2, 1- score);
            increaseGamesPlayed();
            opponent.increaseGamesPlayed();
            increaseElimRounds();
            opponent.increaseElimRounds();
        }
    }
    public double getPercentage(){
        return ((double) wins / gamesPlayed);
    }
    public void divide(int x){
        gamesPlayed = gamesPlayed / x;
        byes = byes / x;
        wins = wins / x;
        elimRounds = elimRounds / x;
    }
}
