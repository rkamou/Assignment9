/**
 * 
 */
package exercice5;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.stream.Stream;

/**
 * @author 610151
 *
 */
public class Section {
	public static Stream<String> streamSection(Stream<String> stream, int m, int n) {
		return stream.skip(m).limit(n);
	}

	public static void main(String[] args) {
		// Make three calls for the streamSection() method with different inputs // use
		// nextStream() method to supply the Stream input as a first argument in
		// streamSection() method
		streamSection(nextStream(),2,4).forEach(System.out::println);
	}

	// support method for the main method -- for testing
	private static Stream<String> nextStream() {
		return Arrays.asList("Speedy", "Gonzales", "The", "Fastest", "Mouse", "All", "Over", "Mexico", "iii").stream();
	}

	
}