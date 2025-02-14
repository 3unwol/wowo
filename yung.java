import javax.swing.*;
import java.awt.*;

public class yung extends JPanel {

    private String[] lyrics = {
            "I'm not good with letters but, I hope this will convey", 
            "how deep my love runs for you.",
            "Throughout our relationship, you have been nothing but,", 
            "accepting, understanding, loving, caring, and attentive.",
            "I never knew I'd have a heart someone could hold",
            "until you came into my life.",
            "During the first few weeks of us being together,",
            "I would be lying if I said I wasn't a bit scared that",
            "You'd maybe lose feelings after getting to know me more.",
            "But you assured me all the way with your everlasting warmth,", 
            "blanketing me in a loving embrace.",
            "I hope you know how special you are in my heart.",
            "I don't want to only know the great parts about you,", 
            "I want to know everything about you.",
            "Your habits, interests, scars, what makes you laugh,",
            "How I can reassure and understand you through your worries,",
            "What makes you feel loved and cared for,",
            "And the unique individuality of makes you, you.",
            " I feel privileged that I get to your girlfriend, hopefully a long-term one.",
            "Even if we're busy, we remain in each other's minds and hearts,",
            "Which is what makes our bond so special.",
            "Despite the LDR, I can clearly feel your love coursing through me.",
            "I want to love you thoroughly,",
            "Accept you fully,",
            "Care for you unlimitedly,",
            "And be there for you eternally.",
            "Happy Valentine's Day, Zecariah.",
            "I hope this letter wasn't too cringe for you.",
            "My heart was racing so much writing this huhu.",
            "With that being said, I love you."
    };

    private int[] delays = {
            400, 300, 300, 400, 3300, 400, 400, 400, 400, 400, 400, 400,
            400, 400, 400, 400, 400, 3000, 400, 400, 400, 400, 400, 1000
    };

    private int currentIndex = 0;
    private String currentLine = "";
    private int currentCharIndex = 0;
    private ImageIcon backgroundGif;

    public yung() {
        setPreferredSize(new Dimension(1280, 720));
        backgroundGif = new ImageIcon("pinksky.gif");
        new Thread(() -> {
            try {
                while (currentIndex < lyrics.length) {
                    if (currentCharIndex < lyrics[currentIndex].length()) {
                        currentLine += lyrics[currentIndex].charAt(currentCharIndex);
                        currentCharIndex++;
                        repaint();
                        Thread.sleep(110);
                    } else {
                        Thread.sleep(delays[currentIndex]);
                        currentIndex++;
                        currentLine = "";
                        currentCharIndex = 0;
                        repaint();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundGif != null) {
            g.drawImage(backgroundGif.getImage(), 0, 0, getWidth(), getHeight(), this);
        }
        g.setFont(new Font("Serif", Font.PLAIN, 42));
        g.setColor(Color.decode("#C02D6F"));

        // Hitung posisi tengah vertikal
        int stringWidth = g.getFontMetrics().stringWidth(currentLine);
        int x = (getWidth() - stringWidth) / 2;
        int y = getHeight() / 2;

        // Gambar lirik di tengah
        g.drawString(currentLine, x, y);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Lyrics");
        yung panel = new yung();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
