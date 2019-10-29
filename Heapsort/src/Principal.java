import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;

public class Principal {
	
	private static int heap[]; 
	
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
		
		String directory = Principal.class.getResource(filename).toString();
		
		if(directory != null)
			directory = directory.replace("file:/", "");
		else {
			System.out.println("Arquivo inexistente");
			System.exit(-1);
		}
			
		
		System.out.println("Diretorio do arquivo: \n" + directory);
		System.out.println();
		
		int size = 0;
		System.out.println("Instancia numerica: \n");
		try {
			BufferedReader br = new BufferedReader(new FileReader(directory));
			
			size = Integer.parseInt(br.readLine().toString());
			heap = new int[size];
			
			int index = 0;
			
			while(br.ready()) {
		        String linha = br.readLine();
		        int i = Integer.parseInt(linha);
		        heap[index++] = i;
		        System.out.println(i);
		     }
		     br.close();
		     
		} catch (IOException e) {
			System.out.println("Arquivo nao encontrado!");
			e.printStackTrace();
		}
		
		
		
		System.out.println("\nTamanho do array:" + size);
		System.out.println(heap[9999]);  
 
        Heapsort ob = new Heapsort(heap); 
        heap = ob.getHeap();
        System.out.println("\nO array organizado eh: ");
        printArray(heap);
	}

}
