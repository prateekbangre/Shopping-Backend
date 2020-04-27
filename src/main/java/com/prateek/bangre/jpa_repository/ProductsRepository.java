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

    @Query(value="SELECT p.id, p.title, p.image, p.images, p.description, p.price, p.quantity, c.title as categoriesName FROM Products p JOIN Categories c order by p.id", nativeQuery = true)
    public  List<ProductsJoin> getProductsWithCategoriesTitle();
}
