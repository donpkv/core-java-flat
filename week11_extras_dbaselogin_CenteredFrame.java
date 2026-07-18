package dbaselogin;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.*;
import java.awt.event.WindowEvent;
import java.awt.*;
import javax.swing.*;

public class CenteredFrame extends JFrame implements ActionListener{

   JButton btnPanel1; 
   JButton btnPanel2;
   JButton btnPanel3;	  
   JLabel  lblPanelName;
  public CenteredFrame() {
    setTitle("CenteredFrame");
        
	btnPanel1 =new JButton("Eclipse");
	btnPanel2 =new JButton("NetBeans");
	btnPanel3 =new JButton("FileZilla");
	lblPanelName =new JLabel("Controller");

        this.setLayout(null);

	btnPanel1.addActionListener(this); 
	btnPanel2.addActionListener(this);
	btnPanel3.addActionListener(this);

        this.add(btnPanel1).setBounds(50,50,80,30);

	this.add(btnPanel2).setBounds(150,50,80,30);

	this.add(btnPanel3).setBounds(50,100,80,30);

	this.add(lblPanelName).setBounds(50,30,150,30);


 
addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });
    Toolkit tk = Toolkit.getDefaultToolkit();
    Dimension screenSize = tk.getScreenSize();
    int screenHeight = screenSize.height;
    int screenWidth = screenSize.width;
    setSize(screenWidth / 2, screenHeight / 2);
    setLocation(screenWidth / 4, screenHeight / 4);
    setUndecorated(true); 	  
}
  public void actionPerformed(ActionEvent ge)
		{
				
                     if(ge.getSource()==btnPanel1 )
				{

				   Runtime rtime= Runtime.getRuntime();
				       		try
						{
					rtime.exec("D:\\android\\adt-bundle-windows-x86-20140702\\eclipse\\eclipse.exe");
						}
						catch(Exception e)
							{
							System.out.println("Error "+e);

							}

					}

		if(ge.getSource()==btnPanel2 )
				{

				   Runtime rtime= Runtime.getRuntime();
				       		try
						{
					rtime.exec("C:\\Program Files\\NetBeans\\bin\\netbeans.exe");
						}
						catch(Exception e)
							{
							System.out.println("Error "+e);

							}

					}

		if(ge.getSource()==btnPanel3 )
				{

				   Runtime rtime= Runtime.getRuntime();
				       		try
						{
					rtime.exec("C:\\Program Files\\FileZilla FTP Client\\filezilla.exe");
						}
						catch(Exception e)
							{
							System.out.println("Error "+e);

							}

					}	

		}
 
public void paint(Graphics g) {
    Graphics2D g2 = (Graphics2D) g;

    Image img1 = Toolkit.getDefaultToolkit().getImage("D:\\Abhishek_Vaishnav\\AndroidStudio\\files\\andro2.jpg");
    g2.drawImage(img1, 10, 10, this);
    
    //g.drawString("Controller", 50, 200);

    g2.finalize();
  }


  public static void main(String[] args) {
    JFrame frame = new CenteredFrame();
    frame.show();
  }
}