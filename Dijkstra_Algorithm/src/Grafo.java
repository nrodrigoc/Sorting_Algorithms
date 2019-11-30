import java.awt.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class Grafo {
	
	private int[][] vertexMatrix;
	private int nOfVertices;
	public Vertice[] vertices;
	
	
	public Grafo(int[][] vertexMatrix, int nOfVertices) {
		this.vertexMatrix = vertexMatrix;
		this.nOfVertices = nOfVertices;
	
		initVertexArray();
	}
	
	public void initVertexArray() {
		vertices = new Vertice[nOfVertices];
		for(int i = 0; i < nOfVertices; i++) {
			vertices[i] = new Vertice(i);
		}
	}
	
	
	/*
	 * v1 -> vertice1
	 * v2 -> vertice2
	 */
	/*public void removerAresta(int v1, int v2) {
		vertexMatrix[v1][v2] = 0;
		vertexMatrix[v2][v1] = 0;
	}*/
	
	public int getPeso(int v1, int v2) {
		return vertexMatrix[v1][v2];
	}
	
	/*
	 * retorna a lista de adjacencia do no
	 */
	public ArrayList<Vertice> getVizinhos(Vertice vertice){
		ArrayList<Vertice> vizinhos = new ArrayList<>();
		
		for(int i = 0; i < vertices.length; i++) {
			if(vertexMatrix[vertice.id][i] > 0) {
				vizinhos.add(vertices[i]);
			}
		}
		
		return vizinhos;
	}
	
	
}
