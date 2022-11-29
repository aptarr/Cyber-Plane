package Object;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;

public class Load {
    
    public static final String PLAYER = "Image/TEST_ANIMASI1.png";
    public static final String BULLET = "Image/SHOT.png";
    public static final String ENEMY = "Image/ALIEN.png";
    public static final String BG1 = "Image/BG7.jpg";
    
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
