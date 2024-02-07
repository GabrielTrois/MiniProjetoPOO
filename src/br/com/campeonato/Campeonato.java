package br.com.campeonato;

import java.util.ArrayList;

public class Campeonato {
	
	private ArrayList<Clube> clubes = new ArrayList<Clube>();
	
	public void jogarCampeonato() {
		
	}
	
	public void jogarPartida(Clube m, Clube v) {
		
	}
	
	public ArrayList<Clube> getClassificacao() {
		ArrayList<Clube> test = new ArrayList<Clube>();
		return test;
	}
	
	public Clube getCampeao() {
		Clube c = new Clube("test");
		return c;
	}

	
	public ArrayList<Clube> getClubes() {
		return clubes;
	}
	public void setClubes(ArrayList<Clube> clubes) {
		this.clubes = clubes;
	}
}
