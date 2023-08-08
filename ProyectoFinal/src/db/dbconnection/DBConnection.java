package db.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private String uri = "jdbc:mysql://localhost:3306/proyectofinal";
	private String user = "root";
	private String password = "P15m16o19!";
	
	private Connection connection = null ;
	public DBConnection(){
		
		try {
			connection = DriverManager.getConnection(uri,user,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		return connection;
	}
	//metodo para cerrar la conexion
	public void closeConnection() {
		connection = null;
	}
	
}
