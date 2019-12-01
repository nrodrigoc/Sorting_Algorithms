import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class Dijkstra {
	
	private ArrayList<Vertice> Q;
	private ArrayList<Vertice> S;
	
	private Grafo grafo; 
	
	
	public Dijkstra(int matriz[][]) {
		Q = new ArrayList<Vertice>();
		S = new ArrayList<Vertice>();
		
		grafo = new Grafo(matriz);
		
		for(int i = 0; i < grafo.heap.length; i++) {
			Q.add(grafo.heap[i]);
		}
	}
	
	public void inicializa(int origem) {
		grafo.heap[origem].distOrigem = 0;
		
		
		Iterator<Vertice> itr = Q.iterator();
		
		while(itr.hasNext()) {
			Vertice u = Q.get(0);
			
			for(int i = 0; i < grafo.getVizinhos(u).length; i++) {
				relaxamento(u, grafo.getVizinhos(u)[i]);
			}
			
			S.add(Q.get(0));
			Q.remove(0);
		}
			
			
		for(Vertice v : S) {
			System.out.println("vertice: " + v.id);
		}
		
		for(int i = 0; i < grafo.heap.length; i++) {
			System.out.print(grafo.heap[i].antecessor);
		}
		System.out.println("\ndistancia: " + grafo.heap[grafo.heap.length-1].distOrigem);
		
	}
	
	public void printArray(Vertice[] heap) {
		for(int i = 0; i < heap.length; i++) {
			System.out.println("Distancia ateh origem do vertice " + i + ": " + heap[i].distOrigem);
		}
		
	}
	
	public void relaxamento(Vertice u, Vertice v) {
		
		if(v.distOrigem > (u.distOrigem + grafo.getPeso(u.id, v.id))) {
			v.distOrigem = u.distOrigem + v.distOrigem;	
			v.antecessor = u.id;
		}
		
	}
	
	
}
