package Main;

import Input.KeyboardInput;
import Input.MouseInput;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Panel extends JPanel{
    
    private MouseInput mouseInput;
    private Game game;
        
    public Panel(Game game){
        this.game = game;
        
        setPanelSize();
        addKeyListener(new KeyboardInput(this, game));
        mouseInput = new MouseInput(this);
        addMouseListener(mouseInput);
        addMouseMotionListener(mouseInput);
    }
    
    private void setPanelSize() {
        Dimension size = new Dimension(Sifat.BOARD_WIDTH, Sifat.BOARD_HEIGHT);
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
    }

    public void updateGame(){
        
    }
    
    public Game getGame(){
        return game;
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
   
        game.render(g);
    }
}
