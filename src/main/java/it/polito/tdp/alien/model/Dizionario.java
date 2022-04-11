package it.polito.tdp.alien.model;

import java.util.ArrayList;
import java.util.List;

public class Dizionario {

	List<Traduzione> dictionary ;
	
	public Dizionario() {
		this.dictionary = new ArrayList<Traduzione>();
	}
	
	public void aggiungiParola(String s1, String s2) {
		//converto le stringhe in minuscolo ---> tutte le elaborazioni sono case INSENSITIVE
		String alienWord = s1.toLowerCase();
		String trad = s2.toLowerCase();
		//aggiungo al dizionario: verifico che la parola aliena non sia già presente
		boolean presente = false;
		boolean already = false;
		int index = -1;
		List<String> temp = new ArrayList<String>(); //per verificare che la traduzione non sia doppia
		for(Traduzione t : this.dictionary) {
			if(t.getParolaAliena().toLowerCase().equals(alienWord)) {
				presente = true; //la parola è già presente nel dizionario ---> aggiungo soltanto la traduzione alla collezione
				index = this.dictionary.indexOf(t);
				for(String s : t.getTraduzioni()) {
					temp.add(s);
				}
			}
		}
		//controllo che la traduzione non esista già
		for(String s : temp) {
			if(s.equals(trad)) {
				already = true;
			}
		}
		if(presente && !already) { //aggiungo la sola traduzione
			this.dictionary.get(index).addTraduzione(trad);
		}
		if(!presente) { //aggiungo parola al dizionario
			this.dictionary.add(new Traduzione(alienWord, trad));
		}
	}
	
	public int indiceTraduzione(String parola) {
		int indice = -1;
		for(Traduzione tt : this.dictionary) {
			if(tt.getParolaAliena().equals(parola.toLowerCase()))
				indice = this.dictionary.indexOf(tt);
		}
		return indice;
	}
	
	public String cercaTraduzione(String parola) {
		//convertiamo la stringa in minuscolo
		String toFind = parola.toLowerCase();
		String found = "";
		for(Traduzione t : this.dictionary) {
			if(t.getParolaAliena().toLowerCase().equals(toFind)) {
				found = t.getTraduzioni().toString();
				//return t.getTraduzione();
				return found;
			}
		}
		return null;
	}
	
	public String cercaTradWildcard(String parola) {
		String toFind = parola.toLowerCase();
		//String found = "";
		toFind = toFind.replaceAll("\\?", "."); //sostituisco poichè "." indica nelle regex qualsiasi carattere
		int contatore = 0; //quante volte la parola viene trovata
		StringBuilder sb = new StringBuilder();
		
		for(Traduzione tt : this.dictionary) {
			if(tt.getParolaAliena().matches(parola)) {
				contatore++;
				sb.append(tt.getTraduzioni().toString()+"\n");
			}
		}
		if(contatore!=0)
			return sb.toString();
		else
			return null;
		/*String s[] = toFind.split("."); //splitto la stringa in due
		int length = s[0].length();
		for(Traduzione tt : this.dictionary) {
			String s1 = tt.getParolaAliena().substring(0,length);
			String s2 = tt.getParolaAliena().substring(length+1);
			if(s1.equals(s[0]) && s2.equals(s[1])) { //se a parte il carattere wildcard, le due stringhe sono uguali
				//restituisco l'insieme delle traduzioni possibili
				found = tt.getTraduzioni().toString();
			}
		}*/
	}
	
	public List<Traduzione> getDizionario(){
		return this.dictionary;
	}
	
	public Traduzione getTrad(String s) {
		for(Traduzione t : this.dictionary) {
			if(t.getParolaAliena().equals(s) || t.getTraduzione().equals(s)) {
				return t;
			}
		}
		return null;
	}

	@Override
	public String toString() {
		String stringa = "";
		for(Traduzione t : this.dictionary) {
			stringa = t.toString()+"\n";
		}
		return stringa;
	}	
}
