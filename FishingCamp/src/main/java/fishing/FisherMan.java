package fishing;

//낚시꾼 테이블을 만들기 위한 DTO 생성
public class FisherMan {
   String a_code;
   String id;
   String pw;
   String name;
   String phone;
   int fishes;
   
   public FisherMan() {}
   
   public FisherMan(String a_code, String id, String pw, String name, String phone, int fishes) {
      this.a_code = a_code;
      this.id = id;
      this.pw = pw;
      this.name = name;
      this.phone = phone;
      this.fishes = fishes;
   }

   @Override
   public String toString() {
      return "Fisherman [a_code=" + a_code + ", id=" + id + ", pw=" + pw + ", name=" + name + ", phone=" + phone
            + ", fishes=" + fishes + "]";
   }

   public String getA_code() {
      return a_code;
   }

   public String getId() {
      return id;
   }

   public String getPw() {
      return pw;
   }

   public String getName() {
      return name;
   }

   public String getPhone() {
      return phone;
   }

   public int getFishes() {
      return fishes;
   }
   
   
}
