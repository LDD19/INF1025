//Frederic Achard-Groleau 20165049 et Si Da Li 20086868

package tp2_fixed;

public class DocumentInverse {

	public String nomDocument;
	public int frequence;
	
	public DocumentInverse(String nomDocument, int frequence) {
		this.nomDocument = nomDocument;
		this.frequence = frequence;
	}
	
	public String toString() {
		return nomDocument + ":" + frequence;
	}
}
