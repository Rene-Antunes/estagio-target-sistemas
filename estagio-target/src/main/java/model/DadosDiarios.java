package model;


public class DadosDiarios {
	
	private Integer dia;
	private Double valor;
	public Integer getDia() {
		return dia;
	}
	@Override
	public String toString() {
		return String.format(" Dia: %o \n Valor: %.2f", dia, valor);
	}
	public void setDia(Integer dia) {
		this.dia = dia;
	}
	public Double getValor() {
		if (valor > 0) {
			return valor;
		}
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	
	
	
}
