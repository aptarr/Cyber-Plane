package State;

import Main.Game;
import Main.Sifat;
import Object.Load;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class Menu implements Statemethods{
    
    private Game game;
    private BufferedImage BGM, JUDUL;
    private MenuButton[] button = new MenuButton[2];
    
    public Menu(Game game){
        this.game = game;
        BGM = Load.getObject(Load.BGM);
        JUDUL = Load.getObject(Load.JUDUL);
        loadButtons();
    }
    
    private void loadButtons() {
        button[0] = new MenuButton(Sifat.BOARD_WIDTH / 2, 250, 0, Gamestate.PLAYING);
        button[1] = new MenuButton(Sifat.BOARD_WIDTH / 2, 350, 1, Gamestate.QUIT);
    }
    
    @Override
    public void update() {
        for(MenuButton mb : button)
           mb.update();
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(new Color(50,50,50));
        g.fillRect(0, 0, 1280, 672);
        g.drawImage(BGM, 0, 0, 1280, 672, null);
        g.drawImage(JUDUL, Sifat.BOARD_WIDTH/2 - 250, 50, 500, 400, null);
        for(MenuButton mb : button)
           mb.draw(g);
    }
    
    @Override
    public void mouseDragged(MouseEvent e){
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
//        if(e.getButton() == MouseEvent.BUTTON1){
//            Gamestate.state = Gamestate.PLAYING;
//        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        for(MenuButton mb : button){
            if(isIn(e, mb)){
                mb.setMousePressed(true);
            }
        }
//        if(e.getButton() == MouseEvent.BUTTON1){
//            Gamestate.state = Gamestate.PLAYING;
//        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        for(MenuButton mb : button){
            if(isIn(e, mb)){
                if(mb.isMousePressed())
                    mb.applyGamestate();
                break;
            }
        }
        resetButton();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        for(MenuButton mb : button){
            mb.setMouseOver(false);
        }
        
        for(MenuButton mb : button){
            if(isIn(e, mb)){
                mb.setMouseOver(true);
                break;
            }
        }
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
//        if(e.getKeyCode() == KeyEvent.VK_ENTER)
//            Gamestate.state = Gamestate.PLAYING;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
    
    private void resetButton() {
        for(MenuButton mb : button){
            mb.reset();
        }
    }
    
    public boolean isIn(MouseEvent e, MenuButton mb){
        return mb.getBounds().contains(e.getX(), e.getY());
    }
}
