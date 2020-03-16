
public class QuickSort {
	private int sort(int ar[], int lower, int higher) {
		int i = lower - 1;
		
		int pivot = ar[higher];
		
		for(int j = lower; j < higher; j++) {
			
			if(ar[j] < pivot) {
				i++;
				Principal.swap(ar, i, j);
			}
			
		}
		
		//Troca o pivot de lugar com o elemento do array apos o indice i
		//Apos a troca, o pivot estará ordenado
		Principal.swap(ar, i+1, higher);
		
		return i+1;
	}
	
	
	
	public void quickSort(int ar[], int lower, int higher) {
		
		//Chamada recursiva
		if(lower < higher) {
			
			int sorted = sort(ar, lower, higher);
			
			//Recursivamente ordena os indices antes e depois do pivot recém ordenado
			quickSort(ar, lower, sorted-1);
			quickSort(ar, sorted+1, higher);
			
		}
		
	}
}
