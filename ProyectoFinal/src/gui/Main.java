package gui;

import Identidades.Documentacion;
import Identidades.Medico;

public class Main {

	public static void main(String[] args) {
//public Medico(int idMedico, String exequatur, String especializacion, String nombre, String apellido, Documentacion documentoMedico, String contraseña)
		ConsultaM c = new ConsultaM(new Medico(1,"12323","General","maria","mariñes",new Documentacion("cedula","231223"),"12345"));
		
	}

}
