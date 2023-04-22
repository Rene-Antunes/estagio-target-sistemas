package helpers;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import model.EstatisticaVenda;


public class Questao_4_Helper {

	public void getPercentual(Collection<EstatisticaVenda> estatisticas, List<Double> valores) {
		Double ganhoTotal = ganhoTotal(estatisticas);
		
		for (Double valor : valores) {
			DecimalFormat df = new DecimalFormat("#.##");
			Double porcentagem =  (valor / ganhoTotal)*100;
			System.out.println(" Porcetagem: "+df.format(porcentagem) + "%");
		}
	}

	public Collection<EstatisticaVenda> getJsonToList(Gson gson, String file) throws FileNotFoundException {
		
		BufferedReader br = new BufferedReader(new FileReader(file));
		
		TypeToken<Collection<EstatisticaVenda>> collectionType = new TypeToken<Collection<EstatisticaVenda>>(){};
		Collection<EstatisticaVenda> dadosDiarios = gson.fromJson(br, collectionType);
		return dadosDiarios;
	}

	public List<Double> getValoresToList(Collection<EstatisticaVenda> valores) {
		List<Double> ganhosLista = new ArrayList<>();
		valores.forEach((valor) -> {
			Double ganhos = valor.getGanho();
			ganhosLista.add(ganhos);
			
		});
		return ganhosLista;
	}

	public Double ganhoTotal(Collection<EstatisticaVenda> dadosDiarios) {
		List<Double> ganhosLista = getValoresToList(dadosDiarios);
		Double soma = ganhosLista.stream()
				.reduce(0.0, Double::sum);
		return soma;
	}

}
