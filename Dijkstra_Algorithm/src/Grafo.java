import java.awt.List;
import java.util.ArrayList;

public class Grafo {
	
	private int[][] nos;
	private int nDeNos;
	
	public Grafo(int[][] nos, int nDeNos) {
		this.nos = nos;
		this.nDeNos = nDeNos;
	}
	
	/*
	 * v1 -> vertice1
	 * v2 -> vertice2
	 */
	public void removerAresta(int v1, int v2) {
		nos[v1][v2] = 0;
		nos[v2][v1] = 0;
	}
	
	public int getDistancia(int v1, int v2) {
		return nos[v1][v2];
	}
	
	/*
	 * retorna a lista de adjacencia do no
	 */
	public ArrayList<Integer> getVizinhos(int vertice){
		ArrayList<Integer> vizinhos = new ArrayList<>();
		
		for(int i = 0; i < nDeNos; i++) {
			if(nos[vertice][i] > 0) {
				vizinhos.add(nos[vertice][i]);
			}
		}
		
		return vizinhos;
	}
	
	
}
