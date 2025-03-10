package src;

import java.awt.*;
import src.constants.PieceNames;

public class Piece {
    private char color; // D - dark / W - white
    int name;
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

    public Block[] checkMove(Block existingBlock) {
        // scrie functia de verificare miscare pentru fiecare piesa
            // primeste blockul unde se afla si trebuie sa returneze toate blocurile unde poate ajunge (sau ceva de genu)

        return new Block [] { new Block('a', 1, 2, 3, 4) };
    }

    public void move(Block existingBlock) {
        // scrie functia de miscare propriu-zisa(cand apesi pe un camp gol, aceasta functie este apelata iar piesa se misca)
    }
}
