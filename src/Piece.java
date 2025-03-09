package src;

import java.awt.*;
import src.constants.PieceNames;

public class Piece {
    private char color; // D - dark / W - white
    private int name;
    private int tileSize;
    Image image;

    int x, y;
    int startX, startY;
    int width, height;

    Piece(int name, Image pieceImage, char color, int x, int y, int tileSize) {
        this.name = name;
        this.color = color;
        this.tileSize = width;
        this.image = pieceImage;
        this.x = x;
        this.y = y;
        this.width = tileSize;
        this.height = tileSize;
        this.startX = x;
        this.startY = y;
    }

    public void move() {

    }
}
