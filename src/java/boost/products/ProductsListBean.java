package boost.products;


import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@SessionScoped
public class ProductsListBean implements Serializable {

    private List<Product> products = new ArrayList<Product>();

    private Product newProduct = new Product();


    public Product getNewProduct() {
        return newProduct;
    }

    public void createNewProduct() {

        products.add(newProduct);
        newProduct = new Product();
    }

    public List<Product> getProducts() {
        return products;
    }




    @PostConstruct
    private void initialize() {

        Product product = new Product();
        product.setId("sa");
        product.setName("fasol");
        product.setPrice(123);
        products.add(product);

        product = new Product();
        product.setId("sa");
        product.setName("ris");
        product.setPrice(145);
        products.add(product);

        product = new Product();
        product.setId("aa");
        product.setName("rывывыis");
        product.setPrice(23);
        products.add(product);
    }


}
