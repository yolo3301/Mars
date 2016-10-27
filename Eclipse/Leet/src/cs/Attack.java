package cs;

import java.util.Arrays;

public class Attack {

	public static void main(String[] args) {
		Leet289 l = new Leet289();
		int[][] a = new int[][] {{0,0,0,0},{0,1,1,0},{0,1,1,0},{0,0,0,0}};
		l.gameOfLife(a);
		for (int[] arr : a) {
			for (int j : arr) {
				System.out.print(j + ",");
			}
			System.out.println();
		}
		// System.out.println(Arrays.asList("2*3-5+6".split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)")));
	}

}
