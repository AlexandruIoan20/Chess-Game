package src;

import java.awt.*;
import java.util.ArrayList;

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
        this.tileSize = tileSize;
        this.image = pieceImage;
        this.x = x;
        this.y = y;
        this.width = tileSize;
        this.height = tileSize;
        this.startX = x;
        this.startY = y;
    }

    boolean inside(int x, int y) {
        return x > 0 && y > 0 && x < 8 * tileSize && y < 8 * tileSize;
    }

    public ArrayList<Block> getAvailableBlockToGo() {
        ArrayList<Block> result = new ArrayList<>();
        if(this.name == PieceNames.PAWN.getPieceName()) {
            result.add(new Block(this.x, this.y - tileSize, tileSize));
        }
        if(this.name == PieceNames.BISHOP.getPieceName()) {
            final int[] dx = { -1, 1, 1, -1 };
            final int[] dy = { -1, -1, 1, 1 };

            for(int k = 0; k < dx.length; k++) {
                int velocityX = dx[k] * tileSize;
                int velocityY = dy[k] * tileSize;

                int xNou = this.x + velocityX;
                int yNou = this.y + velocityY;

                while(inside(xNou, yNou)) {
                    result.add(new Block(xNou, yNou, tileSize));
                    xNou += velocityX;
                    yNou += velocityY;
                }
            }
        }

        return result;
    }

    public void move(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
