package dbaselogin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;

public class LoginScreen extends JFrame implements ActionListener{
	private final JTextField txtUserName;
	private final JPasswordField txtPassword;

	JLabel  lblUserName;
	JLabel lblPassword;
    JButton btnLogin;
   JLabel  lblPanelName;
  public LoginScreen() {
    setTitle("CenteredFrame");

	  lblUserName =new JLabel("UserName");
	  lblPassword =new JLabel("Password");
	  txtUserName = new JTextField();
	  txtPassword = new JPasswordField();

	  btnLogin =new JButton("Login");
	  lblPanelName =new JLabel("LOGIN SCREEN");

        this.setLayout(null);

	btnLogin.addActionListener(this);

	  this.add(lblPanelName).setBounds(50,30,150,30);

	this.add(lblUserName).setBounds(50,50,80,30);

	this.add(lblPassword).setBounds(50,70,80,30);

	  this.add(txtUserName).setBounds(150,50,80,30);

	  this.add(txtPassword).setBounds(150,70,80,30);

	  this.add(btnLogin).setBounds(100,100,80,30);

	  txtPassword.addActionListener(this);
	  btnLogin.addActionListener(this);


 
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
				

		if(ge.getSource()==txtPassword)
				{
					String userName =txtUserName.getText();
					char[] password =txtPassword.getPassword();


					if(userName.length()>0 && password.length>0)
					{

						String pswd = password.toString();

						Connection connection = Dbcon.getCon(userName,pswd);

						if(connection!=null) {
							JOptionPane.showMessageDialog(null, "Success!!");
						}
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Feilds are empty!!");

					}


				}

		if(ge.getSource()== btnLogin)
				{

					String userName =txtUserName.getText();
					char[] password =txtPassword.getPassword();


					if(userName.length()>0 && password.length>0)
					{

						String pswd = password.toString();

						Connection connection = Dbcon.getCon(userName,pswd);

						if(connection!=null) {
							JOptionPane.showMessageDialog(null, "Success!!");
						}


					}
					else
					{
						JOptionPane.showMessageDialog(null, "Feilds are empty!!");

					}
				/*   Runtime rtime= Runtime.getRuntime();
				       		try
						{
					rtime.exec("C:\\Program Files\\FileZilla FTP Client\\filezilla.exe");
						}
						catch(Exception e)
							{
							System.out.println("Error "+e);

							}
*/
					}	

		}
 
/*
public void paint(Graphics g) {
    Graphics2D g2 = (Graphics2D) g;

   */
/* Image img1 = Toolkit.getDefaultToolkit().getImage("D:\\Abhishek_Vaishnav\\AndroidStudio\\files\\andro2.jpg");
    g2.drawImage(img1, 10, 10, this);
   *//*

    g.drawString("Controller", 50, 200);

    g2.finalize();
  }
*/


  public static void main(String[] args) {
    JFrame frame = new LoginScreen();
    frame.show();
  }
}