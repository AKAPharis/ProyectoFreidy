package db.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import Identidades.Documentacion;
import Identidades.Medico;
import Identidades.Paciente;
import db.dbconnection.DBConnection;

public class PacienteDAO {
	
	public void agregarPaciente(Paciente paciente) {
		DBConnection connection = new DBConnection();
		try {
			
			/*
			idPaciente int not null primary key,
		    nombrePaciente varchar(30),
		    apellidoPaciente varchar(30),
		    estado varchar(15),
		    idMedico int not null,
		    constraint FK_Paciente_Medico foreign key(idMedico) references Medicos(idMedico)
			*/
			Statement st = connection.getConnection().createStatement();
			
			st.executeUpdate("insert into Pacientes values("+paciente.getIdPaciente()+",'"+paciente.getNombre()+"','"+paciente.getApellido()+"','"+paciente.getEstado()+"',"+paciente.getMedicoEncargago().getIdMedico());
			st.executeUpdate("insert into DocumentoPaciente(tipo,noDocumento,idPaciente) values('"+paciente.getDocumento().getTipo()+"','"+paciente.getDocumento().getNoDocumento()+"',"+paciente.getIdPaciente());
			if(paciente.isInterno()) {
				st.executeUpdate("update Habitacion set idPaciente = " +paciente+" where idHabitacion = "+paciente.getHabitacion().getNoHabitacion() );

			}

			st.close();
			connection.closeConnection();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	@SuppressWarnings("finally")
	public List<Paciente> consultarPacientes(String nombrePaciente, Medico encargado) {
		List<Paciente> paciente = null;
		DBConnection connection = new DBConnection();
		try {
			Statement st = connection.getConnection().createStatement();
			ResultSet rs = st.executeQuery("select p.idPaciente,p.nombrePaciente,p.apellidoPaciente,p.estado,dp.tipoDocumento,dp.noDocumento from Pacientes p \r\n"
											+ "inner join DocumentoPaciente dp on dp.idPaciente = p.idPaciente \r\n"
											+ "where nombrePaciente like '%"+nombrePaciente+"%' and p.idMedico = "+ encargado.getIdMedico());
			while(rs.next()) {
				paciente.add(new Paciente(rs.getInt("p.idPaciente"),new Documentacion(rs.getString("dp.tipoDocumento"),rs.getString("dp.noDocumento")), rs.getString("p.nombrePaciente"), rs.getString("p.apellidoPaciente"),rs.getString("p.estado"), false, encargado));
			/*
			 * 
			 * 	private Documentacion documento;
	private String nombre;
	private String apellido;
	private String estado;
	private boolean interno;
	private Medico medicoEncargago;
	
			 */
			
			}
			rs.close();
			st.close();
			connection.closeConnection();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			
			return paciente;
		}
	}
}

