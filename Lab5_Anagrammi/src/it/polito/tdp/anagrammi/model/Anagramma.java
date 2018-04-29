package it.polito.tdp.anagrammi.model;

public class Anagramma {
	
	private String parola;
	private boolean esiste;
	
	public Anagramma(String parola, boolean esiste) {
		this.parola = parola;
		this.esiste = esiste;
	}
	
	
	
	public String getParola() {
		return parola;
	}



	public void setParola(String parola) {
		this.parola = parola;
	}



	public boolean isEsiste() {
		return esiste;
	}



	public void setEsiste(boolean esiste) {
		this.esiste = esiste;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (esiste ? 1231 : 1237);
		result = prime * result + ((parola == null) ? 0 : parola.hashCode());
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
		Anagramma other = (Anagramma) obj;
		if (esiste != other.esiste)
			return false;
		if (parola == null) {
			if (other.parola != null)
				return false;
		} else if (!parola.equals(other.parola))
			return false;
		return true;
	}
	
	



}
