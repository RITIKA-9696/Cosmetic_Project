package com.cosmetic.cosmeticService;

import java.util.Optional;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cosmetic.cosmeticModel.CosmeticProductList;
import com.cosmetic.cosmeticModel.CosmeticUser;
import com.cosmetic.cosmeticRepository.CosmeticRepository;
import com.cosmetic.cosmeticRepository.ProductRepository;

@Service
public class CosmeticService {
	
	@Autowired
	CosmeticRepository cosmeticRepository;
	
	@Autowired
	ProductRepository productRepository;
	
	public CosmeticUser saveUserInfo(String name, String mobile, String email, String username, String password) {
		
		CosmeticUser info = new CosmeticUser();
		
		info.setName(name);
		info.setEmail(mobile);
		info.setMobile(email);
		info.setUsername(username);
		info.setPassword(password);
		
		return cosmeticRepository.save(info);
		
	}
	
	public CosmeticProductList saveProducts(String usernsame,String productname, String price) {
		
		CosmeticProductList productInfo = new CosmeticProductList();
		
		productInfo.setUsername(usernsame);
		productInfo.setProductname(productname);
		productInfo.setPrice(price);
		
		return productRepository.save(productInfo);
		
		
		
		
	}
	
	public Optional<CosmeticUser> getUserByUsernameAndPassword(String username, String password) {
        return cosmeticRepository.findByUsernameAndPassword(username, password);
    }
	
	
	
	
	
	


}
