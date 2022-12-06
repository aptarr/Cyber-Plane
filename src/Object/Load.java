package Object;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;

public class Load {
    
    public static final String PLAYER = "Image/TEST_ANIMASI1.png";
    public static final String BULLET = "Image/SHOT.png";
    public static final String ENEMY = "Image/ALIEN.png";
    public static final String BGP = "Image/BG7.jpg";
    public static final String MENU_BUTTON = "Image/coba button.png";
    public static final String BGM = "Image/BG8.png";
    public static final String JUDUL = "Image/coba judul.png";
    public static final String GAME_OVER = "Image/coba gameover.png";
    public static final String UE_BUTTON = "Image/coba button2.png";
    public static final String PAUSED = "Image/coba paused.png";
    
    public static BufferedImage getObject(String fileName){
        BufferedImage image = null;
        InputStream I1 = Load.class.getResourceAsStream("/" + fileName);
        
        try {
            image = ImageIO.read(I1);
        } catch (IOException ex) {
            ex.printStackTrace();
        }finally{
            try{
                I1.close();
            }catch (IOException e) {
                e.printStackTrace();
            }
        }
        return image;
    }
}
