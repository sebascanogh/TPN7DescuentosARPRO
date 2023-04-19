package paquetetpn7;

public class DescuentoPorcentaje extends Descuento {
	public double valorFinal(double valorInicial) {
		return valorInicial - (valorInicial * this.dameValorDesc());
		
	}
	
}



