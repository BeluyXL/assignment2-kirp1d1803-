import java.util.Arrays;


public class Map {
    char[][] chars;
    public Map (int rows, int cols){
        chars = new char[rows][cols];
        for (char[] aChar : chars) {
            Arrays.fill(aChar, '.');
        }
    }
    public Map(char[][] mapTemplate){
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


}
