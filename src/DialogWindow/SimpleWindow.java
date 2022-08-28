package DialogWindow;

//Сделайте так, чтобы при нажатии на пробел появлялось информационное окно, в котором написано ваше имя

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class SimpleWindow {
    public static void main(String[] args) {
        JFrame frame = new JFrame(); //создаем пустое окно
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //завершает работу JFrame  и освобождает память
        frame.getContentPane().setBackground(Color.PINK.brighter()); //устанавливаем цвет фона окна
        frame.setSize(600, 600); //устанавливаем размер окна
        frame.setLocationRelativeTo(null); // выравниваем окно по центру
        frame.setVisible(true); //делаем окно видимым

        //добавляем прослушивателя для получения событий клавиатуры на панель
        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e){
                if (e.getKeyCode() == KeyEvent.VK_SPACE) { //если нажата клавиша "пробел"
                    //выводит простое диалоговое окно с заголовком «Message»
                    JOptionPane.showMessageDialog(null, "Олеся"); //parentComponent -  компонент, который определяет фрейм, в котором отображается диалоговое окно; если null, или если parentComponent не имеет рамки, используется рамка по умолчанию
                }
            }
        });
    }
}



