import java.util.ArrayList;
import java.util.LinkedList;

public class Dijkstra {
	
	private int nDeNos;
	private int matrizAdjacente[][];
	private ArrayList<Vertice> listaDeAdjacencia;
	private LinkedList<Integer> caminhoMin;
	
	private Grafo grafo; 
	
	public Dijkstra(int matriz[][], int nDeNos) {
		matrizAdjacente = matriz;
		this.nDeNos = nDeNos;
		caminhoMin = new LinkedList<Integer>();
		listaDeAdjacencia = new ArrayList<Vertice>();
		
		grafo = new Grafo(matriz, nDeNos);
		inicializa(0);
		
		for(int i = grafo.vertices.size()-1; i >= 0; i--) {
			Vertice u = grafo.vertices.get(0);
			listaDeAdjacencia.add(u);
			
			for(Integer v : grafo.getVizinhos(u.id)) {
				relaxamento(u, grafo.vertices.get(v));
			}
			
		}
		
		
	}
	
	public void inicializa(int origem) {
		grafo.vertices.get(origem).distOrigem = 0;
	}
	
	public void relaxamento(Vertice u, Vertice v) {
		if(v.distOrigem > (u.distOrigem + grafo.getDistancia(u.id, v.id))) {
			v.distOrigem = u.distOrigem + v.distOrigem;
			
		}
		
	}
	
	
}
