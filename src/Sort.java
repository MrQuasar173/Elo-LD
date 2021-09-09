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
        System.out.println("Aff Wins Total: " + affWinsTotalAmount);
        System.out.println("Neg Wins Total: " + negWinsTotalAmount);
        System.out.println("Aff Elim Wins: " + affElimWin);
        System.out.println("Neg Elim Wins: " + negElimWin);
        System.out.println("Aff Wins " + ((double) affWinsTotalAmount * 100) / (affWinsTotalAmount + negWinsTotalAmount) + "% of the time");
        System.out.println("Aff wins in elim rounds " + ((double) affElimWin * 100) / (negElimWin + affElimWin) + "% of the time");
        listy.sortElo();
    }
}

