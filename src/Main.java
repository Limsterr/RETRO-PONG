import java.io.IOException;
import javax.sound.sampled.*;

public class Main {
    public static void main(String[] args) throws InterruptedException, UnsupportedAudioFileException, IOException, LineUnavailableException {
        MainMenu menu = new MainMenu(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT, Constants.SCREEN_TITLE);

        while (true) {
            menu.drawMain();
            menu.getInput();
            Thread.sleep(70);
        }
    }
}
