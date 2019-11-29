
public class Vertice {
	
	public int id;
	public int antecessor;
	public int distOrigem;
	
	public Vertice(int id) {
		this.id = id;
		antecessor = -1;
		this.distOrigem = Integer.MAX_VALUE/2;
	}
	
	public int getDadIndex() {
		return id/2; 
	}
	
}
