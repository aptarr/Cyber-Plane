package State;

import Main.Sifat;
import Object.Load;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

public class GameOver {
    private Playing playing;
    private BufferedImage GO;
    
    public GameOver(Playing playing){
        this.playing = playing;
        GO = Load.getObject(Load.GAME_OVER);
    }
    
    public void draw(Graphics g){
        g.setColor(new Color(0,0,0, 200));
        g.fillRect(0, 0, 1280, 672);
        g.drawImage(GO, Sifat.BOARD_WIDTH/2 - 250, 200, 500, 400, null);
    }
    
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
            playing.resetAll();
            Gamestate.state = Gamestate.MENU;
        }
    }
}
