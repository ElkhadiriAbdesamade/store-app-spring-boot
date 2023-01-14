package com.gestion.service.api.dataaccess.facture.dao;

import com.gestion.service.api.dataaccess.entities.Facture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

public interface FactureDAO extends JpaRepository<Facture, BigDecimal> {
    @Transactional
    @Modifying
    @Query("""
            update Facture f set f.user_id = ?1, f.product_id = ?2, f.user_fullName = ?3, f.product_name = ?4, f.product_qte = ?5, f.total_price = ?6
            where f.id = ?7""")
    int updateFacture(int user_id, int product_id, String user_fullName, String product_name, int product_qte, float total_price, int id);
    @Transactional
    @Modifying
    @Query("delete from Facture f where f.id = ?1")
    int deleteFactureById(int id);

    @Query(value = "SELECT * FROM factures",nativeQuery = true)
    List<Facture> getAllFactures();

    @Query(value = "SELECT * FROM factures f where f.user_id = :id",nativeQuery = true)
    List<Facture> getFacturesByUserId(@Param("id") BigDecimal id);

    @Query(value = "SELECT * FROM factures f WHERE f.id = :id",nativeQuery = true)
    Facture getFactureById(@Param("id") BigDecimal id);
}
