package Object;

//import java.awt.Graphics;

import java.awt.Rectangle;


public abstract class GameObject {
    
    protected double x, y;
//    private int velX, velY;
    
    public GameObject(double x, double y){
        this.x = x;
        this.y = y;
    }
    
//    public abstract void tick();
//    public abstract void render(Graphics g);

    public Rectangle getBounds(int width, int height){
        return new Rectangle((int) x, (int) y, width, height);
    }
    
    public double getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

//    public int getVelX() {
//        return velX;
//    }
//
//    public void setVelX(int velX) {
//        this.velX = velX;
//    }
//
//    public int getVelY() {
//        return velY;
//    }
//
//    public void setVelY(int velY) {
//        this.velY = velY;
//    }
}
