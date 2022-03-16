package model;

import java.util.Map;
import java.util.TreeMap;

public class Model {
	
	private Map<String,Parole> paroleTradotte = new TreeMap<String,Parole>();
	
	
	public void aggiungiAlDizionario(String aliena, String tradotta) {
		 if(paroleTradotte.containsKey(aliena) == false) {
			 Parole p = new Parole(aliena);
			 p.aggiungiParole(tradotta);
			 paroleTradotte.put(aliena, p);
			 return;
		 } else {
			 paroleTradotte.get(aliena).aggiungiParole(tradotta);
		 }
	}
	
	public String traduci(String s) {
		if (s.contains("?")) {
			String input = s.replace("?", ".");
			String ss = "";
			for (Parole r : paroleTradotte.values()) {
				if (r.getParola().matches(input)) {
					for (String m : r.getParole()) {
						ss += m + "\n";
					}
				}
			}
			return ss;
		}

		if (paroleTradotte.containsKey(s) == false) {
			return "Parola ancora non inserita nel dizionario";
		}

		String ss = "";
		for (String r : paroleTradotte.get(s).getParole()) {
			ss += r + "\n";
		}
		return ss;
	}
	
	
}
