package Animation;

/*Создайте на вашей панели объект с любой картинкой из интернета (размер 50х50). Реализуйте движение вашего объекта
 с помощью стрелочек (по 50 пикселей в необходимую сторону). Сделайте так, чтобы ваш объект не мог выбраться за пределы окна.
  Движение объекта должно происходить только после того, как пользователь отпускает клавишу.
 */

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class SimpleMoving extends JComponent implements ActionListener, KeyListener{
    public Timer timer = new Timer(10,this);
    public int x = 260;
    public int y = 260;
    public BufferedImage image;


    public SimpleMoving() {

        this.setPreferredSize(new Dimension(600, 600));

        try {
            image = ImageIO.read(new File("./src/Images/rabbit.jpg"));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void keyPressed(KeyEvent e) {}

    /* Метод keyReleased вызывается при отпускании клавиши
    Метод getKeyCode, позволяет узнать код клавиши, которая была нажата;
    Класс KeyEvent содержит набор констант, каждая константа содержит код соответствующей клавиши*/

    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) { //если нажата клавиша вправо
            if (x < 510) {
                x = x + 50;
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {  //если нажата клавиша влево
            if (x > 10) {
                x = x - 50;
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) { //если нажата клавиша вверх
            if (y > 10) {
                y = y - 50;
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) { //если нажата клавиша вниз
            if (y < 510) {
                y = y + 50;
            }
        }
    }
    public void keyTyped(KeyEvent e) {}

    // то, что мы хотим, чтобы программа выполняла при срабатывании события
    @Override
    public void actionPerformed(ActionEvent arg0) {
        repaint();//перерисовывает изображение
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D graf = (Graphics2D) g;
        graf.drawImage(image, x, y, this);
        timer.start();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.getContentPane().setBackground(Color.white);
        SimpleMoving s = new SimpleMoving();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(s);
        frame.addKeyListener(s);
        frame.pack();
        frame.setVisible(true);
    }
}

