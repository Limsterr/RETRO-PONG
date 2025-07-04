import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.*;
import java.io.IOException;
import static java.awt.event.KeyEvent.*;

public class MainMenu extends SimpleGameWindow{
    public int pointerPos = 400;
    public MainMenu(int width, int height, String title) {
        super(width, height, title);
    }
    public void drawMain () {
        this.drawText("RETRO PONG", 100, 350, 200, Color.YELLOW);
        this.drawText("SINGLE PLAYER (VS AI)", 40, 50, 400, Color.CYAN);
        this.drawText("LOCAL MULTIPLAYER", 40, 50, 400+100, Color.CYAN);
        this.drawText("THEMES", 40, 50, 400+200, Color.CYAN);
        this.drawText("QUIT", 40, 50, 400+300, Color.CYAN);
        this.drawText("BY LIMSTER", 30, 1100, 780, Color.GRAY);
    }
    public void drawSelector () {
        this.drawText("DIFFICULTY", 60, 50, 270, Color.WHITE);
        this.drawText("POTATO", 40, 50, 400, Color.CYAN);
        this.drawText("AVERAGE", 40, 50, 400+100, Color.CYAN);
        this.drawText("PRO", 40, 50, 400+200, Color.CYAN);
    }
    public void drawThemes() {
        this.drawText("THEMES", 60, 50, 180, Color.WHITE);
        this.drawText("DEFAULT", 40, 50, 300, Color.CYAN);
        this.drawText("IMPERIAL", 40, 50, 300+100, Color.CYAN);
        this.drawText("ALLIANCE", 40, 50, 300+200, Color.CYAN);
        this.drawText("REY", 40, 50, 300+300, Color.CYAN);
    }
    public void getInput () throws InterruptedException, UnsupportedAudioFileException, LineUnavailableException, IOException {
        if (this.isKeyPressed(VK_DOWN)) {
            this.clear();
            this.drawMain();
            pointerPos += 100;
            if (pointerPos > 700)
                pointerPos = 700;

            this.drawText(">", 40, 10, pointerPos, Color.red);
        }
        else if (this.isKeyPressed(VK_UP)) {
            this.clear();
            this.drawMain();
            pointerPos -= 100;
            if (pointerPos < 400)
                pointerPos = 400;

            this.drawText(">", 40, 10, pointerPos, Color.red);

        }

        Game newGame = new Game();
        AI ai = new AI();
        Themes themes = new Themes();
        if (this.isKeyPressed(VK_ENTER)) {
            switch (pointerPos) {
                case 400:
                    this.keyPressed[VK_ENTER] = false;
                    ai.getDifficulty(Themes.backgroundColor, Themes.actorColor);
                    break;
                case 500:
                    this.keyPressed[VK_ENTER] = false;
                    newGame.multiplayer(Themes.backgroundColor, Themes.actorColor);
                    break;
                case 600:
                    themes.selector();
                    break;
                default:
                    this.terminate();
            }
        }
    }
}
