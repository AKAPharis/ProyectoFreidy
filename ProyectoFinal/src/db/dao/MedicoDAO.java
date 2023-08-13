package db.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Identidades.Documentacion;
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
	
	public Medico getMedico(int id) {
		Medico medico = null;
		DBConnection connection = new DBConnection();

		try {
			Statement st = connection.getConnection().createStatement();
			ResultSet rs = st.executeQuery("select m.idMedico,m.nombre,m.apellido,m.exequatur,m.especializacion,m.contraseña,dm.tipoDocumento,dm.noDocumento from Medicos m "
					+ "inner join DocumentoMedico dm on dm.idMedico = m.idMedico"
					+ " where m.idMedico = " + id);

			if(rs.next() == true) {
			medico = new Medico(rs.getInt("m.idMedico"),rs.getString("m.exequatur"),rs.getString("m.especializacion"),rs.getString("m.nombre"),rs.getString("m.apellido"), new Documentacion(rs.getString("dm.tipoDocumento"),rs.getString("dm.noDocumento")),rs.getString("m.contraseña"));
			}
			rs.close();
			st.close();
			connection.closeConnection();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally{
			
			connection.closeConnection();
		}
		
		return medico;
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
