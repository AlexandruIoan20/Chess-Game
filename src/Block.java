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

    Block(char letter, int number, int x, int y, int size) {
        this.letter = letter;
        this.number = number;
        this.x = x;
        this.y = y;
        this.size = size;

        initBlock();
    }

    void initBlock() {
        ArrayList <Character> availableLetters = new ArrayList<>(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g' ));

        int indexOfLetter = availableLetters.indexOf(letter) + 1;
        if(indexOfLetter % 2 == this.number % 2) this.color = 'D';
        else this.color = 'W';
    }
}
