import java.util.ArrayList;

public class Dijkstra {
	
	private int nDeNos;
	private int matrizAdjacente[][];
	private ArrayList<Integer> listaDeAdjacencia;
	
	public Dijkstra(int matriz[][], int nDeNos) {
		matrizAdjacente = matriz;
		this.nDeNos = nDeNos;
	}
}
