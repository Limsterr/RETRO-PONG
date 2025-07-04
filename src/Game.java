import javax.sound.sampled.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

import static java.awt.event.KeyEvent.*;

public class Game {
    public void multiplayer (Color backGroundColor, Color actorColor) throws InterruptedException, UnsupportedAudioFileException, LineUnavailableException, IOException {
        SimpleGameWindow screen = new SimpleGameWindow(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT, Constants.SCREEN_TITLE);

        Score playerScore = new Score();
//        SoundEffect sound = new SoundEffect();

        Paddle paddle1 = new Paddle();
        Paddle paddle2 = new Paddle();

        Ball ball = new Ball();

        //Game Loop
        while (true) {
            screen.clear();
            // Paint Screen
            screen.drawRect(0, 0, 1280, 800, backGroundColor);

            // Draw Borders
            for (int i = 10; i <= 740; i += 40)
                screen.drawRect(Constants.SCREEN_WIDTH/2-7, 20 + i, 14, 20, actorColor);

            screen.drawRect(0, 26, Constants.SCREEN_WIDTH, 14, actorColor);
            screen.drawRect(0, Constants.SCREEN_HEIGHT - 40, Constants.SCREEN_WIDTH, 14, actorColor);

            // Display Player Scores
            screen.drawText (playerScore.displayP1Score(), 100, 320, 135, actorColor);
            screen.drawText (playerScore.displayP2Score(), 100, Constants.SCREEN_WIDTH - 370, 135, actorColor);

            // Draw Paddles
            screen.drawRect(80, paddle1.Position, Paddle.width, Paddle.height, actorColor);
            screen.drawRect(Constants.SCREEN_WIDTH - Paddle.width - 80, paddle2.Position, Paddle.width, Paddle.height, actorColor);

            // Move Ball
            Ball.x = ball.move(Ball.xVelocity, Ball.x);
            Ball.y = ball.move(Ball.yVelocity, Ball.y);

            // Draw Ball
            screen.drawCircle(Ball.x, Ball.y, Ball.radius, actorColor);

            // Check Collision With Walls
            if (ball.checkCollision(paddle1.Position, paddle2.Position) == 1) {
//                sound.bounceSound();
                Ball.yVelocity *= -1;
            }

            // Check Collision With Paddles
            if (ball.checkCollision(paddle1.Position, paddle2.Position) == 2) {
//                sound.bounceSound();
                Ball.xVelocity *= -1;
            }

            // Scoring
            if (Ball.x >= Constants.SCREEN_WIDTH - Ball.radius) {
                playerScore.addP1Score();
//                sound.scoreSound();
                ball.reset();
            }
            else if (Ball.x <= 0) {
                playerScore.addP2Score();
//                sound.scoreSound();
                ball.reset();
            }

            // Check GameOver
            if (playerScore.player1Score == Constants.MAX_SCORE || playerScore.player2Score == Constants.MAX_SCORE) {
                screen.clear();
                break;
            }

            // Handle Input For Paddles
            if (screen.isKeyPressed(VK_UP)) {
                paddle2.Position -= Paddle.velocity;
                if (paddle2.checkCollision(paddle2.Position))
                    paddle2.Position = 40;
            }
            else if (screen.isKeyPressed(VK_DOWN)) {
                paddle2.Position += Paddle.velocity;
                if (paddle2.checkCollision(paddle2.Position))
                    paddle2.Position = Constants.SCREEN_HEIGHT - Paddle.height - 40;
            }
            if (screen.isKeyPressed(VK_W)) {
                paddle1.Position -= Paddle.velocity;
                if (paddle1.checkCollision(paddle1.Position))
                    paddle1.Position = 40;
            }
            else if (screen.isKeyPressed(VK_S)) {
                paddle1.Position += Paddle.velocity;
                if (paddle1.checkCollision(paddle1.Position))
                    paddle1.Position = Constants.SCREEN_HEIGHT - Paddle.height - 40;
            }

            Thread.sleep(10);
        }
        if (playerScore.player1Score == Constants.MAX_SCORE) {
            screen.clear();
            screen.drawRect(0, 0, 1280, 800, backGroundColor);
            screen.drawText("PLAYER 1 WINS!", 120, 256, 400, actorColor);
            Thread.sleep(2000);
            screen.terminate();
        }
        else if (playerScore.player2Score == Constants.MAX_SCORE) {
            screen.clear();
            screen.drawRect(0, 0, 1280, 800, backGroundColor);
            screen.drawText("PLAYER 2 WINS!", 120, 256, 400, actorColor);
            Thread.sleep(2000);
            screen.terminate();
        }
    }
    public void singlePlayer (Color backGroundColor, Color actorColor, int difficulty) throws InterruptedException {
        SimpleGameWindow screen = new SimpleGameWindow(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT, Constants.SCREEN_TITLE);

        Score playerScore = new Score();
//        SoundEffect sound = new SoundEffect();

        Paddle paddle1 = new Paddle();
        Paddle paddle2 = new Paddle();

        Ball ball = new Ball();

        //Game Loop
        while (true) {
            screen.clear();
            // Paint Screen
            screen.drawRect(0, 0, 1280, 800, backGroundColor);

            // Draw Borders
            for (int i = 10; i <= 740; i += 40)
                screen.drawRect(Constants.SCREEN_WIDTH/2-7, 20 + i, 14, 20, actorColor);

            screen.drawRect(0, 26, Constants.SCREEN_WIDTH, 14, actorColor);
            screen.drawRect(0, Constants.SCREEN_HEIGHT - 40, Constants.SCREEN_WIDTH, 14, actorColor);

            // Display Player Scores
            screen.drawText (playerScore.displayP1Score(), 100, 320, 135, actorColor);
            screen.drawText (playerScore.displayP2Score(), 100, Constants.SCREEN_WIDTH - 370, 135, actorColor);

            // Draw Paddles
            screen.drawRect(80, paddle1.Position, Paddle.width, Paddle.height, actorColor);
            screen.drawRect(Constants.SCREEN_WIDTH - Paddle.width - 80, paddle2.Position, Paddle.width, Paddle.height, actorColor);

            // Move Ball
            Ball.x = ball.move(Ball.xVelocity, Ball.x);
            Ball.y = ball.move(Ball.yVelocity, Ball.y);

            // Draw Ball
            screen.drawCircle(Ball.x, Ball.y, Ball.radius, actorColor);

            // Check Collision With Walls
            if (ball.checkCollision(paddle1.Position, paddle2.Position) == 1) {
//                sound.bounceSound();
                Ball.yVelocity *= -1;
            }

            // Check Collision With Paddles
            if (ball.checkCollision(paddle1.Position, paddle2.Position) == 2) {
//                sound.bounceSound();
                Ball.xVelocity *= -1;
            }

            // Scoring
            if (Ball.x >= Constants.SCREEN_WIDTH - Ball.radius) {
                playerScore.addP1Score();
//                sound.scoreSound();
                ball.reset();
            }
            else if (Ball.x <= 0) {
                playerScore.addP2Score();
//                sound.scoreSound();
                ball.reset();
            }

            // Check GameOver
            if (playerScore.player1Score == Constants.MAX_SCORE || playerScore.player2Score == Constants.MAX_SCORE) {
                screen.clear();
                break;
            }
            if (Ball.x > 640) {
                AI controller = new AI();
                paddle2.Position = controller.controller(difficulty, Ball.y, paddle2.Position);
                if (paddle2.Position < 40)
                    paddle2.Position = 40;
                else if (paddle2.Position > Constants.SCREEN_HEIGHT - Paddle.height - 40)
                    paddle2.Position = Constants.SCREEN_HEIGHT - Paddle.height - 40;
            }

            // Handle Input For Paddle
            if (screen.isKeyPressed(VK_W)) {
                paddle1.Position -= Paddle.velocity;
                if (paddle1.checkCollision(paddle1.Position))
                    paddle1.Position = 40;
            }
            else if (screen.isKeyPressed(VK_S)) {
                paddle1.Position += Paddle.velocity;
                if (paddle1.checkCollision(paddle1.Position))
                    paddle1.Position = Constants.SCREEN_HEIGHT - Paddle.height - 40;
            }

            Thread.sleep(10);
        }
        if (playerScore.player1Score == Constants.MAX_SCORE) {
            screen.clear();
            screen.drawRect(0, 0, 1280, 800, backGroundColor);
            screen.drawText("YOU WIN!", 120, 350, 400, actorColor);
            Thread.sleep(2000);
            screen.terminate();
        }
        else if (playerScore.player2Score == Constants.MAX_SCORE) {
            screen.clear();
            screen.drawRect(0, 0, 1280, 800, backGroundColor);
            screen.drawText("BOT WINS!", 120, 350, 400, actorColor);
            Thread.sleep(2000);
            screen.terminate();
        }
    }
}
