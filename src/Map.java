import java.util.Arrays;


public class Map {
    char[][] chars;
    int rows;
    int cols;
    int heroRow = 0;
    int heroCol = 0;
    Hero hero = new Hero();

    public Map(int rows, int cols) {
        chars = new char[rows][cols];
        this.rows = rows;
        this.cols = cols;
        for (char[] aChar : chars) {
            Arrays.fill(aChar, '.');
        }
    }

    public Map(char[][] mapTemplate) {
        this.rows = mapTemplate.length;
        this.cols = mapTemplate[0].length;
        chars = new char[mapTemplate.length][mapTemplate[0].length];
        chars = mapTemplate.clone();
    }

    public String toString() { // prints out the map
        for (int i = 0; i < chars.length; i++) {
            System.out.println(chars[i]);
        }
        return "";

    }

    public void addWalls() { // adds X's on the border of the map
        for (int i = 0; i < chars.length; i++) {
            chars[i][0] = 'X';
            chars[i][chars[i].length - 1] = 'X';
        }
        Arrays.fill(chars[0], 'X');
        Arrays.fill(chars[chars.length - 1], 'X');


    }

    public void addItems(int numOfItems) {  // this method adds specific number of items on the map
        char[] items = new char[numOfItems];
        for (int i = 0; i < numOfItems; i++) {
            items[i] = (char) (i + 1 + '0');
        }
        int counter = 0;
        while (counter < numOfItems) {
            int r = GameData.randomRoll(0, rows);
            int c = GameData.randomRoll(0, cols);
            if (chars[r][c] != 'X') {
                chars[r][c] = items[counter];
                counter++;
            }
        }

    }

    public void initHeroLocation() {    // it checks if there is a player on the location, if it is not - create a player
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < chars[i].length; j++) {
                if (chars[i][j] == 'H') {
                    heroRow = i;
                    heroCol = j;
                }
            }
        }
        if (heroRow == 0 && heroCol == 0) {
            while (true) {
                if (heroRow == 0 && heroCol == 0) {
                    heroRow = GameData.randomRoll(0, rows);
                    heroCol = GameData.randomRoll(0, cols);
                    if (chars[heroRow][heroCol] != 'X') {
                        chars[heroRow][heroCol] = 'H';
                        break;
                    }
                }
            }
        }
    }

    private boolean isValidMove(int row, int col) {  //it checks if the move is valid and returns true or false
        if (chars[row][col] != 'X') {
            return true;
        } else {
            return false;
        }
    }


    private char applyMove(int endRow, int endCol) {  //this method changes the given point to H and returns current
        if (isValidMove(endRow, endCol)) {            // hero coordinates
            chars[endRow][endCol] = 'H';
            heroRow = endRow;
            heroCol = endCol;
        }
        return chars[heroRow][heroCol];

    }

    public char processInput(int direction) { // this method call aplyMove and change the given coordinate to H
        if (direction == 0) {                 // it also changes previous coordinates to .
            if (isValidMove(heroRow - 1, heroCol)) {
                if (chars[heroRow - 1][heroCol] != '.') {
                    chars[heroRow - 1][heroCol] = '.';
                    applyMove(heroRow - 1, heroCol);
                    chars[heroRow + 1][heroCol] = '.';
                    return chars[heroRow][heroCol];
                } else {
                    applyMove(heroRow - 1, heroCol);
                    chars[heroRow + 1][heroCol] = '.';
                    return chars[heroRow][heroCol];
                }
            } else {
                return 'X';
            }

        }

         else if (direction == 1) {
            if (isValidMove(heroRow, heroCol + 1)) {
                if (chars[heroRow][heroCol + 1] != '.') {
                    chars[heroRow][heroCol + 1] = '.';
                    applyMove(heroRow, heroCol + 1);
                    chars[heroRow][heroCol - 1] = '.';
                    return chars[heroRow][heroCol];
                } else {
                    applyMove(heroRow, heroCol + 1);
                    chars[heroRow][heroCol - 1] = '.';
                    return chars[heroRow][heroCol];
                }
            } else {
                return 'X';
            }

        } else if (direction == 2) {
            if (isValidMove(heroRow + 1, heroCol)) {
                if (chars[heroRow + 1][heroCol] != '.') {
                    chars[heroRow + 1][heroCol] = '.';
                    applyMove(heroRow + 1, heroCol);
                    chars[heroRow - 1][heroCol] = '.';
                    return chars[heroRow][heroCol];
                } else {
                    applyMove(heroRow + 1, heroCol);
                    chars[heroRow - 1][heroCol] = '.';
                    return chars[heroRow][heroCol];
                }
            } else {
                return 'X';
            }

        } else if (direction == 3) {
            if (isValidMove(heroRow, heroCol - 1)) {
                if (chars[heroRow][heroCol - 1] != '.') {
                    chars[heroRow][heroCol - 1] = '.';
                    applyMove(heroRow, heroCol - 1);
                    chars[heroRow][heroCol + 1] = '.';
                    return chars[heroRow][heroCol];
                } else {
                    applyMove(heroRow, heroCol - 1);
                    chars[heroRow][heroCol + 1] = '.';
                    return chars[heroRow][heroCol];
                }
            } else {
                return 'X';
            }
        } else {
            return 'X';
        }
    }
}








