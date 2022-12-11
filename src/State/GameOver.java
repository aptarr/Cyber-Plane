package State;

import Main.Sifat;
import Object.Load;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class GameOver {
    private Playing playing;
    private BufferedImage GO;
    
    public GameOver(Playing playing){
        this.playing = playing;
        GO = Load.getObject(Load.GAME_OVER);
    }
    
    public void writeFile() throws IOException{
        FileWriter fileOutput = new FileWriter("Database.txt");
        BufferedWriter bufferOutput = new BufferedWriter(fileOutput);
        
        String data = Integer.toString(playing.getSCORE());
        bufferOutput.write(data);
        bufferOutput.newLine();
        bufferOutput.flush();
//        System.out.println(data);
        
        fileOutput.close();
    }
    
    public void draw(Graphics g){
        g.setColor(new Color(0,0,0, 200));
        g.fillRect(0, 0, 1280, 672);
        g.drawImage(GO, Sifat.BOARD_WIDTH/2 - 250, 200, 500, 400, null);
    }
    
    public void keyPressed(KeyEvent e) throws IOException{
        if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
            writeFile();
            playing.resetAll();
            Gamestate.state = Gamestate.MENU;
        }
    }
}
