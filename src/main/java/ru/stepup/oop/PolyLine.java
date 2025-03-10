package ru.stepup.oop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PolyLine {
    private List<Line> polyLine = new ArrayList<>();

    private PolyLine() {

    }

    public static PolyLine ofVarargs(Point... points) {
        PolyLine pl = new PolyLine();

        if (points.length > 1) {
            Line tempLine;
            for (int i = 0; i < points.length - 1; ) {
                tempLine = new Line();
                tempLine.setPoint1(points[i]);
                tempLine.setPoint2(points[++i]);
                pl.polyLine.add(tempLine);
            }
        }

        return pl;
    }

    public static PolyLine ofArrayLines(List<Line> lines) {
        PolyLine pl = new PolyLine();

        pl.polyLine.addAll(lines);
        return pl;
    }

    public static PolyLine ofArrayPoints(List<Point> points) {
        PolyLine pl = new PolyLine();

        if (points.size() > 1) {
            for (int i = 0; i < points.size() - 1; i++) {
                Line tempLine = new Line();
                tempLine.setPoint1(points.get(i));
                tempLine.setPoint2(points.get(i + 1));
                pl.polyLine.add(tempLine);
            }
        }
        return pl;
    }

    public List<Line> getLines() {
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
