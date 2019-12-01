public class HeapMin {
	
	public Vertice heap[];
	
	public HeapMin(Vertice[] heap) {
		this.heap = heap;
		heapSort();
		
	}
	
	public void buildHeapMin() {
		int tam = heap.length;
		
		//Partindo da metade do array, monta a heap
		for(int i = tam/2 - 1; i >= 0; i--)
			minHeapify(tam, i);
	}
	
	public void swap(int i, int menor) {
		Vertice aux = heap[i];
		heap[i] = heap[menor];
		heap[menor] = aux;
	}
	
	
	public void minHeapify(int treeSize, int rootIndex) {
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
			
			minHeapify(treeSize, menor);
		}
			
	}
	
	
	public void heapSort() {
		int tam = heap.length;
		buildHeapMin();
		
		for(int i = tam - 1; i >= 0; i--) {
			
			//Manda o maior elemento(raiz) pro final do array
			swap(0, i);
			
			//Reconstroi a heap sem contar o ultimo elemento
			minHeapify(i, 0);
		}
	}
	
	public Vertice extractMin() {
		Vertice min = heap[0];
		Vertice ultimo = heap[heap.length-1];
		
		
		
		if(heap.length < 1) {
			System.out.println("Nao existe minimo");
			return null;
		}

		
		return min;
		
	}
	
	public Vertice[] getHeap() {
		for(int i = 0; i < heap.length; i++) {
			System.out.println(heap[i]);
		}
		return heap;
	}
	
}
