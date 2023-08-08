package db.dao;

import java.sql.SQLException;
import java.sql.Statement;

import Identidades.Medico;
import db.dbconnection.DBConnection;
public class MedicoDAO {
	
	public void agregarMedico(Medico medico) {
		DBConnection connection = new DBConnection();
		try {
			Statement st = connection.getConnection().createStatement();
			System.out.println("insert into Medicos values(" +medico.getIdMedico()+",'" + medico.getNombre() +"','"+medico.getApellido()+"','"+medico.getExequatur()+"','"+medico.getEspecializacion()+"','"+medico.getContraseña()+"')");
			st.executeUpdate("insert into Medicos values(" +medico.getIdMedico()+",'" + medico.getNombre() +"','"+medico.getApellido()+"','"+medico.getExequatur()+"','"+medico.getEspecializacion()+"','"+medico.getContraseña()+"')");
			System.out.println("insert into DocumentoMedico(tipoDocumento,noDocumento,idMedico) values('" +medico.getDocumento().getTipo()+"','"+medico.getDocumento().getNoDocumento()+"',"+medico.getIdMedico()+")");
			st.executeUpdate("insert into DocumentoMedico(tipoDocumento,noDocumento,idMedico) values('" +medico.getDocumento().getTipo()+"','"+medico.getDocumento().getNoDocumento()+"',"+medico.getIdMedico()+")");

			st.close();
			connection.closeConnection();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
	}
	
	
	
}
