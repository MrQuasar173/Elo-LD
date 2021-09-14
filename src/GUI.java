import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {
    public GUI(){
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        JButton eloButton = new JButton("Elo Sort");
        JButton affEloButton = new JButton("Aff Elo Sort");
        JButton negEloButton = new JButton("Neg Elo Sort");
        JButton gamesPlayed = new JButton("Games Played Sort");
        JButton elimRounds = new JButton("Elim Round Sort");
        JButton winPercentage = new JButton("Win Percentage Sort");
        JButton wins = new JButton("Wins Sort");
        panel.setBorder(BorderFactory.createEmptyBorder(90,90,20,50));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(eloButton);
        panel.add(affEloButton);
        panel.add(negEloButton);
        panel.add(gamesPlayed);
        panel.add(elimRounds);
        panel.add(winPercentage);
        panel.add(wins);

        eloButton.addActionListener(this);

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Elo Scores");
        frame.pack();
        frame.setVisible(true);
    }
    public static void main(String[] args){
        new GUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
JLabel explination = new JLabel("");
    }
}
