import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

public class FlappyBirdGame implements ActionListener, KeyListener {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;

    private JFrame frame;
    private Renderer renderer;
    private Rectangle bird;
    private ArrayList<Rectangle> pipes;

    private int ticks, yMotion, score;
    private boolean gameOver, started;

    public FlappyBirdGame() {
        frame = new JFrame();
        renderer = new Renderer();
        bird = new Rectangle(WIDTH / 2 - 10, HEIGHT / 2 - 10, 20, 20);
        pipes = new ArrayList<>();

        Timer timer = new Timer(20, this);

        frame.add(renderer);
        frame.setTitle("Flappy Bird");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WIDTH, HEIGHT);
        frame.addKeyListener(this);
        frame.setResizable(false);
        frame.setVisible(true);

        addPipe(true);
        addPipe(true);
        addPipe(true);
        addPipe(true);

        timer.start();
    }

    private void addPipe(boolean start) {
        int space = 200;
        int width = 100;
        int height = 50 + new Random().nextInt(300);

        if (start) {
            pipes.add(new Rectangle(WIDTH + width + pipes.size() * 300, HEIGHT - height - 120, width, height));
            pipes.add(new Rectangle(WIDTH + width + (pipes.size() - 1) * 300, 0, width, HEIGHT - height - space));
        } else {
            pipes.add(new Rectangle(pipes.get(pipes.size() - 1).x + 600, HEIGHT - height - 120, width, height));
            pipes.add(new Rectangle(pipes.get(pipes.size() - 1).x, 0, width, HEIGHT - height - space));
        }
    }

    private void jump() {
        if (gameOver) {
            bird = new Rectangle(WIDTH / 2 - 10, HEIGHT / 2 - 10, 20, 20);
            pipes.clear();
            yMotion = 0;
            score = 0;

            addPipe(true);
            addPipe(true);
            addPipe(true);
            addPipe(true);

            gameOver = false;
        }

        if (!started) {
            started = true;
        } else if (!gameOver) {
            if (yMotion > 0) {
                yMotion = 0;
            }
            yMotion -= 10;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int speed = 10;

        if (started) {
            ticks++;

            for (int i = 0; i < pipes.size(); i++) {
                Rectangle pipe = pipes.get(i);
                pipe.x -= speed;
            }

            if (ticks % 2 == 0 && yMotion < 15) {
                yMotion += 2;
            }

            for (int i = 0; i < pipes.size(); i++) {
                Rectangle pipe = pipes.get(i);

                if (pipe.x + pipe.width < 0) {
                    pipes.remove(pipe);

                    if (pipe.y == 0) {
                        addPipe(false);
                    }
                }
            }

            bird.y += yMotion;

            for (Rectangle pipe : pipes) {
                if (pipe.y == 0 && bird.x + bird.width / 2 > pipe.x + pipe.width / 2 - 10
                        && bird.x + bird.width / 2 < pipe.x + pipe.width / 2 + 10) {
                    score++;
                }

                if (pipe.intersects(bird)) {
                    gameOver = true;

                    if (bird.x <= pipe.x) {
                        bird.x = pipe.x - bird.width;
                    } else {
                        if (pipe.y != 0) {
                            bird.y = pipe.y - bird.height;
                        } else if (bird.y < pipe.height) {
                            bird.y = pipe.height;
                        }
                    }
                }
            }

            if (bird.y > HEIGHT - 120 || bird.y < 0) {
                gameOver = true;
            }

            if (bird.y + yMotion >= HEIGHT - 120) {
                bird.y = HEIGHT - 120 - bird.height;
                gameOver = true;
            }
        }

        renderer.repaint();
    }

    public void paintPipe(Graphics g, Rectangle pipe) {
        g.setColor(Color.green.darker());
        g.fillRect(pipe.x, pipe.y, pipe.width, pipe.height);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            jump();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    public static void main(String[] args) {
        new FlappyBirdGame();
    }

    private class Renderer extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            // Background
            g.setColor(Color.cyan);
            g.fillRect(0, 0, WIDTH, HEIGHT);

            // Ground
            g.setColor(Color.orange);
            g.fillRect(0, HEIGHT - 120, WIDTH, 120);

            g.setColor(Color.green);
            g.fillRect(0, HEIGHT - 120, WIDTH, 20);

            // Bird
            g.setColor(Color.red);
            g.fillRect(bird.x, bird.y, bird.width, bird.height);

            // Pipes
            for (Rectangle pipe : pipes) {
                paintPipe(g, pipe);
            }

            // Score
            g.setColor(Color.white);
            g.setFont(new Font("Arial", Font.BOLD, 50));

            if (!started) {
                g.drawString("Press SPACE to Start", 150, HEIGHT / 2 - 50);
            }

            if (gameOver) {
                g.drawString("Game Over!", 300, HEIGHT / 2 - 50);
                g.drawString("Score: " + score, 300, HEIGHT / 2);
            }

            if (!gameOver && started) {
                g.drawString("Score: " + score, 20, 50);
            }
        }
    }
}