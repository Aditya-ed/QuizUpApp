package minip;
import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener{
	String name;
	JButton back,next,Continue;
	JTextField username;
	JPasswordField pass;
	JLabel info,text;
	int flag=0;
	Login()
	{
		addWindowListener(new WindowAdapter() {
		    public void windowClosing(WindowEvent e) {
		        dispose();
		    }
		});
		
		getContentPane().setBackground(Color.CYAN);
		setLayout(null);
		
		JLabel heading = new JLabel("Login to Check the Score ");
		heading.setBounds(327,30,700,40);
		heading.setFont(new Font("Tahoma",Font.BOLD,28));
		heading.setForeground(Color.black)	;
		add(heading);
		
		back= new JButton("Back");
		back.setBounds(300,260,120,25);
		back.setForeground(Color.BLACK);
		back.addActionListener(this);
		add(back);
		
		next= new JButton("Next");
		next.setBounds(550,260,120,25);
		next.setForeground(Color.BLACK);
		next.addActionListener(this);
		add(next);
		
		Continue = new JButton("Continue");
		Continue.setBounds(425,350,120,25);
		Continue.setForeground(Color.BLACK);
		Continue.addActionListener(this);
		
		
		info=new JLabel("Enter UserID");
		info.setBounds(425,80,120,25);
		info.setFont(new Font("Tahoma",Font.BOLD,18));
		add(info);
		
		username=new JTextField();
		username.setBounds(365,120,250,25);
		add(username);
		
		info=new JLabel("Enter Password");
		info.setBounds(410,160,150,25);
		info.setFont(new Font("Tahoma",Font.BOLD,18));
		add(info);
		
		text = new JLabel();
		text.setBounds(415,300,250,35);
		text.setFont(new Font("Tahoma",Font.BOLD,15));
		add(text);
		
		pass=new JPasswordField();
		pass.setBounds(365,200,250,25);
		add(pass);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/6.png"));
		JLabel image= new JLabel(i1,JLabel.CENTER);
		image.setBounds(0,0,1000,500);
		image.setOpaque(true);
		add(image);
		setSize(1000,500);
		setLocation(200,100);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ace)
	{
		if(ace.getSource()==next)
		{
			String password=String.valueOf(pass.getPassword());
			if(username.getText().equals("Teacher@123") && password.equals("123"))
			{
				text.setText("Login Successful!");
				add(Continue);
				flag=1;
				//setVisible(false);
				
			}
			else if(username.getText().equals("Student@123") && password.equals("123"))
			{
				text.setText("Login Successful!");
				add(Continue);
			}
			else
			text.setText("Login Un-Successful!");
		}
		else if(ace.getSource()==back)
		{
			new Choose();
			setVisible(false);
		}
		else if(ace.getSource()== Continue)
		{
			if(flag==1)
			{
				setVisible(false);
				new Teacher();
				//setVisible(false);
			}
			else
			{
				setVisible(false);
				//new Teacher();
			}
		}
	}
	public static void main(String args[])
	{
		
		new Login();
	}

}

