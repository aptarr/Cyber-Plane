package Input;

import Main.Game;
import Main.Panel;
import Object.Bullet;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

//import static Main.Constant.Direction.*;
//import static Main.Panel.*;
//import Object.Controller;

public class KeyboardInput implements KeyListener{
    
    private Panel gamePanel;
    private Game game;
    
    public KeyboardInput(Panel gamePanel, Game game){
        this.gamePanel = gamePanel;
        this.game = game;
        
//        controller = new Controller(gamePanel);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
//        System.out.println("cek");
         switch (e.getKeyCode()) {
            case KeyEvent.VK_W:
                gamePanel.getGame().getPlayer().setUp(true);
                break;
            case KeyEvent.VK_A:
                gamePanel.getGame().getPlayer().setLeft(true);
                break;
            case KeyEvent.VK_S:
                gamePanel.getGame().getPlayer().setDown(true);
                break;
            case KeyEvent.VK_D:
                gamePanel.getGame().getPlayer().setRight(true);
                break;
            case KeyEvent.VK_SPACE:
                gamePanel.getGame().getController().addEntityA(new Bullet(gamePanel.getGame().getPlayer().getX() + 80, gamePanel.getGame().getPlayer().getY() + 25, 5f, game));
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W:
                gamePanel.getGame().getPlayer().setUp(false);
                break;
            case KeyEvent.VK_A:
                gamePanel.getGame().getPlayer().setLeft(false);
                break;
            case KeyEvent.VK_S:
                gamePanel.getGame().getPlayer().setDown(false);
                break;
            case KeyEvent.VK_D:
                gamePanel.getGame().getPlayer().setRight(false);
                break;
//            case KeyEvent.VK_SPACE:
//                System.out.println("Cek");
//                break;
        }
    }   
}
