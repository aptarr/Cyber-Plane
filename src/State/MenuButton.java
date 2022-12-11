package State;

import Object.Load;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class MenuButton {
    private Gamestate state;
    private int xPos, yPos, rowIndex, index;
    private int xCenter = 100;
    private BufferedImage[] imgs;
    private boolean mouseOver, mousePressed;
    private Rectangle bounds;
    
    public MenuButton(int xPos, int yPos, int rowIndex, Gamestate state){
        this.xPos = xPos;
        this.yPos = yPos;
        this.rowIndex = rowIndex;
        this.state = state;
        loadImgs();
        initBounds();
    }
    
    private void loadImgs(){
        imgs = new BufferedImage[3];
        BufferedImage temp = Load.getObject(Load.MENU_BUTTON);
        for(int i = 0; i< imgs.length; i++)
            imgs[i] = temp.getSubimage(i * 360, rowIndex * 150, 360, 150);
    }
    
    public void draw(Graphics g){
        g.drawImage(imgs[index], xPos - xCenter, yPos, 180, 75, null);
    }
    
    public void update(){
        index = 0;
        if(isMouseOver())
            index = 1;
        if(isMousePressed())
            index = 2;
    }
    
    public boolean isMouseOver() {
        return mouseOver;
    }

    public void setMouseOver(boolean mouseOver) {
        this.mouseOver = mouseOver;
    }

    public boolean isMousePressed() {
        return mousePressed;
    }

    public void setMousePressed(boolean mousePressed) {
        this.mousePressed = mousePressed;
    }

    private void initBounds() {
        bounds = new Rectangle(xPos - xCenter, yPos, 180, 75);
    }
    
    public Rectangle getBounds(){
        return bounds;
    }
    
    public void applyGamestate(){
        Gamestate.state = state;
    }
    
    public void reset(){
        mouseOver = false;
        mousePressed = false;
    }
}
