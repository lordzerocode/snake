import javax.swing.*;

public class GameFrame extends JFrame {
    private MenuPanel menuPanel;
    private CountdownPanel countdownPanel;
    private GamePanel gamePanel;

    public GameFrame() {
        menuPanel = new MenuPanel(this);
        countdownPanel = new CountdownPanel(this);
        this.add(menuPanel);
        this.setTitle("Snake");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

    public void showCountdownPanel() {
        this.getContentPane().removeAll();
        this.add(countdownPanel);
        this.pack();
        this.revalidate();
        this.repaint();
        countdownPanel.startCountdown();
    }

    public void showGamePanel() {
        this.getContentPane().removeAll();
        gamePanel = new GamePanel();
        this.add(gamePanel);
        this.pack();
        this.revalidate();
        this.repaint();
        gamePanel.requestFocusInWindow();
    }
}
