import java.io.File;
import java.io.IOException;
import javax.sound.sampled.*;
public class SoundEffect {
    File bFile = new File("Bounce.wav");
    File sFile = new File("Score.wav");

    public void bounceSound() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(bFile);
        Clip clip = AudioSystem.getClip();
        clip.open(audioStream);
        clip.start();
    }

    public void scoreSound() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(sFile);
        Clip clip = AudioSystem.getClip();
        clip.open(audioStream);
        clip.start();
    }
}
