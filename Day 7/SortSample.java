import java.util.Comparator;

public class SortSample {
	public static class SortClassByIdAsc implements Comparator<Item> {

		@Override
		public int compare(Item o1, Item o2) {
			return o1.getItemId() - o2.getItemId();
		}
	}
	
	public static class SortClassByIdDesc implements Comparator<Item> {

		@Override
		public int compare(Item o1, Item o2) {
			return o2.getItemId() - o1.getItemId();
		}
	}
	
	public static class SortClassByNameAsc implements Comparator<Item> {

		@Override
		public int compare(Item o1, Item o2) {
			return o1.getName().compareTo(o2.getName());
		}
	}
	
	public static class SortClassByNameDesc implements Comparator<Item> {

		@Override
		public int compare(Item o1, Item o2) {
			return -o1.getName().compareTo(o2.getName());
		}
	}
	
	public static class SortClassByPriceAsc implements Comparator<Item> {

		@Override
		public int compare(Item o1, Item o2) {
			return Double.compare(o1.getPrice(), o2.getPrice());
		}
	}
	
	public static class SortClassByPriceDesc implements Comparator<Item> {

		@Override
		public int compare(Item o1, Item o2) {
			return Double.compare(o2.getPrice(), o1.getPrice());
		}
	}
	
	public static class SortClassByRatingAsc implements Comparator<Item> {

		@Override
		public int compare(Item o1, Item o2) {
			return Double.compare(o1.getRatings(), o2.getRatings());
		}
	}
	
	public static class SortClassByRatingDesc implements Comparator<Item> {

		@Override
		public int compare(Item o1, Item o2) {
			return Double.compare(o2.getRatings(), o1.getRatings());
		}
	}
}
