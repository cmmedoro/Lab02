package it.polito.tdp.alien.model;

import java.util.*;

public class Traduzione {
	
	private String parolaAliena;
	private String traduzione;
	private List<String> traduzioni;
	
	public Traduzione(String s1, String s2) {
		this.parolaAliena = s1;
		this.traduzione = s2;
		this.traduzioni = new ArrayList<String>();
		this.traduzioni.add(s2);
	}
	
	public void addTraduzione(String s) { //da usare quando voglio inserire più traduzioni per la singola parola aliena
		traduzioni.add(s);
	}

	public String getParolaAliena() {
		return parolaAliena;
	}


	public String getTraduzione() {
		return traduzione;
	}
	
	public List<String> getTraduzioni(){
		return this.traduzioni;
	}

	@Override
	public String toString() {
		return "Parola: " + parolaAliena + ". Traduzione: " + this.traduzioni.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((parolaAliena == null) ? 0 : parolaAliena.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Traduzione other = (Traduzione) obj;
		if (parolaAliena == null) {
			if (other.parolaAliena != null)
				return false;
		} else if (!parolaAliena.equals(other.parolaAliena))
			return false;
		return true;
	}
	
}
