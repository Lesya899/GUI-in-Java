package DialogWindow;

//Создайте приложение, которое вызовет диалоговое окно с возможностью ввода имени в текстовое поле. Пользователь должен ввести в это поле своё имя и нажать кнопку ок. После чего должно появиться информационное окно, подобное предыдущей задаче, но с тем именем, которое ввёл пользователь в предыдущее окно.

import javax.swing.*;
import java.awt.*;

public class TwoWindow {
    public static void main(String[] args) {
        JFrame frame = new JFrame(); //создаем пустое окно
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //завершает работу JFrame  и освобождает память
        frame.getContentPane().setBackground(Color.PINK.brighter()); //устанавливаем цвет фона окна
        frame.setSize(600, 600); //устанавливаем размер окна
        frame.setLocationRelativeTo(null); // выравниваем окно по центру
        frame.setVisible(true); //делаем окно видимым
        String str = JOptionPane.showInputDialog(null,"Введите имя"); //метод  запрашивает ввод имени пользователя
        JOptionPane.showMessageDialog(null, str); //выводим диалоговое окно с введенным именем
    }
}
