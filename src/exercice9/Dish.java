package exercice9;

import java.util.*;
import java.util.function.Function;

public class Dish {

	private final String name;
	private final boolean vegetarian;
	private final int calories;
	private final Type type;

	public Dish(String name, boolean vegetarian, int calories, Type type) {
		this.name = name;
		this.vegetarian = vegetarian;
		this.calories = calories;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public boolean isVegetarian() {
		return vegetarian;
	}

	public int getCalories() {
		return calories;
	}

	public Type getType() {
		return type;
	}

	public enum Type {
		MEAT, FISH, OTHER
	}

	@Override
	public String toString() {
		return name;
	}

	public static final List<Dish> menu = Arrays.asList(new Dish("pork", false, 800, Dish.Type.MEAT),
			new Dish("beef", false, 700, Dish.Type.MEAT), new Dish("chicken", false, 400, Dish.Type.MEAT),
			new Dish("french fries", true, 530, Dish.Type.OTHER), new Dish("rice", true, 350, Dish.Type.OTHER),
			new Dish("season fruit", true, 120, Dish.Type.OTHER), new Dish("pizza", true, 550, Dish.Type.OTHER),
			new Dish("prawns", false, 400, Dish.Type.FISH), new Dish("salmon", false, 450, Dish.Type.FISH));

	//a. Is there any Vegetarian meal available ( return type boolean)
	public static Function<List<Dish>, Boolean> Is_there_any_Vegetarian_meal = (list) -> list.stream()
			.filter(a -> a.vegetarian).findAny().isPresent();
	
	//b. Is there any healthy menu have calories less than 1000 ( return type boolean)
	public static Function<List<Dish>, Boolean> Is_there_any_Healthy_menu = (list) -> list.stream()
			.filter(a -> a.calories < 1000).findAny().isPresent();
	
	//c. Is there any unhealthy menu have calories greater than 1000 ( return type boolean)
	public static Function<List<Dish>, Boolean> Is_there_any_Unhealthy_menu = (list) -> list.stream()
			.filter(a -> a.calories > 1000).findAny().isPresent();
	
	//d. find and return the first item for the type of MEAT( return type Optional<Dish>)
	public static Function<List<Dish>, Optional<Dish>> first_item_type_of_MEAT = (list) -> list.stream()
			.filter(a -> a.type.equals(Type.MEAT)).findFirst();
	
	//e. calculateTotalCalories() in the menu using reduce. (return int)
	public static Function<List<Dish>, Integer> calculateTotalCalories = (list) -> list.stream()
			.map(a->a.calories).reduce(0,(a,b)->a+b);
	
	//f. calculate TotalCaloriesMethodReference()in the menu using MethodReferences. (return int)
	public static Function<List<Dish>, Integer> TotalCaloriesMethodReference = (list) -> list.stream()
			.map(a->a.calories).reduce(0,Integer::sum);
	
	//e. Implement a main method to test.
	public static void main(String args[]) {
		System.out.println("a. Is there any Vegetarian meal available ( return type boolean)");
		System.out.println(Is_there_any_Vegetarian_meal.apply(menu));
		System.out.println();
		System.out.println("b. Is there any healthy menu have calories less than 1000 ( return type boolean)");
		System.out.println(Is_there_any_Healthy_menu.apply(menu));
		System.out.println();
		System.out.println("c. Is there any unhealthy menu have calories greater than 1000 ( return type boolean)");
		System.out.println(Is_there_any_Unhealthy_menu.apply(menu));
		System.out.println();
		System.out.println("d. find and return the first item for the type of MEAT( return type Optional<Dish>)");
		System.out.println(first_item_type_of_MEAT.apply(menu));
		System.out.println();
		System.out.println("e. calculateTotalCalories() in the menu using reduce. (return int)");
		System.out.println(calculateTotalCalories.apply(menu));
		System.out.println();
		System.out.println("f. calculate TotalCaloriesMethodReference()in the menu using MethodReferences. (return int)");
		System.out.println(TotalCaloriesMethodReference.apply(menu));
	}
	
	
}