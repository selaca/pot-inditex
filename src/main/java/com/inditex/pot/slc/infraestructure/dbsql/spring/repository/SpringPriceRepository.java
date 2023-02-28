package com.inditex.pot.slc.infraestructure.dbsql.spring.repository;

import com.inditex.pot.slc.infraestructure.dbsql.spring.entities.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface SpringPriceRepository extends CrudRepository<PriceEntity, Long> {

    @Query(
        value = "SELECT * " +
                "FROM PRICES P " +
                "WHERE P.PRODUCT_ID = ?2 AND " +
                        "P.BRAND_ID = ?3 AND " +
                        "?1 BETWEEN P.START_DATE AND P.END_DATE AND " +
                        "P.PRIORITY = " +
                            "(SELECT MAX(PI.PRIORITY) FROM PRICES PI WHERE PI.PRODUCT_ID = ?2 AND PI.BRAND_ID = ?3 AND ?1 BETWEEN PI.START_DATE AND PI.END_DATE)",
        nativeQuery = true)
    PriceEntity findPriceByDate(
            LocalDateTime date,
            int productId,
            int brandId);
}
