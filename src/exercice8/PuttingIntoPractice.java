package exercice8;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PuttingIntoPractice {
	public static void main(String... args) {
		Trader raoul = new Trader("Raoul", "Cambridge");
		Trader mario = new Trader("Mario", "Milan");
		Trader alan = new Trader("Alan", "Cambridge");
		Trader brian = new Trader("Brian", "Cambridge");

		List<Transaction> transactions = Arrays.asList(new Transaction(brian, 2011, 300),
				new Transaction(raoul, 2012, 1000), new Transaction(raoul, 2011, 400),
				new Transaction(mario, 2012, 710), new Transaction(mario, 2012, 700), new Transaction(alan, 2012, 950));

		// Query 1: Find all transactions from year 2011 and sort them by value (small
		// to high).
		BiFunction<List<Transaction>, Integer, List<Transaction>> Transactions_from_a_year = (list, year) -> list
				.stream().filter(a -> a.getYear() >= year)
				.sorted((a1, a2) -> Integer.compare(a1.getValue(), a2.getValue())).collect(Collectors.toList());

		// Query 2: What are all the unique cities where the traders work?
		Function<List<Transaction>, List<String>> Unique_cities = (list) -> list.stream()
				.map(a -> a.getTrader().getCity()).distinct().collect(Collectors.toList());

		// Query 3: Find all traders from Cambridge and sort them by name.
		BiFunction<List<Transaction>, String, List<Trader>> Traders_from_City = (list, city) -> list.stream()
				.filter(a -> a.getTrader().getCity().equals(city))
				.sorted((a1, a2) -> a1.getTrader().getName().compareTo(a2.getTrader().getName()))
				.map(t -> t.getTrader()).collect(Collectors.toList());

		// Query 4: Return a string of all traders names sorted alphabetically.
		Function<List<Transaction>, String> All_traders_names_sorted = (list) -> list.stream()
				.sorted((a1, a2) -> a1.getTrader().getName().compareTo(a2.getTrader().getName()))
				.map(a -> a.getTrader().getName()).distinct().collect(Collectors.joining(", "));

		// Query 5: Are there any trader based in Milan?
		BiFunction<List<Transaction>, String, Boolean> Are_there_any_trader = (list,city) -> list.stream()
				.filter(t->t.getTrader().getCity().equals(city)).findAny().isPresent();

		// Query 6: Update all transactions so that the traders from Milan are set to
		// Cambridge.

		// Query 7: What's the highest value in all the transactions?
		Function<List<Transaction>, Integer> Highest_value_transactions = (list) -> list.stream()
				.map(t->Integer.valueOf(t.getValue())).max((a1,a2)->a1.compareTo(a2)).orElse(0); 

		
		System.out.println();
		System.out.println(Transactions_from_a_year.apply(transactions,2011));
		System.out.println();
		System.out.println(Unique_cities.apply(transactions));
		System.out.println();
		System.out.println(Traders_from_City.apply(transactions,"Cambridge"));
		System.out.println();
		System.out.println(All_traders_names_sorted.apply(transactions));
		System.out.println();
		System.out.println(Are_there_any_trader.apply(transactions,"Milan"));
		System.out.println();
		System.out.println(Highest_value_transactions.apply(transactions));
	}
}
