package helpers;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import model.DadosDiarios;


public class Questao_3_Helper {
	
	

	public static void getDiasSuprioresAmedia(List<Double> ganhosDiarios) {
		Double media = ganhosDiarios.stream().mapToDouble((n)-> n ).average().getAsDouble();
		int diasSuperioresAMedia = 0;
		for (Double valor : ganhosDiarios) {
			if (valor > media) {
				diasSuperioresAMedia +=1;
			}
		}
		System.out.println("Dias superiores a média: "+ diasSuperioresAMedia);
	}

	public static void ganhoTotal(Collection<DadosDiarios> dadosDiarios) {
		List<Double> ganhosLista = getValoresToList(dadosDiarios);
		Double soma = ganhosLista.stream()
				.reduce(0.0, Double::sum);
			
		DecimalFormat df = new DecimalFormat("#,###.00");
		System.out.println(" soma total: "+df.format(soma));
	}

	public static void getMaiorValor(Collection<DadosDiarios> dadosDiarios, Comparator<DadosDiarios> filtroValor) {
		DadosDiarios menorValor = dadosDiarios.stream().min(filtroValor).get();
		System.out.println(menorValor);
	}

	public static void getMenorValor(Collection<DadosDiarios> dadosDiarios, Comparator<DadosDiarios> filtroValor) {
		DadosDiarios maiorValor = dadosDiarios.stream().max(filtroValor).get();
		System.out.println(maiorValor);
	}

	public static List<Double> getValoresToList(Collection<DadosDiarios> valores) {
		List<Double> ganhosLista = new ArrayList<>();
		valores.forEach((valor) -> {
			Double ganhos = valor.getValor();
			ganhosLista.add(ganhos);
			
		});
		return ganhosLista;
	}

	public static Collection<DadosDiarios> getJsonToList(Gson gson, String file) throws FileNotFoundException {
		BufferedReader br = new BufferedReader(new FileReader(file));
		
		TypeToken<Collection<DadosDiarios>> collectionType = new TypeToken<Collection<DadosDiarios>>(){};
		Collection<DadosDiarios> dadosDiarios = gson.fromJson(br, collectionType);
		return dadosDiarios;
	}

	public static Comparator<DadosDiarios> compararValores() {
		Comparator<DadosDiarios> filtroValor = (valor1, valor2) -> {
			if (valor1.getValor() > 0 &  valor2.getValor() > 0) {
				if (valor1.getValor() > valor2.getValor()) {
					return 1;
				}
				if (valor1.getValor() < valor2.getValor()) {
					if (valor1.getValor() < 0 & valor2.getValor() < 0) {
					}
					return -1;
				}
			}
			return 0;
		};
		return filtroValor;
	}

	public Questao_3_Helper() {
		super();
	}

}