import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Principal {
	
	private static int matriz[][]; 
	
	public static void printArray(int heap[]) {
		System.out.println("Enter file name: ");
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
			matriz = new int[size][size];
			
			int index = 0;
			for(int i = 0; i < size; i++) {
				matriz[i][i] = 0;
			}
			
			int colunaAtual = size - 1;
			
			while(br.ready()) {
		        String linha = br.readLine();
		        String numeros[] = linha.split(" ");
		        for(int line = numeros.length-1; line >= 0; line--) {
		        	matriz[line][colunaAtual] = Integer.parseInt(numeros[line]);
		        	matriz[colunaAtual][line] = Integer.parseInt(numeros[line]);
		        }
		        colunaAtual--;
		     }
		     br.close();
		     
		} catch (IOException e) {
			System.out.println("Enter a valid directory and file!");
			e.printStackTrace();
		}
		
		
		for(int j = 0; j < size; j++) {
			System.out.println();
			for(int i = 0; i < size; i++) {
				System.out.print(matriz[i][j] + " ");
			}
		}
 
        /*Dijkstra ob = new Dijkstra(matriz); 
        heap = ob.getHeap();
        printArray(heap);*/
	}

}
