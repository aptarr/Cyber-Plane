package Object;

import Main.Game;
import Main.Sifat;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Alien extends GameObject implements EntityB{
    
    private BufferedImage imageEn;
    private Controller controller;
    private Game game;
    
    private Random r = new Random();
    private double enemySpeed = 1;
    
    public Alien(double x, double y, Controller controller, Game game){
        super(x, y);
        this.game = game;
        this.controller = controller;
        
        imageEn = Load.getObject(Load.ENEMY);
    }
    
    @Override
    public void update(){
        x -= enemySpeed;
        if(x < 0){
            enemySpeed = r.nextDouble(3) + 1;
            x = 1280;
            y = r.nextInt(672);
        }
     
        if(Physics.Collision(this, game.EntityA)){
            controller.removeEntityB(this);
            
            game.setAlien_killed(game.getAlien_killed() + 1);
        }
    }
    
    @Override
    public void render(Graphics g){
        g.drawImage(imageEn, (int) getX(), (int) getY(), Sifat.ALIEN_WIDTH, Sifat.ALIEN_HEIGHT, null);
    }
    
    @Override
    public double getX() {
        return x;
    }

    @Override
    public double getY() {
        return y;
    }
    
    @Override
    public Rectangle getBounds() {
        return new Rectangle ((int) x, (int) y, Sifat.ALIEN_WIDTH, Sifat.ALIEN_HEIGHT);
    }
}
