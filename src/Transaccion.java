import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.SignatureException;

import firmaDigital.Firma;
import firmaDigital.Firmador;
import firmaDigital.GeneradorDeClaves;

public class Transaccion {

	private Firma depositante;
	private int importe;
	private String usuarioAcreedor;
	private String usuarioDepositante; // quizas pueda obviarse al estar la firma
	private PublicKey clavePublica;
	private String emicion;
	private String firmado;
	
	
	public Transaccion(String usuarioA,String usuarioD,int importe) {
		this.importe = importe;
		this.usuarioAcreedor = usuarioA;
		this.usuarioDepositante = usuarioD;
	}
	
	public String getEmicion() {
		return this.emicion;
	}
	
	public PublicKey getClavePublica() {
		return this.clavePublica;
	}
	
	public String getFirmado() {
		return this.firmado;
	}
	
	public void generar(Firma depositante) {
		this.depositante = depositante;
		this.emicion = this.emitir();
		// DEBERIA ENCRIPTARSE
		try {
			GeneradorDeClaves generador = new GeneradorDeClaves();
			generador.generarClave(depositante.getClave());
			KeyPair claves = generador.getClaves().get(depositante.getClave());
			this.clavePublica = claves.getPublic();
			Firmador firmador = new Firmador();
			try {
				byte[] data = firmador.firmarArchivo(claves.getPrivate(), emicion);
				this.firmado = new String(data, StandardCharsets.UTF_8);
			} catch (InvalidKeyException | SignatureException e) {
				e.printStackTrace();
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
	}
	
	public String emitir() {
		Integer dinero = this.importe;
		return ("El usuario "+this.usuarioAcreedor+" recibe "+dinero.toString()+" de "+this.usuarioDepositante);
	}

	
}
