package Animation;

//Сделайте так, чтобы при нажатии на левую кнопку мыши, в том месте, где вы щёлкнули по панели, появился новый объект

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class SimpleAdd {
    public static void main(String[] args)  {
        JFrame f = new JFrame(); //создаем окно
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(600, 600);
        f.setLocationRelativeTo(null); // выравниваем окно по центру
        JPanel panel = new JPanel(); // создаем панель
        f.add(panel); // добавляем панель в окно

        //добавляем прослушивателя для получения событий мыши на панель
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e){ //метод вызывается при нажатии кнопки мыши на компоненте
                if (e.getButton() == 1) { //если нажали левую кнопку
                    try {
                        File file = new File("./src/Images/dragon.jpg");
                        BufferedImage image = ImageIO.read(file); //загружаем картинку
                        JLabel label = new JLabel(new ImageIcon(image)); //создаем лейбл с загруженной картинкой
                        label.setBounds(e.getX(), e.getY(), 150, 150); // положение и размер картинки
                        panel.add(label);
                        label.repaint();
                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    }

                }
            }
        });
        f.setVisible(true); // делаем окно видимым
    }
}

