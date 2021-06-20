import java.util.Arrays;


public class Map {
    char[][] chars;
    int rows;
    int cols;
    public Map (int rows, int cols){
        chars = new char[rows][cols];
        this.rows = rows;
        this.cols = cols;
        for (char[] aChar : chars) {
            Arrays.fill(aChar, '.');
        }
    }
    public Map(char[][] mapTemplate){
        this.rows = mapTemplate.length;
        this.cols = mapTemplate[0].length;
        chars = new char[mapTemplate.length][mapTemplate[0].length];
        chars = mapTemplate.clone();
    }
    public String toString(){
        for (int i = 0; i < chars.length; i++) {
            System.out.println(chars[i]);
        }
        return "";

    }
    public void addWalls(){
        for (int i = 0; i < chars.length; i++) {
            chars[i][0] = 'X';
            chars[i][chars[i].length -1] = 'X';
        }
        Arrays.fill(chars[0], 'X');
        Arrays.fill(chars[chars.length - 1], 'X');



    }
    public void addItems(int numOfItems){
        char[] items = new char[numOfItems];
        for (int i = 0; i < numOfItems; i++) {
            items[i] = (char)(i+1 + '0');
        }

        int counter = 0;
        int itemCounter = 0;
        while (counter < numOfItems){
            int r = GameData.randomRoll(0, rows);
            int c = GameData.randomRoll(0, cols);
            if(chars[r][c] != 'X'){
                chars[r][c] = items[itemCounter];
                counter++;
                itemCounter++;
            }
        }

    }


}
