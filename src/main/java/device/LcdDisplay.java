package device;

import model.Product;

public class LcdDisplay {
    public void print(Product product) {
        if(product == null){
            System.out.println("Product not found");
        } else{
            System.out.println(product.getName() + " " + product.getPrice() + "zł");
        }
    }
}
