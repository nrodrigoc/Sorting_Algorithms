
public class Heapsort {
	
	private int[] heap;
	
	public Heapsort(int ar[]) {
		heap = ar;
		sort();
	}
	
	public void buildHeapMax() {
		int tam = heap.length; //comprimento do array
		
		for (int i = tam / 2 - 1; i >= 0; i--) 
			maxHeapify(heap, tam, i); 
		
	}
	
	private void sort() {
		int tam = heap.length; //comprimento do array
	
		buildHeapMax();
		
		//A cada iteração, diminui o tamanho do heap (não seu tamanho real)
		for(int i = tam-1 ; i >= 0; i--) {
			
			//Troca a ultima folha de lugar com a raiz
			int aux = heap[0];
			heap[0] = heap[i];
			heap[i] = aux;
			
			//Realiza o maxHeapify em cada sub-árvore
			maxHeapify(heap, i, 0);
		}
		
		
	}
	
		
	public void maxHeapify(int ar[], int subtreeSize, int subtreeRoot) {
		int maior = subtreeRoot;
		int l = 2*subtreeRoot + 1;
		int r = 2*subtreeRoot + 2;
		
		//A instrução à esquerda do if verifica se existe filho à esquerda
		if(l < subtreeSize && ar[l] > ar[maior])
			maior = l;
		
		//A instrução à esquerda do if verifica se existe filho à direita
		if(r < subtreeSize && ar[r] > ar[maior])
			maior = r;
		
		//Se o maior nó não é mais a raiz da sub árvore...
		if(maior != subtreeRoot) {
			//trocar de lugar os valores do maior nó e da raíz da sub árvore
			int aux = ar[subtreeRoot];
			ar[subtreeRoot] = ar[maior];
			ar[maior] = aux;
			
			//repete o processo com a nova raiz da sub árvore
			maxHeapify(ar, subtreeSize, maior);	
		}
			
	}
	
	public static void printArray(int ar[]) {
		for(int i = 0; i < ar.length; i++) {
			System.out.println("ar["+i+"] = " + ar[i]);
		}
	}
	
	
	public int[] getHeap() {
		return heap;
	}
	
	
	public static void main(String args[]) 
    { 
        int ar[] = {7, 2, 5, 3, 0}; 
        System.out.println("O array original é: ");
        printArray(ar);
        
        
        Heapsort ob = new Heapsort(ar); 
        ar = ob.getHeap();
        System.out.println("\nO array organizado é: ");
        printArray(ar);
    }
}
