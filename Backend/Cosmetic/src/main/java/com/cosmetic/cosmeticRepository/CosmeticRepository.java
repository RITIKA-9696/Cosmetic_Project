package com.cosmetic.cosmeticRepository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cosmetic.cosmeticModel.CosmeticUser;

@Repository
public interface CosmeticRepository extends JpaRepository<CosmeticUser, Long> {
	
	public Optional<CosmeticUser> findByUsernameAndPassword(String username, String password); 

}


