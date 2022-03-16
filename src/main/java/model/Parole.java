package model;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Parole {
	
	private String parola;
	private Set<String> parole = new HashSet<String>();
	
	
	public Parole(String parola) {
		super();
		this.parola = parola;
	}

	public void aggiungiParole(String p) {
		parole.add(p);
	}
	
	
	public String getParola() {
		return parola;
	}

	public void setParola(String parola) {
		this.parola = parola;
	}

	public Set<String> getParole() {
		return parole;
	}

	public void setParole(Set<String> parole) {
		this.parole = parole;
	}



}
