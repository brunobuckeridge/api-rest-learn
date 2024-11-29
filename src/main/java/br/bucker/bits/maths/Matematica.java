package br.bucker.bits.maths;

@Deprecated
public class Matematica {

	//Usado para estudo, manter classe apenas como algo UTIL. Sem uso nos modulos mais avançados do curso.
	public Matematica() {
	}

	public Double soma(Double numberOne, Double numberTwo) throws Exception {
		return numberOne + numberTwo;
	}
	
	public Double sub(Double numberOne, Double numberTwo) throws Exception {
		return numberOne - numberTwo;
	}
	
	public Double mult(Double numberOne, Double numberTwo) throws Exception {
		return numberOne * numberTwo;
	}
	
	public Double div(Double numberOne, Double numberTwo) throws Exception {
		return numberOne / numberTwo;
	}
	
	public Double med(Double numberOne, Double numberTwo) throws Exception {
		return (numberOne + numberTwo) / 2;
	}
	
	public Double raiz(Double number) throws Exception {
		return Math.sqrt(number);
	}
}
