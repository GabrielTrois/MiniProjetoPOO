package br.com.campeonato;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Campeonato {
	
	private ArrayList<Clube> clubes = new ArrayList<Clube>();
	
	public Campeonato(ArrayList<Clube> c) {
		this.clubes = c;
	}
	
	public void jogarCampeonato() {
		sorteiaTimes();
		
		int i;
		
		System.out.println("Primeiro Grupo\n");
		
		for(i = 1; i <= clubes.size(); i+=2) {
			System.out.println("" + this.clubes.get(i-1).getNome() + " X " + this.clubes.get(i).getNome());
			jogarPartida(this.clubes.get(i-1),this.clubes.get(i));
			System.out.println();
		}
		for(i = 1; i <= clubes.size(); i+=2) {
			System.out.println("" + this.clubes.get(i).getNome() + " X " + this.clubes.get(i-1).getNome());
			jogarPartida(this.clubes.get(i),this.clubes.get(i-1));
			System.out.println();
		}
		
		System.out.println("Segundo Grupo\n");
		
		int j = clubes.size()-1;
		
		for(i = 1; i <= clubes.size()/2; i++) {
			System.out.println("" + this.clubes.get(i-1).getNome() + " X " + this.clubes.get(j).getNome());
			jogarPartida(this.clubes.get(i-1),this.clubes.get(j));
			System.out.println();
			j--;
		}
		j = clubes.size()-1;
		for(i = 1; i <= clubes.size()/2; i++) {
			System.out.println("" + this.clubes.get(j).getNome() + " X " + this.clubes.get(i-1).getNome());
			jogarPartida(this.clubes.get(j),this.clubes.get(i-1));
			System.out.println();
			j--;
		}
		
		System.out.println("Terceiro Grupo\n");
		
		for(i = 1; i <= clubes.size()/2; i++) {
			System.out.println("" + this.clubes.get(i-1).getNome() + " X " + this.clubes.get(i+(clubes.size()/2)-1).getNome());
			jogarPartida(this.clubes.get(i-1),this.clubes.get(i+(clubes.size()/2)-1));
			System.out.println();
		}
		for(i = 1; i <= clubes.size()/2; i++) {
			System.out.println("" + this.clubes.get(i+(clubes.size()/2)-1).getNome() + " X " + this.clubes.get(i-1).getNome());
			jogarPartida(this.clubes.get(i+(clubes.size()/2)-1),this.clubes.get(i-1));
			System.out.println();
		}
	}
	
	private void jogarPartida(Clube m, Clube v) {
		Random rn = new Random();
		
		int golsTime1 = rn.nextInt(5);
		int golsTime2 = rn.nextInt(5);
		int saldoGols = Math.abs(golsTime1 - golsTime2);
		
		if(golsTime1 > golsTime2) {
			m.ganhar(saldoGols);
			v.perder(saldoGols);
			System.out.println("" + m.getNome() + " ganhou");
			System.out.println("Placar de " + golsTime1 + " - " + golsTime2);
		}
		else if(golsTime1 < golsTime2) {
			m.perder(saldoGols);
			v.ganhar(saldoGols);
			System.out.println("" + v.getNome() + " ganhou");
			System.out.println("Placar de " + golsTime1 + " - " + golsTime2);
		} else {
			m.empatar();
			v.empatar();
			System.out.println("Empate");
			System.out.println("Placar de " + golsTime1 + " - " + golsTime2);
		}
	}
	
	private void sorteiaTimes() {
		ArrayList<Clube> copia = new ArrayList<Clube>();
		ArrayList<Clube> lista = new ArrayList<Clube>();
		copia = this.clubes;
		
		Random rn = new Random();
		
		for(int i = copia.size()-1; i >= 0; i--) {
			int rand = rn.nextInt(i+1);
			lista.add(copia.get(rand));
			copia.remove(rand);
		}
		this.clubes = lista;
	}
	
	public ArrayList<Clube> getClassificacao() {
		ArrayList<Clube> test = new ArrayList<Clube>();
		
		test = this.clubes;
		
		Collections.sort(test, Comparator.comparing(Clube::getPontos));
		
		Collections.reverse(test);
		
		for (int i = 1; i < test.size()-1; i++) {
			if(test.get(0).getPontos() == test.get(i).getPontos()) {
				if(test.get(0).getSaldoGols() > test.get(i).getSaldoGols()) {
					test.get(0).empatar();
				} else {
					test.get(i).empatar();
				}
			}
		}
		
		return test;
	}
	
	public Clube getCampeao() {
		Clube c = new Clube(null);
		c = getClassificacao().get(0);
		return c;
	}

	
	public ArrayList<Clube> getClubes() {
		return clubes;
	}
	public void setClubes(ArrayList<Clube> clubes) {
		this.clubes = clubes;
	}
}
