import javax.swing.*;
import java.awt.*;

public class CountdownPanel extends JPanel {
    private int count = 3;
    private final GameFrame frame;
    private Timer timer;

    public CountdownPanel(GameFrame frame) {
        this.frame = frame;
        setPreferredSize(new Dimension(600, 600));
        setBackground(Color.BLACK);

        timer = new Timer(1000, e -> {
            count--;
            repaint();
            if (count == 0) {
                timer.stop();
                frame.showGamePanel();
            }
        });
    }

    public void startCountdown() {
        count = 3;
        repaint();
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (count > 0) {
            g.setColor(Color.GREEN);
            g.setFont(new Font("Arial", Font.BOLD, 120));
            String text = String.valueOf(count);
            FontMetrics metrics = g.getFontMetrics();
            int x = (getWidth() - metrics.stringWidth(text)) / 2;
            int y = (getHeight() - metrics.getHeight()) / 2 + metrics.getAscent();
            g.drawString(text, x, y);
        }
    }
}