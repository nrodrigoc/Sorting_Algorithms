
public class Principal {
	
	public static void swap(int ar[], int p1, int p2) {
		int aux = ar[p1];
		ar[p1] = ar[p2];
		ar[p2] = aux;
	}
	
	
	public static void main(String[] args) {
		int ar[][] = {{3, 2, 4, 3, 9, 8, 1},
					{7, 21, 24, 33, 9, 11},
					{31, 12, 42, 33, 4, 2, 12, 92, 81, 15}};
		
		BubbleSort ms = new BubbleSort();
		
		for(int i = 0; i < ar.length; i++) {
			ms.bubbleSort(ar[i]);
		}
		
		
		for(int i = 0; i < ar.length; i++) {
			for(int j = 0; j < ar[i].length; j++)
				System.out.print(ar[i][j] + " ");
			System.out.println();
		}
		
	}
}
