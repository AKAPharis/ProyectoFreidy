package db.dao;

import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Identidades.Cita;
import Identidades.Documentacion;
import Identidades.Medico;
import Identidades.Paciente;
import db.dbconnection.DBConnection;

public class CitaDAO {
	
	public List<Cita> listaCitas(Medico encargado) {
		List<Cita> listaCitas = new ArrayList<>();
		PacienteDAO pDAO = new PacienteDAO();
		
		DBConnection connection = new DBConnection();
		try {
			Statement st = connection.getConnection().createStatement();
			ResultSet rs = st.executeQuery("select c.idCita,c.idPaciente,c.diaCita,c.estado,p.idMedico from Cita c"
					+ "inner join Pacientes p on p.idPaciente = c.idPaciente"
					+ "inner join Medicos m on m.idMedico = p.idMedico");
			while(rs.next()) {
				listaCitas.add(new Cita(rs.getInt(1),rs.getDate(3),pDAO.getPaciente(rs.getInt(2),encargado ),rs.getString(4)));
			}
				
			rs.close();
			st.close();
			connection.closeConnection();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return listaCitas;
		
		
	}
	
	
	
}
