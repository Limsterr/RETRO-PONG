public class Score {
    int player1Score = 0;
    int player2Score = 0;
    public void addP1Score() {
        player1Score ++;
    }
    public void addP2Score() {
        player2Score ++;
    }
    public String displayP1Score() {
        String s = Integer.toString(player1Score);
        return s;
    }
    public String displayP2Score() {
        String s = Integer.toString(player2Score);
        return s;
    }
}
