package no.hvl.dat100.jplab12.oppgave3;

import no.hvl.dat100.jplab12.common.TODO;
import no.hvl.dat100.jplab12.oppgave1.*;

public class Blogg {

	private Innlegg [] itab;
	private int nesteLedig;
	
	public Blogg() {
		itab = new Innlegg[20];
		nesteLedig=0;
	}

	public Blogg(int lengde) {
		itab = new Innlegg[lengde];
		nesteLedig=0;
	}

	public int getAntall() {
		return nesteLedig;
	}
	
	public Innlegg[] getSamling() {
		return itab;
	}
	
	public int finnInnlegg(Innlegg innlegg) {
		for (int i = 0; i < itab.length; i++) {
			if (itab[i] != null && innlegg.erLik(itab[i])) {
				return i;				
			}
		}
		return -1;
	}

	public boolean finnes(Innlegg innlegg) {
		return (finnInnlegg(innlegg) >= 0);
	}

	public boolean ledigPlass() {
		return nesteLedig < getSamling().length;
	}
	
	public boolean leggTil(Innlegg innlegg) {
		if (ledigPlass() && !finnes(innlegg)) {
			itab[nesteLedig]=innlegg;
			nesteLedig++;
			return true;
		}
		return false;
	}
	
	public String toString() {
		search("tekst");
		String str = getAntall()+"\n";
		for (int i = 0; i<itab.length; i++) {
					str += itab[i].toString();
		}
		return str;
	}
	
	public void utvid() {
		Innlegg [] itabClone = itab.clone(); 
		itab = new Innlegg [itab.length*2];
		for (int i = 0; i < itabClone.length; i++) {
			itab[i] = itabClone[i];
		}
	}
	
	public boolean leggTilUtvid(Innlegg innlegg) {
		if (!finnes(innlegg)) {
			if (!leggTil(innlegg)) {
				utvid();
				leggTil(innlegg);
				return true;
			}
			leggTil(innlegg);
			return true;
		}
		return false;
	}
	
	public boolean slett(Innlegg innlegg) {
		if (finnes(innlegg)) {
			int i = finnInnlegg(innlegg);
			Innlegg [] itabClone = itab.clone(); 
			itab = new Innlegg [itabClone.length-1];
			nesteLedig--;
			for (int j = 0, k = 0; j < itab.length; j++) {
				if (j == i) {
					continue;
				}
				itab[k] = itabClone[j];
				k++;
			}
			return true;
		}
		return false;
	}
	
	public int[] search(String keyword) {
		//som returnere en tabell av id'er på alle innlegg i bloggen der teksten
		//inneholder strengen angitt med parameteren ord.
		String tekst;
		for (int i = 0; i < itab.length; i++) {
			tekst = itab[i].toString();
			System.out.println(i + ": " + tekst);
			//for (j = 0; j) {
				
			//}
		}
		int [] hufie = {1,2,3,4};
		return hufie;
	}
	
}