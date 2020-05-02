
package main;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;



public class ModelPraktikum {
    //mengkoneksikan ke database
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/clicker";//nama database kita di slash terakhir
    static final String USER = "root";
    static final String PASS = "";
    
    Connection koneksi;
    Statement statement;//untuk perintah query

    public ModelPraktikum() {
        try{
            Class.forName(JDBC_DRIVER);
            koneksi = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Koneksi Berhasil");
            statement = koneksi.createStatement();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println("Koneksi Gagal");
        }
    }
    
    public int selectMultiplication() {
    	try {
    		int iambilMultiplication = 0;
    		String sambilMultiplication = null;
    		String query = "SELECT multiplication FROM player";
    		ResultSet rs = statement.executeQuery(query);
    		while(rs.next()) {
    			sambilMultiplication = rs.getString("multiplication");
    		}
    		iambilMultiplication = Integer.parseInt(sambilMultiplication);
    		return iambilMultiplication;
    	}catch(Exception e) {
    		System.out.println(e.getMessage());
    	}
    	return 0;
    }
    
    public int selectMoney() {
    	try {
    		int money;
    		String ambilMoney = null;
        	String query = "SELECT money FROM player";
        	ResultSet rs = statement.executeQuery(query);
        	while(rs.next()) {
        		ambilMoney = rs.getString("money");
        	}
        	money = Integer.parseInt(ambilMoney);
        	return money;
    	}
    	catch(Exception e) {
    		System.out.println(e.getMessage());
    	}
		return 0;
    }

    public void updateMoney(String money){
    	try {
    		String query = "UPDATE player SET money = '"+money+"'";
    		statement.execute(query);
    	}
    	catch(Exception e) {
    		
    	}
    }
   
    public void updateMoneyToZero() {
    	try {
    		String query = "UPDATE player SET money='0'";
    		statement.execute(query);
    	}catch(Exception e) {
    		
    	}
    }
    
    public void updateMultiplicationToZero() {
    	try {
    		String query = "UPDATE player SET multiplication='1'";
    		statement.execute(query);
    	}catch(Exception e) {
    		
    	}
    }
    
    public void updateMultiplication(String a) {
    	try {
    		String query = "UPDATE player SET multiplication='"+a+"'";
    		statement.execute(query);
    	}catch(Exception e) {
    		
    	}
    }
    
    public int testLevelUpCost() {
    	int cost = 0;
    	int money = 0;
    	money = selectMoney();
    	cost = (int) (selectMultiplication() * 2.5);
    	if(money >= cost) {
    		return 1;
    	}
    	else
    	{
    		return 0;
    	}
    }
}
