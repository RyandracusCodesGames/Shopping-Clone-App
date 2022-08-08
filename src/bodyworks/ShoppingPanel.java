
package bodyworks;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import java.awt.Image;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;


public class ShoppingPanel extends JPanel implements Runnable
{
    Thread shoppingThread;
    double fps = 0.3;
    
    public final int lotionState = 1, perfumeState = 2, cartState = 3;
    
    public int mainState;
    
    public double balance;
    
    Image rose = new ImageIcon("src\\images\\rosemarymint.PNG").getImage();
    Image pearl = new ImageIcon("src\\images\\sweetpearl.PNG").getImage();
    
    Image paris = new ImageIcon("src\\images\\paris.PNG").getImage();
    Image cologne = new ImageIcon("src\\images\\colong.jpg").getImage();
    
    Image imag;
    
    public ShoppingPanel()
    {
        this.setBounds(0, 60, 350, 700);
        this.setBackground(Color.darkGray.darker());
        this.setDoubleBuffered(true);
        mainMenuState();
    }
    
    public void startShoppingThread()
    {
        shoppingThread = new Thread(this);
        shoppingThread.start();
    }
    public void mainMenuState()
    {
        mainState = lotionState;
    }
    @Override
    public void run()
    {
        double drawInterval = 1000000000/fps;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        int timer = 0;
        int drawCount = 0;
        
        while(shoppingThread != null)
        {
            currentTime = System.nanoTime();
            
            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            
            lastTime = currentTime;
            
            if(delta >= 1)
            {
                update();
                repaint();
                delta--;
                drawCount++;
            }
            if(timer >= 1000000000)
            {
                drawCount = 0;
                timer = 0;
            }
        }
    }
    
    public void update()
    {

    }
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        
        Graphics2D g2 = (Graphics2D)g;
        
        g2.setColor(Color.white);
        g2.setFont(new Font("Arial",Font.BOLD,17));
        g2.drawString("Image Preview of Our Products",0, 170);
        
        
        Random rand = new Random();
        
        int im = rand.nextInt(4);
               
        switch(im)
        {
            case 1:
            imag = paris;
            break;
            case 2:
            imag = pearl;
            break;
            case 3:
            imag = rose;
            break;
            case 4:
            imag = cologne;
            break;
        }
        
        g2.drawImage(imag, 50, 200, null);
        
        
        g.dispose();
    }
            
}
