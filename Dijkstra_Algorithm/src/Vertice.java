
public class Vertice {
	
	public int id;
	public int antecessor;
	public int distOrigem;
	
	public Vertice(int id) {
		this.id = id;
		antecessor = -1;
		this.distOrigem = 99999;
	}
	
	
}
