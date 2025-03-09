package ru.stepup.oop;

public class Line {
    private Point p1;
    private Point p2;

    public Line() {
    }

    public Line(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public Line(int x1, int y1, int x2, int y2) {
        this.p1 = new Point(x1,y1);
        this.p2 = new Point(x2,y2);
    }

    public double getLength() {
        int deltaX = p2.getX() - p1.getX();
        int deltaY = p2.getY() - p1.getY();
        return  (Math.round(Math.sqrt(deltaX * deltaX + deltaY * deltaY) * 100)) / 100.;
    }

    @Override
    public String toString() {
        return "Линия от " + p1 + " до " + p2;
    }

    public Point getP1() {
        return p1;
    }

    public void setP1(int x, int y) {
        this.p1.setX(x);
        this.p1.setY(y);
    }

    public Point getP2() {
        return p2;
    }

    public void setP2(int x, int y) {
        this.p2.setX(x);
        this.p2.setY(y);
    }

    public void setPoint1(Point p) {
        this.p1 = p;
    }

    public void setPoint2(Point p) {
        this.p2 = p;
    }

    public void setNull() {
        this.p1 = null;
        this.p2 = null;
    }
}
