import processing.core.*;

public class App extends PApplet {
    public static void main(String[] args) {
        PApplet.main("App");
    }
//image variables:
    PImage bird;
    PImage pipe;
    PImage lost;
    PImage pipeImage;

    float playerX = 100;
    float playerY = 300;
    float playerSize = 50;
    float ySpeed = 0; //speed for player
    double xspeed = 0; //speed for pipes
    float pipeMovement;
    float rectWidth = 50;

    double gravity = 0.2; // creates flappy bird movement for the player
    boolean deathCheck = false; //check for death

    boolean gameOver = false;
    boolean rectCollision = false;

    float rectgameOverY = 800;
    float rectgameOverX = 600;

     // pipe sizing  
    float pipe1x = 700;
    float pipe1y = 0;
    float pipe1Height = 230;

    float pipe2x = 420;
    float pipe2y = 340;
    float pipe2Height = 250;

    float pipe3x = 100;
    float pipe3y = 0;
    float pipe3Height = 260;

    float pipe4x = 410;
    float pipe4y = 0;
    float pipe4Height = 180;

    float pipe5x = 600;
    float pipe5y = 350;
    float pipe5Height = 250;

    float pipe6x = 800;
    float pipe6y = 400;
    float pipe6Height = 200;

    float pipe7x = 1100;
    float pipe7y = 400;
    float pipe7Height = 300;

    boolean restartGame = false;

    public void settings() {
        size(800, 600);
    }

    public void setup() {
        bird = loadImage("Bird.png"); // create variable for printing bird over player
        bird.resize(80, 80);

        pipe = loadImage("Pipe.png"); // create variable for printing the pipes over rectangle opstacles
        pipeImage = loadImage("Pipe2.png"); // create variable for printing the pipes upside down over rectangle
                                            // obstacles

        lost = loadImage("Lost.png");
    }

    public void draw() {
        background(173, 216, 230);
        player();
        image(bird, playerX - 15, playerY - 15); // says the bird is the player
        pipeMovement();
        pipe();
        pipes();
        ifCollision();
        gameOver();
    }

    public boolean collision(float rectangleX, float rectangleY, float rectHeight, float playerX, float playerY) { 
        // set collison perameters for when player hits pipe            
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

    public void ifCollision() { // what happens for collision between pipe and player loop (needs array lists for efieciency)
        if (collision(pipe3x, pipe3y, pipe3Height, playerX, playerY)) {
            playerDeath();
            restartGame();
        } else if (collision(pipe3x, pipe3y, rectWidth, playerX, playerY)) {
            playerDeath();
            restartGame();
        }
        if (collision(pipe5x, pipe5y, pipe5Height, playerX, playerY)) {
            playerDeath();
            restartGame();
        } else if (collision(pipe5x, pipe5y, rectWidth, playerX, playerY)) {
            playerDeath();
            restartGame();
        }
        if (collision(pipe4x, pipe4y, pipe4Height, playerX, playerY)) {
            playerDeath();
            restartGame();
        } else if (collision(pipe4x, pipe4y, rectWidth, playerX, playerY)) {
            playerDeath();
            restartGame();
        }
        if (collision(pipe2x, pipe2y, pipe2Height, playerX, playerY)) {
            playerDeath();
            restartGame();
        } else if (collision(pipe2x, pipe2y, rectWidth, playerX, playerY)) {
            playerDeath();
            restartGame();
        }
        if (collision(pipe1x, pipe1y, pipe1Height, playerX, playerY)) {
            playerDeath();
            restartGame();
        } else if (collision(pipe1x, pipe1y, rectWidth, playerX, playerY)) {
            playerDeath();
            restartGame();
        }
        if (collision(pipe6x, pipe6y, pipe6Height, playerX, playerY)) {
            playerDeath();
            restartGame();
        } else if (collision(pipe6x, pipe6y, rectWidth, playerX, playerY)) {
            playerDeath();
            restartGame();
        }
        if (collision(pipe7x, pipe7y, pipe7Height, playerX, playerY)) {
            playerDeath();
            restartGame();
        } else if (collision(pipe7x, pipe7y, rectWidth, playerX, playerY)) {
            playerDeath();
            restartGame();
        }
    }

    public void player() { // method that creates the player and movement
        noFill();
        noStroke();
        rect(playerX, playerY, playerSize, playerSize);
        ySpeed += gravity; //movement perameters
        playerY += ySpeed; //movement perameters
        if (playerY > height - 25) { //movement perameters
            playerDeath();
            restartGame();
        }
        if (playerY < 0) {
            playerDeath();
            restartGame();
        }
    }

    public void pipe() { // method that creates pipes (x,y,width,height)
        noFill();
        noStroke();
        rect(pipe1x, pipe1y, rectWidth, pipe1Height);
        rect(pipe2x, pipe2y, rectWidth, pipe2Height);
        rect(pipe3x, pipe3y, rectWidth, pipe3Height);
        rect(pipe4x, pipe4y, rectWidth, pipe4Height);
        rect(pipe5x, pipe5y, rectWidth, pipe5Height);
        rect(pipe6x, pipe6y, rectWidth, pipe6Height);
        rect(pipe7x, pipe7y, rectWidth, pipe7Height);
    }

    public void pipes() { // method that prints pipes over rectangles
        image(pipeImage, pipe1x, pipe1y, rectWidth, pipe1Height);
        image(pipe, pipe2x, pipe2y, rectWidth, pipe2Height);
        image(pipeImage, pipe3x, pipe3y, rectWidth, pipe3Height);
        image(pipeImage, pipe4x, pipe4y, rectWidth, pipe4Height);
        image(pipe, pipe5x, pipe5y, rectWidth, pipe5Height);
        image(pipe, pipe6x, pipe6y, rectWidth, pipe6Height);
        image(pipe, pipe7x, pipe7y, rectWidth, pipe7Height);
    }

    public void keyPressed() {
        if (key == ' ') { // if space pressed player flaps
            ySpeed = -4;
            deathCheck = false;
        }
        if (keyCode == UP) {
            playerY -= 5;
        }
        if (keyCode == DOWN) {
            playerY += 5;
        }
    }

    public void playerDeath() {
        deathCheck = true;
    }

    public void pipeMovement() { // method for the illusion of the moving pipes
        xspeed = -2;
        pipe1x += xspeed;
        if (pipe1x < 10) {
            pipe1x = 800;
        }
        pipe2x += xspeed;
        if (pipe2x < 10) {
            pipe2x = 800;
        }
        pipe3x += xspeed;
        if (pipe3x < 10) {
            pipe3x = 800;
        }
        pipe4x += xspeed;
        if (pipe4x < 10) {
            pipe4x = 800;
        }
        pipe5x += xspeed;
        if (pipe5x < 10) {
            pipe5x = 800;
        }
        pipe6x += xspeed;
        if (pipe6x < 10) {
            pipe6x = 800;
        }
        pipe7x += xspeed;
        if (pipe7x < 10) {
            pipe7x = 800;
        }
    }

    public void gameOver() { // method for after death
        if (deathCheck == true) {
            background(220);
            image(lost, 0, 0, width, height); // background for death
            playerY = 400;
            textSize(70);
            fill(0, 0, 0);
            text("Press Space to Play Again", 30, 500);
        }
    }

    public void restartGame() { // reset method when play again
        playerY = 300;
        pipe1x = 700;
        pipe2x = 420;
        pipe3x = 250;
        pipe4x = 410;
        pipe5x = 600;
        pipe6x = 800;
        pipe7x = 1100;
    }
}
