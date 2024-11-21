package br.bucker.bits;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.bucker.bits.exceptions.UnsupportedMathOperationException;

@RestController
public class CalculadoraController {

	private static final String template = "Sua %s é: %s!";

	@GetMapping("/soma/{numberOne}/{numberTwo}")
	public String soma(@PathVariable String numberOne, @PathVariable String numberTwo) throws Exception {
		return  String.format(template, "soma", validaNumero(numberOne) + validaNumero(numberTwo));
	}
	
	@GetMapping("/sub/{numberOne}/{numberTwo}")
	public String sub(@PathVariable String numberOne, @PathVariable String numberTwo) throws Exception {
		return  String.format(template, "subtração", validaNumero(numberOne) - validaNumero(numberTwo));
	}
	
	@GetMapping("/mult/{numberOne}/{numberTwo}")
	public String mult(@PathVariable String numberOne, @PathVariable String numberTwo) throws Exception {
		return  String.format(template, "multiplicação", validaNumero(numberOne) * validaNumero(numberTwo));
	}
	
	@GetMapping("/div/{numberOne}/{numberTwo}")
	public String div(@PathVariable String numberOne, @PathVariable String numberTwo) throws Exception {
		return  String.format(template, "divisão", validaNumero(numberOne) / validaNumero(numberTwo));
	}
	
	@GetMapping("/med/{numberOne}/{numberTwo}")
	public String med(@PathVariable String numberOne, @PathVariable String numberTwo) throws Exception {
		return  String.format(template, "media", (validaNumero(numberOne) + validaNumero(numberTwo)) / 2);
	}
	
	@GetMapping("/raiz/{numberOne}")
	public String raiz(@PathVariable String numberOne) throws Exception {
		return  String.format(template, "raiz quadrada", Math.sqrt(validaNumero(numberOne)));
	}

	private Double validaNumero(String strNumber) throws Exception {
		if (strNumber == null)
			return 0D;
		
		if (!isNumber(strNumber)) {
			throw new UnsupportedMathOperationException("Precisam ser numeros para a operação!");
		} else {
			strNumber.replaceAll(",", ".");
		}
		return converteDouble(strNumber);
	}

	private Double converteDouble(String strNumber) {		
		return Double.parseDouble(strNumber);
	}

	private boolean isNumber(String strNumber) {
		return strNumber.matches("[-+]?[0-9]*\\.?[0-9]+");
	}
}
