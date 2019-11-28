
public class Vertice {
	
	public int id;
	public boolean visitado;
	public int antecessor;
	public int distOrigem;
	
	public Vertice(int id) {
		this.id = id;
		visitado = false;
		antecessor = -1;
		this.distOrigem = 99999;
	}
	
	
}
