import firmaDigital.Firma;

public class Main {
	
	
	
	public static void main(String[] args) {
				
		Firma depositante = new Firma("123");
		Transaccion transaccion = new Transaccion("Elvis","Gato",100);
		transaccion.generar(depositante);
	}

}
