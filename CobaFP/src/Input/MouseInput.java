package Input;

import Main.Game;
import Main.Panel;
import Object.Bullet;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseInput implements MouseListener, MouseMotionListener {
    
    private Panel gamePanel;
    private Game game;
    
    public MouseInput(Panel gamePanel, Game game){
        this.gamePanel = gamePanel;
        this.game = game;
        
//        controller = new Controller(gamePanel);
    }
    
    @Override
    public void mouseDragged(MouseEvent e) {
        gamePanel.getGame().getPlayer().setPos(e.getX(), e.getY());
        if(e.getButton() == MouseEvent.BUTTON1){
            
            gamePanel.getGame().getController().addEntityA(new Bullet(gamePanel.getGame().getPlayer().getX() + 80, gamePanel.getGame().getPlayer().getY() + 25, 5f, game));
        }
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseMoved(MouseEvent e) {
//        System.out.println("mouse gerak");
        gamePanel.getGame().getPlayer().setPos(e.getX(), e.getY());
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        gamePanel.getGame().getPlayer().setPos(e.getX(), e.getY());
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getButton() == MouseEvent.BUTTON1){
//            gamePanel.getGame().getPlayer().setPos(e.getX(), e.getY());
            gamePanel.getGame().getController().addEntityA(new Bullet(gamePanel.getGame().getPlayer().getX() + 85, gamePanel.getGame().getPlayer().getY() + 25, 5f, game));
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseEntered(MouseEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseExited(MouseEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
