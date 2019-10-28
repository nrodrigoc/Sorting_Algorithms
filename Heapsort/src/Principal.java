public class Principal {

	public static void printArray(int ar[]) {
		for(int i = 0; i < ar.length; i++) {
			System.out.println("ar["+i+"] = " + ar[i]);
		}
	}
	
	
	public static void main(String[] args) {
		
		if(args.length > 1) {
			System.out.println("Ta errado isso ai irmao");
			System.exit(-1);
		}
		
		String filename = args[0];
		System.out.println(filename);
		
        /*for(String arg : args)
            System.out.println(arg) ;*/
		
        
        
        int ar[] = {7, 2, 5, 3, 0}; 
        System.out.println("O array original eh: ");
        printArray(ar);
        
        
        Heapsort ob = new Heapsort(ar); 
        ar = ob.getHeap();
        System.out.println("\nO array organizado eh: ");
        printArray(ar);
	}

}
