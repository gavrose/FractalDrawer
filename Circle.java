// Written by Gavin Rose, rose1751

import java.awt.Color;

public class Circle {

    double x;
    double y;
    double radius;
    Color circ_color = new Color(12);

    public Circle(double x, double y, double radius) {
        this.radius = radius;
        this.x = x;
        this.y = y;
    }

    public double calculatePerimeter() {
        double p = 3.14*radius;
        return p;
    }

    public double calculateArea() {
        double a = 3.14*radius*radius;
        return a;
    }

    public void setColor(Color in_color){
        this.circ_color = in_color;
    }

    public void setPos(double x,double y){
        this.x = x;
        this.y = y;
    }

    public void setRadius(double r){
        this.radius = r;
    }

    public Color getColor() {
        return this.circ_color;
    }

    public double getXPos() {
        return x;
    }

    public double getYPos() {
        return y;
    }

    double getRadius() {
        return radius;
    }
}

