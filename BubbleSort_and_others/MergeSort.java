
public class MergeSort {
	
	private void merge(int ar[], int l, int m, int r) {
		
		int sizeL = m - l + 1;
		int sizeR = r - m;
		
		int lar[] = new int[sizeL]; //metade da esquerda do subarray
		int rar[] = new int[sizeR]; //metade da direita do subarray
		
		System.arraycopy(ar, l, lar, 0, sizeL);
		System.arraycopy(ar, m+1, rar, 0, sizeR);
		
		//Indice inicial de subdivisao do array
		int i = 0, j = 0;
		
		//Guarda a proxima posicao a ser ordenada no sub-array
		int aux = l;
		
		//Aqui comparamos o lado esquerdo e o lado direito de cada sub array
		while(i < sizeL && j < sizeR) {
			
			if(lar[i] <= rar[j]) {
				ar[aux] = lar[i];
				i++;
			}else {
				ar[aux] = rar[j];
				j++;
			}
			
			aux++;
		}
		
		//Adicionamos os subarrays já ordenados em seus respectivos índices no array principal
		while(i < sizeL) {
			ar[aux] = lar[i];
			i++;
			aux++;
		}
		
		while(j < sizeR) {
			ar[aux] = rar[j];
			j++;
			aux++;
		}
		
	}
	
	public void mergeSort(int ar[], int l, int r) {
		
		//Aqui dividimos o array em pedaços menores até que haja apenas 1 elemento em cada subarray
		if(l < r) { //Se o indice do fim eh maior que o do incio
			
			int m = (l + r) / 2;
			
			//Cada metade do array é mais uma vez partida ao meio recursivamente
			mergeSort(ar, l, m);
			mergeSort(ar, m+1, r);
			
			//Das menores partes para as maiores organizamos os subarrays
			merge(ar, l, m, r);
		}
	}
}
