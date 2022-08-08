
package bodyworks;

import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import java.awt.Image;
import javax.swing.ImageIcon;


public class GraphicsPanel extends JPanel implements Runnable
{
    Image sale = new ImageIcon("src\\images\\sale.PNG").getImage();
    
    Thread graphicsThread;
    int fps = 60;
    
    int x = 0, x2 = 1000;
    
    public GraphicsPanel()
    {
       this.setBounds(0, 0, 700, 80);
       this.setDoubleBuffered(true);
    }
    
    public void startGraphicsThread()
    {
        graphicsThread = new Thread(this);
        graphicsThread.start();
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
        
        while(graphicsThread != null)
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
       saleAdjustment();
    }
    
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        
        Graphics2D g2 = (Graphics2D)g;
        
        g2.drawImage(sale, x, 0, null);
        g2.drawImage(sale, x2, 0, null);
        
        g.dispose();
    }
    
    public void saleAdjustment()
    {
        x--;
        x2--;
        
        if(x < -1050)
        {
            x = 900;
        }
        if(x2 < -1050)
        {
            x2 = 900;
        }
  
  
    }
}
