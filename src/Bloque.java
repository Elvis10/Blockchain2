import java.util.ArrayList;
import java.util.List;

import firmaDigital.Verificador;

public class Bloque {

	private List<Transaccion> transacciones; // tiene un limite de transacciones, capas lo ideal es que sea un arreglo
	
	public Bloque() {
		this.transacciones = new ArrayList<Transaccion>();
	}
	
	private boolean verificarFirma(Transaccion t) {
		Verificador verificador = new Verificador();
		try {
			return verificador.validarFirma(t.getEmicion(),t.getFirmado(),t.getClavePublica());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	private boolean verificarSaldo(Transaccion t) {
		return true; // EL SALDO CREO QUE NO SE VERIFICA EN LA CUENTA SINO EN LAS TRANSACCIONES MAS UN MINIMO EXISTENTE
	}
	
	private boolean verificar(Transaccion t) {
		boolean firma = this.verificarFirma(t);
		boolean saldo = this.verificarSaldo(t);
		if(firma && saldo) {
			return true;
		}
		return false;
	}
	
	public void addTransaccion(Transaccion t) {
		boolean agregar = this.verificar(t);
		if(agregar) {
			this.transacciones.add(t);
		}
	}
	
}
