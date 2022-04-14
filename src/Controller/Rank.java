package Controller;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;

import Model.Database;
import Model.Player;
import Model.ThongSo;

public class Rank extends JFrame {
	private int WIDTH = 620;
    private int HEIGHT = 635;
    //private BangXepHang BXH = new BangXepHang();
	Rank() throws ClassNotFoundException, SQLException{
		ThongSo a = new ThongSo();
		a.docTuFile();
		Database data = new Database();
		List<Player> list = new ArrayList<Player>();
		list = data.ghiDiemRaGame();
		
		
		
		JLabel label[] = new JLabel[100];
		JLabel lbt = new JLabel();
		JLabel lbn = new JLabel();
		JLabel lbp = new JLabel();
		lbt.setText("Top");
		lbt.setBounds(40, 30 , 50, 50);
		lbt.setForeground(new Color(0x00FF00));
		
		lbn.setText("Name");
		lbn.setBounds(240, 30 , 50, 50);
		lbn.setForeground(new Color(0x00FF00));
		
		lbp.setText("Point");
		lbp.setBounds(450, 30, 50, 50);
		lbp.setForeground(new Color(0x00FF00));
		
		String kc = " ";
		for(int f=1;f<58;f++)
			kc = kc+" ";
		int i = 0;
		int j=40;
		
		for(Player a1:list) {
			label[i] = new JLabel();
			label[i].setText(i+1 + kc + a1.getName()+ kc + a1.getPoint());
			label[i].setForeground(new Color(0x00FF00));
			
			label[i].setBounds(40, j, 500, 150);
			i=i+1;
			j=j+40;
			
		}	
		
		this.setTitle("Top 10");	
		this.setSize(this.WIDTH, this.HEIGHT);
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	 
		this.setLayout(null);
		this.setVisible(true);
		this.setResizable(false);
		this.getContentPane().setBackground(Color.black);
		this.setLocationRelativeTo(null);
		this.add(lbt);
		this.add(lbn);
		this.add(lbp);
		for(int k=0;k<i;k++) {
			this.add(label[k]);
		}
	}
	
	
}
