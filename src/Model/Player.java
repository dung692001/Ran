package Model;

public class Player {
	private String Name;
	private int Point;
	private static String ten_tmp;
	public static String getTen_tmp() {
		return ten_tmp;
	}
	public static void setTen_tmp(String ten_tmp) {
		Player.ten_tmp = ten_tmp;
	}
	public Player() {
		
	}
	public void setName(String name) {
		Name = name;
	}

	public void setPoint(int point) {
		Point = point;
	}

	public Player(String name, int point) {
		Name = name;
		Point = point;
	}

	public String getName() {
		return Name;
	}


	@Override
	public String toString() {
		return "Name = " + getName() + "  Point = " + getPoint() ;
	}
	public int getPoint() {
		return Point;
	}

	
	
}
