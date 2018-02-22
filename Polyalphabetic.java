import java.math.BigInteger;

public class Polyalphabetic {
	int table[][] = new int[10][10];

	public void generateTable() {
		int array[] = new int[10];
		int c = 0;
		for (int x = 0; x < 10; x++) {
			array[x] = c;
			c++;
		}
		int i, j, k;
		i = 0;
		while (i < 10) {
			k = i;
			for (j = 0; j < 10; j++) {
				if (k >= 10) {
					System.out.println();
					k = 0;
					
				}
					
				table[i][j] = array[k++];
				System.out.print(table[i][j]);
			}
			i++;
		}
	}

	public String encrypt(String keyWord, String message) {
		generateTable();
		return keyWord;
	}

	public String decrypt(String keyWord, String cipher) {
		generateTable();
		return keyWord;

	}

}
