package minip;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;
public class Choose extends JFrame implements ActionListener{

	JButton T,S,Exit;
	JLabel name;
	JTextField box;
	Choose()
	{
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel heading = new JLabel("QUIZ Time!");
		heading.setBounds(377, 40 ,300 ,45);
		heading.setFont(new Font("Tahoma", Font.BOLD,34));
		heading.setForeground(new Color(18, 18, 18));
		add(heading);
		
		JLabel heading2 = new JLabel("Choose an option");
		heading2.setBounds(330, 100 ,400 ,45);
		heading2.setFont(new Font("Tahoma",Font.BOLD,34));
		heading2.setForeground(new Color(18, 18, 18));
		add(heading2);
		
		T=new JButton("Teacher");
		T.setForeground(Color.BLACK);
		T.setBounds(320, 180 ,110 ,75);
		T.addActionListener(this);
		T.setOpaque(false);
		T.setContentAreaFilled(false);
		T.setBorderPainted(false);
		add(T);
		
		S=new JButton("Student");
		S.setForeground(Color.black);
		S.setBounds(520,180,110,75);
		S.addActionListener(this);
		S.setOpaque(false);
		S.setContentAreaFilled(false);
		S.setBorderPainted(false);
		add(S);
		
		Exit=new JButton("Exit");
		Exit.setForeground(Color.BLACK);
		Exit.setBounds(440,380,75,25);
		Exit.addActionListener(this);
		add(Exit);
		
		ImageIcon i2 = new ImageIcon(ClassLoader.getSystemResource("Icons/pngwing.com - Copy (2).png"));
		JLabel i22= new JLabel(i2);
		Dimension size= i22.getPreferredSize();
		i22.setBounds(300,160,size.width,size.height);
		add(i22);
		
		ImageIcon i3 = new ImageIcon(ClassLoader.getSystemResource("Icons/pngwing.com2.png"));
		JLabel i33= new JLabel(i3);
		Dimension size1= i33.getPreferredSize();
		i33.setBounds(500,160,size1.width,size1.height);
		add(i33);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/5.png"));
		JLabel image= new JLabel(i1,JLabel.CENTER);
		image.setBounds(0,0,1000,500);
		add(image);
		
		setSize(1000,500);
		setLocation(200,100);
		setVisible(true);

		addWindowListener(new WindowAdapter() {
		    public void windowClosing(WindowEvent e) {
		        dispose();
		    }
		});
		
	}
	public void actionPerformed(ActionEvent ace)
	{
		if(ace.getSource() == T)
		{
			new Login();
			setVisible(false);
		}
		else if(ace.getSource() == S)
		{
			new Home();
			setVisible(false);
		}
		else if(ace.getSource() == Exit)
		{
			System.exit(0);
		}
	}
	public static void main(String args[])
	{
		
		new Choose();
	}
}
