package com.cosmetic.cosmeticRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cosmetic.cosmeticModel.CosmeticProductList;
@Repository
public interface ProductRepository extends JpaRepository<CosmeticProductList, Long> {
	
	

}
