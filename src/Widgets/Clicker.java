package Widgets;

//Создайте элементарное приложение - кликер. В вашем приложении должны быть кнопка и надпись. В надписи должна выводится информация о том, сколько раз кнопка была нажата.

import javax.swing.*;
import java.awt.*;


public class Clicker {
    static int count = 0;
    public static void main(String[] args) {
        JFrame frame = new JFrame(); //создаем пустое окно
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //завершает работу JFrame  и освобождает память
        frame.setSize(400, 400); //устанавливаем размер окна
        frame.setLocationRelativeTo(null); // выравниваем окно по центру
        JPanel panel = new JPanel(); //создаем панель
        panel.setBackground(Color.pink.brighter()); //устанавливаем цвет панели
        panel.setLayout (new FlowLayout(FlowLayout.CENTER)); // последовательное расположение с выравниванием компонентов по центру
        //создаем лейбл
        JLabel label = new JLabel("" + count++);
        //класс Font представляет шрифты, которые используются для визуального отображения текста
        label.setFont(new Font("Arial", Font.CENTER_BASELINE, 30));
        //устанавливаем цвет шрифта
        label.setForeground(Color.BLACK);
        //создаем кнопку со значком
        JButton button = new JButton(new ImageIcon("./src/Images/icons8.png"));
        //добавляем слушателя событий
        button.addActionListener (e -> {
            label.setText("" + count++);
        });
        frame.add(panel);
        panel.add(button);
        panel.add(label);
        frame.setVisible(true); //делаем окно видимым
    }
}



