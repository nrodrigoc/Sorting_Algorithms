
public class SelectionSort {
	public void selectionSort(int ar[]) {
		
		for(int i = 0; i < ar.length; i++) {
			int j = i;
			int aux = i;
			while(j < ar.length) {
				if(ar[j] < ar[aux]) {
					aux = j;
				}
				
				j++;
			}
			
			if(aux != i)
				Principal.swap(ar, i, aux);
			
		}
	}
}
