package Identidades;

public class Documentacion {
	private String tipo;
	private String noDocumento;
	
	public Documentacion(String tipo,String noDocumento) {
		this.setTipo(tipo);
		this.setNoDocumento(noDocumento);
	}
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public String getNoDocumento() {
		return noDocumento;
	}
	public void setNoDocumento(String noDocumento) {
		this.noDocumento = noDocumento;
	}
	
	public String toString() {
        return tipo + noDocumento;
    }
	
}

