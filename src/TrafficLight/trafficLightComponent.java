package TrafficLight;

import javax.swing.JComponent;
import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.Dimension;
import java.awt.geom.QuadCurve2D;
import java.awt.Point;
import java.awt.geom.Path2D;
import java.awt.geom.AffineTransform;


public class trafficLightComponent extends JComponent{


    //определяем размер окна
    public Dimension getPreferredSize() {
        return new Dimension(700, 800);
    }

    /*Класс Graphics является абстрактным базовым классом для всех графических объектов, которые позволяют приложению
     рисовать на компонентах, реализованных на различных устройствах,а также на изображениях за пределами экрана */

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setBackground(Color.LIGHT_GRAY); //устанавливаем цвет фона

        //создаем корпус светофора
        g2.setColor(Color.DARK_GRAY); //устанавливаем цвет для корпуса
        g2.fillRoundRect(270, 70, 150, 425, 35, 35); //создаем в указанных координатах прямоугольник с закругленными углами, заполненный заданным цветом
        g2.fillRoundRect(315, 502, 65, 80, 20, 20);
        g2.fillArc(293, 36, 102, 55, 0, 180); //метод закрашивает сектор, ограниченный дугой, задаваемой параметрами

        //создаем сигналы светофора
        g2.setColor(Color.red);
        g2.fillOval(294, 100, 100, 100);
        g2.setColor(Color.yellow);
        g2.fillOval(294, 230, 100, 100);
        g2.setColor(Color.green);
        g2.fillOval(294, 365, 100, 100);

        //создаем белые полуокружности над сигналами светофора
        g2.setColor(Color.white);
        Area area1 = new Area(new Ellipse2D.Double(286.5, 78, 115, 100));//new Area создает пустую область, а new Ellipse2D.Double создает и инициализирует эллипс из указанных координат
        Area area2 = new Area(new Ellipse2D.Double(286.5, 90, 115, 100));
        area1.subtract(area2); //вычитаем форму второго Area из формы первого Area. Результирующая форма Area будет включать области, которые содержались только в первом Area, а не во втором Area
        g2.fill(area1); //заполняет область цветом, указанным в настройках объекта т.е. белым

        area1 = new Area(new Ellipse2D.Double(286.5, 208, 115, 100));
        area2 = new Area(new Ellipse2D.Double(286.5, 222, 115, 100));
        area1.subtract(area2);
        g2.fill(area1);

        area1 = new Area(new Ellipse2D.Double(286.5, 345, 115, 100));
        area2 = new Area(new Ellipse2D.Double(286.5, 359, 115, 100));
        area1.subtract(area2);
        g2.fill(area1);

        //создаем треугольники с двух сторон корпуса
        //указываем координаты для первого треугольника слева
        Point coordinate1 = new Point(185,110);
        Point coordinate2 = new Point(260,110);
        Point coordinate3 = new Point(260,180);
        //применяем интерполяцию к координатам
        Point point1 = interpolate(coordinate1, coordinate2, 0.2);
        Point point2 = interpolate(coordinate1, coordinate2, 0.8);
        Point point3 = interpolate(coordinate2, coordinate3, 0.2);
        Point point4 = interpolate(coordinate2, coordinate3, 0.8);
        Point point5 = interpolate(coordinate3, coordinate1, 0.2);
        Point point6 = interpolate(coordinate3, coordinate1, 0.8);

        //устанавливаем цвет
        g2.setColor(Color.DARK_GRAY);
        //рисуем линии
        g2.drawLine(point1.x, point1.y, point2.x, point2.y);
        g2.drawLine(point3.x, point3.y, point4.x, point4.y);
        g2.drawLine(point5.x, point5.y, point6.x, point6.y);

        //QuadCurve2D определяет сегмент квадратичной параметрической кривой в (x,y) координатном пространстве т.е. создаем изгибы в треугольнике
        QuadCurve2D curve1 = new QuadCurve2D.Double(point2.x, point2.y, coordinate2.x, coordinate2.y, point3.x, point3.y);
        QuadCurve2D curve2 = new QuadCurve2D.Double(point4.x, point4.y, coordinate3.x, coordinate3.y, point5.x, point5.y);
        QuadCurve2D curve3 = new QuadCurve2D.Double(point6.x, point6.y, coordinate1.x, coordinate1.y, point1.x, point1.y);

