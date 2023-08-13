package db.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private String uri = "jdbc:mysql://localhost:3306/proyectofinal";
	private String user = "root";
	private String password = "2654k";
	
	private Connection connection = null ;
	public DBConnection(){
		
		try {
			connection = DriverManager.getConnection(uri,user,password);
			connection.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	public void commit() {
		try {
			connection.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		return connection;
	}
	
	public void rollback(){
		try {
			connection.rollback();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		//metodo para cerrar la conexion
	public void closeConnection() {
		connection = null;
	}
	
}
