/**
 * 
 */
package exercice1_2_3_4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author 610151
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// Problem 1
		System.out.println("Output problem 1");
		Stream<String> stringStream = Stream.of("Bill", "Thomas", "Mary");
		System.out.println(stringStream.reduce("", (a, b) -> a.isEmpty() ? "" + b : a + " , " + b));

		stringStream = Stream.of("Bill", "Thomas", "Mary");
		System.out.println(stringStream.reduce((a, b) -> a + " , " + b).orElse(""));

		stringStream = Stream.of("Bill", "Thomas", "Mary");
		System.out.println(stringStream.collect(Collectors.joining(" , ")));

		System.out.println();
		System.out.println("************************************************");
		System.out.println();

		// Problem 2
		System.out.println("Output problem 2");
		Stream<Integer> myIntStream = Stream.of(5, 0, 2, 8, 6, 1, 2, 5, 9, 12, 4, 41);
		System.out.println(myIntStream.map(a -> String.valueOf(a)).reduce((a, b) -> a + "," + b).orElse(""));
		myIntStream = Stream.of(5, 0, 2, 8, 6, 1, 2, 5, 9, 12, 4, 41);
		System.out.println("Max : " + myIntStream.collect(Collectors.summarizingInt((Integer p) -> p)).getMax());
		myIntStream = Stream.of(5, 0, 2, 8, 6, 1, 2, 5, 9, 12, 4, 41);
		System.out.println("Max : " + myIntStream.collect(Collectors.summarizingInt((Integer p) -> p)).getMin());

		System.out.println();
		System.out.println("************************************************");
		System.out.println();

		// Problem 3
		System.out.println("Output problem 3");
		List<String> stringList = Arrays.asList("Bryan", "Alfred", "Beth");
		System.out.println(countWords(stringList, "B", "i", 5));

		System.out.println();
		System.out.println("************************************************");
		System.out.println();

		// Problem 4
		System.out.println("Output problem 4");
		printSquares(4);
		printSquares(6);
		printSquares(100);
	}

	public static Long countWords(List<String> words, CharSequence c, CharSequence d, int len) {
		return words.stream().filter(a -> a.length() == len && a.contains(c) && !a.contains(d))
				.collect(Collectors.counting());
	}

	public static void printSquares(int num) { 
		System.out.println(Stream.iterate(1, n -> n + 1).limit(num).map(n -> n * n).map(n -> String.valueOf(n))
				.collect(Collectors.joining(" , ")));
	}

}
