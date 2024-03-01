import processing.core.*;

public class App extends PApplet {
    public static void main(String[] args) {
        PApplet.main("App");
    }

    float rect1;
    float textSize = 0;
    float rectX = 100;
    float rectY = 300;
    float ySpeed = 0;
    double xspeed = 0;

    
    float rect3;
    float rect4;
    float rect5;
    float rect6;

    double gravity = 0.1;
    boolean deathCheck = false;

    float rect2X = 700;
    float rect2Y = 0;

    float rect3X = 420;
    float rect3Y = 340;

    float rect4X = 250;
    float rect4Y = 0;

    float rect5X = 410;
    float rect5Y = 0;

    float rect6X = 600;
    float rect6Y = 350;

    public void settings() {
        size(800, 600);
    }

    public void setup() {

    }

    public void draw() {
        background(173, 216, 230);
        fill(255, 255, 0);
        rect1(rectX, rectY, 50, 50);
        ySpeed += gravity;
        rectY += ySpeed;
        if (rectY > height - 25) {
            death();
            ySpeed = 0;
        }

        columnMove();

    }

    fill(0, 255, 0);
        rect1(rect2X, rect2Y, 50, 270);

        fill(0, 255, 0);
        rect2(rect3X, rect3Y, 50, 280);

        fill(0, 255, 0);
        rect3(rect4X, rect4Y, 50, 300);

        fill(0, 255, 0);
        rect(rect5X, rect5Y, 50, 240);

        fill(0, 255, 0);
        rect4(rect6X, rect6Y, 50, 300);

        if(deathCheck){
            fill(255, 0, 0);
            textSize(40);
            text("YOU LOST", 330, 300);
        }
}


    public boolean rectCollision(){
    if(rect1.X()+rect1.getwidth() < rect2.getX()){
    return false; 
    else if(rect1.getX()>rect2.getX() + rect2.getwidth()){
    return false;
    }
    else if(rect1.getY() + rect1.getheight()<rect2.getY()){
    return false;
    }
    else if(rect1.getY() > rect2.getY + rect2.getheight(){
    return false;
    }
    else(){
    return true;
    }
}
    }

    public void spacePressed() {

        ySpeed = -4;
    }

    public void mousePressed() {
        ySpeed = -4;
    }

    public void death() {
        rectY = 100;
        deathCheck = true;

    }

    public void columnMove() {
        xspeed = -0.4;
        rect2X += xspeed;
        if (rect2X < 0) {
            rect2X = 800;
        }
        rect3X += xspeed;
        if (rect3X < 0) {
            rect3X = 800;
        }
        rect4X += xspeed;
        if (rect4X < 0) {
            rect4X = 800;
        }
        rect5X += xspeed;
        if (rect5X < 0) {
            rect5X = 800;
        }
        rect6X += xspeed;
        if (rect6X < 0) {
            rect6X = 800;
        }
    }

