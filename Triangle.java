// Written by Gavin Rose, rose1751

import java.awt.Color;

public class Triangle {
    double x;
    double y;
    double width;
    double height;
    Color tri_color = new Color(10);

    public Triangle(double x, double y, double width, double height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    
    public double calculatePerimeter(){
        return width + Math.sqrt((width * width) + 4*(height * height));
    }

    public double calculateArea(){
        return (this.width*this.height)/2;
    }

    public void setColor(Color in_color){
        tri_color = in_color;
    }

    public void setPos(double x, double y){
        this.x = x;
        this.y = y;
    }

    public void setHeight(double h){
        this.height = h;
    }

    public void setWidth(double w){
        this.width = w;
    }

    public Color getColor(){
        return this.tri_color;
    }

    public double getXPos(){
        return this.x;
    }

    public double getYPos(){
        return this.y;
    }

    public double getHeight(){
        return this.height;
    }

    public double getWidth(){
        return this.width;
    }
}
