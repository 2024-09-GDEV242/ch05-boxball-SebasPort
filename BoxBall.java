import java.awt.*;
import java.awt.geom.*;
import java.awt.Color;
/**
 * The BoxBall class is responsible of creating the bouncing
 * balls. All of this happening inside a rectangle/square with
 * different speeds andn positions
 *
 * @author Sebastian Portillo
 * @version 10/20/24
 * 
 */

public class BoxBall
{
    // instance variables declaration
    private Color color;      //color of ball
    private int diameter;     //size of ball
    private int yPosition;    //vertical position of ball 
    private int xPosition;    //horizontal position of ball
    private final int width;  
    private final int height;
    private Canvas canvas;
    private int ySpeed;       //vertical speed of ball
    private int xSpeed;       //horizontal speed of ball
    private int const_Distance = 10;
    
    

    /**
     * Constructor for objects of class BoxBall
     * @param yPos is the vertical coordinate of the ball
     * @param xPos is the horizonal coordinate of the ball
     * @param ballDiameter is the diameter (in pixels) of the ball
     * @param ballColor is the color of the ball
     * @param box_width the width of the box
     * @param box_height the height of the box
     * @param drawingCanvas is the canvas to draw on
     */
    public BoxBall(int yPos, int xPos, int ballDiameter, Color ballColor, int box_height, int box_width, Canvas drawingCanvas)
    {
        // initialise instance variables
        if (xPos >= box_width){
        xPosition = xPos - const_Distance;
    }
        else {
          xPosition = xPos;
        }
    if (yPos >= box_height){
       yPosition = yPos - const_Distance;   
        }
        else{
         yPosition = yPos;
        }
    diameter =ballDiameter;
    color = ballColor;
    height = box_height;
    width = box_width;
    canvas = drawingCanvas;
    xSpeed = (int) (Math.random() * 20) + 1;
    ySpeed = (int) (Math.random() * 20) + 1;
    
    }
    /**
     * The following method draws the ball at the starting 
     * position on the canvas
     */
    public void draw () {
     canvas.setForegroundColor(color);
     canvas.fillCircle(xPosition, yPosition, diameter);
    }
    /**
     * The following method erases the ball at the position on
     * the canvas.
     */
    public void erase(){
        canvas.eraseCircle (xPosition, yPosition, diameter);
    }
    /**
     * The following method moves the ball according to its speed
     * and position and draws it accordingly.
     */
    public void move(){
        erase();                     //delete from canvas at the current position
        int radius = diameter /2;    //defines the radius
        xPosition += xSpeed;         //defining the position according to its speed
        yPosition  += ySpeed;        //defining the position according to its speed    
        //In this if statement, we are stating that if the x-position of the ball is less 
        //than zero, then change its speed and set the x-position of it.
        if (xPosition - radius - const_Distance < 0){
            xSpeed = -xSpeed; //bounces the ball with in the "walls" of the box
            xPosition = radius + const_Distance;
        }
        //In this else statement, we are stating that if the x-position of the ball is greater 
        //than or equal to it's width, then change it's speed and set its x-position 
        else if (xPosition + radius >= width){
            xSpeed = -xSpeed;
            xPosition = width - radius ;
        }
        //In this if statement,we are stating if the y-position of the ball is less
        // than zero, then change its speed and set the y-position of it.
        if (yPosition - radius - const_Distance < 0){
            ySpeed = -ySpeed;
            yPosition = radius + const_Distance ;
        }
        //In this else statement, we are stating that if the y-position of the ball is greater
        //than or equal to it's height, then change it's speed and set it's y-position
        else if (yPosition + radius >= height){
            ySpeed = -ySpeed;
            yPosition = height - radius;
        }
        //draw again at the new position899i
        draw ();
    }
    /**
     * returns the vertical position of this ball
     */
     public int getyPosition (){
         return yPosition;
     }
     /**
      * returns the horizontal position of this ball
      */
     public int getxPosition (){
         return xPosition;
     }
}
