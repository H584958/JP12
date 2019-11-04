package no.hvl.dat100.jplab12.oppgave5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import no.hvl.dat100.jplab12.common.TODO;
import no.hvl.dat100.jplab12.oppgave1.*;
import no.hvl.dat100.jplab12.oppgave2.*;
import no.hvl.dat100.jplab12.oppgave3.*;

import javax.swing.JOptionPane;

public class LesBlogg {

	private static String MAPPE = System.getProperty("user.dir") + "/src/no/hvl/dat100/jplab12/tests/";

	private static String TEKST = "TEKST";
	private static String BILDE = "BILDE";

	public static Blogg les(String filnavn) {
		Scanner leser = null;
		String[] tab = new String[1];
		Blogg pBlogg = null;

		try {
			File file = new File(MAPPE + filnavn);
			leser = new Scanner(file);
			int linjeNr = 0;
			String linje;
			while (leser.hasNextLine()) {
				linje = leser.nextLine();
				//System.out.println(linjeNr + ": " + linje);
				if (linjeNr + 1 > tab.length) {
					String[] itabClone = tab.clone();
					tab = new String[itabClone.length + 1];
					int i;
					for (i = 0; i < itabClone.length; i++) {
						tab[i] = itabClone[i];
					}
					tab[linjeNr] = linje;
					linjeNr++;
				} else {
					tab[linjeNr] = linje;
					linjeNr++;
				}
			}
			pBlogg = new Blogg(Integer.parseInt(tab[0]));
			for (int i = 1,k = 0; i < pBlogg.getSamling().length; i++) {
				if (tab[i].equals(TEKST)) {
					pBlogg.getSamling()[k] = new Tekst(Integer.parseInt(tab[i + 1]), tab[i + 2], tab[i + 3],
							Integer.parseInt(tab[i + 4]), tab[i + 5]);
					i += 6;
					k++;
				}
				if (tab[i].equals(BILDE)) {
					pBlogg.getSamling()[k] = new Bilde(Integer.parseInt(tab[i + 1]), tab[i + 2], tab[i + 3],
							Integer.parseInt(tab[i + 4]), tab[i + 5], tab[i + 6]);
					i += 7;
					k++;
				}
			}

			for (int i = 0; i < pBlogg.getSamling().length; i++) {
				pBlogg.leggTil(pBlogg.getSamling()[i]);
			}
		} catch (FileNotFoundException e) {
			return null;
		} finally {
			if (leser != null) {
				leser.close();
				return pBlogg;
			}
		}
		return null;
	}
}
