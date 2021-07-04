package com.roze.repository;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.roze.domain.ProductService;
import com.roze.enumeration.PurchaseStatus;
import com.roze.enumeration.SaleStatus;

@Repository
public interface ProductServiceRepository extends CrudRepository<ProductService, Long>{

	List<ProductService> findBySaleStatusAndPurchaseStatus(SaleStatus saleStatus, PurchaseStatus purchaseStatus);

	int countBySaleStatusAndPurchaseStatus(SaleStatus saleStatus, PurchaseStatus purchaseStatus);

	List<ProductService> findBySaleStatus(SaleStatus saleStatus);

}
