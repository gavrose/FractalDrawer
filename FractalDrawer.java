// Written by Gavin Rose, rose1751


// FractalDrawer class draws a fractal of a shape indicated by user input
import java.awt.Color;
import java.util.Scanner;

public class FractalDrawer {
    // creates new colors to use
    // these colors are Color objects so to call them you can just say the color you dont have to say Color.color

    public static final Color NAVY_BLUE = new Color(0,0,150);  // creates a new color of navy blue
    public static final Color FOREST_GREEN = new Color(0,110,0); // creates a color of forest green (dark green)
    public static final Color NEW_GREEN = new Color(0,200,0); // creates a new color of green which is different from the Color.GREEN

    private double totalArea=0;  // member variable for tracking the total area

    public FractalDrawer() {}  // contructor

    public double drawFractal(String type) {
        Canvas can = new Canvas(); // creates a new cavas object
        //checks which shape inputted and calls the corresponding fractal
        if (type.equals("triangle")){ 
            drawTriangleFractal(250,215,275 /* bottom left corner x */,500 /* bottom left corner y */,Color.CYAN,can,0);
        } else if (type.equals("circle")){
            drawCircleFractal(125, 400, 400, Color.RED, can, 0);
        } else if (type.equals("rectangle")){
            drawRectangleFractal(400,60,195/* bottom left corner x */,/* bottom left corner y */ 350,NEW_GREEN,can,0);
        }
        return totalArea;  // return the total area of the fractal
    }

    public void drawTriangleFractal(double width, double height, double x, double y, Color c, Canvas can, int level){
        Triangle tri = new Triangle(x /* bottom left corner */,y /* bottom left corner */,width,height);
        if (level < 8) {  // if the fractal hasnt yet reached 8 levels of recursion:
            totalArea += tri.calculateArea();  // add the area of the current triangle to the total area
            Color newColor = c;   // create a new variable to store the color

            // cycle between the 3 colors each level
            if (newColor == Color.BLUE){   
                newColor = Color.CYAN;
            } else if (newColor == Color.CYAN){
                newColor = NAVY_BLUE;
            } else if (newColor == NAVY_BLUE){
                newColor = Color.BLUE ;
            }
            tri.setColor(newColor);  // set the color of the triangle to the new color
            can.drawShape(tri);   // draw the new triangle
            
            drawTriangleFractal(width/2.0,-height/2.0,x+(width),y,newColor,can,level+1);
            drawTriangleFractal(width/2.0,-height/2.0,x-(width/2.0),y,newColor,can,level+1);
            drawTriangleFractal(width/2.0,-height/2.0,x+(width/4.0),y-(height+(height/2)),newColor,can,level+1);
        }
    }

    public void drawCircleFractal(double radius, double x, double y, Color c, Canvas can, int level) {
        Circle circ = new Circle(x,y,radius);  //create a new triangle 
        if (level < 8) {   // if the triangle hasn't reached 8 levels of recursion
            totalArea += circ.calculateArea();  // add the area of the current triangle to the total area
            Color newColor = c;  // create new variable to store the color
            // cycle between the 3 colors each level
            if (newColor == Color.BLACK){      
                newColor = Color.MAGENTA;
            } else if (newColor == Color.MAGENTA){
                newColor = Color.RED;
            }else if (newColor == Color.RED){
                newColor = Color.BLACK;
            }
            circ.setColor(newColor);  // set the color to the new color
            can.drawShape(circ);  // draw the circle shape on the canvas
            // if the level is even and less than 5 (level 0,2,4), draw circles at the top, bottom, left and right of the circle
            if (level % 2 == 0 && level <5) { 
            drawCircleFractal(radius/2.0, x-radius-(radius/2.1), y, newColor, can, level+1); // left
            drawCircleFractal(radius/2.0, x+radius+(radius/2.1), y, newColor, can, level+1);  // right
            drawCircleFractal(radius/2, x, y+radius+(radius/2.1), newColor, can, level+1);  // bottom
            drawCircleFractal(radius/2, x, y-radius-(radius/2.1), newColor, can, level+1);  // top
            }
            // draw these circles every level   
            drawCircleFractal(radius/2.0, x+radius, y+radius, newColor, can, level+1);  // bottom right  
            drawCircleFractal(radius/2.0, x-radius, y-radius, newColor, can, level+1);  // bottom left
            drawCircleFractal(radius/2.0, x+radius, y-radius, newColor, can, level+1);  // top right
            drawCircleFractal(radius/2.0, x-radius, y+radius, newColor, can, level+1);  // top left
        }
    }

    public void drawRectangleFractal(double width, double height, double x, double y, Color c, Canvas can, int level) {
        Rectangle rect = new Rectangle(x,y,width,height); // create a new rectangle object
        if (level < 10) {  // if the fractal hasn't yet reached 10 levels of recursion
            totalArea += rect.calculateArea(); // add the current rectangle's area to the area
            Color newColor = c;  // store the inputted color in the newColor variable
            // alternates between the 2 colors each level
            if (newColor == FOREST_GREEN){      
                newColor = NEW_GREEN;
            } else if (newColor == NEW_GREEN){
                newColor = FOREST_GREEN;   
            }
            rect.setColor(newColor);  // set the new rectangle to actually have the new color
            can.drawShape(rect);  // draw the new rectangle on the canvas

            // this fractal alternates between drawing vertical and horizontal rectangles each level by switching the height and width of the rectangles each level
            if ((level % 2 == 0)){   //vertcial
                drawRectangleFractal(height/1.5,width/1.5,x+(width), y+(/*centers height*/ height/2)-((width/1.5)/2.0), newColor, can, level+1);
                drawRectangleFractal(height/1.5,width/1.5, x-(height/1.5), y+(/*centers height*/ height/2)-((width/1.5)/2.0), newColor, can, level+1);
            } else {  //horizontal
                drawRectangleFractal(height/1.5,width/1.5,x+(/*centers width*/ width/2.0)-((height/1.5)/2), y-(width/1.5), newColor, can, level+1);
                drawRectangleFractal(height/1.5,width/1.5,x+(/*centers width*/ width/2.0)-((height/1.5)/2), y+height, newColor, can, level+1);
            
            }
        }
    }

    //TODO:
    // main should ask user for shape input, and then draw the corresponding fractal.
    // should print area of fractal
    public static void main(String[] args){
        String shape = "invalid";  // sets intial value for the shape
        FractalDrawer fract = new FractalDrawer();  // creates new fractalDrawer object
        Scanner scan = new Scanner(System.in);  // creates new scanner to catch user input for the shape
        while (shape.equals("invalid")) {    // if the shape is not set to a valid choice it will keep prompting the user for a shape
            System.out.println("Which type of fractal do you want to draw?"); // prompt user for input
            shape = scan.nextLine().toLowerCase(); // set te shape to the next line of user input
            if (shape.equals("circle")){
                System.out.println("\nThe total area of the fractal is "+ fract.drawFractal(shape));
                fract.drawFractal(shape);
            } else if (shape.equals("triangle")){
                System.out.println("\nThe total area of the fractal is "+ fract.drawFractal(shape));
                fract.drawFractal(shape);
            } else if (shape.equals("rectangle")){
                System.out.println("\nThe total area of the fractal is "+ fract.drawFractal(shape));
                fract.drawFractal(shape);
            } else {
                shape = "invalid"; // set the shape back to invalid so that the while loop continues to prompt the user
                System.out.println("\nPlease choose either a circle, triangle, or rectangle.");
            }
        }
        scan.close();
    }
}
