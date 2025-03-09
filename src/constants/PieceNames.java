package src.constants;

public enum PieceNames {
    KING(1), QUEEN(2), ROOK(3), BISHOP(4), KNIGHT(5), PAWN(6);

    private final int pieceValue;

    PieceNames(int pieceValue) {
        this.pieceValue = pieceValue;
    }

    public int getPieceName() {
        return this.pieceValue;
    }
}
