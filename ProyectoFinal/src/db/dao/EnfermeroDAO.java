package db.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Identidades.Enfermero;
import db.dbconnection.DBConnection;

public class EnfermeroDAO {

	public void agregarEnfermero(Enfermero enfermero) {
		DBConnection connection = new DBConnection();
		try {
			Statement st = connection.getConnection().createStatement();
			
			System.out.println("insert into Enfermeros values("+enfermero.getIdEnferma()+",'"+enfermero.getNombre()+"','"+enfermero.getApellido()+"','"+enfermero.getGrado()+"','"+enfermero.getContraseña()+"')");
			st.executeUpdate("insert into Enfermeros values("+enfermero.getIdEnferma()+",'"+enfermero.getNombre()+"','"+enfermero.getApellido()+"','"+enfermero.getGrado()+"','"+enfermero.getContraseña()+"')");
			System.out.println("insert into DocumentoEnfermero(tipoDocumento,noDocumento,idEnfermero) values('"+enfermero.getDocumento().getTipo()+"','"+enfermero.getDocumento().getNoDocumento()+"',"+enfermero.getIdEnferma()+")");
			st.executeUpdate("insert into DocumentoEnfermero(tipoDocumento,noDocumento,idEnfermero) values('"+enfermero.getDocumento().getTipo()+"','"+enfermero.getDocumento().getNoDocumento()+"',"+enfermero.getIdEnferma()+")");
			st.close();
			connection.closeConnection();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
		
	}
	
	@SuppressWarnings("finally")
	public boolean comprobarContraseña(int id,String contraseña) {
		boolean result = false;
		DBConnection connection = new DBConnection();
		try {
			Statement st = connection.getConnection().createStatement();
			ResultSet rs = st.executeQuery("select contraseña from Enfermeros where idEnfermero = " + id);
		
			if(rs.next() == true) {
			result = rs.getString("contraseña").equals(contraseña);
			}
			rs.close();
			st.close();
			connection.closeConnection();
			return result;
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			
			return result;
		}
		
		
		
		
	}
	
}
