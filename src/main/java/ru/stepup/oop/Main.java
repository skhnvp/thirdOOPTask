package ru.stepup.oop;

/*
Создайте класс Ломаная (PolyLine), которая будет представлять собой ломаную линию (см. пример на рис.1), которая описывается:

+ массив Точек, через которые линия проходит
+ При создании объекта можно ничего не указывать, или указать начальный набор Точек
+ Может быть приведена к строковой форме вида “Линия [Т1,T2,…,TN]”, где TN – это результат приведения к строке Точки с номером N
+ Может вернуть массив Линий (getLines)
+ Может вернуть свою длину (getLength)
Под Точкой имеется ввиду класс, созданный в задании 1 (точка координат). Под Линией имеется ввиду класс, созданный в задании 2 (линия).

Необходимо выполнить следующие задачи:

Создать Ломаную, проходящую через точки {1;5}, {2;8}, {5;3}, {8,9}
Рассчитать длину Ломаной
Получить у Ломаной массив Линий
Рассчитать длину массива Линий
Сравнить длину Ломаной и массива Линий: они должны совпасть
Изменить координаты Точки {2,8} таким образом, чтобы она стала иметь значение {12,8}. Если изменения отразились в данной точке, в Ломаной и в двух Линиях массива (из пункта 3), то задача решена верно
Подсказка: текстовое представление объекта лучше реализовывать в переопределенном методе toString()
*/

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Point p1 = new Point(1,5);
        Point p2 = new Point(2,8);
        Point p3 = new Point(5,3);
        Point p4 = new Point(8,9);

        System.out.println("===Varargs==="); //Передаем в PolyLine список точек через параметр переменной длины

        PolyLine pl1 = PolyLine.ofVarargs(p1,p2,p3,p4);
        System.out.println("Задана кривая линия: " + pl1);

        Line l1 = new Line(p1,p2);
        Line l2 = new Line(p2,p3);
        Line l3 = new Line(p3,p4);

        System.out.println("Длина ломаной линии, полученная через Line: " + (l1.getLength() + l2.getLength() + l3.getLength()));
        System.out.println("Длина ломаной линии, полученная через getLength: " + pl1.getLength());

        System.out.println("Массив PolyLine состоящий из Точек: " + pl1.getLines());

        p2.setX(12);
        p2.setY(8);

        System.out.println("Массив PolyLine состоящий из Точек: " + pl1.getLines());
        System.out.println("Длина ломаной линии, полученная через getLength: " + pl1.getLength());

        System.out.println("\n===Array Lines==="); //Передаем в PolyLine список точек через массив Line
        List arrOfLines = new ArrayList<Line>();

        arrOfLines.add(new Line(p1,p2));
        arrOfLines.add(new Line(p2,p3));
        arrOfLines.add(new Line(p3,p4));

        PolyLine pl2 = PolyLine.ofArrayLines(arrOfLines);

        System.out.println("Задана кривая линия: " + pl2);
        System.out.println("Длина ломаной линии, полученная через getLength: " + pl2.getLength());

        System.out.println("\n===Array Points==="); //Передаем в PolyLine список точек через массив Point
        ArrayList arrOfPoints = new ArrayList<Point>();

        arrOfPoints.add(p1);
        arrOfPoints.add(p2);
        arrOfPoints.add(p3);
        arrOfPoints.add(p4);

        PolyLine pl3 = PolyLine.ofArrayPoints(arrOfPoints);

        System.out.println("Задана кривая линия: " + pl3);
        System.out.println("Длина ломаной линии, полученная через getLength: " + pl3.getLength());
    }
}