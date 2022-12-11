package Object;

import Main.Game;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class Controller {
    
    private Random r = new Random();
  
    ArrayList<EntityA> entityA = new ArrayList<>();
    LinkedList<EntityB> entityB = new LinkedList<>();
    
    EntityA TempEntityA;
    EntityB TempEntityB;
    
    Game game;
    
    public Controller(Game game){
        this.game = game;
//        for(int i=0; i<Sifat.BOARD_HEIGHT; i+= 100){
//            addEntityB(new Alien(500, i, this, game));
//        }
//        addEnemy(new Enemy(500, 300));
//        addBullet(new Bullet(100, 200, 5f));
    }
    
    public void addAlien(int alien_count){
        for(int i=0; i < alien_count; i++){
            addEntityB(new Alien(1280, r.nextInt(600), this, game, (int)r.nextDouble(2) + 1));
        }
    }
    
    public void tick(){
        for(int i=0; i < entityA.size(); i++){
            TempEntityA = entityA.get(i);
            
            if(TempEntityA.getX() > 1180)
                entityA.remove(TempEntityA);
            
            TempEntityA.update();
        }
        
        for(int i=0; i < entityB.size(); i++){
            TempEntityB = entityB.get(i);
            
            TempEntityB.update();
        }
    }
    
    public void draw(Graphics g){
        for(int i=0; i < entityA.size(); i++){
            TempEntityA = entityA.get(i);
            
            TempEntityA.render(g);
        }
        
        for(int i=0; i < entityB.size(); i++){
            TempEntityB = entityB.get(i);
            
            TempEntityB.render(g);
        }
    }
    
    public void addEntityA(EntityA object){
        entityA.add(object);
    }
    
    public void removeEntityA(EntityA object){
        entityA.remove(object);
    }
    
    public void addEntityB(EntityB object){
        entityB.add(object);
    }
    
    public void removeEntityB(EntityB object){
        entityB.remove(object);
    }
    
    public ArrayList<EntityA> getEntityA(){
        return entityA;
    }
    
    public LinkedList<EntityB> getEntityB(){
        return entityB;
    }
}
