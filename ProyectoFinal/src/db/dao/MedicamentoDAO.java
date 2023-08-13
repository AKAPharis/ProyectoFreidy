package db.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Identidades.Medicamento;
import db.dbconnection.DBConnection;

public class MedicamentoDAO {
	public List<Medicamento> listaMedicamentos() {
		List<Medicamento> listaMedicamentos=  new ArrayList<>();
		
		
		DBConnection connection = new DBConnection();
		try {
			Statement st = connection.getConnection().createStatement();
			ResultSet rs = st.executeQuery("select idMedicamento,medicamento,principioActivo,marca,fabricante,cantidad from Medicamento");
			while(rs.next()) {
			listaMedicamentos.add(new Medicamento(rs.getInt("idMedicamento"),rs.getString("medicamento"),rs.getString("principioActivo"),rs.getString("marca"),rs.getString("fabricante"),rs.getInt("cantidad")));
			//	public Medicamento(int idMedicamento,String nombreMedicamento,String principioActivo,String marca,String fabricante,int cantidad) {

			}
				
			rs.close();
			st.close();
			connection.closeConnection();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
		return listaMedicamentos;
	}
	
}
