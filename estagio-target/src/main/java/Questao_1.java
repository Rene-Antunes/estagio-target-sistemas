
public class Questao_1 {

	public static void main(String[] args) {
			
		imprimirSoma(0, 0, 13);			
	
	}
	
	public static void imprimirSoma(int k, int SOMA, int INDICE) {
			while (k < INDICE) {
				k = k + 1;
				SOMA = SOMA + k;
			}
		System.out.println(SOMA);
	}
}
