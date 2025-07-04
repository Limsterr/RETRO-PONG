import java.util.Random;

public class Ball {
    public static int radius = 20;
    public static double xVelocity = 6;
    public static double yVelocity = 6;
    public static int x = Constants.SCREEN_WIDTH / 2 - radius / 2;
    public static int y = Constants.SCREEN_HEIGHT / 2 - radius / 2;

    Random rand = new Random();
    public int move(double velocity, int position) {
        position += velocity;

        return position;
    }
    public int checkCollision(int p1, int p2) {
        if (Ball.y <= 40 + Ball.radius || Ball.y + 40 >= Constants.SCREEN_HEIGHT - Ball.radius/2)
            return 1;
        else if ((Ball.x - 80 <= Paddle.width + Ball.radius && Ball.y + Ball.radius >= p1 && Ball.y <= p1 + Paddle.height) ||
                (Ball.x + 80 >= (Constants.SCREEN_WIDTH - Paddle.width) - Ball.radius/2 && Ball.y + Ball.radius >= p2 && Ball.y <= p2 + Paddle.height))
            return 2;

        return 0;
    }
    public void reset() throws InterruptedException {
        Thread.sleep(1000);
        Ball.x = Constants.SCREEN_WIDTH / 2 - Ball.radius / 2;
        Ball.y = Constants.SCREEN_HEIGHT / 2 - Ball.radius / 2;
        Ball.xVelocity *= -1;
        Ball.yVelocity = rand.nextDouble() * 8 - 4; // Random Y Velocity Between -4 & 4
    }
}
