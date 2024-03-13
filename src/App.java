import processing.core.*;

public class App extends PApplet {
    public static void main(String[] args) {
        PApplet.main("App");
    }
    PImage bird;   
    PImage pipe; 
    PImage lost;
    PImage pipe2;

   
   
    float playerX = 100;
    float playerY = 300;
    float playerSize = 50;
    float ySpeed = 0;
    double xspeed = 0;

    float columnMovement;
    float rectWidth = 50;

    double gravity = 0.2 ; //creates flappy bird movement for the player
    boolean deathCheck = false;

    boolean gameOver = false;
    boolean rectCollision = false;

      
    float rectgameOverY = 800;
    float rectgameOverX = 600;
    
   

    float rect2X = 700;
    float rect2Y = 0;
    float rect2Height = 230;

    float rect3X = 420;
    float rect3Y = 340;
    float rect3Height = 250;

    float rect4X = 100;
    float rect4Y = 0;
    float rect4Height = 260;

    float rect5X = 410;
    float rect5Y = 0;
    float rect5Height = 180;

    float rect6X = 600;
    float rect6Y = 350;
    float rect6Height = 250;

    float rect7X = 800;
    float rect7Y = 400;
    float rect7Height = 200;

    float rect8X = 1100;
    float rect8Y = 400;
    float rect8Height = 300;

    boolean restartGame = false;

    public void settings() {
        size(800, 600);
    }
    public void setup(){
        bird = loadImage("Bird.png"); // create variable for printing bird over player
        bird.resize(80, 80);

        pipe = loadImage("Pipe.png"); // create variable for printing the pipes over rectangle opstacles
        pipe2 = loadImage("Pipe2.png"); // create variable for printing the pipes upside down over rectangle obstacles
       
       
        lost=loadImage("Lost.png");
    }
    public void draw() {
        background(173, 216, 230);
        player(); 
        image(bird, playerX-15, playerY-15); // says the bird is the player
        columnMovement();
        rectangle();
        pipes(); 
        ifCollision();
        gameOver();
  }
       
    public boolean collision(float rectangleX, float rectangleY, float rectHeight, float playerX, float playerY) { // set collison perameters for when player hits obstacle
        if (playerX + playerSize < rectangleX) {
            return false;
        } else if (playerX > rectangleX + rectWidth) {
            return false;
        } else if (playerY + playerSize < rectangleY) {
            return false;
        } else if (playerY > rectangleY + rectHeight) {
            return false;
        } else {
            return true;
        }
    }
    public void ifCollision(){
        if (collision(rect4X, rect4Y, rect4Height, playerX, playerY)) {
            playerDeath();
            restartGame();
        } else if (collision(rect4X, rect4Y, rectWidth, playerX, playerY)) {
            playerDeath();
            restartGame();
        }
        if (collision(rect6X, rect6Y, rect6Height, playerX, playerY)) {
            playerDeath();
            restartGame();
        } else if (collision(rect6X, rect6Y, rectWidth, playerX, playerY)) {
            playerDeath();
            restartGame();
        }
        if (collision(rect5X, rect5Y, rect5Height, playerX, playerY)) {
            playerDeath();
            restartGame();
        } else if (collision(rect5X, rect5Y, rectWidth, playerX, playerY)) {
            playerDeath();
            restartGame();
        }
        if (collision(rect3X, rect3Y, rect3Height, playerX, playerY)) {
            playerDeath();
            restartGame();
        } else if (collision(rect3X, rect3Y, rectWidth, playerX, playerY)) {
            playerDeath();
            restartGame();
        }
        if (collision(rect2X, rect2Y, rect2Height, playerX, playerY)) {
            playerDeath();
            restartGame();
        } else if (collision(rect2X, rect2Y, rectWidth, playerX, playerY)) {
            playerDeath();
            restartGame();
        }
        if (collision(rect7X, rect7Y, rect7Height, playerX, playerY)) {
            playerDeath();
            restartGame();
        } else if (collision(rect7X, rect7Y, rectWidth, playerX, playerY)) {
            playerDeath();
            restartGame();
        }
        if (collision(rect8X, rect8Y, rect8Height, playerX, playerY)) {
                playerDeath();
                restartGame();
        } 
        else if (collision(rect8X, rect8Y, rectWidth, playerX, playerY)) {
                playerDeath();
                restartGame();
        }
    }
    public void player() { // method that creates the player
        noFill();
        noStroke();
        rect(playerX, playerY, playerSize, playerSize);
        ySpeed += gravity;
        playerY += ySpeed;
        if (playerY > height - 25) {
            playerDeath();
            restartGame();
        }
        if (playerY < 0) {
            playerDeath();
            restartGame();
        }
    }
    public void rectangle() {
      
       noFill();
       noStroke();
        rect(rect2X, rect2Y, rectWidth, rect2Height);

        noFill();
        noStroke();
        rect(rect3X, rect3Y, rectWidth, rect3Height);

        noFill();
        noStroke();
        rect(rect4X, rect4Y, rectWidth, rect4Height);

        noFill();
        noStroke();
        rect(rect5X, rect5Y, rectWidth, rect5Height);

        noFill();
        noStroke();
        rect(rect6X, rect6Y, rectWidth, rect6Height);

        noFill();
        noStroke();
        rect(rect7X, rect7Y, rectWidth, rect7Height);

        noFill();
        noStroke();
        rect(rect8X, rect8Y, rectWidth, rect8Height);
    }
    public void pipes(){ // method that prints pipes over rectangles
        image(pipe2, rect2X, rect2Y, rectWidth, rect2Height);
        image(pipe, rect3X, rect3Y, rectWidth, rect3Height);
        image(pipe2, rect4X, rect4Y, rectWidth, rect4Height);
        image(pipe2, rect5X, rect5Y, rectWidth, rect5Height);
        image(pipe, rect6X, rect6Y, rectWidth, rect6Height);
        image(pipe, rect7X, rect7Y, rectWidth, rect7Height);
        image(pipe, rect8X, rect8Y, rectWidth, rect8Height);
    }
   
    public void keyPressed() {
        if (key == ' ') {
            ySpeed = -4;
            deathCheck=false;
        }

        if (keyCode == UP) {
            playerY -= 5;
        }

        if (keyCode == DOWN) {
            playerY += 5;
        }

        if (key == 'r') {
            restartGame();
        }
    }
    public void playerDeath() {
        deathCheck = true;
    }
    public void columnMovement() {
        xspeed = -2;
        rect2X += xspeed;
        if (rect2X < 10) {
            rect2X = 800;
        }
        rect3X += xspeed;
        if (rect3X < 10) {
            rect3X = 800;
        }
        rect4X += xspeed;
        if (rect4X < 10) {
            rect4X = 800;
        }
        rect5X += xspeed;
        if (rect5X < 10) {
            rect5X = 800;
        }
        rect6X += xspeed;
        if (rect6X < 10) {
            rect6X = 800;
        }
        rect7X += xspeed;
        if (rect7X < 10) {
            rect7X = 800;
        }
        rect8X += xspeed;
        if (rect8X < 10) {
            rect8X = 800;
        }
    }
    public void gameOver(){
        if(deathCheck==true){
            background(220);
            image(lost, 0, 0, width, height);
           playerY=400;
           textSize(70);
           fill(0,0,0);
           text("Press Space to Play Again", 30, 500);
        }  
    }
    public void restartGame() {
        playerY = 300;
        rect2X = 700;
        rect3X = 420;
        rect4X = 250;
        rect5X = 410;
        rect6X = 600;
        rect7X = 800;
        rect8X = 1100;
    }
}
