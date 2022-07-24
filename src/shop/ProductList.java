package shop;

import java.util.Arrays;

public class ProductList {

   private Product [] productList;
   private final int productListSize = 10;
   private int lastIndex = -1;

   public ProductList() {
      this.productList = new Product[productListSize];
   }

   public ProductList(Product[] productList) {
      this.productList = productList;
   }

   public void addProduct(Product product) {

      if (lastIndex == -1) {
         this.productList = new Product[productListSize];
      } else if (lastIndex == productList.length - 1) {
         productList = Arrays.copyOf(productList, productList.length * 2);
      }

      lastIndex++;
      productList[lastIndex] = product;

   }

   public int getNewID() {
      return lastIndex + 2;
   }

   public void DisplayProductList() {

      for (int i = 0; i < productList.length; i++) {
         if (productList[i] != null) {
            System.out.println(productList[i].toString());
         }

      }
   }

   public void DeleteProduct(int id) {

      for (int i = 0; i < productList.length; i++) {
         if (id == productList[i].getId()) {
            productList[i] = null;
         }

      }
   }

   public Product GetProductById(int id) {

      Product prod;
      for (int i = 0; i < productList.length; i++) {
         if (id == productList[i].getId()) {
            prod = productList[i];
         }
      }

      return prod;
   }
}
