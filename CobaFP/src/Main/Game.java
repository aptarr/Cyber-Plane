package Main;

//import Object.Bullet;
import Object.Controller;
import Object.EntityA;
import Object.EntityB;
import Object.Player;
import java.awt.Graphics;
import java.util.LinkedList;

public class Game implements Runnable{
    
    private Window gameWindow;
    private Panel gamePanel;
    private Thread gameThread;
    private final int FPS = 120;
    private final int UPS = 200;
    
    private int alien_count = 10;
    private int alien_killed = 0;
    
    //object Game
    private Player player;
    private Controller controller;
    
    public LinkedList<EntityA> EntityA;
    public LinkedList<EntityB> EntityB;
    
    public Game(){
//        System.out.println("Cek");
        initClass();
        EntityA = controller.getEntityA();
        EntityB = controller.getEntityB();
        
        controller.addAlien(alien_count);
                
        gamePanel = new Panel(this);
        gameWindow = new Window(gamePanel);
        gamePanel.requestFocus();
        
        startGameLoop();
    }
    
    private void initClass(){
        player = new Player(200, 200);
        controller = new Controller(this);
        
    }
    
    private void startGameLoop(){
        gameThread = new Thread(this);
        gameThread.start();
    }
    
    private void update(){
        player.update(); 
        controller.tick();
        if(alien_killed >= alien_count){
            alien_count += 2;
            alien_killed = 0;
            controller.addAlien(alien_count);
        }
    }
    
    public void render(Graphics g){
        player.render(g);
        controller.draw(g);
    }
    
    public Player getPlayer(){
        return player;
    }
    
    public Controller getController(){
        return controller;
    }
    
    public void windowLostFocus(){
        player.resetDirBoolean();
    }
    
    public int getAlien_count() {
        return alien_count;
    }

    public void setAlien_count(int alien_count) {
        this.alien_count = alien_count;
    }

    public int getAlien_killed() {
        return alien_killed;
    }

    public void setAlien_killed(int enemy_killed) {
        this.alien_killed = enemy_killed;
    }
    
    @Override
    public void run() {
        
        double timePerFrame = 1000000000 / FPS;
        double timePerUpdate = 1000000000 / UPS;
        
        long previousTime = System.nanoTime();
        
        int updates = 0;
        int frames = 0;
        long lastCheck = System.currentTimeMillis();
        
        double deltaU = 0;
        double deltaF = 0;
        
        while(true){
            long currentTime = System.nanoTime();
            
            deltaU +=(currentTime - previousTime) / timePerUpdate;
            deltaF +=(currentTime - previousTime) / timePerFrame;
            previousTime = currentTime;
            
            if(deltaU >= 1){
                update();
                updates++;
                deltaU--;
            }
            
            if(deltaF >= 1){
                gamePanel.repaint();
                frames++;
                deltaF--;
            }
                        
            if(System.currentTimeMillis() - lastCheck >= 1000){
                lastCheck = System.currentTimeMillis();
                System.out.println("FPS : " + frames + " | UPS : " + updates);
                frames = 0;
                updates = 0;
            }
        }
    }
}
