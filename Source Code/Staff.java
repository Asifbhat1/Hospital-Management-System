import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Staff extends JFrame implements ActionListener
{
	String username="system";
	String password="system";
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10;
	JTextField ltf1,ltf2,ltf3,ltf4,ltf5,ltf6,ltf7,ltf8,ltf9,ltf10;
	JButton submit,clear,update,delete;
	Connection con;
	PreparedStatement stm;
	Statement stm2;
	ResultSet rs2;
	String up;
	int i;
	
	public Staff()
	{
		super(" Staff Information");
		setIconImage(new ImageIcon("image/logo.png").getImage());
		setSize(850,650);
		setLayout(null);
		setLocation(200,70);
		JPanel p=new JPanel();
		p.setLayout(null);
		p.setBounds(0,0,850,650);
		add(p);
		JLabel h1= new JLabel(" Staff Information");
		Font font=new Font("Britannic",Font.PLAIN,25);
		h1.setFont(font);
		h1.setBounds(300,20,300,40);
		p.add(h1);
		
		//Details
		l1= new JLabel("ID :");
		l1.setBounds(200,100,200,20);
		ltf1= new JTextField();
		ltf1.setBounds(340,100,150,20);
		p.add(l1);
		p.add(ltf1);

		l2= new JLabel("Name :");
		l2.setBounds(200,140,200,20);
		ltf2= new JTextField();
		ltf2.setBounds(340,140,150,20);
		p.add(l2);
		p.add(ltf2);

		l3= new JLabel("Gender :");
		l3.setBounds(200,180,200,20);
		ltf3= new JTextField();
		ltf3.setBounds(340,180,150,20);
		p.add(l3);
		p.add(ltf3);


		l4= new JLabel("Position :");
		l4.setBounds(200,220,200,20);
		ltf4= new JTextField();
		ltf4.setBounds(340,220,150,20);
		p.add(l4);
		p.add(ltf4);
		
		l5= new JLabel("Salary :");
		l5.setBounds(200,260,200,20);
		ltf5= new JTextField();
		ltf5.setBounds(340,260,150,20);
		p.add(l5);
		p.add(ltf5);
		
		l6= new JLabel("Phone :");
		l6.setBounds(200,300,200,20);
		ltf6= new JTextField();
		ltf6.setBounds(340,300,150,20);
		p.add(l6);
		p.add(ltf6);

		l7= new JLabel("Address :");
		l7.setBounds(200,340,200,20);
		ltf7= new JTextField();
		ltf7.setBounds(340,340,150,20);
		p.add(l7);
		p.add(ltf7);

		l8= new JLabel("Qualification :");
		l8.setBounds(200,380,200,20);
		ltf8= new JTextField();
		ltf8.setBounds(340,380,150,20);
		p.add(ltf8);
		p.add(l8);

		l9= new JLabel("D.O.B :");
		l9.setBounds(200,420,200,20);
		ltf9= new JTextField();
		ltf9.setBounds(340,420,150,20);
		p.add(ltf9);
		p.add(l9);
		
		l10= new JLabel("ID Proof :");
		l10.setBounds(200,460,200,20);
		ltf10= new JTextField();
		ltf10.setBounds(340,460,150,20);
		p.add(ltf10);
		p.add(l10);
		
	
		update = new JButton("Search",new ImageIcon("image/Search.png"));
		update.addActionListener(this);
		update.setBounds(270,500,130,30);
		p.add(update);		


		clear = new JButton("Clear",new ImageIcon("image/reset.png"));
		clear.setBounds(440,500,130,30);
		p.add(clear);
		clear.addActionListener( new ActionListener() {   
			public void actionPerformed(ActionEvent e)
				{ 	ltf1.setText("");	
				 	ltf2.setText("");
					ltf3.setText("");
					ltf4.setText("");
					ltf5.setText("");
					ltf6.setText("");
					ltf7.setText("");
					ltf8.setText("");
					ltf9.setText("");
					ltf10.setText("");
					}
		});  
				
		
		
		
		
		JLabel im=new JLabel(new ImageIcon("image/m1.jpg"));
		im.setBounds(0,0,850,550);
		p.add(im);
		add(p);
		addWindowListener(new WindowAdapter() {
		public void windowClosing(WindowEvent e){ new MainForm();  dispose(); }});
		setVisible(true);
	}


	
	public void actionPerformed(ActionEvent ea)
	{



			if(ea.getSource()==update)
				{   	
			 		up=JOptionPane.showInputDialog("Enter ID "); 
				        
					if(!up.isEmpty())
					{
				         try{	
					
					Class.forName("oracle.jdbc.driver.OracleDriver");
					con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",username,password);
					stm2=con.createStatement();
					rs2= stm2.executeQuery("SELECT  *  FROM staff WHERE id="+up+" ");
						
				while(rs2.next())
					{
						
					ltf1.setText(rs2.getString(1));
					ltf2.setText(rs2.getString(2));
					ltf3.setText(rs2.getString(3));
					ltf4.setText(rs2.getString(4));
					ltf5.setText(rs2.getString(5));
					ltf6.setText(rs2.getString(6));
					ltf7.setText(rs2.getString(7));
					ltf8.setText(rs2.getString(8));
					ltf9.setText(rs2.getString(9));
					ltf10.setText(rs2.getString(10));
					}	i=1;	
					}
				catch(Exception p){JOptionPane.showMessageDialog(this,p,"Success",JOptionPane.INFORMATION_MESSAGE);}
					}
					else{}   
			     }

			
				


	}




/*public static void main(String []args)
	{  new Staff();  }*/
}