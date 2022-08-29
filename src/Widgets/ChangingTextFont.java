package Widgets;

// Добавьте слайдер для изменения размеров вашей надписи. Размер шрифта должен колебаться от 5 до 100 пикселей

import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;

public class ChangingTextFont {
    public static void main(String[] args) {
        JFrame frame = new JFrame(); //создаем пустое окно
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //завершает работу JFrame  и освобождает память
        frame.setSize(800, 600); //устанавливаем размер окна
        frame.setLocationRelativeTo(null); // выравниваем окно по центру
        frame.setVisible(true); //делаем окно видимым
        //создаем лейбл
        JLabel label = new JLabel("Моя первая надпись!");
        //метод задает выравнивание содержимого лейбла по оси X
        label.setHorizontalAlignment(SwingConstants.CENTER); //размещаем лейбл по центру
        //класс Font представляет шрифты, которые используются для визуального отображения текста
        label.setFont(new Font("Arial", Font.ITALIC, 50));
        //устанавливаем цвет шрифта
        label.setForeground(Color.RED);
        //создаем слайдер с 4-мя параметрами: ориентация ползунка, минимальное, максимальное и текущее значения
        JSlider sl = new JSlider(JSlider.VERTICAL,5,100,50);

        // настраиваем внешний вид ползунков
        sl.setMajorTickSpacing(5); //устанавливаем  расстояние для прорисовки больших делений
        sl.setPaintTicks(true); //включаем  прорисовку делений

        /* Присоединяем слушателя событий
        Все слушатели, связанные с ползунком, получают событие ChangeEvent. Для того, чтобы получать извещения об изменении значения ползунка,
        нужно создать объект, реализующий интерфейс ChangeListener, и вызвать метод addChangeListener() */
        sl.addChangeListener(e ->
            label.setFont(new Font("Arial", Font.ITALIC, sl.getValue()))); //sl.getValue() возвращает текущее значение ползунка
        frame.add(label);
        frame.add(sl, BorderLayout.WEST);
    }
}



