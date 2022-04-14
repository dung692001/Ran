package Controller;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import Model.Player;
import Model.ThongSo;
import Model.Database;
import View.JOption;

public class SnakeGame extends JFrame implements ActionListener{
	private int WIDTH = 600;
    private int HEIGHT = 600;
	public static String Name;
	Button button1,button2;
	public SnakeGame() throws ClassNotFoundException, SQLException, IOException{
		ImageIcon img = new ImageIcon("Rann.png");
		
		button1 = new Button();
		button1.setBounds(250, 390, 100, 50);
		button1.setLabel("Start Game");
		button1.addActionListener(this);
		button1.setFocusable(false);
		
		button2 = new Button();
		button2.setBounds(250, 500, 100, 50);
		button2.addActionListener(this);
		button2.setFocusable(false);
		button2.setLabel("High score");
		
		JLabel label = new JLabel();
		label.setIcon(img);
		label.add(button1);
		label.add(button2);
		
		this.add(label);
		this.setTitle("Snake");
		this.setSize(this.HEIGHT, this.WIDTH);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.pack();
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		
	
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == button1){
			new JOption();
			Player player = new Player();
			player.setTen_tmp(JOption.x);
		 	new GameFrame();
			this.dispose();
		}
		
		if(e.getSource() == button2) {
			ThongSo a = new ThongSo();
			a.docTuFile();
			Database data = new Database();			
			try {
				data.inputData();
			} catch (ClassNotFoundException | SQLException | IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}		
			try {
				new Rank();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			//this.dispose();		
		}
		
	}
}
	
	

