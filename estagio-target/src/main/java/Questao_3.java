import java.io.IOException;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

import com.google.gson.Gson;

import helpers.Questao_3_Helper;
import model.DadosDiarios;

public class Questao_3{
	public static void main(String[] args) {
		Questao_3_Helper questao_3_Helper = new Questao_3_Helper();
		Gson gson = new Gson();
		try {
			Collection<DadosDiarios> dadosDiarios = questao_3_Helper.getJsonToList(gson , "src/main/java/json/dados.json");
			Comparator<DadosDiarios> comparador = questao_3_Helper.compararValores();
			List<Double> ganhosDiarios = questao_3_Helper.getValoresToList(dadosDiarios);

			System.out.println("Maior faturamento");
			questao_3_Helper.getMaiorValor(dadosDiarios, comparador);
			System.out.println();
			
			System.out.println("Menor faturamento");
			questao_3_Helper.getMenorValor(dadosDiarios, comparador);
			System.out.println();

			System.out.println("Valor total de faturamento");
			questao_3_Helper.ganhoTotal(dadosDiarios);
			System.out.println();
			questao_3_Helper.getDiasSuprioresAmedia(ganhosDiarios);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
