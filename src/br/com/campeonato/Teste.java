package br.com.campeonato;

import java.util.ArrayList;

public class Teste {

	public static void main(String[] args) {
		Clube c1 = new Clube("Flamengo");
		Clube c2 = new Clube("Vasco");
		Clube c3 = new Clube("Corinthians");
		Clube c4 = new Clube("Palmeiras");
		
		ArrayList<Clube> times = new ArrayList<Clube>();
		times.add(c1);
		times.add(c2);
		times.add(c3);
		times.add(c4);
		
		Campeonato campeaonato = new Campeonato(times);
		
		campeaonato.jogarCampeonato();
		
		Clube campeao = new Clube(null);
		campeao = campeaonato.getCampeao();
		System.out.println("E o campeão foi o: ");
		System.out.println(campeao.getNome() + " com " + campeao.getPontos() + " pontos\n");
		
		
		ArrayList<Clube> classificacao = new ArrayList<Clube>();
		classificacao = campeaonato.getClassificacao();
		System.out.println("A classificação foi: ");
		int i = 1;
		for(Clube x: classificacao) {
			System.out.println(i + " - " + x.getNome() + " com " + x.getPontos() + " pontos\n");
			i++;
		}

	}

}
