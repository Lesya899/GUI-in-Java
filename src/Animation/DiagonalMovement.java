package Animation;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import javax.swing.Timer;
import java.io.IOException;


public class DiagonalMovement extends JComponent implements ActionListener {
    public Timer timer; // класс Timer запускает один или несколько ActionEvents через указанные промежутки времени
    public int x = 0;
    public int y = 0;
    public BufferedImage image;


    public DiagonalMovement(int delay) {
        timer = new Timer(delay, this);//параметр delay - задержка, параметр listener - к какому обработчику событий подключить
        try {
            image = ImageIO.read(new File("./src/Images/cat.jfif"));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public Dimension getPreferredSize() {

        return new Dimension(700, 700);
    }


    // то, что мы хотим, чтобы программа выполняла при срабатывании события
    @Override
    public void actionPerformed(ActionEvent arg0) {

        repaint();//перерисовывает изображение
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(image, x, y, this); //метод тянет изображение в определенном расположении
        if (x != 700 && y != 700) {
            x++;
            y++;
        }
          else {
            x = -40;
            y = -40;
        }
          timer.start();//запускает Timer, в результате чего он начинает отправлять события действий своим слушателям
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.getContentPane().setBackground(Color.white);
        final DiagonalMovement m = new DiagonalMovement(10);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(m);
        frame.pack();
        frame.setVisible(true);
    }
}


