package br.bucker.bits;

public class Inicializacao {

	private final long id;
	private final String content;
	
	public Inicializacao(long id, String content) {
		this.id = id;
		this.content = content;
	}

	public long getId() {
		return id;
	}
	
	public String getContent() {
		return content;
	}
	
}
