package fishing;

public class Food_Order {
	
	int o_number;
	String a_code;
	String menu;
	String order_date;
	int quantity;
	int total_price;
	
	
	public Food_Order() {}
	
	public Food_Order(int o_number, String a_code, String menu, String order_date, int quantity, int total_price) {
		this.o_number = o_number;
		this.a_code = a_code;
		this.menu = menu;
		this.order_date = order_date;
		this.quantity = quantity;
		this.total_price = total_price;
	}

	@Override
	public String toString() {
		return "Food_Order [o_number=" + o_number + ", a_code=" + a_code + ", menu=" + menu + ", order_date="
				+ order_date + ", quantity=" + quantity + ", total_price=" + total_price + "]";
	}

	public int getO_number() {
		return o_number;
	}

	public String getA_code() {
		return a_code;
	}

	public String getMenu() {
		return menu;
	}

	public String getOrder_date() {
		return order_date;
	}

	public int getQuantity() {
		return quantity;
	}

	public int getTotal_price() {
		return total_price;
	}
	
	
	
}
