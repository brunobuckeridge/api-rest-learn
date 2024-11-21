package br.bucker.bits;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InicializacaoController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/ola")
	public Inicializacao init(@RequestParam(defaultValue = "World") String name) {
		return new Inicializacao(counter.incrementAndGet(), String.format(template, name));
	}
}
