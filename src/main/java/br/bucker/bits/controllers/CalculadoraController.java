package br.bucker.bits.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.bucker.bits.maths.Matematica;
import br.bucker.bits.utils.DoubleUtils;

@RestController
public class CalculadoraController {

	private static final String template = "Sua %s é: %s!";
	private Matematica math = new Matematica();
	
	@GetMapping("/soma/{numberOne}/{numberTwo}")
	public String soma(@PathVariable String numberOne, @PathVariable String numberTwo) throws Exception {
		return  String.format(template, "soma", math.soma(DoubleUtils.validaNumero(numberOne), DoubleUtils.validaNumero(numberTwo)));
	}
	
	@GetMapping("/sub/{numberOne}/{numberTwo}")
	public String sub(@PathVariable String numberOne, @PathVariable String numberTwo) throws Exception {
		return  String.format(template, "subtração", math.sub(DoubleUtils.validaNumero(numberOne), DoubleUtils.validaNumero(numberTwo)));
	}
	
	@GetMapping("/mult/{numberOne}/{numberTwo}")
	public String mult(@PathVariable String numberOne, @PathVariable String numberTwo) throws Exception {
		return  String.format(template, "multiplicação", math.mult(DoubleUtils.validaNumero(numberOne), DoubleUtils.validaNumero(numberTwo)));
	}
	
	@GetMapping("/div/{numberOne}/{numberTwo}")
	public String div(@PathVariable String numberOne, @PathVariable String numberTwo) throws Exception {
		return  String.format(template, "divisão", math.div(DoubleUtils.validaNumero(numberOne), DoubleUtils.validaNumero(numberTwo)));
	}
	
	@GetMapping("/med/{numberOne}/{numberTwo}")
	public String med(@PathVariable String numberOne, @PathVariable String numberTwo) throws Exception {
		return  String.format(template, "media", math.med(DoubleUtils.validaNumero(numberOne), DoubleUtils.validaNumero(numberTwo)));
	}
	
	@GetMapping("/raiz/{number}")
	public String raiz(@PathVariable String number) throws Exception {
		return  String.format(template, "raiz quadrada", math.raiz(DoubleUtils.validaNumero(number)));
	}
}
