package State;

import Main.Game;
import Object.Bullet;
import Object.Controller;
import Object.EntityA;
import Object.EntityB;
import Object.Load;
import Object.Player;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

public class Playing implements Statemethods{
    
    private Player player;
    private Controller controller;
    private Game game;
    private Pause pause;
    private GameOver gameover;
    
    private BufferedImage BGP;
    private int alien_count = 15;
    private int alien_killed = 0;
    public static int HEALTH = 100;
    private boolean paused = false;
    private boolean gameOver = false;
    
    public LinkedList<EntityA> EntityA;
    public LinkedList<EntityB> EntityB;
    
    public Playing (Game game){
        this.game = game;
        initClass();
        BGP = Load.getObject(Load.BGP);
        EntityA = controller.getEntityA();
        EntityB = controller.getEntityB();
        
        controller.addAlien(alien_count);
        
        pause = new Pause(this);
        gameover = new GameOver(this);
    }
    
    private void initClass(){
        controller = new Controller(game);
        player = new Player(200, 200, game, controller, this);
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
    
    public void unpauseGame(){
        paused = false;
    }
    
    public void resetAll(){
        gameOver = false;
        paused = false;
        player.resetAll();
        EntityB.clear();
        this.alien_count = 15;
        this.alien_killed = 0;
        controller.addAlien(alien_count);
    }
    
    public void setGameOver(boolean gameOver){
        this.gameOver = gameOver;
    }
    
    public boolean getGameOver() {
        return gameOver;
    }
    
    @Override
    public void update() {
        if(!paused && !gameOver){
            player.update(); 
            controller.tick();

            if(alien_killed >= alien_count){
                alien_count += 2;
                alien_killed = 0;
                controller.addAlien(alien_count);
            }
        }else{
            pause.update();
        }
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(BGP, 0, 0, 1280, 672, null);
        player.render(g);
        controller.draw(g);
        if(paused){
            pause.draw(g);
        }else if(gameOver){
            gameover.draw(g);
        }
            
    }
    
    @Override
    public void mouseDragged(MouseEvent e){
        if(!gameOver){
            if(paused){
                pause.mouseDragged(e);
            }else{
                player.setPos(e.getX(), e.getY());
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
      
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(!gameOver){
            if(paused){
                pause.mousePressed(e);
            }else{
                if(e.getButton() == MouseEvent.BUTTON1){
                    controller.addEntityA(new Bullet(player.getX() + 85, player.getY() + 25, 5f, controller, game));
                }
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(!gameOver){
            if(paused){
                pause.mouseReleased(e);
            }
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        if(!gameOver){
            if(paused){
                pause.mouseMoved(e);
            }else{
                player.setPos(e.getX(), e.getY());
            }
        }  
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        if(gameOver){
            gameover.keyPressed(e);
        }else{
            switch (e.getKeyCode()) {
                case KeyEvent.VK_W:
                    player.setUp(true);
                    break;
                case KeyEvent.VK_A:
                    player.setLeft(true);
                    break;
                case KeyEvent.VK_S:
                    player.setDown(true);
                    break;
                case KeyEvent.VK_D:
                    player.setRight(true);
                    break;
                case KeyEvent.VK_SPACE:
                    controller.addEntityA(new Bullet(player.getX() + 80, player.getY() + 25, 5f, controller, game));
                    break;
                case KeyEvent.VK_ESCAPE:
                    paused = !paused;
                    break;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(!gameOver){
            switch (e.getKeyCode()) {
                case KeyEvent.VK_W:
                    player.setUp(false);
                    break;
                case KeyEvent.VK_A:
                    player.setLeft(false);
                    break;
                case KeyEvent.VK_S:
                    player.setDown(false);
                    break;
                case KeyEvent.VK_D:
                    player.setRight(false);
                    break;
            }
        }
    }
}
