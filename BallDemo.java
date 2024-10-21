import java.awt.Color;
import java.util.HashSet;
import java.util.Random;
//packages needed in order to execute the code and get desired outcome
/**
 * Class BallDemo - a short demonstration showing animation of balls bacing around a square, kind off like the dvd logo or the
 * bubbles in Windows. In this class, we can find different method calls like bounce,and boxbouce, which determine the logic and 
 * nature of the balls bouncing within the box peripherals.
 * Canvas class. 
 *
 * @author Sebastian Portillo
 * @version 10.20.24
 */

public class BallDemo   
{
   //defining the class instances
    private Canvas myCanvas;   
   //variables for the box and the canvas, such as its width,height
    int boxwidth = 500;
    int boxheight = 500;
    int canvasWidth = 800;
    int canvasHeight = 800;
    int xPos = 10;
    int yPos = 10;
    //Defining the HashSet object of type BouncingBall
    HashSet<BoxBall> balls =new HashSet <BoxBall>();
    // add the Random class variable
    private Random randomGenerator;
/**
 * Create a BallDemo object. Creates a fresh canvas and makes it visible.
*/
public BallDemo(){
myCanvas = new Canvas("Ball Demo", canvasWidth,canvasHeight);
randomGenerator = new Random(); //define the Random object
}

 /**
 * Simulate desired amount of bouncing balls within the box
 */
    public void bounce(int numberofBalls)
    {
    int ground = 400; // position of the ground line

    myCanvas.setVisible(true); //set visibility of the canvas
    boxBounce(numberofBalls);  //call the method boxBounce the number of balls
    // make them bounce
    boolean finished =  false;
        while (!finished) {
        myCanvas.wait(50);  // small delay
        for(BoxBall boxBall : balls){
            boxBall.move();//moves the balls 
            
            
            // stop once ball has travelled a certain distance on x axis
            if(boxBall.getxPosition() >=boxheight + 30 * numberofBalls) {
                finished = true;
            }
        }
    }
}
private void boxBounce (int numberofBalls){
        // draws the rectangle box
        myCanvas.drawRectangle (xPos, yPos, boxheight, boxwidth);
        //This loop creates the bouncingBall object and adds 
        //its to the balls HashSet.
        for( int i = 0; i < numberofBalls; i++){
            int y = randomPosition(); //defines x and y variables
            int x = randomPosition(); //and calls the randomPosition() method to intialize the x and y
            Color randomColor = new Color ((int)(Math.random() *0x1000000));
            BoxBall boxball = new BoxBall (x,y, 16, randomColor, boxwidth, boxheight, myCanvas);//pass x and y values to the BouncingBall constructor
            balls.add(boxball);       // adds bounceBall object to the balls
            boxball.draw();           //calls the draw() method of bounceBall object
        }
}
/**
 *This method creates a random position which lies between the 0 and top half of the screen.
 */
private int randomPosition(){
//gets half of the height of the myCanvas
 int pos = (int) (boxheight);
 //generates the random value and return the value
 return randomGenerator.nextInt (pos);
}
 
}
    

