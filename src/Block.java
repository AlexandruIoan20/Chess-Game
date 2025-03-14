package src;

import java.util.ArrayList;
import java.util.Arrays;

public class Block {
    char letter;
    char color; // D - dark, W - white
    int number;
    int x, y, size;
    boolean isOcupied;
    boolean isSelected;

    private final ArrayList <Character> availableLetters = new ArrayList<>(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h' ));

    Block(int x, int y, int size) {
        this.x = x;
        this.y = y;
        this.size = size;

        getBlockNameFromCoords();
        initBlock();
    }

    void initBlock() {
        int indexOfLetter = availableLetters.indexOf(this.letter);
        if(indexOfLetter % 2 == this.number % 2) this.color = 'D';
        else this.color = 'W';
    }

    void getBlockNameFromCoords() {
        int index_i = this.y / this.size;
        int index_j = this.x / this.size;

        this.letter = availableLetters.get(index_j);
        this.number = 8 - index_i;

    }
}
