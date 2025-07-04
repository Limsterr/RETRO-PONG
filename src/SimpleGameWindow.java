import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.Queue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class SimpleGameWindow {
    private JFrame frame;
    private JPanel panel;
    private Image image;

    private int width;
    private int height;
    public boolean isPressed = false;
    public static boolean isTerminated = false;
    public int x = 0, y = 0;

    public boolean[] keyPressed = new boolean[128];
    private Queue<Character> keyQueue;

    public SimpleGameWindow(int width, int height, String title)
    {
        this.height = height;
        this.width = width;

        keyQueue = new LinkedList<>();

        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        frame = new JFrame(title);
        panel = new JPanel(true) {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(image, 0, 0, null); //TODO: Attend null observer later
            }
        };

        // *Moded*
        frame.setSize(width, height+37);
        panel.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(panel, BorderLayout.CENTER);
        frame.setFocusable(false);
        panel.setFocusable(true);
        panel.requestFocus();
        frame.setResizable(false);

        KeyListener keyListener = new KeyListener() {
            @Override
            public void keyPressed(KeyEvent e) {
                keyPressed[e.getKeyCode()] = true;
            }

            @Override
            public void keyReleased(KeyEvent e) {
                keyPressed[e.getKeyCode()] = false;
            }

            @Override
            public void keyTyped(KeyEvent ke) {
                keyQueue.add(ke.getKeyChar());
            }
        };

        panel.addKeyListener(keyListener);

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                frame.setVisible(true);
            }
        });
    }
    public boolean isKeyPressed(int keyCode) {
        return keyPressed[keyCode];
    }
    public void drawCircle(int x, int y, int r, Color color)
    {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Graphics2D g2d = (Graphics2D) image.getGraphics();
                g2d.setColor(color);
                g2d.fillOval(x - r, y - r, r, r);
                panel.repaint();
            }
        });
    }

    // *Added* Method To Draw a Rectangle To The Screen
    public void drawRect (int x, int y, int width, int height, Color color) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Graphics2D g2d = (Graphics2D) image.getGraphics();
                g2d.setColor(color);
                g2d.fillRect(x, y, width, height);
                panel.repaint();
            }
        });
    }

    // *Added* Method To Draw a Text To The Screen
    public void drawText(String text, int size, int x, int y, Color color) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Graphics2D g2d = (Graphics2D) image.getGraphics();
                Font font = new Font("Impact", Font.PLAIN, size);
                g2d.setColor(color);
                g2d.setFont(font);
                g2d.drawString(text, x, y);
                panel.repaint();
            }
        });
    }
    public void terminate () {
        frame.setVisible(false);
        frame.dispose();
//        frame.disable();
//        panel.disable();
    }

    public void clear() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Graphics2D g2d = (Graphics2D) image.getGraphics();
                g2d.clearRect(0, 0, width, height);
                panel.repaint();
            }
        });
    }

    public Character getKey() {
        if (!keyQueue.isEmpty())
            return keyQueue.poll();
        return null;
    }
}
