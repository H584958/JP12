package no.hvl.dat100.jplab12.oppgave2;

import no.hvl.dat100.jplab12.common.TODO;

public class Bilde extends Tekst {

	String url;
	
	public Bilde(int id, String bruker, String dato, String tekst, String url) {
		super(id,bruker,dato,tekst);
		this.url = url;
	}

	public Bilde(int id, String bruker, String dato, int likes, String tekst, String url) {
		super(id,bruker,dato,likes,tekst);
		this.url = url;
	}
	
	public String getUrl() {
		return this.url;

	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {

		String str = "BILDE" + "\n"+ super.getId() + "\n" + super.getBruker() + "\n" + super.getDato() + "\n" + super.getLikes() + "\n" +super.getTekst() + "\n" +  this.url + "\n";
		return str;

	}

	// Metoden nedenfor er kun for valgfri oppgave 6
	public String toHTML() {
		
		throw new UnsupportedOperationException(TODO.method());
				
	}
}
