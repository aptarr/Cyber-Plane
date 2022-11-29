package Object;

import Main.Sifat;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Player extends GameObject implements EntityA{

//    public static final double PLAYER_SIZE = 58;
    private BufferedImage[] Ani1;
    private int aniTick, aniIndex, aniSpeed = 15;
    private boolean left, up, right, down;
    private float playerSpeed = 5.0f;
     
    public Player(double x, double y){
        super(x, y);
        loadAnimation();
    }
    
    @Override
    public void update(){
        updateAnimationTick();
//        setAnimation();
        updatePos();
    }
    
    @Override
    public void render(Graphics g){
         g.drawImage(Ani1[aniIndex], (int) getX(), (int) getY(), Sifat.PLAYER_WIDTH, Sifat.PLAYER_WIDTH, null);
    }
    
    private void updateAnimationTick(){
        aniTick++;
        if(aniTick >= aniSpeed){
            aniTick = 0;
            aniIndex++;
            if(aniIndex >= 13){
                aniIndex = 0;
            }
        }
    }
    
//    private void setAnimation(){
//        if(moving){
//            playerAction
//        }
//    }
    
    private void updatePos(){
        if(left && !right){
            x -= playerSpeed;
            if(x <= 0)
                x = 0;
        }else if(right && !left){
            x += playerSpeed;
            if(x >= 1280 - 100)
                x = 1280 - 100;
        }
        
        if(up && !down){
            y -= playerSpeed;
            if(y <= 0)
                y = 0;
        }else if(down && !up){
            y += playerSpeed;
            if(y >= 672 - 85)
                y = 672 - 85;
        }
    }
    
    public void setPos(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    private void loadAnimation() {
        BufferedImage image = Load.getObject(Load.PLAYER);
            
        Ani1 = new BufferedImage[13];
        for(int i = 0; i< Ani1.length; i++){
            Ani1[i] = image.getSubimage(i*58, 0, Sifat.PLAYER_SIZE, Sifat.PLAYER_SIZE);
        }
//        for(int j=0; j < Ani1.length; j++){
//            for(int i = 0; i< Ani1[j].length; i++){
//                Ani1[j][i] = image.getSubimage(i*72, j*35, 72, 35);
//            }
//        }
    }
    
    public void resetDirBoolean(){
        up = false;
        down = false;
        left = false;
        right = false;
    }

    public boolean isLeft() {
        return left;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    public boolean isUp() {
        return up;
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    public boolean isRight() {
        return right;
    }

    public void setRight(boolean right) {
        this.right = right;
    }

    public boolean isDown() {
        return down;
    }

    public void setDown(boolean down) {
        this.down = down;
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle ((int) x, (int) y, Sifat.PLAYER_WIDTH, Sifat.PLAYER_HEIGHT);
    }
}
