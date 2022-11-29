package Main;

import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import javax.swing.JFrame;

public class Window extends JFrame{ 
    public Window(Panel gamePanel){
        setTitle("Pesawat VS Alien");
//        setSize(Sifat.BOARD_WIDTH, Sifat.BOARD_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(gamePanel);
        setLocationRelativeTo(null);
        pack();
        setResizable(false);
        setVisible(true);
        addWindowFocusListener(new WindowFocusListener(){
            @Override
            public void windowGainedFocus(WindowEvent e) {
                
            }

            @Override
            public void windowLostFocus(WindowEvent e) {
//                System.out.println("Cek");
                gamePanel.getGame().windowLostFocus();
            }
            
        });
    }
}
