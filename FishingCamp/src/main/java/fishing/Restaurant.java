package fishing;

public class Restaurant {
	
	String menu;
	int price;
	String description;
	String category;
	String image_url;
	
	public Restaurant() {}
	
	public Restaurant(String menu, int price, String description, String category, String image_url) {
		this.menu = menu;
		this.price = price;
		this.description = description;
		this.category = category;
		this.image_url = image_url;
	}
	
	@Override
	public String toString() {
		return "Restaurant [menu=" + menu + ", price=" + price + ", description=" + description + ", category="
				+ category + ", image_url=" + image_url + "]";
	}

	public String getMenu() {
		return menu;
	}

	public int getPrice() {
		return price;
	}
	
	public String getDescription() {
		return description;
	}

	public String getCategory() {
		return category;
	}

	public String getImage_url() {
		return image_url;
	}
	
	
	
	
	
	
	
	
	
}
