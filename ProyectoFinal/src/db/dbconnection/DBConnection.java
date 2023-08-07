package db.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	//Cambiar la conexion a lo hora de usar el programa
	private String conectionString = "\"jdbc:mysql://localhost:3306/proyectofinal\",\"root\",\"P15m16o19!";
	private Connection connection = null ;
	public DBConnection(){
		try {
			connection = DriverManager.getConnection(conectionString);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		return connection;
	}
	
	public void closeConnection() {
		connection = null;
	}
	
}
