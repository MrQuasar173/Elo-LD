import java.io.*;
import java.util.*;
public class Sort {
    public static void main(String[] args) throws Exception {
        FileReader freader = new FileReader("/Users/zacharyklein/eloDebateRankings/TotalAffNegWins.txt");
        BufferedReader bufreader = new BufferedReader(freader);
        allTeams listy = new allTeams();
        int affWinsTotalAmount = Integer.parseInt(bufreader.readLine());
        int negWinsTotalAmount = Integer.parseInt(bufreader.readLine());
        int affElimWin = Integer.parseInt(bufreader.readLine());
        int negElimWin = Integer.parseInt(bufreader.readLine());
        int affWinsThreeZeroVar = Integer.parseInt(bufreader.readLine());
        int negWinsThreeZeroVar = Integer.parseInt(bufreader.readLine());
        int affWinsTwoOneVar = Integer.parseInt(bufreader.readLine());
        int negWinsTwoOneVar = Integer.parseInt(bufreader.readLine());
        int correctVar = Integer.parseInt(bufreader.readLine());
        int totalGamesPlayedVar = Integer.parseInt(bufreader.readLine());

        System.out.println("Aff Wins Total: " + affWinsTotalAmount);
        System.out.println("Neg Wins Total: " + negWinsTotalAmount);
        System.out.println("Aff Elim Wins: " + affElimWin);
        System.out.println("Neg Elim Wins: " + negElimWin);
        System.out.println("3-0 aff votes: " + affWinsThreeZeroVar);
        System.out.println("2-1 aff votes: " + affWinsTwoOneVar);
        System.out.println("2-1 neg votes: " + negWinsTwoOneVar);
        System.out.println("3-0 neg votes: " + negWinsThreeZeroVar);
        System.out.println("Aff Wins " + RoundingClass.roundTwoDigits(( (double) affWinsTotalAmount * 100) / (affWinsTotalAmount + negWinsTotalAmount)) + "% of the time");
        System.out.println("Aff wins in elim rounds " + RoundingClass.roundTwoDigits(( (double) affElimWin * 100) / (negElimWin + affElimWin)) + "% of the time");
        System.out.println("Elo predicted the correct winner " + RoundingClass.roundTwoDigits((double) 100 * correctVar / totalGamesPlayedVar) + "%");
        listy.sortElimRounds();
    }
}

