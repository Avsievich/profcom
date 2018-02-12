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
    private Product editingProduct;

    public List<Product> getProducts() {
        return productsManagerBean.readList(0, 100);
    }

    public Product getNewProduct() {
        return newProduct;
    }

    public Product getEditingProduct() {
        return editingProduct;
    }

    public void setEditingProduct(Product editingProduct) {
        this.editingProduct = editingProduct;
    }

    public void createNewProduct() {
        productsManagerBean.create(newProduct);
        newProduct = new Product();
    }

    public void deleteProduct(long id) {
        productsManagerBean.delete(id);

    }

    public void  saveProduct(){

        productsManagerBean.update(editingProduct);
    }


}
