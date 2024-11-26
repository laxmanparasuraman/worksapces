import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        String name1="asus vivobook";
        String type="laptop";
        String place="Brown Table";
        int warranty=2022;
        //Product p=new Product("Asus vivbook","laptop","Brown Table","2022");
        //System.out.println(p);

        ProductService service =new ProductService();
        service.addProduct(new Product("Asus vivbook","laptop","Brown Table","2022"));
        service.addProduct(new Product("Asus vivbook","laptop","Brown Table","2022"));
        service.addProduct(new Product("Asus vivbook","laptop","Brown Table","2022"));
        service.addProduct(new Product("Asus vivbook","laptop","Brown Table","2022"));

         List<Product> result=service.getAllProducts();
         for(Product p:result){
             System.out.println(p);
         }
        System.out.println("========");
        System.out.println(" get a particular product");
        System.out.println(service.getProducts("Asus vivbok"));

        System.out.println(" a particular text");

        List<Product> listProducts=service.getProductwithText("asus");
        for (Product p:listProducts){
            System.out.println(p);
        }


    }
    }

    /*
    assgn  find by place and chek expiry

    1  search by place
    2  search Products out of warranty
    3  Stream Api
    537
  550

    */
