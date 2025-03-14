package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import src.constants.PieceNames;
import src.constants.PieceNumbers;

public class GameTable extends JPanel implements MouseListener {
    private int tileSize = 80;
    private int squaresOnRow = 8;
    private int boardWidth = tileSize * squaresOnRow;
    private int boardHeight = tileSize * squaresOnRow;
    private boolean pieceSelected = false;
    Piece selectedPiece;

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

    // ArrayLists for storing pieces
    ArrayList<Piece> darkPawns;
    ArrayList<Piece> whitePawns;

    ArrayList<Piece> darkKnights;
    ArrayList<Piece> whiteKnights;

    ArrayList<Piece> darkBishops;
    ArrayList<Piece> whiteBishops;

    ArrayList<Piece> darkRooks;
    ArrayList<Piece> whiteRooks;

    Piece whiteKing, darkKing;
    Piece whiteQueen, darkQueen;

    Piece[][] pieces;
    ArrayList<Block> gameSquares; // ArrayList instead of HashSet
    ArrayList<Block> availableBlocksToGo;
    Block selectedBlock;

    GameTable() {
        // Init objects
        pieces = new Piece[8][8];
        addMouseListener(this);
        selectedBlock = null;

        // Init ArrayLists
        darkPawns = new ArrayList<>();
        whitePawns = new ArrayList<>();
        darkKnights = new ArrayList<>();
        whiteKnights = new ArrayList<>();
        darkBishops = new ArrayList<>();
        whiteBishops = new ArrayList<>();
        darkRooks = new ArrayList<>();
        whiteRooks = new ArrayList<>();

        gameSquares = new ArrayList<>();
        availableBlocksToGo = new ArrayList<>();
        selectedPiece = null;

        // Get pieces images
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
        whiteKing = new Piece(PieceNames.KING.getPieceName(), whiteKingImage, 'W', 4 * tileSize, 7 * tileSize, this.tileSize);
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
            darkPawns.add(new Piece(PieceNames.PAWN.getPieceName(), darkPawnImage, 'D', i * tileSize, tileSize, tileSize));
        }

        int index = 0;
        for(Piece pawn : darkPawns) {
            pieces[1][index] = pawn;
            index++;
        }

        index = 0;

        for(Piece pawn : whitePawns) {
            pieces[6][index] = pawn;
            index++;
        }

        for(Piece rook : darkRooks) {
            if(pieces[0][0] == null) pieces[0][0] = rook;
            else pieces[0][7] = rook;
        }

        for(Piece rook : whiteRooks) {
            if(pieces[7][0] == null) pieces[7][0] = rook;
            else pieces[7][7] = rook;
        }

        for(Piece knight : darkKnights) {
            if(pieces[0][1] == null) pieces[0][1] = knight;
            else pieces[0][6] = knight;
        }

        for(Piece knight : whiteKnights) {
            if(pieces[7][1] == null) pieces[7][1] = knight;
            else pieces[7][6] = knight;
        }

        for(Piece bishop : darkBishops) {
            if(pieces[0][2] == null) pieces[0][2] = bishop;
            else pieces[0][5] = bishop;
        }

        for(Piece bishop : whiteBishops) {
            if(pieces[7][2] == null) pieces[7][2] = bishop;
            else pieces[7][5] = bishop;
        }

        pieces[0][3] = darkQueen;
        pieces[0][4] = darkKing;
        pieces[7][3] = whiteQueen;
        pieces[7][4] = whiteKing;

        for(int i = 0; i < 8; i++)
            for(int j = 0; j < 8; j++) {
                Block block = new Block(j * tileSize, i * tileSize, tileSize);

                if(8 - i == 8 || 8 - i == 7 || 8 - i == 2 || 8  - i == 1) block.isOcupied = true;
                else block.isOcupied = false;

                gameSquares.add(block);
                System.out.println(block);
            }
    }

    Piece selectPiece(int x, int y) {
        availableBlocksToGo.clear(); // clear places to go from moving the last piece
        // Convert the click coordinates into grid indices
        int col = x / tileSize;
        int row = y / tileSize;

        if(pieces[row][col] != null) {
            repaint();
            pieceSelected = true;
        }

        return pieces[row][col];
    }

    void afis_game_table () {
        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                if(pieces[i][j] != null) System.out.print(pieces[i][j].name);
                else System.out.print("*");
            }

            System.out.println();
        }
    }

    void movePiece (int x, int y) {
        System.out.println("Functon gets called");
        // From screen coords to grid indexes
        int index_i = y / tileSize;
        int index_j = x / tileSize;

        if(pieces[index_i][index_j] != null) {
            return;
        }

        // Update the indexes
        pieces[index_i][index_j] = selectedPiece;
        pieces[selectedPiece.y / tileSize][selectedPiece.x / tileSize] = null;

        selectedPiece.move(index_j * tileSize, index_i * tileSize); // update the objects

        afis_game_table();
        repaint();

        selectedPiece = null;
        pieceSelected = false;
        availableBlocksToGo.clear();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {
        // Draw Squares
        for(Block block : gameSquares) {
            if (block.color == 'D') {
                g.setColor(new Color(4, 0, 112));
                g.fillRect(block.x, block.y, block.size, block.size);
            } else {
                g.setColor(new Color(146, 205, 255));
                g.fillRect(block.x, block.y, block.size, block.size);
            }

            if(block.isSelected) {
                Graphics2D g2d = (Graphics2D) g;

                g2d.setColor(Color.BLACK);
                g2d.setStroke(new BasicStroke(8));
                g2d.drawRect(block.x, block.y, block.size, block.size);
            }
        }
        // Draw Pieces
        for(int i = 0; i < 8; i++)
            for(int j = 0; j < 8; j++)
                if(pieces[i][j] != null)
                    g.drawImage(pieces[i][j].image, pieces[i][j].x, pieces[i][j].y, pieces[i][j].width, pieces[i][j].height, null);

        if(selectedPiece != null) {
            Graphics2D g2d = (Graphics2D) g;

            g2d.setStroke(new BasicStroke(5));
            g2d.setColor(Color.BLACK);

            g2d.drawRect(selectedPiece.x, selectedPiece.y, selectedPiece.width, selectedPiece.height);
        }

        if(availableBlocksToGo != null) {
            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor(Color.GREEN);
            g2d.setStroke(new BasicStroke(8));
            for(Block block : availableBlocksToGo) {
                int index_i = block.y / tileSize;
                int index_j = block.x / tileSize;

                if(pieces[index_i][index_j] == null)
                    g.drawRect(block.x, block.y, block.size, block.size);
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(!pieceSelected) {
            selectedPiece = selectPiece(e.getX(), e.getY());
            if(selectedPiece != null) {
                availableBlocksToGo = selectedPiece.getAvailableBlockToGo();
                repaint();
            }
        } else {
            movePiece(e.getX(), e.getY());
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
