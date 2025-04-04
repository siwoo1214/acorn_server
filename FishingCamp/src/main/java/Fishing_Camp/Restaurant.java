package Fishing_Camp;

public class Restaurant {
   
   String menu;
   int price;
   String description;
   String category;
   String image_url;
   
   public Restaurant() {}
   
   public Restaurant(String menu, int price) {
      this.menu = menu;
      this.price = price;
   }

   @Override
   public String toString() {
      return "Restaurant [menu=" + menu + ", price=" + price+"]";
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

//   public String getImage_url() {
//      return image_url;
//   }
   
   
   
   
   
   
   
   
   
}
