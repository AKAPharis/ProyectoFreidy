package db.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;

import Identidades.Documentacion;
import Identidades.Medico;
import Identidades.Paciente;
import db.dbconnection.DBConnection;

public class PacienteDAO {
	
	public Paciente getPaciente(int idPaciente,Medico encargado) {
		Paciente paciente = null;
		DBConnection connection = new DBConnection();
		try {
			Statement st = connection.getConnection().createStatement();
			ResultSet rs = st.executeQuery("select p.idPaciente,p.nombrePaciente,p.apellidoPaciente,p.estado,dp.tipoDocumento,dp.noDocumento from Pacientes p \r\n"
					+ "inner join DocumentoPaciente dp on dp.idPaciente = p.idPaciente \r\n"
					+ "where p.idPaciente = "+ idPaciente);
			if(rs.next()) {
				paciente = new Paciente(rs.getInt("p.idPaciente"),new Documentacion(rs.getString("dp.tipoDocumento"),rs.getString("dp.noDocumento")), rs.getString("p.nombrePaciente"), rs.getString("p.apellidoPaciente"),rs.getString("p.estado"), isInterno(rs.getInt("p.idPaciente")), encargado);
			}

			rs.close();
		
			st.close();
			connection.closeConnection();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return paciente;
	}
	
	public Paciente getPaciente(String nombrePaciente,Medico encargado) {
		Paciente paciente = null;
		DBConnection connection = new DBConnection();
		try {
			Statement st = connection.getConnection().createStatement();
			ResultSet rs = st.executeQuery("select p.idPaciente,p.nombrePaciente,p.apellidoPaciente,p.estado,dp.tipoDocumento,dp.noDocumento from Pacientes p \r\n"
					+ "inner join DocumentoPaciente dp on dp.idPaciente = p.idPaciente \r\n"
					+ "where p.nombrePaciente = '"+ nombrePaciente +"' and p.idMedico = " + encargado.getIdMedico());
			if(rs.next()) { 
				paciente = new Paciente(rs.getInt("p.idPaciente"),new Documentacion(rs.getString("dp.tipoDocumento"),rs.getString("dp.noDocumento")), rs.getString("p.nombrePaciente"), rs.getString("p.apellidoPaciente"),rs.getString("p.estado"), isInterno(rs.getInt("p.idPaciente")), encargado);
			}

			rs.close();
		
			st.close();
			connection.closeConnection();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return paciente;
	}
	
	public int agregarPaciente(Paciente paciente) {
		int result = 0;
		DBConnection connection = new DBConnection();
		try {
			Statement st = connection.getConnection().createStatement();
			System.out.println("insert into Pacientes values("+paciente.getIdPaciente()+",'"+paciente.getNombre()+"','"+paciente.getApellido()+"','"+paciente.getEstado()+"',"+paciente.getMedicoEncargago().getIdMedico()+")");
			st.executeUpdate("insert into Pacientes values("+paciente.getIdPaciente()+",'"+paciente.getNombre()+"','"+paciente.getApellido()+"','"+paciente.getEstado()+"',"+paciente.getMedicoEncargago().getIdMedico()+")");
			System.out.println("insert into DocumentoPaciente(tipoDocumento,noDocumento,idPaciente) values('"+paciente.getDocumento().getTipo()+"','"+paciente.getDocumento().getNoDocumento()+"',"+paciente.getIdPaciente()+")");
			st.executeUpdate("insert into DocumentoPaciente(tipoDocumento,noDocumento,idPaciente) values('"+paciente.getDocumento().getTipo()+"','"+paciente.getDocumento().getNoDocumento()+"',"+paciente.getIdPaciente()+")");
			if(paciente.isInterno()) {
				st.executeUpdate("update Habitacion set idPaciente = " +paciente+" where idHabitacion = "+paciente.getHabitacion().getNoHabitacion() );

			}
			connection.commit();
			st.close();
			connection.closeConnection();
		}catch(SQLException e) {
			connection.rollback();
			result =  1;
			e.printStackTrace();
		}
		return result;
	}
	
	public void eliminarPaciente(Paciente paciente) {
		DBConnection connection = new DBConnection();
		try {
			Statement st = connection.getConnection().createStatement();
			st.executeUpdate("delete from Pacientes where idPaciente = " + paciente.getIdPaciente());
			st.executeUpdate("delete from DocumentoPaciente where idPaciente = " + paciente.getIdPaciente());
			st.executeUpdate("update Habitacion set idPaciente = null where idPaciente = " + paciente.getIdPaciente());

			st.close();
			connection.closeConnection();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public boolean isInterno(int idPaciente) {
		boolean result = false;
		DBConnection connection = new DBConnection();
		try {
			Statement st = connection.getConnection().createStatement();
			ResultSet rs = st.executeQuery("select idPaciente from Habitacion where idPaciente = " + idPaciente);
			
			if (rs.next()){
				
				result = true;
			}
			
			rs.close();
			st.close();
			connection.closeConnection();
		}catch(SQLException e) {
			e.printStackTrace();
		}
			
		return result;
		
	}
	
	public List<Paciente> listaPacientes(Medico encargado){
		List<Paciente> lista = new ArrayList<>();
		DBConnection connection = new DBConnection();
		try {
			Statement st = connection.getConnection().createStatement();
			ResultSet rs = st.executeQuery("select p.idPaciente,p.nombrePaciente,p.apellidoPaciente,p.estado,dp.tipoDocumento,dp.noDocumento from Pacientes p \r\n"
											+ "inner join DocumentoPaciente dp on dp.idPaciente = p.idPaciente \r\n"
											+ "where p.idMedico = "+ encargado.getIdMedico());
			while(rs.next()) {
				lista.add(new Paciente(rs.getInt("p.idPaciente"),new Documentacion(rs.getString("dp.tipoDocumento"),rs.getString("dp.noDocumento")), rs.getString("p.nombrePaciente"), rs.getString("p.apellidoPaciente"),rs.getString("p.estado"), isInterno(rs.getInt("p.idPaciente")), encargado));				
			}
				
			rs.close();
			st.close();
			connection.closeConnection();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return lista;
		
	}
	
	public List<Paciente> consultarPacientes(String nombrePaciente, Medico encargado) {
		List<Paciente> paciente = new ArrayList<>();
		DBConnection connection = new DBConnection();
		try {
			Statement st = connection.getConnection().createStatement();
			ResultSet rs = st.executeQuery("select p.idPaciente,p.nombrePaciente,p.apellidoPaciente,p.estado,dp.tipoDocumento,dp.noDocumento from Pacientes p \r\n"
											+ "inner join DocumentoPaciente dp on dp.idPaciente = p.idPaciente \r\n"
											+ "where nombrePaciente like '%"+nombrePaciente+"%' and p.idMedico = "+ encargado.getIdMedico());
			while(rs.next()) {
				paciente.add(new Paciente(rs.getInt("p.idPaciente"),new Documentacion(rs.getString("dp.tipoDocumento"),rs.getString("dp.noDocumento")), rs.getString("p.nombrePaciente"), rs.getString("p.apellidoPaciente"),rs.getString("p.estado"), false, encargado));
			
			}
			rs.close();
			st.close();
			connection.closeConnection();
		}catch(SQLException e) {
			e.printStackTrace();
		}
			
		return paciente;
	}
}

