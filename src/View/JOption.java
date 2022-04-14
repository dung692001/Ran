package View;

import javax.swing.JOptionPane;

public class JOption {
	public static String x;
	public JOption() {
		x =	JOptionPane.showInputDialog(null, "Nhap ten nguoi choi", " ", JOptionPane.PLAIN_MESSAGE);
	}
}
