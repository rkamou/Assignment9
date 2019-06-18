package exercice7.b;
import java.util.*;
import java.util.stream.Collectors;

public class LambdaLibrary {
	public static final TriFunction<List<Employee>, String,Integer, String> Full_NAMES
	=(list, pattern, salaryRange)->
	list.stream().
	filter(e-> e.getSalary() > salaryRange && e.getLastName().matches(pattern)).
	sorted((Employee p1, Employee p2) -> p1.getFirstName().compareTo(p2.getFirstName())).
	map(e -> e.firstName+ " " + e.lastName).
	collect(Collectors.joining(" , "));
}
