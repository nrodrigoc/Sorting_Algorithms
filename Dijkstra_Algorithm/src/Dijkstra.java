import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class Dijkstra {
	
	private ArrayList<Vertice> listaDeAdjacencia;
	private ArrayList<Vertice> abertos;
	private ArrayList<Vertice> fechados;
	private LinkedList<Integer> caminhoMin;
	
	private Grafo grafo; 
	
	
	public Dijkstra(int matriz[][], int nDeNos) {
		caminhoMin = new LinkedList<Integer>();
		listaDeAdjacencia = new ArrayList<Vertice>();
		fechados = new ArrayList<Vertice>();
		
		grafo = new Grafo(matriz, nDeNos);
		abertos = grafo.vertices;
		
	}
	
	public void inicializa(int origem) {
		grafo.vertices.get(origem).distOrigem = 0;
		
		
		Iterator<Vertice> itr = abertos.iterator();
		
		while(itr.hasNext()) {
			Vertice u = abertos.get(0);
			
			for(int i = 0; i < grafo.getVizinhos(u).size(); i++) {
				relaxamento(u, grafo.getVizinhos(u).get(i));
			}
			
			fechados.add(abertos.get(0));
			abertos.remove(0);
		}
			
			
			
		for(int i = 0; i < caminhoMin.size(); i++) {
			System.out.println(caminhoMin.get(i));
		}
	}
	
	public void relaxamento(Vertice u, Vertice v) {
		
		if(v.distOrigem > (u.distOrigem + grafo.getPeso(u.id, v.id))) {
			v.distOrigem = u.distOrigem + v.distOrigem;	
			v.antecessor = u.id;
			caminhoMin.add(v.id);
		}
		
	}
	
	
}
