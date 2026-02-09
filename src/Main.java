public class Main {
    public static void main(String[] args) {








































































































































































































































        System.out.println("Adam, compra tabaco")

		char[][] cara = new char[9][9];

		for (int i = 0; i < cara.length; i++) {
			for (int j = 0; j < cara[i].length; j++) {

				if (i == 0 || i == cara.length - 1 ||
						j == 0 || j == cara[i].length - 1) {

					cara[i][j] = '0';

				} else if ((i == 2 && j == 2) || (i == 2 && j == 6)) {

					cara[i][j] = '0';

				} else if (i == 6 && (j >= 2 && j <= 6)) {

					cara[i][j] = '0';

				} else {
					cara[i][j] = ' ';
				}
			}
		}

		for (int i = 0; i < cara.length; i++) {
			for (int j = 0; j < cara[i].length; j++) {
				System.out.print(cara[i][j] + " ");
			}
			System.out.println();
		}
	}
}