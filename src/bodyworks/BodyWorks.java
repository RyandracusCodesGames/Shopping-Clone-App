
package bodyworks;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.sql.*;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;


public class BodyWorks implements ActionListener{
    
    public static BodyWorks body;
    
    public static JFrame jframe, frame, shop, fram, carte;
    
    public static JTextField text = new JTextField(15), text4 = new JTextField(15);
    
    public static JPasswordField pass = new JPasswordField(15), passw = new JPasswordField(15);
    
    public static GraphicsPanel gp = new GraphicsPanel();
    
    public static JButton login, register, forgot, regReturn, reg, lotion, perfume, cart, ret, ret2, butt, purchase, purchase2, buy;
    
    public static JButton purchase3, purchase4, remove, remove2, remove3, remove4;
    
    public static ShoppingPanel showP = new ShoppingPanel();
    
    public static CartPanel cartPanel = new CartPanel();
    
    public static Image rose = new ImageIcon("src\\images\\rosemarymint.PNG").getImage();
    public static Image pearl = new ImageIcon("src\\images\\sweetpearl.PNG").getImage();
    
    public static Image paris = new ImageIcon("src\\images\\paris.PNG").getImage();
    public static Image cologne = new ImageIcon("src\\images\\colong.jpg").getImage();
    
    public JLabel label4 = new JLabel(), Labname = new JLabel();
    
    public JLabel label2 = new JLabel(), Labname2 = new JLabel();
   
    
    public JPanel col = new JPanel();
    
    public String pic = "src\\images\\rosemarymint.PNG";
    public String pic2 = "src\\images\\sweetpearl.PNG";
    
    public String name = "Rosemary Mint Lotion";
    public String name2 = "Sweet Pearl Lavender Lotion";
    
    public String price = "";
    public String price2 = "";
    
