public class HeapMin {
	
	public Vertice heap[];
	
	public HeapMin(Grafo grafo) {
		heap = grafo.vertices;
		heapSort();
		
	}
	
	public void ordenaHeap() {
		int tam = heap.length;
		
		//Partindo da metade do array, monta a heap
		for(int i = tam/2 - 1; i >= 0; i--)
			constroiHeapMin(tam, i);
	}
	
	public void swap(int i, int menor) {
		int aux = heap[i].distOrigem;
		heap[i].distOrigem = heap[menor].distOrigem;
		heap[menor].distOrigem = aux;
	}
	
	
	public void constroiHeapMin(int treeSize, int rootIndex) {
		//Root -> raiz da subarvore a ser analisada
		int menor = rootIndex;
		int leftSon = 2 * rootIndex + 1;
		int rightSon = 2 * rootIndex + 2;
		
		//a primeira condi��o verifica se a sub�rvore tem filho � esquerda
		if(leftSon < treeSize && heap[leftSon].distOrigem < heap[menor].distOrigem)
			menor = leftSon;
		
		//a primeira condicao verifica se a subarvore tem filho � direita
		if(rightSon < treeSize && heap[rightSon].distOrigem < heap[menor].distOrigem)
			menor = rightSon;
			
		if(menor != rootIndex) {
			swap(rootIndex, menor);
			
			constroiHeapMin(treeSize, menor);
		}
			
	}
	
	
	public void heapSort() {
		int tam = heap.length;
		ordenaHeap();
		
		for(int i = tam - 1; i >= 0; i--) {
			
			//Manda o maior elemento(raiz) pro final do array
			swap(0, i);
			
			//Reconstroi a heap sem contar o 
			constroiHeapMin(i, 0);
		}
	}
	
	
	public Vertice[] getHeap() {
		for(int i = 0; i < heap.length; i++) {
			System.out.println(heap[i]);
		}
		return heap;
	}
	
}
