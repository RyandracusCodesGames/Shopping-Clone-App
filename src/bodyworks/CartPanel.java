
package bodyworks;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class CartPanel extends JPanel implements Runnable
{
    Thread cartThread;
    double fps = 60;
    
    double balance = 0;
    
    int rosemary = 0;
    int sweetpearl = 0;
    int paris = 0;
    int cologne = 0;
    
    Image receipt = new ImageIcon("src\\images\\receipt.png").getImage();
    
    String[] items = {"Rosemary mint","Sweet Pearl","Paris","Cologne"};
    
    public CartPanel()
    {
        this.setBounds(380, 90, 180, 290);
        this.setBackground(Color.darkGray);
        this.setDoubleBuffered(true);
    }
    
    public void startCartThread()
    {
        cartThread = new Thread(this);
        cartThread.start();
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
        
        while(cartThread != null)
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
        if(balance < 0)
        {
            balance = 0;
        }
        
        if(rosemary < 0)
        {
            rosemary = 0;
        }
        if(sweetpearl < 0)
        {
            sweetpearl = 0;
        }
        if(paris < 0)
        {
            paris = 0;
        }
        if(cologne < 0)
        {
            cologne = 0;
        }
    }
    
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        
        Graphics2D g2 = (Graphics2D)g;
        
        g2.setColor(Color.black);
        g2.setFont(new Font("Arial",Font.BOLD,18));
        
        String bal = String.format("%.2f",balance);
        
        g2.drawString("Rosemary Mint x"+" "+String.valueOf(rosemary), 10, 50);
        g2.drawString("Sweet Pearl x"+" "+String.valueOf(sweetpearl), 10, 90);
        g2.drawString("Paris x"+" "+String.valueOf(paris), 10, 130);
        g2.drawString("Cologne x"+" "+String.valueOf(cologne), 10, 170);
        g2.drawString("__________", 10, 180);
        g2.drawString("Total:"+" "+bal, 10, 210);
        
       // g2.drawImage(receipt, 0, 0, null);
       
        g.dispose();
    }
    
    
            
    
}
