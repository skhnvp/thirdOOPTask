package ru.stepup.oop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PolyLine {
    private List polyLine = new ArrayList<Line>();

    private PolyLine() {
    }

    private PolyLine(Point... polyLines) {
        if (polyLines.length > 1) {
            Line tempLine;
            for (int i = 0; i < polyLines.length - 1; ) {
                tempLine = new Line();
                tempLine.setPoint1(polyLines[i]);
                tempLine.setPoint2(polyLines[++i]);
                polyLine.add(tempLine);
            }
        }
    }

    private PolyLine(List<Line> lines) {
        for (Line line : lines) {
            this.polyLine.add(line);
        }
    }


    private PolyLine(ArrayList<Point> points) {
        //если тут оставить List<Point> points то будет ошибка, которую так и не понял как иначе решить: 'PolyLine(List<Line>)' clashes with 'PolyLine(List<Point>)'; both methods have same erasure
        if (points.size() > 1) {
            Line tempLine;
            for (int i = 0; i < points.size() - 1; ) {
                tempLine = new Line();
                tempLine.setPoint1(points.get(i));
                tempLine.setPoint2(points.get(++i));
                polyLine.add(tempLine);
            }
        }
    }

    public static PolyLine ofVarargs(Point... points) {
        return new PolyLine(points);
    }

    public static PolyLine ofArrayLines(List<Line> lines) {
        return new PolyLine(lines);
    }

    public static PolyLine ofArrayPoints(ArrayList<Point> points) {
        return new PolyLine(points);
    }


    public List getLines() {
        return this.polyLine;
    }

    public double getLength() {
        double len = 0.;

        for (int i = 0; i < polyLine.size(); i++) {
            len += ((Line) polyLine.get(i)).getLength();
        }
        return len;
    }

    @Override
    public String toString() {
        return "Линия " + polyLine;
    }
}
