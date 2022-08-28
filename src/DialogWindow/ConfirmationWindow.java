package DialogWindow;

/*Задайте пользователю два любых вопроса с возможностью ответа Да/Нет с помощью двух окон подтверждения выбора.
 По результатам ответов, выдайте какой - либо ответ (должно быть готово 4 варианта ответа - для каждого из варианта ответов) в виде информационного окна */

import javax.swing.*;
import java.awt.*;

public class ConfirmationWindow {
    public static void main(String[] args) {
        JFrame frame = new JFrame(); //создаем пустое окно
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //завершает работу JFrame  и освобождает память
        frame.getContentPane().setBackground(Color.PINK.brighter()); //устанавливаем цвет фона окна
        frame.setSize(600, 600); //устанавливаем размер окна
        frame.setLocationRelativeTo(null); // выравниваем окно по центру
        frame.setVisible(true); //делаем окно видимым
        UIManager.put("OptionPane.minimumSize",new Dimension(350, 120)); //меняем размер диалогового окна
        ImageIcon icon1 = new ImageIcon("./src/Images/img1.png"); //загружаем картинки для иконок
        ImageIcon icon2 = new ImageIcon("./src/Images/img2.png");
        ImageIcon icon3 = new ImageIcon("./src/Images/img3.png");
        ImageIcon icon4 = new ImageIcon("./src/Images/img4.png");
        // создаем окна с вопросами
        int input1 = JOptionPane.showConfirmDialog(null, "Вы  занимаетесь спортом?", "Вопрос №1", JOptionPane.YES_NO_CANCEL_OPTION);
        int input2 = JOptionPane.showConfirmDialog(null, "Вы не употребляете вредную еду?", "Вопрос №2", JOptionPane.YES_NO_CANCEL_OPTION);
        if (input1 == 0 && input2==0 ) { //если на оба вопроса выбрано "Да"
            JOptionPane.showMessageDialog(null, "Правильное решение!", "Ответ", JOptionPane.INFORMATION_MESSAGE, icon1); //INFORMATION_MESSAGE - стандартное диалоговое окно для вывода информации со значком соответствующего вида
        }
        else if(input1 == 0 && input2!=0) { //если на первый вопрос "Да", а на второй выбрано "Нет"
            JOptionPane.showMessageDialog(null, "Сладкое вызывает усталость!", "Ответ", JOptionPane.INFORMATION_MESSAGE, icon2 );
        }
        else if(input1 != 0 && input2==0) { //если на первый вопрос "Нет", а на второй выбрано "Да"
            JOptionPane.showMessageDialog(null,"Спорт улучшает настроение!", "Ответ",JOptionPane.INFORMATION_MESSAGE, icon3 );
        }
        else if(input1 != 0 && input2!=0) { //если на оба вопроса "Нет"
            JOptionPane.showMessageDialog(null, "Плохо!", "Ответ", JOptionPane.INFORMATION_MESSAGE, icon4);

        }
    }
}






