package Object;

import Main.Game;
import Main.Sifat;
import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Bullet extends GameObject implements EntityA{
    
    private BufferedImage imageBull;
    private float bulletSpeed = 1f;
    private Game game;
    
    public Bullet(double x, double y, float bulletSpeed, Game gamePanel){
        super(x, y);
        this.bulletSpeed = bulletSpeed;
        imageBull = Load.getObject(Load.BULLET);
        this.game = gamePanel;
    }
    
    @Override
    public void update(){
        x += bulletSpeed;
        if(Physics.Collision(this, game.EntityB)){
            System.out.println("Collision Detect");
        }
    }
    
    @Override
    public void render(Graphics g){
        g.drawImage(imageBull, (int) x, (int) y, Sifat.BULLET_WIDTH, Sifat.BULLET_HEIGHT, null);
    }
    
    @Override
    public Rectangle getBounds() {
        return new Rectangle ((int) x, (int) y, Sifat.BULLET_WIDTH, Sifat.BULLET_HEIGHT);
    }
}
