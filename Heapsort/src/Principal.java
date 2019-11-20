import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Principal {
	
	private static int heap[]; 
	
	public static void printArray(int heap[]) {
		System.out.println("Enter the file name: ");
		Scanner ler = new Scanner(System.in);
		String nome = ler.next();
		ler.close();
		
		try {
			String destiny = new File(".").getCanonicalPath();
			destiny = destiny.replace("\\", "/");
			destiny = destiny + "/output/" + nome + ".in";
			System.out.println("The file is in the following directory: \n" + destiny);
			
			FileWriter arq = new FileWriter(destiny);
			PrintWriter gravarArq = new PrintWriter(arq);
			
			for(int i = 0; i < heap.length; i++) {
				gravarArq.printf("%d%n", heap[i]);
			}
			
			arq.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		String filename = args[0];
		
		String directory = Principal.class.getResource(filename).toString();
		
		if(directory != null)
			directory = directory.replace("file:/", "");
		else {
			System.out.println("Arquivo inexistente");
			System.exit(-1);
		}
			
		
		System.out.println("File directory: \n" + directory + "\n");
		
		int size = 0; // tamanho do array
		try {
			BufferedReader br = new BufferedReader(new FileReader(directory));
			
			//Interpreta a primeira linha do arquivo como o tamanho do array
			if(br.ready())
				size = Integer.parseInt(br.readLine().toString());
			heap = new int[size];
			
			int index = 0;
			
			while(br.ready()) {
		        String linha = br.readLine();
		        int i = Integer.parseInt(linha);
		        heap[index++] = i;
		     }
		     br.close();
		     
		} catch (IOException e) {
			System.out.println("Enter a valid directory and file!");
			e.printStackTrace();
		}
		
 
        Heapsort ob = new Heapsort(heap); 
        heap = ob.getHeap();
        printArray(heap);
	}

}
