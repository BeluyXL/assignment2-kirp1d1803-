import java.awt.event.KeyEvent;
import java.io.IOException;


public class Game {


    public static boolean isHeroActive(Map map){ // checks if there is any items on the map
        boolean status = false;
        for (int i = 0; i < map.chars.length; i++) {
            for (int j = 0; j < map.chars[i].length; j++) {
                if(map.chars[i][j] != 'X' && map.chars[i][j] != '.'){
                    status = true;
                    break;
                }
            }
        }
        return status;
    }
    private static int getInput(){ // listens to user's input
        if(StdDraw.isKeyPressed(KeyEvent.VK_UP)){
            return 0;
        }else if(StdDraw.isKeyPressed(KeyEvent.VK_RIGHT)){
            return 1;
        }else if (StdDraw.isKeyPressed(KeyEvent.VK_DOWN)){
            return 2;
        }else if (StdDraw.isKeyPressed(KeyEvent.VK_LEFT)){
            return 3;
        }else {
            return -1;
        }

    }
    public static void main(String[] args) throws IOException, InterruptedException {
        Map fileLoader = FileLoader.loadMap("mapFile.txt");
        Hero fileReader = FileReader.loadHero("HeroFile.txt");
        fileLoader.addItems(4);
        fileLoader.initHeroLocation();
        while (true){
            StdDraw.show(50);
            fileLoader.hero.getItemsCollected();
            fileLoader.processInput(getInput());
            System.out.println(fileLoader);
            System.out.println(fileReader);

            }







    }


}
