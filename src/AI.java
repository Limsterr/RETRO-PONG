import java.awt.*;
import static java.awt.event.KeyEvent.*;

public class AI {
    public int controller (int velocity, int ballPosition, int paddlePosition) {
        if (paddlePosition < ballPosition) {
            paddlePosition += velocity;
        }
        else if (paddlePosition > ballPosition){
            paddlePosition -= velocity;
        }
        return paddlePosition;
    }
    public void getDifficulty (Color backgroungColor, Color actorColor) throws InterruptedException {
        MainMenu menu = new MainMenu(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT, Constants.SCREEN_TITLE);
        while (true) {
            menu.drawSelector();
            if (menu.isKeyPressed(VK_DOWN)) {
                menu.clear();
                menu.drawSelector();
                menu.pointerPos += 100;
                if (menu.pointerPos > 600)
                    menu.pointerPos = 600;
                menu.drawText(">", 40, 10, menu.pointerPos, Color.red);
            } else if (menu.isKeyPressed(VK_UP)) {
                menu.clear();
                menu.drawSelector();
                menu.pointerPos -= 100;
                if (menu.pointerPos < 400)
                    menu.pointerPos = 400;
                menu.drawText(">", 40, 10, menu.pointerPos, Color.red);
            }
            Game newGame = new Game();
            if (menu.isKeyPressed(VK_ENTER)) {
                switch (menu.pointerPos) {
                    case 300:
                        menu.keyPressed[VK_ENTER] = false;
                        newGame.singlePlayer(backgroungColor, actorColor, 2);
                        menu.terminate();
                        break;
                    case 400:
                        menu.keyPressed[VK_ENTER] = false;
                        newGame.singlePlayer(backgroungColor, actorColor, 3);
                        menu.terminate();
                    break;
                    default:
                        menu.keyPressed[VK_ENTER] = false;
                        newGame.singlePlayer(backgroungColor, actorColor, 6);
                        menu.terminate();
                }
                break;
            }
            Thread.sleep(70);
        }
    }
}
