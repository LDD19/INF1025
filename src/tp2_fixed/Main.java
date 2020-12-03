package tp2_fixed;

import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		
		Index index = new Index();
		IndexInverse indexInv = new IndexInverse(index);
		WindowMain main=new WindowMain(index, indexInv);
	}
}
