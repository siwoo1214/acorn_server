package fishing;

public class Flatform {
	int f_num;
	int price;
	
	public Flatform() {}

	public Flatform(int f_num, int price) {
		this.f_num = f_num;
		this.price = price;
	}

	public int getF_num() {
		return f_num;
	}

	public int getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return "FlatformDTO [f_num=" + f_num + ", price=" + price + "]";
	}
	
	
}
