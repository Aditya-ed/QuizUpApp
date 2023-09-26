package minip;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;
public class Finish extends JFrame implements ActionListener{

	JButton Try,Exit;
	JLabel name;
	JTextField box;
	Finish()
	{
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel heading = new JLabel("Thanks for Attempting the Quiz");
		heading.setBounds(250, 80 ,500,50);
		heading.setFont(new Font("Tahoma",Font.BOLD,30));
		heading.setForeground(new Color(18,18,18));
		add(heading);
		
		Try=new JButton("Teacher");
		Try.setForeground(Color.BLACK);
		Try.setBounds(375, 300 ,100 ,25);
		Try.addActionListener(this);
		add(Try);
		
		Exit=new JButton("Exit");
		Exit.setForeground(Color.black);
		Exit.setBounds(499,300,100,25);
		Exit.addActionListener(this);
		add(Exit);
		ImageIcon i2 = new ImageIcon(ClassLoader.getSystemResource("Icons/thumbsup - Copy.png"));
		JLabel i22= new JLabel(i2);
		Dimension size= i22.getPreferredSize();
		i22.setBounds(400,140,size.width,size.height);
		add(i22);
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/8.png"));
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
		if(ace.getSource()==Try)
		{
			new Login();
			setVisible(false);
		}
		else if(ace.getSource()==Exit)
		{
			System.exit(0);
		}
	}
	public static void main(String args[])
	{
		
		new Finish();
	}
}
