import java.awt.List;
import java.util.ArrayList;

public class Grafo {
	
	private int[][] vertexMatrix;
	private int nOfVertices;
	public ArrayList<Vertice> vertices;
	
	
	public Grafo(int[][] vertexMatrix, int nOfVertices) {
		this.vertexMatrix = vertexMatrix;
		this.nOfVertices = nOfVertices;
	
		initVertexArray();
	}
	
	public void initVertexArray() {
		vertices = new ArrayList<Vertice>();
		for(int i = 0; i < nOfVertices; i++) {
			vertices.add(new Vertice(i));
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
	
	public int getDistancia(int v1, int v2) {
		return vertexMatrix[v1][v2];
	}
	
	/*
	 * retorna a lista de adjacencia do no
	 */
	public ArrayList<Integer> getVizinhos(int vertice){
		ArrayList<Integer> vizinhos = new ArrayList<>();
		
		for(int i = 0; i < nOfVertices; i++) {
			if(vertexMatrix[vertice][i] > 0) {
				vizinhos.add(i);
			}
		}
		
		return vizinhos;
	}
	
	
}
