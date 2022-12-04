package Object;

import Main.Game;
import Main.Sifat;
import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Bullet extends GameObject implements EntityA{
    
    private Game game;
    private Controller controller;
    
    private BufferedImage imageBull;
    private float bulletSpeed = 1f;
    private int counter = 0;
    
    public Bullet(double x, double y, float bulletSpeed, Controller controller, Game game){
        super(x, y);
        this.game = game;
        this.bulletSpeed = bulletSpeed;
        this.controller = controller;
        imageBull = Load.getObject(Load.BULLET);
    }
    
    @Override
    public void update(){
        x += bulletSpeed;
        for(int i = 0; i < game.getPlaying().EntityB.size(); i++){
            EntityB tempEnt = game.getPlaying().EntityB.get(i);
            
            if(Physics.Collision(this, tempEnt)){
                counter++;
                game.getPlaying().getPlayer().setSCORE(counter);
                controller.removeEntityB(tempEnt);
                controller.removeEntityA(this);
                game.getPlaying().setAlien_killed(game.getPlaying().getAlien_killed() + 1);
            }
        }
//        if(Physics.Collision(this, game.getPlaying().EntityB)){
//            System.out.println("Collision Detect");
//        }
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
