package br.com.campeonato;

import java.util.ArrayList;
import java.util.Random;

public class Campeonato {
	
	private ArrayList<Clube> clubes = new ArrayList<Clube>();
	
	public void jogarCampeonato() {
		
	}
	
	private void jogarPartida(Clube m, Clube v) {
		Random rn = new Random();
		
		int golsTime1 = rn.nextInt(5);
		int golsTime2 = rn.nextInt(5);
		int saldoGols = Math.abs(golsTime1 - golsTime2);
		
		if(golsTime1 > golsTime2) {
			m.ganhar(saldoGols);
			v.perder(saldoGols);
			System.out.println("Time " + m.getNome() + " ganhou");
			System.out.println("Placar de " + golsTime1 + " - " + golsTime2);
		}
		else if(golsTime1 < golsTime2) {
			m.perder(saldoGols);
			v.ganhar(saldoGols);
			System.out.println("Time " + v.getNome() + " ganhou");
			System.out.println("Placar de " + golsTime1 + " - " + golsTime2);
		} else {
			m.empatar();
			v.empatar();
			System.out.println("Empate");
			System.out.println("Placar de " + golsTime1 + " - " + golsTime2);
		}
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
