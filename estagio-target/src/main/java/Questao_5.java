
public class Questao_5 {
	public static void main(String[] args) {
		    
		    String reverter = "Taget Sistemas";
		    System.out.println(reverter);
		    
		    char[] ch = reverter.toCharArray();
		    int inicio = 0;
		    int fim = ch.length -1;
		    char ord;
		    
		    while(fim > inicio) {
		    	ord = ch[inicio];
		    	ch[inicio] = ch[fim];
		    	ch[fim] = ord;
		    	fim--;
		    	inicio++;
		    	
		    }
		    
		    reverter = new String(ch);
		    System.out.println(reverter);
		    
		    
			
		}
}
