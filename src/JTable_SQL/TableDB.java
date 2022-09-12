package JTable_SQL;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class TableDB {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Getting information about cats"); //cоздаем окно
        frame.setLayout(new FlowLayout()); //FlowLayout используется для размещения компонентов в линию, один за другим
        frame.setSize(600, 600);
        DefaultTableModel defaultTableModel = new DefaultTableModel(); //создаем модель  по умолчанию, которая является таблицей нулевых столбцов и нулевых строк
        JTable table = new JTable(); //создаем объект JTable
        table.setModel(defaultTableModel); //устанавливаем для JTable модель
        table.setPreferredScrollableViewportSize(new Dimension(500, 500)); //устанавливаем размер JTable
        table.setFillsViewportHeight(true); // чтобы таблица никогда не была меньше окна просмотра
        frame.add(new JScrollPane(table)); //JScrollPane обеспечивает представление с возможностью прокрутки компонента
        defaultTableModel.addColumn("id"); //добавляем столбцы в модель
        defaultTableModel.addColumn("name");
        defaultTableModel.addColumn("type_id");
        defaultTableModel.addColumn("age");
        defaultTableModel.addColumn("weight");
        //подключаемся к базе данных
        try {
            Class.forName("org.sqlite.JDBC");
            Connection connection = DriverManager.getConnection("jdbc:sqlite:My_cats.db");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from cats"); //выгружаем данные по запросу в ResultSet
            while (resultSet.next()) { //проходимся по resultSet и получаем данные
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int type_id = resultSet.getInt("type_id");
                int age = resultSet.getInt("age");
                double weight = resultSet.getDouble("weight");
                defaultTableModel.addRow(new Object[]{id, name, type_id,age,weight}); //добавляем данные в модель
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        frame.setVisible(true);
        frame.validate();
    }
}


