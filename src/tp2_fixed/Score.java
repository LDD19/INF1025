//Frederic Achard-Groleau 20165049 et Si Da Li 20086868

package tp2_fixed;

public class Score {

	public String nomDocument;
	public int score;
	
	public Score(String nomDocument, int score) {
		this.nomDocument = nomDocument;
		this.score = score;
	}
	
	public String toString() {
		return nomDocument + " : " + score;
	}
}
