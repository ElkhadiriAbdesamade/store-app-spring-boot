package com.gestion.service.api.dataaccess.product.dao;

import com.gestion.service.api.dataaccess.entities.Product;
import com.gestion.service.api.dataaccess.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

public interface ProductDAO extends JpaRepository<Product, BigDecimal> {
    @Transactional
    @Modifying
    @Query("delete from Product p where p.id = ?1")
    void deleteProductById(int id);

    @Query(value = "SELECT * FROM products",nativeQuery = true)
    List<Product> getAllProducts();


    @Query(value = "SELECT * FROM products p where p.name = :productName",nativeQuery = true)
    List<Product> searchProducts(@Param("productName") String productName);
    @Query(value = "SELECT * FROM products p WHERE p.id = :id",nativeQuery = true)
    Product getProductById(@Param("id") BigDecimal id);

    @Transactional
    @Modifying
    @Query("""
            update Product p set p.name = ?1, p.description = ?2, p.qte_stock = ?3, p.sale = ?4, p.sale_amount = ?5, p.price = ?6, p.image = ?7
            where p.id = ?8""")
    int updateProductById(String name, String description, int qte_stock, int sale, float sale_amount, float price, String image, int id);




}
