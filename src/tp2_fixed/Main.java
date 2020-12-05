//Frederic Achard-Groleau 20165049 et Si Da Li 20086868

package tp2_fixed;

import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		
		Index index = new Index();
		IndexInverse indexInv = new IndexInverse(index);
		new WindowMain(index, indexInv);
	}
}
