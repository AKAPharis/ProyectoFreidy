package db.dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;

import Identidades.Consulta;
import Identidades.Documentacion;
import Identidades.Medico;
import Identidades.Paciente;
import Identidades.Receta;
import db.dbconnection.DBConnection;

public class ConsultaDAO {
	
	public boolean comprobarId(int id) {
		boolean result = false;
		DBConnection connection = new DBConnection();
		try {
			Statement st = connection.getConnection().createStatement();
			ResultSet rs = st.executeQuery("select idPaciente from Pacientes where idPaciente = " + id);
		
			if(rs.next() == true) {
			result = rs.getString("contraseña").equals(id);
			}
			
			rs.close();
			st.close();
			connection.closeConnection();
			return result;
		}catch(SQLException e) {
			e.printStackTrace();
		}
			
			return result;
		
		
		
		
		
	}
	
	
	
	
	public Consulta getConsulta(int idConsulta,Medico encargado) {
		Consulta consulta = null;
		DBConnection connection = new DBConnection();
		PacienteDAO pDAO = new PacienteDAO();
		try {
			Statement st = connection.getConnection().createStatement();
			ResultSet rs = st.executeQuery("\r\n"
					+ "select c.idConsulta,c.fecha,p.idPaciente from Consulta c \r\n"
					+ "					inner join Pacientes p on p.idPaciente = c.idPaciente\r\n"
					+ "					where c.idConsulta =" + idConsulta);
			if(rs.next()) {
				consulta  = new Consulta(rs.getInt("c.idConsulta"),rs.getDate("c.fecha"),pDAO.getPaciente(rs.getInt("p.idPaciente"),encargado));				
			}
				
			rs.close();
			st.close();
			connection.closeConnection();
		}catch(SQLException e) {
			e.printStackTrace();
		}
				
		
		
		return consulta;
	}
	public List<Consulta> listaConsulta(Medico encargado) {
		DBConnection connection = new DBConnection();
		PacienteDAO pDAO = new PacienteDAO();
		List<Consulta> lista = new ArrayList<>();
		try {
			Statement st = connection.getConnection().createStatement();
			ResultSet rs = st.executeQuery("select c.idConsulta,c.fecha,p.idPaciente from Consulta c "
					+ "inner join Pacientes p on p.idPaciente = c.idPaciente ");
			while(rs.next()) {
				lista.add(new Consulta(rs.getInt("c.idConsulta"),rs.getDate("c.fecha"),pDAO.getPaciente(rs.getInt("p.idPaciente"),encargado)));				
			}
				
			rs.close();
			st.close();
			connection.closeConnection();
		}catch(SQLException e) {
			e.printStackTrace();
		}
				
		return lista;
	}
	
	public int agregarConsulta(Consulta consulta) {
		int result = 0;
		DBConnection connection = new DBConnection();
		try {
			Statement st = connection.getConnection().createStatement();
			st.executeUpdate("insert into Consulta values(" + consulta.getIdConsulta()+",'"+new java.sql.Date(consulta.getFecha().getTime())+"',"+consulta.getPaciente().getIdPaciente()+","+consulta.getEncargado().getIdMedico()+")");
			for(int i = 0 ; i < consulta.getDiagnostico().length ; i++) {
			st.executeUpdate("insert into ConsultaDiagnostico values("+consulta.getIdConsulta()+","+consulta.getDiagnostico()[i]+")");
			}
			RecetaDAO rDAO = new RecetaDAO();
			rDAO.agregarReceta(consulta.getReceta(), consulta.getIdConsulta());
			
			connection.commit();
			st.close();
			connection.closeConnection();
		}catch(SQLException e) {
			connection.rollback();
			result = 1;
			e.printStackTrace();
		}
		return result;
	}
	/*
	public int[] getIdDiagnostico() {
		int diagnostico[];
		
	}
	
	*/
}
