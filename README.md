# Fractal Drawer

# This was created for university purpose

# This program draws a premade fractal of 3 shapes (circle, triangle, rectangle) based on the desired user input. This uses recursion to draw each level of the fractal, however, as memory is not unlimited, the fractal was limited to around 8-10 levels of recursion. Each level of recursion draws multiple shapes at a set location with a changing size to create a modular shape.

# The Canvas.java file was provided and was not edited. 

# How to compile and run: 
# Navigate to the folder where the project is stored using terminal cd commands. Enter "javac FractalDrawer.java" java into the terminal. Enter "java FractalDrawer" into the terminal.

# How to Use
# When the FractalDrawer.java file is run, the user will be prompted to enter a shape. Once this shape is entered (NOT CASE SENSITIVE) a canvas window will be created and the desired shape will draw.


# How to Modify Program (Change Fractal)
# In the FractalDrawer.java the drawFractal method creates the inital shape. To modify this shape, change the width, height, X/Y position, or color values to what you want. In the FractalDrawer.java file there are methods to draw each respective fractal (draw<SHAPE NAME>Fractal). Inside each draw<SHAPE NAME>Fractal method there are recursive calls to the function which draw the new shapes. Mess around with the positions and heights to draw new shapes in different locations/orientations.

# Helpful Resources
# How to create custom colors using java.awt.Color RGB values -https://teaching.csse.uwa.edu.au/units/CITS1001/colorinfo.html

