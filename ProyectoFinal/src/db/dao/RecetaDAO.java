package db.dao;

import java.sql.SQLException;
import java.sql.Statement;

import Identidades.Receta;
import db.dbconnection.DBConnection;

public class RecetaDAO {
	public int agregarReceta(Receta receta,int idConsulta) {
		int result = 0;
		DBConnection connection = new DBConnection();
		try {
			Statement st = connection.getConnection().createStatement();
			st.executeUpdate("insert into Receta values("+receta.getIdReceta()+","+idConsulta+")");
			for(int i = 0 ; i < receta.getListaMedicamentos().size() ; i++) {
			st.executeUpdate("insert into DetalleReceta values("+receta.getIdReceta()+","+receta.getListaMedicamentos().get(i).getIdMedicamento()+","+receta.getListaMedicamentos().get(i).getCantidad()+")");
			}
			
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
}
