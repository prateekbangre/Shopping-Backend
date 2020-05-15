package com.prateek.bangre.jpa_repository;


import com.prateek.bangre.model.Products;
import com.prateek.bangre.model.ProductsJoin;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * @author prateek.bangre on 26/04/20.
 * @Project Shoping-Backend
 */
@Repository("productRepository")
public interface ProductsRepository extends CrudRepository<Products, Integer> {
    List<Products> findAllBycatId(int cat_id);

    @Query(value="SELECT p.id, p.title as name, p.image, p.images, p.description, p.price, p.quantity, (select c.title from shopping_db.categories as c where p.cat_id = c.id) as category FROM Products p", nativeQuery = true)
    public  List<ProductsJoin> getProductsWithCategoriesTitle();

    @Query(value="SELECT p.id, p.title, p.image, p.images, p.description, p.price, p.quantity, c.title as categoriesName FROM Products p JOIN Categories c where p.id=?1", nativeQuery = true)
    List<ProductsJoin> getProductsWithCategoriesTitleById(int id);

    @Query(value="SELECT p.id, p.title, p.image, p.images, p.description, p.price, p.quantity, c.title as categoriesName FROM Products p JOIN Categories c where c.title like (?1)", nativeQuery = true)
    List<ProductsJoin> getProductsWithCategoriesTitleByCategoryName(String categoryName);
}
