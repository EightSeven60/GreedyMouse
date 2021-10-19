import Classes.Cat;
import Classes.Mouse;
import GUI.AppFrame;

import javax.swing.*;

public class GreedyMouse {
    public static void main(String[] args) {
        AppFrame appFrame = new AppFrame();

        Cat tom = appFrame.getTom();
        Mouse jerry = appFrame.getJerry();
        JLabel tomLabel = appFrame.getTomLabel();

        ImageIcon death = new ImageIcon("images/death50x50.png");
        
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            /*
            //old cat movement algorithm - random
            if (tom.getxCoord() > 1280 - tom.getWidth()) {
                tom.setSpeedX(tom.getSpeedX() * (-1));
            }
            if (tom.getyCoord() > 720 - tom.getHeight() - 50) {
                tom.setSpeedY(tom.getSpeedY() * (-1));
            }
            */
            if (tom.getxCoord() - jerry.getxCoord() < 0) { //if tom is left of jerry
                if (tom.getSpeedX() < 0) {
                    tom.setSpeedX(tom.getSpeedX() * -1);
                }
            }
            else { //if tom is right of jerry
                if (tom.getSpeedX() > 0) {
                    tom.setSpeedX(tom.getSpeedX() * -1);
                }
            }
            if (tom.getyCoord() - jerry.getyCoord() > 0) { //if tom is higher than jerry
                if (tom.getSpeedY() > 0) {
                    tom.setSpeedY(tom.getSpeedY() * -1);
                }
            }
            else { //if tom is lower than jerry
                if (tom.getSpeedY() < 0) {
                    tom.setSpeedY(tom.getSpeedY() * -1);
                }
            }
            if (Math.abs(tom.getxCoord() - jerry.getxCoord()) < 5 &&
                Math.abs(tom.getyCoord() - jerry.getyCoord()) < 5) {
                JOptionPane.showMessageDialog(appFrame, "You got caught by the cat!", "Game Over", JOptionPane.INFORMATION_MESSAGE, death);
                System.exit(0);
            }
            tom.setxCoord(tom.getxCoord() + tom.getSpeedX());
            tom.setyCoord(tom.getyCoord() + tom.getSpeedY());
            tomLabel.setLocation(tom.getxCoord(), tom.getyCoord());
        }
    }
}
