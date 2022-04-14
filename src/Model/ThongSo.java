package Model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Properties;

public class ThongSo {
	public static String DB_DRIVER;
	public static String URL;
	public static String USER;
	public static String PASS;
	public static int TOP;
	
	public void docTuFile() {
		Properties prop = new Properties();
        FileReader fr = null;
        BufferedReader br = null;
        try{
            fr = new FileReader("config.ini");
            br = new BufferedReader(fr);
            prop.load(br);
            br.close();
            fr.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        DB_DRIVER = prop.getProperty("DB_DRIVER");
        URL = prop.getProperty("URL");
        USER = prop.getProperty("USER");
        PASS = prop.getProperty("PASS");
        TOP = Integer.parseInt(prop.getProperty("TOP"));
	}
//	
//	public static void main(String[] args) {
//		ThongSo a = new ThongSo();
//		a.docTuFile();
//		System.out.println(a.TOP);
//	}
}