        //рисуем треугольник
        g2.draw(curve1);
        g2.draw(curve2);
        g2.draw(curve3);

        //Класс Path2D определяет геометрический путь с координатами, хранящимися в формате Double
        Path2D path = new Path2D.Double();
        // Класс AffineTransform представляет двумерное аффинное преобразование, выполняющее линейное преобразование двухмерных координат в другие двумерные координаты
        AffineTransform affine = new AffineTransform();
        path.moveTo(point1.x, point1.y); //добавляет точку к пути путем перемещения к указанным координатам
        path.lineTo(point2.x, point2.y); //добавляет точку к пути, рисуя прямую линию от текущих координат до новых указанных координат
        //getPathIterator() возвращает объект итератора, который выполняет итерацию вдоль  границы формы и обеспечивает доступ к плоскому виду геометрии контура
        path.append(curve1.getPathIterator(affine), true); // append() добавляет геометрию указанного объекта к пути, соединяя новую геометрию с существующими сегментами пути с помощью сегмента линии
        path.lineTo(point4.x, point4.y);
        path.append(curve2.getPathIterator(affine), true);
        path.lineTo(point6.x, point6.y);
        path.append(curve3.getPathIterator(affine), true);
        path.closePath(); //закрывает текущий подконтур, рисуя прямую линию обратно к координатам последнего moveTo
        g2.fill(path);

        //рисуем второй треугольник слева
        //указываем координаты
        Point coordinate4 = new Point(185,230);
        Point coordinate5 = new Point(260,230);
        Point coordinate6 = new Point(260,300);

        Point point7 = interpolate(coordinate4, coordinate5, 0.2);
        Point point8 = interpolate(coordinate4, coordinate5, 0.8);
        Point point9 = interpolate(coordinate5, coordinate6, 0.2);
        Point point10 = interpolate(coordinate5, coordinate6, 0.8);
        Point point11 = interpolate(coordinate6, coordinate4, 0.2);
        Point point12 = interpolate(coordinate6, coordinate4, 0.8);
        g2.setColor(Color.DARK_GRAY);
        g2.drawLine(point7.x, point7.y, point8.x, point8.y);
        g2.drawLine(point9.x, point9.y, point10.x, point10.y);
        g2.drawLine(point11.x, point11.y, point12.x, point12.y);

        QuadCurve2D curve4 = new QuadCurve2D.Double(point8.x, point8.y, coordinate5.x, coordinate5.y, point9.x, point9.y);
        QuadCurve2D curve5 = new QuadCurve2D.Double(point10.x, point10.y, coordinate6.x, coordinate6.y, point11.x, point11.y);
        QuadCurve2D curve6 = new QuadCurve2D.Double(point12.x, point12.y, coordinate4.x, coordinate4.y, point7.x, point7.y);

        g2.draw(curve4);
        g2.draw(curve5);
        g2.draw(curve6);

        Path2D path2 = new Path2D.Double();
        AffineTransform affine2 = new AffineTransform();
        path2.moveTo(point7.x, point7.y);
        path2.lineTo(point8.x, point8.y);
        path2.append(curve4.getPathIterator(affine2), true);
        path2.lineTo(point10.x, point10.y);
        path2.append(curve5.getPathIterator(affine2), true);
        path2.lineTo(point12.x, point12.y);
        path2.append(curve6.getPathIterator(affine2), true);
        path2.closePath();
        g2.fill(path2);

        //рисуем третий треугольник слева
        //указываем координаты
        Point coordinat1 = new Point(185,350);
        Point coordinat2 = new Point(260,350);
        Point coordinat3 = new Point(260,420);

