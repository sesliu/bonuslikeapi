package br.com.bonuslike.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.NamingException;

public class Conexao {
	

private static Connection conexao = null;

	
	public static Connection getConnection()
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException, NamingException {
				
	    String url = "jdbc:mysql://s54ham9zz83czkff.cbetxkdyhwsb.us-east-1.rds.amazonaws.com:3306/be1d0afjixihi0rj"; //"jdbc:mysql://localhost:3306/bonus_like";
		String user =  "udfklj2u5ge947cd"; //"root"; // data.getDataSource("spring.datasource.username"); //"root";
		String password =  "x21gnwzunigjkzfk"; //data.getDataSource("spring.datasource.password"); //"root";

		Class.forName("com.mysql.cj.jdbc.Driver");
		conexao  = DriverManager.getConnection(url, user, password);

		return conexao;
	
	}
	

	public static void close (){
		
		try {
		
			conexao.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


}
