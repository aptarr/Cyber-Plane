package State;

import Main.Sifat;
import Object.Load;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class Pause {
    
    private Playing playing;
    private PauseButton unpausedB, exitB;
//    private BufferedImage backgroundImg;
    
    public Pause(Playing playing){
        this.playing = playing;
//        backgroundImg = Load.getObject(Load.BGPS);
        loadButtons();
    }
    
    private void loadButtons() {
        unpausedB = new PauseButton(Sifat.BOARD_WIDTH / 2 - 100, 300, 0);
        exitB = new PauseButton(Sifat.BOARD_WIDTH / 2 + 200, 300, 1);
    }
    
    public void update(){
        unpausedB.update();
        exitB.update();
    }
    
    public void draw(Graphics g){
        //background
        g.setColor(new Color(0,0,0, 200));
        g.fillRect(0, 0, 1280, 672);
        
        //button
        unpausedB.draw(g);
        exitB.draw(g);
    }
    
    public void mouseClicked(MouseEvent e) {
        if(e.getButton() == MouseEvent.BUTTON1){
            Gamestate.state = Gamestate.PLAYING;
        }
    }
    
    public void mouseDragged(MouseEvent e){
        
    } 

    public void mousePressed(MouseEvent e) {
        if(isIn(e, unpausedB)){
            unpausedB.setMousePressed(true);
        }else if(isIn(e, exitB)){
            exitB.setMousePressed(true);
        }
    }

    public void mouseReleased(MouseEvent e) {
        if(isIn(e, unpausedB)){
            if(unpausedB.isMousePressed())
                playing.unpauseGame();
        }else if(isIn(e, exitB)){
            if(exitB.isMousePressed()){
                Gamestate.state = Gamestate.MENU;
                playing.unpauseGame();
            }
        } 
        resetButton();
    }

    public void mouseMoved(MouseEvent e) {
        unpausedB.setMouseOver(false);
        exitB.setMouseOver(false);
        
        if(isIn(e, unpausedB)){
            unpausedB.setMouseOver(true);
        }else if(isIn(e, exitB)){
            exitB.setMouseOver(true);
        }
    }
    
    private void resetButton() {
        unpausedB.reset();
        exitB.reset();
    }
    
    public boolean isIn(MouseEvent e, PauseButton pb){
        return pb.getBounds().contains(e.getX(), e.getY());
    }
}
