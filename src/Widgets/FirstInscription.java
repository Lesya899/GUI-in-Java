package Widgets;

/* Создайте окно произвольного размера, в центре которого разместите JLabel с текстом "Моя первая надпись!".
Измените шрифт вашему JLabel на любой, который вам понравится, курсив, размер 50 */

import javax.swing.*;
import java.awt.*;


public class FirstInscription {
    public static void main(String[] args) {
        JFrame frame = new JFrame(); //создаем пустое окно
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //завершает работу JFrame  и освобождает память
        frame.getContentPane().setBackground(Color.YELLOW.brighter()); //устанавливаем цвет фона окна
        frame.setSize(600, 400); //устанавливаем размер окна
        frame.setLocationRelativeTo(null); // выравниваем окно по центру
        frame.setVisible(true); //делаем окно видимым
        //создаем лейбл
        JLabel label = new JLabel("Моя первая надпись!");
        //метод задает выравнивание содержимого лейбла по оси X
        label.setHorizontalAlignment(SwingConstants.CENTER); //размещаем лейбл по центру
        //класс Font представляет шрифты, которые используются для визуального отображения текста
        label.setFont(new Font("Arial", Font.ITALIC, 50));
        //устанавливаем цвет шрифта
        label.setForeground(Color.BLUE);
        frame.add(label);
    }
}
