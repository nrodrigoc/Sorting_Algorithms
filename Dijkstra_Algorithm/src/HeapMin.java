public class HeapMin {
	
	private int heap[];
	
	public HeapMin(int ar[]) {
		heap = ar;
		heapSort();
	}
	
	public void ordenaHeap() {
		int tam = heap.length;
		
		//Partindo da metade do array, monta a heap
		for(int i = tam/2 - 1; i >= 0; i--)
			constroiHeapMin(tam, i);
		
		
	}
	
	public void constroiHeapMin(int treeSize, int rootIndex) {
		//Root -> raiz da sub�rvore a ser analisada
		int menor = rootIndex;
		int leftSon = 2 * rootIndex + 1;
		int rightSon = 2 * rootIndex + 2;
		
		//a primeira condi��o verifica se a sub�rvore tem filho � esquerda
		if(leftSon < treeSize && heap[leftSon] < heap[menor])
			menor = leftSon;
		
		//a primeira condicao verifica se a subarvore tem filho � direita
		if(rightSon < treeSize && heap[rightSon] < heap[menor])
			menor = rightSon;
			
		if(menor != rootIndex) {
			int aux = heap[rootIndex];
			heap[rootIndex] = heap[menor];
			heap[menor] = aux;
			
			constroiHeapMin(treeSize, menor);
		}
			
	}
	
	
	public void heapSort() {
		int tam = heap.length;
		
		
		ordenaHeap();
		
		for(int i = tam - 1; i >= 0; i--) {
			
			//Manda o maior elemento(raiz) pro final do array
			int aux = heap[0];
			heap[0] = heap[i];
			heap[i] = aux;
			
			//Reconstroi a heap sem contar o 
			constroiHeapMin(i, 0);
		}
	
		
		
	}
	
	
	public int[] getHeap() {
		for(int i = 0; i < heap.length; i++) {
			System.out.println(heap[i]);
		}
		return heap;
	}
	
}
