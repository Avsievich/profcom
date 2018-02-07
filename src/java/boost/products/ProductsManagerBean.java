package boost.products;


import boost.products.domain.ProductEntity;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@LocalBean
@Stateless
public class ProductsManagerBean {

    @PersistenceContext(unitName = "examplePU")
    private EntityManager entityManager;



    //CRUD

    public boolean create(ProductEntity productEntity){

    }

    public  ProductEntity read (long id){

    }
    public List<ProductEntity> readList (int offset, int limit){


    }

    public  boolean update (ProductEntity productEntity){

    }

    public boolean delete (long id){

    }




}