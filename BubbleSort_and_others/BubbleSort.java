
public class BubbleSort {
	
	public void bubbleSort(int ar[]) {
		
		for(int i = ar.length; i > 0; i--) {
		
			for(int j = 0; j < i - 1; j++) {
				
				if(ar[j] > ar[j+1]) {
					Principal.swap(ar, j, j+1);
				}
			}	
		}
	}
}
