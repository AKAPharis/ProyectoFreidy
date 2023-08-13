package db.dao;

import java.util.List;

import Identidades.Documentacion;
import Identidades.Paciente;
import db.dbconnection.DBConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Cie10DAO {

	public List<String> listaCodigos() {
		List<String> listaCodigos =  new ArrayList<>();
		
		
		DBConnection connection = new DBConnection();
		try {
			Statement st = connection.getConnection().createStatement();
			ResultSet rs = st.executeQuery("select descripcion from cie10");
			while(rs.next()) {
			 listaCodigos.add(rs.getString(1));				
			}
				
			rs.close();
			st.close();
			connection.closeConnection();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
		return listaCodigos;
	}
	
	public int getId(String nombre) {
		int id = 0 ;
		DBConnection connection = new DBConnection();
		try {
			Statement st = connection.getConnection().createStatement();
			ResultSet rs = st.executeQuery("select id from cie10");
			if(rs.next()) {
			 id = rs.getInt("id");				
			}
				
			rs.close();
			st.close();
			connection.closeConnection();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
		return id;
	}
	
}
