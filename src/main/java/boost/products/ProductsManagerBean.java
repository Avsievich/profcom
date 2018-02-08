package boost.products;


import boost.products.domain.ProductEntity;
import org.apache.commons.lang3.StringUtils;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.Collections;
import java.util.List;


// работа с сущностью productEntity


@LocalBean
@Stateless
public class ProductsManagerBean {

    @PersistenceContext(unitName="examplePU")
    private EntityManager entityManager;


    //CRUD

    // Добавляем обьект в БД
    public boolean create(ProductEntity productEntity) {
        // проверяем все ли поля заполнены
        if (checkValid(productEntity)) {
            // проверяем на существование обьекта
            ProductEntity existingProduct = entityManager.find(ProductEntity.class, productEntity.getId());
            if (existingProduct != null) {
                return false;
            }
            // добавляем оьект в базу данных
            entityManager.persist(productEntity);
            return true;

        }
        return false;

    }

    // Получение обьектов из БД
    public ProductEntity read(long id) {

        // выбераем данные по id
        return entityManager.find(ProductEntity.class, id);
    }

    // Получение обьектов из БД списком
    public List<ProductEntity> readList(int offset, int limit) {
        if (offset < 0 || limit < 1) {
            return null;
        }
        TypedQuery<ProductEntity> query = entityManager.createQuery(
                "SELECT entity from ProductEntity entity"
                , ProductEntity.class);
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        return query.getResultList();
    }

    //  Обнавляем обьект в базе данных
    public boolean update(ProductEntity productEntity) {
        // проверяем все ли поля заполнены
        if (checkValid(productEntity)) {
            return false;
        }
        // проверяем на существование обьекта
        ProductEntity existingProduct = entityManager.find(ProductEntity.class, productEntity.getId());
        if (existingProduct == null) {
            return false;
        }
        //  обнавляем обьект в базе данных
        entityManager.merge(productEntity);
        return true;

    }

    //Удаляем обьекты из базы данных
    public boolean delete(long id) {
        // проверяем на существование обьекта
        ProductEntity existingEntity = entityManager.find(ProductEntity.class, id);
        if (existingEntity != null) {
            return false;
        }
        //  удаляем обьект в базе данных
        entityManager.remove(existingEntity);
        return true;
    }

    //    Проверяем на заполниность пораметров
    private boolean checkValid(ProductEntity productEntity) {
        return productEntity != null &&
                !StringUtils.isEmpty(productEntity.getName()) &&
                productEntity.getPrice() > 0;

    }


}