        Point p1 = interpolate(coordinat1, coordinat2, 0.2);
        Point p2 = interpolate(coordinat1, coordinat2, 0.8);
        Point p3 = interpolate(coordinat2, coordinat3, 0.2);
        Point p4 = interpolate(coordinat2, coordinat3, 0.8);
        Point p5 = interpolate(coordinat3, coordinat1, 0.2);
        Point p6 = interpolate(coordinat3, coordinat1, 0.8);
        g2.setColor(Color.DARK_GRAY);
        g2.drawLine(p1.x, p1.y, p2.x, p2.y);
        g2.drawLine(p3.x, p3.y, p4.x, p4.y);
        g2.drawLine(p5.x, p5.y, p6.x, p6.y);

        QuadCurve2D curv1 = new QuadCurve2D.Double(p2.x, p2.y, coordinat2.x, coordinat2.y, p3.x, p3.y);
        QuadCurve2D curv2 = new QuadCurve2D.Double(p4.x, p4.y, coordinat3.x, coordinat3.y, p5.x, p5.y);
        QuadCurve2D curv3 = new QuadCurve2D.Double(p6.x, p6.y, coordinat1.x, coordinat1.y, p1.x, p1.y);

        g2.draw(curv1);
        g2.draw(curv2);
        g2.draw(curv3);

        Path2D path3 = new Path2D.Double();
        AffineTransform affine3 = new AffineTransform();
        path3.moveTo(p1.x, p1.y);
        path3.lineTo(p2.x, p2.y);
        path3.append(curv1.getPathIterator(affine3), true);
        path3.lineTo(p4.x, p4.y);
        path3.append(curv2.getPathIterator(affine3), true);
        path3.lineTo(p6.x, p6.y);
        path3.append(curv3.getPathIterator(affine3), true);
        path3.closePath();
        g2.fill(path3);

        //рисуем первый треугольник справа
        //указываем координаты
        Point coord1 = new Point(430,110);
        Point coord2 = new Point(505,110);
        Point coord3 = new Point(430,180);

        Point pt1 = interpolate(coord1, coord2, 0.2);
        Point pt2 = interpolate(coord1, coord2, 0.8);
        Point pt3 = interpolate(coord2, coord3, 0.2);
        Point pt4 = interpolate(coord2, coord3, 0.8);
        Point pt5 = interpolate(coord3, coord1, 0.2);
        Point pt6 = interpolate(coord3, coord1, 0.8);
        g2.setColor(Color.DARK_GRAY);
        g2.drawLine(pt1.x, pt1.y, pt2.x, pt2.y);
        g2.drawLine(pt3.x, pt3.y, pt4.x, pt4.y);
        g2.drawLine(pt5.x, pt5.y, pt6.x, pt6.y);

        QuadCurve2D cur1 = new QuadCurve2D.Double(pt2.x, pt2.y, coord2.x, coord2.y, pt3.x, pt3.y);
        QuadCurve2D cur2 = new QuadCurve2D.Double(pt4.x, pt4.y, coord3.x, coord3.y, pt5.x, pt5.y);
        QuadCurve2D cur3 = new QuadCurve2D.Double(pt6.x, pt6.y, coord1.x, coord1.y, pt1.x, pt1.y);

        g2.draw(cur1);
        g2.draw(cur2);
        g2.draw(cur3);

        Path2D path4 = new Path2D.Double();
        AffineTransform affine4 = new AffineTransform();
        path4.moveTo(pt1.x, pt1.y);
        path4.lineTo(pt2.x, pt2.y);
        path4.append(cur1.getPathIterator(affine4), true);
        path4.lineTo(pt4.x, pt4.y);
        path4.append(cur2.getPathIterator(affine4), true);
        path4.lineTo(pt6.x, pt6.y);
        path4.append(cur3.getPathIterator(affine4), true);
        path4.closePath();
        g2.fill(path4);

        //рисуем второй треугольник справа
        //указываем координаты
        Point coor1 = new Point(430,230);
        Point coor2 = new Point(505,230);
        Point coor3 = new Point(430,300);

