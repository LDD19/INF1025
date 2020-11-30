package tp2_fixed;

//classe pour stocker un mot et sa frequence dans un document
public class Mot {

	public String mot;
	public int frequence;
	
	public Mot(String mot) {
		this.mot = mot;
		this.frequence = 1;
	}
	
	public String toString() {
		return "'" + mot + "'" + ":" + frequence;
	}
}
