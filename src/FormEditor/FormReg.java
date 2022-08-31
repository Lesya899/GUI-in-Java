package FormEditor;

/* Создайте форму для регистрации на какое-либо мероприятие, используя графический интерфейс.
 В вашей форме должно быть не менее 10 вопросов. Внизу формы должна быть кнопка "Отправить", после нажатия на которую
 все введённые данные должны отобразится в  информационном окошке JOptionPane. */

import javax.swing.*;
import java.awt.*;


public class FormReg extends JFrame {
    private JPanel panel;
    private JLabel label2;
    private JLabel label3;
    private JLabel label1;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    private JLabel label7;
    private JLabel label8;
    private JLabel label9;
    private JLabel label10;
    private JTextField textField2;
    private JTextField textField1;
    private JRadioButton radioButton1;
    private JRadioButton radioButton2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JRadioButton radioButton3;
    private JRadioButton radioButton4;
    private JRadioButton radioButton5;
    private JRadioButton radioButton6;
    private JTextField textField6;
    private JRadioButton radioButton7;
    private JRadioButton radioButton8;
    private JButton button;
    private ButtonGroup buttonGroup1;

    private ButtonGroup buttonGroup4;
    private ButtonGroup buttonGroup3;
    private ButtonGroup buttonGroup2;


    public FormReg(String title) {
        super(title);

        setContentPane(panel);
        this.pack();

        button.addActionListener(e -> new JOptionPane().showMessageDialog(null, "ФИО:  " + textField1.getText() + "\n" + "Возраст:  " + textField2.getText() +
                "\n" + "Пол:  " + buttonGroup1.getSelection().getActionCommand() + "\n" + "Телефон:  " + textField3.getText() + "\n" + "Электронная почта:  " + textField4.getText() +
                "\n" + "Место работы:  " + textField5.getText() + "\n" + "Форма участия:  " + buttonGroup2.getSelection().getActionCommand() + "\n" +
                "Сборник тезисов:  " + buttonGroup3.getSelection().getActionCommand() + "\n" + "Название доклада:  " + textField6.getText() +
                "\n" + "Бронировать место для проживания?   " + buttonGroup4.getSelection().getActionCommand()));
    }

    public static void main(String[] args) {
        FormReg fr = new FormReg("Форма регистрации");
        fr.setVisible(true);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setLocationRelativeTo(null); // выравниваем окно по центру
        fr.setSize(new Dimension(600, 600));

    }
}