    public BodyWorks()
    {
        jframe = new JFrame();
        jframe.setSize(700,700);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setResizable(false);
        jframe.setTitle("Skin and Body Baths");
        jframe.add(gp);
        jframe.setLayout(null);
        jframe.setIconImage(new ImageIcon("src\\images\\candle.PNG").getImage());
       
       JPanel panel = new JPanel();
       panel.setBounds(0, 20, 700, 600);
       panel.setLayout(null);
       panel.setBackground(Color.darkGray.darker());
       
       JLabel label = new JLabel();
       label.setText("Username:");
       label.setBounds(180, 170, 300, 300);
       label.setForeground(Color.white);
       label.setFont(new Font("Arial",Font.BOLD,18));
       
       JLabel label2 = new JLabel();
       label2.setText("Password:");
       label2.setBounds(180, 220, 300, 300);
       label2.setForeground(Color.white);
       label2.setFont(new Font("Arial", Font.BOLD,18));
       
       login = new JButton("Login");
       login.setBounds(350, 400, 100, 50);
       login.setBackground(Color.orange);
       login.setForeground(Color.white);
       login.setFocusPainted(false);
       login.addActionListener(this);
       
       JLabel portrait = new JLabel();
       portrait.setBounds(140, 150, 490, 120);
       portrait.setIcon(new ImageIcon("src\\images\\body.png"));
       
       register = new JButton("Register");
       register.setBounds(230, 400, 100, 50);
       register.setBackground(Color.red);
       register.setForeground(Color.white);
       register.setFocusPainted(false);
       register.addActionListener(this);
       
       forgot = new JButton("Forgot Password");
       forgot.setBounds(270, 460, 140, 50);
       forgot.setBackground(Color.red);
       forgot.setForeground(Color.white);
       forgot.setFocusPainted(false);
       forgot.addActionListener(this);
       
       text.setBounds(280, 290, 200, 22);
       pass.setBounds(280, 340, 200, 22);

       jframe.add(login);
       jframe.add(register);
       jframe.add(forgot);
       jframe.add(label);
       jframe.add(label2);
       jframe.add(portrait);
       jframe.add(panel);
       
       
       panel.add(text);
       panel.add(pass);
       
       
       
       jframe.setVisible(true); 
       
       gp.startGraphicsThread();
    }
     @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == login)
        {
            try
            {
                String user = text.getText();
                String password = String.valueOf(pass.getPassword());
                Connection con = getConnection();
                
                String query = "SELECT * FROM tablename WHERE username = '"+user+"' AND password ='"+password+"'";
                
                PreparedStatement prep = con.prepareStatement(query);
                

                ResultSet rs = prep.executeQuery();
                
                if(rs.next())
                {
                    jframe.dispose();
                    
                    purchase = new JButton("Add to Cart");
                    purchase.setBounds(450, 300, 100, 50);
                    purchase.setForeground(Color.white);
                    purchase.setBackground(Color.green);
                    purchase.addActionListener(this);
                    
                    purchase2 = new JButton("Add to Cart");
                    purchase2.setBounds(450, 600, 100, 50);
                    purchase2.setForeground(Color.white);
                    purchase2.setBackground(Color.green);
                    purchase2.addActionListener(this);
                   
                    col.setBounds(300, 50, 600, 700);
                    col.setBackground(Color.darkGray.darker());
            
                    
                    shop = new JFrame();
                    shop.setSize(700, 700);
                    shop.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    shop.setResizable(false);
                    shop.setTitle("Skin and Body Baths");
                    shop.setLayout(null);
                    shop.setIconImage(new ImageIcon("src\\images\\candle.PNG").getImage());
   
                    shop.add(purchase);
                    shop.add(purchase2);
                    shop.add(showP);

                    JPanel panel2 = new JPanel();
                    panel2.setBounds(0, 0, 700, 60);
                    panel2.setBackground(Color.orange);
                    
                    lotion = new JButton("Lotion");
                    lotion.setBounds(50, 0, 100, 50);
                    lotion.setForeground(Color.white);
                    lotion.setBackground(Color.red);
                    lotion.addActionListener(this);
                    lotion.setFocusPainted(false);
                    
                    perfume = new JButton("Perfume");
                    perfume.setBounds(300, 0, 100, 50);
                    perfume.setForeground(Color.white);
                    perfume.setBackground(Color.red);
                    perfume.setFocusPainted(false);
                    perfume.addActionListener(this);
                   
                    cart = new JButton("Cart");
                    cart.setBounds(550, 0, 100, 50);
                    cart.setForeground(Color.white);
                    cart.setBackground(Color.red);
                    cart.setFocusPainted(false);
                    cart.addActionListener(this);
                    
                    
                    shop.add(lotion);
                    shop.add(perfume);
                    shop.add(cart);
                    shop.add(panel2);

                    shop.setVisible(true);
                    
                    showP.startShoppingThread();
                    
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Incorrect Username or Password!");
                }
                
                
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
        }
        if(e.getSource() == perfume)
        {
           pic = "src\\images\\paris.PNG"; 
           pic2 = "src\\images\\cologne.jpg";
           
           name = "Paris Cologne";
           name2 = "Freshwater Perfume";
           
           price = "$13.27";
           price2 = "$12.14";
           
           JLabel label = new JLabel();
           label.setText(price);
           label.setForeground(Color.black);
           label.setBounds(600, 200, 100, 50);
           
           JLabel label22 = new JLabel();
           label22.setText(price2);
           label22.setForeground(Color.black);
           label22.setBounds(600, 500, 100, 50);
           
           label4.setBounds(450, 10, 400, 400);
           label4.setIcon(new ImageIcon(pic));
           
           label2.setBounds(450, 300, 400, 400);
           label2.setIcon(new ImageIcon(pic2));

           Labname.setText(name);
           Labname.setBounds(440, 50, 400, 100);
           Labname.setForeground(Color.darkGray.darker());
           Labname.setFont(new Font("Arial",Font.BOLD, 20));
           
           Labname2.setText(name2);
           Labname2.setBounds(410, 340, 400, 100);
           Labname2.setForeground(Color.darkGray.darker());
           Labname2.setFont(new Font("Arial",Font.BOLD, 20));
           
           purchase3 = new JButton("Add to Cart");
           purchase3.setBounds(450, 300, 100, 50);
           purchase3.setForeground(Color.white);
           purchase3.setBackground(Color.red);
           purchase3.addActionListener(this);
                    
           purchase4 = new JButton("Add to Cart");
           purchase4.setBounds(450, 600, 100, 50);
           purchase4.setForeground(Color.white);
           purchase4.setBackground(Color.red);
           purchase4.addActionListener(this);
           
           shop.add(purchase3);
           shop.add(purchase4);
           shop.add(Labname);
           shop.add(Labname2);
           shop.add(label4);
           shop.add(label2);
           shop.add(label);
           shop.add(label22);
           
           purchase.setVisible(false);
           purchase2.setVisible(false);
           purchase3.setVisible(true);
           purchase4.setVisible(true);
           
           shop.validate();
           
           shop.setVisible(true);
        }
        if(e.getSource() == lotion)
        {
            pic = "src\\images\\rosemarymint.PNG";
            pic2 = "src\\images\\sweetpearl.PNG";
            
            name = "Rosemary Mint Lotion";
            name2 = "Sweet Pearl Lavender Lotion";
            
            price = "$13.27";
            price2 = "$12.14";
           
           JLabel label = new JLabel();
           label.setText(price);
           label.setForeground(Color.black);
           label.setBounds(600, 200, 100, 50);
           
           JLabel label22 = new JLabel();
           label22.setText(price2);
           label22.setForeground(Color.black);
           label22.setBounds(600, 500, 100, 50);

           label4.setBounds(450, 0, 400, 400);
           label4.setIcon(new ImageIcon(pic));
        

           label2.setIcon(new ImageIcon(pic2));
           
           Labname.setText(name);
           Labname.setBounds(410, 40, 400, 100);
           Labname.setForeground(Color.darkGray.darker());
           Labname.setFont(new Font("Arial",Font.BOLD, 20));
           
           Labname2.setText(name2);
           Labname2.setBounds(390, 340, 400, 100);
           Labname2.setForeground(Color.darkGray.darker());
           Labname2.setFont(new Font("Arial",Font.BOLD, 20));
           
           purchase.setVisible(true);
           purchase2.setVisible(true);
           purchase3.setVisible(false);
           purchase4.setVisible(false);
           
           shop.add(Labname);
           shop.add(Labname2);
           shop.add(label4);
           shop.add(label2);
           shop.add(label);
           shop.add(label22);
           
           shop.validate();
           
           shop.setVisible(true);
        }
        
        if(e.getSource() == purchase)
        {
            cartPanel.rosemary++;
            cartPanel.balance += 13.27;
        }
        
        if(e.getSource() == purchase2)
        {
            cartPanel.sweetpearl++;
            cartPanel.balance += 12.14;
        }
        
        if(e.getSource() == purchase3)
        {
            cartPanel.paris++;
            cartPanel.balance += 13.27;
        }
        
        if(e.getSource() == purchase4)
        {
            cartPanel.cologne++;
            cartPanel.balance += 12.14;
        }
        if(e.getSource() == remove)
        {
            if(cartPanel.rosemary > 0)
            {
              cartPanel.rosemary--;
              cartPanel.balance -= 13.27;
            }
            
        }
        
        if(e.getSource() == remove2)
        {
            if(cartPanel.sweetpearl > 0)
            {
              cartPanel.sweetpearl--;
              cartPanel.balance -= 12.14;
            }
            
        }
        
        if(e.getSource() == remove3)
        {
            if(cartPanel.paris > 0)
            {
             cartPanel.paris--;
             cartPanel.balance -= 13.27;
            } 
        }
        
        if(e.getSource() == remove4)
        {
            if(cartPanel.cologne > 0)
            {
             cartPanel.cologne--;
             cartPanel.balance -= 12.14;
            }
        }
        
        if(e.getSource() == cart)
        {
            
            shop.dispose();
            
            carte = new JFrame();
            carte.setSize(700,700);
            carte.setResizable(false);
            carte.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            carte.setTitle("Skin and Body Baths");
            carte.setIconImage(new ImageIcon("src\\images\\candle.PNG").getImage());
            carte.add(cartPanel);
            
            cartPanel.startCartThread();
            
            JPanel panel = new JPanel();
            panel.setBounds(0, 60, 700, 700);
            panel.setBackground(Color.darkGray.darker());
            
            JPanel panel2 = new JPanel();
            panel2.setBounds(0, 0, 700, 60);
            panel2.setBackground(Color.orange);
            
            ret2 = new JButton("Return");
            ret2.setBounds(0, 0, 100, 15);
            ret2.setForeground(Color.white);
            ret2.setBackground(Color.red);
            ret2.setFocusPainted(false);
            ret2.addActionListener(this);
            
            JLabel label = new JLabel();
            label.setText("Payment Information");
            label.setFont(new Font("Arial",Font.BOLD, 18));
            label.setBounds(10, 70, 200, 100);
            label.setForeground(Color.white);
            
            JLabel label2 = new JLabel();
            label2.setText("___________________");
            label2.setFont(new Font("Arial",Font.BOLD, 18));
            label2.setBounds(5, 72, 200, 100);
            label2.setForeground(Color.white);
            
            JLabel label3 = new JLabel();
            label3.setText("Card Type:");
            label3.setFont(new Font("Arial",Font.BOLD, 18));
            label3.setBounds(10, 100, 200, 100);
            label3.setForeground(Color.white);
            
            JLabel label4 = new JLabel();
            label4.setBounds(110, 52, 200, 200);
            label4.setIcon(new ImageIcon("src\\images\\visa.png"));
            
            JRadioButton b = new JRadioButton();
            b.setBounds(135, 148, 20, 10);
         
            JLabel label5= new JLabel();
            label5.setBounds(160, 52, 200, 200);
            label5.setIcon(new ImageIcon("src\\images\\mastercard.png"));
            
            JRadioButton b2 = new JRadioButton();
            b2.setBounds(195, 148, 20, 10);
            
            JLabel label6 = new JLabel();
            label6.setText("Card Number:");
            label6.setFont(new Font("Arial",Font.BOLD, 18));
            label6.setBounds(10, 135, 200, 100);
            label6.setForeground(Color.white);
            
            JTextField text = new JTextField(25);
            text.setBounds(135, 177, 150, 20);
            
            JLabel label7 = new JLabel();
            label7.setText("Expiration Date:");
            label7.setFont(new Font("Arial",Font.BOLD, 18));
            label7.setBounds(10, 170, 200, 100);
            label7.setForeground(Color.white);
            
            JComboBox box = new JComboBox();
            box.setBounds(155, 212, 70, 18);
            box.addItem("1");
            box.addItem("2");
            box.addItem("3");
            box.addItem("4");
            box.addItem("5");
            box.addItem("6");
            box.addItem("7");
            box.addItem("8");
            box.addItem("9");
            box.addItem("10");
            box.addItem("11");
            box.addItem("12");
            
            JComboBox box2 = new JComboBox();
            box2.setBounds(240, 212, 70, 18);
            box2.addItem("2022");
            box2.addItem("2023");
            box2.addItem("2024");
            box2.addItem("2025");
            box2.addItem("2026");
            box2.addItem("2027");
            box2.addItem("2028");
            
            JLabel label8 = new JLabel();
            label8.setText("CVV:");
            label8.setFont(new Font("Arial",Font.BOLD, 18));
            label8.setBounds(10, 205, 200, 100);
            label8.setForeground(Color.white);
            
            JTextField text2 = new JTextField(4);
            text2.setBounds(60, 245, 150, 20);
            
            JLabel label9 = new JLabel();
            label9.setText("Card Holder's Name:");
            label9.setFont(new Font("Arial",Font.BOLD, 18));
            label9.setBounds(10, 240, 200, 100);
            label9.setForeground(Color.white);
            
            JTextField text3 = new JTextField(40);
            text3.setBounds(195, 280, 220, 20);
            
            JLabel label11 = new JLabel();
            label11.setText("Email Address:");
            label11.setFont(new Font("Arial",Font.BOLD, 18));
            label11.setBounds(10, 275, 200, 100);
            label11.setForeground(Color.white);
            
            JTextField text4 = new JTextField(40);
            text4.setBounds(150, 315, 210, 20);
            
            buy = new JButton("Purchase");
            buy.setBounds(75, 350, 100, 50);
            buy.setForeground(Color.white);
            buy.setBackground(Color.green);
            buy.addActionListener(this);
            
            remove = new JButton("Remove 1");
            remove.setBounds(570, 120, 100, 25);
            remove.setForeground(Color.white);
            remove.setBackground(Color.red);
            remove.addActionListener(this);
            
            remove2 = new JButton("Remove 1");
            remove2.setBounds(570, 160, 100, 25);
            remove2.setForeground(Color.white);
            remove2.setBackground(Color.red);
            remove2.addActionListener(this);
            
            remove3 = new JButton("Remove 1");
            remove3.setBounds(570, 200, 100, 25);
            remove3.setForeground(Color.white);
            remove3.setBackground(Color.red);
            remove3.addActionListener(this);
            
            remove4 = new JButton("Remove 1");
            remove4.setBounds(570, 240, 100, 25);
            remove4.setForeground(Color.white);
            remove4.setBackground(Color.red);
            remove4.addActionListener(this);
            carte.add(remove);
            carte.add(remove2);
            carte.add(remove3);
            carte.add(remove4);
            carte.add(ret2);
            carte.add(label);
            carte.add(label2);
            carte.add(label3);
            carte.add(label4);
            carte.add(label5);
            carte.add(label6);
            carte.add(label7);
            carte.add(label8);
            carte.add(text2);
            carte.add(label11);
            carte.add(text4);
            carte.add(box);
            carte.add(box2);
            carte.add(text);
            carte.add(text3);
            carte.add(label9);
            carte.add(b);
            carte.add(b2);
            carte.add(buy);
            carte.add(panel);
            carte.add(panel2);
            
            carte.setVisible(true);
            
        }
        if(e.getSource() == register)
        {
            jframe.dispose();
            
            frame = new JFrame();
            frame.setSize(400, 400);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setResizable(false);
            frame.setTitle("Skin and Body Baths");
            frame.setLayout(null);
            frame.setIconImage(new ImageIcon("src\\images\\candle.PNG").getImage());
            
            
            regReturn = new JButton("Return");
            regReturn.setBounds(0, 0, 100, 15);
            regReturn.setForeground(Color.white);
            regReturn.setBackground(Color.red);
            regReturn.setFocusPainted(false);
            regReturn.addActionListener(this);
            
            JPanel panel = new JPanel();
            panel.setBounds(0, 0, 400, 50);
            panel.setBackground(Color.orange);
            
            JPanel panel2 = new JPanel();
            panel2.setBounds(0, 50, 400, 350);
            panel2.setLayout(null);
            panel2.setBackground(Color.darkGray);
            
            JLabel label = new JLabel();
            label.setText("Register");
            label.setBounds(0, 5, 200, 50);
            label.setForeground(Color.white);
            label.setFont(new Font("Arial", Font.BOLD,25));
            
            JLabel username = new JLabel();
            username.setText("Enter new username:");
            username.setBounds(5, 100, 200, 50);
            username.setForeground(Color.white);
            username.setFont(new Font("Arial",Font.BOLD,16));
            
            JLabel pass = new JLabel();
            pass.setText("Enter new password:");
            pass.setBounds(5, 150, 200, 50);
            pass.setForeground(Color.white);
            pass.setFont(new Font("Arial",Font.BOLD,16));
            
            
            text4.setBounds(170, 65, 200, 22);
            passw.setBounds(170, 115, 200, 22);

            panel2.add(text4);
            panel2.add(passw);
            
            reg = new JButton("Register");
            reg.setBounds(210, 210, 100, 50);
            reg.setForeground(Color.white);
            reg.setBackground(Color.orange);
            reg.setFocusPainted(false);
            reg.addActionListener(this);
            
            frame.add(regReturn);
            frame.add(reg);
            frame.add(label);
            frame.add(username);
            frame.add(pass);
            frame.add(panel);
            frame.add(panel2);
            frame.setVisible(true);
        }
        
        if(e.getSource() == forgot)
        {
            jframe.dispose();
            
            fram = new JFrame();
            fram.setSize(400,400);
            fram.setResizable(false);
            fram.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            fram.setLayout(null);
            fram.setTitle("Skin and Body Baths");
            fram.setIconImage(new ImageIcon("src\\images\\candle.PNG").getImage());
            
            ret = new JButton("Return");
            ret.setBounds(0, 0, 100, 15);
            ret.setForeground(Color.white);
            ret.setBackground(Color.red);
            ret.setFocusPainted(false);
            ret.addActionListener(this);
            
            JPanel panel = new JPanel();
            panel.setBounds(0, 50, 400, 400);
            panel.setBackground(Color.darkGray.darker());
            
            JPanel panel2 = new JPanel();
            panel2.setBounds(0, 0, 500, 50);
            panel2.setBackground(Color.orange);
            
            JLabel label = new JLabel();
            label.setText("Forgot Password");
            label.setBounds(0, -20, 400, 100);
            label.setFont(new Font("Arial",Font.BOLD,26));
            label.setForeground(Color.white);
            
            JTextArea text = new JTextArea();
            text.setBounds(10, 100, 200, 250);
            
            butt = new JButton("Send");
            butt.setBounds(240, 180, 100, 50);
            butt.setForeground(Color.white);
            butt.setBackground(Color.green);
            butt.addActionListener(this);
            
            JLabel lab = new JLabel();
            lab.setText("Send email and account name to tech support:");
            lab.setForeground(Color.white);
            lab.setBounds(0, 40, 400, 50);
            lab.setFont(new Font("Arial",Font.BOLD,16));
            
            JLabel lab2 = new JLabel();
            lab2.setText("Will send account password within 24 hours");
            lab2.setForeground(Color.white);
            lab2.setBounds(0, 60, 400, 50);
            lab2.setFont(new Font("Arial",Font.BOLD,16));
                    
            
            fram.add(label);
            fram.add(lab);
            fram.add(lab2);
            fram.add(butt);
            fram.add(text);
            fram.add(panel);
            fram.add(panel2);
            fram.add(ret);
            
            fram.setVisible(true);
            
            
        }
        if(e.getSource() == butt)
        {
            JOptionPane.showMessageDialog(null,"Message successfully sent!");
        }
        if(e.getSource() == regReturn)
        {
            frame.dispose();
            
            jframe.requestFocus();
            jframe.setVisible(true);
        }
        if(e.getSource() == ret)
        {
            fram.dispose();
            
            jframe.requestFocus();
            jframe.setVisible(true);
        }
        
        if(e.getSource() == ret2)
        {
            carte.dispose();
            
            shop.requestFocus();
            shop.setVisible(true);
        }
        
        if(e.getSource() == reg)
        {
            String username = text4.getText();
            String password = String.valueOf(passw.getPassword());
 
            if(username.equals("") || password.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Username or Password cannot be empty!");
            }
            if(username.length() >= 15 || password.length() >= 15)
            {
                JOptionPane.showMessageDialog(null, "Username or Password length cannot exceed 15 characters!");
            }
            
            try
            {
                Connection con = getConnection();
                PreparedStatement prep = con.prepareStatement("INSERT INTO tablename (username, password) VALUES ('"+username+"','"+password+"')");
                prep.executeUpdate();
                
                JOptionPane.showMessageDialog(null, "Account registered successfully!");
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
            
        }
        if(e.getSource() == buy)
        {
            JOptionPane.showMessageDialog(null,"Purchase successful!");
        }
        
    }
    
    
    public static void main(String[] args)
    {
        body = new BodyWorks();
        createTable();
    }
    
    public static Connection getConnection()
    {
        try
        {
            String driver = "com.mysql.cj.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3fagf/nosteal";
            String username = "root";
            String password = "nosteel";
            
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url, username, password);
            
            System.out.println("Connected");
            return con;
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
    
    public static void createTable()
    {
        try
        {
           Connection con = getConnection();
           PreparedStatement state = con.prepareStatement("CREATE TABLE IF NOT EXISTS tablename(id int NOT NULL AUTO_INCREMENT, username VARCHAR(15), password VARCHAR(15), PRIMARY KEY(id))");
           state.executeUpdate();
        }
     
       
        catch(Exception e)
        {
           e.printStackTrace();
        }
    }
   
}
