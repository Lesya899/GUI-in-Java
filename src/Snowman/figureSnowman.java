package Snowman;

import javax.swing.JComponent;
import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.BasicStroke;

public class figureSnowman extends JComponent {


    //определяем размер окна
    public Dimension getPreferredSize() {
        return new Dimension(700, 700);
    }


    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g; //Graphics2D определяет текущее графическое состояние, а также методы графического вывода
        g2.setBackground(Color.WHITE); //устанавливаем цвет фона

        //создаем нижний круг снеговика
        g2.setColor(Color.white);
        g2.fillOval(210, 400, 285, 270); //заполняет овал, ограниченный указанным прямоугольником, текущим цветом
        g2.setColor(Color.BLACK);
        //атрибуты класса BasicStroke описывают форму пера, нарисованного вдоль траектории пути, и декорации, применяемые в местах соединения сегментов пути, а также в местах их начала и конца
        g2.setStroke(new BasicStroke(3)); //устанавливаем ширину пера
        g2.drawOval(210, 400, 285, 270);

        //рисуем среднюю часть
        g2.setColor(Color.white);
        g2.fillOval(240, 275, 225, 210);
        g2.setColor(Color.BLACK);
        g2.drawOval(240, 275, 225, 210);

        //рисуем голову снеговика
        g2.setColor(Color.white);
        g2.fillOval(280, 170, 150, 140);
        g2.setColor(Color.BLACK);
        g2.drawOval(280, 170, 150, 140);

        //рисуем кружочки на средней части снеговика
        g2.setColor(Color.BLACK);
        g2.setStroke(new BasicStroke(2));
        g2.drawOval(360, 350, 10, 10);
        g2.drawOval(360, 375, 10, 10);
        g2.drawOval(360, 400, 10, 10);

        //прорисовываем элементы на лице
        g2.setColor(Color.BLACK);
        g2.drawOval(340, 220, 12, 12); //левый глаз
        g2.drawOval(380, 220, 12, 12); //правый глаз
        g2.drawOval(330, 270, 10, 10); //начало рта
        g2.drawOval(345, 275, 10, 10);
        g2.drawOval(362, 275, 10, 10);
        g2.drawOval(380, 270, 10, 10);

        /*Рисуем нос с помощью Polygon
        Класс Polygon инкапсулирует описание замкнутой двумерной области в координатном пространстве. Эта область
        ограничена произвольным количеством отрезков, каждый из которых является одной стороной многоугольника */
        int [] x = {360,365,450};
        int [] y = {240,255,240};
        //задаются вершины многоугольника  и их число
        g2.drawPolygon(x, y, 3);

        //рисуем шляпу
        g2.setColor(Color.white);
        g2.fillOval(260, 160, 190, 30); //заполняет овал белым  цветом
        g2.setColor(Color.BLACK); //устанавливаем черный цвет
        g2.setStroke(new BasicStroke(3)); //устанавливаем ширину пера
        g2.drawOval(260, 160, 190, 30); //рисует контур овала черным цветом
        g2.setColor(Color.white);
        g2.fillRoundRect(310, 95, 95, 70, 15, 15); //заполняем прямоугольник белым цветом
        g2.setColor(Color.BLACK);
        g2.drawRoundRect(310, 95, 95, 70, 15, 15); //прорисовываем контур прямоугольника с закругленными углами черным цветом
        g2.drawLine(310, 145, 405, 145);

        //рисуем правую руку
        g2.setColor(Color.white);
        g2.fillPolygon(new int[] {460, 590, 605, 615, 605,650,655,610,645,640,595,465},
                new int[] {350, 300, 250,255, 295,280, 290,310,335,345,315,365},
                12);
        g2.setColor(Color.black);
        g2.drawPolygon(new int[] {460, 590, 605, 615, 605,650,655,610,645,640,595,465},
                new int[] {350, 300, 250,255, 295,280, 290,310,335,345,315,365},
                12);

        //рисуем левую руку
        g2.setColor(Color.white);
        g2.fillPolygon(new int[] {265, 105, 90, 80, 90,45,40,85,50,55,100,260},
                new int[] {345, 300, 250,255, 295,280, 290,310,335,345,315,365},
                12);
        g2.setColor(Color.black);
        g2.drawPolygon(new int[] {265, 105, 90, 80, 90,45,40,85,50,55,100,260},
                new int[] {350, 300, 250,255, 295,280, 290,310,335,345,315,365},
                12);
    }
}

