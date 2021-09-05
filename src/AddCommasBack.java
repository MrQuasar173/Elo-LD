import java.io.*;
import java.util.*;

public class AddCommasBack {
    public static void main(String[] args) {
        try {
            FileReader freader = new FileReader("/Users/zacharyklein/eloDebateRankings/mytable (164).csv");
            BufferedReader bufreader = new BufferedReader(freader);
            ArrayList<String> lines = new ArrayList<String>();
            String line;
            while ((line = bufreader.readLine()) != null) {
                if (!line.isEmpty()) {
                    lines.add(line);
                }

            }
            FileWriter frwiter = new FileWriter("/Users/zacharyklein/eloDebateRankings/mytable (164).csv");
            BufferedWriter bufwriter = new BufferedWriter(frwiter);
            for (int i = 1; i < lines.size(); i++) {
                lines.set(i, lines.get(i) + ",");
            }
            for (String words : lines) {

                bufwriter.append(words + "\n");
            }
            bufwriter.flush();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
