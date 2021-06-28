import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileReader {
    public static Hero loadHero(String heroFile) throws IOException {  // this method loads Hero from the texts file
        BufferedReader bufferedReader = new BufferedReader(new java.io.FileReader(heroFile));
        Hero hero = new Hero(bufferedReader.readLine(), Integer.parseInt(bufferedReader.readLine()));
        int itemCount = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < itemCount; i++) {
            Item item = new Item(bufferedReader.readLine());
            hero.collectItem(item);
        }
        return hero;

    }



}
