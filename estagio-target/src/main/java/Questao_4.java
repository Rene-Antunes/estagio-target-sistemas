import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.List;

import com.google.gson.Gson;

import helpers.Questao_4_Helper;
import model.EstatisticaVenda;


public class Questao_4 {
	
	public static void main(String[] args) {
		Questao_4_Helper questao_4_Helper = new Questao_4_Helper();
		Gson gson = new Gson();
		try {
			Collection<EstatisticaVenda> estatisticas = questao_4_Helper.getJsonToList(gson , "src/main/java/json/EstatisticaDeVenda.json");
			List<Double> valores = questao_4_Helper.getValoresToList(estatisticas);
			
			System.out.println("Percentual de ganhos por estado: \n");
			
			questao_4_Helper.getPercentual(estatisticas, valores);
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
	 		}
	}
}
