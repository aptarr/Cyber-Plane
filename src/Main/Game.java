package Main;

import State.Gamestate;
import State.Menu;
import State.Playing;
import java.awt.Graphics;
import java.io.IOException;

public class Game implements Runnable{
    
    private Window gameWindow;
    private Panel gamePanel;
    private Thread gameThread;
    private final int FPS = 120;
    private final int UPS = 200;
    
    private Playing playing;
    private Menu menu;
    
    public Game() throws IOException{
//        System.out.println("Cek");
        initClass();        
        
        gamePanel = new Panel(this);
        gameWindow = new Window(gamePanel);
        gamePanel.requestFocus();
        
        startGameLoop();
    }
    
    private void initClass() throws IOException{
        menu = new Menu(this);
        playing = new Playing(this);
        
    }
    
    private void startGameLoop(){
        gameThread = new Thread(this);
        gameThread.start();
    }
    
    private void update(){
        switch(Gamestate.state){
            case MENU:
                menu.update();
                break;
            case PLAYING:
                playing.update();
                break;
            case QUIT:
            default:
                System.exit(0);
                break;
        }
        
    }
    
    public void render(Graphics g){
        switch(Gamestate.state){
            case MENU:
                menu.draw(g);
                break;
            case PLAYING:
                playing.draw(g);
                break;
            default:
                break;
        }
    }
    
    public Menu getMenu(){
        return menu;
    }
    
    public Playing getPlaying(){
        return playing;
    }
    
    public void windowLostFocus(){
        if(Gamestate.state == Gamestate.PLAYING)
            playing.getPlayer().resetDirBoolean();
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
