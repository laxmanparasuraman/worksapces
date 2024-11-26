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



/*
*
*
  Proto  Local Address          Foreign Address        State           PID
  TCP    0.0.0.0:135            0.0.0.0:0              LISTENING       1560
  TCP    0.0.0.0:445            0.0.0.0:0              LISTENING       4
  TCP    0.0.0.0:3306           0.0.0.0:0              LISTENING       6516
  TCP    0.0.0.0:5040           0.0.0.0:0              LISTENING       8916
  TCP    0.0.0.0:8733           0.0.0.0:0              LISTENING       4
  TCP    0.0.0.0:9007           0.0.0.0:0              LISTENING       4
  TCP    0.0.0.0:33060          0.0.0.0:0              LISTENING       6516
  TCP    0.0.0.0:49664          0.0.0.0:0              LISTENING       1348
  TCP    0.0.0.0:49665          0.0.0.0:0              LISTENING       1244
  TCP    0.0.0.0:49666          0.0.0.0:0              LISTENING       2756
  TCP    0.0.0.0:49667          0.0.0.0:0              LISTENING       2888
  TCP    0.0.0.0:49668          0.0.0.0:0              LISTENING       4800
  TCP    0.0.0.0:49669          0.0.0.0:0              LISTENING       1316
  TCP    127.0.0.1:49670        127.0.0.1:49671        ESTABLISHED     6516
  TCP    127.0.0.1:49671        127.0.0.1:49670        ESTABLISHED     6516
  TCP    127.0.0.1:49672        127.0.0.1:49673        ESTABLISHED     6516
  TCP    127.0.0.1:49673        127.0.0.1:49672        ESTABLISHED     6516
  TCP    127.0.0.1:51962        127.0.0.1:27300        SYN_SENT        5440
  TCP    [::]:135               [::]:0                 LISTENING       1560
  TCP    [::]:445               [::]:0                 LISTENING       4
  TCP    [::]:3306              [::]:0                 LISTENING       6516
  TCP    [::]:8733              [::]:0                 LISTENING       4
  TCP    [::]:9007              [::]:0                 LISTENING       4
  TCP    [::]:33060             [::]:0                 LISTENING       6516
  TCP    [::]:49664             [::]:0                 LISTENING       1348
  TCP    [::]:49665             [::]:0                 LISTENING       1244
  TCP    [::]:49666             [::]:0                 LISTENING       2756
  TCP    [::]:49667             [::]:0                 LISTENING       2888
  TCP    [::]:49668             [::]:0                 LISTENING       4800
  TCP    [::]:49669             [::]:0                 LISTENING       1316
  TCP    [2409:408d:3d82:b61f:9d2c:47ae:e495:f849]:51224  [2405:200:1630:ca7::1011]:443  CLOSE_WAIT      15788
  TCP    [2409:408d:3d82:b61f:9d2c:47ae:e495:f849]:51225  [2405:200:1630:a03::312c:c5d9]:443  CLOSE_WAIT      15788
  TCP    [2409:408d:3d82:b61f:9d2c:47ae:e495:f849]:51226  [64:ff9b::b854:e9e3]:443  CLOSE_WAIT      15788
  UDP    0.0.0.0:500            *:*                                    5576
  UDP    0.0.0.0:4500           *:*                                    5576
  UDP    0.0.0.0:5050           *:*                                    8916
  UDP    127.0.0.1:1900         *:*                                    7448
  UDP    127.0.0.1:49664        127.0.0.1:49664                        5596
  UDP    127.0.0.1:65328        *:*                                    7448
  UDP    [::]:500               *:*                                    5576
  UDP    [::]:4500              *:*                                    5576
  UDP    [::1]:1900             *:*                                    7448
  UDP    [::1]:65327            *:*                                    7448*/
