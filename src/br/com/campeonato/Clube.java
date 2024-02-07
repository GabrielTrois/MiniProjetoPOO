package br.com.campeonato;

public class Clube {

	private String nome;
	private int pontos;
	private int saldoGols;
	
	public Clube(String nome) {
		this.nome = nome;
	}
	
	public void ganhar(int saldoGols) {
		
	}
	
	public void empatar() {
		
	}
	
	public void perder(int saldoGols) {
		
	}

	
	public String getNome() {
		return nome;
	}
	public int getPontos() {
		return pontos;
	}
	public int getSaldoGols() {
		return saldoGols;
	}
}
