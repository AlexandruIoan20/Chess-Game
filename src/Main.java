package src;

import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        GameTable gameTable = new GameTable();

        JFrame frame = new JFrame("Chess Game");

        frame.add(gameTable);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);

        frame.setResizable(false);
        frame.setVisible(true);
    }
}
