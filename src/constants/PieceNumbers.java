package src.constants;

public enum PieceNumbers {
    KING_NUMBERS(1), QUEEN_NUMBERS(1), ROOK_NUMBERS(2), BISHOP_NUMBERS(2), KNIGHT_NUMBERS(2), PAWN_NUMBERS(8);

    private final int value;

    PieceNumbers(int value) {
        this.value = value;
    }

    public int getPieceNumbers() {
        return this.value;
    }
}
