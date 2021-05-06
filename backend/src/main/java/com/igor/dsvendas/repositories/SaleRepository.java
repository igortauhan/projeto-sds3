package com.igor.dsvendas.repositories;

import com.igor.dsvendas.entities.Sale;
import com.igor.dsvendas.entities.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {

}
