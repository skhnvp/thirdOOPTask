package ru.stepup.oop;

import java.util.ArrayList;
import java.util.List;

public class PolyLine {
    private List polyLineOfPoints = new ArrayList<Point>();
    private List polyLineOfLines = new ArrayList<Line>();

    public PolyLine() {;
    }

    public PolyLine(Point... polyLines) {
        for (int i = 0; i < polyLines.length; i++) {
            this.polyLineOfPoints.add(polyLines[i]);
        }
    }

    public void addPoint(Point p){
        this.polyLineOfPoints.add(p);
    }

    public List getLines(){
        return this.polyLineOfLines;
    }

    public List getPoints(){
        return this.polyLineOfPoints;
    }

    public double getLength(){
        double len = 0.;

        for (int i = 0, j = 1; i < polyLineOfPoints.size() - 1; i++,j++) {
            Line l = new Line((Point) polyLineOfPoints.get(i), (Point) polyLineOfPoints.get(j));
            len += l.getLength();
        }
        return len;
    }

    @Override
    public String toString() {
        return "Линия " + polyLineOfPoints;
    }
}
