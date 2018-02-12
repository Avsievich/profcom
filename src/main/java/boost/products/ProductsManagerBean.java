package boost.products;


import boost.products.domain.ProductEntity;
import org.apache.commons.lang3.StringUtils;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


// работа с сущностью productEntity


@LocalBean
@Stateless
public class ProductsManagerBean {

    @PersistenceContext(unitName = "examplePU")
    private EntityManager entityManager;


    //CRUD

    // Добавляем обьект в БД
    public boolean create(Product product) {
        // проверяем все ли поля заполнены
        if (checkValid(product)) {
            // проверяем на существование обьекта
            ProductEntity existingProduct = entityManager.find(ProductEntity.class, product.getId());
            if (existingProduct != null) {
                return false;
            }
            // добавляем оьект в базу данных
            existingProduct = new ProductEntity();
            existingProduct.fromDto(product);
            entityManager.persist(existingProduct);
            return true;

        }
        return false;

    }

    // Получение обьектов из БД
    public Product read(long id) {
        // выбераем данные по id
        ProductEntity productEntity = entityManager.find(ProductEntity.class, id);

        if (productEntity == null) {
            return null;
        }
        return productEntity.toDto();
    }

    // Получение обьектов из БД списком
    public List<Product> readList(int offset, int limit) {
        if (offset < 0 || limit < 1) {
            return null;
        }
        TypedQuery<ProductEntity> query = entityManager.createQuery(
                "SELECT entity from ProductEntity entity"
                , ProductEntity.class);
        query.setFirstResult(offset);
        query.setMaxResults(limit);

        List<ProductEntity> productEntities = query.getResultList();
        if (productEntities == null || productEntities.isEmpty()) {
            return Collections.emptyList();
        }
        List<Product> result = new ArrayList<Product>(productEntities.size());
        for (ProductEntity productEntity : productEntities) {

            result.add(productEntity.toDto());
        }
        return result;


    }

    //  Обнавляем обьект в базе данных
    public boolean update(Product product) {
        // проверяем все ли поля заполнены
        if (checkValid(product)) {
            // проверяем на существование обьекта
            ProductEntity existingProduct = entityManager.find(ProductEntity.class, product.getId());
            if (existingProduct == null) {
                return false;
            }
            //  обнавляем обьект в базе данных
            existingProduct.fromDto(product);
            entityManager.merge(existingProduct);
            return true;

        }
        return false;

    }

    //Удаляем обьекты из базы данных
    public boolean delete(long id) {
        // проверяем на существование обьекта
        ProductEntity existingEntity = entityManager.find(ProductEntity.class, id);
        if (existingEntity == null) {
            return false;
        }
        //  удаляем обьект в базе данных
        entityManager.remove(existingEntity);
        return true;
    }

    //    Проверяем на заполниность пораметров
    private boolean checkValid(Product product) {
        return product != null &&
                !StringUtils.isEmpty(product.getName()) &&
                product.getPrice() > 0;

    }


}