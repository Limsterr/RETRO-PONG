public class Paddle {
    public static final int width = 20;
    public static final int height = 130;
    public static final double velocity = 8;
    public int Position = Constants.SCREEN_HEIGHT / 2 - height / 2;
    public boolean checkCollision (int position) {
        if (position <= 40)
            return true;
        else if (position >= Constants.SCREEN_HEIGHT - Paddle.height - 40)
            return true;

        return false;
    }
}
