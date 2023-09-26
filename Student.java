package minip;

import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
public class Student extends JFrame implements ActionListener{
	JButton back,next,finish;
	JLabel qno,q;
	JLabel image2;
	JRadioButton opt1,opt2,opt3,opt4;
	String questions[][]=new String[10][5];
	String ans[][]=new String[10][2];
	String uans[][]=new String[10][1];
	public static int count=0;
	public static int timer=15;
	public static int anss = 0;
	public static int score = 0;
	ButtonGroup groupop;
	String name;
	Student(String name){
		this.name=name;
		back = new JButton("Back");
		back.setBounds(420,425,125,25);
		back.addActionListener(this);
		//add(back);
		
		qno=new JLabel();
		qno.setBounds(100,50,50,30);
		qno.setFont(new Font("Tahoma",Font.PLAIN,18));
		add(qno);
		
		q=new JLabel();
		q.setBounds(130,50,900,30);
		q.setFont(new Font("Tahoma",Font.PLAIN,18));
		add(q);
		
		questions[0][0] = "Identify the correct extension of the user-defined header file in C++.";
        questions[0][1] = ".cpp";
        questions[0][2] = ".hg";
        questions[0][3] = ".h";
        questions[0][4] = ".hf";

        questions[1][0] = "Identify the incorrect constructor type";
        questions[1][1] = "Friend Constructor";
        questions[1][2] = "Default Constructor";
        questions[1][3] = "Parameterized Constructor";
        questions[1][4] = "Copy Constructor";

        questions[2][0] = "C++ uses which approach?";
        questions[2][1] = "right-left";
        questions[2][2] = "top-down";
        questions[2][3] = "left-right";
        questions[2][4] = "bottom-up";

        questions[3][0] = "Which of the following data type is supported in C++ but not in C";
        questions[3][1] = "int";
        questions[3][2] = "bool";
        questions[3][3] = "double";
        questions[3][4] = "float";

        questions[4][0] = "Identity the correct syntax for declaring arrays in C++";
        questions[4][1] = "array arr[10]";
        questions[4][2] = "array{10}";
        questions[4][3] = "int arr[10]";
        questions[4][4] = "int arr";

        questions[5][0] = "Which of the following is 'address of operator'?";
        questions[5][1] = "*";
        questions[5][2] = "&";
        questions[5][3] = "[]";
        questions[5][4] = "&&";

        questions[6][0] = "Identify the correct example for a pre-increment operator";
        questions[6][1] = "++n";
        questions[6][2] = "n++";
        questions[6][3] = "--n";
        questions[6][4] = "+n";

        questions[7][0] = "Which of the following loops is best when we know the number of iterations";
        questions[7][1] = "while loop";
        questions[7][2] = "do while";
        questions[7][3] = "for loop";
        questions[7][4] = "all of the above";

        questions[8][0] = "Identify the scope resolution operator";
        questions[8][1] = ":";
        questions[8][2] = "::";
        questions[8][3] = "?";
        questions[8][4] = "None";

        questions[9][0] = "  goto can be classified into?";
        questions[9][1] = "label";
        questions[9][2] = "variable";
        questions[9][3] = "operator";
        questions[9][4] = "function";
        
        ans[0][1] = ".h";
        ans[1][1] = "Friend Constructor";
        ans[2][1] = "bottom-up";
        ans[3][1] = "bool";
        ans[4][1] = "int arr[10]";
        ans[5][1] = "&";
        ans[6][1] = "++n";
        ans[7][1] = "for loop";
        ans[8][1] = "::";
        ans[9][1] = "label";
        opt1 = new JRadioButton();
        opt1.setBounds(130,100,350,30);
        
        opt1.setOpaque(false);
        add(opt1);
        
        opt2 = new JRadioButton();
        opt2.setBounds(130,130,350,30);
        opt2.setOpaque(false);
        add(opt2);

        opt3 = new JRadioButton();
        opt3.setBounds(130,160,350,30);
        opt3.setOpaque(false);
        add(opt3);

        opt4 = new JRadioButton();
        opt4.setBounds(130,190,350,30);
        opt4.setOpaque(false);
        add(opt4);
        
       groupop = new ButtonGroup();
        groupop.add(opt4);
        groupop.add(opt3);
        groupop.add(opt2);
        groupop.add(opt1);
		
		next = new JButton("Next");
		next.setBounds(340,300,125,25);
		next.addActionListener(this);
		add(next);
		
		finish = new JButton("Finish");
		finish.setBounds(500,300,125,25);
		finish.addActionListener(this);
		finish.setEnabled(false);
		add(finish);
		
		start(count);
		
		ImageIcon i2 = new ImageIcon(ClassLoader.getSystemResource("Icons/Dexter2.png"));
		image2=new JLabel(i2);
		Dimension size=image2.getPreferredSize();
		image2.setBounds(750,80,size.width,size.height);
		add(image2);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/7.png"));
		JLabel image= new JLabel(i1,JLabel.CENTER);
		image.setBounds(0,0,1000,500);
		image.setOpaque(true);
		add(image);
		getContentPane().setBackground(Color.white);
		setLayout(null);
		setSize(1000,500);
		setLocation(200,100);
		setVisible(true);
		
		addWindowListener(new WindowAdapter() {
		    public void windowClosing(WindowEvent e) {
		        dispose();
		    }
		});
		
		
	}
	public void paint(Graphics g)
	{
		super.paint(g);
		String time = "Time Left:  "+ timer + " seconds";
		g.setColor(Color.black);
		g.setFont(new Font("Plain",Font.BOLD,18));
		
		if(timer > 0)
		{
			g.drawString(time,385,400);
		}
		else 
		{
			g.drawString("Times Up!!",440,400);
		}
		timer--;
		
		try {
			Thread.sleep(1000);
			repaint();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		if(anss==1)
		{
			anss=0;
			timer=15;
		}
		else if(timer<0)
		{
			timer = 15;
			
			if(count == 8 )
			{
				next.setEnabled(false);
				finish.setEnabled(true);
			}
			if(count == 9)
			{
				if(groupop.getSelection()==null)
				{
					uans[count][0]="";
				}
				else
				{
					uans[count][0]=groupop.getSelection().getActionCommand();
				}
				
				for(int i=0;i<uans.length;i++)
				{
					if(uans[i][0].equals(ans[i][1]))
					{
						score+=10;
					}
				}
				setVisible(false);
				//new Score(name,score);
			}
			if(count==9)
			{
				count=0;
			}
			else
			{
				if(groupop.getSelection()==null)
				{
					uans[count][0]="";
				}
				else
				{
					uans[count][0]=groupop.getSelection().getActionCommand();
				}
				count++;
				start(count);
			}
			
		}
	}
	public void start(int count)
	{
		qno.setText("Q" +(count + 1)+". ");
		q.setText(questions[count][0]);
		opt1.setText(questions[count][1]);
		opt1.setActionCommand(questions[count][1]);
		opt2.setText(questions[count][2]);
		opt2.setActionCommand(questions[count][2]);
		opt3.setText(questions[count][3]);
		opt3.setActionCommand(questions[count][3]);
		opt4.setText(questions[count][4]);
		opt4.setActionCommand(questions[count][4]);
		
		groupop.clearSelection();
	}
	public void actionPerformed(ActionEvent ace)
	{
		if(ace.getSource()==back)
		{
			setVisible(false);
			new Home();
		}
		if(ace.getSource()==next)
		{
			repaint();
			
			anss = 1;
			if(groupop.getSelection()==null)
			{
				uans[count][0]="";
			}
			else
			{
				uans[count][0]=groupop.getSelection().getActionCommand();
			}
			if(count == 8 )
			{
				next.setEnabled(false);
				finish.setEnabled(true);
				//count=0;
			}
			if(count == 9)
			{
				count=0;
				//finish.setEnabled(false);
				//next.setEnabled(true);
			}
			count++;
			start(count);
		}
		else if(ace.getSource()==finish)
		{
			anss=1;
			if(groupop.getSelection()==null)
			{
				uans[count][0]="";
			}
			else
			{
				uans[count][0]=groupop.getSelection().getActionCommand();
			}
			
			for(int i=0;i<uans.length;i++)
			{
				if(uans[i][0].equals(ans[i][1]))
				{
					score+=10;
				}
			}
			String scor=Integer.toString(score);
			setVisible(false);
			File myfile=new File("Score.txt");
			if(!myfile.exists())
			{
			try{myfile.createNewFile();}
			catch(IOException e){}
			}
			try{
			FileWriter file=new FileWriter("Score.txt",true);
			file.write(name);
			file.write("\t");
			file.write(scor);
			file.write("\n");
			file.close();}
			catch(IOException e){}
			//new Score(name,score);
			new Finish();
		}
	}
	public static void main(String args[])
	{
		new Student("User");
	}
}
