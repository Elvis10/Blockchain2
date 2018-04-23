import firmaDigital.Firma;

public class Monedero {
	
	private int saldo;
	private Firma firma;
	private String usuario;
	private String password;
	private Transaccion transaccion;
	private Bloque bloque;
	
	public Monedero() {
		this.saldo = 0;
		this.firma = new Firma();
	}
	
	public void cargarSaldo(int saldo) {
		this.saldo+=saldo;
	}
	
	public void cargarFirma(Firma firma) {
		this.firma = firma;
	}
	
	public void nombrarUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	public void password(String pass) {
		this.password = pass;
	}
	
	public void transferir(int cantidad,String usuario) {
		
	}

}
