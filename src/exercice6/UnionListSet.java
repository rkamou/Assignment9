/**
 * 
 */
package exercice6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

/**
 * @author 610151
 *
 */
public class UnionListSet {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<String> s1 = Arrays.asList("Speedy", "Gonzales", "The", "Fastest", "Mouse", "All", "Over", "Mexico", "iii").stream().collect(Collectors.toSet());
		Set<String> s2 = Arrays.asList("Geeks", "For", "Geeks", "Example", "Set", "Big", "Heart", "hhh", "iii").stream().collect(Collectors.toSet());
          
        List<Set<String>> lis = new ArrayList<Set<String>>();
        lis.add(s1);
        lis.add(s2);
        Set<String>resu = union(lis);
        System.out.println(resu.stream().collect(Collectors.joining(" , ")));
	}
	
	public static Set<String> union(List<Set<String>> sets) { 
		BiFunction<Set<String>, Set<String>, Set<String>> myBi = (Set<String> a, Set<String> c) -> {
			c.forEach(e -> a.add(e));
			return a;
		};

		return  sets.stream().reduce((a, c) -> myBi.apply(a, c)).orElse(null);
 

	}

}
