public class Heapsort {
	
	private int heap[];
	
	public Heapsort(int ar[]) {
		heap = ar;
		heapSort();
	}
	
	public void ordenaHeap() {
		int tam = heap.length;
		
		//Partindo da metade do array, monta a heap
		for(int i = tam/2 - 1; i >= 0; i--)
			constroiHeapMax(tam, i);
		
		
	}
	
	public void constroiHeapMax(int treeSize, int rootIndex) {
		//Root -> raiz da sub�rvore a ser analisada
		int maior = rootIndex;
		int leftSon = 2 * rootIndex + 1;
		int rightSon = 2 * rootIndex + 2;
		
		//a primeira condi��o verifica se a sub�rvore tem filho � esquerda
		if(leftSon < treeSize && heap[leftSon] < heap[maior])
			maior = leftSon;
		
		//a primeira condicao verifica se a subarvore tem filho � direita
		if(rightSon < treeSize && heap[rightSon] < heap[maior])
			maior = rightSon;
			
		if(maior != rootIndex) {
			int aux = heap[rootIndex];
			heap[rootIndex] = heap[maior];
			heap[maior] = aux;
			
			constroiHeapMax(treeSize, maior);
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
			constroiHeapMax(i, 0);
		}
	
		
		
	}
	
	
	public int[] getHeap() {
		for(int i = 0; i < heap.length; i++) {
			System.out.println(heap[i]);
		}
		return heap;
	}
	
}
