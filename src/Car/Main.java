package Car;

//Пользуясь полученными знаниями, нарисуйте Машинку, похожую на ту, что на картинке

import javax.swing.JFrame;


public class Main {
    public static void main(String[] args) {
        //создаем пустое окно
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new figureCar());
        //метод позволяет «упаковать» имеющиеся в окне компоненты, так чтобы они занимали столько места, сколько им необходимо
        frame.pack();
        //компоненты переходят в «видимое» состояние и начинают обслуживаться очередью событий
        frame.setVisible(true);
    }
}

