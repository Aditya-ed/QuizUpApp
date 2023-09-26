package minip;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;
public class Home extends JFrame implements ActionListener{

	JButton next,back;
	JLabel name;
	JTextField box;
	Home()
	{
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel heading = new JLabel("QUIZ Time!");
		heading.setBounds(490, 40 ,300 ,45);
		heading.setFont(new Font("Tahoma", Font.BOLD,38));
		heading.setForeground(new Color(255, 153, 194));
		add(heading);
		
		name = new JLabel("Enter Name");
		name.setBounds(530, 120 ,300 ,20);
		name.setFont(new Font("Tahoma", Font.BOLD,25));
		name.setForeground(new Color(255, 153, 194));
		add(name);
		
		box = new JTextField();
		box.setBounds(450,180,300,35);
		box.setFont(new Font("Tahoma",Font.BOLD,25));
		add(box);
		
		back= new JButton("Back");
		back.setBounds(470,240,120,25);
		back.setForeground(Color.BLACK);
		back.addActionListener(this);
		add(back);
		
		next= new JButton("Next");
		next.setBounds(610,240,120,25);
		next.setForeground(Color.BLACK);
		next.addActionListener(this);
		add(next);
		
		ImageIcon i2 = new ImageIcon(ClassLoader.getSystemResource("Icons/type 2.png"));
		JLabel i22= new JLabel(i2);
		Dimension size= i22.getPreferredSize();	
		i22.setBounds(200,140,size.width,size.height);
		//add(i22);
		
		ImageIcon i3 = new ImageIcon(ClassLoader.getSystemResource("Icons/teach2.png"));
		JLabel i33= new JLabel(i3);
		Dimension size1= i33.getPreferredSize();
		i33.setBounds(130,120,size1.width,size1.height);
		add(i33);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/5.png"));
		JLabel image= new JLabel(i1,JLabel.CENTER);
		image.setBounds(0,0,1000,500);
		add(image);

		addWindowListener(new WindowAdapter() {
		    public void windowClosing(WindowEvent e) {
		        dispose();
		    }
		});
		
		setSize(1000,500);
		setLocation(200,100);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ace)
	{
		if(ace.getSource() == back)
		{
			setVisible(false);
			new Choose();
		}
		else if(ace.getSource() == next)
		{
			String names= box.getText();
			setVisible(false);
			new Student(names);
		}
	}
	public static void main(String args[])
	{
		
		new Home();
	}
}
