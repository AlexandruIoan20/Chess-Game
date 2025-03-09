package src;

import javax.swing.JPanel;
import java.awt.*;

public class GameTable extends JPanel {
    private int tileSize = 80;
    private int squaresOnRow = 8;
    private int boardWidth = tileSize * squaresOnRow;
    private int boardHeight = tileSize * squaresOnRow;

    GameTable() {
        this.setPreferredSize(new Dimension(boardWidth, boardHeight));
        this.setBackground(Color.CYAN);
    }
}
