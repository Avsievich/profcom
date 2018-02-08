package boost.products;


import boost.products.domain.ProductEntity;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


//Получение списка товаров и завести новый товар
@Named
@SessionScoped
public class ProductsListBean implements Serializable {

    @EJB
    private ProductsManagerBean productsManagerBean;
    private Product newProduct = new Product();

    public List<Product> getProducts() {
        List<Product> result = new ArrayList<Product>();
        List<ProductEntity> entities = productsManagerBean.readList(0, 10);
        for (ProductEntity productEntity : entities) {
            result.add(productEntity.toDto());
        }
        return result;

    }

    public Product getNewProduct() {
        return newProduct;
    }

    public void createNewProduct() {
        ProductEntity productEntity = new ProductEntity();
        productEntity.fromDto(newProduct);

        productsManagerBean.create(productEntity);
        newProduct = new Product();
    }


}
