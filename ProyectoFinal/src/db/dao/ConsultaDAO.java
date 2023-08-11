package db.dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import Identidades.Consulta;
import Identidades.Documentacion;
import Identidades.Medico;
import Identidades.Paciente;
import Identidades.Receta;
import db.dbconnection.DBConnection;

public class ConsultaDAO {
	public List<Consulta> listaConsulta(Medico encargado) {
		DBConnection connection = new DBConnection();
		PacienteDAO pDAO = new PacienteDAO();
		List<Consulta> lista = null;
		try {
			Statement st = connection.getConnection().createStatement();
			ResultSet rs = st.executeQuery("select c.idConsulta,c.fecha,c.estado,p.idPaciente from Consulta c"
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
	
	public void agregarConsulta(Consulta consulta) {
		DBConnection connection = new DBConnection();
		try {
			Statement st = connection.getConnection().createStatement();
			/*
			 * 
create table Consulta
(
	idConsulta int not null primary key,
    fecha date,
	idPaciente int,
	idMedico int not null,
    constraint FK_Consulta_Paciente foreign key(idPaciente) references Pacientes(idPaciente),
	constraint FK_Consulta_Medico foreign key(idMedico) references Medicos(idMedico)

    
)

create table ConsultaDiagnostico
(
    idConsulta int not null,
    idCIE int not null,
    primary key(idConsulta,idCIE),
    constraint FK_CD_Consulta foreign key(idConsulta) references Consulta(idConsulta),
    constraint FK_CD_CIE foreign key(idCIE) references CIE10(id)
    
)	

create table Receta
(
	idReceta int not null primary key,
    idConsulta int not null,
    constraint FK_Receta_Consulta foreign key(idConsulta) references Consulta(idConsulta)
)

create table DetalleReceta
(
	idReceta int not null,
    idMedicamento int not null,
    primary key(idReceta,idMedicamento),
    constraint FK_Detalle_Receta foreign key(idReceta) references Receta(idReceta),
    constraint FK_Detalle_Medicamento foreign key(idMedicamento) references Medicamento(idMedicamento)
)

			 */
			st.executeUpdate("insert into Consulta values(" + consulta.getIdConsulta()+",'"+consulta.getFecha()+"',"+consulta.getPaciente().getIdPaciente()+","+consulta.getEncargado().getIdMedico());
			for(int i = 0 ; i < consulta.getDiagnostico().length ; i++) {
			st.executeUpdate("insert into ConsultaDiagnostico values("+consulta.getIdConsulta()+","+consulta.getDiagnostico()[i]+")");
			}
			
			
			st.close();
			connection.closeConnection();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	
}
