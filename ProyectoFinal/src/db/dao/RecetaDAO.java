package db.dao;

import java.sql.SQLException;
import java.sql.Statement;

import Identidades.Receta;
import db.dbconnection.DBConnection;

public class RecetaDAO {
	public void agregarReceta(Receta receta,int idConsulta) {
		
		DBConnection connection = new DBConnection();
		try {
			Statement st = connection.getConnection().createStatement();
			st.executeUpdate("insert into Receta values("+receta.getIdReceta()+","+idConsulta+")");
			for(int i = 0 ; i < receta.getListaMedicamentos().length ; i++) {
			st.executeUpdate("insert into DetalleReceta values("+receta.getIdReceta()+","+receta.getListaMedicamentos()[i].getIdMedicamento()+")");
			}
			
			
			st.close();
			connection.closeConnection();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
}
