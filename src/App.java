import processing.core.*;

public class App extends PApplet {
    public static void main(String[] args)  {
        PApplet.main("App");
    }
    float textSize =0;
    float rectX = 100; 
    float rectY = 300;
    float ySpeed = 0;
    double xspeed = 0;   
    
    double gravity = 0.1; 
    boolean deathCheck = false;
    boolean resetCheck = false;

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
   

        public void settings(){
            size(800, 600);
        }
    
        public void setup() {
            
    }

        public void draw() {
            background(173, 216, 230); 
            fill(255, 255, 0);
            rect(rectX, rectY, 50, 50);
            ySpeed += gravity;
            rectY += ySpeed; 
            if (rectY > height - 25) {
                death();
                ySpeed = 0;
            }
            
                
                column1Move();
                column2Move();
                column3Move();
                column4Move();
                column5Move();
            
            



            fill(0, 255, 0);
            rect(rect2X, rect2Y, 50, 270);

            fill(0, 255, 0);
            rect(rect3X, rect3Y, 50, 280);

            fill(0, 255, 0);
            rect(rect4X, rect4Y, 50, 300);

            fill(0, 255, 0);
            rect(rect5X, rect5Y, 50, 240);

            fill(0, 255, 0);
            rect(rect6X, rect6Y, 50, 300);

            if(deathCheck) {
                fill(255,0,0);
            textSize(40);
            text("YOU LOST", 400, 300 );



            }
            

        }
        
        public void spacePressed() {
        
            ySpeed = -4;
        }
        public void mousePressed() {
            ySpeed = -4;
        }
        public void death() {
            rectY= 100;
            deathCheck = true;
            


        }
        public void collision() {
        }
        public void column1Move() {
            xspeed = -0.01;
            rect2X += xspeed;
            if(rect2X < 0) {
            rect2X = 800;
        }
        }
        public void column2Move() {
            xspeed = -0.1;
            rect3X += xspeed;
            if(rect3X < 0) {
            rect3X = 800;
            }
        }
        public void column3Move() {
            xspeed = -0.1;
            rect4X += xspeed;
            if(rect4X < 0) {
            rect4X = 800;
            }
        }
        public void column 4Move() {
            xspeed = -0.1;
            rect5X += xspeed;
            if(rect5X < 0) {
            rect5X = 800;
        }
        }

        }


       
       
           
        
    