        Point pnt1 = interpolate(coor1, coor2, 0.2);
        Point pnt2 = interpolate(coor1, coor2, 0.8);
        Point pnt3 = interpolate(coor2, coor3, 0.2);
        Point pnt4 = interpolate(coor2, coor3, 0.8);
        Point pnt5 = interpolate(coor3, coor1, 0.2);
        Point pnt6 = interpolate(coor3, coor1, 0.8);
        g2.setColor(Color.DARK_GRAY);
        g2.drawLine(pnt1.x, pnt1.y, pnt2.x, pnt2.y);
        g2.drawLine(pnt3.x, pnt3.y, pnt4.x, pnt4.y);
        g2.drawLine(pnt5.x, pnt5.y, pnt6.x, pnt6.y);

        QuadCurve2D bending1 = new QuadCurve2D.Double(pnt2.x, pnt2.y, coor2.x, coor2.y, pnt3.x, pnt3.y);
        QuadCurve2D bending2 = new QuadCurve2D.Double(pnt4.x, pnt4.y, coor3.x, coor3.y, pnt5.x, pnt5.y);
        QuadCurve2D bending3 = new QuadCurve2D.Double(pnt6.x, pnt6.y, coor1.x, coor1.y, pnt1.x, pnt1.y);

        g2.draw(bending1);
        g2.draw(bending2);
        g2.draw(bending3);

        Path2D path5 = new Path2D.Double();
        AffineTransform affine5 = new AffineTransform();
        path5.moveTo(pnt1.x, pnt1.y);
        path5.lineTo(pnt2.x, pnt2.y);
        path5.append(bending1.getPathIterator(affine5), true);
        path5.lineTo(pnt4.x, pnt4.y);
        path5.append(bending2.getPathIterator(affine5), true);
        path5.lineTo(pnt6.x, pnt6.y);
        path5.append(bending3.getPathIterator(affine5), true);
        path5.closePath();
        g2.fill(path5);

        //рисуем третий треугольник справа
        //указываем координаты
        Point c1 = new Point(430,350);
        Point c2 = new Point(505,350);
        Point c3 = new Point(430,420);

        Point t1 = interpolate(c1, c2, 0.2);
        Point t2 = interpolate(c1, c2, 0.8);
        Point t3 = interpolate(c2, c3, 0.2);
        Point t4 = interpolate(c2, c3, 0.8);
        Point t5 = interpolate(c3, c1, 0.2);
        Point t6 = interpolate(c3, c1, 0.8);
        g2.setColor(Color.DARK_GRAY);
        g2.drawLine(t1.x, t1.y, t2.x, t2.y);
        g2.drawLine(t3.x, t3.y, t4.x, t4.y);
        g2.drawLine(t5.x, t5.y, t6.x, t6.y);

        QuadCurve2D bend1 = new QuadCurve2D.Double(t2.x, t2.y, c2.x, c2.y, t3.x, t3.y);
        QuadCurve2D bend2 = new QuadCurve2D.Double(t4.x, t4.y, c3.x, c3.y, t5.x, t5.y);
        QuadCurve2D bend3 = new QuadCurve2D.Double(t6.x, t6.y, c1.x, c1.y, t1.x, t1.y);

        g2.draw(bend1);
        g2.draw(bend2);
        g2.draw(bend3);

        Path2D path6 = new Path2D.Double();
        AffineTransform affine6 = new AffineTransform();
        path6.moveTo(t1.x, t1.y);
        path6.lineTo(t2.x, t2.y);
        path6.append(bend1.getPathIterator(affine6), true);
        path6.lineTo(t4.x, t4.y);
        path6.append(bend2.getPathIterator(affine6), true);
        path6.lineTo(t6.x, t6.y);
        path6.append(bend3.getPathIterator(affine6), true);
        path6.closePath();
        g2.fill(path6);
    }

    //метод принимает два значения вместе с дробной частью между 0.0 и 1.0 и возвращает интерполированное значение
    public Point interpolate(Point coordinate1, Point coordinate2, double t){
        return new Point((int)Math.round(coordinate1.x * (1-t) + coordinate2.x*t),
                (int)Math.round(coordinate1.y * (1-t) + coordinate2.y*t));
    }
}

