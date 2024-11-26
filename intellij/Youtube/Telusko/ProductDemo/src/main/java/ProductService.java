import java.util.ArrayList;
import java.util.List;

public class ProductService {


    List<Product>  products =new ArrayList<>();
    public  void addProduct(Product product){
        products.add(product);

    }

    public  List<Product> getAllProducts(){
        return  products;
    }
    public  Product getProducts(String name){
        for (Product p:products){
            if (p.getName().equals(name)){
                return p;
            }
        }
        return null;
    }


    public List<Product> getProductwithText(String text) {
        List<Product> result=new ArrayList<>();

        for (Product p:products){
            if (p.getName().toLowerCase().contains(text.toLowerCase())||p.getPlace().contains(text)){
                result.add(p);
            }
        }
        return result;
    }
}
