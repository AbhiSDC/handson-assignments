
public class Item {
	private int itemId;
	private String name;
	private double price;
	private double ratings;
	
	public Item() {
		super();
	}

	public Item(int itemId, String name, double price, double ratings) {
		super();
		this.itemId = itemId;
		this.name = name;
		this.price = price;
		this.ratings = ratings;
	}
	public int getItemId() {
		return itemId;
	}
	public String getName() {
		return name;
	}
	public double getPrice() {
		return price;
	}
	public double getRatings() {
		return ratings;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public void setRatings(double ratings) {
		this.ratings = ratings;
	}
	
	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", name=" + name + ", price=" + price + ", ratings=" + ratings + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + itemId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (itemId != other.itemId)
			return false;
		return true;
	}
}
