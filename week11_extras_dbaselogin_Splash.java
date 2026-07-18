package dbaselogin;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;

public class Splash extends JFrame {

    private final int screenHeight;
    private final int screenWidth;
    JButton btnPanel1;
    JButton btnPanel2;
    JButton btnPanel3;
    JLabel  lblPanelName;
    public Splash(Connection con) {

        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension screenSize = tk.getScreenSize();
         screenHeight = screenSize.height;
         screenWidth = screenSize.width;

      addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                //System.exit(0);
            }
        });
      // / 2
        setSize(screenWidth/2 , screenHeight/2);
        setLocation(screenWidth / 4, screenHeight / 4);
        setUndecorated(true);
        setVisible(true);

        //Graphics2D g = (Graphics2D) getGraphics();



       Dbcon.getDbcon().createDB(con,this);
/*        for(int i=0; i<100; i++) {
            renderSplashFrame(g, i);
            try {
                Thread.sleep(80);
            }
            catch(InterruptedException e) {
            }
        }*/

        this.dispose();

    }

    public  void renderSplashFrame(Graphics2D g, int frame) {
        final String[] comps = {"1", "2", "3"};

         final BufferedImage image;
         try {
             image = ImageIO.read(new File(".\\images\\splash_bg.jpg"));
             //g2.drawImage(image, 0, 0, this);
             g.drawImage(image, 0, 0, screenWidth/2 , screenHeight/2, 0, 0, image.getWidth(), image.getHeight(), this);


         } catch (IOException e) {
             e.printStackTrace();
         }


        //g.setComposite(AlphaComposite.Clear);
        //g.fillRect(120,140,200,40);
        //g.setPaintMode();
        //g.setColor(Color.BLACK);
        //g.drawString("Loading "+comps[(frame/5)%3]+"...", (screenWidth/2)-380,(screenHeight/2)-100);
        g.setColor(Color.BLACK);
        g.setFont(new Font("TimesRoman", Font. BOLD, 17));
        g.drawString("Pathobix Loading "+frame+"...", (screenWidth/2)-420,(screenHeight/2)-190);
        g.setColor(Color.WHITE);

        g.drawString("Visit us @ www.algobix.com   Email : algobixx@gmail.com Helpline No : 9407786486", (screenWidth/2)-660,(screenHeight/2)-10);


    }
   /* public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        final BufferedImage image;
        try {
            image = ImageIO.read(new File(".\\images\\splash_bg.jpg"));
            //g2.drawImage(image, 0, 0, this);
            g2.drawImage(image, 0, 0, screenWidth/2 , screenHeight/2, 0, 0, image.getWidth(), image.getHeight(), this);


        } catch (IOException e) {
            e.printStackTrace();
        }
       // g2.drawString("Algobix", 50, 200);

        g2.finalize();
    }*/

}