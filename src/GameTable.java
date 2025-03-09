package src;

import javax.swing.*;
import java.awt.*;
import java.util.HashSet;

import src.constants.PieceNames;
import src.constants.PieceNumbers;

public class GameTable extends JPanel {
    private int tileSize = 80;
    private int squaresOnRow = 8;
    private int boardWidth = tileSize * squaresOnRow;
    private int boardHeight = tileSize * squaresOnRow;

    Image darkQueenImage;
    Image whiteQueenImage;

    Image darkKingImage;
    Image whiteKingImage;

    Image darkRookImage;
    Image whiteRookImage;

    Image darkBishopImage;
    Image whiteBishopImage;

    Image darkKnightImage;
    Image whiteKnightImage;

    Image darkPawnImage;
    Image whitePawnImage;

    HashSet<Piece> darkPawns;
    HashSet<Piece> whitePawns;

    HashSet<Piece> darkKnights;
    HashSet<Piece> whiteKnights;

    HashSet<Piece> darkBishops;
    HashSet<Piece> whiteBishops;

    HashSet<Piece> darkRooks;
    HashSet<Piece> whiteRooks;

    Piece whiteKing, darkKing;
    Piece whiteQueen, darkQueen;

    GameTable() {
        // Init HashSets
        darkPawns = new HashSet<>();
        whitePawns = new HashSet<>();
        darkKnights = new HashSet<>();
        whiteKnights = new HashSet<>();
        darkBishops = new HashSet<>();
        whiteBishops = new HashSet<>();
        darkRooks = new HashSet<>();
        whiteRooks = new HashSet<>();

        darkQueenImage = new ImageIcon(getClass().getResource("./resources/black-queen.png")).getImage();
        whiteQueenImage = new ImageIcon(getClass().getResource("./resources/white-queen.png")).getImage();

        darkKingImage = new ImageIcon(getClass().getResource("./resources/black-king.png")).getImage();
        whiteKingImage = new ImageIcon(getClass().getResource("./resources/white-king.png")).getImage();

        darkRookImage = new ImageIcon(getClass().getResource("./resources/black-rook.png")).getImage();
        whiteRookImage = new ImageIcon(getClass().getResource("./resources/white-rook.png")).getImage();

        darkBishopImage = new ImageIcon(getClass().getResource("./resources/black-bishop.png")).getImage();
        whiteBishopImage = new ImageIcon(getClass().getResource("./resources/white-bishop.png")).getImage();

        darkKnightImage = new ImageIcon(getClass().getResource("./resources/black-knight.png")).getImage();
        whiteKnightImage = new ImageIcon(getClass().getResource("./resources/white-knight.png")).getImage();

        darkPawnImage = new ImageIcon(getClass().getResource("./resources/black-pawn.png")).getImage();
        whitePawnImage = new ImageIcon(getClass().getResource("./resources/white-pawn.png")).getImage();

        this.setPreferredSize(new Dimension(boardWidth, boardHeight));
        this.setBackground(Color.CYAN);
        loadMap();
    }

