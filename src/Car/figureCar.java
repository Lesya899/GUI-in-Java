package Car;

import javax.swing.JComponent;
import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.BasicStroke;
import java.awt.geom.Path2D;
import java.awt.geom.Line2D;
import java.awt.geom.Arc2D;

public class figureCar extends JComponent {


    //определяем размер окна
    public Dimension getPreferredSize() {
        return new Dimension(600, 400);
    }


    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g; //Graphics2D определяет текущее графическое состояние, а также методы графического вывода
        g2.setBackground(Color.WHITE); //устанавливаем цвет фона

        //рисуем корпус машины
        g2.setStroke(new BasicStroke(5));////устанавливаем ширину пера
        //Класс Path2D определяет геометрический путь с координатами
        // Arc2D.Double () создает новую дугу, инициализированную с указанным местоположением, размером, угловыми размерами и типом замыкания
        Path2D car = new Path2D.Double(new Arc2D.Double(370, 235, 130, 130, 0, 180, Arc2D.OPEN));
        car.append(new Line2D.Double(370, 300, 230, 300), true);
        car.append(new Arc2D.Double(100, 235, 130, 130, 0, 180, Arc2D.OPEN), true);
        car.append(new Line2D.Double(100, 300, 50, 300), true);
        //метод curveTo() добавляет криволинейный сегмент, определяемый тремя новыми точками, к пути путем рисования кривой Безье, которая пересекает как текущие координаты, так и указанные координаты
        car.curveTo(50, 300, 30, 275, 50, 260);
        car.curveTo(50, 260, 50, 215, 75, 170);
        car.curveTo(75, 170, 270, 0, 435, 170);
        car.curveTo(435, 170, 590, 160, 575, 275);
        car.curveTo(575, 275, 590, 290, 575, 300);
        car.closePath();
        g2.setColor(Color.green.darker());
        g2.fill(car);
        g2.setColor(Color.black);
        g2.draw(car);

        //рисуем левое окно
        Path2D leftWindow = new Path2D.Double(new Line2D.Double(250, 170, 140, 170));
        leftWindow.curveTo(140, 170, 210, 125, 250, 130);
        leftWindow.closePath();
        g2.setColor(Color.lightGray);
        g2.fill(leftWindow);
        g2.setColor(Color.black);
        g2.draw(leftWindow);

        //рисуем правое окно
        Path2D rightWindow = new Path2D.Double(new Line2D.Double(270, 170, 270, 130));
        rightWindow.curveTo(270, 130, 320, 125, 385, 170);
        rightWindow.closePath();
        g2.setColor(Color.lightGray);
        g2.fill(rightWindow);
        g2.setColor(Color.black);
        g2.draw(rightWindow);

        //рисуем остальные детали машины
        g2.drawLine(285, 195, 315, 195);
        Path2D p = new Path2D.Double(new Line2D.Double(530, 215, 530, 215));
        p.curveTo(530, 215, 570, 210, 565, 250);
        p.curveTo(565, 250, 525, 255, 530, 215);
        g2.setColor(Color.orange.darker());
        g2.fill(p);
        g2.setColor(Color.black);
        g2.draw(p);

        //рисуем колеса
        g2.setColor(Color.white);
        g2.fillOval(128, 260, 75, 75);//рисуем левое колесо
        g2.fillOval(398, 260, 75, 75);////рисуем правое колесо
        g2.setColor(Color.black);
        g2.setStroke(new BasicStroke(30));
        g2.drawOval(128, 260, 75, 75);
        g2.drawOval(398, 260, 75, 75);

    }
}

