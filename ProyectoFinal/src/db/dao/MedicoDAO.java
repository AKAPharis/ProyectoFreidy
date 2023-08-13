package db.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import Identidades.Medico;
import db.dbconnection.DBConnection;
public class MedicoDAO {
	
	public int agregarMedico(Medico medico) {
		int result = 0;
		DBConnection connection = new DBConnection();
		try {
			Statement st = connection.getConnection().createStatement();
			System.out.println("insert into Medicos values(" +medico.getIdMedico()+",'" + medico.getNombre() +"','"+medico.getApellido()+"','"+medico.getExequatur()+"','"+medico.getEspecializacion()+"','"+medico.getContraseña()+"')");
			st.executeUpdate("insert into Medicos values(" +medico.getIdMedico()+",'" + medico.getNombre() +"','"+medico.getApellido()+"','"+medico.getExequatur()+"','"+medico.getEspecializacion()+"','"+medico.getContraseña()+"')");
			System.out.println("insert into DocumentoMedico(tipoDocumento,noDocumento,idMedico) values('" +medico.getDocumento().getTipo()+"','"+medico.getDocumento().getNoDocumento()+"',"+medico.getIdMedico()+")");
			st.executeUpdate("insert into DocumentoMedico(tipoDocumento,noDocumento,idMedico) values('" +medico.getDocumento().getTipo()+"','"+medico.getDocumento().getNoDocumento()+"',"+medico.getIdMedico()+")");
			
			st.close();
			connection.commit();
		}catch(SQLException e) {
			connection.rollback();
			result = 1;
			e.printStackTrace();
		}finally{
			
			connection.closeConnection();
		}
		return result;
		
		
		
	}
	
	
	@SuppressWarnings("finally")
	public boolean comprobarContraseña(int id,String contraseña) {
		boolean result = false;
		DBConnection connection = new DBConnection();
		try {
			Statement st = connection.getConnection().createStatement();
			ResultSet rs = st.executeQuery("select contraseña from Medicos where idMedico = " + id);
		
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
