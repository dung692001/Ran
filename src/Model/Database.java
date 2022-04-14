package Model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Database {
	public List<Player> ghiDiemRaGame() throws ClassNotFoundException, SQLException {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<Player> list_player = new ArrayList<>();
		try {
			Class.forName(ThongSo.DB_DRIVER);
			conn = DriverManager.getConnection(ThongSo.URL, ThongSo.USER, ThongSo.PASS);
			stmt = conn.createStatement();
			stmt.executeQuery("SELECT * From snake ORDER BY Point DESC LIMIT "+ThongSo.TOP);
			rs = stmt.getResultSet();
			while(rs.next()) {
				String name = rs.getString("name");
				int point = rs.getInt("point");
				list_player.add(new Player(name,point));
			}
		}catch(SQLException e) {
			throw e;
		}finally {
			if(stmt != null)
				stmt.close();
			if(conn!= null)
				conn.close();
			if(rs != null)
				rs.close();
		}
		return list_player;
		
	}
	public static void  luuDiemVaoDB(String ten, int diem) throws SQLException, ClassNotFoundException {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName(ThongSo.DB_DRIVER);
			conn = DriverManager.getConnection(ThongSo.URL, ThongSo.USER, ThongSo.PASS);
			stmt = conn.createStatement(); //Tao truy van
			stmt.executeQuery("SELECT * FROM `snake` WHERE Name = '"+ten+"'");
			rs = stmt.getResultSet();
			
			int checkdiem = -1;
			while(rs.next()) {
				checkdiem = rs.getInt("point");
			}
			if(checkdiem == -1 ) {	
				stmt.executeUpdate("INSERT INTO `snake`(`Name`, `Point`) VALUES ('"+ten+"','"+diem+"')");
			}
			else {	
				if(checkdiem < diem ) {
					stmt.executeUpdate("UPDATE `snake` SET `Point`='"+diem+"' Where Name = '"+ten+"'");
				}
			}
		}catch(SQLException e) {
			throw e;
		}finally {
			if(stmt != null)
				stmt.close();
			if(conn!= null)
				conn.close();
			if(rs != null)
				rs.close();
		}
	}
	public static void inputData() throws ClassNotFoundException, SQLException, IOException {
		
		Database data = new Database();
		
		List<Player> list = new ArrayList<Player>();
		list = data.ghiDiemRaGame();
		
		BufferedWriter bw = null;
		try {
			FileWriter fw = new FileWriter("src\\src\\data\\dulieu.txt");
			bw = new BufferedWriter(fw);
			
			for (Player l:list) {
				bw.write(l.getName()+ " " +l.getPoint());
				bw.newLine();
			}
			
		}catch(IOException ex) {}
		finally {
			try {
				bw.close();
			} catch (IOException e) {}
		}
	}		
}
