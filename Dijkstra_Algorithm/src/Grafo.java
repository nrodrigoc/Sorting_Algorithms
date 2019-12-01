import java.awt.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class Grafo {
	
	private int[][] matriz;
	public Vertice[] heap;
	
	
	public Grafo(int[][] matriz) {
		this.matriz = matriz;
	
		initVertexArray();
	}
	
	public void initVertexArray() {
		heap = new Vertice[matriz.length];
		for(int i = 0; i < matriz.length; i++) {
			heap[i] = new Vertice(i);
		}
	}
	
	
	/*
	 * v1 -> vertice1
	 * v2 -> vertice2
	 */
	public int getPeso(int v1, int v2) {
		return matriz[v1][v2];
	}
	
	/*
	 * retorna a lista de adjacencia do no
	 */
	public Vertice[] getVizinhos(Vertice vertice){
		Vertice[] vizinhos = new Vertice[matriz.length-1];
		
		int ajuste = 0;
		for(int i = 0; i < heap.length-1; i++) {
			if(ajuste == 0) {
				if(matriz[vertice.id][i] > 0)
					vizinhos[i] = heap[i];
				else
					ajuste = 1;
			}else
				vizinhos[i-1] = heap[i];
		}
		
		return vizinhos;
	}
	
	
}
