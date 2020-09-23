import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SetDemo {

	public static void main(String[] args) {
		Set<Item> items = new HashSet<Item>();
		items.add(new Item(5, "Car", 493245, 3.5));
		items.add(new Item(2, "TV", 14000, 4.5));
		items.add(new Item(3, "Mobile", 8999.45, 3));
		items.add(new Item(1, "Pen", 45, 3.2));
		items.add(new Item(4, "Laptop", 66983, 2.9));
		
		/*
		 * System.out.println("---------Using equals method-------"); for(Item it :
		 * itemslist) { System.out.println(it); }
		 */
		
		List<Item> itemslist = new ArrayList<Item>(items);
		System.out.println("\n---------Using Comparator for ItemId Ascending-------");
		Collections.sort(itemslist, new SortSample.SortClassByIdAsc());
		for(Item it : itemslist) {
			System.out.println(it);
		}
		
		System.out.println("\n---------Using Comparator for ItemId Descending-------");
		Collections.sort(itemslist, new SortSample.SortClassByIdDesc());
		for(Item it : itemslist) {
			System.out.println(it);
		}
		
		System.out.println("\n---------Using Comparator for ItemName Ascending-------");
		Collections.sort(itemslist, new SortSample.SortClassByNameAsc());
		for(Item it : itemslist) {
			System.out.println(it);
		}
		
		System.out.println("\n---------Using Comparator for ItemName Descending-------");
		Collections.sort(itemslist, new SortSample.SortClassByNameDesc());
		for(Item it : itemslist) {
			System.out.println(it);
		}
		
		System.out.println("\n---------Using Comparator for ItemPrice Ascending-------");
		Collections.sort(itemslist, new SortSample.SortClassByPriceAsc());
		for(Item it : itemslist) {
			System.out.println(it);
		}
		
		System.out.println("\n---------Using Comparator for ItemPrice Descending-------");
		Collections.sort(itemslist, new SortSample.SortClassByPriceDesc());
		for(Item it : itemslist) {
			System.out.println(it);
		}
		
		System.out.println("\n---------Using Comparator for ItemRating Ascending-------");
		Collections.sort(itemslist, new SortSample.SortClassByRatingAsc());
		for(Item it : itemslist) {
			System.out.println(it);
		}
		
		System.out.println("\n---------Using Comparator for ItemRating Descending-------");
		Collections.sort(itemslist, new SortSample.SortClassByRatingDesc());
		for(Item it : itemslist) {
			System.out.println(it);
		}
	}

}
