import java.util.Scanner;

public class Questao_2 {
	
	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Insira o número desejado: ");
		int numero = entrada.nextInt();
		
		int n1 = 0;
		int n2 = 1;
		int n3 = 0;
		
		while (numero > n3 ) {
			
			n3 = n1 + n2;
			n1 = n2;
			n2 = n3;
						
		}
		
		if (numero == 0 || numero == 1) {
			
			System.out.println("O número: " + numero + " faz parte da sequencia de Fibocci");
			
		}else if (numero == n3) {
			System.out.println("O número: " + numero + " faz parte da sequencia de Fibocci");
			
		} else {
			System.out.println("O número: " + numero + " não faz parte da sequencia de Fibocci");
			
		}
		
		entrada.close();
	
	
	}
	
	
}
