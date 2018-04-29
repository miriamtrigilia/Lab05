package it.polito.tdp.anagrammi.model;

import java.util.HashSet;
import java.util.Set;

import it.polito.tdp.anagrammi.DAO.AnagrammaDAO;

public class Model {
	
	private AnagrammaDAO anagrammaDAO = new AnagrammaDAO();
	
	
	
	public Set<String> calcolaAnagrammi (String parola) {
		
		// CASO INIZIALE
		
	    Set<String> anagrammi = new HashSet<String>();
	    String parziale = "";
	    
	    calcola(parziale,parola,0,anagrammi);

	    return anagrammi;
	}
	
	private void calcola(String parziale,String parola, int passo, Set<String> anagrammi){
		
		// TERMINAZIONE
		if(passo == parola.length()){ 
			anagrammi.add(parziale);
			return; // -> Va dentro il for a "parziale = parziale.substring..."
		}
		
		// CASO INTERMEDI0
		for(int i = 0; i< parola.length(); i++){
			if(contatoreLettere (parziale, parola.charAt(i)) < contatoreLettere (parola, parola.charAt(i))){ // vedo se parziale contiene tutte le lettere di parola, considerando anche quelle che si ripetono
				parziale += parola.charAt(i);
				calcola(parziale, parola, passo + 1,anagrammi);
				parziale = parziale.substring(0,parziale.length()-1); // backtrack .. toglie l'ultima lettera
			}
		}
			
	}
	
	private static int contatoreLettere (String string, char c){ // quante volte una lettera è presente in una parola
		int count = 0;
	    for (int i=0; i < string.length(); i++)
	    {
	        if (string.charAt(i) == c)
	        {
	             count++;
	        }
	    }
	    return count;
	}
	
	
	public boolean anagrammaEsiste(String anagramma) {
		
		if(this.anagrammaDAO.isCorrect(anagramma)) return true;
			
		else return false;
	}
	
	
	
	public boolean isCorrect(String anagramma){
		return anagrammaDAO.isCorrect(anagramma);
	}
	
	
	

	
	
	

}
