import java.awt.*;

import static java.awt.event.KeyEvent.*;

public class Themes {
    public static Color backgroundColor = Color.blue;
    public static Color actorColor = Color.WHITE;

    public void selector() throws InterruptedException {
        MainMenu menu = new MainMenu(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT, Constants.SCREEN_TITLE);
        while (true) {
            menu.drawThemes();
            if (menu.isKeyPressed(VK_DOWN)) {
                menu.clear();
                menu.drawThemes();
                menu.pointerPos += 100;
                if (menu.pointerPos > 600)
                    menu.pointerPos = 600;
                menu.drawText(">", 40, 10, menu.pointerPos, Color.red);
            } else if (menu.isKeyPressed(VK_UP)) {
                menu.clear();
                menu.drawThemes();
                menu.pointerPos -= 100;
                if (menu.pointerPos < 300)
                    menu.pointerPos = 300;
                menu.drawText(">", 40, 10, menu.pointerPos, Color.red);

            }
            Game newGame = new Game();
            if (menu.isKeyPressed(VK_ENTER)) {
                switch (menu.pointerPos) {
                    case 300:
                        backgroundColor = Color.blue;
                        actorColor = Color.WHITE;
                        menu.terminate();
                        break;
                    case 400:
                        backgroundColor = Color.RED;
                        actorColor = Color.BLACK;
                        menu.terminate();
                        break;
                    case 500:
                        backgroundColor = Color.GREEN;
                        actorColor = Color.blue;
                        menu.terminate();
                        break;
                    default:
                        backgroundColor = Color.orange;
                        actorColor = Color.GRAY;
                        menu.terminate();
                }
                break;
            }
            Thread.sleep(70);
        }
    }
}
