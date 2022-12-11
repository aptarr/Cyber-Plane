package State;

import Main.Game;
import Object.Bullet;
import Object.Controller;
import Object.EntityA;
import Object.EntityB;
import Object.GameObject;
import Object.Load;
import Object.Player;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Playing implements Statemethods{
    
    private Player player;
    private Controller controller;
    private Game game;
    private Pause pause;
    private GameOver gameover;
    
    private BufferedImage BGS1;
    private BufferedImage BGS2;
    private BufferedImage BGS3;
    private BufferedImage BGS4;
    private int backPos1 = 0;
    private int backPos2 = 0;
    private int backPos3 = 0;
    private int backPos4 = 0;
    private int alien_count = 15;
    private int alien_killed = 0;
    private int SCORE = 0;
    private int HIGHSCORE = 0;
    private boolean paused = false;
    private boolean gameOver = false;
    
    public ArrayList<EntityA> EntityA;
    public LinkedList<EntityB> EntityB;
    
    public Playing (Game game) throws IOException{
        this.game = game;
        initClass();

        BGS1 = Load.getObject(Load.BGS1);
        BGS2 = Load.getObject(Load.BGS2);
        BGS3 = Load.getObject(Load.BGS3);
        BGS4 = Load.getObject(Load.BGS4);
        
        EntityA = controller.getEntityA();
        EntityB = controller.getEntityB();
        
        controller.addAlien(alien_count);
        
        pause = new Pause(this);
        gameover = new GameOver(this);
        readFile();
    }
    
    private void initClass(){
        controller = new Controller(game);
        player = new Player(200, 200, game, controller, this);
    }
    
    public void readFile() throws IOException{
        FileReader fileInput;
        BufferedReader bufferInput;
        Generic<String> stringGen = new Generic<String>();
        
        try{
            fileInput = new FileReader("Database.txt");
            bufferInput = new BufferedReader(fileInput);
        }catch(Exception e){
            System.err.print("Database Tidak ada");
            return;
        }
        
        stringGen.setValue(bufferInput.readLine());
        
        while (stringGen.getValue() != null){
//            System.out.println(Integer.parseInt(data));
            if(Integer.parseInt(stringGen.getValue()) > HIGHSCORE)
                setHIGHSCORE(Integer.parseInt(stringGen.getValue()));
//            System.out.println("ini hightscore " + HIGHSCORE);
                stringGen.setValue(bufferInput.readLine());
        }
        
        fileInput.close();
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
    
    public int getHIGHSCORE() {
        return HIGHSCORE;
    }
    
    public void setHIGHSCORE(int hSCORE) {
        this.HIGHSCORE = hSCORE;
    }
        
    public int getSCORE() {
        return SCORE;
    }
    
    public void setSCORE(int aSCORE) {
        this.SCORE = aSCORE;
    }
    
    public int getBackPos1() {
        return backPos1;
    }
    
    public void setBackPos1(int backPos1) {
        this.backPos1 = backPos1;
    }
        
    public void setBackPos1() {
        this.backPos1 = backPos1 - 1;
    }
    
    public int getBackPos2() {
        return backPos2;
    }
    
    public void setBackPos2(int backPos2) {
        this.backPos2 = backPos2;
    }
        
    public void setBackPos2() {
        this.backPos2 = backPos2 - 3;
    }
    
    public int getBackPos3() {
        return backPos3;
    }
    
    public void setBackPos3(int backPos3) {
        this.backPos3 = backPos3;
    }
        
    public void setBackPos3() {
        this.backPos3 = backPos3 - 5;
    }
    
    public int getBackPos4() {
        return backPos4;
    }
    
    public void setBackPos4(int backPos4) {
        this.backPos4 = backPos4;
    }
        
    public void setBackPos4() {
        this.backPos4 = backPos4 - 9;
    }
    
    public void unpauseGame(){
        paused = false;
    }
    
    public void resetAll(){
        gameOver = false;
        paused = false;
        player.resetAll();
        EntityA.clear();
        EntityB.clear();
        this.alien_count = 15;
        this.alien_killed = 0;
        this.SCORE = 0;
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
            setBackPos1();
            setBackPos2();
            setBackPos3();
            setBackPos4();
            
            try {
                readFile();
            } catch (IOException ex) {
                System.err.print("Database Tidak ada");
            }
                       
            if(getBackPos1() < -1280){
                setBackPos1(0);
            }
            
            if(getBackPos2() < -1280){
                setBackPos2(0);
            }
            
            if(getBackPos3() < -1280){
                setBackPos3(0);
            }
            
            if(getBackPos4() < -1280){
                setBackPos4(0);
            }
            
            if(alien_killed >= alien_count){
                alien_count += 5;
                alien_killed = 0;
                controller.addAlien(alien_count);
            }

        }else{
            pause.update();
        }
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(new Color(58,46,63));
        g.fillRect(0, 0, 1280, 672);
        g.drawImage(BGS1, getBackPos1(), 0, 3240, 672, null);
        g.drawImage(BGS2, getBackPos2(), 0, 3240, 672, null);
        g.drawImage(BGS3, getBackPos3(), 0, 3240, 672, null);
        g.drawImage(BGS4, getBackPos4(), 0, 3240, 672, null);
//        GameObject[] Kplayer = {player};
        player.render(g);
        controller.draw(g);
        g.setColor(new Color(255,255,255));
        g.setFont(new Font("Upheaval TT (BRK)", Font.PLAIN, 30));
        g.drawString("Score : " + SCORE, 30, 30);
        g.setFont(new Font("Upheaval TT (BRK)", Font.PLAIN, 30));
        g.drawString("Highscore : " + HIGHSCORE, 1000, 30);
        
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
            try {
                gameover.keyPressed(e);
            } catch (IOException ex) {
                Logger.getLogger(Playing.class.getName()).log(Level.SEVERE, null, ex);
            }
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