    void loadMap() {
        // Init King
        whiteKing = new Piece(PieceNames.KING.getPieceName(), whiteKingImage, 'W', 4 * tileSize, 7 * tileSize, tileSize);
        darkKing = new Piece(PieceNames.KING.getPieceName(), darkKingImage, 'D', 4 * tileSize, 0, tileSize);

        // Init Queens
        whiteQueen = new Piece(PieceNames.QUEEN.getPieceName(), whiteQueenImage, 'W', 3 * tileSize, 7 * tileSize, tileSize);
        darkQueen = new Piece(PieceNames.QUEEN.getPieceName(), darkQueenImage, 'D', 3 * tileSize, 0, tileSize);

        // Init Bishops
        whiteBishops.add(new Piece(PieceNames.BISHOP.getPieceName(), whiteBishopImage, 'W', 2 * tileSize, 7 * tileSize, tileSize));
        whiteBishops.add(new Piece(PieceNames.BISHOP.getPieceName(), whiteBishopImage, 'W', 5 * tileSize, 7 * tileSize, tileSize));
        darkBishops.add(new Piece(PieceNames.BISHOP.getPieceName(), darkBishopImage, 'D', 2 * tileSize, 0, tileSize));
        darkBishops.add(new Piece(PieceNames.BISHOP.getPieceName(), darkBishopImage, 'D', 5 * tileSize, 0, tileSize));

        // Init Knights
        whiteKnights.add(new Piece(PieceNames.KNIGHT.getPieceName(), whiteKnightImage, 'W', tileSize, 7 * tileSize, tileSize));
        whiteKnights.add(new Piece(PieceNames.KNIGHT.getPieceName(), whiteKnightImage, 'W', 6 * tileSize, 7 * tileSize, tileSize));
        darkKnights.add(new Piece(PieceNames.KNIGHT.getPieceName(), darkKnightImage, 'D', tileSize, 0, tileSize));
        darkKnights.add(new Piece(PieceNames.KNIGHT.getPieceName(), darkKnightImage, 'D', 6 * tileSize, 0, tileSize));

        // Init Rooks
        whiteRooks.add(new Piece(PieceNames.ROOK.getPieceName(), whiteRookImage, 'W', 0, 7 * tileSize, tileSize));
        whiteRooks.add(new Piece(PieceNames.ROOK.getPieceName(),whiteRookImage, 'W', 7 * tileSize, 7 * tileSize, tileSize));
        darkRooks.add(new Piece(PieceNames.ROOK.getPieceName(), darkRookImage, 'D', 0, 0, tileSize));
        darkRooks.add(new Piece(PieceNames.ROOK.getPieceName(), darkRookImage, 'D', 7 * tileSize, 0, tileSize));

        for(int i = 0; i < PieceNumbers.PAWN_NUMBERS.getPieceNumbers(); i++) {
            whitePawns.add(new Piece(PieceNames.PAWN.getPieceName(), whitePawnImage, 'W', i * tileSize, 6 * tileSize, tileSize));
            darkPawns.add(new Piece(PieceNames.PAWN.getPieceName(), darkRookImage, 'D', i * tileSize, tileSize, tileSize));
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {
        g.drawImage(whiteKing.image, whiteKing.x, whiteKing.y, whiteKing.width, whiteKing.height, null);
        g.drawImage(darkKing.image, darkKing.x, darkKing.y, darkKing.width, darkKing.height, null);

        g.drawImage(whiteQueen.image, whiteQueen.x, whiteQueen.y, whiteQueen.width, whiteQueen.height, null);
        g.drawImage(darkQueen.image, darkQueen.x, darkQueen.y, darkQueen.width, darkQueen.height, null);

        for(Piece bishop : whiteBishops) g.drawImage(bishop.image, bishop.x, bishop.y, bishop.width, bishop.height, null);
        for(Piece bishop : darkBishops) g.drawImage(bishop.image, bishop.x, bishop.y, bishop.width, bishop.height, null);

        for(Piece knight : whiteKnights) g.drawImage(knight.image, knight.x, knight.y, knight.width, knight.height, null);
        for(Piece knight : darkKnights) g.drawImage(knight.image, knight.x, knight.y, knight.width, knight.height, null);

        for(Piece rook : whiteRooks) g.drawImage(rook.image, rook.x, rook.y, rook.width, rook.height, null);
        for(Piece rook : darkRooks) g.drawImage(rook.image, rook.x, rook.y, rook.width, rook.height, null);

        for(Piece pawn : whitePawns) g.drawImage(pawn.image, pawn.x, pawn.y, pawn.width, pawn.height, null);
        for(Piece pawn : darkPawns) g.drawImage(pawn.image, pawn.x, pawn.y, pawn.width, pawn.height, null);
    }

}
