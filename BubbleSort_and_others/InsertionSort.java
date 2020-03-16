
public class InsertionSort {
	public void insertionSort(int ar[]) {
		
		for(int i = 0; i < ar.length; i++) {
			int j = i;
			
			while(j > 0 && ar[j-1] > ar[j]) {
				Principal.swap(ar, j, j-1);
				j--;
			}
			
		}

	}
}
