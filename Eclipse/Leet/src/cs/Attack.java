package cs;

import java.util.Arrays;

public class Attack {

	public static void main(String[] args) {
		Leet241 l = new Leet241();
		// System.out.println(l.diffWaysToCompute("2*3-4*5"));
		System.out.println(Arrays.asList("2*3-5+6".split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)")));
		System.out.println(Arrays.asList("2*3-5+6".split("[1-9]")));
	}

}
