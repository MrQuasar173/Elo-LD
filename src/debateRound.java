public class debateRound {
    private debateTeam aff;
    private debateTeam neg;
    private boolean affWins;
    private String debateTournament;

    public debateRound(debateTeam aff, debateTeam neg, boolean affWins) {


        this.aff = aff;
        this.neg = neg;
        this.affWins = affWins;
        debateTournament = "";
    }

    public debateRound(debateTeam aff, debateTeam neg, boolean affWins, String debateTournament) {


        this.aff = aff;
        this.neg = neg;
        this.affWins = affWins;
        this.debateTournament = debateTournament;
    }

    public void calculateMatch() {
        debateTeam stayNeg1 = neg.copy(neg);
        debateTeam stayNeg2 = neg.copy(neg);
        debateTeam stayAff1 = aff.copy(aff);
        debateTeam stayAff2 = aff.copy(aff);
        aff.eloCalculator(stayNeg1, affWins);
        neg.eloCalculator(stayAff1, !affWins);
        aff.affEloCalculator(stayNeg2, affWins);
        neg.negEloCalculator(stayAff2, !affWins);
    }

    public debateTeam getAff() {
        return aff;
    }

    public debateTeam getNeg() {
        return neg;
    }

    public String getStringAff() {
        return aff.getName();
    }

    public String getStringNeg() {
        return neg.getName();
    }

    public String getTournament() {
        return debateTournament;
    }

    public String getWinner() {
        if (affWins) {
            return "aff";

        } else {
            return "neg";
        }
    }
}
