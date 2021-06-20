import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;

public class FileLoader {
    public static Map loadMap(String fileName) throws IOException {
        FileReader fileReader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader); //created a buffered reader to read a line from a file
        char[] data = String.valueOf(bufferedReader.readLine()).toCharArray(); //converts first 2 numbers in to a char array
        int row = Integer.parseInt(String.valueOf(data[0])); // parse to int from char array
        int col = Integer.parseInt(String.valueOf(data[1])); // parse from int to char array
        char[][] clearData = new char[row][col]; // create a clear array to pass it to Map method
        data = String.valueOf(bufferedReader.readLine()).toCharArray(); // skips blank line
        for (int i = 0; i < row; i++) { // loop for cloning data from old array
            data = String.valueOf(bufferedReader.readLine()).toCharArray();
            for (int j = 0; j < col; j++) {
                clearData[i][j] = data[j];
            }
        }
        Map map = new Map(clearData);
        return map;
    }

}
