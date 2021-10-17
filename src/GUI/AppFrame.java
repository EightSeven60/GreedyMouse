package GUI;

import Classes.Cat;
import Classes.Cheese;
import Classes.Mouse;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class AppFrame extends JFrame {
    protected final int WINDOW_WIDTH = 1280;
    protected final int WINDOW_HEIGHT = 720;

    protected Mouse jerry;
    protected Cat tom;
    protected Cheese cheese1;
    protected Cheese cheese2;
    protected Cheese cheese3;

    protected ImageIcon jerryIcon;
    protected ImageIcon cheeseIcon;
    protected ImageIcon catIcon;
    protected ImageIcon backgroundIcon;
    protected ImageIcon death;

    protected JPanel contentPane;
    protected JPanel playAreaPanel;
    protected JPanel statsAreaPanel;

    protected JLabel healthLabel;
    protected JLabel jerryLabel;
    protected JLabel tomLabel;
    protected JLabel cheese1Label;
    protected JLabel cheese2Label;
    protected JLabel cheese3Label;
    protected JLabel background;

    protected void detectAndEatCheese() {
        int colorValue;
        Random random = new Random();

        int newHealth = jerry.getHealth() + 100;
        colorValue = (int)((0.0002 * Math.pow(newHealth, 2)) - (0.4250 * newHealth) + 255);
        if (colorValue > 255) {
            colorValue = 255;
        }
        else if (colorValue < 0) {
            colorValue = 0;
        }

        if ( (Math.abs(cheese1.getxCoord() - jerry.getxCoord()) < 10) && (Math.abs(cheese1.getyCoord() - jerry.getyCoord()) < 10) ) {
            cheese1 = new Cheese(
                    Math.abs(random.nextInt()) % (WINDOW_WIDTH - 50),
                    Math.abs(random.nextInt()) % (WINDOW_HEIGHT - 50 - 50 - 50));
            cheese1Label.setLocation(cheese1.getxCoord(), cheese1.getyCoord());
            jerry.addHealth(100);
            if (jerry.getHealth() >= 2500) {
                JOptionPane.showMessageDialog(this,
                        "You died of obesity, you fat [beautiful person]!",
                        "Game over", JOptionPane.INFORMATION_MESSAGE, death);
                System.exit(0);
            }
            healthLabel.setText("Health: "+ jerry.getHealth());
            healthLabel.setForeground(new Color(colorValue, 255 - colorValue, 0));

        }
        if ( (Math.abs(cheese2.getxCoord() - jerry.getxCoord()) < 10) && (Math.abs(cheese2.getyCoord() - jerry.getyCoord()) < 10) ) {
            cheese2 = new Cheese(
                    Math.abs(random.nextInt()) % (WINDOW_WIDTH - 50),
                    Math.abs(random.nextInt()) % (WINDOW_HEIGHT - 50 - 50 - 50));
            cheese2Label.setLocation(cheese2.getxCoord(), cheese2.getyCoord());
            jerry.addHealth(100);
            if (jerry.getHealth() >= 2500) {
                JOptionPane.showMessageDialog(this,
                        "You died of obesity, you fat [beautiful person]!",
                        "Game over", JOptionPane.INFORMATION_MESSAGE, death);
                System.exit(0);
            }
            healthLabel.setText("Health: "+ jerry.getHealth());
            healthLabel.setForeground(new Color(colorValue, 255 - colorValue, 0));
        }
        if ( (Math.abs(cheese3.getxCoord() - jerry.getxCoord()) < 10) && (Math.abs(cheese3.getyCoord() - jerry.getyCoord()) < 10) ) {
            cheese3 = new Cheese(
                    Math.abs(random.nextInt()) % (WINDOW_WIDTH - 50),
                    Math.abs(random.nextInt()) % (WINDOW_HEIGHT - 50 - 50 - 50));
            cheese3Label.setLocation(cheese3.getxCoord(), cheese3.getyCoord());
            jerry.addHealth(100);
            if (jerry.getHealth() >= 2500) {
                JOptionPane.showMessageDialog(this,
                        "You died of obesity, you fat [beautiful person]!",
                        "Game over", JOptionPane.INFORMATION_MESSAGE, death);
                System.exit(0);
            }
            healthLabel.setText("Health: "+ jerry.getHealth());
            healthLabel.setForeground(new Color(colorValue, 255 - colorValue, 0));
        }
    }
    protected class UpAction extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {
            int speed = (int)(-0.01 * jerry.getHealth() + 25);
            jerryLabel.setLocation(jerryLabel.getX(), jerryLabel.getY() - speed);
            jerry.setxCoord(jerry.getxCoord());
            jerry.setyCoord(jerry.getyCoord() - speed);
            detectAndEatCheese();
        }
    }
    protected class DownAction extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {
            int speed = (int)(-0.01 * jerry.getHealth() + 25);
            jerryLabel.setLocation(jerryLabel.getX(), jerryLabel.getY() + speed);
            jerry.setxCoord(jerry.getxCoord());
            jerry.setyCoord(jerry.getyCoord() + speed);
            detectAndEatCheese();
        }
    }
    protected class LeftAction extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {
            int speed = (int)(-0.01 * jerry.getHealth() + 25);
            jerryLabel.setLocation(jerryLabel.getX() - speed, jerryLabel.getY());
            jerry.setxCoord(jerry.getxCoord() - speed);
            jerry.setyCoord(jerry.getyCoord());
            detectAndEatCheese();
        }
    }
    protected class RightAction extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {
            int speed = (int)(-0.01 * jerry.getHealth() + 25);
            jerryLabel.setLocation(jerryLabel.getX() + speed, jerryLabel.getY());
            jerry.setxCoord(jerry.getxCoord() + speed);
            jerry.setyCoord(jerry.getyCoord());
            detectAndEatCheese();
        }
    }

    Action upAction;
    Action downAction;
    Action leftAction;
    Action rightAction;

    public AppFrame() {
        jerryIcon = new ImageIcon("images/mouse50x50.png");
        cheeseIcon = new ImageIcon("images/cheese50x50.png");
        catIcon = new ImageIcon("images/cat50x50.png");
        backgroundIcon = new ImageIcon("images/background.jpg");
        death = new ImageIcon("images/death50x50.png");


        upAction = new UpAction();
        downAction = new DownAction();
        leftAction = new LeftAction();
        rightAction = new RightAction();

        this.setLayout(new BorderLayout());
        //this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Random random = new Random();

        jerry = new Mouse((WINDOW_WIDTH - 50) / 2, (WINDOW_HEIGHT - 50 - 50) / 2);
        //jerry.addHealth(1500);
        cheese1 = new Cheese(Math.abs(random.nextInt()) % (WINDOW_WIDTH - 50), Math.abs(random.nextInt()) % (WINDOW_HEIGHT - 50 - 50 - 50));
        cheese2 = new Cheese(Math.abs(random.nextInt()) % (WINDOW_WIDTH - 50), Math.abs(random.nextInt()) % (WINDOW_HEIGHT - 50 - 50 - 50));
        cheese3 = new Cheese(Math.abs(random.nextInt()) % (WINDOW_WIDTH - 50), Math.abs(random.nextInt()) % (WINDOW_HEIGHT - 50 - 50 - 50));
        tom = new Cat(Math.abs(random.nextInt()) % (WINDOW_WIDTH - 50), Math.abs(random.nextInt()) % (WINDOW_HEIGHT - 50 - 50 - 50));

        healthLabel = new JLabel("Health: "+ jerry.getHealth());
        healthLabel.setVisible(true);
        healthLabel.setHorizontalAlignment(JLabel.CENTER);
        healthLabel.setVerticalTextPosition(JLabel.CENTER);
        healthLabel.setFont(new Font(Font.SERIF, Font.BOLD, 40));
        healthLabel.setForeground(new Color(200, 50, 50));

        statsAreaPanel = new JPanel(new BorderLayout());
        statsAreaPanel.setBackground(new Color(50, 50, 100));
        statsAreaPanel.setOpaque(true);
        statsAreaPanel.setPreferredSize(new Dimension(0, 50));
        statsAreaPanel.add(healthLabel, BorderLayout.CENTER);
        statsAreaPanel.setVisible(true);

        jerryLabel = new JLabel(jerryIcon);
        jerryLabel.setSize(jerry.getWidth(), jerry.getHeight());
        jerryLabel.setLocation(jerry.getxCoord(), jerry.getyCoord());
        jerryLabel.getInputMap().put(KeyStroke.getKeyStroke('w'), "upMovement");
        jerryLabel.getActionMap().put("upMovement", upAction);
        jerryLabel.getInputMap().put(KeyStroke.getKeyStroke('s'), "downMovement");
        jerryLabel.getActionMap().put("downMovement", downAction);
        jerryLabel.getInputMap().put(KeyStroke.getKeyStroke('a'), "leftMovement");
        jerryLabel.getActionMap().put("leftMovement", leftAction);
        jerryLabel.getInputMap().put(KeyStroke.getKeyStroke('d'), "rightMovement");
        jerryLabel.getActionMap().put("rightMovement", rightAction);
        //jerryLabel.setBackground(new Color(0, 0, 255));
        //jerryLabel.setOpaque(true);
        jerryLabel.setVisible(true);

        cheese1Label = new JLabel(cheeseIcon);
        cheese1Label.setSize(cheese1.getWidth(), cheese1.getHeight());
        cheese1Label.setLocation(cheese1.getxCoord(), cheese1.getyCoord());
        cheese1Label.setVisible(true);

        cheese2Label = new JLabel(cheeseIcon);
        cheese2Label.setSize(cheese2.getWidth(), cheese2.getHeight());
        cheese2Label.setLocation(cheese2.getxCoord(), cheese2.getyCoord());
        cheese2Label.setVisible(true);

        cheese3Label = new JLabel(cheeseIcon);
        cheese3Label.setSize(cheese3.getWidth(), cheese3.getHeight());
        cheese3Label.setLocation(cheese3.getxCoord(), cheese3.getyCoord());
        cheese3Label.setVisible(true);

        background = new JLabel(backgroundIcon);
        background.setSize(1280, 720);
        background.setLocation(0, 0);
        background.setVisible(true);

        playAreaPanel = new JPanel(null);
        //playAreaPanel.setBackground(new Color(0, 255, 0));
        //playAreaPanel.setOpaque(true);
        playAreaPanel.add(jerryLabel);
        playAreaPanel.add(cheese1Label);
        playAreaPanel.add(cheese2Label);
        playAreaPanel.add(cheese3Label);
        playAreaPanel.add(background);
        playAreaPanel.setVisible(true);

        contentPane = new JPanel(new BorderLayout());
        contentPane.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        contentPane.setBackground(new Color(100, 100, 100));
        contentPane.setOpaque(true);
        contentPane.add(statsAreaPanel, BorderLayout.NORTH);
        contentPane.add(playAreaPanel, BorderLayout.CENTER);
        contentPane.setVisible(true);

        this.setResizable(false);
        this.setIconImage(jerryIcon.getImage());
        this.setTitle("Greedy Mouse");
        this.setContentPane(contentPane);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public int getWINDOW_WIDTH() {
        return WINDOW_WIDTH;
    }
    public int getWINDOW_HEIGHT() {
        return WINDOW_HEIGHT;
    }
    public Mouse getJerry() {
        return jerry;
    }
    public Cat getTom() {
        return tom;
    }
    public Cheese getCheese1() {
        return cheese1;
    }
    public Cheese getCheese2() {
        return cheese2;
    }
    public Cheese getCheese3() {
        return cheese3;
    }
    public ImageIcon getJerryIcon() {
        return jerryIcon;
    }
    public ImageIcon getCheeseIcon() {
        return cheeseIcon;
    }
    public ImageIcon getCatIcon() {
        return catIcon;
    }
    public ImageIcon getBackgroundIcon() {
        return backgroundIcon;
    }
    public JPanel getPlayAreaPanel() {
        return playAreaPanel;
    }
    public JPanel getStatsAreaPanel() {
        return statsAreaPanel;
    }
    public JLabel getHealthLabel() {
        return healthLabel;
    }
    public JLabel getJerryLabel() {
        return jerryLabel;
    }
    public JLabel getTomLabel() {
        return tomLabel;
    }
    public JLabel getCheese1Label() {
        return cheese1Label;
    }
    public JLabel getCheese2Label() {
        return cheese2Label;
    }
    public JLabel getCheese3Label() {
        return cheese3Label;
    }
    public Action getUpAction() {
        return upAction;
    }
    public Action getDownAction() {
        return downAction;
    }
    public Action getLeftAction() {
        return leftAction;
    }
    public Action getRightAction() {
        return rightAction;
    }
    @Override
    public String toString() {
        return "AppFrame{" +
                "WINDOW_WIDTH=" + WINDOW_WIDTH +
                ", WINDOW_HEIGHT=" + WINDOW_HEIGHT +
                ", jerry=" + jerry +
                ", tom=" + tom +
                ", cheese1=" + cheese1 +
                ", cheese2=" + cheese2 +
                ", cheese3=" + cheese3 +
                ", jerryIcon=" + jerryIcon +
                ", cheeseIcon=" + cheeseIcon +
                ", catIcon=" + catIcon +
                ", backgroundIcon=" + backgroundIcon +
                ", contentPane=" + contentPane +
                ", playAreaPanel=" + playAreaPanel +
                ", statsAreaPanel=" + statsAreaPanel +
                ", healthLabel=" + healthLabel +
                ", jerryLabel=" + jerryLabel +
                ", tomLabel=" + tomLabel +
                ", cheese1Label=" + cheese1Label +
                ", cheese2Label=" + cheese2Label +
                ", cheese3Label=" + cheese3Label +
                ", background=" + background +
                ", upAction=" + upAction +
                ", downAction=" + downAction +
                ", leftAction=" + leftAction +
                ", rightAction=" + rightAction +
                ", rootPane=" + rootPane +
                ", rootPaneCheckingEnabled=" + rootPaneCheckingEnabled +
                ", accessibleContext=" + accessibleContext +
                ", accessibleContext=" + accessibleContext +
                '}';
    }
}
