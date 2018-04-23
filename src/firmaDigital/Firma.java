package firmaDigital;

//http://www.disca.upv.es/elvira/practicasIR/pracs97-98/firDigitales.html
public class Firma {

	private String firmaDigital;
	private String clavePublica;
	private String clavePrivada;
	private String clave;
	
	public Firma(String clave) {
		this.clave = clave;
	}
	
	public Firma() {
	}
	
	public String getClave() {
		return this.clave;
	}
}
