package Main;

import Input.KeyboardInput;
import Input.MouseInput;
import Object.Load;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

//import static Main.Constant.Direction.*;
import java.awt.Color;
import java.awt.image.BufferedImage;

public class Panel extends JPanel{
    
    private MouseInput mouseInput;
    private BufferedImage BG1;
    
    private Game game;
        
    public Panel(Game game){
        this.game = game;
        BG1 = Load.getObject(Load.BG1);
        
        setPanelSize();
        addKeyListener(new KeyboardInput(this, game));
        mouseInput = new MouseInput(this, game);
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
        g.setColor(new Color(50,50,50));
        g.fillRect(0, 0, 1280, 672);
        g.drawImage(BG1, 0, 0, 1280, 672, null);        
        game.render(g);
    }
}
