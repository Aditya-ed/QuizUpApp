package minip;
import java.io.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;
public class Teacher extends JFrame implements ActionListener{

	JButton next,back;
	JLabel name;
	JTextField box;
	Teacher()
	{
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel heading = new JLabel("RESULTS!");
		heading.setFont(new Font("Tahoma", Font.BOLD,38));
		heading.setForeground(Color.black);
		heading.setBounds(390, 40 ,300 ,45);
		add(heading);
		String str="";
		JTextArea ar=new JTextArea();
		File myfile=new File("Score.txt");
		try
		{
			Scanner sc=new Scanner(myfile);
			while(sc.hasNext())
			{
				str=sc.nextLine();
				ar.append(str);
				ar.append("\n");
			}
		}
		catch(FileNotFoundException e)
		{}
		ar.setFont(new Font("Comic Sans",Font.ITALIC | Font.BOLD,18));
		ar.setEditable(false);
		JScrollPane scp=new JScrollPane(ar,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scp.setBounds(340, 120, 300, 200);
		add(scp);
		
		back= new JButton("Exit");
		back.setBounds(423,350,120,25);
		back.setForeground(Color.BLACK);
		back.addActionListener(this);
		add(back);
		
		next= new JButton("Next");
		next.setBounds(503,400,120,25);
		next.setForeground(Color.BLACK);
		next.addActionListener(this);
		//add(next);
		
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
		if(ace.getSource() == back)
		{
			setVisible(false);
		}
		else if(ace.getSource() == next)
		{
			//String names= box.getText();
			setVisible(false);
			//new Student(names);
		}
	}
	public static void main(String args[])
	{
		
		new Teacher();
	}
}
