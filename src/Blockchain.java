import java.util.ArrayList;
import java.util.List;

public class Blockchain {

	private List<Bloque> bloques;
	
	public Blockchain() {
		this.bloques = new ArrayList<>();
	}
	
	public void addBlock(Bloque b) {
		this.bloques.add(b);
	}
	
	
}
